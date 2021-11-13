package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.EjecutivosPriorityVentaGerenciaResponseDTO;



public class EjecutivosPriorityVentaGerenciaResponse {
	
	private List<EjecutivosPriorityVentaGerenciaResponseDTO> ejecutivosPriorityVentaGerenciaResponseDTO;
	private String code;
	/**
	 * @param ejecutivosPriorityVentaGerenciaResponseDTO
	 * @param code
	 */
	public EjecutivosPriorityVentaGerenciaResponse(
			List<EjecutivosPriorityVentaGerenciaResponseDTO> ejecutivosPriorityVentaGerenciaResponseDTO, String code) {
		super();
		this.ejecutivosPriorityVentaGerenciaResponseDTO = ejecutivosPriorityVentaGerenciaResponseDTO;
		this.code = code;
	}
	public List<EjecutivosPriorityVentaGerenciaResponseDTO> getEjecutivosPriorityVentaGerenciaResponseDTO() {
		return ejecutivosPriorityVentaGerenciaResponseDTO;
	}
	public void setEjecutivosPriorityVentaGerenciaResponseDTO(
			List<EjecutivosPriorityVentaGerenciaResponseDTO> ejecutivosPriorityVentaGerenciaResponseDTO) {
		this.ejecutivosPriorityVentaGerenciaResponseDTO = ejecutivosPriorityVentaGerenciaResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
