<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sidebar Page</title>
<link rel="stylesheet" href="css/scheduler/scheduler.css">
</head>
<body>
	<!-- Navigation -->
	 <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	 	<jsp:include page="header.jsp" />
		<div class="navbar-default sidebar" role="navigation">
	    	<div class="sidebar-nav navbar-collapse">
	        	<ul class="nav" id="side-menu">
	            	<li class="sidebar-search">
	                	<div class="input-group custom-search-form">
	                    	<input type="text" class="form-control" placeholder="Search...">
	                        <span class="input-group-btn">
	                        	<button class="btn btn-default" type="button">
	                        		<i class="fa fa-search"></i>
	                        	</button>
	                        </span>
	                    </div>
	                    <!-- /input-group -->
	                </li>
	                <li>
	                	<a href="index"><i class="fa fa-dashboard fa-fw"></i><span class="margin-left-5">Dashboard</span></a>
	                </li>
	                <li>
                    	<a href="#"><i class="fa fa-clock-o"></i><span class="margin-left-5">Scheduling</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                        	<li>
                            	<a data-href="jobgroup" class="linkclick jobgroup"><i class="fa fa-clock-o"></i><span class="margin-left-5">Job Group</span></a>
                            </li>
                            <li>
                            	<a data-href="jobschedule" class="linkclick jobschedule"><i class="fa fa-clock-o"></i><span class="margin-left-5">Job Scheduling</span></a>
                            </li>
						</ul>
                        <!-- /.nav-second-level -->
					</li>
					<li>
                    	<a href="#"><i class="fa fa-clock-o"></i><span class="margin-left-5">View Scheduled Jobs</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                        	<li>
                            	<a data-href="scheduledmasterjob" class="linkclick scheduledmasterjob"><i class="fa fa-clock-o"></i><span class="margin-left-5">View Scheduled Master Jobs</span></a>
                            </li>
                            <li>
                            	<a data-href="scheduledjobs" class="linkclick scheduledjobs"><i class="fa fa-clock-o"></i><span class="margin-left-5">View Scheduled Jobs</span></a>
                            </li>
						</ul>
                        <!-- /.nav-second-level -->
					</li>
	            </ul>
	    	</div>
	    	<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side -->
	</nav>
</body>
</html>