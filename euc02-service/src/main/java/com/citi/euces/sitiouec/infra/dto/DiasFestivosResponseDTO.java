package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;


public class DiasFestivosResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
	private Long PlazoReal; 
	private String Vigencia;
	
	public DiasFestivosResponseDTO(Long plazoReal, String vigencia) {
		super();
		PlazoReal = plazoReal;
		Vigencia = vigencia;
	}
	public Long getPlazoReal() {
		return PlazoReal;
	}
	public void setPlazoReal(Long plazoReal) {
		PlazoReal = plazoReal;
	}
	public String getVigencia() {
		return Vigencia;
	}
	public void setVigencia(String vigencia) {
		Vigencia = vigencia;
	}
	
}
