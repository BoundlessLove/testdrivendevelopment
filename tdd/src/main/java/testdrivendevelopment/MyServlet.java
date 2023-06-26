package testdrivendevelopment;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.VerifyRecaptcha;

//import testdrivendevelopment.LogicLayer;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at2: ").append(request.getContextPath());
		LogicLayer logic = new LogicLayer();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("usernameTF");
		String password = request.getParameter("passwordTF");
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		boolean captchaOK = verifyCaptcha(gRecaptchaResponse);
		HttpSession session = request.getSession(true);
		System.out.println("User=" + username + "::password=" + password + "::Captcha Verify "+captchaOK);
		if (!captchaOK){
			printPage(out,"<label id=\"welcomeMSG\" for=\"username\"> Captcha failed. Please go back login and re-enter captcha.</label>");			
		 }else{
			 if(inputValidatedForSQLInjection(username, password)){ 
					if (credentialsExist(logic,username,password)){
						//printPage(out,"<label id=\"welcomeMSG\" for=\"username\">Welcome "+ username+"</label>");
						session.setAttribute("username", username);
						session.setAttribute("month", calculateMonth());
						session.setAttribute("year", calculateYear());
						//session.setAttribute("monthYear", calculateMonth()+" "+calculateYear());
						response.sendRedirect("nextpage.jsp");
					}else{
						printPage(out,"<label id=\"welcomeMSG\" for=\"username\">Sorry, invalid credentials</label>");
					}
			    }else{
					printPage(out,"<label id=\"welcomeMSG\" for=\"username\">SQL injection suspected</label>");
			    	//out.println("<label id=\"welcomeMSG\" for=\"username\"> Sorry, invalid credentials</label>");
			    }
		 }


	}

	protected void printPage(PrintWriter out, String errormsg){
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
				+ "Transitional//EN\">\n");
		 out.println("<HTML>"); 
	     out.println("<TITLE>Web Calendar Home</TITLE>"); 
	     out.println("<BODY>");
	     out.println("<h1> Web Calendar Homepage</h1>"); 
	     out.println(errormsg);
		out.println("<br>");
		out.println("<br> <a href=\"hello.jsp\" target=\"_top\">back</a> to login page");	
		out.println("<br> <a href=\"detail2.html\" target=\"_top\">click</a> for details on automation used");	
		out.println("<br> <a href=\"integration.html\" target=\"_top\">click</a> for details on Web Services Integration used");	
		out.println("<br> <a href=\"cicd.html\" target=\"_top\">click</a> for details on Continuous integration using Jenkins");	
		out.println("<br>");
		out.println("<br>©Jay Sarna 2016");
		out.println("</BODY>");	
		out.println("</HTML>");
	     out.println("</BODY>");	
	     out.println("</HTML>");

	}
	
	protected boolean credentialsExist(LogicLayer logic, String username, String password){
		
		if(logic.thisUserExists(username, password)){
			return true;	
		}else{
			return false;
		}
			
	}	

	protected boolean verifyCaptcha(String gRecaptchaResponse) throws IOException{
		System.out.println(gRecaptchaResponse);
		boolean verify;
		try{
			verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		}catch(Exception e){
			e.printStackTrace();
			verify = false;
			return verify;
		}
		return verify;
	}

	// ensure input does not contain chars "=" or ";". These are used for sql injection.
	protected boolean inputValidatedForSQLInjection(String username, String password){
		
		if (username.contains("=") || username.contains(";") || password.contains("=") || password.contains(";") ) {
			return false;	
		}else{
			return true;
		}
	}	

		protected  String calculateMonth(){
		   Calendar c = Calendar.getInstance();   // this takes current date
		    c.set(Calendar.DAY_OF_MONTH, 1);
		    System.out.println(c.getTime());       // this returns java.util.Date
		    DateFormat day = new SimpleDateFormat("MMMM");
		    return day.format(c.getTime());
		}
		
		protected  String calculateYear(){
		   Calendar c = Calendar.getInstance();   // this takes current date
		    c.set(Calendar.DAY_OF_MONTH, 1);
		    System.out.println(c.getTime());       // this returns java.util.Date
		    DateFormat day = new SimpleDateFormat("yyyy");
		    return day.format(c.getTime());
		}
	
	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}