package com.citi.euces.sitiouec.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UEC_TB_ACUMULADO_CAMP")
public class AutoTasaAcomuladoCampGerencia implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="FECHA_APERTURA")
	private Timestamp FECHA_APERTURA;
    @Column(name ="MONTO")
	private Long MONTO;
    @Column(name ="DIVISION")
	private String DIVISION;
    @Column(name ="NOM_CAMP")
	private String NOM_CAMP;
    @Column(name ="NUM_VENTAS")
	private Long NUM_VENTAS;
    @Column(name ="DISTRITO")
   	private String DISTRITO;
    @Column(name ="SIRH")
   	private String SIRH;
    @Column(name ="TIPO_DISP")
   	private String TIPO_DISP;
    @Column(name ="NUM_EJECUTIVO")
  	private Long NUM_EJECUTIVO;
    @Column(name ="TIPO")
    private String TIPO;
    @Column(name ="SUC_SOLIC")
    private Long SUC_SOLIC;
	/**
	 * 
	 */
	public AutoTasaAcomuladoCampGerencia() {
		super();
	}

	/**
	 * @param fECHA_APERTURA
	 * @param mONTO
	 * @param dIVISION
	 * @param nOM_CAMP
	 * @param nUM_VENTAS
	 * @param dISTRITO
	 * @param sIRH
	 * @param tIPO_DISP
	 * @param nUM_EJECUTIVO
	 * @param tIPO
	 * @param sUC_SOLIC
	 */
	public AutoTasaAcomuladoCampGerencia(Timestamp fECHA_APERTURA, Long mONTO, String dIVISION, String nOM_CAMP,
			Long nUM_VENTAS, String dISTRITO, String sIRH, String tIPO_DISP, Long nUM_EJECUTIVO, String tIPO,
			Long sUC_SOLIC) {
		super();
		FECHA_APERTURA = fECHA_APERTURA;
		MONTO = mONTO;
		DIVISION = dIVISION;
		NOM_CAMP = nOM_CAMP;
		NUM_VENTAS = nUM_VENTAS;
		DISTRITO = dISTRITO;
		SIRH = sIRH;
		TIPO_DISP = tIPO_DISP;
		NUM_EJECUTIVO = nUM_EJECUTIVO;
		TIPO = tIPO;
		SUC_SOLIC = sUC_SOLIC;
	}

	public Timestamp getFECHA_APERTURA() {
		return FECHA_APERTURA;
	}
	public void setFECHA_APERTURA(Timestamp fECHA_APERTURA) {
		FECHA_APERTURA = fECHA_APERTURA;
	}
	public Long getMONTO() {
		return MONTO;
	}
	public void setMONTO(Long mONTO) {
		MONTO = mONTO;
	}
	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public String getNOM_CAMP() {
		return NOM_CAMP;
	}
	public void setNOM_CAMP(String nOM_CAMP) {
		NOM_CAMP = nOM_CAMP;
	}
	public Long getNUM_VENTAS() {
		return NUM_VENTAS;
	}
	public void setNUM_VENTAS(Long nUM_VENTAS) {
		NUM_VENTAS = nUM_VENTAS;
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
	public String getTIPO_DISP() {
		return TIPO_DISP;
	}
	public void setTIPO_DISP(String tIPO_DISP) {
		TIPO_DISP = tIPO_DISP;
	}
	public Long getNUM_EJECUTIVO() {
		return NUM_EJECUTIVO;
	}
	public void setNUM_EJECUTIVO(Long nUM_EJECUTIVO) {
		NUM_EJECUTIVO = nUM_EJECUTIVO;
	}
	public String getTIPO() {
		return TIPO;
	}
	public void setTIPO(String tIPO) {
		TIPO = tIPO;
	}
	public Long getSUC_SOLIC() {
		return SUC_SOLIC;
	}
	public void setSUC_SOLIC(Long sUC_SOLIC) {
		SUC_SOLIC = sUC_SOLIC;
	}
	

}