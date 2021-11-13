package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.CampanaporSucursalesResponseDTO;



public class CampanaporSucursalesResponse {
	
	private List<CampanaporSucursalesResponseDTO> campanaporSucursalesResponseDTO;
	 private String code;
	/**
	 * @param campanaporSucursalesResponseDTO
	 * @param code
	 */
	public CampanaporSucursalesResponse(List<CampanaporSucursalesResponseDTO> campanaporSucursalesResponseDTO,
			String code) {
		super();
		this.campanaporSucursalesResponseDTO = campanaporSucursalesResponseDTO;
		this.code = code;
	}
	public List<CampanaporSucursalesResponseDTO> getCampanaporSucursalesResponseDTO() {
		return campanaporSucursalesResponseDTO;
	}
	public void setCampanaporSucursalesResponseDTO(List<CampanaporSucursalesResponseDTO> campanaporSucursalesResponseDTO) {
		this.campanaporSucursalesResponseDTO = campanaporSucursalesResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	 
	 

}
