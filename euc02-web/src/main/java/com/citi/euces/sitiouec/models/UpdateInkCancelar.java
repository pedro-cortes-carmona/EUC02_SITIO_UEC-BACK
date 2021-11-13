package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class UpdateInkCancelar implements Serializable {

	private static final long serialVersionUID = 1L;

	private String soeidOpe;

	private String estatus;

	private String justificacion;

	private String observacionWeb;

	private String numAutoriEUC;

	private String idTasaAuto;

	public UpdateInkCancelar() {
		// TODO Auto-generated constructor stub
	}

	public String getSoeidOpe() {
		return soeidOpe;
	}

	public void setSoeidOpe(String soeidOpe) {
		this.soeidOpe = soeidOpe;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
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

	public String getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(String idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	@Override
	public String toString() {
		return "UpdateInkCancelar [soeidOpe=" + soeidOpe + ", estatus=" + estatus + ", justificacion=" + justificacion
				+ ", observacionWeb=" + observacionWeb + ", numAutoriEUC=" + numAutoriEUC + ", idTasaAuto=" + idTasaAuto
				+ "]";
	}

}
