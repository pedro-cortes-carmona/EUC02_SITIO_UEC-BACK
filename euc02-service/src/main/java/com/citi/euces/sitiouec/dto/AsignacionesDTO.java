package com.citi.euces.sitiouec.dto;

public class AsignacionesDTO {

	private String id;

	private String soeid;

	private Long online;

	private String nombre;

	public AsignacionesDTO(String id, String soeid, Long online, String nombre) {
		super();
		this.id = id;
		this.soeid = soeid;
		this.online = online;
		this.nombre = nombre;
	}

	public AsignacionesDTO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public AsignacionesDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "AsignacionesDTO [id=" + id + ", soeid=" + soeid + ", online=" + online + ", nombre=" + nombre + "]";
	}

}
