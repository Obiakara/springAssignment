package com.softwareHomework.model;

public class PostRequestBody {
	
	private String address;
	private String zip;
	private String city;
	private String state;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return String.format("PostRequestBody [address=%s, zip=%s, city=%s, state=%s]", address, zip, city, state);
	}
	
	
	

}
