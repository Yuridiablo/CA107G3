package com.restaurant_transaction_list.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/RES_Transaction_ListServlet")
public class RES_Transaction_ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RES_Transaction_ListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession se = req.getSession();
		
		
		
		

		
		if ("logout".equals(action)) {
							
			try {
				/*************************** 1.接收請求參數 ****************************************/
				
				se.invalidate();
				
	
				/*************************** 2.開始查詢資料 ****************************************/
		
				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				String url = req.getContextPath() + "/Vendor/V_frontPage.jsp";
				res.sendRedirect(url);
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//				successView.forward(req, res);
	
				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		}
	}
}
