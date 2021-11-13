package com.citi.euces.sitiouec.dto;

import java.util.ArrayList;
import java.util.List;

public class ReporteCetesDTO {

	List<CetePaginaDTO> listaCetesVariacion;

	List<CetePaginaDTO> listaCetes;

	public ReporteCetesDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<CetePaginaDTO> getListaCetesVariacion() {
		if (listaCetesVariacion == null) {
			listaCetesVariacion = new ArrayList<>();
		}
		return listaCetesVariacion;
	}

	public void setListaCetesVariacion(List<CetePaginaDTO> listaCetesVariacion) {
		this.listaCetesVariacion = listaCetesVariacion;
	}

	public List<CetePaginaDTO> getListaCetes() {
		if (listaCetes == null) {
			listaCetes = new ArrayList<>();
		}
		return listaCetes;
	}

	public void setListaCetes(List<CetePaginaDTO> listaCetes) {
		this.listaCetes = listaCetes;
	}

	@Override
	public String toString() {
		return "ReporteCetesDTO [listaCetesVariacion=" + listaCetesVariacion + ", listaCetes=" + listaCetes + "]";
	}

}
