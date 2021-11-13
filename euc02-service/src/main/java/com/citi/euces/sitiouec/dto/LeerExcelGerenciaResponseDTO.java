package com.citi.euces.sitiouec.dto;

public class LeerExcelGerenciaResponseDTO {
	
	private String ESTATUS;
	
	private String CONTRATO;

	/**
	 * @param eSTATUS
	 * @param cONTRATO
	 */
	public LeerExcelGerenciaResponseDTO(String eSTATUS, String cONTRATO) {
		super();
		ESTATUS = eSTATUS;
		CONTRATO = cONTRATO;
	}

	/**
	 * 
	 */
	public LeerExcelGerenciaResponseDTO() {
		super();
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}

	public String getCONTRATO() {
		return CONTRATO;
	}

	public void setCONTRATO(String cONTRATO) {
		CONTRATO = cONTRATO;
	}
	
	

}
