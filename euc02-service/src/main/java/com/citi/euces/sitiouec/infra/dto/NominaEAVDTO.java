package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.Date;

public class NominaEAVDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long nomina;
	private Date fechaApertura;
	private Double monto;
	private String nomCamp;
	
	public NominaEAVDTO() {}
	
	public NominaEAVDTO(Long nomina) {
		super();
		this.nomina = nomina;
	}

	public NominaEAVDTO(Date fechaApertura, Double monto, String nomCamp) {
		super();
		this.fechaApertura = fechaApertura;
		this.monto = monto;
		this.nomCamp = nomCamp;
	}

	public Long getNomina() {
		return nomina;
	}

	public void setNomina(Long nomina) {
		this.nomina = nomina;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getNomCamp() {
		return nomCamp;
	}

	public void setNomCamp(String nomCamp) {
		this.nomCamp = nomCamp;
	}
	
	
	
}
