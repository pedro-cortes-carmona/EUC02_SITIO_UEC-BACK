package com.citi.euces.sitiouec.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author cesar.alducin
 * 
 * HistoricoCetesDTO - Histo_CeteBE 
 *
 */
public class HistoricoCetesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date fecha;
	
	private Double cete1plazo;
	
	private Double cete1tasa;
	
	private Double cete2plazo;
	
	private Double cete2tasa;
	
	private Double cete3plazo;
	
	private Double cete3tasa;
	
	private Double cete4plazo;
	
	private Double cete4tasa;
	
		
	public HistoricoCetesDTO() {
		
	}

	public HistoricoCetesDTO(Date fecha, Double cete1plazo, Double cete1tasa, Double cete2plazo, Double cete2tasa,
			Double cete3plazo, Double cete3tasa, Double cete4plazo, Double cete4tasa) {
		super();
		this.fecha = fecha;
		this.cete1plazo = cete1plazo;
		this.cete1tasa = cete1tasa;
		this.cete2plazo = cete2plazo;
		this.cete2tasa = cete2tasa;
		this.cete3plazo = cete3plazo;
		this.cete3tasa = cete3tasa;
		this.cete4plazo = cete4plazo;
		this.cete4tasa = cete4tasa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getCete1plazo() {
		return cete1plazo;
	}

	public void setCete1plazo(Double cete1plazo) {
		this.cete1plazo = cete1plazo;
	}

	public Double getCete1tasa() {
		return cete1tasa;
	}

	public void setCete1tasa(Double cete1tasa) {
		this.cete1tasa = cete1tasa;
	}

	public Double getCete2plazo() {
		return cete2plazo;
	}

	public void setCete2plazo(Double cete2plazo) {
		this.cete2plazo = cete2plazo;
	}

	public Double getCete2tasa() {
		return cete2tasa;
	}

	public void setCete2tasa(Double cete2tasa) {
		this.cete2tasa = cete2tasa;
	}

	public Double getCete3plazo() {
		return cete3plazo;
	}

	public void setCete3plazo(Double cete3plazo) {
		this.cete3plazo = cete3plazo;
	}

	public Double getCete3tasa() {
		return cete3tasa;
	}

	public void setCete3tasa(Double cete3tasa) {
		this.cete3tasa = cete3tasa;
	}

	public Double getCete4plazo() {
		return cete4plazo;
	}

	public void setCete4plazo(Double cete4plazo) {
		this.cete4plazo = cete4plazo;
	}

	public Double getCete4tasa() {
		return cete4tasa;
	}

	public void setCete4tasa(Double cete4tasa) {
		this.cete4tasa = cete4tasa;
	}

	@Override
	public String toString() {
		return "HistoricoCetesDTO [fecha=" + fecha + ", cete1plazo=" + cete1plazo + ", cete1tasa=" + cete1tasa
				+ ", cete2plazo=" + cete2plazo + ", cete2tasa=" + cete2tasa + ", cete3plazo=" + cete3plazo
				+ ", cete3tasa=" + cete3tasa + ", cete4plazo=" + cete4plazo + ", cete4tasa=" + cete4tasa + "]";
	}

	
}
