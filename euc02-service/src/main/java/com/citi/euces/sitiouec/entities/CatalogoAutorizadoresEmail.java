package com.citi.euces.sitiouec.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author cesar.alducin
 * 
 *         Entidad que se utiliza para mappear la tabla
 *         UEC_Catalogo_Autorizadores2021
 *
 */

@Entity
@Table(name = "UEC_CATALOGO_AUTORIZADORES2021")
public class CatalogoAutorizadoresEmail {

	@Id
	@Column(name = "SOEID", nullable = true)
	private String soied;

	@Column(name = "SOEID_DIVISIONAL", nullable = true)
	private String soiedDivisional;

	@Column(name = "SOEID_DISTRITAL", nullable = true)
	private String soeidDistrital;

	@Column(name = "DIVISION", nullable = true)
	private String dvision;

	@Column(name = "DISTRISTO", nullable = true)
	private String distrito;

	@Column(name = "NOMBRE", nullable = true)
	private String nombre;

	@Column(name = "INIC", nullable = true)
	private String inic;

	@Column(name = "FECHA_INICIO", nullable = true)
	private Date fechaInicio;

	@Column(name = "FECHA_TERMINO", nullable = true)
	private Date fechaTermino;

	@Column(name = "ALTA", nullable = true)
	private Long alta;

	@Column(name = "CORREO", nullable = true)
	private String correo;

	@Column(name = "IS_CETE100", nullable = true)
	private Long isCete100;

	@Column(name = "IS_CAMPESP", nullable = true)
	private Long isCampesp;

	@Column(name = "ID_NIVEL_AUTO", nullable = true)
	private Long idNivelAuto;

	public CatalogoAutorizadoresEmail() {
		// TODO Auto-generated constructor stub
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
		return "CatalogoAutorizadoresEmail [soied=" + soied + ", soiedDivisional=" + soiedDivisional
				+ ", soeidDistrital=" + soeidDistrital + ", dvision=" + dvision + ", distrito=" + distrito + ", nombre="
				+ nombre + ", inic=" + inic + ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino
				+ ", alta=" + alta + ", correo=" + correo + ", isCete100=" + isCete100 + ", isCampesp=" + isCampesp
				+ ", idNivelAuto=" + idNivelAuto + "]";
	}

}
