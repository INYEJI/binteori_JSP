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
		 url = "jdbc:oracle:thin:@localhost:1521:xe";
		 uid = "hr";
		 pass = "hr";
		Class.forName("oracle.jdbc.driver.OracleDriver");
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

