package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class RegionesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long sirh;
	private String division;
	private String distrito;
	
	public RegionesDTO() {}
	
	public RegionesDTO(Long sirh, String division, String distrito) {
		super();
		this.sirh = sirh;
		this.division = division;
		this.distrito = distrito;
	}

	/**
	 * @param distrito
	 */
	public RegionesDTO(String distrito) {
		super();
		this.distrito = distrito;
	}

	public Long getSirh() {
		return sirh;
	}

	public void setSirh(Long sirh) {
		this.sirh = sirh;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegionesDTO [sirh=").append(sirh).append(", division=").append(division).append(", distrito=")
				.append(distrito).append("]");
		return builder.toString();
	}
	
	
	
}
