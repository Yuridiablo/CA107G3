<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.vendor.model.*"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>店家會員註冊</title>
<style type="text/css">
.col-form-label {
	text-align: right;
	font: 18px 微軟正黑體;
}

#refreshconfirm {
	text-align: right;
	margin-bottom: 5px;
}

.btn-primary {
	background-color: orange;
	border-color: orange;
}

#topicBar {
	border: 1px;
	border: solid;
	border-color: #7c7c7c;
	background-color: #7c7c7c;
	color: white;
	text-align: center;
	font-size: 20px;
	font-weight: bold;
}

#confirmletter {
	display: inline-block;
	font: 15px/40px Helvetica;
	text-align: center;
	background: #F5F5F5;
	border: 1px solid #cccccc;
	color: #000000;
	margin: 0px 8px 0px 0px;
	position: relative;
	top: -2px; #
	top: 1px;
	cursor: pointer;
	text-decoration: none;
}
</style>
</head>

<body>
	<form class="needs-validation" novalidate>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-6">
					<label id="topicBar" class="col-12">SeakFoodTable 廠商註冊</label>
					<div class="form-row">
						<div class="col-2 col-form-label">
							<label for="validationTooltip01">餐廳名稱 :</label>
						</div>
						<div class="col-10">
							<input type="text" name="MEM_NAME" class="form-control"
								placeholder="請輸入餐廳名稱" required>
							<div class="invalid-tooltip">請輸入餐廳名稱!</div>
						</div>
					</div>
					<div class="form-row">
						<div class="col-2 col-form-label">
							<label>帳號 :</label>
						</div>
						<div class="col-10">
							<input type="text" name="MEM_ID" class="form-control"
								placeholder="請填寫帳號" required>
							<div class="invalid-tooltip">請輸入正確格式</div>
						</div>
					</div>
					<div class="form-row">
						<div class="col-2 col-form-label">
							<label>設定密碼 :</label>
						</div>
						<div class="col-10">
							<input type="password" name="MEM_PWD" class="form-control"
								id="pwd" placeholder="請填寫6-10位混和英數字,英文需區分大小寫" maxlength="10"
								required pattern="^(?=.*\d)(?=.*[A-za-z]).{6,10}$">
							<div class="invalid-tooltip  ">請設定密碼</div>
						</div>
					</div>
					<div class="form-row">
						<div class="col-2 col-form-label">
							<label>密碼確認 :</label>
						</div>
						<div class="col-10">
							<input type="password" name="MEM_PWD_confirm"
								class="form-control" placeholder="請再輸入一次密碼" maxlength="10"
								id="pwdconfirm" required
								pattern="^(?=.*\d)(?=.*[A-za-z]).{6,10}$">
							<div class="invalid-tooltip pwdtip">請輸入同上密碼</div>
						</div>
					</div>
					<div class="form-row">
						<div class="col-2 col-form-label">
							<label>信箱 :</label>
						</div>
						<div class="col-10">
							<input type="email" name="MEM_MAIL" class="form-control"
								placeholder="請填寫有效的email" required>
							<div class="invalid-tooltip">請輸入有效信箱</div>
						</div>
					</div>
					<div class="form-row">
						<div class="col-2 col-form-label">
							<label>電話 :</label>
						</div>
						<div class="col-2">
							<input type="text" name="MEM_ACCOUNT" class="form-control"
								maxlength="10" required
								pattern="^(?=.*\d)(?=.*[A-za-z]).{6,10}$">
							<div class="invalid-tooltip"></div>
						</div>
						<div class="col-8">
							<input type="text" name="MEM_ACCOUNT" class="form-control"
								placeholder="請輸入正確電話格式" maxlength="10" required
								pattern="^(?=.*\d)(?=.*[A-za-z]).{6,10}$">
							<div class="invalid-tooltip">請輸入正確格式</div>
						</div>
					</div>
					<div class="form-row">
						<div class="col-2 col-form-label">
							<label>地址 :</label>
						</div>
						<div class="col-2">
							<input type="text" name="MEM_ACCOUNT" class="form-control"
								maxlength="10" placeholder="區號" required
								pattern="^(?=.*\d)(?=.*[A-za-z]).{6,10}$">
							<div class="invalid-tooltip">郵遞區號</div>
						</div>
						<div class="col-3">
							<input type="text" name="MEM_ACCOUNT" class="form-control"
								placeholder="縣市" maxlength="10" required
								pattern="^(?=.*\d)(?=.*[A-za-z]).{6,10}$">
							<div class="invalid-tooltip">縣市</div>
						</div>
						<div class="col-3">
							<input type="text" name="MEM_ACCOUNT" class="form-control"
								placeholder="行政區" maxlength="10" required
								pattern="^(?=.*\d)(?=.*[A-za-z]).{6,10}$">
							<div class="invalid-tooltip">區</div>
						</div>
					</div>
					<div class="form-row">
						<div class="col-2">
							<label></label>
						</div>
						<div class="col-10">
							<input type="text" name="MEM_ACCOUNT" class="form-control"
								maxlength="10" placeholder="" required
								pattern="^(?=.*\d)(?=.*[A-za-z]).{6,10}$">
							<div class="invalid-tooltip">地址</div>
						</div>
					</div>
					<div class="form-row">
						<div class="col-2 col-form-label">
							<label>店家照片 :</label>
						</div>
						<div class="col-10">
							<input type="file" class="form-control-file" name="MEM_PIC">
						</div>
					</div>
<!-- 					<div class="form-row"> -->
<!-- 						<div class="col-2 col-form-label"> -->
<!-- 							<label>驗證碼 :</label> -->
<!-- 						</div> -->
<!-- 						<div class="col-8"> -->
<!-- 							<input type="text" name="MEM_PWD_confirm" class="form-control" -->
<!-- 								placeholder="請輸入右方數字" maxlength="10" required> -->
<!-- 							<div class="invalid-tooltip">請輸入驗證碼</div> -->
<!-- 						</div> -->
<!-- 						<div class="col"> -->
<!-- 							<img src="dog.jpg" class="col-12"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div> -->
<!-- 						<a href="#"><small id="refreshconfirm" -->
<!-- 							class="form-text text-muted">重新產生</small></a> -->
<!-- 					</div> -->
					<div>
						<button type="submit" class="btn btn-primary col-12">送出審核</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Fetch all the forms we want to apply custom Bootstrap validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');
						// Loop over them and prevent submission
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();

		$("#pwdconfirm").on('blur', function() {
			var pwd = document.getElementById("pwd").value;
			var pwdconfirm = this.value;
			if (pwd != null && pwd != pwdconfirm) {
				$(".pwdtip").show();
			} else {
				$(".pwdtip").hide();
			}

		});
	</script>
</body>

</html>