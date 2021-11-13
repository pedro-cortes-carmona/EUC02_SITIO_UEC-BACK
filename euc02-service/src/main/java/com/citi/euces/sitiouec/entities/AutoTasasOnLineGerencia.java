package com.citi.euces.sitiouec.entities;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_AUTOTASAS")
public class AutoTasasOnLineGerencia {
	
	@Id
    @Column(name ="ID_TASAUTO")
	private BigInteger ID_TASAUTO;
	@Column(name ="FECHA_SOLIC")
	private Timestamp  FECHA_SOLIC;
    @Column(name ="FECHA_AUTORI")
	private Timestamp  FECHA_AUTORI;
    @Column(name ="FECHA_ESTATUS")
	private Timestamp  FECHA_ESTATUS;
    @Column(name ="ESTATUS")
	private String ESTATUS;
    @Column(name ="SUC_SOLIC")
	private Long SUC_SOLIC;
    @Column(name ="DIVISION")
	private String DIVISION;
    @Column(name ="PLAZO")
	private Long PLAZO;
    @Column(name ="TASA_AUTORI")
	private Long TASA_AUTORI;
    @Column(name ="TIPO_AUTORI")
	private String TIPO_AUTORI;
    @Column(name ="SOEID_AUTORI")
	private String SOEID_AUTORI;
    @Column(name ="SOEID_ASIG")
	private String SOEID_ASIG;
    @Column(name ="SOEID_OPE")
	private String SOEID_OPE;
    @Column(name ="NUM_AUTORI_UEC")
	private Long NUM_AUTORI_UEC;
	/**
	 * @param iD_TASAUTO
	 * @param fECHA_SOLIC
	 * @param fECHA_AUTORI
	 * @param fECHA_ESTATUS
	 * @param eSTATUS
	 * @param sUC_SOLIC
	 * @param dIVISION
	 * @param pLAZO
	 * @param tASA_AUTORI
	 * @param tIPO_AUTORI
	 * @param sOEID_AUTORI
	 * @param sOEID_ASIG
	 * @param sOEID_OPE
	 * @param nUM_AUTORI_UEC
	 */
	public AutoTasasOnLineGerencia(BigInteger iD_TASAUTO, Timestamp fECHA_SOLIC, Timestamp fECHA_AUTORI,
			Timestamp fECHA_ESTATUS, String eSTATUS, Long sUC_SOLIC, String dIVISION, Long pLAZO, Long tASA_AUTORI,
			String tIPO_AUTORI, String sOEID_AUTORI, String sOEID_ASIG, String sOEID_OPE, Long nUM_AUTORI_UEC) {
		super();
		ID_TASAUTO = iD_TASAUTO;
		FECHA_SOLIC = fECHA_SOLIC;
		FECHA_AUTORI = fECHA_AUTORI;
		FECHA_ESTATUS = fECHA_ESTATUS;
		ESTATUS = eSTATUS;
		SUC_SOLIC = sUC_SOLIC;
		DIVISION = dIVISION;
		PLAZO = pLAZO;
		TASA_AUTORI = tASA_AUTORI;
		TIPO_AUTORI = tIPO_AUTORI;
		SOEID_AUTORI = sOEID_AUTORI;
		SOEID_ASIG = sOEID_ASIG;
		SOEID_OPE = sOEID_OPE;
		NUM_AUTORI_UEC = nUM_AUTORI_UEC;
	}
	/**
	 * 
	 */
	public AutoTasasOnLineGerencia() {
		super();
	}
	public BigInteger getID_TASAUTO() {
		return ID_TASAUTO;
	}
	public void setID_TASAUTO(BigInteger iD_TASAUTO) {
		ID_TASAUTO = iD_TASAUTO;
	}
	public Timestamp getFECHA_SOLIC() {
		return FECHA_SOLIC;
	}
	public void setFECHA_SOLIC(Timestamp fECHA_SOLIC) {
		FECHA_SOLIC = fECHA_SOLIC;
	}
	public Timestamp getFECHA_AUTORI() {
		return FECHA_AUTORI;
	}
	public void setFECHA_AUTORI(Timestamp fECHA_AUTORI) {
		FECHA_AUTORI = fECHA_AUTORI;
	}
	public Timestamp getFECHA_ESTATUS() {
		return FECHA_ESTATUS;
	}
	public void setFECHA_ESTATUS(Timestamp fECHA_ESTATUS) {
		FECHA_ESTATUS = fECHA_ESTATUS;
	}
	public String getESTATUS() {
		return ESTATUS;
	}
	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}
	public Long getSUC_SOLIC() {
		return SUC_SOLIC;
	}
	public void setSUC_SOLIC(Long sUC_SOLIC) {
		SUC_SOLIC = sUC_SOLIC;
	}
	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public Long getPLAZO() {
		return PLAZO;
	}
	public void setPLAZO(Long pLAZO) {
		PLAZO = pLAZO;
	}
	public Long getTASA_AUTORI() {
		return TASA_AUTORI;
	}
	public void setTASA_AUTORI(Long tASA_AUTORI) {
		TASA_AUTORI = tASA_AUTORI;
	}
	public String getTIPO_AUTORI() {
		return TIPO_AUTORI;
	}
	public void setTIPO_AUTORI(String tIPO_AUTORI) {
		TIPO_AUTORI = tIPO_AUTORI;
	}
	public String getSOEID_AUTORI() {
		return SOEID_AUTORI;
	}
	public void setSOEID_AUTORI(String sOEID_AUTORI) {
		SOEID_AUTORI = sOEID_AUTORI;
	}
	public String getSOEID_ASIG() {
		return SOEID_ASIG;
	}
	public void setSOEID_ASIG(String sOEID_ASIG) {
		SOEID_ASIG = sOEID_ASIG;
	}
	public String getSOEID_OPE() {
		return SOEID_OPE;
	}
	public void setSOEID_OPE(String sOEID_OPE) {
		SOEID_OPE = sOEID_OPE;
	}
	public Long getNUM_AUTORI_UEC() {
		return NUM_AUTORI_UEC;
	}
	public void setNUM_AUTORI_UEC(Long nUM_AUTORI_UEC) {
		NUM_AUTORI_UEC = nUM_AUTORI_UEC;
	}

    



}
