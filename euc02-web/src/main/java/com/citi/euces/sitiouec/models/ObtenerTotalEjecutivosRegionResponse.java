package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.ObtenerTotalEjecutivosRegionResponseDTO;



public class ObtenerTotalEjecutivosRegionResponse {
	
	private List<ObtenerTotalEjecutivosRegionResponseDTO> obtenerTotalEjecutivosRegionResponseDTO;
	private String code;
	/**
	 * @param obtenerTotalEjecutivosRegionResponseDTO
	 * @param code
	 */
	public ObtenerTotalEjecutivosRegionResponse(
			List<ObtenerTotalEjecutivosRegionResponseDTO> obtenerTotalEjecutivosRegionResponseDTO, String code) {
		super();
		this.obtenerTotalEjecutivosRegionResponseDTO = obtenerTotalEjecutivosRegionResponseDTO;
		this.code = code;
	}
	public List<ObtenerTotalEjecutivosRegionResponseDTO> getObtenerTotalEjecutivosRegionResponseDTO() {
		return obtenerTotalEjecutivosRegionResponseDTO;
	}
	public void setObtenerTotalEjecutivosRegionResponseDTO(
			List<ObtenerTotalEjecutivosRegionResponseDTO> obtenerTotalEjecutivosRegionResponseDTO) {
		this.obtenerTotalEjecutivosRegionResponseDTO = obtenerTotalEjecutivosRegionResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
