<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Code</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>
	<!-- wrapper -->
	<div id="wrapper" style="background-color:rgba(255, 106, 0,0.7);">
		<nav class="navbar navbar-inverse" style="height: 10%;">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Shopping Cart</a>
		    </div>
		</nav>

		<div class="container" align="center" style="height: 80%;">
			<div class="col-md-6 col-md-offset-3">
				<div class="jumbotron">
					<div class="card card-container">
			            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
			            <p id="profile-name" class="profile-name-card"></p>
			            <form class="form-signin" action="postStart" method="POST">
			            	<p>${shittymessage}</p>
			                <span id="reauth-email" class="reauth-email"></span>
			                <input type="password" id="password" name="password" class="form-control" placeholder="Código" required style="margin-bottom:5px">
			                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Ingresar</button>
			            </form><!-- /form -->
			        </div><!-- /card-container -->
				</div>
			</div>
	    </div><!-- /container -->

	    <footer class="footer navbar navbar-inverse" style="height: 10%;">
	      <div class="container" style="padding:10px 10px 10px 10px;">
	        <p class="text-muted">Created by </p>
	      </div>
	    </footer>
	</div>
    <!-- /#wrapper -->
</body>
</html>