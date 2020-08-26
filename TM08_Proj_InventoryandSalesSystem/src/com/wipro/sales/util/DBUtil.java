package com.wipro.sales.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getDBConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		return con;
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getClass());
			return null;
		}
		catch(SQLException se) {
			System.out.println(se.getClass());		
			return null;
		}
	}
	
}
