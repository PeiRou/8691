<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>About - Business Casual - Start Bootstrap Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
	
    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">
    
    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    
    <!-- jquery.css -->
    
    <link href="<%= request.getContextPath() %>/css/jquery.dataTable.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/css/jquery-ui/jquery-ui.min.css" rel="stylesheet">    
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<table id="vistorTable"
						class="table table-striped table-hover dataTable" cellspacing="0">
						<thead>
							<tr class="customer-font">
								<th>店家名稱</th>
								<th>是否審核</th>
								<th>店家狀態</th>
								<th>申請日期</th>
								<th>店家資訊</th>
							</tr>
						</thead>
						<tbody style="text-align: left;" class="customer-font">
						</tbody>
					</table>
					<c:set value="${select}" var="VistorStaus"></c:set>
					<input id="hidVistorStaus" type="hidden" value='${VistorStaus}' />
					
					<c:url value="/_13_Maintenance/GetSellerDetail.controller" var="sellerpath"></c:url>
					<c:set value="${sellerpath}" var="sellerdetail"></c:set>
					<input id="hidsellerdetail" type="hidden" value='${sellerdetail}' />
				</div>
			</div>			
		</div>
	</div>
	<!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; EEIT83第五小組 2016 | <a href="<%= request.getContextPath() %>/contact.jsp">聯絡我們</a></p>
                </div>
            </div>
        </div>
    </footer>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
    
    <!-- Json -->
    <script src="<%= request.getContextPath() %>/js/json.js"></script>
    
    <!-- jQuery -->    
    <script src="<%= request.getContextPath() %>/js/jquery.js"></script>
    <script src="<%= request.getContextPath() %>/js/jquery.dataTable.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/jquery-ui.min.js"></script>
</body>
<script type="text/javascript">
$(document).ready(function() {

	var data = $('#hidVistorStaus').val();	
	//var data = '[{"isCheck":"0","sellerSstatus":"1","name":"玖壹壹","insdate":"2016-03-07","accountUID":"4DDF4A66-2618-4A89-BB32-01BB25E36E2B"},{"isCheck":"1","sellerSstatus":"0","name":"willy wang","insdate":"2016-03-07","accountUID":"A04712B3-A15A-4448-AF9E-27E40BB6733A"},{"isCheck":"0","sellerSstatus":"0","name":"大隻老","insdate":"2016-03-07","accountUID":"A6105F1F-80A1-459C-B5D3-420BCDBED06A"},{"isCheck":"1","sellerSstatus":"0","name":"1111","insdate":"2016-03-07","accountUID":"399115CA-CF2F-48D7-AE37-4288E8E55F6A"},{"isCheck":"0","sellerSstatus":"0","name":"玖壹壹","insdate":"2016-03-07","accountUID":"61C16B60-CB5A-4548-A4B7-584E8E6F2807"},{"isCheck":"0","sellerSstatus":"0","name":"測試","insdate":"2016-03-07","accountUID":"0E23A738-497E-4DBC-83B8-7109260A52FA"},{"isCheck":"0","sellerSstatus":"0","name":"000","insdate":"2016-03-07","accountUID":"1A91A662-869A-4EFA-9DC2-BD519AD8C710"},{"isCheck":"0","sellerSstatus":"0","name":"1111","insdate":"2016-03-07","accountUID":"00B12767-B318-499B-9A14-CD5E9D5A9F13"},{"isCheck":"0","sellerSstatus":"0","name":"1111","insdate":"2016-03-07","accountUID":"359FD003-1052-481F-9BD2-DE90E1F60329"},{"isCheck":"0","sellerSstatus":"0","name":"willy wang","insdate":"2016-03-07","accountUID":"8B1459F0-4C4E-481F-87A5-F3855C6BE256"}]';

	var prodInfo = JSON.parse(data);

	$('#vistorTable').DataTable({
		data:prodInfo,
		columns: 
			[
	            { data: "name" },
	            //{ data: "isCheck" },
	            { data: function(prodInfo){	  
	            	var temp = '<form>';
	            	var check0,check1;
	            	if(prodInfo.isCheck =='0'){
	            		check0 = 'checked';
		            	check1 = '';
	            	}else{
	            		check0 = '';
		            	check1 = 'checked';
	            	}	            	
	            	temp = temp.concat('<input type="radio" name="rdoisCheck" value="0" '+check0+'>未審核');
	            	temp = temp.concat('<input type="radio" name="rdoisCheck" value="1" '+check1+'>已審核');
	            	temp = temp.concat('</form>');	  
	            	$(":input").attr('disabled', true);
	            	return temp;
	            } },
	            { data: "sellerSstatus" },
	            { data: "insdate" },	            
	            //{ data: "accountUID" }
	            { data: function(prodInfo){
	            	var url = $('#hidsellerdetail').val();
	            	var acc = prodInfo.accountUID;
	            	console.log(acc);
	            	var temp = '<a class="btn btn-primary" href="'+url+'?sellerUID='+ acc +'">按我看店家資訊</a>';	            	
	            	return temp;
	            }
	            }
	        ],
	});
		
});	


</script>
</html>