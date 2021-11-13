package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.EjecutivosPrioritySinVentaGerenciaResponseDTO;



public class EjecutivosPrioritySinVentaGerenciaResponse {
	
	private List<EjecutivosPrioritySinVentaGerenciaResponseDTO> ejecutivosPrioritySinVentaGerenciaResponseDTO;
	private String code;
	/**
	 * @param ejecutivosPrioritySinVentaGerenciaResponseDTO
	 * @param code
	 */
	public EjecutivosPrioritySinVentaGerenciaResponse(
			List<EjecutivosPrioritySinVentaGerenciaResponseDTO> ejecutivosPrioritySinVentaGerenciaResponseDTO,
			String code) {
		super();
		this.ejecutivosPrioritySinVentaGerenciaResponseDTO = ejecutivosPrioritySinVentaGerenciaResponseDTO;
		this.code = code;
	}
	public List<EjecutivosPrioritySinVentaGerenciaResponseDTO> getEjecutivosPrioritySinVentaGerenciaResponseDTO() {
		return ejecutivosPrioritySinVentaGerenciaResponseDTO;
	}
	public void setEjecutivosPrioritySinVentaGerenciaResponseDTO(
			List<EjecutivosPrioritySinVentaGerenciaResponseDTO> ejecutivosPrioritySinVentaGerenciaResponseDTO) {
		this.ejecutivosPrioritySinVentaGerenciaResponseDTO = ejecutivosPrioritySinVentaGerenciaResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
