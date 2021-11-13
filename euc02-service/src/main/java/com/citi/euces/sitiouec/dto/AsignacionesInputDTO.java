package com.citi.euces.sitiouec.dto;

public class AsignacionesInputDTO {

	private String soeid;
	private String puesto;

	public AsignacionesInputDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getSoeid() {
		return soeid;
	}

	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "AsignacionesInputDTO [soeid=" + soeid + ", puesto=" + puesto + "]";
	}

}
