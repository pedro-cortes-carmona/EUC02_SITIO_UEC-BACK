package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class SolicitudesAplicadasRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fechaBusqueda;
	
	public String getFechaBusqueda() {
		return fechaBusqueda;
	}
	public void setFechaBusqueda(String fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}

	
	
}
