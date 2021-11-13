package com.citi.euces.sitiouec.dto;

public class AsignacionesRevolverDTO {

	private String soeid;

	private Long online;

	public AsignacionesRevolverDTO() {
		// TODO Auto-generated constructor stub
	}

	public AsignacionesRevolverDTO(String soeid, Long online) {
		super();
		this.soeid = soeid;
		this.online = online;
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
		return "AsignacionesRevolverDTO [soeid=" + soeid + ", online=" + online + "]";
	}

	
	
	
	
}
