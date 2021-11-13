package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class BoletinesRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estatus;
	private Integer enfoque;
	private String fechaInicial;
	private String fechaFinal;
	private Integer reporte; 
	
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Integer getEnfoque() {
		return enfoque;
	}
	public void setEnfoque(Integer enfoque) {
		this.enfoque = enfoque;
	}
	public String getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Integer getReporte() {
		return reporte;
	}
	public void setReporte(Integer reporte) {
		this.reporte = reporte;
	}
	
	
}
