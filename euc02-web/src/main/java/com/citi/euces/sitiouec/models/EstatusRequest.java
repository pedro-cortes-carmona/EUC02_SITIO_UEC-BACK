package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class EstatusRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String soeid;
	private String idTasa;
	private String estatus;
	
	public EstatusRequest() {}
	
	public EstatusRequest(String soeid, String idTasa, String estatus) {
		super();
		this.soeid = soeid;
		this.idTasa = idTasa;
		this.estatus = estatus;
	}

	public String getSoeid() {
		return soeid;
	}

	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}

	public String getIdTasa() {
		return idTasa;
	}

	public void setIdTasa(String idTasa) {
		this.idTasa = idTasa;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
}
