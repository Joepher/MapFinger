package com.mapfinger.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionFactory {
	private static ConnectionFactory connectionFactory;
	
	private Connection connection;
	private Logger logger;
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USER = "joepher";
	private static final String PASSWORD = "154844799";
	private static final String URL = "jdbc:mysql://192.168.1.101/mapfinger";
	
	private ConnectionFactory() {
		logger = LogManager.getLogger("com.logging.log");
	}
	
	public static ConnectionFactory getConnectionFactory() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		
		return connectionFactory;
	}
	
	public Connection openConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
			logger.debug("open database connection");
		} catch (Exception e) {
			connection = null;
			
			logger.error(e.getMessage());
		}
		
		return connection;
	}
	
	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				
				logger.debug("close database connection");
			} catch (SQLException e) {
				logger.error(e.getMessage());
			}
		}
	}
	
}
