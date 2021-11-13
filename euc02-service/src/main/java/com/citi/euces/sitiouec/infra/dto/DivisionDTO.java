package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class DivisionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String division;
	
	public DivisionDTO() {}
	
	public DivisionDTO(String division) {
		super();
		this.division = division;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
	
	
	
}
