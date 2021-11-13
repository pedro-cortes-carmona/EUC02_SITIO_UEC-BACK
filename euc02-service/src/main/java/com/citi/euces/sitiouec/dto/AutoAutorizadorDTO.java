package com.citi.euces.sitiouec.dto;

import java.util.Date;


public class AutoAutorizadorDTO {

	private String soied;

	private String soiedDivisional;

	private String soeidDistrital;

	private String dvision;

	private String distrito;

	private String nombre;

	private String inic;

	private Date fechaInicio;

	private Date fechaTermino;

	private Long alta;

	private String correo;

	private Long isCete100;

	private Long isCampesp;

	private Long idNivelAuto;
	
	public AutoAutorizadorDTO() {
		// TODO Auto-generated constructor stub
	}

	public AutoAutorizadorDTO(String soied, String soiedDivisional, String soeidDistrital, String dvision,
			String distrito, String nombre, String inic, Date fechaInicio, Date fechaTermino, Long alta, String correo,
			Long isCete100, Long isCampesp, Long idNivelAuto) {
		super();
		this.soied = soied;
		this.soiedDivisional = soiedDivisional;
		this.soeidDistrital = soeidDistrital;
		this.dvision = dvision;
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

	public String getSoied() {
		return soied;
	}

	public void setSoied(String soied) {
		this.soied = soied;
	}

	public String getSoiedDivisional() {
		return soiedDivisional;
	}

	public void setSoiedDivisional(String soiedDivisional) {
		this.soiedDivisional = soiedDivisional;
	}

	public String getSoeidDistrital() {
		return soeidDistrital;
	}

	public void setSoeidDistrital(String soeidDistrital) {
		this.soeidDistrital = soeidDistrital;
	}

	public String getDvision() {
		return dvision;
	}

	public void setDvision(String dvision) {
		this.dvision = dvision;
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

	public Long getIdNivelAuto() {
		return idNivelAuto;
	}

	public void setIdNivelAuto(Long idNivelAuto) {
		this.idNivelAuto = idNivelAuto;
	}

	@Override
	public String toString() {
		return "AutoAutorizadorDTO [soied=" + soied + ", soiedDivisional=" + soiedDivisional + ", soeidDistrital="
				+ soeidDistrital + ", dvision=" + dvision + ", distrito=" + distrito + ", nombre=" + nombre + ", inic="
				+ inic + ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + ", alta=" + alta
				+ ", correo=" + correo + ", isCete100=" + isCete100 + ", isCampesp=" + isCampesp + ", idNivelAuto="
				+ idNivelAuto + "]";
	}
	
	

}
