package com.citi.euces.sitiouec.dto;

public class InBuscarClickDTO {
	
	private String estatus;
	
	private String contrato;
	
	private String numeroCliente;
	
	private String fechaSolicitud;
	

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	
	public String getNumeroCliente() {
		return numeroCliente;
	}


	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}


	public String getFechaSolicitud() {
		return fechaSolicitud;
	}


	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	@Override
	public String toString() {
		return "InBuscarClickDTO [estatus="+estatus+", contrato=" + contrato + ",numeroCliente=" + numeroCliente +", fechaSolicitud=" + fechaSolicitud + "]";
	}

}
