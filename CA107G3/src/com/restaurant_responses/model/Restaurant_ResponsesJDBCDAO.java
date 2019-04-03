package com.restaurant_responses.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Restaurant_ResponsesJDBCDAO implements Restaurant_ResponsesDAO_interface {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "CA107G3";
	String passwd = "123456";
	
	private static final String INSERT_STMT = 
//			('MWL'||LPAD(to_char(MEMBER_WALLET_LIST_SEQ.NEXTVAL), 7, '0'),'M000001',sysdate,'5566',1,null,'20190330-000001'
			"INSERT INTO Restaurant_Responses (res_no,cmnt_no,res_text,res_time) VALUES ('RR'||LPAD(to_char(RESTAURANT_RESPONSES_SEQ.NEXTVAL), 8, '0'),?,?,CURRENT_TIMESTAMP)";	
	private static final String UPDATE_STMT =
			"UPDATE Restaurant_Responses set res_text=? where res_no = ?";
	private static final String DELETE = 
			"DELETE FROM Restaurant_Responses where res_no = ?";
	private static final String GET_ALL_STMT = 
			"SELECT * FROM Restaurant_Responses order by res_no";
	
	@Override
	public void insert(Restaurant_ResponsesVO Restaurant_ResponsesVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, Restaurant_ResponsesVO.getCmnt_no());
			pstmt.setString(2, Restaurant_ResponsesVO.getRes_text());
			
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
	public void update(Restaurant_ResponsesVO Restaurant_ResponsesVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);
			

			pstmt.setString(1, Restaurant_ResponsesVO.getRes_text());
			pstmt.setString(2, Restaurant_ResponsesVO.getRes_no());
			
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
	public void delete(String res_no) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, res_no);
			
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
	public List<Restaurant_ResponsesVO> getAll() {
		// TODO Auto-generated method stub
		List<Restaurant_ResponsesVO> list = new ArrayList<Restaurant_ResponsesVO>();
		Restaurant_ResponsesVO rr = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rr = new Restaurant_ResponsesVO();
				rr.setRes_no(rs.getString("res_no"));
				rr.setCmnt_no(rs.getString("cmnt_no"));
				rr.setRes_text(rs.getString("res_text"));
				rr.setRes_time(rs.getDate("res_time"));
				
				list.add(rr);
				
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
		// TODO Auto-generated method stub
		Restaurant_ResponsesJDBCDAO dao = new Restaurant_ResponsesJDBCDAO();	
		
		//新增
		Restaurant_ResponsesVO rr = new Restaurant_ResponsesVO();
		
		rr.setCmnt_no("C000002");
		rr.setRes_text("阿不就好棒棒");
				
		dao.insert(rr);
		
		Restaurant_ResponsesVO rr2 = new Restaurant_ResponsesVO();
		rr2.setRes_no("RR00000003");
		rr2.setRes_text("年度回饋全面免費");
		dao.update(rr2);
		
		//刪除
//		dao.delete("RR00000002");
		
		//查全部
		List<Restaurant_ResponsesVO> list = dao.getAll();
		for (Restaurant_ResponsesVO rrVO : list) {
			System.out.println(rrVO.getRes_no());
			System.out.println(rrVO.getCmnt_no());
			System.out.println(rrVO.getRes_text());
			System.out.println(rrVO.getRes_time());			

			System.out.println("--------");
		}
	}

}
