package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class EstatusDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SolicitudEstatusDTO solicitud;
	private String mensaje;
	private String sucursalOpe;
	private String nombreAutorizador;
	private String NombreEjec;
	private Boolean flag;
	private String estatusFolio;
	private String mensajeFolio;
	
	public EstatusDTO() {}
	
	public EstatusDTO(SolicitudEstatusDTO solicitud, String mensaje, Boolean flag) {
		super();
		this.solicitud = solicitud;
		this.mensaje = mensaje;
		this.flag = flag;
	}

	public String getSucursalOpe() {
		return sucursalOpe;
	}

	public void setSucursalOpe(String sucursalOpe) {
		this.sucursalOpe = sucursalOpe;
	}

	public String getNombreEjec() {
		return NombreEjec;
	}

	public void setNombreEjec(String nombreEjec) {
		NombreEjec = nombreEjec;
	}

	public SolicitudEstatusDTO getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudEstatusDTO solicitud) {
		this.solicitud = solicitud;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getNombreAutorizador() {
		return nombreAutorizador;
	}

	public void setNombreAutorizador(String nombreAutorizador) {
		this.nombreAutorizador = nombreAutorizador;
	}

	public String getEstatusFolio() {
		return estatusFolio;
	}

	public void setEstatusFolio(String estatusFolio) {
		this.estatusFolio = estatusFolio;
	}

	public String getMensajeFolio() {
		return mensajeFolio;
	}

	public void setMensajeFolio(String mensajeFolio) {
		this.mensajeFolio = mensajeFolio;
	}
	
	
	
}
