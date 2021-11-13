package com.citi.euces.sitiouec.dto;

import java.math.BigInteger;

public class AutoTasaMontoVolumenGerenciaDTO {
	private BigInteger VOLUMEN;
	private String CAMPANA;
	private String FECHA;
	
	public AutoTasaMontoVolumenGerenciaDTO(BigInteger vOLUMEN, String cAMPANA, String fECHA) {
		super();
		VOLUMEN = vOLUMEN;
		CAMPANA = cAMPANA;
		FECHA = fECHA;
	}
	public BigInteger getVOLUMEN() {
		return VOLUMEN;
	}
	public void setVOLUMEN(BigInteger vOLUMEN) {
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


}
