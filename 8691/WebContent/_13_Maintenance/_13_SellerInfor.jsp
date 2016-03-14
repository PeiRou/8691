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

    <title>8691管理中心</title>

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
    
    <link rel="apple-touch-icon" href="<%= request.getContextPath() %>/images/logo.png">
	<link rel="icon" href="<%= request.getContextPath() %>/images/logo.png">    
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
								<th>統一編號</th>
								<th>店家名稱</th>
								<th>電話</th>
								<th>地址(縣/市)</th>
								<th>地址(區)</th>
								<th>地址(路)</th>
								<th>地址(號)</th>
								<th>聯絡人</th>
								<th>聯絡人手機</th>
								<th>收款方式</th>
								<th>是否為合作店家</th>
								<th>運費</th>
								<th>最低金額</th>
							</tr>
						</thead>
						<tbody style="text-align: left;" class="customer-font">
						</tbody>
					</table>
					<c:set value="${select}" var="VistorStaus"></c:set>
					<input id="hidVistorStaus" type="hidden" value='${VistorStaus}' />
				</div>
				<input class="btn btn-primary text-center" type="button" value="看更多店家" onclick="location.href='<%= request.getContextPath() %>/_13_Maintenance/GetSeller.controller'">
			</div>			
		</div>
	</div>
	
	
	<!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Your Website 2016</p>
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
	//var data = '[{"guarNO":"6號2樓","lowestPrice":"10","receiptsMetho":"3","sellerStatus":"2","conName":"50blue","fein":"88888888","shipPrice":"100","guarCT":"臺北市","guarAR":"100","email2":"50@50.com","conCel":"0912345678","name":"50嵐","sellerPhoto":null,"tel":"098777","guarROAD":"1000","insdate":"2016-03-02"}]';
	var prodInfo = JSON.parse(data);
	
	$('#vistorTable').DataTable({
		data:prodInfo,
		columns: 
			[
	            { data: "fein"},
				{ data: "name"},
				{ data: "tel"},
				{ data: "guarCT"},
				{ data: "guarAR"},
				{ data: "guarROAD"},
				{ data: "guarNO"},
				{ data: "conName"},
				{ data: "conCel"},
				//{ data: "receiptsMetho"},
				{ data: function(prodInfo){
					var receiptsMetho = parseInt(prodInfo.receiptsMetho);
					var temp;
					switch(receiptsMetho) {
				    case 0:				        
				    	temp = "貨到付款";
				    	break;
				    case 1:				        
				    	temp = "信用卡";
				    	break;
				    case 3:
				    	temp = "都有";
				    	break;
				    default:
				    	temp = "啊!錯了";
				    	break;
				    }
					var temphtml = ' '+temp+'</a>';
					return temphtml;
				}},
				
// 				{ data: function(prodInfo){
// 					var sellerStatus = parseInt(prodInfo.sellerStatus);
// 					var temp1;
// 					console.log("sellerStatus:"+sellerStatus);
// 					switch(sellerStatus) {
// 				    case 0:				        
// 				    	temp1 = "未審核";
// 				    	break;
// 				    case 1:				        
// 				    	temp1 = "未啟用";
// 				    	break;
// 				    case 2:				        
// 				    	temp1 = "啟用";
// 				    	break;
// 				    default:
// 				    	temp1 = "啊!錯了";
// 				    	break;
// 				    }
// 					var temphtml = ''+temp1+'</a>';
// 					return temphtml;
// 				}},
				
				{ data: function(prodInfo){	  
	            	var temp = '<form>';
	            	var check1,check2;
	            	if(prodInfo.sellerStatus == '0'){
		            	check1 = '';
		            	check2 = '';
	            	}else if(prodInfo.sellerStatus == '1'){
		            	check1 = 'checked';
		            	check2 = '';
	            	}else if(prodInfo.sellerStatus == '2'){
	            		check0 = '';
		            	check1 = '';
		            	check2 = 'checked';
	            		
	            	}	
	            	temp = temp.concat('<input type="radio" name="rdoisCheck" value="1" '+check1+'>未啟用');
	            	temp = temp.concat('<input type="radio" name="rdoisCheck" value="2" '+check2+'>啟用');
	            	temp = temp.concat('</form>');
	            	//$(":input").attr('disabled', true);
	            	return temp;
	            } },

				{ data: "shipPrice"},
				{ data: "lowestPrice"},            
	        ],
	});
		
});	



</script>



</html>