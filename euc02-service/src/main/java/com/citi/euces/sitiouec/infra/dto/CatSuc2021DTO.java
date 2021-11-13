package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class CatSuc2021DTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer sirh;
	private String sucursal;
	private String division;
	
	public CatSuc2021DTO() {}

	public CatSuc2021DTO(Integer sirh, String sucursal, String division) {
		super();
		this.sirh = sirh;
		this.sucursal = sucursal;
		this.division = division;
	}

	public Integer getSirh() {
		return sirh;
	}

	public void setSirh(Integer sirh) {
		this.sirh = sirh;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	
}
