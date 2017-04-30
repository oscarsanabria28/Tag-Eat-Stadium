<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Home Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>
</head>
<style>
	.my_button{
		margin-top:12px;
		background-color: Transparent;
	    background-repeat:no-repeat;
	    border: none;
	    cursor:pointer;
	    overflow: hidden;
	    outline:none;
	    color: gray;
	}
	.my_button:hover{
		margin-top:12px;
		background-color: Transparent;
	    background-repeat:no-repeat;
	    border: none;
	    cursor:pointer;
	    overflow: hidden;
	    outline:none;
	    color: white;
	}
</style>
<script>

	$( document ).ready(function() {
		showStores();
	});

	function showCart(){
		$.ajax({
	        url: 'cart',
	        dataType: 'html',
	        success: function (data) {
	            document.getElementById("divAjax").innerHTML = data;
	        }
	    });
	}
	
	function showStores(){
		$.ajax({
	        url: 'stores',
	        dataType: 'html',
	        success: function (data) {
	            document.getElementById("divAjax").innerHTML = data;
	        }
	    });
	}

	function showProducts(){
		$.ajax({
	        url: 'products',
	        dataType: 'html',
	        success: function (data) {
	            document.getElementById("divAjax").innerHTML = data;
	        }
	    });
	}
	
	function searchProduct(id){
		$.ajax({
	        url: id,
	        dataType: 'html',
	        success: function (data) {
	            document.getElementById("divAjax").innerHTML = data;
	        }
	    });
	}
	
	function searchStoreArticles(id){
		$.ajax({
	        url: "tienda?tienda="+id,
	        dataType: 'html',
	        success: function (data) {
	            document.getElementById("divAjax").innerHTML = data;
	        }
	    });
	}

	var check = 0;

	$(document).on('submit','#editForm',function(event){
		if (check==0) {

		} else {
			event.preventDefault();
		}
	})
	
	function addProduct(id){
		var qty = $('#qty').val();
		var check = confirm("Want to add to the cart?");
		var dataToSend = 'id='+id+"&qty="+qty;
		if(check){
			$.ajax({
				type: 'post',
		        url: 'postCart',
		        data: dataToSend,
		        success: function (data) {
		        	//alert("Correctly Inserted...");
		            document.getElementById("divAjax").innerHTML = data;
		        }
		    });
		}
		
	}
	
	function pay(){
		var saldo = $('#balance').html();
		var total = $('#totalAll').html();
		//alert("total: "+total+"      saldo: "+saldo);
		if(Number(total)>Number(saldo)){
			alert("You cannot purchase more than what you have...");
		} else {
			if(confirm("Are you sure?")){
				var dataToSend = "id="+$('#userId').html()+"&pay="+total;
				$.ajax({
					type: 'post',
			        url: 'pay',
			        data: dataToSend,
			        success: function (data) {
			        	//alert("Correctly Inserted...");
			            document.getElementById("divAjax").innerHTML = data;
			        }
			    });
			}
		}
	}
	
	function remove(index){
		if(confirm("Do you want to remove from the cart?")){
			var dataToSend = "index="+index;
			$.ajax({
				type: 'post',
			    url: 'remove',
			    data: dataToSend,
			    success: function (data) {
			        document.getElementById("divAjax").innerHTML = data;
			    }
			 });
		}
	}
	
	function thing(){
		window.open("http://10.24.162.224:9081/ShopingCart/logout","_self");
	}

</script>


<body>
	<!-- wrapper -->
	<div id="wrapper" style="background-color:rgba(255, 106, 0,0.7);">
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header" onclick="showStores();">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#"><span>Welcome to ${username}</span></a>
		    </div>

		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		    <form action="postLogout" method="post">
		      <ul class="nav navbar-nav">
		        <li class="" onclick="showCart();"><a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>     Cart</a></li>
		        <li><button type="submit" class="my_button"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>     Log out</></li>
		      </ul>
		      </form>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>



		<div class="wrapper" id="divAjax" align="center">
		
	    </div><!-- /container -->

	    <footer class="footer navbar navbar-inverse">
	      <div class="container" style="padding:10px 10px 10px 10px;">
	        <p class="text-muted">Created by </p>
	      </div>
	    </footer>
	</div>
    <!-- /#wrapper -->
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

</body>
</html>