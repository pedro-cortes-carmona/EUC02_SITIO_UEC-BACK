package com.citi.euces.sitiouec.dto;

public class CampanaDiasGerenciaResponseDTO {
	
	private String CAMPANIAS_FECHA;

	/**
	 * @param cAMPANIAS_FECHA
	 */
	public CampanaDiasGerenciaResponseDTO(String cAMPANIAS_FECHA) {
		super();
		CAMPANIAS_FECHA = cAMPANIAS_FECHA;
	}

	public CampanaDiasGerenciaResponseDTO() {
		super();
	}

	public String getCAMPANIAS_FECHA() {
		return CAMPANIAS_FECHA;
	}

	public void setCAMPANIAS_FECHA(String cAMPANIAS_FECHA) {
		CAMPANIAS_FECHA = cAMPANIAS_FECHA;
	}
	
	
	
}
