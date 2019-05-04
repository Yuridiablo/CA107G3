<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.vendor.model.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Colorlib">
    <meta name="description" content="#">
    <meta name="keywords" content="#">
    <!-- Favicons -->
    <link rel="shortcut icon" href="#">
    <!-- Page Title -->
    <title>SeekFoodTable &amp; 搜尋結果</title>
    <!-- Bootstrap CSS -->
    <!-- 貓頭鷹 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- 以下是 自訂的東西 -->
    <!-- 線條樣式 -->
    <!-- 線條樣式 -->
    <link rel="stylesheet" type="text/css" href="../front-end/css/simple-line-icons.css">
    <!-- Icon資源池 -->
    <link rel="stylesheet" type="text/css" href="../front-end/css/themify-icons.css">
    <!-- 動態效果 -->
    <link rel="stylesheet" type="text/css" href="../front-end/css/set1.css">
    <!-- 自訂 CSS主檔 -->
    <link rel="stylesheet" type="text/css" href="../front-end/css/style.css">
</head>
<style type="text/css">
.featured-place-wrap img {
    width: 30%;

    object-fit: cover;
}

.featured-responsive .img-fluid {
    height: 240px;
    width: 300px;
    object-fit: cover;
    margin-top: 2%;
}

.featured-place-wrap .media {
    margin: 30px 0 10px 0
}
</style>

<body>
    <!--============================= DETAIL =============================-->
    <section>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-7 responsive-wrap">
                    <div class="row detail-filter-wrap">
                        <div class="col-md-7 featured-responsive">
                            <div class="detail-filter-text">
                            <form  METHOD="post" ACTION="<%=request.getContextPath()%>/Vendor/Vendor.do" >
                                <div class="input-group mb-3">
                                    <input type="text" class="form-control" placeholder="輸入條件.." aria-label="Recipient's username" aria-describedby="button-addon2" name="v_name" value="${vVO.v_name}">
                                    <div class="input-group-append">
                                    <input type="hidden" name="action" value="search">
                                        <button class="btn btn-warning" type="submit" id="button-addon2"><span class="icon-magnifier search-icon"></span>再次搜尋</button>
                                        <p>${fn:length(searchlist)}個符合條件的結果 <span>於${fn:length(alllist)}間餐廳</span></p>
                                    </div>
                                </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-5 featured-responsive">
                            <div class="detail-filter">
                                <p>變更條件</p>
                                <form class="filter-dropdown">
                                    <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="inlineFormCustomSelect">
                                        <option selected>評分高於</option>
                                        <option value="4">4</option>
                                        <option value="3">3</option>
                                        <option value="2">2</option>
                                    </select>
                                </form>
                                <form class="filter-dropdown">
                                    <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="inlineFormCustomSelect1">
                                        <option selected>距離我</option>
                                        <option value="1">5公里</option>
                                        <option value="2">10公里</option>
                                        <option value="3">30公里</option>
                                        <option value="4">30公里以上</option>
                                    </select>
                                </form>
                                <div class="map-responsive-wrap">
                                    <a class="map-icon" href="#"><span class="icon-location-pin"></span></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row detail-checkbox-wrap">
                        <div class="col-6">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                                <label class="form-check-label" for="inlineCheckbox1">營業中</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                                <label class="form-check-label" for="inlineCheckbox2">有停車位</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3" disabled>
                                <label class="form-check-label" for="inlineCheckbox3">disabled</label>
                            </div>
                            核取方塊的位置
                        </div>
                        <div class="col-12">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item disabled">
                                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">上頁</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                                    <li class="page-item"><a class="page-link" href="#">5</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#">下頁</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>


<c:forEach var="sMap" items="${searchMap}">

                    
                    <div class="container-fluid onerest">
                        <div class="col-12 featured-responsive ">
                            <div class="featured-place-wrap">
                                <div class="d-flex">
                                <img  class="img-fluid resultpic" alt="#" src="<%= request.getContextPath()%>/ShowImg.do?vendor_no='${sMap.key.vendor_no}'&pic=1">
                                                                        <span class="featured-rating-green">${sMap.value[0]}</span>
                                    <div class="featured-title-box">
                                        <h5>${sMap.key.v_name}</h5>
                                        <p>${sMap.key.v_type} </p> <span>• </span>
                                        <p>${sMap.value[1]} 評論</p> <span> • </span>
                                        <p><span>$$$</span>$$</p>
                                        <ul>
                                            <li><span class="icon-location-pin"></span>
                                                <span>${sMap.key.v_ad_code}${sMap.key.v_address1}${sMap.key.v_address2}${sMap.key.v_address3}</span>
                                            </li>
                                            <li><span class="icon-screen-smartphone"></span>
                                                <p>${sMap.key.v_n_code}-${sMap.key.v_tel}</p>
                                            </li>
                                            <li><span class="icon-info"></span>
                                                <p>座位數：${sMap.key.v_tables}</p>
                                            </li>
                                        </ul>
                                        <div class="bottom-icons">
                                            <div class="closed-now">休息中</div>
                                            <span class="ti-heart"></span>
                                            <span class="ti-share"></span>
                                        </div>
                                    </div>
                                    <div class="col-5">
                                        <div class="media">
                                        
                                            <img src="images/4809.jpg" class="mr-3" alt="...">
                                            <div class="media-body">
                                                <h5 class="mt-0">我沒鼻子都覺得香</h5>
                                                ${sMap.value[2]}
                                            </div>
                                        </div>
                                        <div>評分：${sMap.value[3]}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
  
</c:forEach>




                    <div class="col-md-5 responsive-wrap map-wrap">
                        <div class="map-fix">
                            <!-- data-toggle="affix" -->
                            <!-- Google map will appear here! Edit the Latitude, Longitude and Zoom Level below using data-attr-*  -->
                            <div id="map" data-lat="24.969" data-lon="121.191" data-zoom="14"></div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
           
    </section>
    <!--//END DETAIL -->
    <!-- jQuery, Bootstrap JS. -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="../front-end/js/jquery-3.3.1.min.js"></script>
    <script src="../front-end/js/popper.min.js"></script>
    <!-- 貓頭鷹 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
    <script>
    $(".map-icon").click(function() {
        $(".map-fix").toggle();
    });
    </script>
    <script>
    // Want to customize colors? go to snazzymaps.com
    function myMap() {
        var maplat = $('#map').data('lat');
        var maplon = $('#map').data('lon');
        var mapzoom = $('#map').data('zoom');
        // Styles a map in night mode.
        var map = new google.maps.Map(document.getElementById('map'), {
            center: {
                lat: maplat,
                lng: maplon
            },
            zoom: mapzoom,
            scrollwheel: false
        });
        var marker = new google.maps.Marker({
            position: {
                lat: maplat,
                lng: maplon
            },
            map: map,
            title: 'We are here!'
        });
    }
    </script>
    <!-- Map JS (Please change the API key below. Read documentation for more info) -->
    <script src="https://maps.googleapis.com/maps/api/js?callback=myMap&key=AIzaSyBYZhprf58VI160spKuA98fVS9AcSeVuVg"></script>
</body>

</html>