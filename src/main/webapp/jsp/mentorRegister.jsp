<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.example.MentorOnDemand.Model.Mentor,com.example.MentorOnDemand.Model.Skill"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Mentor Registration</title>
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
		<form:form method="GET" action="/registerMentor"
			modelAttribute="registerMentor">
			<div class="note">
				<p>Mentor Registration Form</p>
			</div>

			<div class="form-content">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<b>Enter the Mentor Name</b>
							<form:input type="text" class="form-control" path="mentorName"
								id="mentorName" placeholder="Mentor Name *" />
							<form:errors path="mentorName" class="errorColor" />
						</div>
						<div class="form-group">
							<b>Gender</b> <br>
							<!--<form:input type="text" class="form-control" path="gender" id="gender"
								placeholder="Gender *"/>-->
							<input type="radio" name="gender" path="gender" id="gender"
								value="male"> Male<br> <input type="radio"
								name="gender" path="gender" id="gender" value="female">
							Female<br> <input type="radio" name="gender" path="gender"
								id="gender" value="other"> Other<br>
							<form:errors path="gender" class="errorColor" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<b>Enter Email</b>
							<form:input type="text" class="form-control" path="email"
								id="email" placeholder=" Email *" />
							<form:errors path="email" class="errorColor" />
						</div>
						<div class="form-group">
							<b>Enter the Password</b>
							<form:input type="password" class="form-control" path="password"
								id="password" placeholder="Password *" />
							<form:errors path="password" class="errorColor" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<b>Address</b>
							<form:input type="text" class="form-control" path="address"
								id="address" placeholder=" Address*" />
							<form:errors path="address" class="errorColor" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<b>Contact Number</b>
							<form:input type="text" class="form-control" path="contactNumber"
								id="contactNumber" placeholder=" Contact Number*" />
							<form:errors path="contactNumber" class="errorColor" />
						</div>
					</div>
					<div class="col-md-6">
						<!-- <div class="form-group">
							<b>Technologies known</b>
							<form:input type="text" class="form-control" path="technology"
								id="technology" placeholder="Technology *" />
							<form:errors path="technology" class="errorColor" />
						</div> -->
						<div class="form-group">
							
								<%
									List skillDetails = (List) request.getAttribute("skillList");
										Iterator itr = skillDetails.iterator();
								%>

								<b><label class="control-label col-xs-4">Technology/Skill</label></b>


								<div class="col-xs-8">
									<form:select class="form-control" path="technology" >
										<option value="" disabled selected>Choose Technology</option>
										<%
											while (itr.hasNext()) {
														Skill skill = (Skill) itr.next();
														String skills=skill.getSkillName();
										%>
										<option value="<%=skills%> ">
											<%=skills%></option>

										<%
											}
										%>

									</form:select>
									<form:errors path="technology" cssClass="errorColor" />
								</div>
							</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<b>Experience in years</b>
							<form:input type="number" class="form-control" path="experience"
								id="experience" placeholder="Experience *" />
							<form:errors path="experience" class="errorColor" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<b>Date</b>
							<form:input type="date" class="form-control" path="date"
								id="date" placeholder="Date *" />
							<form:errors path="date" class="errorColor" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
								<b><label class="control-label col-xs-4">Choose your time Slot</label></b>
								<div class="col-xs-8">
									<form:select class="form-control" path="timeslot" >
										<option value="" disabled selected>Choose Time slot</option>
										<option value="9AM-11AM">9AM-11AM</option>
										<option value="11AM-1PM">11AM-1PM</option>
										<option value="1PM-3PM">1PM-3PM</option>
										<option value="3PM-5PM">3PM-5PM</option>
									</form:select>
									<form:errors path="timeslot" cssClass="errorColor" />
								</div>
							</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
								<b><label class="control-label col-xs-4">Status</label></b>
								<div class="col-xs-8">
									<form:select class="form-control" path="status" >
										<option value="" disabled selected>Choose Status</option>
										<option value="Assigned">Assigned</option>
										<option value="Not Assigned">Not Assigned</option>
									</form:select>
									<form:errors path="status" cssClass="errorColor" />
								</div>
							</div>
					</div>
				</div>
				<button type="submit" class="btnSubmit">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>