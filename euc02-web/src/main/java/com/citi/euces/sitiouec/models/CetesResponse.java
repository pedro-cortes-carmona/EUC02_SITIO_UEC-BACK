package com.citi.euces.sitiouec.models;

public class CetesResponse {

	private String archivo;
	private String code;

	public CetesResponse(String archivo, String code) {
		super();
		this.archivo = archivo;
		this.code = code;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "CetesResponse [archivo=" + archivo + ", code=" + code + "]";
	}
	
	
	

}
