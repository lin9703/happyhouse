/** ************* 아파트 실거래가 정보 가져오기 *************** */
$("#search").click(function() {
//   alert("AAA")
   $.ajax({
         url: "./data/AptDealHistory.xml",
         success: function(data) {
            // console.log(data);
            let apartments = $(data).find("item");
            let $ul = $("#deal-list");
            // console.log(apartments);
            $.each(apartments, function(idx, item) {
               let $apartment = $(item);
//             console.log($apartment.find("아파트").text());
//             console.log($apartment.find("거래금액").text());
//             console.log($apartment.find("전용면적").text());
//             console.log($apartment.find("년").text())
//             console.log($apartment.find("월").text())
//             console.log($apartment.find("일").text())
               
               let html = `
                          <div class="menu_item">
                            <a href="#"><p>${$apartment.find("아파트").text()} </p></a>
                            <p> 거래금액: ${$apartment.find("거래금액").text()} </p>
                            <p> 면적: ${$apartment.find("전용면적").text()} </p>
                            <p> ${$apartment.find("년").text()}. ${$apartment.find("월").text()}. ${$apartment.find("일").text()} </p>
                          </div>
                          <hr>
                       `;
               
//               console.log($apartment.find("법정동").text());
//               console.log(" 사직동");
             console.log("aa:"+$apartment.find("법정동").text().trim());
             console.log("dong:"+$("#dong").val())
               if($apartment.find("법정동").text().trim() == $("#dong").val()) {               
                  $ul.append($(html));
               }
            })
          }
   })
});


/** ************* 아파트 실거래가 정보 가져오기 *************** */
$("#gu").on('change', function() {
	let gu = $(this).val();
	let $target = $("#dong")
	$target.empty();
	
	$.ajax({
		url:"./data/법정동코드.json",
		type:"get",
		success:function(data){
			//console.log(data);
			$.each(data, function(idx, item) {
				let val = item.법정동명.split(" ");
//				console.log(val[1]);
				if(gu == val[1]) {
					  let html =`		                      
					  <option value="${val[2]}">${val[2]}</option>`;
		            
//		            console.log($apartment.find("법정동").text());
//		            console.log(" 사직동");
					  $("#dong").append(html);
				}
			})
		}
	});

	
})


