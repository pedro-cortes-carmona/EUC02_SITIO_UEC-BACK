package com.citi.euces.sitiouec.models;

import java.io.Serializable;
import java.util.List;

import com.citi.euces.sitiouec.dto.ConsultarAutorizadorDTO;

public class ResponseAutorizador implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ConsultarAutorizadorDTO> listaAutorizadores;
	private String code;
	
	public ResponseAutorizador() {}
	
	public ResponseAutorizador(List<ConsultarAutorizadorDTO> listaAutorizadores, String code) {
		super();
		this.listaAutorizadores = listaAutorizadores;
		this.code = code;
	}

	public List<ConsultarAutorizadorDTO> getListaAutorizadores() {
		return listaAutorizadores;
	}

	public void setListaAutorizadores(List<ConsultarAutorizadorDTO> listaAutorizadores) {
		this.listaAutorizadores = listaAutorizadores;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
