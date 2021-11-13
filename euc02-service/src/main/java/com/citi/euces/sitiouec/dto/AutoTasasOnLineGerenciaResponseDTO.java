package com.citi.euces.sitiouec.dto;

import java.math.BigInteger;

public class AutoTasasOnLineGerenciaResponseDTO {
	
	private BigInteger ID_TASAUTO;
	private String  FECHA_SOLIC;
	private String  FECHA_AUTORI;
	private String  FECHA_ESTATUS;
	private String ESTATUS;
	private Long SUC_SOLIC;
	private String DIVISION;
	private Long PLAZO;
	private Long TASA_AUTORI;
	private String TIPO_AUTORI;
	private String SOEID_AUTORI;
	private String SOEID_ASIG;
	private String SOEID_OPE;
	private Long NUM_AUTORI_UEC;
	/**
	 * 
	 */
	public AutoTasasOnLineGerenciaResponseDTO() {
		super();
	}
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
	public AutoTasasOnLineGerenciaResponseDTO(BigInteger iD_TASAUTO, String fECHA_SOLIC, String fECHA_AUTORI,
			String fECHA_ESTATUS, String eSTATUS, Long sUC_SOLIC, String dIVISION, Long pLAZO, Long tASA_AUTORI,
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
	public BigInteger getID_TASAUTO() {
		return ID_TASAUTO;
	}
	public void setID_TASAUTO(BigInteger iD_TASAUTO) {
		ID_TASAUTO = iD_TASAUTO;
	}
	public String getFECHA_SOLIC() {
		return FECHA_SOLIC;
	}
	public void setFECHA_SOLIC(String fECHA_SOLIC) {
		FECHA_SOLIC = fECHA_SOLIC;
	}
	public String getFECHA_AUTORI() {
		return FECHA_AUTORI;
	}
	public void setFECHA_AUTORI(String fECHA_AUTORI) {
		FECHA_AUTORI = fECHA_AUTORI;
	}
	public String getFECHA_ESTATUS() {
		return FECHA_ESTATUS;
	}
	public void setFECHA_ESTATUS(String fECHA_ESTATUS) {
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
