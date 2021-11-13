package com.citi.euces.sitiouec.dto;

import java.sql.Timestamp;

public class TasasTimeLinessDTO {

	private Long idTasa;

	private String asignadoA;

	private String operadoPor;

	private Long contrato;

	private Long num_cte;

	private String estatus;

	private String fechaSCaptura;

	private String fechaSAutori;

	private String fechaSEstatus;	

	private java.sql.Timestamp fechaCaptura;

	private java.sql.Timestamp fechaAutori;

	private java.sql.Timestamp fechaEstatus;

	private String observaWeb;

	private String campanaWeb;

	private String soeidResp;
	
	public TasasTimeLinessDTO() {
		// TODO Auto-generated constructor stub
	}

	public TasasTimeLinessDTO(Long idTasa, String asignadoA, String operadoPor, Long contrato, Long num_cte,
			String estatus, Timestamp fechaCaptura, Timestamp fechaAutori, Timestamp fechaEstatus, String observaWeb,
			String campanaWeb, String soeidResp) {
		super();
		this.idTasa = idTasa;
		this.asignadoA = asignadoA;
		this.operadoPor = operadoPor;
		this.contrato = contrato;
		this.num_cte = num_cte;
		this.estatus = estatus;
		this.fechaCaptura = fechaCaptura;
		this.fechaAutori = fechaAutori;
		this.fechaEstatus = fechaEstatus;
		this.observaWeb = observaWeb;
		this.campanaWeb = campanaWeb;
		this.soeidResp = soeidResp;
	}

	public Long getIdTasa() {
		return idTasa;
	}

	public void setIdTasa(Long idTasa) {
		this.idTasa = idTasa;
	}

	public String getAsignadoA() {
		return asignadoA;
	}

	public void setAsignadoA(String asignadoA) {
		this.asignadoA = asignadoA;
	}

	public String getOperadoPor() {
		return operadoPor;
	}

	public void setOperadoPor(String operadoPor) {
		this.operadoPor = operadoPor;
	}

	public Long getContrato() {
		return contrato;
	}

	public void setContrato(Long contrato) {
		this.contrato = contrato;
	}

	public Long getNum_cte() {
		return num_cte;
	}

	public void setNum_cte(Long num_cte) {
		this.num_cte = num_cte;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public java.sql.Timestamp getFechaCaptura() {
		return fechaCaptura;
	}

	public void setFechaCaptura(java.sql.Timestamp fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	public java.sql.Timestamp getFechaAutori() {
		return fechaAutori;
	}

	public void setFechaAutori(java.sql.Timestamp fechaAutori) {
		this.fechaAutori = fechaAutori;
	}

	public java.sql.Timestamp getFechaEstatus() {
		return fechaEstatus;
	}

	public void setFechaEstatus(java.sql.Timestamp fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}

	public String getObservaWeb() {
		return observaWeb;
	}

	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}

	public String getCampanaWeb() {
		return campanaWeb;
	}

	public void setCampanaWeb(String campanaWeb) {
		this.campanaWeb = campanaWeb;
	}

	public String getSoeidResp() {
		return soeidResp;
	}

	public void setSoeidResp(String soeidResp) {
		this.soeidResp = soeidResp;
	}
	
	public String getFechaSCaptura() {
		return fechaSCaptura;
	}

	public void setFechaSCaptura(String fechaSCaptura) {
		this.fechaSCaptura = fechaSCaptura;
	}

	public String getFechaSAutori() {
		return fechaSAutori;
	}

	public void setFechaSAutori(String fechaSAutori) {
		this.fechaSAutori = fechaSAutori;
	}

	public String getFechaSEstatus() {
		return fechaSEstatus;
	}

	public void setFechaSEstatus(String fechaSEstatus) {
		this.fechaSEstatus = fechaSEstatus;
	}

	@Override
	public String toString() {
		return "TasasTimeLinessDTO [idTasa=" + idTasa + ", asignadoA=" + asignadoA + ", operadoPor=" + operadoPor
				+ ", contrato=" + contrato + ", num_cte=" + num_cte + ", estatus=" + estatus + ", fechaSCaptura="
				+ fechaSCaptura + ", fechaSAutori=" + fechaSAutori + ", fechaSEstatus=" + fechaSEstatus
				+ ", fechaCaptura=" + fechaCaptura + ", fechaAutori=" + fechaAutori + ", fechaEstatus=" + fechaEstatus
				+ ", observaWeb=" + observaWeb + ", campanaWeb=" + campanaWeb + ", soeidResp=" + soeidResp + "]";
	}

}
