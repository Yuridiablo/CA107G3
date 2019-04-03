package com.member_wallet_list.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Member_Wallet_listJDBCDAO implements Member_Wallet_listDAO_interface {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "CA107G3";
	String passwd = "123456";
	
	private static final String INSERT_STMT = 
//			('MWL'||LPAD(to_char(MEMBER_WALLET_LIST_SEQ.NEXTVAL), 7, '0'),'M000001',sysdate,'5566',1,null,'20190330-000001'
			"INSERT INTO Member_Wallet_list (list_no,mem_no,list_time,list_wit,list_stat,list_dep,pay_for) VALUES ('MWL'||LPAD(to_char(MEMBER_WALLET_LIST_SEQ.NEXTVAL), 7, '0'),?,sysdate,?,?,?,?)";	
	private static final String UPDATE_STMT =
			"UPDATE Member_Wallet_list set list_wit=? where list_no = ?";
	private static final String DELETE = 
			"DELETE FROM Member_Wallet_list where list_no = ?";
	private static final String GET_ALL_STMT = 
			"SELECT * FROM Member_Wallet_list order by list_no";

	@Override
	public void insert(Member_Wallet_listVO Member_Wallet_listVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, Member_Wallet_listVO.getMem_no());
			pstmt.setString(2, Member_Wallet_listVO.getList_wit());
			pstmt.setInt(3, Member_Wallet_listVO.getList_stat());
			pstmt.setString(4, Member_Wallet_listVO.getList_dep());
			pstmt.setString(5, Member_Wallet_listVO.getPay_for());
//			pstmt.setInt(4, Comment_ReportedVO.getRep_stat());
			
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
	public void update(Member_Wallet_listVO Member_Wallet_listVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);
			

			pstmt.setString(1, Member_Wallet_listVO.getList_wit());
			pstmt.setString(2,Member_Wallet_listVO.getList_no());
			
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
	public void delete(String list_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setString(1, list_no);
			
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
	public List<Member_Wallet_listVO> getAll() {
		// TODO Auto-generated method stub
		List<Member_Wallet_listVO> list = new ArrayList<Member_Wallet_listVO>();
		Member_Wallet_listVO mwl = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mwl = new Member_Wallet_listVO();
				mwl.setList_no(rs.getString("list_no"));
				mwl.setMem_no(rs.getString("mem_no"));
				mwl.setList_time(rs.getDate("list_time"));
				mwl.setList_wit(rs.getString("list_wit"));
				mwl.setList_stat(rs.getInt("list_stat"));
				mwl.setList_dep(rs.getString("list_dep"));
				mwl.setPay_for(rs.getString("pay_for"));
				list.add(mwl);
				
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
		Member_Wallet_listJDBCDAO dao = new Member_Wallet_listJDBCDAO();	
		
		//新增
		Member_Wallet_listVO mwl = new Member_Wallet_listVO();
		
		mwl.setMem_no("M000001");
		mwl.setList_wit("7788");
		mwl.setList_stat(1);
 		mwl.setList_dep(null);
		mwl.setPay_for("20190330-000003");		
		dao.insert(mwl);		
		
		//修改
		Member_Wallet_listVO mwl2 = new Member_Wallet_listVO();
		mwl2.setList_wit("8000");
		mwl2.setList_no("MWL0000002");
		dao.update(mwl2);
		
		//刪除
//		dao.delete("MWL0000004");
		
		//查全部
		List<Member_Wallet_listVO> list = dao.getAll();
		for (Member_Wallet_listVO mwlVO : list) {
			System.out.println(mwlVO.getList_no());
			System.out.println(mwlVO.getMem_no());
			System.out.println(mwlVO.getList_time());
			System.out.println(mwlVO.getList_wit());			
			System.out.println(mwlVO.getList_stat());
			System.out.println(mwlVO.getList_dep());
			System.out.println(mwlVO.getPay_for());
			System.out.println("--------");
		}
	}
	
}
