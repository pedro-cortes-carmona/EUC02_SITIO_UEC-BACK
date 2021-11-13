package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.Date;

public class AutDivisionalesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String soeid;
	private String division;
	private String distrito;
	private String nombre;
	private String inic;
	private Date fechaInicio;
	private Date fechaFinal;
	private Integer alta;
	private String correo;
	private Integer idNivelAuto;
	
	public AutDivisionalesDTO() {}
	
	public AutDivisionalesDTO(String soeid, String division, String distrito, String nombre, String inic,
			Date fechaInicio, Date fechaFinal, Integer alta, String correo, Integer idNivelAuto) {
		super();
		this.soeid = soeid;
		this.division = division;
		this.distrito = distrito;
		this.nombre = nombre;
		this.inic = inic;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.alta = alta;
		this.correo = correo;
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

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Integer getAlta() {
		return alta;
	}

	public void setAlta(Integer alta) {
		this.alta = alta;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getIdNivelAuto() {
		return idNivelAuto;
	}

	public void setIdNivelAuto(Integer idNivelAuto) {
		this.idNivelAuto = idNivelAuto;
	}
	
	
	
}
