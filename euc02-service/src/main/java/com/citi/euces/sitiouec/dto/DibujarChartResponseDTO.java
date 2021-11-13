package com.citi.euces.sitiouec.dto;

import java.util.List;

import com.citi.euces.sitiouec.infra.dto.Data_ChartBEResponSeDTO;

public class DibujarChartResponseDTO {
	
	private String divname;
	private String tipo; 
	private String tituloleyenda;
	private boolean mostrar_leyenda;
	private String position; 
	private String titulo;
	private double transparency;
	private boolean descargable;
	private List<Data_ChartBEResponSeDTO> listaDatos;
	public DibujarChartResponseDTO(String divname, String tipo, String tituloleyenda, boolean mostrar_leyenda,
			String position, String titulo, double transparency, boolean descargable, List<Data_ChartBEResponSeDTO> listaDatos) {
		super();
		this.divname = divname;
		this.tipo = tipo;
		this.tituloleyenda = tituloleyenda;
		this.mostrar_leyenda = mostrar_leyenda;
		this.position = position;
		this.titulo = titulo;
		this.transparency = transparency;
		this.descargable = descargable;
		this.listaDatos = listaDatos;
	}
	public String getDivname() {
		return divname;
	}
	public void setDivname(String divname) {
		this.divname = divname;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTituloleyenda() {
		return tituloleyenda;
	}
	public void setTituloleyenda(String tituloleyenda) {
		this.tituloleyenda = tituloleyenda;
	}
	public boolean isMostrar_leyenda() {
		return mostrar_leyenda;
	}
	public void setMostrar_leyenda(boolean mostrar_leyenda) {
		this.mostrar_leyenda = mostrar_leyenda;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getTransparency() {
		return transparency;
	}
	public void setTransparency(double transparency) {
		this.transparency = transparency;
	}
	public boolean isDescargable() {
		return descargable;
	}
	public void setDescargable(boolean descargable) {
		this.descargable = descargable;
	}
	public List<Data_ChartBEResponSeDTO> getListaDatos() {
		return listaDatos;
	}
	public void setListaDatos(List<Data_ChartBEResponSeDTO> listaDatos) {
		this.listaDatos = listaDatos;
	}
	
	

}
