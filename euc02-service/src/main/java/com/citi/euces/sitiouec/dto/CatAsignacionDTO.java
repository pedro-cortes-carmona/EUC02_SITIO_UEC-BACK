package com.citi.euces.sitiouec.dto;

/**
 * 
 *   @author cesar.alducin
 *
 *   Cat_AsignacionBE 
 * 
 */

public class CatAsignacionDTO {

	private String soeid;

	private Long online;

	public CatAsignacionDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getSoeid() {
		return soeid;
	}

	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}

	public Long getOnline() {
		return online;
	}

	public void setOnline(Long online) {
		this.online = online;
	}

	@Override
	public String toString() {
		return "CatAsignacionDTO [soeid=" + soeid + ", online=" + online + "]";
	}

}
