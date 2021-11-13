package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.EjecutivosPriorityGerenciaResponseDTO;



public class EjecutivosPriorityGerenciaResponse {
	
	private List<EjecutivosPriorityGerenciaResponseDTO> ejecutivosPriorityGerenciaResponseDTO;
	private String code;
	/**
	 * @param ejecutivosPriorityGerenciaResponseDTO
	 * @param code
	 */
	public EjecutivosPriorityGerenciaResponse(
			List<EjecutivosPriorityGerenciaResponseDTO> ejecutivosPriorityGerenciaResponseDTO, String code) {
		super();
		this.ejecutivosPriorityGerenciaResponseDTO = ejecutivosPriorityGerenciaResponseDTO;
		this.code = code;
	}
	public List<EjecutivosPriorityGerenciaResponseDTO> getEjecutivosPriorityGerenciaResponseDTO() {
		return ejecutivosPriorityGerenciaResponseDTO;
	}
	public void setEjecutivosPriorityGerenciaResponseDTO(
			List<EjecutivosPriorityGerenciaResponseDTO> ejecutivosPriorityGerenciaResponseDTO) {
		this.ejecutivosPriorityGerenciaResponseDTO = ejecutivosPriorityGerenciaResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
