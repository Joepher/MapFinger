package com.mapfinger.server.test;

import com.mapfinger.server.bean.LocationData;
import com.mapfinger.server.impl.LocationDataParseServiceImpl;
import com.mapfinger.server.services.LocationDataParseService;

public class LocationDataParseServiceTest {
	
	public static void main(String[] args) {
		LocationData locationData = new LocationData();
		LocationDataParseService locationDataParseService = new LocationDataParseServiceImpl();
		
		locationData.setTimeline("2015-05-11 20:20:20");
		locationData.setLatitude("23.051655");
		locationData.setLongitude("113.413152");
		locationData.setAltitude("15.2");
		locationData.setAccuracy("67.97523");
		locationData.setSpeed("12.0315");
		locationData.setBearing("105.5");
		locationData.setAddress("广东省广州市番禺区大学城穗石大道");
		
		int status = locationDataParseService.parseData(locationData);
		
		System.out.println(status);
	}
	
}
