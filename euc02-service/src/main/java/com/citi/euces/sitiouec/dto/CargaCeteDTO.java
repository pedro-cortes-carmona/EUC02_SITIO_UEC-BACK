package com.citi.euces.sitiouec.dto;


public class CargaCeteDTO{
	
	public Long idRango;
	
	public String periodo;
	
	
	public String milDosMilQuin;
	
	public String fechaIni;
	
	public String fechaFin;
	

	public CargaCeteDTO() {
		super();
	}


	public CargaCeteDTO(Long idRango, String periodo, String milDosMilQuin, String fechaIni, String fechaFin) {
		super();
		this.idRango = idRango;
		this.periodo = periodo;
		this.milDosMilQuin = milDosMilQuin;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
	}

	public Long getIdRango() {
		return idRango;
	}


	public void setIdRango(Long idRango) {
		this.idRango = idRango;
	}


	public String getPeriodo() {
		return periodo;
	}


	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}


	public String getMilDosMilQuin() {
		return milDosMilQuin;
	}


	public void setMilDosMilQuin(String milDosMilQuin) {
		this.milDosMilQuin = milDosMilQuin;
	}


	public String getFechaIni() {
		return fechaIni;
	}


	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	

}
