package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class CampanaTipoAutoriDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String campana;
	
	public CampanaTipoAutoriDTO() {}

	public CampanaTipoAutoriDTO(String campana) {
		super();
		this.campana = campana;
	}

	public String getCampana() {
		return campana;
	}

	public void setCampana(String campana) {
		this.campana = campana;
	}
	
	
}
