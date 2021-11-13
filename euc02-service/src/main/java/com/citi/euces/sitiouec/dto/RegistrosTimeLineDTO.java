package com.citi.euces.sitiouec.dto;

public class RegistrosTimeLineDTO {
	
	private Long   idTasa;
	private String fechaEstatus;
	private Long numCliente;
	private String contrato;
	private String observaWeb;
	private String asginadoA;
	private String operadorPor;
	private Long estatusTasas;
	private String fechaCaptura;
	private String fechaAutori;
    private String campanaWeb;	
	private String soeidRep;
	
	public Long getIdTasa() {
		return idTasa;
	}
	public void setIdTasa(Long idTasa) {
		this.idTasa = idTasa;
	}
	public String getFechaEstatus() {
		return fechaEstatus;
	}
	public void setFechaEstatus(String fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}
	public Long getNumCliente() {
		return numCliente;
	}
	public void setNumCliente(Long numCliente) {
		this.numCliente = numCliente;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getObservaWeb() {
		return observaWeb;
	}
	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}
	public String getAsginadoA() {
		return asginadoA;
	}
	public void setAsginadoA(String asginadoA) {
		this.asginadoA = asginadoA;
	}
	public String getOperadorPor() {
		return operadorPor;
	}
	public void setOperadorPor(String operadorPor) {
		this.operadorPor = operadorPor;
	}
	public Long getEstatusTasas() {
		return estatusTasas;
	}
	public void setEstatusTasas(Long estatusTasas) {
		this.estatusTasas = estatusTasas;
	}
	public String getFechaCaptura() {
		return fechaCaptura;
	}
	public void setFechaCaptura(String fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}
	public String getFechaAutori() {
		return fechaAutori;
	}
	public void setFechaAutori(String fechaAutori) {
		this.fechaAutori = fechaAutori;
	}
	public String getCampanaWeb() {
		return campanaWeb;
	}
	public void setCampanaWeb(String campanaWeb) {
		this.campanaWeb = campanaWeb;
	}
	public String getSoeidRep() {
		return soeidRep;
	}
	public void setSoeidRep(String soeidRep) {
		this.soeidRep = soeidRep;
	}
	
	
	@Override
	public String toString() {
		return "RegistrosTimeLineDTO [idTasa=" + idTasa + ", fechaEstatus=" + fechaEstatus + ", numCliente="
				+ numCliente + ", contrato=" + contrato + ", observaWeb=" + observaWeb + ", asginadoA=" + asginadoA
				+ ", operadorPor=" + operadorPor + ", estatusTasas=" + estatusTasas + ", fechaCaptura=" + fechaCaptura
				+ ", fechaAutori=" + fechaAutori + ", campanaWeb=" + campanaWeb + ", soeidRep=" + soeidRep + "]";
	}
	
	
	
}
