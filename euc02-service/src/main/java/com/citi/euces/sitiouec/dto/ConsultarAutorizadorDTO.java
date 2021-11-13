package com.citi.euces.sitiouec.dto;

import java.sql.Date;

public class ConsultarAutorizadorDTO {
	
	private String soeid;
	
	private String soeidDivisional;
	
	private String soeidDistrital;
	
	private String division;
	
	private String distrito;
	
	private String nombre;
	
	private String inic;
	
	private Date fechaInicio;
	
	private Date fechaTermino;
	
	private String correo;
	
	private Long isCete100;
	
	private Long isCampesp;
	
	private Long idNivelAuto;
	
	
	
	
	public ConsultarAutorizadorDTO() {
		
	}

	public ConsultarAutorizadorDTO(String soeid, String soeidDivisional, String soeidDistrital, String division,
			String distrito, String nombre, String inic, Date fechaInicio, Date fechaTermino, String correo,
			Long isCete100, Long isCampesp, Long idNivelAuto) {
		super();
		this.soeid = soeid;
		this.soeidDivisional = soeidDivisional;
		this.soeidDistrital = soeidDistrital;
		this.division = division;
		this.distrito = distrito;
		this.nombre = nombre;
		this.inic = inic;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
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

	public String getSoeidDivisional() {
		return soeidDivisional;
	}

	public void setSoeidDivisional(String soeidDivisional) {
		this.soeidDivisional = soeidDivisional;
	}

	public String getSoeidDistrital() {
		return soeidDistrital;
	}

	public void setSoeidDistrital(String soeidDistrital) {
		this.soeidDistrital = soeidDistrital;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
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
		return "ConsultarAutorizadorDTO[soeid = "+soeid+", soeidDivisional = "+soeidDivisional+", soeidDistrital = "+soeidDistrital+","
				+ " division="+division+", distrito="+distrito+", nombre = "+nombre+", inic = "+inic+", fechaInicio="+fechaInicio+","
				+ " fechaTermino = "+fechaTermino+", correo = "+correo+", isCete100 = "+isCete100+", isCampesp = "+isCampesp+", idNivelAuto = "+idNivelAuto+"]";
	}

}
