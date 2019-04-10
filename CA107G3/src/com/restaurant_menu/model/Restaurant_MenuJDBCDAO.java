package com.restaurant_menu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.comment_reported.model.Comment_ReportedVO;
import com.member_wallet_list.model.Member_Wallet_ListVO;

public class Restaurant_MenuJDBCDAO implements Restaurant_MenuDAO_interface {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "CA107G3";
	String passwd = "123456";
	
	private static final String INSERT_STMT = 		
			"INSERT INTO RESTAURANT_MENU (MENU_NO,VENDOR_NO,MENU_NAME,MENU_PRICE,MENU_PIC,MENU_STAT,MENU_TEXT) VALUES ('RM'||LPAD(to_char(RESTAURANT_MENU_SEQ.NEXTVAL), 8, '0'),?,?,?,?,?,?)";	
	private static final String UPDATE_STMT =
			"UPDATE RESTAURANT_MENU set menu_stat=? where menu_no = ?";
	private static final String DELETE = 
			"DELETE FROM RESTAURANT_MENU where menu_no = ?";
	private static final String GET_ONE_STMT = 
			"SELECT * FROM RESTAURANT_MENU where menu_no = ?";
	private static final String GET_ALL_STMT = 
			"SELECT * FROM RESTAURANT_MENU order by menu_no";
	
	@Override
	public void insert(Restaurant_MenuVO Restaurant_MenuVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, Restaurant_MenuVO.getVendor_no());
			pstmt.setString(2, Restaurant_MenuVO.getMenu_name());
			pstmt.setString(3, Restaurant_MenuVO.getMenu_price());
			pstmt.setBytes(4, Restaurant_MenuVO.getMenu_pic());
			pstmt.setInt(5, Restaurant_MenuVO.getMenu_stat());
			pstmt.setString(6, Restaurant_MenuVO.getMenu_text());
			
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
	public void update(Restaurant_MenuVO Restaurant_MenuVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);
			

			pstmt.setInt(1, Restaurant_MenuVO.getMenu_stat());
			pstmt.setString(2,Restaurant_MenuVO.getMenu_no());
			
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
	public void delete(String menu_no) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, menu_no);
			
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
	public Restaurant_MenuVO findByPK(String menu_no) {
		Comment_ReportedVO crVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Restaurant_MenuVO rm = null;
		
		try {

			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, menu_no);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				rm = new Restaurant_MenuVO();
				rm.setMenu_no(rs.getString("menu_no"));
				rm.setVendor_no(rs.getString("vendor_no"));
				rm.setMenu_name(rs.getString("menu_name"));
				rm.setMenu_price(rs.getString("menu_price"));
				rm.setMenu_pic(rs.getBytes("menu_pic"));
				rm.setMenu_stat(rs.getInt("menu_stat"));
				rm.setMenu_text(rs.getString("menu_text"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return rm;
	}

	@Override
	public List<Restaurant_MenuVO> getAll() {
		// TODO Auto-generated method stub
		List<Restaurant_MenuVO> list = new ArrayList<Restaurant_MenuVO>();
		Restaurant_MenuVO rm = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rm = new Restaurant_MenuVO();
				rm.setMenu_no(rs.getString("menu_no"));
				rm.setVendor_no(rs.getString("vendor_no"));
				rm.setMenu_name(rs.getString("menu_name"));
				rm.setMenu_price(rs.getString("menu_price"));
				rm.setMenu_pic(rs.getBytes("menu_pic"));
				rm.setMenu_stat(rs.getInt("menu_stat"));
				rm.setMenu_text(rs.getString("menu_text"));
				list.add(rm);
				
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
		Restaurant_MenuJDBCDAO dao = new Restaurant_MenuJDBCDAO();	
		
		//新增
		Restaurant_MenuVO rm = new Restaurant_MenuVO();
		
		rm.setVendor_no("V000003");
		rm.setMenu_name("宇宙大燒賣");
		rm.setMenu_price("2050");
 		rm.setMenu_pic(null);
 		rm.setMenu_stat(1);		
 		rm.setMenu_text("居然包了一整頭豬在裡面啊");		
 		
		dao.insert(rm);		
		
		//修改
		Restaurant_MenuVO rm2 = new Restaurant_MenuVO();
		rm2.setMenu_stat(2);
		rm2.setMenu_no("RM00000004");
		dao.update(rm2);
		
		//刪除
//		dao.delete("RM00000011");
		
		//查單筆
		Restaurant_MenuVO rmVO1 = dao.findByPK("RM00000001");
		System.out.println(rmVO1.getMenu_no());
		System.out.println(rmVO1.getVendor_no());
		System.out.println(rmVO1.getMenu_name());
		System.out.println(rmVO1.getMenu_price());			
		System.out.println(rmVO1.getMenu_pic());
		System.out.println(rmVO1.getMenu_stat());
		System.out.println(rmVO1.getMenu_text());
		System.out.println("---------------------");
		
		//查全部
		List<Restaurant_MenuVO> list = dao.getAll();
		for (Restaurant_MenuVO rmVO : list) {
			System.out.println(rmVO.getMenu_no());
			System.out.println(rmVO.getVendor_no());
			System.out.println(rmVO.getMenu_name());
			System.out.println(rmVO.getMenu_price());			
			System.out.println(rmVO.getMenu_pic());
			System.out.println(rmVO.getMenu_stat());
			System.out.println(rmVO.getMenu_text());
			System.out.println("--------");
		}
	}
	
	

}
