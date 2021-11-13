package com.citi.euces.sitiouec.dto;

import java.util.List;

import com.citi.euces.sitiouec.infra.dto.Data_ChartBEResponSeDTO;
import com.citi.euces.sitiouec.infra.dto.DatosAgrupadosResponseDTO;

public class DibujarChartAgrupadoResponseDTO {
	
	private String divname;
	private String tipo; 
	private boolean mostrar_leyenda;
	private String position; 
	private String titulo;
	private double transparency;
	private boolean descargable;
	private List<DatosAgrupadosResponseDTO> datos_agrupados;
	private List<String> ListaCategorias;
	private List<DatosAgrupadosResponseDTO> datos_agrupados_mixtos;
	private List<Data_ChartBEResponSeDTO> listaDatos;
	public DibujarChartAgrupadoResponseDTO(String divname, String tipo, boolean mostrar_leyenda, String position,
			String titulo, double transparency, boolean descargable, List<DatosAgrupadosResponseDTO> datos_agrupados,
			List<String> listaCategorias, List<DatosAgrupadosResponseDTO> datos_agrupados_mixtos, List<Data_ChartBEResponSeDTO> listaDatos) {
		super();
		this.divname = divname;
		this.tipo = tipo;
		this.mostrar_leyenda = mostrar_leyenda;
		this.position = position;
		this.titulo = titulo;
		this.transparency = transparency;
		this.descargable = descargable;
		this.datos_agrupados = datos_agrupados;
		ListaCategorias = listaCategorias;
		this.datos_agrupados_mixtos = datos_agrupados_mixtos;
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
	public List<DatosAgrupadosResponseDTO> getDatos_agrupados() {
		return datos_agrupados;
	}
	public void setDatos_agrupados(List<DatosAgrupadosResponseDTO> datos_agrupados) {
		this.datos_agrupados = datos_agrupados;
	}
	public List<String> getListaCategorias() {
		return ListaCategorias;
	}
	public void setListaCategorias(List<String> listaCategorias) {
		ListaCategorias = listaCategorias;
	}
	public List<DatosAgrupadosResponseDTO> getDatos_agrupados_mixtos() {
		return datos_agrupados_mixtos;
	}
	public void setDatos_agrupados_mixtos(List<DatosAgrupadosResponseDTO> datos_agrupados_mixtos) {
		this.datos_agrupados_mixtos = datos_agrupados_mixtos;
	}
	public List<Data_ChartBEResponSeDTO> getListaDatos() {
		return listaDatos;
	}
	public void setListaDatos(List<Data_ChartBEResponSeDTO> listaDatos) {
		this.listaDatos = listaDatos;
	}
	
	
	
}
