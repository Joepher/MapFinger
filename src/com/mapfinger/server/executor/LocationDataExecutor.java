package com.mapfinger.server.executor;

import java.util.Vector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mapfinger.server.bean.LocationData;

public class LocationDataExecutor implements Runnable {
	private Logger logger;
	private LocationData dataToPersistence;
	private Vector<LocationData> dataQueue;
	private DataPersistenceExecutor dataPersistenceExecutor;
	
	private static final int EXECUTE_LONG_DURATION = 8000;
	private static final int EXECUTE_MIDDLE_DURATION = 5000;
	private static final int EXECUTE_SHORT_DURATION = 2000;
	
	public LocationDataExecutor() {
		this.logger = LogManager.getLogger("com.logging.error");
		this.dataToPersistence = new LocationData();
		this.dataQueue = new Vector<LocationData>();
		this.dataPersistenceExecutor = new DataPersistenceExecutor();
	}
	
	public void run() {
		operateLocationData();
	}
	
	public boolean execute(LocationData locationData) {
		synchronized (dataQueue) {
			dataQueue.add(locationData);
			dataQueue.notifyAll();
		}
		
		return true;
	}
	
	private void operateLocationData() {
		while (true) {
			synchronized (dataQueue) {
				if (dataQueue.size() > 0) {
					dataToPersistence = dataQueue.remove(0);
				} else {
					dataToPersistence = null;
				}
			}
			
			if (dataToPersistence != null) {
				if (dataPersistenceExecutor.execute(dataToPersistence)) {
					waitToReparseTillTimeOut();
				} else {
					synchronized (dataQueue) {
						dataQueue.add(0, dataToPersistence);
						
						waitToReparseTillTimeOut();
					}
				}
			} else {
				waitToReparseTillTimeOut();
			}
		}
	}
	
	private void waitToReparseTillTimeOut() {
		synchronized (dataQueue) {
			try {
				if (dataQueue.size() > 20) {
					dataQueue.wait(EXECUTE_SHORT_DURATION);
				} else if (dataQueue.size() > 10) {
					dataQueue.wait(EXECUTE_MIDDLE_DURATION);
				} else {
					dataQueue.wait(EXECUTE_LONG_DURATION);
				}
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
	}
	
}
