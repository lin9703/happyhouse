// Initialize and add the map
function initMap() {
  // The location of 적선동
  const jeokseondong = { lat: 37.5745573, lng: 126.9739195 };
  const zoom = 15;
  // The map, centered at 적선동
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom,
    center: jeokseondong,
    minZoom : zoom - 2,
    maxZoom : zoom + 3,
  });
  // The marker, positioned at 적선동
  const marker = new google.maps.Marker({
    position: jeokseondong,
    map: map,
  });
}