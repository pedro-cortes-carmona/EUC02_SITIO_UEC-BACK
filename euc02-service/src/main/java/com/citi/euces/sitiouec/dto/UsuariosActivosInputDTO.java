package com.citi.euces.sitiouec.dto;

public class UsuariosActivosInputDTO {

	private String fechaInicial;

	public UsuariosActivosInputDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	@Override
	public String toString() {
		return "UsuariosActivosInputDTO [fechaInicial=" + fechaInicial + "]";
	}

}
