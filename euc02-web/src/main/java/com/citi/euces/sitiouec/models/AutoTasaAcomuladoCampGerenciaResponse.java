package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.AutoTasaAcomuladoCampGerenciaResponseDTO;


public class AutoTasaAcomuladoCampGerenciaResponse {
	
	private List<AutoTasaAcomuladoCampGerenciaResponseDTO> ObtenerListaCampanas;
	private String code;
	/**
	 * @param obtenerListaCampanas
	 * @param code
	 */
	public AutoTasaAcomuladoCampGerenciaResponse(List<AutoTasaAcomuladoCampGerenciaResponseDTO> obtenerListaCampanas,
			String code) {
		super();
		ObtenerListaCampanas = obtenerListaCampanas;
		this.code = code;
	}
	public List<AutoTasaAcomuladoCampGerenciaResponseDTO> getObtenerListaCampanas() {
		return ObtenerListaCampanas;
	}
	public void setObtenerListaCampanas(List<AutoTasaAcomuladoCampGerenciaResponseDTO> obtenerListaCampanas) {
		ObtenerListaCampanas = obtenerListaCampanas;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
