package com.citi.euces.sitiouec.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UEC_TB_CERTIFICADOS_FISICOS")
public class CertificadosFisicos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "FOLIO")
	private String folio;

	@Column(name = "NUM_CTE")
	private Integer numCte;
	
	@Column(name = "ID_SOLICITUD")
	private Integer idSolicitud;
	
	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column(name = "NOMINAC")
	private Integer nominac;
	
	@Column(name = "EJECUTIVOC")
	private String ejecutivoc;

	@Column(name = "FECHA_GENERACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaGeneracion;

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public Integer getNumCte() {
		return numCte;
	}

	public void setNumCte(Integer numCte) {
		this.numCte = numCte;
	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNominac() {
		return nominac;
	}

	public void setNominac(Integer nominac) {
		this.nominac = nominac;
	}

	public String getEjecutivoc() {
		return ejecutivoc;
	}

	public void setEjecutivoc(String ejecutivoc) {
		this.ejecutivoc = ejecutivoc;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
