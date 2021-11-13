package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class DivisionesRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String region;
	private String autDivisionales;
	
	public DivisionesRequest() {}
	
	public DivisionesRequest(String region, String autDivisionales) {
		super();
		this.region = region;
		this.autDivisionales = autDivisionales;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAutDivisionales() {
		return autDivisionales;
	}

	public void setAutDivisionales(String autDivisionales) {
		this.autDivisionales = autDivisionales;
	}
	
	
	
}
