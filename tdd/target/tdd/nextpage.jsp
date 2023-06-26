<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <!-- errorPage="error.jsp"%>-->
    
 <%@ page import="java.util.Properties"%> 
 <%@ page import="beans.*" %>
 <%@ page import="java.lang.*" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Calendar Home</title>
</head>
<body>
<%
if (session.getAttribute("username") == null){
	response.sendRedirect("hello.jsp");
}
%>
<h1> Web Calendar Homepage</h1>
<label id="welcomeMSG" for="username">Welcome <% out.print( session.getAttribute("username"));%></label>
<jsp:useBean id="monthDates" 
                    class="beans.MonthDatesBean"> 
   <jsp:setProperty name="monthDates" property="month" 
                    value='<%=session.getAttribute("month")%>'/>
   <jsp:setProperty name="monthDates" property="year" 
                    value='<%=session.getAttribute("year")%>'/>
</jsp:useBean>

<p><label id="CurrentMonth">Current Month: 
   <jsp:getProperty name="monthDates" property="month"/></label>
   <label id="CurrentMonth"> and Current Year: 
   <jsp:getProperty name="monthDates" property="year"/></label>
</p>
<p><label id="MonthStartDate">Month Start Date: <font color=blue>
   <jsp:getProperty name="monthDates" property="monthStartDate"/></font></label>
</p>
<p><label id="MonthEndDate">Month End Date: <font color=blue>
   <jsp:getProperty name="monthDates" property="monthEndDate"/></font></label>
</p>
<p></p>
<form name="displaymonth" action="DisplayMonth" method="get">
<br>To view the starting weekday and ending weekday for a different Month, please select month and year below:</h3> 
<br>
<br> Select a month: 
<select id="monthlist" name="monthlist">
   <option value="January">January</option>
   <option value="February">February</option>
   <option value="March">March</option>
   <option value="April">April</option>
   <option value="May">May</option>
   <option value="June">June</option>
   <option value="July">July</option>
   <option value="August">August</option>
   <option value="September">September</option>
   <option value="October">October</option>
   <option value="November">November</option>
   <option value="December">December</option>
</select> 
<br>
<br> Select a year: 
<select id="yearlist" name="yearlist">
   <option value="2019">2019</option>
   <option value="2020">2020</option>
   <option value="2021">2021</option>
</select> 
 <br><li> <input type="submit" ID="submit" value="Get Month Dates and weekdays" /></li>
</form> 
<form name="logout" action="Logout" method="get">
 <br><input type="submit" ID="Logout" value="Logout" onclick="Logout" />
 </form>
<br>
<h5> For details on Automation used, please click <a href="detail2.html" target="_top">here</a> </h5>
<h5> For details on Web Services Integration used, please click <a href="integration.html" target="_top">here</a> </h5>
<h5> For details of Continuous integration using Jenkins implemented, please click <a href="cicd.html" target="_top">here</a> </h5>
<br>�Jay Sarna 2019
</body>
</html>