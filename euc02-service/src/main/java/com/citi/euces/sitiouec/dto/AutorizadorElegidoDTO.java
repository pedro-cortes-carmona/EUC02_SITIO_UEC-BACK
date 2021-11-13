package com.citi.euces.sitiouec.dto;

import java.util.List;

public class AutorizadorElegidoDTO {

	private Long idTasaAuto;

	private List<AutoAutorizadorDTO> lsAutorizadores;

	private String autorizadores;

	public AutorizadorElegidoDTO() {
		
	}

	public AutorizadorElegidoDTO(Long idTasaAuto) {
		super();
		this.idTasaAuto = idTasaAuto;
	}

	public AutorizadorElegidoDTO(Long idTasaAuto, List<AutoAutorizadorDTO> lsAutorizadores) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.lsAutorizadores = lsAutorizadores;
	}

	public String getAutorizadores() {
		return autorizadores;
	}

	public AutorizadorElegidoDTO(Long idTasaAuto, String autorizadores) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.autorizadores = autorizadores;
	}

	public void setAutorizadores(String autorizadores) {
		this.autorizadores = autorizadores;
	}

	public Long getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	public List<AutoAutorizadorDTO> getLsAutorizadores() {
		return lsAutorizadores;
	}

	public void setLsAutorizadores(List<AutoAutorizadorDTO> lsAutorizadores) {
		this.lsAutorizadores = lsAutorizadores;
	}

	@Override
	public String toString() {
		return "AutorizadorElegidoDTO [idTasaAuto=" + idTasaAuto + ", lsAutorizadores=" + lsAutorizadores
				+ ", autorizadores=" + autorizadores + "]";
	}

}
