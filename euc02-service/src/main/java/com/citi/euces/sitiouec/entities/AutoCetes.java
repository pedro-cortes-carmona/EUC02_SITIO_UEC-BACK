package com.citi.euces.sitiouec.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_AUTOCETES")
public class AutoCetes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PLAZO", nullable = true)
	private Long idPlazo;
	
	@Column(name = "CETE", nullable = true)
	private Double cete;
	

	public Long getIdPlazo() {
		return idPlazo;
	}

	public void setIdPlazo(Long idPlazo) {
		this.idPlazo = idPlazo;
	}

	public Double getCete() {
		return cete;
	}

	public void setCete(Double cete) {
		this.cete = cete;
	}	

}
