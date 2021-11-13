package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class UpdateInRechazarCancelar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String soeidOpe;
	
	private String fechaEstatus;
	
	private String justificacion;
	
	private String observacionWeb;
	
	private String numAutoriEUC;
	
	private String estatus;
	
	private String idTasaAuto;
	
	
	public String getSoeidOpe() {
		return soeidOpe;
	}
	
	public void setSoeidOpe(String soeidOpe) {
		this.soeidOpe = soeidOpe;
	}
	
	public String getFechaEstatus() {
		return fechaEstatus;
	}
	
	public void setFechaEstatus(String fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}
	
	public String getJustificacion() {
		return justificacion;
	}
	
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	
	public String getObservacionWeb() {
		return observacionWeb;
	}
	
	public void setObservacionWeb(String observacionWeb) {
		this.observacionWeb = observacionWeb;
	}
	
	public String getNumAutoriEUC() {
		return numAutoriEUC;
	}
	
	public void setNumAutoriEUC(String numAutoriEUC) {
		this.numAutoriEUC = numAutoriEUC;
	}
	
	public String getEstatus() {
		return estatus;
	}
	
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	public String getIdTasaAuto() {
		return idTasaAuto;
	}
	
	public void setIdTasaAuto(String idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}
	
	@Override
	public String toString() {
		return "UpdateInRechazarCancelar [soeidOpe="+soeidOpe+", fechaEstatus=" + fechaEstatus +", justificacion=" + justificacion + ", observacionWeb=" + observacionWeb + ", numAutoriEUC=" + numAutoriEUC + 
				", estatus=" + estatus +", idTasaAuto=" + idTasaAuto +"]";
	}
	

}
