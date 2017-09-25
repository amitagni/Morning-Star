/**
 * 
 */
package com.ms.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.mysql.jdbc.Connection;

/**
 * @author Amit.Agnihotri
 *
 */
 @Component
public class DBUtil {
	public String DB_USER = "root";
	public String DB_PASSWORD = "123456";
	public String DB_NAME = "morningstar";
	
	
	public Connection  getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/"+DB_NAME,DB_USER, DB_PASSWORD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return connection;
	}
	
	

}
