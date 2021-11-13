package com.citi.euces.sitiouec.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_AUTOTASAS") // TSC_EUCS_OWN
public class AutoTasas {

	@Id
	@Column(name = "ID_TASAUTO", nullable = true)
	private Long idTasaAuto;

	@Column(name = "FECHA_SOLIC", nullable = true)
	private java.sql.Timestamp fechaSoli;

	@Column(name = "FECHA_AUTORI", nullable = true)
	private Date fechaAutori;

	@Column(name = "FECHA_PROCESS", nullable = true)
	private Date fechaProcess;

	@Column(name = "FECHA_ESTATUS", nullable = true)
	private java.sql.Timestamp fechaEstatus;

	@Column(name = "IS_PROCESS", nullable = true)
	private Long iSProcess;

	@Column(name = "ESTATUS", nullable = true)
	private String estatus;

	@Column(name = "SUC_SOLIC", nullable = true)
	private Long sucSolic;

	@Column(name = "DIVISION", nullable = true)
	private String division;

	@Column(name = "NUM_CTE", nullable = true)
	private Long numCliente;

	@Column(name = "NOM_CTE", nullable = true)
	private String nomCliente;

	@Column(name = "CONTRATO", nullable = true)
	private String contrato;

	@Column(name = "NOMINA", nullable = true)
	private String nomina;

	@Column(name = "NOMEJEC", nullable = true)
	private String nomEjecutivo;

	@Column(name = "MONTO", nullable = true)
	private Double monto;

	@Column(name = "PLAZO", nullable = true)
	private Long plazo;

	@Column(name = "TASA_AUTORI", nullable = true)
	private Double tasaAutori;

	@Column(name = "TIPO_AUTORI", nullable = true)
	private String tipoAutori;

	@Column(name = "SOEID_AUTORI", nullable = true)
	private String soeidAutori;

	@Column(name = "INIC_AUTORI", nullable = true)
	private String inicAutori;

	@Column(name = "NUM_AUTORI_UEC", nullable = true)
	private Long numAutoriEuc;

	@Column(name = "SOEID_ASIG", nullable = true)
	private String soeidAsig;

	@Column(name = "SOEID_PROC", nullable = true)
	private String soeidProc;

	@Column(name = "SOEID_OPE", nullable = true)
	private String soeidOpe;

	@Column(name = "CETE", nullable = true)
	private Long cete;

	@Column(name = "PORCEN_CETE", nullable = true)
	private Long porcenCete;

	@Column(name = "OBSERVA_WEB", nullable = true)
	private String observaWeb;

	@Column(name = "JUSTIFICACION", nullable = true)
	private String justificacion;

	@Column(name = "CEL", nullable = true)
	private String cel;

	@Column(name = "T_PER")
	private Long tPer;

	@Column(name = "FECHA_SOLIC_CANCEL", nullable = true)
	private Date fechaSolicCancel;

	@Column(name = "NOMINA_CANCEL", nullable = true)
	private String nominaCancel;

	@Column(name = "NOMEJEC_CANCEL", nullable = true)
	private String nomEjeCancel;

	@Column(name = "JUSTIFICACION_CANCEL", nullable = true)
	private String justificacionCancel;

	@Column(name = "REINVERSION", nullable = true)
	private String reInversion;

	@Column(name = "IS_CUENTA_MAESTRA", nullable = true)
	private Long isCuentaMaestra;

	@Column(name = "IS_PORTABILIDAD", nullable = true)
	private String isPortabilidad;

	@Column(name = "EMAIL", nullable = true)
	private String email;

	@Column(name = "AUTORIZADORES", nullable = true)
	private String autorizadores;

	@Column(name = "CERTIFICADO_FISICO", nullable = true)
	private String certificadoFisico;

	@Column(name = "CERTIFICADO_MORAL", nullable = true)
	private String certificadoMoral;

	@Column(name = "SUC", nullable = true)
	private String sucursal;

	@Column(name = "ID_CAMPANA", nullable = true)
	private String idCampana;

	@Column(name = "MONTOVENTAS")
	private Long montoVentas;

	@Column(name = "VENTAS")
	private Long ventas;

	@Column(name = "DISTRITO", nullable = true)
	private String distrito;

