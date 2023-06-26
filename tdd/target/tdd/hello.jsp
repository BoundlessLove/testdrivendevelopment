<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- saved from url=(0014)about:internet -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
 <%@ page import="java.util.Properties"%>

<title>Test Driven development</title>
<script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
<h2>Web Calendar Login - a sample "JAVA, TOMCAT and MYSQL" application developed in redhat cloud to demonstrate DevOps in action</h2>
<hr>
<h3>Please use sample credentials below to sign in:-</h3>
<br>Username: joshwilliams 
<br>Password: Password1
<hr>
<br>
<h3> SIGN IN: </h3>
<form name="login" action="MyServlet" method="get" onSubmit="return validateMyForm();">
	<u1>
		<br><label for="username">Username: </label>
		<input type="text" ID="usernameTF" name="usernameTF" placeholder="enter username" required>
		<br><label for="password">Password: </label>
		<input type="password" ID="passwordTF" name="passwordTF" placeholder="enter password" required> 
		<br>
		<br>
       <div class="g-recaptcha"
            data-sitekey="6LffHyETAAAAAN-vHjs7KCoSVEWAArUEkcsRSLyS" required></div>
		<br><input type="submit" ID="submit" value="Send" />
	</u1>
</form>

<font color="red"><p id="demo"></p></font>

<!-- preventing sql injection -->
<script "text/javascript">
function validateMyForm() {
	var usrnm, pswd, text;
	
	var usrnm = document.getElementById("usernameTF").value;
	var pswd = document.getElementById("passwordTF").value;
	if (usrnm.contains("=") || usrnm.contains(";") ||pswd.contains("=") || pswd.contains(";") ) {
        
		text = "Error: Input not valid";
		document.getElementById("demo").innerHTML = text;
		return false;	
    	
	}
	text = "Input valid"; 
	document.getElementById("demo").innerHTML = text;
	return true;
}
</script>

<br>
<hr>
<h3> Documentation regarding evidence of Automation, Integration with a Web Service and Continuous Integration performed on this sample application:</h3>
<h5> 1. For details on Automation used, please click <a href="detail2.html" target="_top">here</a> </h5>
<h5> 2. For details on SOAP Web Services Integration used, please click <a href="integration.html" target="_top">here</a> </h5>
<h5> 3. For details of Continuous integration using Jenkins implemented, please click <a href="cicd.html" target="_top">here</a> </h5>
<hr>
<br>�Sarna, J 2019
<br> Author is Alumni of Software Engineering, University of Auckland, New Zealand
<br>
<h3> References</h3>
<br> 1. Reddy, C.S. (2015), Jenkins Tutorial - Part03: Git Integration & Configuring jobs using GIT, Source: https://www.youtube.com/watch?v=ISAUsBSI8G0
<br> 2. ..
<br> More coming....
</body>
</html>