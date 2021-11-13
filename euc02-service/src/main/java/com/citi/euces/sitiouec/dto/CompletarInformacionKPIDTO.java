package com.citi.euces.sitiouec.dto;

import java.sql.Timestamp;
import java.util.Date;

public class CompletarInformacionKPIDTO {
	
	
	private Long IdTasaAuto;

	private Long numAutoriEuc;
	
	private String fechaSolicitud;
	
	private java.sql.Timestamp fechaSoli;
	
	private String estatus; //estatus de la tabla de autotasas
	
	private Long isProcess; // estatus de la tabla tasas
	
	private String tipoAutori;
	
	private String contrato;
	
	private Long numCliente;
	
	private String nomCliente;
	
	private String division;
	
	private String sucursal;
	
	private String observaWeb;
	
	private Long sucSolic;
		
	private Long monto;
	
	private Long plazo;
	
	private Long tasaAutori;
	
	private String soeidAsig;
	
	private String soeidProc;
	
	private String soeidOpe;
	
	private String nomina;
	
	private String nomEjecutivo;
	
	private Date fechaProcess;
	
	
	private String soeidAutori;
	
	public CompletarInformacionKPIDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CompletarInformacionKPIDTO(Long idTasaAuto, Long numAutoriEuc,Timestamp fechaSoli,
			String estatus, Long isProcess, String tipoAutori, String contrato, Long numCliente, String nomCliente,
			String division, String sucursal, String observaWeb, Long sucSolic, Long monto, Long plazo, Long tasaAutori,
			String soeidAsig, String soeidProc, String soeidOpe, String nomina, String nomEjecutivo, Date fechaProcess,
			String soeidAutori){
		super();
		IdTasaAuto = idTasaAuto;
		this.numAutoriEuc = numAutoriEuc;
		this.fechaSoli=fechaSoli;		
		this.estatus = estatus;
		this.isProcess = isProcess;
		this.tipoAutori = tipoAutori;
		this.contrato = contrato;
		this.numCliente = numCliente;
		this.nomCliente = nomCliente;
		this.division = division;
		this.sucursal = sucursal;
		this.observaWeb = observaWeb;
		this.sucSolic = sucSolic;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.soeidAsig = soeidAsig;
		this.soeidProc = soeidProc;
		this.soeidOpe = soeidOpe;
		this.nomina = nomina;
		this.nomEjecutivo = nomEjecutivo;
		this.fechaProcess = fechaProcess;
		this.soeidAutori = soeidAutori;
	}

	public Long getIdTasaAuto() {
		return IdTasaAuto;
	}

	public void setIdTasaAuto(Long idTasaAuto) {
		IdTasaAuto = idTasaAuto;
	}

	public Long getNumAutoriEuc() {
		return numAutoriEuc;
	}

	public void setNumAutoriEuc(Long numAutoriEuc) {
		this.numAutoriEuc = numAutoriEuc;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public java.sql.Timestamp getFechaSoli() {
		return fechaSoli;
	}

	public void setFechaSoli(java.sql.Timestamp fechaSoli) {
		this.fechaSoli = fechaSoli;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Long getIsProcess() {
		return isProcess;
	}

	public void setIsProcess(Long isProcess) {
		this.isProcess = isProcess;
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

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getObservaWeb() {
		return observaWeb;
	}

	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}

	public Long getSucSolic() {
		return sucSolic;
	}

	public void setSucSolic(Long sucSolic) {
		this.sucSolic = sucSolic;
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

	public Long getTasaAutori() {
		return tasaAutori;
	}

	public void setTasaAutori(Long tasaAutori) {
		this.tasaAutori = tasaAutori;
	}

	public String getSoeidAsig() {
		return soeidAsig;
	}

	public void setSoeidAsig(String soeidAsig) {
		this.soeidAsig = soeidAsig;
	}

	public String getSoeidProc() {
		return soeidProc;
	}

	public void setSoeidProc(String soeidProc) {
		this.soeidProc = soeidProc;
	}

	public String getSoeidOpe() {
		return soeidOpe;
	}

	public void setSoeidOpe(String soeidOpe) {
		this.soeidOpe = soeidOpe;
	}

	public String getNomina() {
		return nomina;
	}

	public void setNomina(String nomina) {
		this.nomina = nomina;
	}

	public String getNomEjecutivo() {
		return nomEjecutivo;
	}

	public void setNomEjecutivo(String nomEjecutivo) {
		this.nomEjecutivo = nomEjecutivo;
	}

	public Date getFechaProcess() {
		return fechaProcess;
	}

	public void setFechaProcess(Date fechaProcess) {
		this.fechaProcess = fechaProcess;
	}

	public String getSoeidAutori() {
		return soeidAutori;
	}

	public void setSoeidAutori(String soeidAutori) {
		this.soeidAutori = soeidAutori;
	}
	
	
	
	
	
	

}
