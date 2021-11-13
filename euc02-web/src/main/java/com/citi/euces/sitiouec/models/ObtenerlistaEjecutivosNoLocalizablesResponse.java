package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.ObtenerlistaEjecutivosNoLocalizablesResponseDTO;

public class ObtenerlistaEjecutivosNoLocalizablesResponse {
	
	private List<ObtenerlistaEjecutivosNoLocalizablesResponseDTO> obtenerlistaEjecutivosNoLocalizablesResponseDTO;
	private String code;
	/**
	 * @param obtenerlistaEjecutivosNoLocalizablesResponseDTO
	 * @param code
	 */
	public ObtenerlistaEjecutivosNoLocalizablesResponse(
			List<ObtenerlistaEjecutivosNoLocalizablesResponseDTO> obtenerlistaEjecutivosNoLocalizablesResponseDTO,
			String code) {
		super();
		this.obtenerlistaEjecutivosNoLocalizablesResponseDTO = obtenerlistaEjecutivosNoLocalizablesResponseDTO;
		this.code = code;
	}
	public List<ObtenerlistaEjecutivosNoLocalizablesResponseDTO> getObtenerlistaEjecutivosNoLocalizablesResponseDTO() {
		return obtenerlistaEjecutivosNoLocalizablesResponseDTO;
	}
	public void setObtenerlistaEjecutivosNoLocalizablesResponseDTO(
			List<ObtenerlistaEjecutivosNoLocalizablesResponseDTO> obtenerlistaEjecutivosNoLocalizablesResponseDTO) {
		this.obtenerlistaEjecutivosNoLocalizablesResponseDTO = obtenerlistaEjecutivosNoLocalizablesResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
