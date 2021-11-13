package com.citi.euces.sitiouec.dto;

public class AutoTasaGerenciaResponseDTO {
	
	private  String Division;
	private double Ventas;
	private double Monto;
	private double MontoVentas;
	private double CantEjec;
	private double CantSuc;
	private double CantSucSinVentas;
	private double CantSucConVentas;
    private double Per_Capita;
	/**
	 * @param division
	 * @param ventas
	 * @param monto
	 * @param montoVentas
	 * @param cantEjec
	 * @param cantSuc
	 * @param cantSucSinVentas
	 * @param cantSucConVentas
	 * @param per_Capita
	 */
	public AutoTasaGerenciaResponseDTO(String division, double ventas, double monto, double montoVentas,
			double cantEjec, double cantSuc, double cantSucSinVentas, double cantSucConVentas, double per_Capita) {
		super();
		Division = division;
		Ventas = ventas;
		Monto = monto;
		MontoVentas = montoVentas;
		CantEjec = cantEjec;
		CantSuc = cantSuc;
		CantSucSinVentas = cantSucSinVentas;
		CantSucConVentas = cantSucConVentas;
		Per_Capita = per_Capita;
	}
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
	}
	public double getVentas() {
		return Ventas;
	}
	public void setVentas(double ventas) {
		Ventas = ventas;
	}
	public double getMonto() {
		return Monto;
	}
	public void setMonto(double monto) {
		Monto = monto;
	}
	public double getMontoVentas() {
		return MontoVentas;
	}
	public void setMontoVentas(double montoVentas) {
		MontoVentas = montoVentas;
	}
	public double getCantEjec() {
		return CantEjec;
	}
	public void setCantEjec(double cantEjec) {
		CantEjec = cantEjec;
	}
	public double getCantSuc() {
		return CantSuc;
	}
	public void setCantSuc(double cantSuc) {
		CantSuc = cantSuc;
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
    
    
	
}
