package com.harjeet.SpringRsocket;

public class ClinicalData {
	
	private int heartrate;
	private String Bp;
	public ClinicalData(int heartrate, String bp) {
		// TODO Auto-generated constructor stub
		super();
		this.heartrate=heartrate;
		this.Bp=Bp;
	}
	public int getHeartrate() {
		return heartrate;
	}

	public void setHeartrate(int heartrate) {
		this.heartrate = heartrate;
	}

	public String getBp() {
		return Bp;
	}

	public void setBp(String bp) {
		Bp = bp;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "clinical Data :" + heartrate + "bp : " +Bp;
	} 
		
	}

