package com.citi.euces.sitiouec.dto;

public class SucursalGerenciaVentasResponseDTO {
	
	private double CantVentasCam;
	private double VentasCam;
	
	public SucursalGerenciaVentasResponseDTO(double cantVentasCam, double ventasCam) {
		super();
		CantVentasCam = cantVentasCam;
		VentasCam = ventasCam;
	}
	

	public SucursalGerenciaVentasResponseDTO() {
		super();
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
