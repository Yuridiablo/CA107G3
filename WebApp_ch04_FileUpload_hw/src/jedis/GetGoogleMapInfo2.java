package jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import redis.clients.jedis.Jedis;

public class GetGoogleMapInfo2 {

//	public static final String MY_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=24.967742,121.1895113&radius=10000&type=restaurant&language=zh-tw&key=AIzaSyBYZhprf58VI160spKuA98fVS9AcSeVuVg";
	public static final String MY_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=24.67742,121.105113&radius=10000&type=restaurant&language=zh-tw&key=AIzaSyBYZhprf58VI160spKuA98fVS9AcSeVuVg";

	public static void main(String[] args) throws IOException, JSONException {
		StringBuilder sb = new StringBuilder();
		URL url = new URL(MY_URL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setConnectTimeout(10000);
		con.setUseCaches(false);
		
		InputStream is = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String str;
		while((str = br.readLine()) != null) {
			sb.append(str);
		}		
		
		br.close();
		isr.close();
		is.close();
		con.disconnect();
		
		System.out.println("===以下JSON===");
		
		JSONObject jObj = new JSONObject(sb.toString());
		JSONArray jArray = jObj.getJSONArray("results");
		
		for (int i = 0 ; i < jArray.length(); i++) {
			String keys = "rest:";
			JSONObject data = jArray.getJSONObject(i);  
			String v_name = data.getString("name");
			List<String> lll = new ArrayList<>();
			Map<String, List<String>> map = new HashMap<>();
			
			JSONObject jObj2 = data.getJSONObject("geometry");
			JSONObject jObj3 = jObj2.getJSONObject("location");
			Double lat = jObj3.getDouble("lat");
			Double lng = jObj3.getDouble("lng");
			JSONObject jObjHour = data.getJSONObject("opening_hours");
			Boolean open = jObjHour.getBoolean("open_now");
//			Integer zip = data.getInt("user_ratings_total");
			String add = data.getString("vicinity");
			String id = data.getString("id");
			
			Double rating = data.getDouble("rating");			
			System.out.println("店名：" + v_name);
			System.out.println("經度：" + lat);
			System.out.println("緯度：" + lng);
			System.out.println("分數：" + rating);
			System.out.println("狀態：" + ( open ? "營業中" : "休息中"));
			System.out.println("地址：" + add);
			System.out.println("-------------");
			
			lll.add(lat.toString());
			lll.add(lng.toString());
			lll.add(rating.toString());
			lll.add(add);
			
			map.put(v_name, lll);
			
			Jedis jed = new Jedis("localhost", 6379);
			jed.auth("123456");
//			jed.flushDB();
			jed.hset("v_name", id, v_name);
			jed.hset("v_add", id, add);
			jed.hset("v_score", id, rating.toString());
			jed.hset("v_lat", id, lat.toString());
			jed.hset("v_lng", id, lng.toString());
//			jed.set("v_name", v_name);
			
			
			System.out.println(jed.hset("v_add", id, add));
			
			System.out.println(jed.hgetAll("rest:5"));
			jed.close();
			
		}
		
		
		
	}

}
