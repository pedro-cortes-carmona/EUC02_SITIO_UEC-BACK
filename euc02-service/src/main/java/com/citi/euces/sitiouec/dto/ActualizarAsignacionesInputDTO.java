package com.citi.euces.sitiouec.dto;

public class ActualizarAsignacionesInputDTO {
	
	private Long online;
	
	private String soeid;
	
	private String nombre;
	
	public ActualizarAsignacionesInputDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getOnline() {
		return online;
	}

	public void setOnline(Long online) {
		this.online = online;
	}

	public String getSoeid() {
		return soeid;
	}

	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}

	@Override
	public String toString() {
		return "ActualizarAsignacionesInputDTO [online=" + online + ", soeid=" + soeid + ", nombre=" + nombre + "]";
	}

}
