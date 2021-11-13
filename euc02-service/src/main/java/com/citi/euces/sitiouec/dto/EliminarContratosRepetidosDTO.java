package com.citi.euces.sitiouec.dto;

import java.util.List;

public class EliminarContratosRepetidosDTO {

	private List<Long> lsContratosRepetidos;
			           

	
	public EliminarContratosRepetidosDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<Long> getLsContratosRepetidos() {
		return lsContratosRepetidos;
	}

	public void setLsContratosRepetidos(List<Long> lsContratosRepetidos) {
		this.lsContratosRepetidos = lsContratosRepetidos;
	}

	@Override
	public String toString() {
		return "EliminarContratosRepetidosDTO [lsContratosRepetidos=" + lsContratosRepetidos + "]";
	}

}
