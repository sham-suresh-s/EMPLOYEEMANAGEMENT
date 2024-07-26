package com.tnsif.mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_connection {
	private static final String url = "jdbc:mysql://localhost:3306/EMPLOYEEMANAGEMENTDB";
	private static final String userName = "root";
	private static final String password = "Techguysham";
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, userName, password);
	}

}
