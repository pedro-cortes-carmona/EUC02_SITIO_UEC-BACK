package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class AutDivisionales implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String region;
	
	public AutDivisionales() {}
	
	public AutDivisionales(String region) {
		super();
		this.region = region;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
}
