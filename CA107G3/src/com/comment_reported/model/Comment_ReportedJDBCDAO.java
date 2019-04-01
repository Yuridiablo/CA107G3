package com.comment_reported.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Comment_ReportedJDBCDAO implements Comment_ReportedDAO_interface {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "CA107G3";
	String passwd = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO COMMENT_REPORTED (rep_no,cmnt_no,mem_no,rep_for,rep_time,rep_stat) VALUES ('CR'||LPAD(to_char(COMMENT_REPORTED_SEQ.NEXTVAL), 8, '0'),?,?,?,?,?)";	

	@Override
	public void insert(Comment_ReportedVO Comment_ReportedVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
//			pstmt.setString(1, Comment_ReportedVO.getRep_no());
			pstmt.setString(1, Comment_ReportedVO.getCmnt_no());
			pstmt.setString(2, Comment_ReportedVO.getMem_no());
			pstmt.setString(3, Comment_ReportedVO.getRep_for());
			pstmt.setTimestamp(4, Comment_ReportedVO.getRep_time());
			pstmt.setInt(5, Comment_ReportedVO.getRep_stat());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException se) {
			
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Comment_ReportedVO Comment_ReportedVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Comment_ReportedVO Comment_ReportedVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Comment_ReportedVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		Comment_ReportedJDBCDAO dao = new Comment_ReportedJDBCDAO();
		
		//新增
		Comment_ReportedVO comRepVO01 = new Comment_ReportedVO();
		comRepVO01.setCmnt_no("C000001");
		comRepVO01.setMem_no("M000001");
		comRepVO01.setRep_for("消費10元也算一篇？這店家派來的工讀生吧，啊我去吃怎麼沒有送龍蝦、送鮑魚，超唬爛");
		comRepVO01.setRep_time(new Timestamp(new java.util.Date().getTime()));
		comRepVO01.setRep_stat(1);
		
		dao.insert(comRepVO01);
		
	}

}
