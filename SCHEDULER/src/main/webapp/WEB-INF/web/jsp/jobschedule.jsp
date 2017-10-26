<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Schedule</title>
</head>
<body>
<div class="panel panel-default">
	<div class="panel-body">
		<div id="jobschedule">
			<form id="jobschedulerform">
				<c:choose>
					<c:when test="${not empty jobgroup && jobgroup == 'jobgroup'}">
						<div class="form-group">
	                    	<label>(<span class="mandat">*</span>) Job Group Name :</label>
	                        <input class="form-control" name="jobGroupName" id="jobGroupName" placeholder="Enter Job Group Name">
	                     </div>
	                     <input type="button" class="btn btn-primary jobscheduler jobgroup" value="submit"/>
					</c:when>
					<c:when test="${not empty jobschedule && jobschedule == 'jobschedule'}">
						<input type="button" class="btn btn-primary jobscheduler jobschedule" value="submit"/>
					</c:when>
					<c:otherwise>
						<h1>Other page request....</h1>
					</c:otherwise>
				</c:choose>
				<input type="hidden" name="requestFor" value="${jobgroup}"/>
			</form>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="js/scheduler/jobscheduler.js"></script>
</html>