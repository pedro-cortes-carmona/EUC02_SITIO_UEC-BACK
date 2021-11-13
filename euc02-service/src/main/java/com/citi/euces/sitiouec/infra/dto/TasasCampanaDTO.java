package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class TasasCampanaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idTasaAuto;
	private Date fechaProcess;
	private String fechaPro;
	private Integer numAutoriUEC;
	private String division;
	private String distrito;
	private String sucursal;
	private Integer sucSolic;
	private String nomina;
	private String nomEjec;
	private Long numCte;
	private String contrato;
	private String nomCte;
	private String tipoAutori;
	private Double monto;
	private Integer plazo;
	private Long tasaAutori;
	private String estatus;
	private Integer estatus2;
	private Date fechaEstatus;
	private String fechaE;
	private Date fechaSolic;
	private String fechaS;
	private String observaWeb;
	private String soeidOpe;
	private Integer numAutoriUEC2;
	private String soeidAsig;
	private String soeidAutori;
	private String isPortabilidad;
	private String email;
	private Integer tipoPersona;
	private String ofertaId;
	private String sirhSuc;
	private String campana;
	private String gatNominalOferta;
	private String gatRealOferta;
	private Double rendimiento;
	private String ofertaParticipacionUnica;
	private String fechaVigencia;
	private String producto;
	private Integer numInver;
	private String cert;
	private String soeidEjecSuc;
	private String folioPDFEspecial;
	private String idCampana;
	private String aplicado;
	private Double tasa;
	
	public TasasCampanaDTO() {}

	public TasasCampanaDTO(Long idTasaAuto, Date fechaProcess, Integer numAutoriUEC, String division, String distrito,
			String sucursal, Integer sucSolic, String nomina, String nomEjec, Long numCte, String contrato,
			String nomCte, String tipoAutori, Double monto, Integer plazo, Double tasa, String estatus,
			Integer estatus2, Date fechaEstatus, Date fechaSolic, String observaWeb, String soeidOpe,
			Integer numAutoriUEC2, String soeidAsig, String soeidAutori, String isPortabilidad, 
			String ofertaId, String sirhSuc, String gatNominalOferta, String gatRealOferta, Double rendimiento,
			String producto, Integer numInver, String cert, Integer tipoPersona, String folioPDFEspecial, String idCampana,
			String soeidEjecSuc, String fechaPro, String fechaE, String fechaS) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaProcess = fechaProcess;
		this.numAutoriUEC = numAutoriUEC;
		this.division = division;
		this.distrito = distrito;
		this.sucursal = sucursal;
		this.sucSolic = sucSolic;
		this.nomina = nomina;
		this.nomEjec = nomEjec;
		this.numCte = numCte;
		this.contrato = contrato;
		this.nomCte = nomCte;
		this.tipoAutori = tipoAutori;
		this.monto = monto;
		this.plazo = plazo;
		this.tasa = tasa;
		this.estatus = estatus;
		this.estatus2 = estatus2;
		this.fechaEstatus = fechaEstatus;
		this.fechaSolic = fechaSolic;
		this.observaWeb = observaWeb;
		this.soeidOpe = soeidOpe;
		this.numAutoriUEC2 = numAutoriUEC2;
		this.soeidAsig = soeidAsig;
		this.soeidAutori = soeidAutori;
		this.isPortabilidad = isPortabilidad;
		this.ofertaId = ofertaId;
		this.sirhSuc = sirhSuc;
		this.gatNominalOferta = gatNominalOferta;
		this.gatRealOferta = gatRealOferta;
		this.rendimiento = rendimiento;
		this.producto = producto;
		this.numInver = numInver;
		this.cert = cert;
		this.tipoPersona = tipoPersona;
		this.folioPDFEspecial = folioPDFEspecial;
		this.idCampana = idCampana;
		this.soeidEjecSuc = soeidEjecSuc;
		this.fechaPro = fechaPro;
		this.fechaE = fechaE;
		this.fechaS = fechaS;
	}
	
	public TasasCampanaDTO(Long idTasaAuto, Date fechaProcess, Integer numAutoriUEC, String division, String distrito,
			String sucursal, Integer sucSolic, String nomina, String nomEjec, Long numCte, String contrato,
			String nomCte, String tipoAutori, Double monto, Integer plazo, Long tasaAutori, String estatus,
			Integer estatus2, Date fechaEstatus, Date fechaSolic, String observaWeb, String soeidOpe,
			Integer numAutoriUEC2, String soeidAsig, String soeidAutori, String isPortabilidad, 
			String ofertaId, String sirhSuc, String gatNominalOferta, String gatRealOferta, Double rendimiento,
			String producto, Integer numInver, String cert, Integer tipoPersona, String folioPDFEspecial, String idCampana,
			String soeidEjecSuc) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaProcess = fechaProcess;
		this.numAutoriUEC = numAutoriUEC;
		this.division = division;
		this.distrito = distrito;
		this.sucursal = sucursal;
		this.sucSolic = sucSolic;
		this.nomina = nomina;
		this.nomEjec = nomEjec;
		this.numCte = numCte;
		this.contrato = contrato;
		this.nomCte = nomCte;
		this.tipoAutori = tipoAutori;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.estatus = estatus;
		this.estatus2 = estatus2;
		this.fechaEstatus = fechaEstatus;
		this.fechaSolic = fechaSolic;
		this.observaWeb = observaWeb;
		this.soeidOpe = soeidOpe;
		this.numAutoriUEC2 = numAutoriUEC2;
		this.soeidAsig = soeidAsig;
		this.soeidAutori = soeidAutori;
		this.isPortabilidad = isPortabilidad;
		this.ofertaId = ofertaId;
		this.sirhSuc = sirhSuc;
		this.gatNominalOferta = gatNominalOferta;
		this.gatRealOferta = gatRealOferta;
		this.rendimiento = rendimiento;
		this.producto = producto;
		this.numInver = numInver;
		this.cert = cert;
		this.tipoPersona = tipoPersona;
		this.folioPDFEspecial = folioPDFEspecial;
		this.idCampana = idCampana;
		this.soeidEjecSuc = soeidEjecSuc;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	public String getAplicado() {
		return aplicado;
	}

	public void setAplicado(String aplicado) {
		this.aplicado = aplicado;
	}

	public String getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(String idCampana) {
		this.idCampana = idCampana;
	}

	public String getFolioPDFEspecial() {
		return folioPDFEspecial;
	}

	public void setFolioPDFEspecial(String folioPDFEspecial) {
		this.folioPDFEspecial = folioPDFEspecial;
	}

	public String getFechaPro() {
		return fechaPro;
	}

	public void setFechaPro(String fechaPro) {
		this.fechaPro = fechaPro;
	}

	public String getFechaE() {
		return fechaE;
	}

	public void setFechaE(String fechaE) {
		this.fechaE = fechaE;
	}

	public String getFechaS() {
		return fechaS;
	}

	public void setFechaS(String fechaS) {
		this.fechaS = fechaS;
	}

	public String getOfertaId() {
		return ofertaId;
	}

	public void setOfertaId(String ofertaId) {
		this.ofertaId = ofertaId;
	}

	public String getSirhSuc() {
		return sirhSuc;
	}

	public void setSirhSuc(String sirhSuc) {
		this.sirhSuc = sirhSuc;
	}

	public String getSoeidEjecSuc() {
		return soeidEjecSuc;
	}

	public void setSoeidEjecSuc(String soeidEjecSuc) {
		this.soeidEjecSuc = soeidEjecSuc;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Integer getNumInver() {
		return numInver;
	}

	public void setNumInver(Integer numInver) {
		this.numInver = numInver;
	}

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public String getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(String fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public String getCampana() {
		return campana;
	}

	public void setCampana(String campana) {
		this.campana = campana;
	}

	public String getGatNominalOferta() {
		return gatNominalOferta;
	}

	public void setGatNominalOferta(String gatNominalOferta) {
		this.gatNominalOferta = gatNominalOferta;
	}

	public String getGatRealOferta() {
		return gatRealOferta;
	}

	public void setGatRealOferta(String gatRealOferta) {
		this.gatRealOferta = gatRealOferta;
	}

	public Double getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(Double rendimiento) {
		this.rendimiento = rendimiento;
	}

	public String getOfertaParticipacionUnica() {
		return ofertaParticipacionUnica;
	}

	public void setOfertaParticipacionUnica(String ofertaParticipacionUnica) {
		this.ofertaParticipacionUnica = ofertaParticipacionUnica;
	}

	public Integer getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(Integer tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Long getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	public Date getFechaProcess() {
		return fechaProcess;
	}

	public void setFechaProcess(Date fechaProcess) {
		this.fechaProcess = fechaProcess;
	}

	public Integer getNumAutoriUEC() {
		return numAutoriUEC;
	}

	public void setNumAutoriUEC(Integer numAutoriUEC) {
		this.numAutoriUEC = numAutoriUEC;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public Integer getSucSolic() {
		return sucSolic;
	}

	public void setSucSolic(Integer sucSolic) {
		this.sucSolic = sucSolic;
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

	public Long getNumCte() {
		return numCte;
	}

	public void setNumCte(Long numCte) {
		this.numCte = numCte;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getNomCte() {
		return nomCte;
	}

	public void setNomCte(String nomCte) {
		this.nomCte = nomCte;
	}

	public String getTipoAutori() {
		return tipoAutori;
	}

	public void setTipoAutori(String tipoAutori) {
		this.tipoAutori = tipoAutori;
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

	public Long getTasaAutori() {
		return tasaAutori;
	}

	public void setTasaAutori(Long tasaAutori) {
		this.tasaAutori = tasaAutori;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getEstatus2() {
		return estatus2;
	}

	public void setEstatus2(Integer estatus2) {
		this.estatus2 = estatus2;
	}

	public Date getFechaEstatus() {
		return fechaEstatus;
	}

	public void setFechaEstatus(Date fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}

	public Date getFechaSolic() {
		return fechaSolic;
	}

	public void setFechaSolic(Date fechaSolic) {
		this.fechaSolic = fechaSolic;
	}

	public String getObservaWeb() {
		return observaWeb;
	}

	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}

	public String getSoeidOpe() {
		return soeidOpe;
	}

	public void setSoeidOpe(String soeidOpe) {
		this.soeidOpe = soeidOpe;
	}

	public Integer getNumAutoriUEC2() {
		return numAutoriUEC2;
	}

	public void setNumAutoriUEC2(Integer numAutoriUEC2) {
		this.numAutoriUEC2 = numAutoriUEC2;
	}

	public String getSoeidAsig() {
		return soeidAsig;
	}

	public void setSoeidAsig(String soeidAsig) {
		this.soeidAsig = soeidAsig;
	}

	public String getSoeidAutori() {
		return soeidAutori;
	}

	public void setSoeidAutori(String soeidAutori) {
		this.soeidAutori = soeidAutori;
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
	
	
}