	@Column(name = "CAPITA", nullable = true)
	private Float capita;

	@Column(name = "EJECUTIVOS", nullable = true)
	private Float ejecutivo;
	
	@Column(name = "DISTRITO_NOMBRE", nullable = true)
	private String distritoNombre;
	
	@Column(name = "EJECUTIVO_TOTAL", nullable = true)
	private Float ejeTotal;

	@Column(name = "ESTATUS_CLIENTE", nullable = true)
	private String estatusCliente;
	
	@Column(name = "OFERTA_ID", nullable = true)
	private String ofertaID;
	
	

	public AutoTasas() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdTasaAuto() {
		return idTasaAuto;
	}
	
	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	public java.sql.Timestamp getFechaSoli() {
		return fechaSoli;
	}

	public void setFechaSoli(java.sql.Timestamp fechaSoli) {
		this.fechaSoli = fechaSoli;
	}

	public Date getFechaAutori() {
		return fechaAutori;
	}

	public void setFechaAutori(Date fechaAutori) {
		this.fechaAutori = fechaAutori;
	}

	public Date getFechaProcess() {
		return fechaProcess;
	}

	public void setFechaProcess(Date fechaProcess) {
		this.fechaProcess = fechaProcess;
	}

	public java.sql.Timestamp getFechaEstatus() {
		return fechaEstatus;
	}

	public void setFechaEstatus(java.sql.Timestamp fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}

	public Long getiSProcess() {
		return iSProcess;
	}

