<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<%@ include file="/include/header.jsp" %>
<body>

	<!-- ======= Hero Section ======= -->
	<section id="hero">
		<div class="hero-container" data-aos="fade-in">
			<h1>행복한 우리집</h1>
			<h2>HAPPY HOUSE</h2>

			<div
				class="sorting-filters text-center mb-20 d-flex justify-content-center">
				<form class="form-inline" id="frm" action="searchRecentHouseDeal.do">
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
						<select class="form-control" name="dongcode" id="gu">
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

				</form>
			</div>
			<br>
			<div id="map" style="height: 500px; width: 800px;"></div>
		</div>

	</section>
	<!-- End Hero Section -->
	<%@ include file="/include/footer.jsp" %>
</body>
	<%@ include file="/include/vendorjs.jsp" %>
</html>