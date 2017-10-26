<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- css -->
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="css/sb-admin/sb-admin-2.min.css">
<link rel="stylesheet" href="css/sb-admin/metisMenu.min.css">
<link rel="stylesheet" href="css/bootstrap/font-awesome.min.css">
<title>Index Page</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="navigations.jsp" />
        <jsp:include page="dashboard.jsp" />
	</div>
</body>
<!-- scripts -->
<script type="text/javascript" src="js/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="js/sb-admin/sb-admin-2.js"></script>
<script type="text/javascript" src="js/sb-admin/metisMenu.min.js"></script>
<script type="text/javascript" src="js/scheduler/schedulerutil.js"></script>
<script type="text/javascript" src="js/scheduler/constants.js"></script>
<script type="text/javascript" src="js/scheduler/scheduler.js"></script>
<!-- PNotify -->
<script type="text/javascript" src="js/notify/pnotify.core.js"></script>
<script type="text/javascript" src="js/notify/pnotify.buttons.js"></script>
<script type="text/javascript" src="js/notify/pnotify.nonblock.js"></script>
</html>