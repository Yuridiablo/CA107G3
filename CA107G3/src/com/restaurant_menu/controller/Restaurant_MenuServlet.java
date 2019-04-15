package com.restaurant_menu.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant_menu.model.*;

@WebServlet("/Restaurant_Menu/Restaurant_Menu.do")

public class Restaurant_MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Restaurant_MenuServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				String menu_no = req.getParameter("menu_no");
				System.out.println(menu_no);
				
				/***************************2.開始查詢資料****************************************/
				Restaurant_MenuService rmSvc = new Restaurant_MenuService();
				Restaurant_MenuVO rmVO = rmSvc.findByPK(menu_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("rmVO", rmVO);         // 資料庫取出的empVO物件,存入req
				String url = "/Restaurant_Menu/update_menu_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Restaurant_Menu/listAllMenus.jsp");
				failureView.forward(req, res);
			}
		}	
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String menu_no = req.getParameter("menu_no");
				System.out.println(menu_no);
				
				String vendor_no = req.getParameter("vendor_no");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("員工姓名: 請勿空白");
//				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
				
				String menu_name = req.getParameter("menu_name").trim();
//				if (menu_name == null || menu_name.trim().length() == 0) {
//					errorMsgs.add("職位請勿空白");
//				}	
				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}

				String menu_price = req.getParameter("menu_price").trim();
//				try {
//					sal = new Double(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("薪水請填數字.");
//				}

//				Double comm = null;
//				try {
//					comm = new Double(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}
				byte[] menu_pic = null;
				Integer menu_stat = new Integer(req.getParameter("menu_stat").trim());
				String menu_text = req.getParameter("menu_text").trim();

				Restaurant_MenuVO rmVO = new Restaurant_MenuVO();
				rmVO.setMenu_no(menu_no);
				rmVO.setVendor_no(vendor_no);
				rmVO.setMenu_name(menu_name);
				rmVO.setMenu_price(menu_price);
				rmVO.setMenu_pic(menu_pic);
				rmVO.setMenu_stat(menu_stat);
				rmVO.setMenu_text(menu_text);

				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("Restaurant_MenuVO", Restaurant_MenuVO); // 含有輸入格式錯誤的empVO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //程式中斷
//				}
				
				/***************************2.開始修改資料*****************************************/
			
				Restaurant_MenuService rmSvc = new Restaurant_MenuService();
				rmVO = rmSvc.updateRM(menu_name, menu_price, menu_pic, menu_stat, menu_text, menu_no);
				List<Restaurant_MenuVO> vlist = rmSvc.getVendor(vendor_no);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("rmVO", rmVO); // 資料庫update成功後,正確的的empVO物件,存入req
				req.setAttribute("vlist", vlist);  
				String url = "/Restaurant_Menu/listChoosed.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Restaurant_Menu/update_menu_input.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_List".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				String vendor_no = req.getParameter("vendor_no");
				System.out.println(vendor_no);
				
				/***************************2.開始查詢資料****************************************/
				Restaurant_MenuService rmSvc = new Restaurant_MenuService();
				List<Restaurant_MenuVO> vlist = rmSvc.getVendor(vendor_no);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("vlist", vlist);         // 資料庫取出的empVO物件,存入req
				String url = "/Restaurant_Menu/listChoosed.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/Restaurant_Menu/listAllMenus.jsp");
				failureView.forward(req, res);
			}
		}	
		
	}

}
