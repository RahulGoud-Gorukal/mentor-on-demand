<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.example.MentorOnDemand.Model.Mentor"%>
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
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 8px;
}

#back tr {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: black;
	color: white;
}

table, td, th {
	border: 1px solid #ddd;
	text-align: left;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 15px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Displaying mentors</title>
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
	</div>
	</nav>
	<%
List mentorList = (List) request.getAttribute("mentorList");
	System.out.println(session.getAttribute("userName"));
if(!mentorList.isEmpty())
{
%>

	<div style="overflow-x: auto;">
		<table>
			<tr id="back">
				<td><b>Mentor Code</b></td>
				<td><b>Mentor name</b></td>
				<td><b>Technology</b></td>
				<td><b>Email</b></td>
				<td><b>Gender</b></td>
				<td><b>Contact Number</b></td>
				<td><b>Experience in years</b></td>
				<td><b>Time Slot</b></td>
				<td><b>Status</b></td>
				<%if (session.getAttribute("userName")!=null)
				{
				%>
				<td><b>Request for training</b></td>
				<%} %>

			</tr>

			<%
			for (int i = 0; i < mentorList.size(); i++) {
				Mentor m = (Mentor) mentorList.get(i);
		%>
			<tr>
				<td><%=m.getMentorId()%></td>
				<td><%=m.getMentorName()%></td>
				<td><%=m.getTechnology()%></td>
				<td><%=m.getEmail()%></td>
				<td><%=m.getGender()%></td>
				<td><%=m.getContactNumber()%></td>
				<td><%=m.getExperience()%></td>
				<td><%=m.getTimeslot()%></td>
				<td><%=m.getStatus()%></td>
				<%if (session.getAttribute("userName")!=null)
				{
				%>
				<td><a href="requestMentor?mid=<%=m.getMentorId()%>">Request</a></td>
				<%} %>



			</tr>
			<%}%>

		</table>
		<%}  else{%>
		<h4 align="center">No mentors available</h4>
		<% }%>
	
</body>
</html>