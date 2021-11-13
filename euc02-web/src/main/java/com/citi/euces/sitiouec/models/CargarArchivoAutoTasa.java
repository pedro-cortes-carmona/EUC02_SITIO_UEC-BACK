package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class CargarArchivoAutoTasa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String file;
	private String fecha_inicio;
	private String fecha_fin;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
