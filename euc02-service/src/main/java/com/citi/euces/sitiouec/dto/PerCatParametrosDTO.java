package com.citi.euces.sitiouec.dto;

public class PerCatParametrosDTO {
	
	
	private Long idParametro;
	
	private String parametroNom;
	
	private String parametroValor;
	
	
	
	public PerCatParametrosDTO() {
		// TODO Auto-generated constructor stub
	}


	public PerCatParametrosDTO(Long idParametro, String parametroNom, String parametroValor) {
		super();
		this.idParametro = idParametro;
		this.parametroNom = parametroNom;
		this.parametroValor = parametroValor;
	}


	public Long getIdParametro() {
		return idParametro;
	}


	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}


	public String getParametroNom() {
		return parametroNom;
	}


	public void setParametroNom(String parametroNom) {
		this.parametroNom = parametroNom;
	}


	public String getParametroValor() {
		return parametroValor;
	}


	public void setParametroValor(String parametroValor) {
		this.parametroValor = parametroValor;
	}


	@Override
	public String toString() {
		return "PerCatParametrosDTO [idParametro=" + idParametro + ", parametroNom=" + parametroNom
				+ ", parametroValor=" + parametroValor + "]";
	}
	
	

}
