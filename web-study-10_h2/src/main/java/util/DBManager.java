package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		String url = null;
		String uid = null;
		String pass = null;
		
		try {
		 url = "jdbc:h2:mem:testdb";
		 uid = "sa";
		 pass = "";
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection(url,uid,pass);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	} //end get Connection
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null ) conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt != null) stmt.close();
			if(conn != null ) conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

