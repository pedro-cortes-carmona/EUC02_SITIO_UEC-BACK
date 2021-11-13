package com.citi.euces.sitiouec.dto;

public class GetNumRegTbAcumuladoTasasGerenciaResponseBEDTO {
	int acum_o_tasas;
	private String campana;
	private String fercha;

	public String getCampana() {
		return campana;
	}

	public void setCampana(String campana) {
		this.campana = campana;
	}

	public int getAcum_o_tasas() {
		return acum_o_tasas;
	}

	public void setAcum_o_tasas(int acum_o_tasas) {
		this.acum_o_tasas = acum_o_tasas;
	}

	public String getFercha() {
		return fercha;
	}

	public void setFercha(String fercha) {
		this.fercha = fercha;
	}
	
	
	

}
