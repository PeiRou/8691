<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>visitor page</title>
</head>

<body>

	<h1>店家會員</h1>

	<form name="Visitor"
		action="<c:url value='/page/partner.controller' />" method="post">

		<table>
			<tr>
				<td>輸入您的店家名稱 :</td>
				<td><input type="text" name="name" value="${param.name}"></td>
				<td>${error.name}</td>
			</tr>
			<tr>
				<td>輸入您的統一編號 :</td>
				<td><input type="text" name="FEIN" value="${param.FEIN}"></td>
				<td></td>
			</tr>
		</table>
		
			<table>
		    <tr height='36'>
		    <td>輸入您的店家圖片:</td>
		        <td width="45" align="right" class="title_font">圖片</td>
		        <td colspan="3">
		            <input style="background:#FFFFFF" class='InputClass'  type="file" 
		            name="uploadFile" size="40" />    
		    </tr>
			</table>
			
			<table>
			<tr>
				<td>輸入您的帳號/email :</td>
				<td><input type="text" name="acc_email"
					value="${param.acc_email}"></td>
				<td>${error.acc_email}</td>
			</tr>
			<tr>
				<td>輸入您的密碼 :</td>
				<td><input type="text" name="psd" value="${param.psd}"></td>
				<td>${error.psd}</td>
			</tr>
			<tr>
				<td>輸入您的連絡市話  :</td>
				<td><input type="text" name="phone" value="${param.tel}"></td>
				<td>${error.tel}</td>
			</tr>
			<tr>
				<td>住址(縣/市) : </td>
				<td><input type="text" name="GUAR_CT" value="${param.GUAR_CT}"></td>
				<td>${error.GUAR_CT}</td>
			</tr>
			<tr>
				<td>住址(區/鄉/鎮/市) : </td>
				<td><input type="text" name="GUAR_AR" value="${param.GUAR_AR}"></td>
				<td>${error.GUAR_AR}</td>
			</tr>
				<tr>
				<td>住址(路/街/巷) : </td>
				<td><input type="text" name="GUAR_ROAD" value="${param.GUAR_ROAD}"></td>
				<td>${error.GUAR_ROAD}</td>
			</tr>
				<tr>
				<td>住址(號) : </td>
				<td><input type="text" name="GUAR_NO" value="${param.GUAR_NO}"></td>
				<td>${error.GUAR_NO}</td>
			</tr>
			
			<tr>
				<td>輸入聯絡人姓名 :</td>
				<td><input type="text" name="Con_name" value="${param.name}"></td>
				<td>${error.name}</td>
			</tr>
			<tr>
				<td>輸入連絡人手機 :</td>
				<td><input type="text" name="Con_cel"
					value="${param.Con_cel}"></td>
				<td>${error.Con_cel}</td>
			</tr>
				<tr>
				<td>收款方式 : </td>
				<td>	
				<select name="receipts_metho" value="${param.receipts_metho}">
		      <option value="" selected>請選擇</option>
		        <option value="0">貨到付款</option>
		        <option value="1">信用卡付款</option>
		        <option value="3">都有使用</option></select>
		        </td>
				<td>${error.receipts_metho}</td>
				</tr>
			<tr>
				<td>是否有主食 : </td>
				<td>	
				<select name="IS_Food_Staple" value="${param.IS_Food_Staple}">
				<option value="" selected>請選擇</option>
		        <option value="0">無</option>
		        <option value="1">有</option></select>
		        </td>
				<td>${error.IS_Food_Staple}</td>
			</tr>
			<tr>
				<td>是否有飲料 : </td>
				<td>	
				<select name="IS_Food_Drink" value="${param.IS_Food_Drink}">
				<option value="" selected>請選擇</option>
		        <option value="0">無</option>
		        <option value="1">有</option></select>
		        </td>
				<td>${error.IS_Food_Drink}</td>
			</tr>
			<tr>	
				<td align="right"><input type="submit" value="儲存"></td>
			</tr>
		</table>
	</form>

</body>
</html>