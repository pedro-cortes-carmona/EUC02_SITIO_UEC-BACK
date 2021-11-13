package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_SUCURSALES")
public class TotalEjecutivosGerencia {
	
	@Id
	@Column(name ="DIVISION_NOMBRE" )
	private String DIVISION;
	@Column(name ="DISTRITO_NOMBRE" )
	private String DISTRITO;
	@Column(name ="CANTEJEC" )
	private Long cantejec;
	/**
	 * 
	 */
	public TotalEjecutivosGerencia() {
		super();
	}
	/**
	 * @param dIVISION
	 * @param dISTRITO
	 * @param cantejec
	 */
	public TotalEjecutivosGerencia(String dIVISION, String dISTRITO, Long cantejec) {
		super();
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
		this.cantejec = cantejec;
	}
	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public String getDISTRITO() {
		return DISTRITO;
	}
	public void setDISTRITO(String dISTRITO) {
		DISTRITO = dISTRITO;
	}
	public Long getCantejec() {
		return cantejec;
	}
	public void setCantejec(Long cantejec) {
		this.cantejec = cantejec;
	}
	
	

}
