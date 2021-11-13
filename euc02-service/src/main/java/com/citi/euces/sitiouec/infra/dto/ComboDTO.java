package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.List;

public class ComboDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ListaComboDTO> valores;
	
	public ComboDTO() {}
	
	public ComboDTO(List<ListaComboDTO> valores) {
		super();
		this.valores = valores;
	}

	public List<ListaComboDTO> getValores() {
		return valores;
	}

	public void setValores(List<ListaComboDTO> valores) {
		this.valores = valores;
	}
	
	
	
}
