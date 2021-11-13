package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.List;

public class BusquedaCampanaResumenDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ResumenCampanaDTO> campanaResumen;
	
	public BusquedaCampanaResumenDTO() {}
	
	public BusquedaCampanaResumenDTO(List<ResumenCampanaDTO> campanaResumen) {
		super();
		this.campanaResumen = campanaResumen;
	}

	public List<ResumenCampanaDTO> getCampanaResumen() {
		return campanaResumen;
	}

	public void setCampanaResumen(List<ResumenCampanaDTO> campanaResumen) {
		this.campanaResumen = campanaResumen;
	}
	
	
	
	
}
