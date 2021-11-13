package com.citi.euces.sitiouec.dto;

/**
 * 
 * @author cesar.alducin
 * 
 *         DTO - CeteBE
 *
 */
public class CetePaginaDTO {

	private Double plazo;

	private Double tasa;
	
	private String variacion;

	public CetePaginaDTO() {
		// TODO Auto-generated constructor stub
	}

	public CetePaginaDTO(Double plazo, Double tasa) {
		super();
		this.plazo = plazo;
		this.tasa = tasa;
	}
	
	
	public CetePaginaDTO(Double plazo, Double tasa, String variacion) {
		super();
		this.plazo = plazo;
		this.tasa = tasa;
		this.variacion = variacion;
	}

	public String getVariacion() {
		return variacion;
	}
	
	public void setVariacion(String variacion) {
		this.variacion = variacion;
	}

	public Double getPlazo() {
		return plazo;
	}

	public void setPlazo(Double plazo) {
		this.plazo = plazo;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	@Override
	public String toString() {
		return "CetePaginaDTO [plazo=" + plazo + ", tasa=" + tasa + "]";
	}

}
