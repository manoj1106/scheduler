<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="css/scheduler/login.css">
</head>
<body>
	<c:choose>
		<c:when test="${not empty error}">
			<div class="error"><h2>${error}!</h2></div>
		</c:when>
		<c:when test="${empty username}">
			<div class="error"><h1>HTTP Status 403 - Access is denied</h1></div>
			<h2>You do not have permission to access this page!</h2>
		</c:when>
		<c:otherwise>
			<div class="error"><h1>HTTP Status 403 - Access is denied</h1></div>
			<h2>Username : ${username} <br/>You do not have permission to access this page!</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>