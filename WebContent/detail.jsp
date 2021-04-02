<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Happy House</title>
<meta content="" name="description">
<meta content="" name="keywords">

<style>
#search {
	margin-left: 20px;
	padding: 5px;
}
</style>
</head>
<%@ include file="/include/header.jsp" %>
<body>

	<section id="hero">
		<div class="hero-container" data-aos="fade-in">

			<div
				class="sorting-filters text-center mb-20 d-flex justify-content-center">
				<form class="form-inline" id="frm" action="${root }/main">
					<!-- <input type="hidden" id="code"  name="code" value="code"/> -->
					<div class="form-group md pr-3">
						<select class="form-control" name="city" id="city">
							<option value="all">도/광역시</option>
							<option value="서울특별시">서울시</option>
							<option value="경기도">경기도</option>
							<option value="인천광역시">인천광역시</option>
							<option value="부산광역시">부산광역시</option>
							<option value="대전광역시">대전광역시</option>
							<option value="대구광역시">대구광역시</option>
							<option value="울산광역시">울산광역시</option>
							<option value="세종특별자치시">세종시</option>
							<option value="광주광역시">광주광역시</option>
							<option value="강원도">강원도</option>
							<option value="충청북도">충청북도</option>
							<option value="경상북도">경상북도</option>
							<option value="경상남도">경상남도</option>
							<option value="전라북도">전라북도</option>
							<option value="전라남도">전라남도</option>
							<option value="제주특별자치도">제주도</option>
						</select>
					</div>
					<div class="form-group md-1 pr-3">
						<select class="form-control" name="gu" id="gu">
							<option value="all">시/구/군</option>
							<option value="도봉구">도봉구</option>
							<option value="은평구">은평구</option>
							<option value="동대문구">동대문구</option>
							<option value="동작구">동작구</option>
							<option value="금천구">금천구</option>
							<option value="구로구">구로구</option>
							<option value="종로구">종로구</option>
							<option value="강북구">강북구</option>
							<option value="중랑구">중랑구</option>
							<option value="강남구">강남구</option>
							<option value="강서구">강서구</option>
							<option value="중구">중구</option>
							<option value="강동구">강동구</option>
							<option value="광진구">광진구</option>
							<option value="마포구">마포구</option>
							<option value="서초구">서초구</option>
							<option value="성북구">성북구</option>
							<option value="노원구">노원구</option>
							<option value="송파구">송파구</option>
							<option value="서대문">서대문</option>
							<option value="양천구">양천구</option>
							<option value="영등포구">영등포구</option>
							<option value="관악구">관악구</option>
							<option value="성동구">성동구</option>
							<option value="용산구">용산구</option>
						</select>
					</div>
					<div class="form-group md-1">
						<select class="form-control" name="dong" id="dong">
							<option value="all">동</option>
						</select>
					</div>
					<div>
						<button type="button" id="search">검색</button>
					</div>
				</form>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<h3
						style="background-color: #b3e6cc; font-size: 15pt; padding: 10px; border-radius: 10px; box-shadow: 0 8px 6px -6px black;">거래
						정보</h3>
					<hr>
					<div id="deal-list" style="height: 500px; overflow: scroll;"></div>
				</div>
				<div class="col-md-8" id="map"
					style="box-shadow: 0 8px 6px -6px black;"></div>
			</div>
		</div>
	<h1>============</h1>
	</section>
	<!-- End Hero Section -->
	<%@ include file="/include/footer.jsp" %>
</body>
	<%@ include file="/include/vendorjs.jsp" %>
</html>