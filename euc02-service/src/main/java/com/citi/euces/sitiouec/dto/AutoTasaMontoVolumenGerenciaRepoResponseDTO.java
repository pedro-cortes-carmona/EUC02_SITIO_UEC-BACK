package com.citi.euces.sitiouec.dto;

import java.math.BigInteger;


public class AutoTasaMontoVolumenGerenciaRepoResponseDTO {
	

	private String VOLUMEN;
	private String CAMPANA;
	private String FECHA; 
	private String MONTO;
/*	private String divname;
	private String tipo;
	private boolean mostrar_leyenda;
	private String position;
	private String titulo;
	private double transparency;
	private boolean descargable;
	private String Promedio;
	private double valor;*/
	public AutoTasaMontoVolumenGerenciaRepoResponseDTO(String vOLUMEN, String cAMPANA, String fECHA,
			String mONTO) {
		super();
		VOLUMEN = vOLUMEN;
		CAMPANA = cAMPANA;
		FECHA = fECHA;
		MONTO = mONTO;
	}
	public String getVOLUMEN() {
		return VOLUMEN;
	}
	public void setVOLUMEN(String vOLUMEN) {
		VOLUMEN = vOLUMEN;
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
	public String getMONTO() {
		return MONTO;
	}
	public void setMONTO(String mONTO) {
		MONTO = mONTO;
	}
	
	
	
}
