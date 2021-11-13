package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.CampGerenciaResponseDTO;

public class ObtenerListaCampanasResponse {
	
	private List<CampGerenciaResponseDTO>  campGerenciaResponseDTO;
	private String code;
	/**
	 * @param campGerenciaResponseDTO
	 * @param code
	 */
	public ObtenerListaCampanasResponse(List<CampGerenciaResponseDTO> campGerenciaResponseDTO, String code) {
		super();
		this.campGerenciaResponseDTO = campGerenciaResponseDTO;
		this.code = code;
	}
	public List<CampGerenciaResponseDTO> getCampGerenciaResponseDTO() {
		return campGerenciaResponseDTO;
	}
	public void setCampGerenciaResponseDTO(List<CampGerenciaResponseDTO> campGerenciaResponseDTO) {
		this.campGerenciaResponseDTO = campGerenciaResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
