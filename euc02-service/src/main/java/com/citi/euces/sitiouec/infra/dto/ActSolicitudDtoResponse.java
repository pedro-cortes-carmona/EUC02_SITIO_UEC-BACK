package com.citi.euces.sitiouec.infra.dto;


public class ActSolicitudDtoResponse {
	
	 private String mnsj;
	 private Boolean status;
	 private String code;
	/**
	 * 
	 */
	public ActSolicitudDtoResponse() {
		super();
	}
	/**
	 * @return the mnsj
	 */
	public String getMnsj() {
		return mnsj;
	}
	/**
	 * @param mnsj the mnsj to set
	 */
	public void setMnsj(String mnsj) {
		this.mnsj = mnsj;
	}
	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActSolicitudDtoResponse [mnsj=").append(mnsj).append(", status=").append(status)
				.append(", code=").append(code).append("]");
		return builder.toString();
	}

	 

}
