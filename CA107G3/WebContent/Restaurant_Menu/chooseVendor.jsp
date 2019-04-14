<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.restaurant_menu.model.*" %>
<%@ page import="com.vendor.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>挑選一家廠商開始操作</h3>

  <jsp:useBean id="rmSvc" scope="page" class="com.restaurant_menu.model.Restaurant_MenuService" />
  <jsp:useBean id="vSvc" scope="page" class="com.vendor.model.VendorService" />
     <FORM METHOD="post" ACTION="Restaurant_Menu.do" >
       <b>廠商編號:</b>
       <select size="1" name="vendor_no">
         <c:forEach var="vVO" items="${vSvc.all}" > 
          <option value="${vVO.vendor_no}">${vVO.vendor_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_List">
       <input type="hidden" name="vendor_no" value="${rmVO.vendor_no}">
       <input type="submit" value="送出">
    </FORM>

<h3>直接列出資料庫全部清單</h3>
<a href='select_page.jsp'>列出全部</a>
</body>
</html>