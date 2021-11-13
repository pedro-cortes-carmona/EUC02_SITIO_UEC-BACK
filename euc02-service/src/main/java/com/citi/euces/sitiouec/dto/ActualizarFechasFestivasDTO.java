package com.citi.euces.sitiouec.dto;

public class ActualizarFechasFestivasDTO {

	private Long idFecha;

	private String descripcion;

	private String fecha;
	

	public ActualizarFechasFestivasDTO() {
		// TODO Auto-generated constructor stub
	}

	public ActualizarFechasFestivasDTO(Long idFecha, String descripcion, String fecha) {
		super();
		this.idFecha = idFecha;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	public Long getIdFecha() {
		return idFecha;
	}

	public void setIdFecha(Long idFecha) {
		this.idFecha = idFecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "ActualizarFechasFestivasDTO [idFecha=" + idFecha + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ "]";
	}

}
