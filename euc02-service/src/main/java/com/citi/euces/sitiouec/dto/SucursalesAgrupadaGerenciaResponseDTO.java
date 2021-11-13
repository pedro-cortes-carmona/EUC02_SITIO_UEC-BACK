package com.citi.euces.sitiouec.dto;



public class SucursalesAgrupadaGerenciaResponseDTO {

	private String DIVISION;
	private double cantsuc;
	private double cantejec;
	/**
	 * @param dIVISION
	 * @param cantsuc
	 * @param cantejec
	 */
	public SucursalesAgrupadaGerenciaResponseDTO(String dIVISION, double cantsuc, double cantejec) {
		super();
		DIVISION = dIVISION;
		this.cantsuc = cantsuc;
		this.cantejec = cantejec;
	}
	
	
	/**
	 * 
	 */
	public SucursalesAgrupadaGerenciaResponseDTO() {
		super();
	}


	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public double getCantsuc() {
		return cantsuc;
	}
	public void setCantsuc(double cantsuc) {
		this.cantsuc = cantsuc;
	}
	public double getCantejec() {
		return cantejec;
	}
	public void setCantejec(double cantejec) {
		this.cantejec = cantejec;
	}
	
	
	
}
