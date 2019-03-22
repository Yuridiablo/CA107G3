import java.io.*;
import java.util.Collection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;

@WebServlet("/uploadServlet3_simple.do")
@MultipartConfig

public class UploadTest_Servlet3_Simple extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("Big5");
		res.setContentType("text/html; charset=Big5");

		String del = req.getParameter("del");
		PrintWriter out = res.getWriter();
		System.out.println(del);
		
		if (del!=null && del.equals("刪除")) {
			
			String[] box = req.getParameterValues("pic");				
			
			int i = 0;
			while (box != null && i < box.length) {
				String loc = (String)(req.getServletContext().getRealPath("/images_uploaded/") + box[i]);
				File p1 = new File(loc);
				p1.delete();
//				System.out.println("刪除了" + loc);
				i++;
			}										
			
			File ff = new File(req.getServletContext().getRealPath("/images_uploaded/"));
			String[] locFile = ff.list();
			if (locFile.length > 0) {
				out.println("<FORM action=\"uploadServlet3_simple.do\" method=post>");
				for (String xx : locFile) {
				out.println("<img src=\"" + req.getContextPath() + "/images_uploaded/" + xx + "\">");
				out.println("<br><input type=\"checkbox\" name=\"pic\" value=\""+ xx +"\"><br>");
				System.out.println(xx);
				}
				out.println("<input type=\"submit\" name=\"del\" value=\"刪除\">");
				out.println("</FORM>");
			} else {
				out.println("資料夾內已無檔案");
				out.println("<br><a href=\"Upload_Simple.html\">重新上傳</a>");
			}
						
		
//			out.println("has deleted 已經刪除");
			
			return;
		} else {							
		
		File locSave = new File(req.getServletContext().getRealPath("/images_uploaded/"));
		if (!locSave.exists()) {
			locSave.mkdirs();
		}
			
		Collection<Part> pps = req.getParts();
		out.println("<FORM action=\"uploadServlet3_simple.do\" method=post>");
		
			for (Part part : pps) {
				if (part.getSize() > 0) {
				part.write(getServletContext().getRealPath("/images_uploaded/")+part.getSubmittedFileName());
				out.println("<img src=\"" + req.getContextPath() + "/images_uploaded/" + part.getSubmittedFileName() + "\">");
				out.println("<br><input type=\"checkbox\" name=\"pic\" value=\""+ part.getSubmittedFileName() +"\"><br>");

				}						
			}			
			out.println("<input type=\"submit\" name=\"del\" value=\"刪除\">");
			out.println("<br><a href=\"Upload_Simple.html\">重新上傳</a>");
			out.println("</FORM>");

		}
		
//		out.println("<img src=\"" + req.getContextPath() + "/images_uploaded/" + part.getSubmittedFileName());
	
		
//		Part p1 = req.getPart("upfile1");		
//		p1.write(getServletContext().getRealPath("/images_uploaded/")+p1.getSubmittedFileName());

	}
}