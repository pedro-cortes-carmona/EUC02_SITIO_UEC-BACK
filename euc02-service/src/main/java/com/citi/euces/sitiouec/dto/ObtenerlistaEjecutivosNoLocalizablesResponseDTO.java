package com.citi.euces.sitiouec.dto;

import java.math.BigInteger;

public class ObtenerlistaEjecutivosNoLocalizablesResponseDTO {
	
	private BigInteger NOMINA;
	private String NOMBRE;
	private String SUC;
	private BigInteger MONTOVENTAS;
	private BigInteger NUMVENTAS;
	/**
	 * @param nOMINA
	 * @param nOMBRE
	 * @param sUC
	 * @param mONTOVENTAS
	 * @param nUMVENTAS
	 */
	public ObtenerlistaEjecutivosNoLocalizablesResponseDTO(BigInteger nOMINA, String nOMBRE, String sUC,
			BigInteger mONTOVENTAS, BigInteger nUMVENTAS) {
		super();
		NOMINA = nOMINA;
		NOMBRE = nOMBRE;
		SUC = sUC;
		MONTOVENTAS = mONTOVENTAS;
		NUMVENTAS = nUMVENTAS;
	}
	
	public ObtenerlistaEjecutivosNoLocalizablesResponseDTO() {
		
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
	public String getSUC() {
		return SUC;
	}
	public void setSUC(String sUC) {
		SUC = sUC;
	}
	public BigInteger getMONTOVENTAS() {
		return MONTOVENTAS;
	}
	public void setMONTOVENTAS(BigInteger mONTOVENTAS) {
		MONTOVENTAS = mONTOVENTAS;
	}
	public BigInteger getNUMVENTAS() {
		return NUMVENTAS;
	}
	public void setNUMVENTAS(BigInteger nUMVENTAS) {
		NUMVENTAS = nUMVENTAS;
	}
	
	

}
