package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.List;

public class ReporteResumenDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ResumenDTO> listaRegistrosUEC;
	private List<ResumenDTO> listaRegistrosGerInv;
	private List<ResumenAutDivDTO> listaRegistrosAutDiv;
	private String reporte; 
	
	public ReporteResumenDTO() {}
	
	public ReporteResumenDTO(List<ResumenDTO> listaRegistrosUEC, List<ResumenDTO> listaRegistrosGerInv,
			List<ResumenAutDivDTO> listaRegistrosAutDiv, String reporte) {
		super();
		this.listaRegistrosUEC = listaRegistrosUEC;
		this.listaRegistrosGerInv = listaRegistrosGerInv;
		this.listaRegistrosAutDiv = listaRegistrosAutDiv;
		this.reporte = reporte;
	}

	public List<ResumenDTO> getListaRegistrosUEC() {
		return listaRegistrosUEC;
	}

	public void setListaRegistrosUEC(List<ResumenDTO> listaRegistrosUEC) {
		this.listaRegistrosUEC = listaRegistrosUEC;
	}

	public List<ResumenDTO> getListaRegistrosGerInv() {
		return listaRegistrosGerInv;
	}

	public void setListaRegistrosGerInv(List<ResumenDTO> listaRegistrosGerInv) {
		this.listaRegistrosGerInv = listaRegistrosGerInv;
	}

	public List<ResumenAutDivDTO> getListaRegistrosAutDiv() {
		return listaRegistrosAutDiv;
	}

	public void setListaRegistrosAutDiv(List<ResumenAutDivDTO> listaRegistrosAutDiv) {
		this.listaRegistrosAutDiv = listaRegistrosAutDiv;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}
	
	
}
