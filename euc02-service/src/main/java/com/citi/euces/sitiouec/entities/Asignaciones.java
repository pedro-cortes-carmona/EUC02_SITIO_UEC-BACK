package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_ASIGNACIONES") // TSC_EUCS_OWN
public class Asignaciones {
	

	@Id
	@Column(name = "ID", nullable = true)
	private String id;

	@Column(name = "SOEID", nullable = true)
	private String soeid;

	@Column(name = "ONLINE_", nullable = true)
	private Long online;

	@Column(name = "NOMBRE", nullable = true)
	private String nombre;

	
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
		return "Asignaciones [id=" + id + ", soeid=" + soeid + ", online=" + online + ", nombre=" + nombre + "]";
	}

}
