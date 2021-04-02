/** ************* 아파트 실거래가 정보 가져오기 *************** */
$("#gu").on('change', function() {
	const gu = $(this).val();
	$.ajax({
		url:`http://localhost:8080/HappyHouse_BackEnd/main?act=gu&gu=${gu}`,
		success:function(data){
			$("#dong").empty();
			$.each(data, function(idx, item) {
				$("#dong").append("<option value='"+item+"'>"+item);
			});
		}
});})


/** ************* 기본(위) 검색(법정동 기준) 데이터 가져오기 *************** */
$("#search").on('click', function() {
	const dong = $("#dong").val();
	$.ajax({
		url:`http://localhost:8080/HappyHouse_BackEnd/main?act=search&dong=${dong}`,
		success:function(data){
			$("#deal-list").empty();
			$.each(data, function(idx, item) {
				$("#deal-list").append(`<table>
				<tr class="apt-name"><td colspan="2">${item.aptName}</td></tr>
				<tr><td class="apt-head">거래 금액: </td><td class="apt-right">${item.dealAmount}</td></tr>
				<tr><td class="apt-head">면적: </td><td class="apt-right">${item.area}</td></tr>
				<tr><td class="apt-head">거래 날짜:</td><td class="apt-right">${item.dealYear}-${item.dealMonth}-${item.dealday}</td></tr>
				</table><hr>`);
			});
		}
});})
 
/** ************* 아파트, 실거래가별(아래) 검색 데이터 가져오기 *************** */
$("#search2").on('click', function() {
	const searchTitle = $("#searchTitle").val();
	const searchText = $("#searchText").val();
	console.log(searchTitle, searchText);
	$.ajax({
		url:`http://localhost:8080/HappyHouse_BackEnd/main?act=searchCategory&searchTitle=${searchTitle}&searchText=${searchText}`,
		success:function(data){
			$("#deal-list").empty();
			$.each(data, function(idx, item) {
				$("#deal-list").append(`<table>
				<tr class="apt-name"><td colspan="2">${item.aptName}</td></tr>
				<tr><td class="apt-head">거래 금액: </td><td class="apt-right">${item.dealAmount}</td></tr>
				<tr><td class="apt-head">면적: </td><td class="apt-right">${item.area}</td></tr>
				<tr><td class="apt-head">거래 날짜:</td><td class="apt-right">${item.dealYear}-${item.dealMonth}-${item.dealday}</td></tr>
				</table><hr>`);
			});
		}
});})