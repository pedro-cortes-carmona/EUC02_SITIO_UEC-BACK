package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class ResumenAutDivDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String division;
	private String campana;
    private Integer operaciones;
    private Double monto;
    private Double tasa_Prom;
    private Double cete;
    
    public ResumenAutDivDTO() {}
    
	public ResumenAutDivDTO(String division, String campana, Integer operaciones, Double monto, Double tasa_Prom,
			Double cete) {
		super();
		this.division = division;
		this.campana = campana;
		this.operaciones = operaciones;
		this.monto = monto;
		this.tasa_Prom = tasa_Prom;
		this.cete = cete;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getCampana() {
		return campana;
	}
	public void setCampana(String campana) {
		this.campana = campana;
	}
	public Integer getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(Integer operaciones) {
		this.operaciones = operaciones;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getTasa_Prom() {
		return tasa_Prom;
	}
	public void setTasa_Prom(Double tasa_Prom) {
		this.tasa_Prom = tasa_Prom;
	}
	public Double getCete() {
		return cete;
	}
	public void setCete(Double cete) {
		this.cete = cete;
	}
	
    
}
