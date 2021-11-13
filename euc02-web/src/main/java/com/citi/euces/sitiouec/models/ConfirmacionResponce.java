package com.citi.euces.sitiouec.models;


public class ConfirmacionResponce {

	private String mensaje;
	private String code;
	/**
	 * @param mensaje
	 * @param code
	 */
	public ConfirmacionResponce(String mensaje, String code) {
		super();
		this.mensaje = mensaje;
		this.code = code;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
