package com.citi.euces.sitiouec.dto;

public class SucursalGerenciaResponseSumaDTO {
	
	private String TIPO;
	private double VENTAS;
	private double MONTO;
	private double MONTOVENTAS;
	private double cantsuc;
	private double cantejec;
	private double CantSucSinVentas;
	private double CantSucConVentas;
	private double Per_Capita;
	private double CantVentasCam;
	private double VentasCam;
	public SucursalGerenciaResponseSumaDTO(String tIPO, double vENTAS, double mONTO, double mONTOVENTAS, double cantsuc,
			double cantejec, double cantSucSinVentas, double cantSucConVentas, double per_Capita, double cantVentasCam,
			double ventasCam) {
		super();
		TIPO = tIPO;
		VENTAS = vENTAS;
		MONTO = mONTO;
		MONTOVENTAS = mONTOVENTAS;
		this.cantsuc = cantsuc;
		this.cantejec = cantejec;
		CantSucSinVentas = cantSucSinVentas;
		CantSucConVentas = cantSucConVentas;
		Per_Capita = per_Capita;
		CantVentasCam = cantVentasCam;
		VentasCam = ventasCam;
	}
	public String getTIPO() {
		return TIPO;
	}
	public void setTIPO(String tIPO) {
		TIPO = tIPO;
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
	public double getCantVentasCam() {
		return CantVentasCam;
	}
	public void setCantVentasCam(double cantVentasCam) {
		CantVentasCam = cantVentasCam;
	}
	public double getVentasCam() {
		return VentasCam;
	}
	public void setVentasCam(double ventasCam) {
		VentasCam = ventasCam;
	}
	
	
	
	

}
