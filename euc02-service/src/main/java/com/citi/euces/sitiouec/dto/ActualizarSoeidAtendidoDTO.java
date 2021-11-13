package com.citi.euces.sitiouec.dto;

public class ActualizarSoeidAtendidoDTO {

	private Long idTasaAuto;
	private String soiedAtendido;

	public ActualizarSoeidAtendidoDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}
	public String getSoiedAtendido() {
		return soiedAtendido;
	}

	public void setSoiedAtendido(String soiedAtendido) {
		this.soiedAtendido = soiedAtendido;
	}

	@Override
	public String toString() {
		return "ActualizarSoeidAtendidoDTO [idTasaAuto=" + idTasaAuto + ", soiedAtendido=" + soiedAtendido + "]";
	}

}
