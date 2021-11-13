package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class InsertAutorizadoresRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String soeid;
	
	private String soeidDivisional;
	
	private String soeidDistrital;
	
	private String division;
	
	private String distrito;
	
	private String nombre;
	
	private String inic;
	
	private String fechaInicio;
	
	private String fechaTermino;
	
	private Long alta;
	
	private String correo;
	
	private Long isCete100;
	
	private Long isCampesp;
	
	private Long idNivelAuto;
	
	
	
	public String getSoeid() {
		return soeid;
	}





	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}





	public String getSoeidDivisional() {
		return soeidDivisional;
	}





	public void setSoeidDivisional(String soeidDivisional) {
		this.soeidDivisional = soeidDivisional;
	}





	public String getSoeidDistrital() {
		return soeidDistrital;
	}





	public void setSoeidDistrital(String soeidDistrital) {
		this.soeidDistrital = soeidDistrital;
	}





	public String getDivision() {
		return division;
	}





	public void setDivision(String division) {
		this.division = division;
	}





	public String getDistrito() {
		return distrito;
	}





	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getInic() {
		return inic;
	}





	public void setInic(String inic) {
		this.inic = inic;
	}





	public String getFechaInicio() {
		return fechaInicio;
	}





	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}





	public String getFechaTermino() {
		return fechaTermino;
	}





	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}





	public Long getAlta() {
		return alta;
	}





	public void setAlta(Long alta) {
		this.alta = alta;
	}





	public String getCorreo() {
		return correo;
	}





	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public Long getIsCete100() {
		return isCete100;
	}





	public void setIsCete100(Long isCete100) {
		this.isCete100 = isCete100;
	}





	public Long getIsCampesp() {
		return isCampesp;
	}





	public void setIsCampesp(Long isCampesp) {
		this.isCampesp = isCampesp;
	}





	public Long getIdNivelAuto() {
		return idNivelAuto;
	}





	public void setIdNivelAuto(Long idNivelAuto) {
		this.idNivelAuto = idNivelAuto;
	}





	@Override
	public String toString() {
		return "InsertAutorizadoresRequest [soeid = "+soeid+", soeidDivisional = "+soeidDivisional+", soeidDistrital = "+soeidDistrital+", "
				+ "division = "+division+", distrito = "+distrito+", nombre = "+nombre+", inic = "+inic+", fechaInicio = "+fechaInicio+", "
				+ "fechaTermino = "+fechaTermino+", alta="+alta+", correo = "+correo+", isCete100="+isCete100+", isCampesp = "+isCampesp+","
				+ " idNivelAuto = "+idNivelAuto+"]";
	}

}
