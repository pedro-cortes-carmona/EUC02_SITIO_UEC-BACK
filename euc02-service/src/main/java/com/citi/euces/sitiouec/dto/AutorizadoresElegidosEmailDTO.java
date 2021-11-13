package com.citi.euces.sitiouec.dto;

public class AutorizadoresElegidosEmailDTO {

	private Long idTasaAuto;

	private String autorizadores;

	public AutorizadoresElegidosEmailDTO() {
	   
	}

	public AutorizadoresElegidosEmailDTO(Long idTasaAuto, String autorizadores) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.autorizadores = autorizadores;
	}

	public Long getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	public String getAutorizadores() {
		return autorizadores;
	}

	public void setAutorizadores(String autorizadores) {
		this.autorizadores = autorizadores;
	}

	@Override
	public String toString() {
		return "AutorizadoresElegidosEmailDTO [idTasaAuto=" + idTasaAuto + ", autorizadores=" + autorizadores + "]";
	}

}
