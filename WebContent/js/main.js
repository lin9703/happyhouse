//// 화면에 대한 초기화 작업 및 로그아웃 화면
//function init(flag){
//	let befores = $(".before_login");
//	for(let before of befores){
//		// flag가 true로 평가되면 숨김(none), 아니면 표시(inline-block)
//		before.style.display = flag?"none":"inline-block"
//	}
//	let afters = $(".after_login");
//	for(let after of afters){
//		// flag가 true로 평가되면 보임, 아니면 숨김
//		after.style.display = flag?"inline-block":"none"
//	}
//}
//
//init();
//
//$("#login").on('click', function() {	
//	if($(id).val()=="ssafy" && $(pwd).val()=="1234"){
//		alert("로그인 성공");
//		init(true);
//	} else {
//		alert("로그인 실패");
//	}
//})
//	
//$("#logout").on('click', function() {
//	init();
//})

// map 기능 

//function initMap() {
//	map = new google.maps.Map(document.getElementById("map"), {
//	    center: { lat: -34.397, lng: 150.644 },
//	    zoom: 8,
//	});
//}

// officeAddress의 주소를 이용하여 geocoding으로 lat, lng 얻어온 후 marker
let officemarker = {
	coords: { lat: 37.5845012, lng: 126.9990943 },
	iconImage: null,
	content: "명륜2가"
};
let map;
function initMap() {
	map = new google.maps.Map(document.getElementById("map"), {
	    center: officemarker.coords,
	    zoom: 8,
	});
	
	//infoWindow = new google.maps.InfoWindow;
	
	//const myposition = "img/my_position.png";
	
}

//$("#dong").on('change', function() {
//	var officeAddr = $("#dong").val();
//
//	$.get("https://maps.googleapis.com/maps/api/geocode/json"
//		, {	
//			key: 'AIzaSyBAnF5Ody8kFckur_X9VFJc8jWS5MYwBxE', address: officeAddr 
//		} , function(data, status) {
//				// deleteMarkers();
//			console.log(data);
//			deleteMarkers();
//			officemarker = {
//				coords: { lat: data.results[0].geometry.location.lat, lng: data.results[0].geometry.location.lng },
//				iconImage: null,
//				content: officeAddr
//			};
//			console.log(officemarker);
//			addMarker(officemarker);
//		}			
//		, "json"
//	);// get
//})

//********** 동 보여주기
$("#gu").on("change", function(){
	const gu = $("#gu").val();
	
	if(gu == "종로구"){
		$.ajax({
	         url: "http://localhost:8080/HappyHouse_BackEnd_%EC%84%9C%EC%9A%B8_12%EB%B0%98_%EA%B9%80%EC%9E%AC%ED%98%84_%EA%B9%80%ED%9A%A8%EB%A6%B0/main?act=gu&name=종로구",
	         success: function(data) {
	            // console.log(data);
	            let apartments = $(data).find("item");
	            let $ul = $("#deal-list");
	            // console.log(apartments);
	            $.each(apartments, function(idx, item) {
	               let $apartment = $(item);
	               
	               let html = `
	                          <div class="menu_item">
	                            <a href="#"><p>${$apartment.find("아파트").text()} </p></a>
	                            <p> 거래금액: ${$apartment.find("거래금액").text()} </p>
	                            <p> 면적: ${$apartment.find("전용면적").text()} </p>
	                            <p> ${$apartment.find("년").text()}. ${$apartment.find("월").text()}. ${$apartment.find("일").text()} </p>
	                          </div>
	                          <hr>
	                       `;
	               
//	               console.log($apartment.find("법정동").text());
//	               console.log(" 사직동");
	             console.log("aa:"+$apartment.find("법정동").text().trim());
	             console.log("dong:"+$("#dong").val())
	               if($apartment.find("법정동").text().trim() == $("#dong").val()) {               
	                  $ul.append($(html));
	               }
	            })
	          }
	   })
	}
	
})


//var map;
var markers = [];
var infoWindow;

//function initMap() {
//	map = new google.maps.Map(document.getElementById("map"), {
//	    center: officemarker.coords,
//	    zoom: 8,
//	});
//	
//	//infoWindow = new google.maps.InfoWindow;
//	
//	//const myposition = "img/my_position.png";
//	
//}


function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	infoWindow.setPosition(pos);
	infoWindow.setContent(browserHasGeolocation ?
		'Error: Geolocation 서비스 실패.' :
		'Error: Geolocation을 지원하지 않는 브라우저.');
	infoWindow.open(map);
}

function addMarker(props) {
	const marker = new google.maps.Marker({
		position: new google.maps.LatLng(parseFloat(props.coords.lat),parseFloat(props.coords.lng)),
		map: map
	});
	map.setCenter(marker.getPosition());
	map.setZoom(15);
	
	if(props.iconImage){
		marker.setIcon(props.iconImage);
	}

	if(props.content){
		infoWindow = new google.maps.InfoWindow({
			content:props.content
		});

	}
	
	marker.addListener('click', function() {
		map.setZoom(17);
		map.setCenter(marker.getPosition());
		bounceMarker(marker);
	});
	markers.push(marker);
	setMapOnAll(map);
}

function bounceMarker(marker) {
	if (marker.getAnimation() !== null) {
		marker.setAnimation(null);
	} else {
		marker.setAnimation(google.maps.Animation.BOUNCE);
	}
}

function deleteMarkers() {
	clearMarkers();
	markers = [];
}

function clearMarkers() {
	setMapOnAll(null);
}

function setMapOnAll(map) {
	for (let i = 0; i < markers.length; i++) {
		markers[i].setMap(map);
	}
}