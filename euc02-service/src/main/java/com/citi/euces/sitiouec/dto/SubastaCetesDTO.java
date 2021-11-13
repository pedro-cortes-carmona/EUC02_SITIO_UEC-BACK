package com.citi.euces.sitiouec.dto;

import java.util.Date;

public class SubastaCetesDTO {
	

	private Date fecha;

	private Long cete1plazo;

	private Double cete1tasa;

	private Long cete2plazo;

	private Double cete2tasa;

	private Long cete3plazo;

	private Double cete3tasa;

	private Long cete4plazo;

	private Double cete4tasa;

	
	public SubastaCetesDTO() {
		// TODO Auto-generated constructor stub
	}

	public SubastaCetesDTO(Long cete4plazo, Double cete4tasa) {
		super();
		this.cete4plazo = cete4plazo;
		this.cete4tasa = cete4tasa;
	}
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getCete1plazo() {
		return cete1plazo;
	}

	public void setCete1plazo(Long cete1plazo) {
		this.cete1plazo = cete1plazo;
	}

	public Double getCete1tasa() {
		return cete1tasa;
	}

	public void setCete1tasa(Double cete1tasa) {
		this.cete1tasa = cete1tasa;
	}

	public Long getCete2plazo() {
		return cete2plazo;
	}

	public void setCete2plazo(Long cete2plazo) {
		this.cete2plazo = cete2plazo;
	}

	public Double getCete2tasa() {
		return cete2tasa;
	}

	public void setCete2tasa(Double cete2tasa) {
		this.cete2tasa = cete2tasa;
	}

	public Long getCete3plazo() {
		return cete3plazo;
	}

	public void setCete3plazo(Long cete3plazo) {
		this.cete3plazo = cete3plazo;
	}

	public Double getCete3tasa() {
		return cete3tasa;
	}

	public void setCete3tasa(Double cete3tasa) {
		this.cete3tasa = cete3tasa;
	}

	public Long getCete4plazo() {
		return cete4plazo;
	}

	public void setCete4plazo(Long cete4plazo) {
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
		return "SubastaCetesDTO [fecha=" + fecha + ", cete1plazo=" + cete1plazo + ", cete1tasa=" + cete1tasa
				+ ", cete2plazo=" + cete2plazo + ", cete2tasa=" + cete2tasa + ", cete3plazo=" + cete3plazo
				+ ", cete3tasa=" + cete3tasa + ", cete4plazo=" + cete4plazo + ", cete4tasa=" + cete4tasa + "]";
	}

}
