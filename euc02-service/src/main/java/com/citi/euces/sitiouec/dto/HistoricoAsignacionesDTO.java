package com.citi.euces.sitiouec.dto;

import java.sql.Timestamp;

public class HistoricoAsignacionesDTO {

	private Long idTasaAuto;

	private String soeid;
	
	private String soeidAtendido;

	private java.sql.Timestamp fechaSoli;

	private java.sql.Timestamp fechaDesc;
	
	private String fechaSoliS;

	private String fechaDescS;

	private Long estatus;
	
	
	
	
	public HistoricoAsignacionesDTO() {
		// TODO Auto-generated constructor stub
	}
	
	


	public HistoricoAsignacionesDTO(Long idTasaAuto, String soeid, String soeidAtendido, Timestamp fechaSoli,
			Timestamp fechaDesc, Long estatus) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.soeid = soeid;
		this.soeidAtendido = soeidAtendido;
		this.fechaSoli = fechaSoli;
		this.fechaDesc = fechaDesc;
		this.estatus = estatus;
	}




	public Long getIdTasaAuto() {
		return idTasaAuto;
	}


	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}


	public String getSoeid() {
		return soeid;
	}


	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}


	public String getSoeidAtendido() {
		return soeidAtendido;
	}


	public void setSoeidAtendido(String soeidAtendido) {
		this.soeidAtendido = soeidAtendido;
	}


	public java.sql.Timestamp getFechaSoli() {
		return fechaSoli;
	}


	public void setFechaSoli(java.sql.Timestamp fechaSoli) {
		this.fechaSoli = fechaSoli;
	}


	public java.sql.Timestamp getFechaDesc() {
		return fechaDesc;
	}


	public void setFechaDesc(java.sql.Timestamp fechaDesc) {
		this.fechaDesc = fechaDesc;
	}


	public String getFechaSoliS() {
		return fechaSoliS;
	}


	public void setFechaSoliS(String fechaSoliS) {
		this.fechaSoliS = fechaSoliS;
	}


	public String getFechaDescS() {
		return fechaDescS;
	}


	public void setFechaDescS(String fechaDescS) {
		this.fechaDescS = fechaDescS;
	}


	public Long getEstatus() {
		return estatus;
	}


	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}


	@Override
	public String toString() {
		return "HistoricoAsignacionesDTO [idTasaAuto=" + idTasaAuto + ", soeid=" + soeid + ", soeidAtendido="
				+ soeidAtendido + ", fechaSoli=" + fechaSoli + ", fechaDesc=" + fechaDesc + ", fechaSoliS=" + fechaSoliS
				+ ", fechaDescS=" + fechaDescS + ", estatus=" + estatus + "]";
	}
	
	
	
	
	
	
	

}
