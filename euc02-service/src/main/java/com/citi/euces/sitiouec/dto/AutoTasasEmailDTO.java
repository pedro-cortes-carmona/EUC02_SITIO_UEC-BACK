package com.citi.euces.sitiouec.dto;

import java.sql.Timestamp;
import java.util.List;

public class AutoTasasEmailDTO {

	private Long idTasaAuto;

	private Long sucSolic;

	private java.sql.Timestamp fechaSoli;

	private String fechaSoliS; // No considerar para Constructor

	private String suc;

	private String estatus;

	private String tipoAutori;

	private String contrato;

	private Long numCliente;

	private String nomina;

	private String nomEjec;

	private String nomCliente;

	private Long monto;

	private Long plazo;

	private Double tasaAutori;

	private String foliobancanet;

	private String autorizadores;

	private List<AutoAutorizadorDTO> lsAutorizadores;

	public AutoTasasEmailDTO() {
		// TODO Auto-generated constructor stub
	}

	public AutoTasasEmailDTO(Long idTasaAuto, Long sucSolic, Timestamp fechaSoli, String suc, String estatus,
			String tipoAutori, String contrato, Long numCliente, String nomina, String nomEjec, String nomCliente,
			Long monto, Long plazo, Double tasaAutori, String foliobancanet) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.sucSolic = sucSolic;
		this.fechaSoli = fechaSoli;
		this.suc = suc;
		this.estatus = estatus;
		this.tipoAutori = tipoAutori;
		this.contrato = contrato;
		this.numCliente = numCliente;
		this.nomina = nomina;
		this.nomEjec = nomEjec;
		this.nomCliente = nomCliente;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.foliobancanet = foliobancanet;
	}

	public List<AutoAutorizadorDTO> getLsAutorizadores() {
		return lsAutorizadores;
	}

	public void setLsAutorizadores(List<AutoAutorizadorDTO> lsAutorizadores) {
		this.lsAutorizadores = lsAutorizadores;
	}

	public String getFechaSoliS() {
		return fechaSoliS;
	}

	public void setFechaSoliS(String fechaSoliS) {
		this.fechaSoliS = fechaSoliS;
	}

	public String getAutorizadores() {
		return autorizadores;
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

	public Long getSucSolic() {
		return sucSolic;
	}

	public void setSucSolic(Long sucSolic) {
		this.sucSolic = sucSolic;
	}

	public java.sql.Timestamp getFechaSoli() {
		return fechaSoli;
	}

	public void setFechaSoli(java.sql.Timestamp fechaSoli) {
		this.fechaSoli = fechaSoli;
	}

	public String getSuc() {
		return suc;
	}

	public void setSuc(String suc) {
		this.suc = suc;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getTipoAutori() {
		return tipoAutori;
	}

	public void setTipoAutori(String tipoAutori) {
		this.tipoAutori = tipoAutori;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public Long getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(Long numCliente) {
		this.numCliente = numCliente;
	}

	public String getNomina() {
		return nomina;
	}

	public void setNomina(String nomina) {
		this.nomina = nomina;
	}

	public String getNomEjec() {
		return nomEjec;
	}

	public void setNomEjec(String nomEjec) {
		this.nomEjec = nomEjec;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public Long getPlazo() {
		return plazo;
	}

	public void setPlazo(Long plazo) {
		this.plazo = plazo;
	}

	public Double getTasaAutori() {
		return tasaAutori;
	}

	public void setTasaAutori(Double tasaAutori) {
		this.tasaAutori = tasaAutori;
	}

	public String getFoliobancanet() {
		return foliobancanet;
	}

	public void setFoliobancanet(String foliobancanet) {
		this.foliobancanet = foliobancanet;
	}

	@Override
	public String toString() {
		return "AutoTasasEmailDTO [idTasaAuto=" + idTasaAuto + ", sucSolic=" + sucSolic + ", fechaSoli=" + fechaSoli
				+ ", fechaSoliS=" + fechaSoliS + ", suc=" + suc + ", estatus=" + estatus + ", tipoAutori=" + tipoAutori
				+ ", contrato=" + contrato + ", numCliente=" + numCliente + ", nomina=" + nomina + ", nomEjec="
				+ nomEjec + ", nomCliente=" + nomCliente + ", monto=" + monto + ", plazo=" + plazo + ", tasaAutori="
				+ tasaAutori + ", foliobancanet=" + foliobancanet + ", autorizadores=" + autorizadores
				+ ", lsAutorizadores=" + lsAutorizadores + "]";
	}

}
