package com.citi.euces.sitiouec.models;

import java.io.Serializable;
import java.util.List;

import com.citi.euces.sitiouec.infra.dto.BusquedaSolicitudesAplicadasDTO;
import com.citi.euces.sitiouec.infra.dto.SolicitudesAplicadasSinDatosDTO;

public class SolicitudesAplicadasResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BusquedaSolicitudesAplicadasDTO listaSolicitudes;
	private String code;

	public SolicitudesAplicadasResponse(BusquedaSolicitudesAplicadasDTO listaSolicitudes, String code) {
		super();
		this.listaSolicitudes = listaSolicitudes;
		this.code = code;
	}

	public BusquedaSolicitudesAplicadasDTO getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(BusquedaSolicitudesAplicadasDTO listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
