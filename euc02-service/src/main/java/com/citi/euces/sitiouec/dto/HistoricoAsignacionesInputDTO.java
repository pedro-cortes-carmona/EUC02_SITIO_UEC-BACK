package com.citi.euces.sitiouec.dto;

import java.util.List;

public class HistoricoAsignacionesInputDTO {

	List<HistoricoAsignacionesDTO> lsAsignaciones;

	public HistoricoAsignacionesInputDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<HistoricoAsignacionesDTO> getLsAsignaciones() {
		return lsAsignaciones;
	}

	public void setLsAsignaciones(List<HistoricoAsignacionesDTO> lsAsignaciones) {
		this.lsAsignaciones = lsAsignaciones;
	}

	@Override
	public String toString() {
		return "HistoricoAsignacionesInputDTO [lsAsignaciones=" + lsAsignaciones + "]";
	}

}
