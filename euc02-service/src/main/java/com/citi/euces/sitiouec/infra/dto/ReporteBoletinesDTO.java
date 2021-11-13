package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.List;

public class ReporteBoletinesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<BoletinesDTO> listaSegmento;
	private List<BoletinesDTO> listaTipoTasaGrafica;
	private List<BoletinesDTO> listaTipoTasa;
	private List<BoletinesDTO> listaDivision;
	private List<BoletinesDTO> listaDivisionAnual;
	private List<BoletinesDTO> listaEstatus;
	private String msg;
	private String reporte;
	
	public ReporteBoletinesDTO() {}
	
	public ReporteBoletinesDTO(List<BoletinesDTO> listaSegmento, List<BoletinesDTO> listaTipoTasaGrafica,
			List<BoletinesDTO> listaTipoTasa, List<BoletinesDTO> listaDivision, List<BoletinesDTO> listaDivisionAnual,
			List<BoletinesDTO> listaEstatus, String msg, String reporte) {
		super();
		this.listaSegmento = listaSegmento;
		this.listaTipoTasaGrafica = listaTipoTasaGrafica;
		this.listaTipoTasa = listaTipoTasa;
		this.listaDivision = listaDivision;
		this.listaDivisionAnual = listaDivisionAnual;
		this.listaEstatus = listaEstatus;
		this.msg = msg;
		this.reporte = reporte;
	}

	public List<BoletinesDTO> getListaSegmento() {
		return listaSegmento;
	}

	public void setListaSegmento(List<BoletinesDTO> listaSegmento) {
		this.listaSegmento = listaSegmento;
	}

	public List<BoletinesDTO> getListaTipoTasaGrafica() {
		return listaTipoTasaGrafica;
	}

	public void setListaTipoTasaGrafica(List<BoletinesDTO> listaTipoTasaGrafica) {
		this.listaTipoTasaGrafica = listaTipoTasaGrafica;
	}

	public List<BoletinesDTO> getListaTipoTasa() {
		return listaTipoTasa;
	}

	public void setListaTipoTasa(List<BoletinesDTO> listaTipoTasa) {
		this.listaTipoTasa = listaTipoTasa;
	}

	public List<BoletinesDTO> getListaDivision() {
		return listaDivision;
	}

	public void setListaDivision(List<BoletinesDTO> listaDivision) {
		this.listaDivision = listaDivision;
	}

	public List<BoletinesDTO> getListaDivisionAnual() {
		return listaDivisionAnual;
	}

	public void setListaDivisionAnual(List<BoletinesDTO> listaDivisionAnual) {
		this.listaDivisionAnual = listaDivisionAnual;
	}

	public List<BoletinesDTO> getListaEstatus() {
		return listaEstatus;
	}

	public void setListaEstatus(List<BoletinesDTO> listaEstatus) {
		this.listaEstatus = listaEstatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	
}
