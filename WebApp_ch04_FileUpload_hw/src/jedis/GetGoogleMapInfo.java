package jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import redis.clients.jedis.Jedis;

public class GetGoogleMapInfo {

	public static final String MY_URL = "https://maps.googleapis" + ".com/maps/api/place/nearbysearch/json?location=24."
			+ "95375,121.22575&radius=1000&types=food&name=吃到飽&la"
			+ "nguage=zh-TW&key=AIzaSyAYmC8oUYc9DGAZn8hqZKakFeclhAbTRSI";

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
			String name = data.getString("name");
			
			JSONObject jObj2 = data.getJSONObject("geometry");
			JSONObject jObj3 = jObj2.getJSONObject("location");
			Double lat = jObj3.getDouble("lat");
			Double lng = jObj3.getDouble("lng");
			JSONObject jObjHour = data.getJSONObject("opening_hours");
			Boolean open = jObjHour.getBoolean("open_now");
//			Integer zip = data.getInt("user_ratings_total");
			String add = data.getString("vicinity");
			
			Double rating = data.getDouble("rating");			
			System.out.println("店名：" + name);
			System.out.println("經度：" + lat);
			System.out.println("緯度：" + lng);
			System.out.println("分數：" + rating);
			System.out.println("狀態：" + ( open ? "營業中" : "休息中"));
			System.out.println("地址：" + add);
			System.out.println("-------------");
			
			Jedis jed = new Jedis("localhost", 6379);
			jed.auth("123456");
//			jed.flushDB();
			jed.hset(keys + i, "name", name);
			jed.hset(keys + i, "lat", lat.toString());
			jed.hset(keys + i, "lng", lng.toString());
			jed.hset(keys + i, "rating", rating.toString());
			jed.hset(keys + i, "add", add);
			
			System.out.println(jed.hget("rest:6", "add"));
			
			System.out.println(jed.hgetAll("rest:5"));
			jed.close();
			
		}
		
		
		
	}

}
