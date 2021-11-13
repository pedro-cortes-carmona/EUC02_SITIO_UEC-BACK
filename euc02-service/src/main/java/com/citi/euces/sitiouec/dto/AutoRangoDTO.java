package com.citi.euces.sitiouec.dto;

import java.io.Serializable;

public class AutoRangoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String idRango;
	
	private String rangoMin;
	
	private String rangoMax;
	
	private String milDosMilQuin;
	
	private String dosMilCincoMil;
	
	private String cincoMilSieteMil;
	
	private String sieteMilDiezMil;
	
	private String diezMilVeinteMil;

	private String veinteMilDoscientoMil;
	
	private String fecha;
	
	private String fechaFin;
	

	public AutoRangoDTO() {
		
	}


	public AutoRangoDTO(String idRango, String rangoMin, String rangoMax, String milDosMilQuin, String dosMilCincoMil,
			String cincoMilSieteMil, String sieteMilDiezMil, String diezMilVeinteMil, String veinteMilDoscientoMil,
			String fecha, String fechaFin) {
		super();
		this.idRango = idRango;
		this.rangoMin = rangoMin;
		this.rangoMax = rangoMax;
		this.milDosMilQuin = milDosMilQuin;
		this.dosMilCincoMil = dosMilCincoMil;
		this.cincoMilSieteMil = cincoMilSieteMil;
		this.sieteMilDiezMil = sieteMilDiezMil;
		this.diezMilVeinteMil = diezMilVeinteMil;
		this.veinteMilDoscientoMil = veinteMilDoscientoMil;
		this.fecha = fecha;
		this.fechaFin = fechaFin;
	}


	public String getIdRango() {
		return idRango;
	}


	public void setIdRango(String idRango) {
		this.idRango = idRango;
	}


	public String getRangoMin() {
		return rangoMin;
	}


	public void setRangoMin(String rangoMin) {
		this.rangoMin = rangoMin;
	}


	public String getRangoMax() {
		return rangoMax;
	}


	public void setRangoMax(String rangoMax) {
		this.rangoMax = rangoMax;
	}


	public String getMilDosMilQuin() {
		return milDosMilQuin;
	}


	public void setMilDosMilQuin(String milDosMilQuin) {
		this.milDosMilQuin = milDosMilQuin;
	}


	public String getDosMilCincoMil() {
		return dosMilCincoMil;
	}


	public void setDosMilCincoMil(String dosMilCincoMil) {
		this.dosMilCincoMil = dosMilCincoMil;
	}


	public String getCincoMilSieteMil() {
		return cincoMilSieteMil;
	}


	public void setCincoMilSieteMil(String cincoMilSieteMil) {
		this.cincoMilSieteMil = cincoMilSieteMil;
	}


	public String getSieteMilDiezMil() {
		return sieteMilDiezMil;
	}


	public void setSieteMilDiezMil(String sieteMilDiezMil) {
		this.sieteMilDiezMil = sieteMilDiezMil;
	}


	public String getDiezMilVeinteMil() {
		return diezMilVeinteMil;
	}


	public void setDiezMilVeinteMil(String diezMilVeinteMil) {
		this.diezMilVeinteMil = diezMilVeinteMil;
	}


	public String getVeinteMilDoscientoMil() {
		return veinteMilDoscientoMil;
	}


	public void setVeinteMilDoscientoMil(String veinteMilDoscientoMil) {
		this.veinteMilDoscientoMil = veinteMilDoscientoMil;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	
	
			

}
