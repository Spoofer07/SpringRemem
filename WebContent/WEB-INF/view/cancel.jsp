<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href = "<spring:url value="/res/css/cancel.css" />" >
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My main</title>
	</head>
	<body>
		<h1>What's that? You want to cancel now?!</h1>

		<h2>But why did you book in the first place?!</h2>

		<div class="mainWrapper">


  		<!-- ==========================================!! -->
  		<div>
  			<div class = "menuBut"><a href="/SpringRemem/home.html"><button>HOME</button></a></div>
  			<div class = "menuBut"><a href="/SpringRemem/reservations.html/empty"><button>Reservations</button></a></div>
  			<div class = "menuBut"><a href="/SpringRemem/cancel.html"><button>Cancel Reservations</button></a></div>
  		</div>
  		<!-- ==========================================ii -->
  		<h2>${hiberMsg}</h2>

		<div class="content">
			<p>${ok}</p>
			<p id="nameErr">${nameError}</p>
			 <table class="tableContent">
				 <tr>
		 			<th>Room Name</th>
		 			<th>Reserved</th>
		 		</tr>
			 	<c:forEach items="${ceva}" var="item" >
		 		<tr>
		 			<td>${item.reservRoomId}</td>
		 			<td>${item.reservBool}</td>
		 			<td><a href="/SpringRemem/cancel.html/${item.reservId}"><button id="cancelBut">Cancel</button></a></td>
		 		</tr>
			 	</c:forEach>
			 </table>
		</div>

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
