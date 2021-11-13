package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class BoletinesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private Integer operacionesMen;
	private Double montoMen;
	private Double tpMen;
	private Integer operacionAnual;
	private Double montoAnual;
	private Double tpAnual;
	private Double subProductoMen;
	private Double subProductoAnual;
	
	public BoletinesDTO() {}
	
	public BoletinesDTO(String descripcion, Integer operacionesMen, Double montoMen, Double tpMen,
			Double subProductoMen) {
		super();
		this.descripcion = descripcion;
		this.operacionesMen = operacionesMen;
		this.montoMen = montoMen;
		this.tpMen = tpMen;
		this.subProductoMen = subProductoMen;
	}

	public BoletinesDTO(String descripcion, Integer operacionesMen, Double montoMen, Double tpMen,
			Integer operacionAnual, Double montoAnual, Double tpAnual, Double subProductoMen, Double subProductoAnual) {
		super();
		this.descripcion = descripcion;
		this.operacionesMen = operacionesMen;
		this.montoMen = montoMen;
		this.tpMen = tpMen;
		this.operacionAnual = operacionAnual;
		this.montoAnual = montoAnual;
		this.tpAnual = tpAnual;
		this.subProductoMen = subProductoMen;
		this.subProductoAnual = subProductoAnual;
	}

	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getOperacionesMen() {
		return operacionesMen;
	}

	public void setOperacionesMen(Integer operacionesMen) {
		this.operacionesMen = operacionesMen;
	}

	public Double getMontoMen() {
		return montoMen;
	}

	public void setMontoMen(Double montoMen) {
		this.montoMen = montoMen;
	}

	public Double getTpMen() {
		return tpMen;
	}

	public void setTpMen(Double tpMen) {
		this.tpMen = tpMen;
	}

	public Integer getOperacionAnual() {
		return operacionAnual;
	}

	public void setOperacionAnual(Integer operacionAnual) {
		this.operacionAnual = operacionAnual;
	}

	public Double getMontoAnual() {
		return montoAnual;
	}

	public void setMontoAnual(Double montoAnual) {
		this.montoAnual = montoAnual;
	}

	public Double getTpAnual() {
		return tpAnual;
	}

	public void setTpAnual(Double tpAnual) {
		this.tpAnual = tpAnual;
	}

	public Double getSubProductoMen() {
		return subProductoMen;
	}

	public void setSubProductoMen(Double subProductoMen) {
		this.subProductoMen = subProductoMen;
	}

	public Double getSubProductoAnual() {
		return subProductoAnual;
	}

	public void setSubProductoAnual(Double subProductoAnual) {
		this.subProductoAnual = subProductoAnual;
	}
	
	

	
}
