package com.citi.euces.sitiouec.dto;

import java.math.BigInteger;

public class EjecutivosPriorityVentaGerenciaResponseDTO {
	
	private String DIVISION;
	private String DISTRITO;
	private String Suc;
	private BigInteger NOMINA;
	private String NOMBRE;
	private String FECHA;
	private BigInteger SUB_TOTAL;
	private Long IMPORTE;
	private String CAMPANA;
	/**
	 * @param dIVISION
	 * @param dISTRITO
	 * @param suc
	 * @param nOMINA
	 * @param nOMBRE
	 * @param fECHA
	 * @param sUB_TOTAL
	 * @param iMPORTE
	 * @param cAMPANA
	 */
	public EjecutivosPriorityVentaGerenciaResponseDTO(String dIVISION, String dISTRITO, String suc, BigInteger nOMINA,
			String nOMBRE, String fECHA, BigInteger sUB_TOTAL, Long iMPORTE, String cAMPANA) {
		super();
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
		Suc = suc;
		NOMINA = nOMINA;
		NOMBRE = nOMBRE;
		FECHA = fECHA;
		SUB_TOTAL = sUB_TOTAL;
		IMPORTE = iMPORTE;
		CAMPANA = cAMPANA;
	}
	/**
	 * 
	 */
	public EjecutivosPriorityVentaGerenciaResponseDTO() {
		super();
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
	public String getSuc() {
		return Suc;
	}
	public void setSuc(String suc) {
		Suc = suc;
	}
	public BigInteger getNOMINA() {
		return NOMINA;
	}
	public void setNOMINA(BigInteger nOMINA) {
		NOMINA = nOMINA;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public String getFECHA() {
		return FECHA;
	}
	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}
	public BigInteger getSUB_TOTAL() {
		return SUB_TOTAL;
	}
	public void setSUB_TOTAL(BigInteger sUB_TOTAL) {
		SUB_TOTAL = sUB_TOTAL;
	}
	public Long getIMPORTE() {
		return IMPORTE;
	}
	public void setIMPORTE(Long iMPORTE) {
		IMPORTE = iMPORTE;
	}
	public String getCAMPANA() {
		return CAMPANA;
	}
	public void setCAMPANA(String cAMPANA) {
		CAMPANA = cAMPANA;
	}
	
	

}
