package com.citi.euces.sitiouec.dto;

public class AutoCetesDTO {

	private Long idPlazo;

	private Double cete;

	
	public AutoCetesDTO() {
		// TODO Auto-generated constructor stub
	}

	public Double getCete() {
		return cete;
	}

	public void setCete(Double cete) {
		this.cete = cete;
	}

	public Long getIdPlazo() {
		return idPlazo;
	}

	public void setIdPlazo(Long idPlazo) {
		this.idPlazo = idPlazo;
	}

	@Override
	public String toString() {
		return "AutoCetesDTO [idPlazo=" + idPlazo + ", cete=" + cete + "]";
	}

}
