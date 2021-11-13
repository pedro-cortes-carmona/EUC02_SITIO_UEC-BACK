package com.citi.euces.sitiouec.infra.dto;

import java.util.List;

public class BusquedaSolicitudesAplicadasDTO {

	private List<SolicitudesAplicadasSinDatosDTO> listaSolicitudes;

	public BusquedaSolicitudesAplicadasDTO() {}
	
	public BusquedaSolicitudesAplicadasDTO(List<SolicitudesAplicadasSinDatosDTO> listaSolicitudes) {
		super();
		this.listaSolicitudes = listaSolicitudes;
	}

	public List<SolicitudesAplicadasSinDatosDTO> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(List<SolicitudesAplicadasSinDatosDTO> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}
	
	
}
