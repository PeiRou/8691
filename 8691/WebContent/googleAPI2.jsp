<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head runat="server">
    <title>內嵌Google地圖</title>
    <script src='http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.2.js'></script>   
    <script src="https://maps.google.com/maps/api/js?sensor=false&language=zh-TW"></script>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
     <style> 
         body,input { font-size: 9pt; } 
         html { height: 100% }   
         body { height: 100%; margin: 0px; padding: 0px }   
         #map_canvas { height: 100% } 
                
     </style> 
    <script>
        $(function () {
            //定義經緯度位置: 大安路一段
//             var fiftyBlue = new google.maps.LatLng(25.034621, 121.546173); //50藍
//             var eight = new google.maps.LatLng(25.032159, 121.546165);//八方雲集
//             var wangBlade = new google.maps.LatLng(25.032970, 121.545906);//王家刀切麵店
            var iii = new google.maps.LatLng(25.033772, 121.543393);//王家刀切麵店
            
            //設定地圖參數
            var mapOptions = {
                zoom: 15, //初始放大倍數
                center: iii, //中心點所在位置
                mapTypeId: google.maps.MapTypeId.ROADMAP //正常2D道路模式
            };
            //在指定DOM元素中嵌入地圖
            var map = new google.maps.Map(
                document.getElementById("map_canvas"), mapOptions);
            //加入標示點(Marker)
            var marker = new google.maps.Marker({
                position: iii, //經緯度
                title: "資策會", //顯示文字
                map: map //指定要放置的地圖對象
            });
//             var marker = new google.maps.Marker({
//                 position: eight, //經緯度
//                 title: "八方雲集", //顯示文字
//                 map: map //指定要放置的地圖對象
//             });
//             var marker = new google.maps.Marker({
//                 position: wangBlade, //經緯度
//                 title: "王家刀切麵店", //顯示文字
//                 map: map //指定要放置的地圖對象
//             });
        });
        
        google.maps.event.addDomListener(window, 'load', initialize);  //網頁載入之後才進行繪製
    </script>
</head>
<body >
<div id="map_canvas" style="width:700px; height:400px"></div>
</body>
</html>