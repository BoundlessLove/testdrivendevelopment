package testdrivendevelopment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LogicLayer {
	public ConnectionMySql dbcon;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public LogicLayer(){
		
		dbcon = new ConnectionMySql();
	}
	
	public String[] getAllUserIDs(){
		
		try{
		ResultSet rs1 = dbcon.RunQuery("Select count(*) from User");
		if (rs1 !=null && rs1.next()){
			String[] al = new String[rs1.getInt(1)];
			rs1.close();
			ResultSet rs2 = dbcon.RunQuery("Select * from User");
			if (rs2 !=null && rs2.next()){
				for(int i = 0; i<al.length; i++){
					al[i] = rs2.getString("UserID");
					rs2.next();
				}
			}
			return al;
		}
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
	
	public boolean thisUserExists(String username, String password) {
		
	/* 	try{
		String query = 	"Select * from Credentials where UserName =\""+username+"\" and Password=\""+password+"\"";
		ResultSet rs1 = dbcon.RunQuery(query);
			if (rs1 !=null && rs1.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
	*/
	try {

		URL url = new URL("https://database-microservice.azurewebsites.net/credentials/"+username);//your url i.e fetch data from .
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP Error code : "
					+ conn.getResponseCode());
		}
		InputStreamReader in = new InputStreamReader(conn.getInputStream());
		BufferedReader br = new BufferedReader(in);
		String output;
		//output = <String>br.lines();
		//System.out.println(output);
		StringBuffer sb = new StringBuffer();
		//while ((output = br.read) != null) {
		while ((output = br.readLine()) != null) {
				//System.out.println(output);
				sb.append(output);
		}
		conn.disconnect();
		System.out.println("--------------------------------------");
		System.out.println(sb.toString());
		System.out.println("--------------------------------------");
	
		if ((sb.toString() != null) &&(sb.toString().contains(password))){
			System.out.println("---Said login successful");
			return true;
		}else{
			return false;
		}

	} catch (Exception e) {
		System.out.println("unable to query data: " +e.getMessage());
		//throw new Exception ("unable to query data" +e.getMessage());
		return false;
	}

	}
}
