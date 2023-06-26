package beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import javax.xml.ws.soap.SOAPFaultException;

//import org.jboss.jbossas.quickstarts.wshelloworld.helloworld.*;

public class MonthDatesBean_webservice implements java.io.Serializable
{
   private String monthEndDate = null;
   private String monthStartDate = null;
   private String month = null;
   private String year = null;

   public MonthDatesBean_webservice() {
   }
   public String getMonthEndDate(){
	   
	  Calendar c = null;
		try {
			c = getCurrentMonthCalendarObj(); // this takes current date
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	   c.add(Calendar.MONTH, 1);  
       c.set(Calendar.DAY_OF_MONTH, 1);  
       c.add(Calendar.DATE, -1);  
	   System.out.println(c.getTime());       // this returns java.util.Date
	   DateFormat day = new SimpleDateFormat("EEEE");
	   String weekday = day.format(c.getTime());
	   DateFormat day2 = new SimpleDateFormat("dd/MM/yyyy");
	   String date = day2.format(c.getTime());
	 /*  HelloWorldService_Service helloService = new HelloWorldService_Service();
		HelloWorldService hello = helloService.getHelloWorld();
		String weekday = hello.getMonthEndDay(getMonth(), getYear());
		String date = hello.getMonthEndDate(getMonth(), getYear());*/
	   setMonthEndDate(weekday+ " "+date);
	   return monthEndDate;
   }
   public String getMonthStartDate(){
	   Calendar c = null;
		System.out.println("month Jay: "+month);
	   	try {
			c = getCurrentMonthCalendarObj(); // this takes current date
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
	   c.set(Calendar.DAY_OF_MONTH, 1);
	   System.out.println(c.getTime());       // this returns java.util.Date
	   DateFormat day = new SimpleDateFormat("EEEE");
	   String weekday = day.format(c.getTime());
	   DateFormat day2 = new SimpleDateFormat("dd/MM/yyyy");
	   String date = day2.format(c.getTime());
/*	   HelloWorldService_Service helloService = new HelloWorldService_Service();
		HelloWorldService hello = helloService.getHelloWorld();
		String weekday = hello.getMonthStartDay(getMonth(), getYear());
		String date = hello.getMonthStartDate(getMonth(), getYear());*/
	   setMonthStartDate(weekday+ " "+date);
	   return monthStartDate;
   }
   public String getMonth(){
      return month;
   }
   public String getYear(){
	      return year;
	}
   
   public void setMonthEndDate(String value){
      this.monthEndDate = value;

   }
   public void setMonthStartDate(String value){
      this.monthStartDate = value;
   }
   public void setMonth(String value){
      this.month = value;
   }
   
   public void setYear(String value){
	  this.year = value;
	}
   
	// get a calendar object referring to the month specified in parameter string
	public Calendar getCurrentMonthCalendarObj() throws Throwable{

		String dateInput = "01/"+month+"/"+year;			
		DateFormat df = new SimpleDateFormat("dd/MMMM/yyyy");
		Date startDate = df.parse(dateInput);
		Calendar c = Calendar.getInstance();   // this takes current date
	    c.setTime(startDate); // set date to specified in arguement
		return c;
	}
	
	public static void main(String [] args){
		//String monthStartDate = "Month Start Date: Friday 01/07/2016";
/*		try {
			Calendar c = getCurrentMonthCalendarObj("");
		   DateFormat day2 = new SimpleDateFormat("dd/MM/yyyy");
		   String date = day2.format(c.getTime());
			System.out.println(date);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
