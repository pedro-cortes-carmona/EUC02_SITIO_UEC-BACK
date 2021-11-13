package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class TasasTotal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer total;
	private Double monto;
	
	public TasasTotal() {}
	
	public TasasTotal(Integer total, Double monto) {
		super();
		this.total = total;
		this.monto = monto;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	
	
}
