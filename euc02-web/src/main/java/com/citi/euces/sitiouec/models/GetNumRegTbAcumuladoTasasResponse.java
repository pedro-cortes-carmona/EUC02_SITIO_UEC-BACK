package com.citi.euces.sitiouec.models;

public class GetNumRegTbAcumuladoTasasResponse {
	
	private Long total;
	private String code;
	/**
	 * @param total
	 * @param code
	 */
	public GetNumRegTbAcumuladoTasasResponse(Long total, String code) {
		super();
		this.total = total;
		this.code = code;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
