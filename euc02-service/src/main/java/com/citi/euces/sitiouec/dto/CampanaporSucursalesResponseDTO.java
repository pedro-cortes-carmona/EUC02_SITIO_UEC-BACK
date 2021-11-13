package com.citi.euces.sitiouec.dto;

public class CampanaporSucursalesResponseDTO {
	
	private String DIVISION;
	private String DISTRITO;
	private Long SUC;
	private double VENTAS;
	private double MONTO;
	private double MONTOVENTAS;
	private double cantsuc;
	private double cantejec;
	private double CantSucSinVentas;
	private double CantSucConVentas;
	private double Per_Capita;
	private Long RK;
	
	/**
	 * 
	 */
	public CampanaporSucursalesResponseDTO() {
		super();
	}
	/**
	 * @param dIVISION
	 * @param dISTRITO
	 * @param sUC
	 * @param vENTAS
	 * @param mONTO
	 * @param mONTOVENTAS
	 * @param cantejec
	 * @param per_Capita
	 * @param rK
	 */

	/**
	 * @param dIVISION
	 * @param dISTRITO
	 * @param sUC
	 * @param vENTAS
	 * @param mONTO
	 * @param mONTOVENTAS
	 * @param cantsuc
	 * @param cantejec
	 * @param cantSucSinVentas
	 * @param cantSucConVentas
	 * @param per_Capita
	 * @param rK
	 */
	public CampanaporSucursalesResponseDTO(String dIVISION, String dISTRITO, Long sUC, double vENTAS, double mONTO,
			double mONTOVENTAS, double cantsuc, double cantejec, double cantSucSinVentas, double cantSucConVentas,
			double per_Capita, Long rK) {
		super();
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
		SUC = sUC;
		VENTAS = vENTAS;
		MONTO = mONTO;
		MONTOVENTAS = mONTOVENTAS;
		this.cantsuc = cantsuc;
		this.cantejec = cantejec;
		CantSucSinVentas = cantSucSinVentas;
		CantSucConVentas = cantSucConVentas;
		Per_Capita = per_Capita;
		RK = rK;
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

	public Long getSUC() {
		return SUC;
	}

	public void setSUC(Long sUC) {
		SUC = sUC;
	}

	public double getVENTAS() {
		return VENTAS;
	}

	public void setVENTAS(double vENTAS) {
		VENTAS = vENTAS;
	}

	public double getMONTO() {
		return MONTO;
	}

	public void setMONTO(double mONTO) {
		MONTO = mONTO;
	}

	public double getMONTOVENTAS() {
		return MONTOVENTAS;
	}

	public void setMONTOVENTAS(double mONTOVENTAS) {
		MONTOVENTAS = mONTOVENTAS;
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

	public double getCantSucSinVentas() {
		return CantSucSinVentas;
	}

	public void setCantSucSinVentas(double cantSucSinVentas) {
		CantSucSinVentas = cantSucSinVentas;
	}

	public double getCantSucConVentas() {
		return CantSucConVentas;
	}

	public void setCantSucConVentas(double cantSucConVentas) {
		CantSucConVentas = cantSucConVentas;
	}

	public double getPer_Capita() {
		return Per_Capita;
	}

	public void setPer_Capita(double per_Capita) {
		Per_Capita = per_Capita;
	}

	public Long getRK() {
		return RK;
	}

	public void setRK(Long rK) {
		RK = rK;
	}
	
}
