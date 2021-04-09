// Initialize and add the map
function initMap(data) {

  // 기본 Data : The location of 광화문(init) or 조회하려는 법정동
  // 광화문 입구 : { lat: 37.57571, lng: 126.97672 }
  let dong = { lat: 37.57571, lng: 126.97672 };
  
  // 데이터가 있다면 갱신 
  if(data != null){
    	// data check
		// console.log(data);	
		// console.log(data['dongLoc']);
	  
		// dong = {lat: data['dongLoc']['lat'], lng:data['dongLoc']['lng']};
		dong = data['dongLoc'];
	}

  const zoom = 15; // zoom 설정

  // 맵의 중앙값 및 설정 초기화
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom,
    center: dong,
    minZoom : zoom - 2,
    maxZoom : zoom + 3,
  });
  
  // 첫 로딩 시, Marker 위치를 광화문으로 설정
  const marker = new google.maps.Marker({
    position: dong,
    map: map,
  });
  
  // Marker의 내용을 띄우기 위한 infoWindow 설정
  const infoWindow = new google.maps.InfoWindow();
  
  // data를 받았다면, 새로운 Data의 Marker 설정
  if(data!=null){
	  for (let i = 0; i < data['shopList'].length; i++) {
	      const marker = new google.maps.Marker({
	    	  position: {lat:data['shopList'][i]['lat'], lng:data['shopList'][i]['lng']},
	    	  map: map,
	    	  title: data['shopList'][i]['shopName'],
	      });
	      
	      marker.addListener("click", ()=> {
	    	  infoWindow.close();
	    	  infoWindow.setContent(marker.getTitle());
	    	  infoWindow.open(marker.getMap(), marker);
	    	  map.setZoom(15);
	    	  map.setCenter(marker.getPosition());
	      })
	  }
  }
}
