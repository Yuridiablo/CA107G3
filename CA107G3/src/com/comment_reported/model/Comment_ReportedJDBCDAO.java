package com.comment_reported.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Comment_ReportedJDBCDAO implements Comment_ReportedDAO_interface {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "CA107G3";
	String passwd = "123456";
	
	private static final String INSERT_STMT = 
			"INSERT INTO COMMENT_REPORTED (rep_no,cmnt_no,mem_no,rep_for,rep_time,rep_stat) VALUES ('CR'||LPAD(to_char(COMMENT_REPORTED_SEQ.NEXTVAL), 8, '0'),?,?,?,CURRENT_TIMESTAMP,?)";	
	private static final String UPDATE_STMT =
			"UPDATE COMMENT_REPORTED set rep_stat=? where rep_no = ?";
	private static final String DELETE = 
			"DELETE FROM COMMENT_REPORTED where rep_no = ?";
	private static final String GET_ALL_STMT = 
			"SELECT rep_no,cmnt_no,mem_no,rep_for,rep_time,rep_stat FROM COMMENT_REPORTED order by rep_no";

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
//			pstmt.setTimestamp(4, Comment_ReportedVO.getRep_time());
			pstmt.setInt(4, Comment_ReportedVO.getRep_stat());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
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
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);
			

			pstmt.setInt(1, Comment_ReportedVO.getRep_stat());
			pstmt.setString(2,Comment_ReportedVO.getRep_no());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
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
	public void delete(String rep_no) {
	
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, rep_no);
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
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
	public List<Comment_ReportedVO> getAll() {
		List<Comment_ReportedVO> list = new ArrayList<Comment_ReportedVO>();
		Comment_ReportedVO comRepVO03 = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				comRepVO03 = new Comment_ReportedVO();
				comRepVO03.setRep_no(rs.getString("rep_no"));
				comRepVO03.setCmnt_no(rs.getString("cmnt_no"));
				comRepVO03.setMem_no(rs.getString("mem_no"));
				comRepVO03.setRep_for(rs.getString("rep_for"));
				comRepVO03.setRep_time(rs.getTimestamp("rep_time"));
				comRepVO03.setRep_stat(rs.getInt("rep_stat"));
				list.add(comRepVO03);
				
			}
		} catch (ClassNotFoundException e) {
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
		
		return list;
	}

	public static void main(String[] args) {
		Comment_ReportedJDBCDAO dao = new Comment_ReportedJDBCDAO();	
		
		//新增
		Comment_ReportedVO comRepVO01 = new Comment_ReportedVO();
		
		comRepVO01.setCmnt_no("C000001");
		comRepVO01.setMem_no("M000001");
		comRepVO01.setRep_for("這篇是來亂的吧?為什麼會貼別家店的東西？美式餐廳有賣小籠包喔?");
//		comRepVO01.setRep_time(new Timestamp(new Date().getTime()));
		comRepVO01.setRep_stat(1);		
		dao.insert(comRepVO01);
		
		//修改
		Comment_ReportedVO comRepVO02 = new Comment_ReportedVO();
		comRepVO02.setRep_stat(3);
		comRepVO02.setRep_no("CR00000004");
		dao.update(comRepVO02);
		
		//刪除
//		dao.delete("CR00000004");
		
		//查全部
		List<Comment_ReportedVO> list = dao.getAll();
		for (Comment_ReportedVO comRep : list) {
			System.out.println(comRep.getRep_no());
			System.out.println(comRep.getCmnt_no());
			System.out.println(comRep.getMem_no());
			System.out.println(comRep.getRep_for());
			System.out.println(comRep.getCmnt_no());
			System.out.println(comRep.getRep_stat());
			System.out.println("--------");
		}
	}

}