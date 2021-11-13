package com.citi.euces.sitiouec.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_CAMPANIAS")
public class CampanaGerencia {
	
	@Id
	@Column(name = "CAMPANIAS_ID")
	private String CAMPANIAS_ID;
	@Column(name = "CAMPANIAS_INICIO")
	private Date CAMPANIAS_INICIO;
	@Column(name = "CAMPANIAS_FIN")
	private Date CAMPANIAS_FIN;
	@Column(name = "CAMPANIAS_NOMBRE")
	private String CAMPANIAS_NOMBRE;
	@Column(name = "CAMPANIAS_ESTATUS")
	private String CAMPANIAS_ESTATUS;
	/**
	 * 
	 */
	public CampanaGerencia() {
		super();
	}
	public String getCAMPANIAS_ID() {
		return CAMPANIAS_ID;
	}
	public void setCAMPANIAS_ID(String cAMPANIAS_ID) {
		CAMPANIAS_ID = cAMPANIAS_ID;
	}
	public Date getCAMPANIAS_INICIO() {
		return CAMPANIAS_INICIO;
	}
	public void setCAMPANIAS_INICIO(Date cAMPANIAS_INICIO) {
		CAMPANIAS_INICIO = cAMPANIAS_INICIO;
	}
	public Date getCAMPANIAS_FIN() {
		return CAMPANIAS_FIN;
	}
	public void setCAMPANIAS_FIN(Date cAMPANIAS_FIN) {
		CAMPANIAS_FIN = cAMPANIAS_FIN;
	}
	public String getCAMPANIAS_NOMBRE() {
		return CAMPANIAS_NOMBRE;
	}
	public void setCAMPANIAS_NOMBRE(String cAMPANIAS_NOMBRE) {
		CAMPANIAS_NOMBRE = cAMPANIAS_NOMBRE;
	}
	public String getCAMPANIAS_ESTATUS() {
		return CAMPANIAS_ESTATUS;
	}
	public void setCAMPANIAS_ESTATUS(String cAMPANIAS_ESTATUS) {
		CAMPANIAS_ESTATUS = cAMPANIAS_ESTATUS;
	}
	
	
}
