package com.mapfinger.server.bean;

import java.io.Serializable;

public class LocationData implements Serializable {
	private static final long serialVersionUID = -3934946217773971464L;
	
	private String timeline;
	private String latitude;
	private String longitude;
	private String altitude;
	private String accuracy;
	private String speed;
	private String bearing;
	private String address;
	
	public LocationData() {}
	
	public String getTimeline() {
		return timeline;
	}
	
	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getAltitude() {
		return altitude;
	}
	
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	
	public String getAccuracy() {
		return accuracy;
	}
	
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	
	public String getSpeed() {
		return speed;
	}
	
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	public String getBearing() {
		return bearing;
	}
	
	public void setBearing(String bearing) {
		this.bearing = bearing;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "LocationData [timeline=" + timeline + ", latitude=" + latitude + ", longitude="
				+ longitude + ", altitude=" + altitude + ", accuracy=" + accuracy + ", speed=" + speed
				+ ", bearing=" + bearing + ", address=" + address + "]";
	}
	
}
