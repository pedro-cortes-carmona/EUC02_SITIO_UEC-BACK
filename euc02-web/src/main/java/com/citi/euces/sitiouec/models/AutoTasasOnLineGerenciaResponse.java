package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.AutoTasasOnLineGerenciaResponseDTO;



public class AutoTasasOnLineGerenciaResponse {
	
	private List<AutoTasasOnLineGerenciaResponseDTO> autoTasasOnLineGerenciaResponseDTO;
	private String code;
	/**
	 * @param autoTasasOnLineGerenciaResponseDTO
	 * @param code
	 */
	public AutoTasasOnLineGerenciaResponse(List<AutoTasasOnLineGerenciaResponseDTO> autoTasasOnLineGerenciaResponseDTO,
			String code) {
		super();
		this.autoTasasOnLineGerenciaResponseDTO = autoTasasOnLineGerenciaResponseDTO;
		this.code = code;
	}
	public List<AutoTasasOnLineGerenciaResponseDTO> getAutoTasasOnLineGerenciaResponseDTO() {
		return autoTasasOnLineGerenciaResponseDTO;
	}
	public void setAutoTasasOnLineGerenciaResponseDTO(
			List<AutoTasasOnLineGerenciaResponseDTO> autoTasasOnLineGerenciaResponseDTO) {
		this.autoTasasOnLineGerenciaResponseDTO = autoTasasOnLineGerenciaResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
