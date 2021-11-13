package com.citi.euces.sitiouec.dto;

import java.util.List;

public class EliminarClienteRepetidosDTO {
	
	
	private List<Long> lsClientesRepetidos;
	
	
	
	public EliminarClienteRepetidosDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Long> getLsClientesRepetidos() {
		return lsClientesRepetidos;
	}
	
	public void setLsClientesRepetidos(List<Long> lsClientesRepetidos) {
		this.lsClientesRepetidos = lsClientesRepetidos;
	}

	@Override
	public String toString() {
		return "EliminarClienteRepetidosDTO [lsClientesRepetidos=" + lsClientesRepetidos + "]";
	}
	
	

}
