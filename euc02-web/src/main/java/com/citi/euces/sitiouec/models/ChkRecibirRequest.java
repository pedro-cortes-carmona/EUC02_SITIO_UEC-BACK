package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class ChkRecibirRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String soeid;
	
	private String online;
	
	private String nombre;
	
	private String action;
	
		
	public String getSoeid() {
		return soeid;
	}

	
	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}


	public String getOnline() {
		return online;
	}


	public void setOnline(String online) {
		this.online = online;
	}

	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	@Override
	public String toString() {
		return "ChkRecibirDTO [soeid="+soeid+", online=" + online + ",nombre=" + nombre +", action=" + action + "]";
	}

}
