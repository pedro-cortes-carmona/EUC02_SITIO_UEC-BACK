package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.SucursalGerenciaRegionResponseDTO;

public class SucursalGerenciaRegionResponse {
	
	private List<SucursalGerenciaRegionResponseDTO> sucursalGerenciaRegionResponseDTO;
    private String code;
	/**
	 * @param sucursalGerenciaRegionResponseDTO
	 * @param code
	 */
	public SucursalGerenciaRegionResponse(List<SucursalGerenciaRegionResponseDTO> sucursalGerenciaRegionResponseDTO,
			String code) {
		super();
		this.sucursalGerenciaRegionResponseDTO = sucursalGerenciaRegionResponseDTO;
		this.code = code;
	}
	public List<SucursalGerenciaRegionResponseDTO> getSucursalGerenciaRegionResponseDTO() {
		return sucursalGerenciaRegionResponseDTO;
	}
	public void setSucursalGerenciaRegionResponseDTO(
			List<SucursalGerenciaRegionResponseDTO> sucursalGerenciaRegionResponseDTO) {
		this.sucursalGerenciaRegionResponseDTO = sucursalGerenciaRegionResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    
	
}
