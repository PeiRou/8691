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
	<style type="text/css" class="init">
	td.details-control {
		background: url('<%= request.getContextPath() %>/images/details_open.png') no-repeat center center;
		cursor: pointer;
	}
	
	tr.shown td.details-control {
		background: url('<%= request.getContextPath() %>/images/details_close.png') no-repeat center
			center;
	}
	</style>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<table id="example" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th></th>
								<th>店家名稱</th>
<!-- 								<th>負責人名稱</th> -->
<!-- 								<th>負責人電話</th> -->
<!-- 								<th>備用email</th> -->
								<th>是否啟用</th>
								<th>申請日期</th>
								<th>開通店家</th>
							</tr>
						</thead>
<!-- 						<tfoot> -->
<!-- 							<tr> -->
<!-- 								<th></th> -->
<!-- 								<th>店家名稱</th> -->
<!-- 								<th>負責人名稱</th> -->
<!-- 								<th>負責人電話</th> -->
<!-- 								<th>備用email</th> -->
<!-- 								<th>是否審核</th> -->
<!-- 								<th>申請日期</th> -->
<!-- 								<th>店家資訊</th> -->
<!-- 							</tr> -->
<!-- 						</tfoot> -->
					</table>
					<c:set value="${select}" var="VistorStaus"></c:set>
					<input id="hidVistorStaus" type="hidden" value='${VistorStaus}' />			
				</div>
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
var count = 0;
function format ( d ) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td>統一編號:</td>'+
            '<td>'+d.fein+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>地址(縣/市):</td>'+
            '<td>'+d.guarCT+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>地址(區:</td>'+
            '<td>'+d.guarAR+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>地址(路):</td>'+
            '<td>'+d.guarROAD+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>地址(號:</td>'+
            '<td>'+d.guarNO+'</td>'+
        '</tr>'+
        
        '<tr>'+
             '<td>負責人名稱:</td>'+
             '<td>'+d.conName+'</td>'+
        '</tr>'+
        '<tr>'+
             '<td>負責人電話:</td>'+
             '<td>'+d.conCel+'</td>'+
        '</tr>'+

        '<tr>'+
             '<td>備用email:</td>'+
             '<td>'+d.email2+'</td>'+
        '</tr>'+
 
    '</table>';
}
var data = $('#hidVistorStaus').val();
var prodInfo = JSON.parse(data);
$(document).ready(function() {
    var table = $('#example').DataTable( {
    	data:prodInfo,
        "columns": [
				{
				    "className":      'details-control',
				    "orderable":      false,
				    "data":           null,
				    "defaultContent": ''
				},
            	{ data: "name" },
// 	            { data: "Con_name"},
// 	            { data: "Con_cel"},
// 	            { data: "email2"},
// 	            { data: "isCheck" },
	            { data: function(prodInfo){	  
	            	var temp = '<form class="rad">';
	            	var check0,check1;
	            	if(prodInfo.sellerStatus =='1'){
	            		check0 = 'checked';
		            	check1 = '';
	            	}else if(prodInfo.sellerStatus =='2'){
	            		check0 = '';
		            	check1 = 'checked';
	            	}else{
	            		check0 = '';
		            	check1 = '';
	            	}	
	            	temp = temp.concat('<input class="rddisabled rdo1" type="radio" name="rdoisCheck" value="1" '+check0+'>不啟用');
	            	temp = temp.concat('<input class="rdVal" type="hidden" value="'+prodInfo.sellerStatus+'">');
	            	temp = temp.concat('<input class="rddisabled rdo2" type="radio" name="rdoisCheck" value="2" '+check1+'>啟用');
	            	temp = temp.concat('</form>');	  
	            	$(".rddisabled").attr('disabled', true);
	            	return temp;
	            } },
	            //{ data: "sellerSstatus" },
	            { data: "insdate" },	            
	            //{ data: "accountUID" }
// 	            { data: function(prodInfo){
// 	            	var temp = '<a class="btn btn-primary Upd">修改</a>';
// 	            	temp = temp+'<a class="btn btn-info Ok" style="display:none">確定</a>'
// 	            	return temp;
 
// 	            } }
				{ data: function(prodInfo){
	            	var url = $('#hidUpdseller').val();
	            	var temp = '<input type=hidden value="'+ prodInfo.accountUID +'">';           	
 	            	var temp = temp +'<a class="btn btn-primary Upd">修改</a>';
	            	var temp = temp +'<a class="btn btn-info Ok" style="display:none">確定</a>';	            	
	            	return temp;
	            } }
        ],
        "order": [[1, 'asc']]
    } );
     
    // Add event listener for opening and closing details
    $('#example tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
 
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );
    $('.Upd').click(function(){    	
    	if(count ==0){	    	
	    	$(this).parent().parent().find('.rddisabled').attr('disabled', false);
	    	$(this).parent().parent().find('.rad').addClass('bg-success');
	    	$(this).next().show();
	    	$(this).hide();
    	}
    	count = 1;
    });
    $('.rdo1').change(function(){
    	var temp = $(this).val();
    	$(this).next().val(temp);
    });
    $('.rdo2').change(function(){
    	var temp = $(this).val();    	
    	$(this).prev().val(temp);
    });
    $('.Ok').click(function(){
    	count = 0;    	
    	$(this).parent().parent().find('.rddisabled').attr('disabled', true);
    	var temp = $(this).parent().parent().find('.rdVal').val();
    	var serUID = $(this).prev().prev().val();
    	console.log('serUID:'+serUID);
    	setJson(temp,serUID);
    	$(this).prev().show();
    	$(this).hide();    	
    });
} );
//呼叫ajax
function setJson(jsonData,serUID) {
	var action = action;
	$.ajax({
		url : '<%= request.getContextPath() %>/_13_Maintenance/GetSeller.controller',
        type: 'get',
        dataType: 'json',
        async:true,
        data: {
        	"sellerUID": serUID,
        	"sellerStatus": jsonData},
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {   
        	if(data==1){
        		$('.rad').attr("class","rad");
        	}
        }});
}
</script>
</html>