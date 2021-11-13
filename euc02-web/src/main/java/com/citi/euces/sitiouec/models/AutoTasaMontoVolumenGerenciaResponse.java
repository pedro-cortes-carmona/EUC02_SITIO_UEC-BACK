package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.AutoTasaMontoVolumenGerenciaRepoResponseDTO;
import com.citi.euces.sitiouec.dto.DibujarChartAgrupadoResponseDTO;

public class AutoTasaMontoVolumenGerenciaResponse {
	
	private List<DibujarChartAgrupadoResponseDTO> DibujarChartAgrupadoResponseDTO;
	private String code;
	public AutoTasaMontoVolumenGerenciaResponse(
			List<com.citi.euces.sitiouec.dto.DibujarChartAgrupadoResponseDTO> dibujarChartAgrupadoResponseDTO,
			String code) {
		super();
		DibujarChartAgrupadoResponseDTO = dibujarChartAgrupadoResponseDTO;
		this.code = code;
	}
	public List<DibujarChartAgrupadoResponseDTO> getDibujarChartAgrupadoResponseDTO() {
		return DibujarChartAgrupadoResponseDTO;
	}
	public void setDibujarChartAgrupadoResponseDTO(List<DibujarChartAgrupadoResponseDTO> dibujarChartAgrupadoResponseDTO) {
		DibujarChartAgrupadoResponseDTO = dibujarChartAgrupadoResponseDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
