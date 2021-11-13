package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.DibujarChartResponseDTO;

public class DibujarChartResponse {
	
	private List<DibujarChartResponseDTO> dibujarChartResponseDTO;
	private String code;
	
	public DibujarChartResponse(List<DibujarChartResponseDTO> dibujarChartResponseDTO, String code) {
		super();
		this.dibujarChartResponseDTO = dibujarChartResponseDTO;
		this.code = code;
	}

	public List<DibujarChartResponseDTO> getDibujarChartResponseDTO() {
		return dibujarChartResponseDTO;
	}

	public void setDibujarChartResponseDTO(List<DibujarChartResponseDTO> dibujarChartResponseDTO) {
		this.dibujarChartResponseDTO = dibujarChartResponseDTO;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
