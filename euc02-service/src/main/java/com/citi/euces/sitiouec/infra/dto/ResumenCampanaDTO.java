package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class ResumenCampanaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String estatus;
	private String subTotal;
	private String monto;
	private String campana;
	
	public ResumenCampanaDTO() {}

	public ResumenCampanaDTO(String estatus, String subTotal, String monto, String campana) {
		super();
		this.estatus = estatus;
		this.subTotal = subTotal;
		this.monto = monto;
		this.campana = campana;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getCampana() {
		return campana;
	}

	public void setCampana(String campana) {
		this.campana = campana;
	}
	
	
	
}
