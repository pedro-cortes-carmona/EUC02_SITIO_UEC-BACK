package com.citi.euces.sitiouec.infra.dto;

import java.util.List;

public class DatosAgrupadosResponseDTO {
	
	private String campana;
	private List<Data_ChartBEResponSeDTO> listaDatos;
	public DatosAgrupadosResponseDTO(String campana, List<Data_ChartBEResponSeDTO> listaDatos) {
		super();
		this.campana = campana;
		this.listaDatos = listaDatos;
	}
	public String getCampana() {
		return campana;
	}
	public void setCampana(String campana) {
		this.campana = campana;
	}
	public List<Data_ChartBEResponSeDTO> getListaDatos() {
		return listaDatos;
	}
	public void setListaDatos(List<Data_ChartBEResponSeDTO> listaDatos) {
		this.listaDatos = listaDatos;
	}
	
	

}
