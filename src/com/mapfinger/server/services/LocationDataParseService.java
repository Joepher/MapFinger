package com.mapfinger.server.services;

import com.mapfinger.server.bean.LocationData;

public interface LocationDataParseService {
	public static final int PARSE_SUCCESSED = 101;
	public static final int PARSE_FAILED = 102;
	
	public int parseData(LocationData locationData);
}
