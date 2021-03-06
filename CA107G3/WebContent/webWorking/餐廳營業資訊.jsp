
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<title>餐廳管理後台</title>
<!-- Side Nav -->
<style type="text/css">
body {
	background-color: #eee;
	font-family: "微軟正黑體";
}

#sidenavOverlay {
	display: none;
	position: fixed;
	bottom: 0;
	left: 0;
	right: 0;
	top: 0;
	z-index: 998;
	background: rgba(0, 0, 0, 0.5);
}

#sidenavOverlay.active {
	display: block;
}

#sidenav {
	position: fixed;
	top: 0;
	bottom: 0;
	width: 280px;
	left: -280px;
	z-index: 999;
	background: #fff;
	color: #000;
}

.fullbar {
	animation-name: full;
	animation-duration: 0.5s;
	animation-fill-mode: both;
}

.invibar {
	animation-name: invi;
	animation-duration: 0.5s;
	animation-fill-mode: forwards;
}

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

.needs-validation {
	margin-top: 15%;
}

.form-row {
	margin-top: 2%;
}

.resTitle {
	font-size: 30px;
	margin-left: 5%;
}

img {
	width: 800px;
	max-width: 500px;
}

@keyframes full {from { left:-280px;
	
}

to {
	left: 0px;
}

}
@keyframes invi {from { left:0px;
	
}

to {
	left: -280px;
}
}

/*.side-nav__section-title {
            color: #202124;
            display: block;
            font-size: 18px;
            padding-bottom: 12px;
            padding-left: 24px;
            padding-top: 40px;
        }       */
</style>
</head>
<!-- ============================================================================= -->

<body>
	<!-- Navbar -->
	<nav class="navbar  bg-dark navbar-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar" id="btnSidenav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<spqn class="navbar-brand resTitle">紅樓港式餐廳[佔位]，您好！</spqn>
		<span class="navbar-brand">Seek Food Table</span>
	</nav>
	<!-- Side Nav -->
	<div id="sidenavOverlay"></div>
	<nav class="nav navbar-nav bg-dark" id="sidenav">
		<a class="nav-link text-white p-3" href="#">基本資料</a> <a
			class="nav-link text-white p-3" href="#">訂位管理</a> <a
			class="nav-link text-white p-3" href="#">菜單管理</a> <a
			class="nav-link text-white p-3" href="#">帳戶管理</a> <a
			class="nav-link text-white p-3" href="#">資訊管理</a> <a
			class="nav-link text-white p-3" href="#">帳戶管理</a> <a
			class="nav-link text-white p-3" href="#">桌況設定</a> <a
			class="nav-link text-white p-3" href="#">回應管理</a> <a
			class="nav-link text-white p-3" href="#">訂位者驗證</a> <a
			class="nav-link text-white p-3" href="#">候位者驗證</a>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<!-- ===============================編輯區 開始====================================== -->


				<form class="needs-validation" novalidate>
					<div class="container">

						<div class="col-12">
							<label id="topicBar" class="col-12">餐廳營業資訊設定</label>
							<div class="form-row">
								<div class="col-4 col-form-label">
									<label for="validationTooltip01">餐廳類型 :</label>
								</div>
								<div class="col-8">
									<input type="text" name="MEM_NAME" class="form-control"
										placeholder="請輸入餐廳類型" required>

								</div>
							</div>
							<div class="form-row">
								<div class="col-4 col-form-label">
									<label>開始營業時間 :</label>
								</div>
								<div class="col-8">
									<input type="text" name="MEM_ID" class="form-control"
										placeholder="請填寫帳號" required>
									<div class="invalid-tooltip">請輸入正確格式</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-4 col-form-label">
									<label>結束營業時間 :</label>
								</div>
								<div class="col-8">
									<input type="text" name="MEM_PWD" class="form-control" id="pwd"
										placeholder="請填寫6-10位混和英數字,英文需區分大小寫" maxlength="10" required
										pattern="^(?=.*\d)(?=.*[A-za-z]).{6,10}$">

								</div>
							</div>
							<div class="form-row">
								<div class="col-4 col-form-label">
									<label>定期休假 :</label>
								</div>
								<div class="col-8">
									<input type="text" name="MEM_PWD_confirm" class="form-control"
										placeholder="選擇星期" maxlength="10" id="pwdconfirm" required
										pattern="^(?=.*\d)(?=.*[A-za-z]).{6,10}$">

								</div>
							</div>
							<div class="form-row">
								<div class="col-4 col-form-label">
									<label>店內總桌數 :</label>
								</div>
								<div class="col-8">
									<input type="text" name="MEM_MAIL" class="form-control"
										placeholder="數字" required>
									<div class="invalid-tooltip">請輸入有效信箱</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-4 col-form-label">
									<label>餐廳類型 :</label>
								</div>
								<div class="col-8">
									<input type="text" name="MEM_ACCOUNT" class="form-control"
										maxlength="10" required>

								</div>

							</div>
							<div class="form-row">
								<div class="col-4 col-form-label">
									<label>餐廳說明 :</label>
								</div>
								<div class="col-8">
									<textarea rows="6" cols="50" class="form-control"
										aria-label="With textarea"></textarea>


								</div>

							</div>


							<div>
								<button type="submmit" class="btn btn-primary col-12">送出</button>
							</div>
						</div>
					</div>
			</div>
			</form>
			<div class="col-6">
				<div class="form-row">
					<div class="col-3 col-form-label">
						<label>店家形象</label>
					</div>
					<div class="col-9">
						<button id="V_PIC">更換形象</button>
					</div>
				</div>
				<img
					src="https://api.fnkr.net/testimg/350x200/00CED1/FFF/?text=img+placeholder">
				<div class="form-row">
					<div class="col-3 col-form-label">
						<label>目前宣傳</label>
					</div>
					<div class="col-9">
						<button id="V_AD">更換宣傳</button>
					</div>
				</div>
				<img
					src="https://api.fnkr.net/testimg/350x200/00CED1/FFF/?text=img+placeholder">


			</div>






















			<!-- =================================編輯區 結束==================================== -->
		</div>
	</div>

	</div>


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
	<!-- Input type=number -->
	<script src="bootstrap-input-spinner.js"></script>
	<!--     sweetalert -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
	<script>
    $("input[type='number']").inputSpinner()
    </script>
	<!-- Side Nav -->
	<script type="text/javascript">
    $(document).ready(function() {
        $('#btnSidenav').on('click', function(e) {
            $('#sidenav').removeClass('invibar');
            $('#sidenavOverlay').addClass('active');
            $('#sidenav').addClass('fullbar');
        });

        jQuery('#sidenavOverlay').on('click', function() {
            $('#sidenavOverlay').removeClass('active');
            $('#sidenav').removeClass('fullbar');
            $('#sidenav').addClass('invibar');
        });
    });


    </script>
	<script type="text/javascript">

$("#V_PIC , #V_AD").click(async function(event) {



    
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
      title: '您即將上傳',
      imageUrl: e.target.result,
      imageAlt: 'The uploaded picture'
      
    })
  }

  reader.readAsDataURL(file)

}




})

    </script>
</body>

</html>