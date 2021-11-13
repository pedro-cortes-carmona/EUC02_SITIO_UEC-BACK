package com.citi.euces.sitiouec.dto;


public class ObtenerTotalEjecutivosRegionResponseDTO {
	
	private String DISTRITO;
	private Long NUM_EJECUTIVO;
	
	
	/**
	 * 
	 */
	public ObtenerTotalEjecutivosRegionResponseDTO() {
		super();
	}
	/**
	 * @param dISTRITO
	 * @param nUM_EJECUTIVO
	 */
	public ObtenerTotalEjecutivosRegionResponseDTO(String dISTRITO, Long nUM_EJECUTIVO) {
		super();
		DISTRITO = dISTRITO;
		NUM_EJECUTIVO = nUM_EJECUTIVO;
	}
	public String getDISTRITO() {
		return DISTRITO;
	}
	public void setDISTRITO(String dISTRITO) {
		DISTRITO = dISTRITO;
	}
	public Long getNUM_EJECUTIVO() {
		return NUM_EJECUTIVO;
	}
	public void setNUM_EJECUTIVO(Long nUM_EJECUTIVO) {
		NUM_EJECUTIVO = nUM_EJECUTIVO;
	}
	
	

}
