package pk1;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class tryInsert
 */
@WebServlet("/tryInsert")
public class TryInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	
    public TryInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		res.getWriter().append("Served at: ").append(req.getContextPath());
		PrintWriter out = res.getWriter();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(stmt.execute("SELECT * FROM VENDOR")) {
				ResultSet rs = stmt.getResultSet();
//				ResultSetMetaData rsmd = rs.getMetaData();
//				int numcols = rsmd.getColumnCount();
				while(rs.next()) {
					System.out.println(rs);
//					out.println(rs.toString());
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
//		out.println(new HtmlSQLResult("SELECT * FORM VENDOR",con));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void init() {
		
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
			con = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
