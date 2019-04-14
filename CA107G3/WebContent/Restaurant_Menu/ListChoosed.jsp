
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="com.restaurant_menu.model.*"%>

<%
	List<Restaurant_MenuVO> vlist = (List<Restaurant_MenuVO>)request.getAttribute("vlist"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
	out.print(vlist);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>廠商後台-菜單管理</title>
</head>
<body>

<table>
	<tr>

		<th>品項編號</th>
		<th>廠商編號</th>
		<th>品名</th>
		<th>價格</th>
		<th>圖片</th>
		<th>狀態</th>
		<th>說明文字</th>

	</tr>
	
<c:forEach var="Restaurant_MenuVO" items="${vlist}">

	<tr>

		<td>${Restaurant_MenuVO.menu_no}</td>
        <td>${Restaurant_MenuVO.vendor_no}</td>
        <td>${Restaurant_MenuVO.menu_name}</td>
        <td>${Restaurant_MenuVO.menu_price}</td>
        <td>${Restaurant_MenuVO.menu_pic}</td>
        <td>${Restaurant_MenuVO.menu_stat}</td>
        <td>${Restaurant_MenuVO.menu_text}</td>

		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Restaurant_Menu/Restaurant_Menu.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="menu_no" value="${Restaurant_MenuVO.menu_no}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Restaurant_Menu/Restaurant_Menu.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
<%-- 			     <input type="hidden" name="empno"  value="${empVO.empno}"> --%>
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>

	</tr>
</c:forEach>

</table>

</body>
</html>