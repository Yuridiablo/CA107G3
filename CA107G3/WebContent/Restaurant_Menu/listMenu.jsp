
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="com.restaurant_menu.model.*"%>

<jsp:useBean id="vVO" scope="session" class="com.vendor.model.VendorVO" />

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



<div class="container">
  <div class="row">
    <div class="col-12">
<button type="button" class="btn btn-warning justify-content-end" onclick="location.href='<%=request.getContextPath()%>/Restaurant_Menu/addMenu.jsp'">新增菜色</button>
</div>
</div>
</div>


<div class="container">
<div class="row">


<c:forEach var="rmVO" items="${rmlist}">


<div class="col-4">

 <div class="profile-img"><img id="p${rmVO.menu_no}" src="<%= request.getContextPath()%>/ShowImg.do?menu_no='${rmVO.menu_no}'"/></div>
 
 </div>     
  <div class="col-6"> 
  <h3> ${rmVO.menu_name}<span>$${rmVO.menu_price}</span></h3> 
   ${rmVO.menu_text}
   <div class="btn-group align-self-end align-items-end" role="group" aria-label="Basic example">
      <button type="button" class="btn btn-secondary pic" id="xx${rmVO.menu_no}">換圖</button>
      <button type="button" class="btn btn-secondary edit">編輯</button>
      <button type="button" class="btn btn-secondary updown">下架</button>
    </div>

</div>
      

</c:forEach>


</div>
 </div>




<!-- 	<tr> -->


<%--         <td>${rmVO.menu_name}</td> --%>
<%--         <td>${rmVO.menu_price}</td> --%>

<%--         <td><img src="<%= request.getContextPath()%>/Restaurant_Menu/ShowImg.do?menu_no='${rmVO.menu_no}'"></td> --%>
<%--         <td>${rmVO.menu_stat}</td> --%>
<%--         <td><textarea cols="50" rows="5">${rmVO.menu_text}</textarea></td> --%>

<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Restaurant_Menu/Restaurant_Menu.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="修改"> -->
<%-- 			     <input type="hidden" name="menu_no" value="${rmVO.menu_no}"> --%>
<!-- 			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM> -->
<!-- 			</td> -->
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Restaurant_Menu/Restaurant_Menu.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="上架"> -->
<!-- 			     <br> -->
<!-- 			     <input type="hidden" name="action"	value="changeStatUp"> -->
<!-- 			   </FORM> -->
<%-- 			    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Restaurant_Menu/Restaurant_Menu.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="下架"> -->
<!-- 			     <br> -->
<!-- 			     <input type="hidden" name="action"	value="changeStatDown"> -->
<!-- 			   </FORM> -->
<!-- 			</td> -->
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/Restaurant_Menu/Restaurant_Menu.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="刪除"> -->

<!-- 			     <input type="hidden" name="action" value="delete"></FORM> -->
<!-- 			</td> -->

<!-- 	</tr> -->

<c:forEach var="rmVO" items="${rmlist}">

<script type="text/javascript">
$("#xx${rmVO.menu_no}").click(async function(event) {
    
	const {value: file} = await Swal.fire({
	  title: '請選擇圖片',
	  input: 'file',
	  inputAttributes: {
	    'accept': 'image/*',
	    'aria-label': 'Upload your profile picture'
	  }
	})
	if (file) {
	  const reader = new FileReader
	  reader.onload = (e) => {
	    Swal.fire({
	      title: '圖片已變更為',
	      imageUrl: e.target.result,
	      imageAlt: 'The uploaded picture'
	      
	   
	    }).then(function(file){
	    	$.ajax({
	    		url: "<%=request.getContextPath()%>/Restaurant_Menu/Restaurant_Menu.do",
	            type : 'post',
				data: { action: 'upMenu', file: e.target.result , menu_no:'${rmVO.menu_no}'},
				dataType: 'json',
				async : false,//同步請求
				cache : false,//不快取頁面
				
	    	})
	    })
	    $('#p${rmVO.menu_no}').attr('src', e.target.result);
	  }
	  
	  reader.readAsDataURL(file)
	}
	})


</script>

</c:forEach>

</body>
</html>