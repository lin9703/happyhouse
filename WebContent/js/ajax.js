/** ************* 아파트 실거래가 정보 가져오기 *************** */



/** ************* 아파트 실거래가 정보 가져오기 *************** */
$("#gu").on('change', function() {
	const gu = $(this).val();
	$.ajax({
		url:"http://localhost:8080/HappyHouse_BackEnd_%EC%84%9C%EC%9A%B8_12%EB%B0%98_%EA%B9%80%EC%9E%AC%ED%98%84_%EA%B9%80%ED%9A%A8%EB%A6%B0/main?act=gu&gu="+gu,
		success:function(data){
			$("#dong").empty();
			$.each(data, function(idx, item) {
				$("#dong").append("<option value='"+item+"'>"+item);
			});
		}
});})


