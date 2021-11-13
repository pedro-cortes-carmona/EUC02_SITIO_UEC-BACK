package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.infra.dto.DiasFestivosResponseDTO;

public class DiasFestivosResponse {
	
	private List<DiasFestivosResponseDTO> diasFestivos;
	 private String code;
	/**
	 * @param diasFestivos
	 * @param code
	 */
	public DiasFestivosResponse(List<DiasFestivosResponseDTO> diasFestivos, String code) {
		super();
		this.diasFestivos = diasFestivos;
		this.code = code;
	}
	public List<DiasFestivosResponseDTO> getDiasFestivos() {
		return diasFestivos;
	}
	public void setDiasFestivos(List<DiasFestivosResponseDTO> diasFestivos) {
		this.diasFestivos = diasFestivos;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	 
	 

}
