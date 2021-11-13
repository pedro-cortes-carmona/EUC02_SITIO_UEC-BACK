package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class AutocetesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPlazo;
	private Integer cete;
	
	public AutocetesDTO () {}
	public AutocetesDTO(Integer idPlazo, Integer cete) {
		super();
		this.idPlazo = idPlazo;
		this.cete = cete;
	}
	public Integer getIdPlazo() {
		return idPlazo;
	}
	public void setIdPlazo(Integer idPlazo) {
		this.idPlazo = idPlazo;
	}
	public Integer getCete() {
		return cete;
	}
	public void setCete(Integer cete) {
		this.cete = cete;
	}
	
	
}
