package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_SUCURSALES")
public class SucursalAgrupadasGerencia {
	
	@Id
	@Column(name ="SIRH_SUCURSAL_ID" )
	private Long SIRH;
	@Column(name ="DIVISION_NOMBRE" )
	private String DIVISION;
	@Column(name ="DISTRITO_NOMBRE" )
	private String DISTRITO;
	/*@Column(name ="EJECUTIVO_TOTAL" )
	private Long EJECUTIVOS;
	@Column(name ="EJECUTIVO_PRIORITY" )
	private Long EJECUTIVOS_PRIORITY;*/
	@Column(name ="CANTSUC" )
	private Long cantsuc;
	@Column(name ="CANTEJEC" )
	private Long cantejec;
	/**
	 * 
	 */
	public SucursalAgrupadasGerencia() {
		super();
	}
	/**
	 * @param sIRH
	 * @param dIVISION
	 * @param dISTRITO
	 * @param cantsuc
	 * @param cantejec
	 */
	/**
	 * @param sIRH
	 * @param dIVISION
	 * @param dISTRITO
	 * @param eJECUTIVOS
	 * @param eJECUTIVOS_PRIORITY
	 * @param cantsuc
	 * @param cantejec
	 */
	public SucursalAgrupadasGerencia(Long sIRH, String dIVISION, String dISTRITO, Long cantsuc, Long cantejec) {
		super();
		SIRH = sIRH;
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
		this.cantsuc = cantsuc;
		this.cantejec = cantejec;
	}
	public Long getSIRH() {
		return SIRH;
	}
	public void setSIRH(Long sIRH) {
		SIRH = sIRH;
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
	
	public Long getCantsuc() {
		return cantsuc;
	}
	public void setCantsuc(Long cantsuc) {
		this.cantsuc = cantsuc;
	}
	public Long getCantejec() {
		return cantejec;
	}
	public void setCantejec(Long cantejec) {
		this.cantejec = cantejec;
	}
	
}
