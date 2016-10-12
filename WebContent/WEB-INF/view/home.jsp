<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href = "<spring:url value="/res/css/home.css" />" >
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My main</title>
	</head>
	<body>
		<h1>Guess what? You just reached the MAIN.</h1>

		<h2>What now?!</h2>
		<div class="mainWrapper">


  		<!-- ==========================================!! -->
  		<div>
  			<div class = "menuBut"><a href="/SpringRemem/home.html"><button>HOME</button></a></div>
  			<div class = "menuBut"><a href="/SpringRemem/reservations.html/empty"><button>Reservations</button></a></div>
  			<div class = "menuBut"><a href="/SpringRemem/cancel.html"><button>Cancel Reservations</button></a></div>
  		</div>
  		<!-- ==========================================ii -->
  		

  		<a href="/SpringRemem/logout.html">
  			<button>
  				Get outta here!
  			</button>
  		</a>

  		<a href="/SpringRemem/test.html">
  			<button>
  				Hibernate test
  			</button>
  		</a>
		</div>
	</body>
</html>
