package com.citi.euces.sitiouec.dto;

public class lnkSearchDatos_ClickResponseDTO {
	
	private String fecha;
	private Long num_regTasas;
	private Long num_regAcumulado;
	public lnkSearchDatos_ClickResponseDTO(String fecha, Long num_regTasas, Long num_regAcumulado) {
		super();
		this.fecha = fecha;
		this.num_regTasas = num_regTasas;
		this.num_regAcumulado = num_regAcumulado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Long getNum_regTasas() {
		return num_regTasas;
	}
	public void setNum_regTasas(Long num_regTasas) {
		this.num_regTasas = num_regTasas;
	}
	public Long getNum_regAcumulado() {
		return num_regAcumulado;
	}
	public void setNum_regAcumulado(Long num_regAcumulado) {
		this.num_regAcumulado = num_regAcumulado;
	}
	
	

}
