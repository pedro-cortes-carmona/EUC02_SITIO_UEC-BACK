package com.citi.euces.sitiouec.dto;

import java.util.Date;

public class FechasFestivasDTO {

	private Long idFecha;

	private Date fecha;

	private String descripcion;
	
	private String fechaDescrip;
	
	
	public FechasFestivasDTO() {
		// TODO Auto-generated constructor stub
	}

	public FechasFestivasDTO(Long idFecha, Date fecha, String descripcion) {
		super();
		this.idFecha = idFecha;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}
	
	public String getFechaDescrip() {
		return fechaDescrip;
	}
	
	public void setFechaDescrip(String fechaDescrip) {
		this.fechaDescrip = fechaDescrip;
	}

	public Long getIdFecha() {
		return idFecha;
	}

	public void setIdFecha(Long idFecha) {
		this.idFecha = idFecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "FechasFestivasDTO [idFecha=" + idFecha + ", fecha=" + fecha + ", descripcion=" + descripcion
				+ ", fechaDescrip=" + fechaDescrip + "]";
	}
}
