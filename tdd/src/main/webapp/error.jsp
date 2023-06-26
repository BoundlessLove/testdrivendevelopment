<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Error Page</title>
</head>
<body>
<% if(response.getStatus() == 500){ %>
<p><font color="red"><strong>PAGE COULD NOT BE DISPLAYED. APOLOGISE FOR THE INCONVENIENCE.</strong> 
<br>The SOAP web service connected to this application 
takes time to load, when used first time after a long time,
therefore please try login one more time after one minute.</font></p>

<%-- include login page --%>
<%@ include file="hello.jsp"%>
<%}else {%>
<br>Hi There, error code is <%=response.getStatus() %>
<br><font color="red">Error: <%=exception.getMessage() %></font>
<br>Please go to <a href="hello.jsp">home page</a>
<%} %>
</body>

</html>