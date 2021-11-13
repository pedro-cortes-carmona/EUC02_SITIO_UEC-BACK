package com.citi.euces.sitiouec.dto;

import java.math.BigInteger;

public class EjecutivosPrioritySinVentaGerenciaResponseDTO {
	
	private String DIVISION;
	private String DISTRITO;
	private String Suc;
	private BigInteger NOMINA;
	private String NOMBRE;
	private String CAMPANA;
	private String FECHA;
	/**
	 * @param dIVISION
	 * @param dISTRITO
	 * @param suc
	 * @param nOMINA
	 * @param nOMBRE
	 * @param cAMPANA
	 * @param fECHA
	 */
	public EjecutivosPrioritySinVentaGerenciaResponseDTO(String dIVISION, String dISTRITO, String suc,
			BigInteger nOMINA, String nOMBRE, String cAMPANA, String fECHA) {
		super();
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
		Suc = suc;
		NOMINA = nOMINA;
		NOMBRE = nOMBRE;
		CAMPANA = cAMPANA;
		FECHA = fECHA;
	}
	/**
	 * 
	 */
	public EjecutivosPrioritySinVentaGerenciaResponseDTO() {
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
	public String getCAMPANA() {
		return CAMPANA;
	}
	public void setCAMPANA(String cAMPANA) {
		CAMPANA = cAMPANA;
	}
	public String getFECHA() {
		return FECHA;
	}
	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}
	
	



}
