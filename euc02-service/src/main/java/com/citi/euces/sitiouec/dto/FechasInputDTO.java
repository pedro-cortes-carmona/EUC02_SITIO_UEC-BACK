package com.citi.euces.sitiouec.dto;

public class FechasInputDTO {
	
	private String fechaInicial;
	
	private String fechaFinal;
	

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Override
	public String toString() {
		return "FechasInputDTO [fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + "]";
	}
	

}
