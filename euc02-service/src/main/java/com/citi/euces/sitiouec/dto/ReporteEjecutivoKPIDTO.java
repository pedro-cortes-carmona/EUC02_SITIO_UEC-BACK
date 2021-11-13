package com.citi.euces.sitiouec.dto;

public class ReporteEjecutivoKPIDTO {

	private String fecha;
	private Integer asignadas;
	private Integer operadas;
	private double productividad;
	private Integer reprocesos;
	private double accuracy;
	private double fueraDeTiempo;
	private double timeliness;

	public Integer getAsignadas() {
		return asignadas;
	}

	public void setAsignadas(Integer asignadas) {
		this.asignadas = asignadas;
	}

	public Integer getOperadas() {
		return operadas;
	}

	public void setOperadas(Integer operadas) {
		this.operadas = operadas;
	}

	public Integer getReprocesos() {
		return reprocesos;
	}

	public void setReprocesos(Integer reprocesos) {
		this.reprocesos = reprocesos;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getProductividad() {
		return productividad;
	}

	public void setProductividad(double productividad) {
		this.productividad = productividad;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public double getFueraDeTiempo() {
		return fueraDeTiempo;
	}

	public void setFueraDeTiempo(double fueraDeTiempo) {
		this.fueraDeTiempo = fueraDeTiempo;
	}

	public double getTimeliness() {
		return timeliness;
	}

	public void setTimeliness(double timeliness) {
		this.timeliness = timeliness;
	}

	@Override
	public String toString() {
		return "ReporteEjecutivoKPIDTO [fecha=" + fecha + ", asignadas=" + asignadas + ", operadas=" + operadas
				+ ", productividad=" + productividad + ", reprocesos=" + reprocesos + ", accuracy=" + accuracy
				+ ", fueraDeTiempo=" + fueraDeTiempo + ", timeliness=" + timeliness + "]";
	}

}
