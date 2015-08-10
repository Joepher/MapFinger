package com.mapfinger.server.impl;

import com.mapfinger.server.bean.LocationData;
import com.mapfinger.server.executor.LocationDataExecutor;
import com.mapfinger.server.services.LocationDataParseService;

public class LocationDataParseServiceImpl implements LocationDataParseService {
	private int status;
	private LocationDataExecutor locationDataExecutor;
	
	public LocationDataParseServiceImpl() {
		this.status = 0;
		this.locationDataExecutor = new LocationDataExecutor();
		new Thread(locationDataExecutor).start();
	}
	
	public int parseData(LocationData locationData) {
		if (locationData != null) {
			// deal with json data
			if (locationDataExecutor.execute(locationData)) {
				status = PARSE_SUCCESSED;
			} else {
				status = PARSE_FAILED;
			}
		} else {
			status = PARSE_FAILED;
		}
		
		return status;
	}
}
