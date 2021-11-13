package com.citi.euces.sitiouec.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseSinDatosDTO {

	
	@JsonProperty("sinRegistrosClientes")
	private String sinRegistrosClientesRepetidos;

	@JsonProperty("sinRegistrosContratos")
	private String sinRegistrosContratosRpetidos;

	private String sinRegistros;

	@JsonProperty("sinRegistrosAutoCetes")
	private String sinRegistrosAutoCetes;

	@JsonProperty("sinRegistrosSubastas")
	private String sinRegistrosSubastas;

	public String getSinRegistrosSubastas() {
		return sinRegistrosSubastas;
	}

	public void setSinRegistrosSubastas(String sinRegistrosSubastas) {
		this.sinRegistrosSubastas = sinRegistrosSubastas;
	}

	public String getSinRegistrosAutoCetes() {
		return sinRegistrosAutoCetes;
	}

	public void setSinRegistrosAutoCetes(String sinRegistrosAutoCetes) {
		this.sinRegistrosAutoCetes = sinRegistrosAutoCetes;
	}

	public String getSinRegistros() {
		return sinRegistros;
	}

	public void setSinRegistros(String sinRegistros) {
		this.sinRegistros = sinRegistros;
	}

	public String getSinRegistrosClientesRepetidos() {
		return sinRegistrosClientesRepetidos;
	}

	public void setSinRegistrosClientesRepetidos(String sinRegistrosClientesRepetidos) {
		this.sinRegistrosClientesRepetidos = sinRegistrosClientesRepetidos;
	}

	public String getSinRegistrosContratosRpetidos() {
		return sinRegistrosContratosRpetidos;
	}

	public void setSinRegistrosContratosRpetidos(String sinRegistrosContratosRpetidos) {
		this.sinRegistrosContratosRpetidos = sinRegistrosContratosRpetidos;
	}

	@Override
	public String toString() {
		return "ResponseSinDatosDTO [sinRegistrosClientesRepetidos=" + sinRegistrosClientesRepetidos
				+ ", sinRegistrosContratosRpetidos=" + sinRegistrosContratosRpetidos + ", sinRegistros=" + sinRegistros
				+ ", sinRegistrosAutoCetes=" + sinRegistrosAutoCetes + ", sinRegistrosSubastas=" + sinRegistrosSubastas
				+ "]";
	}

}
