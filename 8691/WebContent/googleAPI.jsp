<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script src="http://maps.google.com/maps/api/js?sensor=false&language=zh_TW" type="text/javascript"></script> -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.20&sensor=false"></script>
<title>Insert title here</title>
</head>
<body>
<div id="map" style="width: 600px; height: 400px;"></div>
<script type="text/javascript">
var locations = [
  ['<a href="https://tw.yahoo.com/">王家刀削麵</a>', 25.032970, 121.545906, 3],  //彈跳訊息可以自行輸入
  ['<a href="">八方雲集</a>', 25.032159, 121.546165, 2],
  ['<a href="">50嵐</a>', 25.034621, 121.546173, 1]
];

var map = new google.maps.Map(document.getElementById('map'), {
  zoom: 16,
  center: new google.maps.LatLng(25.032970, 121.545906),
  mapTypeId: google.maps.MapTypeId.ROADMAP
});

var infowindow = new google.maps.InfoWindow();

var marker, i;
for (i = 0; i < locations.length; i++) {  
  marker = new google.maps.Marker({
    position: new google.maps.LatLng(locations[i][1], locations[i][2]),
    title: locations[i][0],
    zIndex: locations[i][3],
    map: map
  });
  google.maps.event.addListener(marker, 'click', (function(marker, i) {
    return function() {
      infowindow.setContent(locations[i][0]);
      infowindow.open(map, marker);
    }
  })(marker, i));
}
</script>

</body>
</html>