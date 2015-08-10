package com.mapfinger.server.executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mapfinger.server.bean.LocationData;
import com.mapfinger.server.db.ConnectionFactory;

public class DataPersistenceExecutor {
	private Logger logger;
	private Connection connection;
	private PreparedStatement pstmt;
	private String sql;
	
	public DataPersistenceExecutor() {
		logger = LogManager.getLogger("com.logging.log");
		connection = ConnectionFactory.getConnectionFactory().openConnection();
		sql = "insert into position (timeline,latitude,longitude,altitude,accuracy,speed,bearing,address) values (?,?,?,?,?,?,?,?)";
	}
	
	public boolean execute(LocationData locationData) {
		logger.info(locationData.toString());
		
		return persistence(locationData);
	}
	
	private boolean persistence(LocationData locationData) {
		boolean status;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, locationData.getTimeline());
			pstmt.setString(2, locationData.getLatitude());
			pstmt.setString(3, locationData.getLongitude());
			pstmt.setString(4, locationData.getAltitude());
			pstmt.setString(5, locationData.getAccuracy());
			pstmt.setString(6, locationData.getSpeed());
			pstmt.setString(7, locationData.getBearing());
			pstmt.setString(8, locationData.getAddress());
			pstmt.execute();
			
			pstmt.close();
			
			status = true;
		} catch (SQLException e) {
			status = false;
			
			logger.error(e.getMessage());
		}
		return status;
	}
}
