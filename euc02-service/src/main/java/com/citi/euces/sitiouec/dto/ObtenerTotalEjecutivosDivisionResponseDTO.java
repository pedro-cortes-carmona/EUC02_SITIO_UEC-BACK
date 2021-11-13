package com.citi.euces.sitiouec.dto;


public class ObtenerTotalEjecutivosDivisionResponseDTO {
	
	private String DIVISION;
	private Long NUM_EJECUTIVO;

	
	/**
	 * 
	 */
	public ObtenerTotalEjecutivosDivisionResponseDTO() {
		super();
	}
	/**
	 * @param dIVISION
	 * @param nUM_EJECUTIVO
	 */
	public ObtenerTotalEjecutivosDivisionResponseDTO(String dIVISION, Long nUM_EJECUTIVO) {
		super();
		DIVISION = dIVISION;
		NUM_EJECUTIVO = nUM_EJECUTIVO;
	}
	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public Long getNUM_EJECUTIVO() {
		return NUM_EJECUTIVO;
	}
	public void setNUM_EJECUTIVO(Long nUM_EJECUTIVO) {
		NUM_EJECUTIVO = nUM_EJECUTIVO;
	}
	
	
	

}
