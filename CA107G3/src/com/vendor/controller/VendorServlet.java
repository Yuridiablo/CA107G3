package com.vendor.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.restaurant_menu.model.Restaurant_MenuService;
import com.restaurant_menu.model.Restaurant_MenuVO;
import com.vendor.model.*;

//@WebServlet("/VendorServlet")
@MultipartConfig
public class VendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VendorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// 登入
		if ("login".equals(action)) {

		}
		System.out.println("----WW!---");
		//註冊
		if ("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

				String v_name = req.getParameter("v_name");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("員工姓名: 請勿空白");
//				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }

				String v_account = req.getParameter("v_account").trim();
				if (v_account == null || v_account.trim().length() == 0) {
					errorMsgs.add("帳號請勿空白");
				}

//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}

				String v_pwd = req.getParameter("v_pwd").trim();
				String v_mail = req.getParameter("v_mail").trim();
				String v_n_code = req.getParameter("v_n_code").trim();
				String v_tel = req.getParameter("v_tel").trim();
				String v_ad_code = req.getParameter("v_ad_code").trim();
				String v_address1 = req.getParameter("v_address1").trim();
				String v_address2 = req.getParameter("v_address2").trim();
				String v_address3 = req.getParameter("v_address3").trim();

			

//				Double comm = null;
//				try {
//					comm = new Double(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}

				VendorVO vVO = new VendorVO();

				// 上傳圖片
				byte[] v_pic = null;
				Collection<Part> pps = req.getParts();
				for (Part part : pps) {
					if (part.getName().equals("v_pic")) {
						if (part.getSize() != 0) {

							InputStream in = part.getInputStream();
							ByteArrayOutputStream output = new ByteArrayOutputStream();
							v_pic = new byte[in.available()];
							for (int length = 0; (length = in.read(v_pic)) > 0;)
								output.write(v_pic, 0, length);
						} else {
							errorMsgs.add("圖片請勿空白");

						}
					}
				}

				vVO.setV_name(v_name);
				vVO.setV_account(v_account);
				vVO.setV_pwd(v_pwd);
				vVO.setV_mail(v_mail);
				vVO.setV_n_code(v_n_code);
				vVO.setV_tel(v_tel);
				vVO.setV_ad_code(v_ad_code);
				vVO.setV_address1(v_address1);
				vVO.setV_address2(v_address2);
				vVO.setV_address3(v_address3);
				vVO.setV_pic(v_pic);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("vVO", vVO); // 含有輸入格式錯誤的VO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/Restaurant_Menu/addMenu.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/

				VendorService vSvc = new VendorService();
				vVO = vSvc.addV(v_account, v_pwd, v_mail, v_tel, v_n_code, v_ad_code, v_address1, v_address2, v_address3, v_name, v_pic);
//				List<Restaurant_MenuVO> vlist = rmSvc.getVendor(vendor_no);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("vVO", vVO); // 資料庫update成功後,正確的的VO物件,存入req
//				req.setAttribute("vlist", vlist);
				String url = "/Vendor/listAll.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listChoosed.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/Vendor/listAll.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		
	}

}
