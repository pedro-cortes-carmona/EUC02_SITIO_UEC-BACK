package com.citi.euces.sitiouec.dto;

import java.util.List;

public class EliminarRegistrosObservacionesDTO {
	
	
	private List<Long> lsRegistros;
	
	
	
	public List<Long> getLsRegistros() {
		return lsRegistros;
	}
	
	public void setLsRegistros(List<Long> lsRegistros) {
		this.lsRegistros = lsRegistros;
	}

	@Override
	public String toString() {
		return "EliminarRegistrosObservacionesDTO [lsRegistros=" + lsRegistros + "]";
	}
	
	
	

}
