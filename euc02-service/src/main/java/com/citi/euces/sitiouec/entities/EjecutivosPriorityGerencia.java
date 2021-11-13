package com.citi.euces.sitiouec.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_CAT_EJECUTIVOS_PRIORITY2021")
public class EjecutivosPriorityGerencia {
	
	@Id
    @Column(name ="ID")
	private BigInteger ID;
    @Column(name ="SIRH")
	private String SIRH;
    @Column(name ="DIVISION")
	private String DIVISION;
    @Column(name ="DISTRITO")
	private String DISTRITO;
    @Column(name ="ID_ALTERNATIVO")
	private BigInteger ID_ALTERNATIVO;
    @Column(name ="NOMBRE")
    private String NOMBRE;
    
    private Long SUC;
	/**
	 * @param iD
	 * @param sIRH
	 * @param dIVISION
	 * @param dISTRITO
	 * @param iD_ALTERNATIVO
	 * @param nOMBRE
	 */
	public EjecutivosPriorityGerencia(BigInteger iD, String sIRH, String dIVISION, String dISTRITO,
			BigInteger iD_ALTERNATIVO, String nOMBRE) {
		super();
		ID = iD;
		SIRH = sIRH;
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
		ID_ALTERNATIVO = iD_ALTERNATIVO;
		NOMBRE = nOMBRE;
	}
	/**
	 * 
	 */
	public EjecutivosPriorityGerencia() {
		super();
	}
	public BigInteger getID() {
		return ID;
	}
	public void setID(BigInteger iD) {
		ID = iD;
	}
	public String getSIRH() {
		return SIRH;
	}
	public void setSIRH(String sIRH) {
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
	public BigInteger getID_ALTERNATIVO() {
		return ID_ALTERNATIVO;
	}
	public void setID_ALTERNATIVO(BigInteger iD_ALTERNATIVO) {
		ID_ALTERNATIVO = iD_ALTERNATIVO;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
    
    
	
	
}
