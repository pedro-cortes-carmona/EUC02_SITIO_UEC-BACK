package com.citi.euces.sitiouec.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UEC_TB_AUTORANGOS")
public class Autorango implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="ID_RANGO" )
	private Long ID_RANGO;
	@Column(name ="RANGOMIN" )
	private Long RANGOMIN;
	@Column(name ="RANGOMAX" )
	private Long RANGOMAX;
	@Column(name ="MILL_DOSMILLQUIN" )
	private double MILL_DOSMILLQUIN; //double
	@Column(name ="FECHA" )
	private Date FECHA;
	@Column(name ="FECHAFIN" )
	private Date FECHAFIN;
	/**
	 * @param id_Rsngo
	 * @param rangoMin
	 * @param rangoMax
	 * @param mILL_DOSMILLQUIN
	 * @param fECHA
	 * @param fECHAFIN
	 */
	public Autorango() {
		
	}
	public Long getID_RANGO() {
		return ID_RANGO;
	}
	public void setID_RANGO(Long iD_RANGO) {
		ID_RANGO = iD_RANGO;
	}
	public Long getRANGOMIN() {
		return RANGOMIN;
	}
	public void setRANGOMIN(Long rANGOMIN) {
		RANGOMIN = rANGOMIN;
	}
	public Long getRANGOMAX() {
		return RANGOMAX;
	}
	public void setRANGOMAX(Long rANGOMAX) {
		RANGOMAX = rANGOMAX;
	}
	public double getMILL_DOSMILLQUIN() {
		return MILL_DOSMILLQUIN;
	}
	public void setMILL_DOSMILLQUIN(double mILL_DOSMILLQUIN) {
		MILL_DOSMILLQUIN = mILL_DOSMILLQUIN;
	}
	public Date getFECHA() {
		return FECHA;
	}
	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}
	public Date getFECHAFIN() {
		return FECHAFIN;
	}
	public void setFECHAFIN(Date fECHAFIN) {
		FECHAFIN = fECHAFIN;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
