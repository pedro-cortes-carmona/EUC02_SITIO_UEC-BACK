package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class AutRegionalesRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String autRegion;
	private String division;
	
	public AutRegionalesRequest() {}
	
	public AutRegionalesRequest(String autRegion, String division) {
		super();
		this.autRegion = autRegion;
		this.division = division;
	}

	public String getAutRegion() {
		return autRegion;
	}

	public void setAutRegion(String autRegion) {
		this.autRegion = autRegion;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
	
	
	
}
