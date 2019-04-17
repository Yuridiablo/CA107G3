
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="com.restaurant_menu.model.*"%>

<%
	List<Restaurant_MenuVO> vlist = (List<Restaurant_MenuVO>)request.getAttribute("vlist"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
	out.print(vlist);
	Restaurant_MenuVO rmVO = (Restaurant_MenuVO)request.getAttribute("rmVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
	out.print(rmVO);
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="UTF-8">
<title>廠商後台-菜單管理</title>

<style>
img{
max-width:300px;
}
</style>

</head>
<body>
<br><br>
 <h4><a href="chooseVendor.jsp">回選擇頁</a></h4>
<input type="button" value="新增" onclick="location.href='addMenu.jsp'">

<table border=1>
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
<%--         <td>${Restaurant_MenuVO.menu_pic}</td> --%>
        <td><img src="<%= request.getContextPath()%>/Restaurant_Menu/ShowImg.do?menu_no='${Restaurant_MenuVO.menu_no}'"></td>
        <td>${Restaurant_MenuVO.menu_stat}</td>
        <td><textarea cols="50" rows="5">${Restaurant_MenuVO.menu_text}</textarea></td>

			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Restaurant_Menu/Restaurant_Menu.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="menu_no" value="${Restaurant_MenuVO.menu_no}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Restaurant_Menu/Restaurant_Menu.do" style="margin-bottom: 0px;">
			     <input type="submit" value="上架">
			     <br>
			     <input type="hidden" name="action"	value="changeStatUp">
			   </FORM>
			    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Restaurant_Menu/Restaurant_Menu.do" style="margin-bottom: 0px;">
			     <input type="submit" value="下架">
			     <br>
			     <input type="hidden" name="action"	value="changeStatDown">
			   </FORM>
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