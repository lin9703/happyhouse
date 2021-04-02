// 화면에 대한 초기화 작업 및 로그아웃 화면
function init(flag){
	let befores = $(".before_login");
	for(let before of befores){
		// flag가 true로 평가되면 숨김(none), 아니면 표시(inline-block)
		before.style.display = flag?"none":"inline-block"
	}
	let afters = $(".after_login");
	for(let after of afters){
		// flag가 true로 평가되면 보임, 아니면 숨김
		after.style.display = flag?"inline-block":"none"
	}
}

init();

$("#login").on('click', function() {	
	if($(id).val()=="ssafy" && $(pwd).val()=="1234"){
		alert("로그인 성공");
		init(true);
	} else {
		alert("로그인 실패");
	}
})
	
$("#logout").on('click', function() {
	init();
})

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

$("#dong").on('change', function() {
	var officeAddr = $("#dong").val();

	$.get("https://maps.googleapis.com/maps/api/geocode/json"
		, {	
			key: 'AIzaSyBAnF5Ody8kFckur_X9VFJc8jWS5MYwBxE', address: officeAddr 
		} , function(data, status) {
				// deleteMarkers();
			console.log(data);
			deleteMarkers();
			officemarker = {
				coords: { lat: data.results[0].geometry.location.lat, lng: data.results[0].geometry.location.lng },
				iconImage: null,
				content: officeAddr
			};
			console.log(officemarker);
			addMarker(officemarker);
		}			
		, "json"
	);// get
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