package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.Date;

public class TasasDiarioA implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fechaOpe;
	private Integer estatus;
	private Integer contrato;
	private Integer numInversion;
	private Integer plazo;
	private Double monto;
	private Double tasaAutori;
	private String horaAutori;
	private Integer numAutoriUEC;
	private String distrito;
	private Integer sucSolic;
	private String division;
	private String campanaWeb;
	private Integer isWeb;
	private String nomina;
	private String nomEjec;
	private String nomCte;
	private Integer numCte;
	private String observaWeb;
	private String soeidAsignadoA;
	private String soeidOperadoPor;
	/********************************/
	private Double cete;
	private Double porcenCete;
	private String inicialesAutori;
	private Integer isBei;
	private String segmento;
	private String tipoAutorizador;
	private Integer idAcum;
	
	
	public TasasDiarioA(Date fechaOpe, Integer estatus, Integer contrato, Integer plazo, Double monto,
			Double tasaAutori, Integer numAutoriUEC, String distrito, Integer sucSolic, String division,
			String campanaWeb, String nomCte, Integer numCte, String observaWeb, Double cete, Double porcenCete,
			String inicialesAutori, Integer isBei, String segmento, String tipoAutorizador, String nomina) {
		super();
		this.fechaOpe = fechaOpe;
		this.estatus = estatus;
		this.contrato = contrato;
		this.plazo = plazo;
		this.monto = monto;
		this.tasaAutori = tasaAutori;
		this.numAutoriUEC = numAutoriUEC;
		this.distrito = distrito;
		this.sucSolic = sucSolic;
		this.division = division;
		this.campanaWeb = campanaWeb;
		this.nomCte = nomCte;
		this.numCte = numCte;
		this.observaWeb = observaWeb;
		this.cete = cete;
		this.porcenCete = porcenCete;
		this.inicialesAutori = inicialesAutori;
		this.isBei = isBei;
		this.segmento = segmento;
		this.tipoAutorizador = tipoAutorizador;
		this.nomina = nomina;
	}

	public TasasDiarioA() {}
	
	public TasasDiarioA(Date fechaOpe, Integer estatus, Integer contrato, Integer numInversion, Integer plazo,
			Double monto, Double tasaAutori, String horaAutori, Integer numAutoriUEC, String distrito, Integer sucSolic,
			String division, String campanaWeb, Integer isWeb, String nomina, String nomEjec, String nomCte,
			Integer numCte, String observaWeb, String soeidAsignadoA, String soeidOperadoPor, Integer idAcum) {
		super();
		this.fechaOpe = fechaOpe;
		this.estatus = estatus;
		this.contrato = contrato;
		this.numInversion = numInversion;
		this.plazo = plazo;
		this.monto = monto;
		this.tasaAutori = tasaAutori;
		this.horaAutori = horaAutori;
		this.numAutoriUEC = numAutoriUEC;
		this.distrito = distrito;
		this.sucSolic = sucSolic;
		this.division = division;
		this.campanaWeb = campanaWeb;
		this.isWeb = isWeb;
		this.nomina = nomina;
		this.nomEjec = nomEjec;
		this.nomCte = nomCte;
		this.numCte = numCte;
		this.observaWeb = observaWeb;
		this.soeidAsignadoA = soeidAsignadoA;
		this.soeidOperadoPor = soeidOperadoPor;
		this.idAcum = idAcum; 
	}

	
	
	public Integer getIdAcum() {
		return idAcum;
	}

	public void setIdAcum(Integer idAcum) {
		this.idAcum = idAcum;
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

	public String getInicialesAutori() {
		return inicialesAutori;
	}

	public void setInicialesAutori(String inicialesAutori) {
		this.inicialesAutori = inicialesAutori;
	}

	public Integer getIsBei() {
		return isBei;
	}

	public void setIsBei(Integer isBei) {
		this.isBei = isBei;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getTipoAutorizador() {
		return tipoAutorizador;
	}

	public void setTipoAutorizador(String tipoAutorizador) {
		this.tipoAutorizador = tipoAutorizador;
	}

	public Date getFechaOpe() {
		return fechaOpe;
	}

	public void setFechaOpe(Date fechaOpe) {
		this.fechaOpe = fechaOpe;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getContrato() {
		return contrato;
	}

	public void setContrato(Integer contrato) {
		this.contrato = contrato;
	}

	public Integer getNumInversion() {
		return numInversion;
	}

	public void setNumInversion(Integer numInversion) {
		this.numInversion = numInversion;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Double getTasaAutori() {
		return tasaAutori;
	}

	public void setTasaAutori(Double tasaAutori) {
		this.tasaAutori = tasaAutori;
	}

	public String getHoraAutori() {
		return horaAutori;
	}

	public void setHoraAutori(String horaAutori) {
		this.horaAutori = horaAutori;
	}

	public Integer getNumAutoriUEC() {
		return numAutoriUEC;
	}

	public void setNumAutoriUEC(Integer numAutoriUEC) {
		this.numAutoriUEC = numAutoriUEC;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
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

	public String getCampanaWeb() {
		return campanaWeb;
	}

	public void setCampanaWeb(String campanaWeb) {
		this.campanaWeb = campanaWeb;
	}

	public Integer getIsWeb() {
		return isWeb;
	}

	public void setIsWeb(Integer isWeb) {
		this.isWeb = isWeb;
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

	public String getNomCte() {
		return nomCte;
	}

	public void setNomCte(String nomCte) {
		this.nomCte = nomCte;
	}

	public Integer getNumCte() {
		return numCte;
	}

	public void setNumCte(Integer numCte) {
		this.numCte = numCte;
	}

	public String getObservaWeb() {
		return observaWeb;
	}

	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}

	public String getSoeidAsignadoA() {
		return soeidAsignadoA;
	}

	public void setSoeidAsignadoA(String soeidAsignadoA) {
		this.soeidAsignadoA = soeidAsignadoA;
	}

	public String getSoeidOperadoPor() {
		return soeidOperadoPor;
	}

	public void setSoeidOperadoPor(String soeidOperadoPor) {
		this.soeidOperadoPor = soeidOperadoPor;
	}
	
	
}
