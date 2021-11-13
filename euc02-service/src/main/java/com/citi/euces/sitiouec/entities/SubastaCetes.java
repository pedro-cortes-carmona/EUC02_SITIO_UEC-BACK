package com.citi.euces.sitiouec.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_HISTORICO_CETES")
public class SubastaCetes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FECHA", nullable = true)
	private java.sql.Timestamp fecha;

	@Column(name = "CETE1PLAZO", nullable = true)
	private Long cete1plazo;

	@Column(name = "CETE1TASA", nullable = false)
	private Double cete1tasa;

	@Column(name = "CETE2PLAZO", nullable = true)
	private Long cete2plazo;

	@Column(name = "CETE2TASA", nullable = false)
	private Double cete2tasa;

	@Column(name = "CETE3PLAZO", nullable = true)
	private Long cete3plazo;

	@Column(name = "CETE3TASA", nullable = false)
	private Double cete3tasa;

	@Column(name = "CETE4PLAZO", nullable = true)
	private Long cete4plazo;

	@Column(name = "CETE4TASA", nullable = false)
	private Double cete4tasa;
	
	
	public java.sql.Timestamp getFecha() {
		return fecha;
	}
	
	public void setFecha(java.sql.Timestamp fecha) {
		this.fecha = fecha;
	}
	public Long getCete1plazo() {
		return cete1plazo;
	}

	public void setCete1plazo(Long cete1plazo) {
		this.cete1plazo = cete1plazo;
	}

	public Double getCete1tasa() {
		return cete1tasa;
	}

	public void setCete1tasa(Double cete1tasa) {
		this.cete1tasa = cete1tasa;
	}

	public Long getCete2plazo() {
		return cete2plazo;
	}

	public void setCete2plazo(Long cete2plazo) {
		this.cete2plazo = cete2plazo;
	}

	public Double getCete2tasa() {
		return cete2tasa;
	}

	public void setCete2tasa(Double cete2tasa) {
		this.cete2tasa = cete2tasa;
	}

	public Long getCete3plazo() {
		return cete3plazo;
	}

	public void setCete3plazo(Long cete3plazo) {
		this.cete3plazo = cete3plazo;
	}

	public Double getCete3tasa() {
		return cete3tasa;
	}

	public void setCete3tasa(Double cete3tasa) {
		this.cete3tasa = cete3tasa;
	}

	public Long getCete4plazo() {
		return cete4plazo;
	}

	public void setCete4plazo(Long cete4plazo) {
		this.cete4plazo = cete4plazo;
	}

	public Double getCete4tasa() {
		return cete4tasa;
	}

	public void setCete4tasa(Double cete4tasa) {
		this.cete4tasa = cete4tasa;
	}

}
