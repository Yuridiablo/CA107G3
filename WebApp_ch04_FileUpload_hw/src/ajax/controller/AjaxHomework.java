package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class AjaxHomework extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxHomework() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		String question = req.getParameter("question");
		JSONObject obj = new JSONObject();
		System.out.println(req.getParameter("action"));
		if("ask".equals(action)){
			if(question.length() % 2 == 0){
				obj.accumulate("answer", "yes");
			} else {
				obj.accumulate("answer", "no");
			}
		}
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		
		PrintWriter out = res.getWriter();
		out.write(obj.toString());
		out.flush();
		out.close();
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
