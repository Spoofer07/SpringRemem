<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
	<head>
    <link rel="stylesheet" type="text/css" href = "<spring:url value="/res/css/login.css" /> ">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Log In</title>
	</head>
	<body>
    <div class="mainWrapper">

	    <div class="theTitle">
        <h1>How about some login</h1>
      </div>

  		<div class"theError">
        <h2>${noLogin}</h2>
      </div>

      <div class="loginBox">
    		<form:errors path="user1.*" />
    		<form action="/SpringRemem/submitForm.html" method = "post">
    			<input type="text" name="user" />
    			<input type="password" name="pass" />
    			<input type="submit">
    		</form>
      </div>

    </div>
	</body>
</html>
