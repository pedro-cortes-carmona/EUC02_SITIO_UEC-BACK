package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class ResumenDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estatusUEC;
	private String estatusPLA;      
    private String campana;
    private Double monto;
    private Integer operaciones;
    private Double subTotal;
    private Integer aplicado;
    private Double aplicadoMonto;
    private Integer noAplicado;
    private Double noAplicadoMonto;
    private Integer noLocalizado;
    private Double noLocalizadoMonto;
    
    public ResumenDTO() {}
    
	public ResumenDTO(String estatusUEC, String estatusPLA, String campana, Double monto) {
		super();
		this.estatusUEC = estatusUEC;
		this.estatusPLA = estatusPLA;
		this.campana = campana;
		this.monto = monto;
	}
	
	
	
	public ResumenDTO(String estatusUEC, String estatusPLA, String campana, Double monto, Integer operaciones,
			Double subTotal, Integer aplicado, Double aplicadoMonto, Integer noAplicado, Double noAplicadoMonto,
			Integer noLocalizado, Double noLocalizadoMonto) {
		super();
		this.estatusUEC = estatusUEC;
		this.estatusPLA = estatusPLA;
		this.campana = campana;
		this.monto = monto;
		this.operaciones = operaciones;
		this.subTotal = subTotal;
		this.aplicado = aplicado;
		this.aplicadoMonto = aplicadoMonto;
		this.noAplicado = noAplicado;
		this.noAplicadoMonto = noAplicadoMonto;
		this.noLocalizado = noLocalizado;
		this.noLocalizadoMonto = noLocalizadoMonto;
	}

	public String getEstatusUEC() {
		return estatusUEC;
	}
	public void setEstatusUEC(String estatusUEC) {
		this.estatusUEC = estatusUEC;
	}
	public String getEstatusPLA() {
		return estatusPLA;
	}
	public void setEstatusPLA(String estatusPLA) {
		this.estatusPLA = estatusPLA;
	}
	public String getCampana() {
		return campana;
	}
	public void setCampana(String campana) {
		this.campana = campana;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Integer getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(Integer operaciones) {
		this.operaciones = operaciones;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Integer getAplicado() {
		return aplicado;
	}
	public void setAplicado(Integer aplicado) {
		this.aplicado = aplicado;
	}
	public Double getAplicadoMonto() {
		return aplicadoMonto;
	}
	public void setAplicadoMonto(Double aplicadoMonto) {
		this.aplicadoMonto = aplicadoMonto;
	}
	public Integer getNoAplicado() {
		return noAplicado;
	}
	public void setNoAplicado(Integer noAplicado) {
		this.noAplicado = noAplicado;
	}
	public Double getNoAplicadoMonto() {
		return noAplicadoMonto;
	}
	public void setNoAplicadoMonto(Double noAplicadoMonto) {
		this.noAplicadoMonto = noAplicadoMonto;
	}
	public Integer getNoLocalizado() {
		return noLocalizado;
	}
	public void setNoLocalizado(Integer noLocalizado) {
		this.noLocalizado = noLocalizado;
	}
	public Double getNoLocalizadoMonto() {
		return noLocalizadoMonto;
	}
	public void setNoLocalizadoMonto(Double noLocalizadoMonto) {
		this.noLocalizadoMonto = noLocalizadoMonto;
	}
	
    
}
