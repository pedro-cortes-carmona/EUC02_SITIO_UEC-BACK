package com.citi.euces.sitiouec.dto;

import java.util.List;

public class EjecutivosAsignacionesInputDTO {

	private List<String> lsEjecutivos;

	public EjecutivosAsignacionesInputDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<String> getLsEjecutivos() {
		return lsEjecutivos;
	}

	public void setLsEjecutivos(List<String> lsEjecutivos) {
		this.lsEjecutivos = lsEjecutivos;
	}

	@Override
	public String toString() {
		return "EjecutivosAsignacionesInputDTO [lsEjecutivos=" + lsEjecutivos + "]";
	}

}
