package com.citi.euces.sitiouec.dto;

import java.sql.Date;

public class BuscarWebDTO {
	
	private String soeid;
	
	private String division;
	
	private String soeidDivisional;
	
	private String distrito;
	
	private String nombre;
	
	private String inic;
	
	private Date fechaInicio;
	
	private Date fechaTermino;
	
	private String fechaInicioString;
	
	private String fechaTerminoString;
	
	private Long alta;
	
	private String correo;
	
	private Long isCete100;
	
	private Long isCampesp;
	
	private Long idNivelAuto;
	
	
	
	public BuscarWebDTO() {
		
	}

	public BuscarWebDTO(String soeid, String division, String soeidDivisional, String distrito, String nombre,
			String inic, Date fechaInicio, Date fechaTermino, Long alta, String correo, Long isCete100, Long isCampesp,
			Long idNivelAuto) {
		super();
		this.soeid = soeid;
		this.division = division;
		this.soeidDivisional = soeidDivisional;
		this.distrito = distrito;
		this.nombre = nombre;
		this.inic = inic;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.alta = alta;
		this.correo = correo;
		this.isCete100 = isCete100;
		this.isCampesp = isCampesp;
		this.idNivelAuto = idNivelAuto;
	}


	public String getSoeid() {
		return soeid;
	}



	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}



	public String getDivision() {
		return division;
	}



	public void setDivision(String division) {
		this.division = division;
	}



	public String getSoeidDivisional() {
		return soeidDivisional;
	}



	public void setSoeidDivisional(String soeidDivisional) {
		this.soeidDivisional = soeidDivisional;
	}



	public String getDistrito() {
		return distrito;
	}



	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getInic() {
		return inic;
	}



	public void setInic(String inic) {
		this.inic = inic;
	}



	public Date getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public Date getFechaTermino() {
		return fechaTermino;
	}



	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}



	public Long getAlta() {
		return alta;
	}



	public void setAlta(Long alta) {
		this.alta = alta;
	}



	public Long getIdNivelAuto() {
		return idNivelAuto;
	}



	public void setIdNivelAuto(Long idNivelAuto) {
		this.idNivelAuto = idNivelAuto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	public Long getIsCete100() {
		return isCete100;
	}

	public void setIsCete100(Long isCete100) {
		this.isCete100 = isCete100;
	}

	public Long getIsCampesp() {
		return isCampesp;
	}

	public void setIsCampesp(Long isCampesp) {
		this.isCampesp = isCampesp;
	}

	public String getFechaInicioString() {
		return fechaInicioString;
	}

	public void setFechaInicioString(String fechaInicioString) {
		this.fechaInicioString = fechaInicioString;
	}

	public String getFechaTerminoString() {
		return fechaTerminoString;
	}

	public void setFechaTerminoString(String fechaTerminoString) {
		this.fechaTerminoString = fechaTerminoString;
	}

	@Override
	public String toString() {
		return "BuscarWebDTO [soeid=" + soeid + ", division=" + division + ", soeidDivisional=" + soeidDivisional
				+ ", distrito=" + distrito + ", nombre=" + nombre + ", inic=" + inic + ", fechaInicio=" + fechaInicio
				+ ", fechaTermino=" + fechaTermino + ", alta=" + alta + ", correo=" + correo + ", isCete100="
				+ isCete100 + ", isCampesp=" + isCampesp + ", idNivelAuto=" + idNivelAuto + "]";
	}

	

}
