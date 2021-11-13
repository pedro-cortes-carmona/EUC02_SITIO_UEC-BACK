package com.citi.euces.sitiouec.dto;

public class ReporteAccuracyDTO {

	private String fecha;

	private double volumen;

	private double cntRepro;

	private double meta;

	private double porcenAccuracy;

	private double cntTimeliness;

	private double porcenTimeliness;
	
	public ReporteAccuracyDTO() {
		// TODO Auto-generated constructor stub
	}

	public double getCntTimeliness() {
		return cntTimeliness;
	}

	public void setCntTimeliness(double cntTimeliness) {
		this.cntTimeliness = cntTimeliness;
	}

	public double getPorcenTimeliness() {
		return porcenTimeliness;
	}

	public void setPorcenTimeliness(double porcenTimeliness) {
		this.porcenTimeliness = porcenTimeliness;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public double getCntRepro() {
		return cntRepro;
	}

	public void setCntRepro(double cntRepro) {
		this.cntRepro = cntRepro;
	}

	public double getMeta() {
		return meta;
	}

	public void setMeta(double meta) {
		this.meta = meta;
	}

	public double getPorcenAccuracy() {
		return porcenAccuracy;
	}

	public void setPorcenAccuracy(double porcenAccuracy) {
		this.porcenAccuracy = porcenAccuracy;
	}

	@Override
	public String toString() {
		return "ReporteAccuracyDTO [fecha=" + fecha + ", volumen=" + volumen + ", cntRepro=" + cntRepro + ", meta="
				+ meta + ", porcenAccuracy=" + porcenAccuracy + "]";
	}

}
