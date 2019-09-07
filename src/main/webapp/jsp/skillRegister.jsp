<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Skill Registration</title>
<style>
.note {
	text-align: center;
	height: 80px;
	background: -webkit-linear-gradient(left, #0072ff, #8811c5);
	color: #fff;
	font-weight: bold;
	line-height: 80px;
}

.form-content {
	padding: 5%;
	border: 1px solid #ced4da;
	margin-bottom: 2%;
}

.form-control {
	border-radius: 1.5rem;
}

.btnSubmit {
	border: none;
	border-radius: 1.5rem;
	padding: 1%;
	width: 20%;
	cursor: pointer;
	background: #0062cc;
	color: #fff;
}

.errorColor {
	color: red;
}
</style>
</head>
<body>
<ul>
		<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
		class="navbar-brand" href="#">Mentor On Demand</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Register </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="/createAdminPage">Admin</a> <a
						class="dropdown-item" href="/createMentorPage">Mentor</a> <a
						class="dropdown-item" href="/createUserPage">User</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Login </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="/loginAdminPage">Admin</a> <a
						class="dropdown-item" href="/loginMentorPage">Mentor</a> <a
						class="dropdown-item" href="/loginUserPage">User</a>
				</div></li>
		
	</div>
	</nav>
	
	</ul>
	<br>
	<br>
	<div class="container register-form">
		<form:form method="GET" action="/registerSkill"
			modelAttribute="registerSkill">
			<div class="note">
				<p>Skill Registration Form</p>
			</div>

			<div class="form-content">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<b>Enter Skill Name</b>
							<form:input type="text" class="form-control" path="skillName"
								id="skillName" placeholder="Skill Name *" />
							<form:errors path="skillName" class="errorColor" />
						</div>
					</div>
					
					<div class="col-md-6">
						<div class="form-group">
							<b>Fees</b>
							<form:input type="number" class="form-control" path="fees"
								id="fees" placeholder=" Fees *" />
							<form:errors path="fees" class="errorColor" />
						</div>
					</div>
				</div>
				<button type="submit" class="btnSubmit">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>