package com.harjeet.SpringRsocket;

public class Patient {

	private String fname;
	private String lname;
	private String ssn;

	public Patient(String fname, String lname, String ssn){
		//super();
		this.fname=fname;
		this.lname=lname;
		this.ssn=ssn;
		
	}
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLsname(String lname) {
		this.lname = lname;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Patient [firstName="+fname+",lastName=" + lname +"SSN=" + ssn + "]";
	} 
}
