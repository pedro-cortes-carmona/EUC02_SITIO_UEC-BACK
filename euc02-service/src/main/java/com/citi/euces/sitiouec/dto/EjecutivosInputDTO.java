package com.citi.euces.sitiouec.dto;

import java.util.List;

public class EjecutivosInputDTO {

	private List<AsignacionesInputDTO> lsEjecutivos;

	public EjecutivosInputDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<AsignacionesInputDTO> getLsEjecutivos() {
		return lsEjecutivos;
	}

	public void setLsEjecutivos(List<AsignacionesInputDTO> lsEjecutivos) {
		this.lsEjecutivos = lsEjecutivos;
	}

	@Override
	public String toString() {
		return "EjecutivosInputDTO [lsEjecutivos=" + lsEjecutivos + "]";
	}

}
