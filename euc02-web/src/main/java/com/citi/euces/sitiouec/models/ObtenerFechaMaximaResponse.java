package com.citi.euces.sitiouec.models;



public class ObtenerFechaMaximaResponse {
	
	private String fecha;
	private String code;
	/**
	 * @param fecha
	 * @param code
	 */
	public ObtenerFechaMaximaResponse(String fecha, String code) {
		super();
		this.fecha = fecha;
		this.code = code;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