	public void setiSProcess(Long iSProcess) {
		this.iSProcess = iSProcess;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Long getSucSolic() {
		return sucSolic;
	}

	public void setSucSolic(Long sucSolic) {
		this.sucSolic = sucSolic;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
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

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
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

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
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

	public Long getNumAutoriEuc() {
		return numAutoriEuc;
	}

	public void setNumAutoriEuc(Long numAutoriEuc) {
		this.numAutoriEuc = numAutoriEuc;
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

	public Long getCete() {
		return cete;
	}

	public void setCete(Long cete) {
		this.cete = cete;
	}

	public Long getPorcenCete() {
		return porcenCete;
	}

	public void setPorcenCete(Long porcenCete) {
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

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public Long gettPer() {
		return tPer;
	}

	public void settPer(Long tPer) {
		this.tPer = tPer;
	}

	public Date getFechaSolicCancel() {
		return fechaSolicCancel;
	}

	public void setFechaSolicCancel(Date fechaSolicCancel) {
		this.fechaSolicCancel = fechaSolicCancel;
	}

	public String getNominaCancel() {
		return nominaCancel;
	}

	public void setNominaCancel(String nominaCancel) {
		this.nominaCancel = nominaCancel;
	}

	public String getNomEjeCancel() {
		return nomEjeCancel;
	}

	public void setNomEjeCancel(String nomEjeCancel) {
		this.nomEjeCancel = nomEjeCancel;
	}

	public String getJustificacionCancel() {
		return justificacionCancel;
	}

	public void setJustificacionCancel(String justificacionCancel) {
		this.justificacionCancel = justificacionCancel;
	}

	public String getReInversion() {
		return reInversion;
	}

	public void setReInversion(String reInversion) {
		this.reInversion = reInversion;
	}

	public Long getIsCuentaMaestra() {
		return isCuentaMaestra;
	}

	public void setIsCuentaMaestra(Long isCuentaMaestra) {
		this.isCuentaMaestra = isCuentaMaestra;
	}

	public String getIsPortabilidad() {
		return isPortabilidad;
	}

	public void setIsPortabilidad(String isPortabilidad) {
		this.isPortabilidad = isPortabilidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAutorizadores() {
		return autorizadores;
	}

	public void setAutorizadores(String autorizadores) {
		this.autorizadores = autorizadores;
	}

	public String getCertificadoFisico() {
		return certificadoFisico;
	}

	public void setCertificadoFisico(String certificadoFisico) {
		this.certificadoFisico = certificadoFisico;
	}

	public String getCertificadoMoral() {
		return certificadoMoral;
	}

	public void setCertificadoMoral(String certificadoMoral) {
		this.certificadoMoral = certificadoMoral;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(String idCampana) {
		this.idCampana = idCampana;
	}

	public Long getMontoVentas() {
		return montoVentas;
	}

	public void setMontoVentas(Long montoVentas) {
		this.montoVentas = montoVentas;
	}

	public Long getVentas() {
		return ventas;
	}

	public void setVentas(Long ventas) {
		this.ventas = ventas;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Float getCapita() {
		return capita;
	}

	public void setCapita(Float capita) {
		this.capita = capita;
	}

	public Float getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(Float ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public String getDistritoNombre() {
		return distritoNombre;
	}

	public void setDistritoNombre(String distritoNombre) {
		this.distritoNombre = distritoNombre;
	}

	public Float getEjeTotal() {
		return ejeTotal;
	}

	public void setEjeTotal(Float ejeTotal) {
		this.ejeTotal = ejeTotal;
	}

	public String getEstatusCliente() {
		return estatusCliente;
	}

	public void setEstatusCliente(String estatusCliente) {
		this.estatusCliente = estatusCliente;
	}
	
	public String getOfertaID() {
		return ofertaID;
	}
	
	public void setOfertaID(String ofertaID) {
		this.ofertaID = ofertaID;
	}

	public AutoTasas(Long idTasaAuto, Timestamp fechaSoli, Date fechaAutori, Date fechaProcess, Timestamp fechaEstatus,
			Long iSProcess, String estatus, Long sucSolic, String division, Long numCliente, String nomCliente,
			String contrato, String nomina, String nomEjecutivo, Double monto, Long plazo, Double tasaAutori,
			String tipoAutori, String soeidAutori, String inicAutori, Long numAutoriEuc, String soeidAsig,
			String soeidProc, String soeidOpe, Long cete, Long porcenCete, String observaWeb, String justificacion,
			String cel, Long tPer, Date fechaSolicCancel, String nominaCancel, String nomEjeCancel,
			String justificacionCancel, String reInversion, Long isCuentaMaestra, String isPortabilidad, String email,
			String autorizadores, String certificadoFisico, String certificadoMoral, String sucursal, String idCampana,
			Long montoVentas, Long ventas, String distrito, Float capita, Float ejecutivo, String distritoNombre,
			Float ejeTotal, String estatusCliente, String ofertaID) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaSoli = fechaSoli;
		this.fechaAutori = fechaAutori;
		this.fechaProcess = fechaProcess;
		this.fechaEstatus = fechaEstatus;
		this.iSProcess = iSProcess;
		this.estatus = estatus;
		this.sucSolic = sucSolic;
		this.division = division;
		this.numCliente = numCliente;
		this.nomCliente = nomCliente;
		this.contrato = contrato;
		this.nomina = nomina;
		this.nomEjecutivo = nomEjecutivo;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.tipoAutori = tipoAutori;
		this.soeidAutori = soeidAutori;
		this.inicAutori = inicAutori;
		this.numAutoriEuc = numAutoriEuc;
		this.soeidAsig = soeidAsig;
		this.soeidProc = soeidProc;
		this.soeidOpe = soeidOpe;
		this.cete = cete;
		this.porcenCete = porcenCete;
		this.observaWeb = observaWeb;
		this.justificacion = justificacion;
		this.cel = cel;
		this.tPer = tPer;
		this.fechaSolicCancel = fechaSolicCancel;
		this.nominaCancel = nominaCancel;
		this.nomEjeCancel = nomEjeCancel;
		this.justificacionCancel = justificacionCancel;
		this.reInversion = reInversion;
		this.isCuentaMaestra = isCuentaMaestra;
		this.isPortabilidad = isPortabilidad;
		this.email = email;
		this.autorizadores = autorizadores;
		this.certificadoFisico = certificadoFisico;
		this.certificadoMoral = certificadoMoral;
		this.sucursal = sucursal;
		this.idCampana = idCampana;
		this.montoVentas = montoVentas;
		this.ventas = ventas;
		this.distrito = distrito;
		this.capita = capita;
		this.ejecutivo = ejecutivo;
		this.distritoNombre = distritoNombre;
		this.ejeTotal = ejeTotal;
		this.estatusCliente = estatusCliente;
		this.ofertaID = ofertaID;
	}

	
	

	
	

	
}
