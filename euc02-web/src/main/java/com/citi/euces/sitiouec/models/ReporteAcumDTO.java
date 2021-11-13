package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class ReporteAcumDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fecha;
	private String campana;
	private  boolean is_ejec_priority;
    private boolean is_Premio;
    private boolean enablePM;
    
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCampana() {
		return campana;
	}
	public void setCampana(String campana) {
		this.campana = campana;
	}
	public boolean isIs_ejec_priority() {
		return is_ejec_priority;
	}
	public void setIs_ejec_priority(boolean is_ejec_priority) {
		this.is_ejec_priority = is_ejec_priority;
	}
	public boolean isIs_Premio() {
		return is_Premio;
	}
	public void setIs_Premio(boolean is_Premio) {
		this.is_Premio = is_Premio;
	}
	public boolean isEnablePM() {
		return enablePM;
	}
	public void setEnablePM(boolean enablePM) {
		this.enablePM = enablePM;
	}
    
    
}
