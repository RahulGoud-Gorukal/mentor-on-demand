<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.example.MentorOnDemand.Model.Mentor,com.example.MentorOnDemand.Model.Skill"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-image: url("./image/mentor.png");
	background-size: cover;
	background-color: #efefef;
}
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
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
		</ul>
		<%-- <form:form class="form-inline my-2 my-lg-0" action="/search" modelAttribute="searchMentor">
      <form:input class="form-control mr-sm-2" type="text" placeholder="Search" path="technology" value="" id="technology"/>
      
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form:form> --%>
		<form:form class="form-inline my-2 my-lg-0" action="/search"
			modelAttribute="searchMentor">
			<ul>
				<li class="nav-item dropdown">
					<div class="form-group">

						<%
									List skillDetails = (List) request.getAttribute("skillList");
										Iterator itr = skillDetails.iterator();
								%>
						<div class="col-xs-8">
							<form:select class="form-control" path="technology">
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
				</li>
			</ul>
			<pre>  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button></pre>
		</form:form>

	</div>
	</nav>
</body>
</html>