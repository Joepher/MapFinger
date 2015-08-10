package com.mapfinger.server.impl;

import com.mapfinger.server.bean.LocationData;

@javax.jws.WebService(
		targetNamespace = "http://impl.server.mapfinger.com/", 
		serviceName = "LocationDataParseServiceImplService", 
		portName = "LocationDataParseServiceImplPort", 
		wsdlLocation = "WEB-INF/wsdl/LocationDataParseServiceImplService.wsdl")
public class LocationDataParseServiceImplDelegate {
	
	LocationDataParseServiceImpl locationDataParseServiceImpl = new LocationDataParseServiceImpl();
	
	public int parseData(LocationData locationData) {
		return locationDataParseServiceImpl.parseData(locationData);
	}
	
}
