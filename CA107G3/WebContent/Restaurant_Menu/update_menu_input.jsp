<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.restaurant_menu.model.*"%>
<%@page import="java.util.*"%>

<%
	Restaurant_MenuVO rmVO = (Restaurant_MenuVO)request.getAttribute("rmVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
	out.print(rmVO);
	List<Restaurant_MenuVO> vlist = (List<Restaurant_MenuVO>)request.getAttribute("vlist"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
	out.print(vlist);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table id="table-1">
	<tr><td>
		 <h3>菜單資料修改 - update_menu_input.jsp</h3>
		 <h4><a href="chooseVendor.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回列表</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<FORM METHOD="post" ACTION="Restaurant_Menu.do" name="form1">
<table>
	<tr>
		<td>品項編號:<font color=red><b>*</b></font></td>
		<td>${rmVO.menu_no}</td>
	</tr>
	<tr>
		<td>廠商編號:<font color=red><b>*</b></font></td>
		<td>${rmVO.vendor_no}</td>
	</tr>
<!-- 	<tr> -->
<!-- 		<td>廠商編號:</td> -->
<%-- 		<td><input type="TEXT" name="vendor_no" size="45" value="${rmVO.vendor_no}" /></td> --%>
<!-- 	</tr> -->
	<tr>
		<td>品名:</td>
		<td><input type="TEXT" name="menu_name" size="45"	value="${rmVO.menu_name}" /></td>
	</tr>
	<tr>
		<td>圖片:</td>
		<td><input name="menu_pic" id="f_date1" type="text" ></td>
	</tr>
	<tr>
		<td>價格:</td>
		<td><input type="TEXT" name="menu_price" size="45"	value="${rmVO.menu_price}" /></td>
	</tr>
	<tr>
		<td>狀態:</td>
		<td><input type="TEXT" name="menu_stat" size="45"	value="${rmVO.menu_stat}" /></td>
	</tr>
	<tr>
		<td>說明:</td>
		<td><input type="TEXT" name="menu_text" size="45"	value="${rmVO.menu_text}" /></td>
	</tr>
	
</table>
<input type="hidden" name="action" value="update">
<input type="hidden" name="vendor_no" value="${rmVO.vendor_no}">
<input type="hidden" name="menu_no" value="${rmVO.menu_no}">
<input type="submit" value="送出修改"></FORM>

</body>
</html>