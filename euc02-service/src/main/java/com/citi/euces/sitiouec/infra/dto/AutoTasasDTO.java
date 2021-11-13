package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.Date;

public class AutoTasasDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idTasaAuto;
	private Date fechaSolic;
	private Date fechaAutori;
	private Date fechaProcess;
	private Date fechaEstatus;
	private Integer isProcess;
	private String status;
	private Integer sucSolic;
	private String division;
	private Integer numCte;
	private String nomCte;
	private String contrato;
	private String nomina;
	private String nomEjec;
	private Double monto;
	private Integer plazo;
	private Double tasaAutori;
	private String tipoAutori;
	private String idCampana;
	private String soeidAutori;
	private String inicAutori;
	private Integer numAutoriUEC;
	private String soeidAsig;
	private String soeidProc;
	private String soeidOpe;
	private Double porcenCete;
	private Integer cete;
	private Integer isTasaBase;
	private String idOferta;
	
	public AutoTasasDTO() {}
	
	public AutoTasasDTO(Long idTasaAuto, Date fechaSolic, Date fechaAutori, Date fechaProcess, Date fechaEstatus,
			Integer isProcess, String status, Integer sucSolic, String division, Integer numCte, String nomCte,
			String contrato, String nomina, String nomEjec, Double monto, Integer plazo, Double tasaAutori,
			String tipoAutori, String idCampana, String soeidAutori, String inicAutori, Integer numAutoriUEC, String soeidAsig,
			String soeidProc, String soeidOpe, Double porcenCete, Integer cete, Integer isTasaBase, String idOferta) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaSolic = fechaSolic;
		this.fechaAutori = fechaAutori;
		this.fechaProcess = fechaProcess;
		this.fechaEstatus = fechaEstatus;
		this.isProcess = isProcess;
		this.status = status;
		this.sucSolic = sucSolic;
		this.division = division;
		this.numCte = numCte;
		this.nomCte = nomCte;
		this.contrato = contrato;
		this.nomina = nomina;
		this.nomEjec = nomEjec;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.tipoAutori = tipoAutori;
		this.idCampana = idCampana; 
		this.soeidAutori = soeidAutori;
		this.inicAutori = inicAutori;
		this.numAutoriUEC = numAutoriUEC;
		this.soeidAsig = soeidAsig;
		this.soeidProc = soeidProc;
		this.soeidOpe = soeidOpe;
		this.porcenCete = porcenCete;
		this.cete = cete;
		this.isTasaBase = isTasaBase;
		this.idOferta = idOferta;
	}

	public String getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(String idOferta) {
		this.idOferta = idOferta;
	}

	public String getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(String idCampana) {
		this.idCampana = idCampana;
	}

	public Integer getIsTasaBase() {
		return isTasaBase;
	}

	public void setIsTasaBase(Integer isTasaBase) {
		this.isTasaBase = isTasaBase;
	}

	public Long getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	public Date getFechaSolic() {
		return fechaSolic;
	}

	public void setFechaSolic(Date fechaSolic) {
		this.fechaSolic = fechaSolic;
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

	public Date getFechaEstatus() {
		return fechaEstatus;
	}

	public void setFechaEstatus(Date fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}

	public Integer getIsProcess() {
		return isProcess;
	}

	public void setIsProcess(Integer isProcess) {
		this.isProcess = isProcess;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSucSolic() {
		return sucSolic;
	}

	public void setSucSolic(Integer sucSolic) {
		this.sucSolic = sucSolic;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Integer getNumCte() {
		return numCte;
	}

	public void setNumCte(Integer numCte) {
		this.numCte = numCte;
	}

	public String getNomCte() {
		return nomCte;
	}

	public void setNomCte(String nomCte) {
		this.nomCte = nomCte;
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

	public String getNomEjec() {
		return nomEjec;
	}

	public void setNomEjec(String nomEjec) {
		this.nomEjec = nomEjec;
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

	public Integer getNumAutoriUEC() {
		return numAutoriUEC;
	}

	public void setNumAutoriUEC(Integer numAutoriUEC) {
		this.numAutoriUEC = numAutoriUEC;
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

	public Double getPorcenCete() {
		return porcenCete;
	}

	public void setPorcenCete(Double porcenCete) {
		this.porcenCete = porcenCete;
	}

	public Integer getCete() {
		return cete;
	}

	public void setCete(Integer cete) {
		this.cete = cete;
	}
	
}
