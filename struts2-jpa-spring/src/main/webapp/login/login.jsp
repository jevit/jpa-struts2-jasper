<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/login.css" media="screen" />
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
	<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Lato:400,700,300" />
</head>
 
<body>
	<div class="page-header">
	  <h1>Homework <small> Struts 2 / JPA / Spring </small></h1>
	</div>
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign in to continue </h1>
            <div class="account-wall">
                <img class="profile-img" src="../image/system-users-3.png" alt="">
                <form class="form-signin">
					<s:textfield key="global.username" name="username" cssClass="form-control" placeholder="Email" />
					<s:password key="global.password" name="password" cssClass="form-control" placeholder="Password"/>
	                <s:submit cssClass="btn btn-lg btn-primary btn-block" key="global.submit" value="Sign in" name="submit"/>
	                <label >
						<s:checkbox label=" Remember me" name="checkboxField1" value="aBoolean" fieldValue="false" cssClass="checkbox pull-left"/>
	                </label>
	                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="#" class="text-center new-account">Create an account </a>
        </div>
    </div>
</body>
</html>