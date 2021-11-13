package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_TASAS_TIMELINESS")
public class TasasTimeLiness { // TSC_EUCS_OWN

	
	@Id
	@Column(name = "ID_TASA", nullable = true)
	private Long idTasa;

	@Column(name = "ASIGNADO_A", nullable = true)
	private String asignadoA;

	@Column(name = "OPERADO_POR", nullable = true)
	private String operadoPor;

	@Column(name = "CONTRATO", nullable = true)
	private Long contrato;

	@Column(name = "NUM_CTE", nullable = true)
	private Long num_cte;

	@Column(name = "ESTATUS", nullable = true)
	private String estatus;

	@Column(name = "FECHA_CAPTURA", nullable = true)
	private java.sql.Timestamp fechaCaptura;

	@Column(name = "FECHA_AUTORI", nullable = true)
	private java.sql.Timestamp fechaAutori;

	@Column(name = "FECHA_ESTATUS", nullable = true)
	private java.sql.Timestamp fechaEstatus;

	@Column(name = "OBSERVA_WEB", nullable = true)
	private String observaWeb;

	@Column(name = "CAMPANA_WEB", nullable = true)
	private String campanaWeb;

	@Column(name = "SOEID_RESP", nullable = true)
	private String soeidResp;
	

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

	@Override
	public String toString() {
		return "TasasTimeLiness [idTasa=" + idTasa + ", asignadoA=" + asignadoA + ", operadoPor=" + operadoPor
				+ ", contrato=" + contrato + ", num_cte=" + num_cte + ", estatus=" + estatus + ", fechaCaptura="
				+ fechaCaptura + ", fechaAutori=" + fechaAutori + ", fechaEstatus=" + fechaEstatus + ", observaWeb="
				+ observaWeb + ", campanaWeb=" + campanaWeb + ", soeidResp=" + soeidResp + "]";
	}
	
	

}
