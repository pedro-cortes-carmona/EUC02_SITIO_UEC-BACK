package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class AutoTasaSoeidDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String SOEID_ASIG;
	private Long max;

	/**
	 * 
	 */
	public AutoTasaSoeidDTO() {
	}

	/**
	 * @param sOEID_ASIG
	 */
	public AutoTasaSoeidDTO(String sOEID_ASIG) {
		SOEID_ASIG = sOEID_ASIG;
	}

	/**
	 * @param max
	 */
	public AutoTasaSoeidDTO(Long max) {
		super();
		this.max = max;
	}

	/**
	 * @return the sOEID_ASIG
	 */
	public String getSOEID_ASIG() {
		return SOEID_ASIG;
	}

	/**
	 * @param sOEID_ASIG the sOEID_ASIG to set
	 */
	public void setSOEID_ASIG(String sOEID_ASIG) {
		SOEID_ASIG = sOEID_ASIG;
	}

	/**
	 * @return the max
	 */
	public Long getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(Long max) {
		this.max = max;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AutoTasasDTO [SOEID_ASIG=");
		builder.append(SOEID_ASIG);
		builder.append(", max=");
		builder.append(max);
		builder.append("]");
		return builder.toString();
	}

	
	
}
