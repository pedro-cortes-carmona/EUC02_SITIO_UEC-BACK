package com.citi.euces.sitiouec.models;

import java.io.Serializable;
import java.util.List;

import com.citi.euces.sitiouec.dto.BuscarWebDTO;

public class ResponseBuscarAutorizador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<BuscarWebDTO> listaAutorizadores;
	private String code;
	
	public ResponseBuscarAutorizador() {}
	
	public ResponseBuscarAutorizador(List<BuscarWebDTO> listaAutorizadores, String code) {
		super();
		this.listaAutorizadores = listaAutorizadores;
		this.code = code;
	}

	public List<BuscarWebDTO> getListaAutorizadores() {
		return listaAutorizadores;
	}

	public void setListaAutorizadores(List<BuscarWebDTO> listaAutorizadores) {
		this.listaAutorizadores = listaAutorizadores;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
