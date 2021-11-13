package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class ListaComboDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer valor;
	private String nombre;
	
	public ListaComboDTO() {}
	
	public ListaComboDTO(Integer valor, String nombre) {
		super();
		this.valor = valor;
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
