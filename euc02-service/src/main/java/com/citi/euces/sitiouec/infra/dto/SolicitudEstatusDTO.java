package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.Date;

public class SolicitudEstatusDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTasaAuto;
	private Date fechaAutori;
	private Date fechaSolic;
	private Date fechaEstatus;
	private Date fechaProcess;
	private String estatus;
	private String division;
	private Integer sucSolic;
	private Long numCte;
	private String nomCte;
	private Long contrato;
	private String nomina;
	private String nomEjec;
	private String cel;
	private Double monto;
	private Integer plazo;
	private Double tasaAutori;
	private String tipoAutori;
	private String soeidAutori;
	private String inicAutori;
	private Long numAutoriUEC;
	private Double cete;
	private Double porcenCete;
	private String observaWeb;
	private String justificacion;
	private Integer isProcess;
	private Date fechasSolicCancel;
	private String nomEjecCancel;
	private String justificacionCancel;
	private String isNuevo;
	private String autorizadores;
	private String soeidAsig;
	
	public SolicitudEstatusDTO() {}
	
	public SolicitudEstatusDTO(Date fechaAutori, Date fechaSolic, Date fechaEstatus,
			Date fechaProcess, String estatus, String division, Integer sucSolic, Long numCte, String nomCte,
			Long contrato, String nomina, String nomEjec, String cel, Double monto, Integer plazo, Double tasaAutori,
			String tipoAutori, String soeidAutori, String inicAutori, Long numAutoriUEC, Double cete,
			Double porcenCete, String observaWeb, String justificacion, Integer isProcess, Date fechasSolicCancel,
			String nomEjecCancel, String justificacionCancel, String autorizadores) {
		super();
		this.fechaAutori = fechaAutori;
		this.fechaSolic = fechaSolic;
		this.fechaEstatus = fechaEstatus;
		this.fechaProcess = fechaProcess;
		this.estatus = estatus;
		this.division = division;
		this.sucSolic = sucSolic;
		this.numCte = numCte;
		this.nomCte = nomCte;
		this.contrato = contrato;
		this.nomina = nomina;
		this.nomEjec = nomEjec;
		this.cel = cel;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.tipoAutori = tipoAutori;
		this.soeidAutori = soeidAutori;
		this.inicAutori = inicAutori;
		this.numAutoriUEC = numAutoriUEC;
		this.cete = cete;
		this.porcenCete = porcenCete;
		this.observaWeb = observaWeb;
		this.justificacion = justificacion;
		this.isProcess = isProcess;
		this.fechasSolicCancel = fechasSolicCancel;
		this.nomEjecCancel = nomEjecCancel;
		this.justificacionCancel = justificacionCancel;
		this.autorizadores = autorizadores;
	}

	public String getSoeidAsig() {
		return soeidAsig;
	}

	public void setSoeidAsig(String soeidAsig) {
		this.soeidAsig = soeidAsig;
	}

	public Integer getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(Integer idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	public Date getFechaAutori() {
		return fechaAutori;
	}

	public void setFechaAutori(Date fechaAutori) {
		this.fechaAutori = fechaAutori;
	}

	public Date getFechaSolic() {
		return fechaSolic;
	}

	public void setFechaSolic(Date fechaSolic) {
		this.fechaSolic = fechaSolic;
	}

	public Date getFechaEstatus() {
		return fechaEstatus;
	}

	public void setFechaEstatus(Date fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}

	public Date getFechaProcess() {
		return fechaProcess;
	}

	public void setFechaProcess(Date fechaProcess) {
		this.fechaProcess = fechaProcess;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Integer getSucSolic() {
		return sucSolic;
	}

	public void setSucSolic(Integer sucSolic) {
		this.sucSolic = sucSolic;
	}

	public Long getNumCte() {
		return numCte;
	}

	public void setNumCte(Long numCte) {
		this.numCte = numCte;
	}

	public String getNomCte() {
		return nomCte;
	}

	public void setNomCte(String nomCte) {
		this.nomCte = nomCte;
	}

	public Long getContrato() {
		return contrato;
	}

	public void setContrato(Long contrato) {
		this.contrato = contrato;
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

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public Double getTasaAutori() {
		return tasaAutori;
	}

	public void setTasaAutori(Double tasaAutori) {
		this.tasaAutori = tasaAutori;
	}

	public String getTipoAutori() {
		return tipoAutori;
	}

	public void setTipoAutori(String tipoAutori) {
		this.tipoAutori = tipoAutori;
	}

	public String getSoeidAutori() {
		return soeidAutori;
	}

	public void setSoeidAutori(String soeidAutori) {
		this.soeidAutori = soeidAutori;
	}

	public String getInicAutori() {
		return inicAutori;
	}

	public void setInicAutori(String inicAutori) {
		this.inicAutori = inicAutori;
	}

	public Long getNumAutoriUEC() {
		return numAutoriUEC;
	}

	public void setNumAutoriUEC(Long numAutoriUEC) {
		this.numAutoriUEC = numAutoriUEC;
	}

	public Double getCete() {
		return cete;
	}

	public void setCete(Double cete) {
		this.cete = cete;
	}

	public Double getPorcenCete() {
		return porcenCete;
	}

	public void setPorcenCete(Double porcenCete) {
		this.porcenCete = porcenCete;
	}

	public String getObservaWeb() {
		return observaWeb;
	}

	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public Integer getIsProcess() {
		return isProcess;
	}

	public void setIsProcess(Integer isProcess) {
		this.isProcess = isProcess;
	}

	public Date getFechasSolicCancel() {
		return fechasSolicCancel;
	}

	public void setFechasSolicCancel(Date fechasSolicCancel) {
		this.fechasSolicCancel = fechasSolicCancel;
	}

	public String getNomEjecCancel() {
		return nomEjecCancel;
	}

	public void setNomEjecCancel(String nomEjecCancel) {
		this.nomEjecCancel = nomEjecCancel;
	}

	public String getJustificacionCancel() {
		return justificacionCancel;
	}

	public void setJustificacionCancel(String justificacionCancel) {
		this.justificacionCancel = justificacionCancel;
	}

	public String getIsNuevo() {
		return isNuevo;
	}

	public void setIsNuevo(String isNuevo) {
		this.isNuevo = isNuevo;
	}

	public String getAutorizadores() {
		return autorizadores;
	}

	public void setAutorizadores(String autorizadores) {
		this.autorizadores = autorizadores;
	}
	
	
	
}
