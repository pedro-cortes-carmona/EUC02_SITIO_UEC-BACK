package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class CatCampanaDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String campanaID;
	private String campanaDesc;
	
	public CatCampanaDTO() {}
	
	public CatCampanaDTO(String campanaID, String campanaDesc) {
		super();
		this.campanaID = campanaID;
		this.campanaDesc = campanaDesc;
	}

	public String getCampanaID() {
		return campanaID;
	}

	public void setCampanaID(String campanaID) {
		this.campanaID = campanaID;
	}

	public String getCampanaDesc() {
		return campanaDesc;
	}

	public void setCampanaDesc(String campanaDesc) {
		this.campanaDesc = campanaDesc;
	}
	
	
	
}
