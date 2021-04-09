// Initialize and add the map
function initMap(data) {
	if(data != null){
		console.log("initmap")
		console.log(data);
	}
  // The location of 적선동(init) or 조회하려는 법정동
  // 광화문 입구 : { lat: 37.57571, lng: 126.97672 }
  const dong = {lat: 37.5490523468649, lng:127.154504078866 };
  const zoom = 15;
  // The map, centered at 적선동
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom,
    center: dong,
    minZoom : zoom - 2,
    maxZoom : zoom + 3,
  });
  // The marker, positioned at 적선동
  const marker = new google.maps.Marker({
    position: dong,
    map: map,
  });
  
  const infoWindow = new google.maps.InfoWindow();
  
  if(data!=null){
	  for (let i = 0; i < data.length; i++) {
	      const marker = new google.maps.Marker({
	    	  position: {lat:data[i]['lat'], lng:data[i]['lng']},
	    	  map: map,
	    	  title: data[i]['shopName'],
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
