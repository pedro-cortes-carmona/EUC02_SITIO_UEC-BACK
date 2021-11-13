package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_SUCURSALES")
public class SucursalGerencia {

	@Id
	/*@Column(name ="SIRH" )
	private Long SIRH;*/
	@Column(name ="DIVISION_NOMBRE" )
	private String DIVISION_NOMBRE;
	@Column(name ="DISTRITO_NOMBRE" )
	private String DISTRITO_NOMBRE;
	/*@Column(name ="EJECUTIVOS" )
	private Long EJECUTIVOS;
	@Column(name ="EJECUTIVOS_PRIORITY" )
	private Long EJECUTIVOS_PRIORITY;
	@Column(name ="IS_CLOSED" )
	private Long IS_CLOSED;*/
	@Column(name ="CANTSUC" )
	private String cantsuc;
	@Column(name ="CANTEJEC" )
	private String cantejec;

	public SucursalGerencia() {
		super();
	}

	public String getDIVISION_NOMBRE() {
		return DIVISION_NOMBRE;
	}

	public void setDIVISION_NOMBRE(String dIVISION_NOMBRE) {
		DIVISION_NOMBRE = dIVISION_NOMBRE;
	}

	public String getDISTRITO_NOMBRE() {
		return DISTRITO_NOMBRE;
	}

	public void setDISTRITO_NOMBRE(String dISTRITO_NOMBRE) {
		DISTRITO_NOMBRE = dISTRITO_NOMBRE;
	}

	public String getCantsuc() {
		return cantsuc;
	}

	public void setCantsuc(String cantsuc) {
		this.cantsuc = cantsuc;
	}

	public String getCantejec() {
		return cantejec;
	}

	public void setCantejec(String cantejec) {
		this.cantejec = cantejec;
	}


	/**
	 * @param dIVISION
	 * @param dITRITO
	 * @param cantsuc
	 * @param cantejec
	 */
	
}
