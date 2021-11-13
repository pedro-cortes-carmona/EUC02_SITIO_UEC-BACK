package com.citi.euces.sitiouec.infra.dto;

import java.math.BigInteger;
import java.sql.Timestamp;



public class AutoTasaMontoVolumenGerencias {

	private String VOLUMEN;
	private String CAMPANA;
	private Timestamp FECHA;
	private String MONTO;
	
	public AutoTasaMontoVolumenGerencias() {
		super();
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

	public Timestamp getFECHA() {
		return FECHA;
	}

	public void setFECHA(Timestamp fECHA) {
		FECHA = fECHA;
	}

	public String getMONTO() {
		return MONTO;
	}

	public void setMONTO(String mONTO) {
		MONTO = mONTO;
	}

	public AutoTasaMontoVolumenGerencias(String vOLUMEN, String cAMPANA, Timestamp fECHA, String mONTO) {
		super();
		VOLUMEN = vOLUMEN;
		CAMPANA = cAMPANA;
		FECHA = fECHA;
		MONTO = mONTO;
	}

	@Override
	public String toString() {
		return "AutoTasaMontoVolumenGerencias [VOLUMEN=" + VOLUMEN + ", CAMPANA=" + CAMPANA + ", FECHA=" + FECHA
				+ ", MONTO=" + MONTO + "]";
	}
	
	

	
	
	

}
