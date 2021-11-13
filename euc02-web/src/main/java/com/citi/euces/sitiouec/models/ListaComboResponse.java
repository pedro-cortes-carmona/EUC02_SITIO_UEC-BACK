package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import com.citi.euces.sitiouec.infra.dto.ComboDTO;

public class ListaComboResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboDTO lista;
	private String code;
	
	public ListaComboResponse() {}
	
	public ListaComboResponse(ComboDTO lista, String code) {
		super();
		this.lista = lista;
		this.code = code;
	}

	public ComboDTO getLista() {
		return lista;
	}

	public void setLista(ComboDTO lista) {
		this.lista = lista;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
