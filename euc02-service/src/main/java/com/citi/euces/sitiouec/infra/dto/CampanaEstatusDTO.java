package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class CampanaEstatusDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estatus;
	
	public CampanaEstatusDTO() {}

	public CampanaEstatusDTO(String estatus) {
		super();
		this.estatus = estatus;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
}
