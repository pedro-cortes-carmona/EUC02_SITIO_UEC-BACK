package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class ReporteArchivoDiaCargaRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fecha1;
	private String fecha2;
	
	
	public String getFecha1() {
		return fecha1;
	}
	public void setFecha1(String fecha1) {
		this.fecha1 = fecha1;
	}
	public String getFecha2() {
		return fecha2;
	}
	public void setFecha2(String fecha2) {
		this.fecha2 = fecha2;
	}
	
	

	
}
