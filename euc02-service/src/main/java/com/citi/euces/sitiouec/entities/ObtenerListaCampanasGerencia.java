package com.citi.euces.sitiouec.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PER_CAT_SUCURSALES")
public class ObtenerListaCampanasGerencia {
	
	@Id
    @Column(name ="DIVISION")
	private String DIVISION;
    @Column(name ="DISTRITO")
   	private String DISTRITO;
    @Column(name ="SIRH")
   	private String SIRH;
    @Column(name ="MONTO")
	private Long MONTO;
    @Column(name ="NUM_VENTAS")
	private Long NUM_VENTAS;
    @Column(name ="NOM_CAMP")
	private String NOM_CAMP;
    @Column(name ="TIPO_DISP")
   	private String TIPO_DISP;
    @Column(name ="NUM_EJECUTIVOS")
  	private Long NUM_EJECUTIVOS;
    @Column(name ="TIPO")
    private String TIPO;
    
	/**
	 * 
	 */
	public ObtenerListaCampanasGerencia() {
		super();
	}

	/**
	 * @param dIVISION
	 * @param dISTRITO
	 * @param sIRH
	 * @param mONTO
	 * @param nUM_VENTAS
	 * @param nOM_CAMP
	 * @param tIPO_DISP
	 * @param nUM_EJECUTIVOS
	 * @param tIPO
	 */
	public ObtenerListaCampanasGerencia(String dIVISION, String dISTRITO, String sIRH, Long mONTO, Long nUM_VENTAS,
			String nOM_CAMP, String tIPO_DISP, Long nUM_EJECUTIVOS, String tIPO) {
		super();
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
		SIRH = sIRH;
		MONTO = mONTO;
		NUM_VENTAS = nUM_VENTAS;
		NOM_CAMP = nOM_CAMP;
		TIPO_DISP = tIPO_DISP;
		NUM_EJECUTIVOS = nUM_EJECUTIVOS;
		TIPO = tIPO;
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

	public String getSIRH() {
		return SIRH;
	}

	public void setSIRH(String sIRH) {
		SIRH = sIRH;
	}

	public Long getMONTO() {
		return MONTO;
	}

	public void setMONTO(Long mONTO) {
		MONTO = mONTO;
	}

	public Long getNUM_VENTAS() {
		return NUM_VENTAS;
	}

	public void setNUM_VENTAS(Long nUM_VENTAS) {
		NUM_VENTAS = nUM_VENTAS;
	}

	public String getNOM_CAMP() {
		return NOM_CAMP;
	}

	public void setNOM_CAMP(String nOM_CAMP) {
		NOM_CAMP = nOM_CAMP;
	}

	public String getTIPO_DISP() {
		return TIPO_DISP;
	}

	public void setTIPO_DISP(String tIPO_DISP) {
		TIPO_DISP = tIPO_DISP;
	}

	public Long getNUM_EJECUTIVOS() {
		return NUM_EJECUTIVOS;
	}

	public void setNUM_EJECUTIVOS(Long nUM_EJECUTIVOS) {
		NUM_EJECUTIVOS = nUM_EJECUTIVOS;
	}

	public String getTIPO() {
		return TIPO;
	}

	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}
	


}
