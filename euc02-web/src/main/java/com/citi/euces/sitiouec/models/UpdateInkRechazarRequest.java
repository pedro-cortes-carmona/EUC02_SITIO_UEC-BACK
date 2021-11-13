package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class UpdateInkRechazarRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String soeidOpe;
	
	private String justificacion;
	
	private String observaWeb;
	
	private String idTasaAuto;
	
	private String fechaSolicitud;
	
	
	
	public String getSoeidOpe() {
		return soeidOpe;
	}

	public void setSoeidOpe(String soeidOpe) {
		this.soeidOpe = soeidOpe;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public String getObservaWeb() {
		return observaWeb;
	}

	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}
	
	public String getId_tasaAuto() {
		return idTasaAuto;
	}

	public void setId_tasaAuto(String id_tasaAuto) {
		this.idTasaAuto = id_tasaAuto;
	}
	
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	@Override
	public String toString() {
		return "UpdateInkRechazarRequest [soeidOpe=" + soeidOpe + ", justificacion=" + justificacion + ", observaWeb="
				+ observaWeb + ", idTasaAuto=" + idTasaAuto + ", fechaSolicitud=" + fechaSolicitud + "]";
	}



	
}
