<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header Page</title>
</head>
<body>
	<div class="navbar-header">
    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        	<span class="sr-only">Toggle navigation</span>
        	<span class="icon-bar"></span>
        	<span class="icon-bar"></span>
        	<span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index">Scheduler</a>
	</div>
	<!-- /.navbar-header -->
    <ul class="nav navbar-top-links navbar-right">
    	<li class="dropdown">
        	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
            	<i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
			</a>
            <ul class="dropdown-menu dropdown-messages"></ul>
            <!-- /.dropdown-messages -->
        </li>
        <!-- /.dropdown -->
        <li class="dropdown">
        	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
            	<i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-tasks"></ul>
            <!-- /.dropdown-tasks -->
        </li>
        <!-- /.dropdown -->
        <li class="dropdown">
        	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
        		<i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
        	</a>
        	<ul class="dropdown-menu dropdown-alerts"></ul>
        	<!-- /.dropdown-alerts -->
        </li>
        <!-- /.dropdown -->
        <li class="dropdown">
        	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
        		<i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        	</a>
        	<ul class="dropdown-menu dropdown-user">
        		<li><a href="#"><i class="fa fa-user fa-fw"></i>User Profile</a></li>
        		<li><a href="#"><i class="fa fa-gear fa-fw"></i>Settings</a></li>
        		<li class="divider"></li>
        		<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>Logout</a></li>
        	</ul>
        	<!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
	</ul>
    <!-- /.navbar-top-links -->
</body>
</html>