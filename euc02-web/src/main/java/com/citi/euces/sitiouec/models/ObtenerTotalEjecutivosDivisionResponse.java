package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.ObtenerTotalEjecutivosDivisionResponseDTO;


public class ObtenerTotalEjecutivosDivisionResponse {
	
	private List<ObtenerTotalEjecutivosDivisionResponseDTO> obtenerTotalEjecutivosDivisionResponseDTO;
	private String code;
	/**
	 * @param obtenerTotalEjecutivosDivisionResponseDTO
	 * @param code
	 */
	public ObtenerTotalEjecutivosDivisionResponse(
			List<ObtenerTotalEjecutivosDivisionResponseDTO> obtenerTotalEjecutivosDivisionResponseDTO, String code) {
		super();
		this.obtenerTotalEjecutivosDivisionResponseDTO = obtenerTotalEjecutivosDivisionResponseDTO;
		this.code = code;
	}
	public List<ObtenerTotalEjecutivosDivisionResponseDTO> getObtenerTotalEjecutivosDivisionResponseDTO() {
		return obtenerTotalEjecutivosDivisionResponseDTO;
	}
	public void setObtenerTotalEjecutivosDivisionResponseDTO(
			List<ObtenerTotalEjecutivosDivisionResponseDTO> obtenerTotalEjecutivosDivisionResponseDTO) {
		this.obtenerTotalEjecutivosDivisionResponseDTO = obtenerTotalEjecutivosDivisionResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
