<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*,com.example.MentorOnDemand.Model.ProposalRequest"
	pageEncoding="ISO-8859-1"%>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Proposals</title>
<style>
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
#back tr{
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color:black;
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
tr:nth-child(even){background-color: #f2f2f2}
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
				<li class="nav-item"><a class="nav-link" href="/mentorList">Book a mentor</a></li>
				<li class="nav-item"><a class="nav-link" href="/userNotify">Notification!</a></li>
		</div>
		</nav>

	</ul>
	<br>
	<br>
	<%
		List acceptanceList = (List) request.getAttribute("acceptanceList");
	%>

<div style="overflow-x:auto;">
	<table>
		<tr id="back">
			<td><b>Proposal ID</b></td>
			<td><b>Mentor ID</b></td>
			<td><b>Mentor Name</b></td>
		</tr>

		<%
			for (int i = 0; i < acceptanceList.size(); i++) {
				ProposalRequest e = (ProposalRequest) acceptanceList.get(i);
		%>
		<tr>
			<td><%=e.getProposalId()%></td>
			<td><%=e.getMentorId()%></td>
			<td><%=e.getMentorName()%></td>
</tr>
		<% }%>

	</table>
</div>

</body>
</html>