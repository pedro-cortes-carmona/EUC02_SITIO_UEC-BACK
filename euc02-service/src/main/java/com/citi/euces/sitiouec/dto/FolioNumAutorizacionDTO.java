package com.citi.euces.sitiouec.dto;

import java.sql.Timestamp;

public class FolioNumAutorizacionDTO {
	
	private Long idTasaAuto;
	
	private java.sql.Timestamp fechaSoli;
	
	private String estatus;
	
	private String soeidAsig;	
	
	private Long numAutoriEuc;
	
	
	
	
	public FolioNumAutorizacionDTO(Long idTasaAuto, Timestamp fechaSoli, String estatus, String soeidAsig,
			Long numAutoriEuc) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaSoli = fechaSoli;
		this.estatus = estatus;
		this.soeidAsig = soeidAsig;
		this.numAutoriEuc = numAutoriEuc;
	}


	public FolioNumAutorizacionDTO() {
		// TODO Auto-generated constructor stub
	}


	public Long getIdTasaAuto() {
		return idTasaAuto;
	}


	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}


	public java.sql.Timestamp getFechaSoli() {
		return fechaSoli;
	}


	public void setFechaSoli(java.sql.Timestamp fechaSoli) {
		this.fechaSoli = fechaSoli;
	}


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	public String getSoeidAsig() {
		return soeidAsig;
	}


	public void setSoeidAsig(String soeidAsig) {
		this.soeidAsig = soeidAsig;
	}


	public Long getNumAutoriEuc() {
		return numAutoriEuc;
	}


	public void setNumAutoriEuc(Long numAutoriEuc) {
		this.numAutoriEuc = numAutoriEuc;
	}


	@Override
	public String toString() {
		return "FolioNumAutorizacionDTO [idTasaAuto=" + idTasaAuto + ", fechaSoli=" + fechaSoli + ", estatus=" + estatus
				+ ", soeidAsig=" + soeidAsig + ", numAutoriEuc=" + numAutoriEuc + "]";
	}
	
	
	
	
	
	
	

}
