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
					<c:when test="${not empty jobScheduler && jobScheduler == 'jobgroup'}">
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
	                    			<label>(<span class="mandat">*</span>) Job Group Name :</label>
	                        		<input class="form-control" name="jobGroupName" id="jobGroupName" placeholder="Enter Job Group Name">
	                    		</div>
							</div>							
						</div>
						<div class="row">
							<div class="col-lg-12">
								<input type="button" class="btn btn-primary jobscheduler jobgroup" value="submit"/>
							</div>							
						</div>
					</c:when>
					<c:when test="${not empty jobScheduler && jobScheduler == 'jobschedule'}">
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
	                    			<label>(<span class="mandat">*</span>) Job Group Name :</label>
	                        		<select name="jobGroupName" id="jobGroupName" class="form-control">
										<option value="select">--select--</option>
									</select>
	                    		</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
	                    			<label>(<span class="mandat">*</span>) Job Name :</label>
	                        		<input class="form-control" name="jobName" id="jobName" placeholder="Enter Job Name">
	                    		</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
	                    			<label>(<span class="mandat">*</span>) Schedule On :</label>
		                    		<div class="checkbox">
		                    			<label><input class="scheduleOn" type="checkbox" value="Mon"> Mon</label>
		                    			<label><input class="scheduleOn" type="checkbox" value="Tue"> Tue</label>
		                    			<label><input class="scheduleOn" type="checkbox" value="Wed"> Wed</label>
		                    			<label><input class="scheduleOn" type="checkbox" value="Thu"> Thu</label>
		                    			<label><input class="scheduleOn" type="checkbox" value="Fri"> Fri</label>
		                    			<label><input class="scheduleOn" type="checkbox" value="Sat"> Sat</label>
		                    			<label><input class="scheduleOn" type="checkbox" value="Sun"> Sun</label>
		                    		</div>
	                    		</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
	                    			<label>(<span class="mandat">*</span>) Schedule At :</label>
	                    			<div class="row">
	                    				<div class="col-lg-4">
	                    					<label>(<span class="mandat">*</span>) HH (0-24)</label>
	                    					<select name="hour" id="hour" class="form-control">
												<option value="00">00</option>
											</select>
	                    				</div>
	                    				<div class="col-lg-4">
	                    					<label>(<span class="mandat">*</span>) MM (0-60)</label>
	                    					<select name="minutes" id="minutes" class="form-control">
												<option value="00">00</option>
											</select>
	                    				</div>
	                    				<div class="col-lg-4">
	                    					<label>(<span class="mandat">*</span>) SS (0-60)</label>
	                    					<select name="seconds" id="seconds" class="form-control">
												<option value="00">00</option>
											</select>
	                    				</div>
	                    			</div>		               
	                    		</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
	                    			<label>Dependent Job Name :</label>
	                        		<input class="form-control" name="dependentjobName" id="dependentjobName" placeholder="Enter Dependent Job Name">
	                    		</div>
							</div>
							<div class="col-lg-3">
								<div class="form-group">
	                    			<label>Critical Job :</label>
		                    		<div class="checkbox">
		                    			<label><input name="isCritical" id="isCritical" type="checkbox"></label>
		                    		</div>
	                    		</div>
							</div>
							<div class="col-lg-3">
								<div class="form-group">
	                    			<label>Skip Job :</label>
		                    		<div class="checkbox">
		                    			<label><input name="isSkip" id="isSkip" type="checkbox"></label>
		                    		</div>
	                    		</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
	                    			<label>(<span class="mandat">*</span>) Inbound Queue :</label>
	                        		<input class="form-control" name="inboundQueue" id="inboundQueue" placeholder="Enter Inbound Queue">
	                    		</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
	                    			<label>(<span class="mandat">*</span>) Outbound Queue :</label>
	                        		<input class="form-control" name="outboundQueue" id="outboundQueue" placeholder="Enter Outbound Queue">
	                    		</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<input type="button" class="btn btn-primary jobscheduler jobschedule" value="submit"/>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<h1>Other page request....</h1>
					</c:otherwise>
				</c:choose>
				<input type="hidden" name="requestFor" id="requestFor" value="${jobScheduler}"/>
			</form>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="js/scheduler/jobscheduler.js"></script>
</html>