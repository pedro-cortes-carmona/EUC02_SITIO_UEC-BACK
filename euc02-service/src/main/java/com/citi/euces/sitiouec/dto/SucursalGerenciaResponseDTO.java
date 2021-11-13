package com.citi.euces.sitiouec.dto;

import java.util.List;

public class SucursalGerenciaResponseDTO {
	
	private int RK;
	private String DIVISION;
	private String Region;
	private String DISTRITO;
	private String Mercado;
	private Long Suc;
	private String Nomina;
	
	
	private double VENTAS;
	private double MONTO;
	private double MONTOVENTAS;
	private double cantsuc;
	private double cantejec;
	private double CantSucSinVentas;
	private double CantSucConVentas;
	private double Per_Capita;
	
	private SucursalGerenciaVentasResponseDTO ventaImporte;
	private List<SucursalGerenciaVentasResponseDTO> ventaImporte2;
	
	 public List<SucursalGerenciaVentasResponseDTO> getVentaImporte2() {
		return ventaImporte2;
	}

	public void setVentaImporte2(List<SucursalGerenciaVentasResponseDTO> ventaImporte2) {
		this.ventaImporte2 = ventaImporte2;
	}

	SucursalGerenciaResponseDTO() {
		super();
	}
		
	/**
	 * @param dIVISION
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
	public SucursalGerenciaResponseDTO(String dIVISION, double vENTAS, double mONTO, double mONTOVENTAS, double cantsuc,
			double cantejec, double cantSucSinVentas, double cantSucConVentas, double per_Capita, int rK) {
		super();
		DIVISION = dIVISION;
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

	public SucursalGerenciaResponseDTO(String dIVISION, String dISTRITO, double vENTAS, double mONTO,
			double mONTOVENTAS, double cantsuc, double cantejec, double cantSucSinVentas, double cantSucConVentas,
			double per_Capita, int rK) {
		super();
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
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
	
	public SucursalGerenciaResponseDTO(String dIVISION, String dISTRITO, Long sUC, double vENTAS, double mONTO,
			double mONTOVENTAS, double cantsuc, double cantejec, double cantSucSinVentas, double cantSucConVentas,
			double per_Capita, int rK) {
		super();
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
		Suc = sUC;
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

	public int getRK() {
		return RK;
	}

	public void setRK(int rK) {
		RK = rK;
	}

	public String getDIVISION() {
		return DIVISION;
	}

	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getDISTRITO() {
		return DISTRITO;
	}

	public void setDISTRITO(String dISTRITO) {
		DISTRITO = dISTRITO;
	}

	public String getMercado() {
		return Mercado;
	}

	public void setMercado(String mercado) {
		Mercado = mercado;
	}

	public Long getSuc() {
		return Suc;
	}

	public void setSuc(Long suc) {
		Suc = suc;
	}

	public String getNomina() {
		return Nomina;
	}

	public void setNomina(String nomina) {
		Nomina = nomina;
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

	public SucursalGerenciaVentasResponseDTO getVentaImporte() {
		return ventaImporte;
	}

	public void setVentaImporte(SucursalGerenciaVentasResponseDTO ventaImporte) {
		this.ventaImporte = ventaImporte;
	}
	
	



	
}
