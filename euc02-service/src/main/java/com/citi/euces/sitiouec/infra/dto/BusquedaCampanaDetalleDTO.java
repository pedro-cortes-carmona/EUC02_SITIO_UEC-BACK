package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.List;

public class BusquedaCampanaDetalleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TasasCampanaDTO> consultaCampanaFisicas;
	private List<TasasCampanaDTO> consultaCampanaMorales;
	private String reporte;
	
	public BusquedaCampanaDetalleDTO() {}

	public BusquedaCampanaDetalleDTO(List<TasasCampanaDTO> consultaCampanaFisicas,
			List<TasasCampanaDTO> consultaCampanaMorales, String reporte) {
		super();
		this.consultaCampanaFisicas = consultaCampanaFisicas;
		this.consultaCampanaMorales = consultaCampanaMorales;
		this.reporte = reporte;
	}

	public String getReporte() {
		return reporte;
	}

	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	public List<TasasCampanaDTO> getConsultaCampanaFisicas() {
		return consultaCampanaFisicas;
	}

	public void setConsultaCampanaFisicas(List<TasasCampanaDTO> consultaCampanaFisicas) {
		this.consultaCampanaFisicas = consultaCampanaFisicas;
	}

	public List<TasasCampanaDTO> getConsultaCampanaMorales() {
		return consultaCampanaMorales;
	}

	public void setConsultaCampanaMorales(List<TasasCampanaDTO> consultaCampanaMorales) {
		this.consultaCampanaMorales = consultaCampanaMorales;
	}
	
	
}