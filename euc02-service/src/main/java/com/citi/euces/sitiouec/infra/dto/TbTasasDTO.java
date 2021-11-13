package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.Date;

public class TbTasasDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idTasa; 
	private Date fechaOpe;
	private Integer estatus;
	private Long numcte;
	private Long contrato;
	private Integer sucSolic;
	private String division;
	private Integer numAutoriUEC;
	private Integer tipoPersona;
	private Integer tPer;
	private Double monto;
	private Double tasaAutori;
	private Date horaAutori;
	private Double producto;
	private Integer operadorUEC;
	private Integer numInversion;
	private Integer plazo;
	private String nomCte;
	private Integer instr;
	private Integer cveMonto;
	private Integer cvePlazo;
	private String soeidRep;
	private Integer isTasaBase;
	private String campanaWeb;
	private String asignadoA;
	private String operadoPor;
	private String nomina;
	private String autorizador;
	private Integer cete;
	private Integer porcenCete;
	private Date fechacap;
	private Date fechaEstatus;
	private Integer isWeb;
	private String observaWeb;
	private String nomEjec;
	private Integer isActualizar;
	
	public TbTasasDTO() {}
	
	public TbTasasDTO(Integer idTasa, Date fechaOpe, Integer estatus, Long numcte, Long contrato, Integer sucSolic,
			Integer numAutoriUEC, Double monto, Double tasaAutori, Integer plazo, String nomCte) {
		super();
		this.idTasa = idTasa;
		this.fechaOpe = fechaOpe;
		this.estatus = estatus;
		this.numcte = numcte;
		this.contrato = contrato;
		this.sucSolic = sucSolic;
		this.numAutoriUEC = numAutoriUEC;
		this.monto = monto;
		this.tasaAutori = tasaAutori;
		this.plazo = plazo;
		this.nomCte = nomCte;
	}



	public TbTasasDTO(Integer idTasa, Date fechaOpe, Integer estatus, Long numcte, Long contrato, Integer sucSolic,
			String division, Integer numAutoriUEC, Integer tipoPersona, Integer tPer, Double monto, Double tasaAutori,
			Date horaAutori, Double producto, Integer operadorUEC, Integer numInversion, Integer plazo, String nomCte,
			Integer instr, Integer cveMonto, Integer cvePlazo, String soeidRep) {
		super();
		this.idTasa = idTasa;
		this.fechaOpe = fechaOpe;
		this.estatus = estatus;
		this.numcte = numcte;
		this.contrato = contrato;
		this.sucSolic = sucSolic;
		this.division = division;
		this.numAutoriUEC = numAutoriUEC;
		this.tipoPersona = tipoPersona;
		this.tPer = tPer;
		this.monto = monto;
		this.tasaAutori = tasaAutori;
		this.horaAutori = horaAutori;
		this.producto = producto;
		this.operadorUEC = operadorUEC;
		this.numInversion = numInversion;
		this.plazo = plazo;
		this.nomCte = nomCte;
		this.instr = instr;
		this.cveMonto = cveMonto;
		this.cvePlazo = cvePlazo;
		this.soeidRep = soeidRep;
	}

	public TbTasasDTO(Integer idTasa, Date fechaOpe, Integer estatus, Long numcte, Long contrato, Integer isTasaBase, 
			Integer numInversion, Integer plazo, Double monto, Double tasaAutori, Integer numAutoriUEC,
			Integer operadorUEC, Integer sucSolic, String nomCte, Integer tipoPersona,
			Integer instr, String campanaWeb, String asignadoA, String operadoPor, String nomina, String autorizador, Integer isWeb,
			String observaWeb, String nomEjec, Date fechacap, Date fechaEstatus, String division) {
		super();
		this.idTasa = idTasa; 
		this.fechaOpe = fechaOpe;
		this.estatus = estatus;
		this.numcte = numcte;
		this.contrato = contrato;
		this.sucSolic = sucSolic;
		this.numAutoriUEC = numAutoriUEC;
		this.tipoPersona = tipoPersona;
		this.monto = monto;
		this.tasaAutori = tasaAutori;
		this.operadorUEC = operadorUEC;
		this.numInversion = numInversion;
		this.plazo = plazo;
		this.nomCte = nomCte;
		this.instr = instr;
		this.isTasaBase = isTasaBase;
		this.campanaWeb = campanaWeb;
		this.asignadoA = asignadoA;
		this.operadoPor = operadoPor;
		this.nomina = nomina;
		this.autorizador = autorizador;
		this.isWeb = isWeb;
		this.observaWeb = observaWeb;
		this.nomEjec = nomEjec;
		this.fechacap = fechacap;
		this.fechaEstatus = fechaEstatus;
		this.division = division;
	}

	public TbTasasDTO(Integer idTasa, Date fechaOpe, Integer estatus, Long numcte, Long contrato, Integer isTasaBase, 
			Integer numInversion, Integer plazo, Double monto, Double tasaAutori, Integer numAutoriUEC,
			Integer operadorUEC, Integer sucSolic, String nomCte, Integer tipoPersona,
			Integer instr, String campanaWeb, String asignadoA, String operadoPor, String nomina, String autorizador) {
		super();
		this.idTasa = idTasa;
		this.fechaOpe = fechaOpe;
		this.estatus = estatus;
		this.numcte = numcte;
		this.contrato = contrato;
		this.sucSolic = sucSolic;
		this.numAutoriUEC = numAutoriUEC;
		this.tipoPersona = tipoPersona;
		this.monto = monto;
		this.tasaAutori = tasaAutori;
		this.operadorUEC = operadorUEC;
		this.numInversion = numInversion;
		this.plazo = plazo;
		this.nomCte = nomCte;
		this.instr = instr;
		this.isTasaBase = isTasaBase;
		this.campanaWeb = campanaWeb;
		this.asignadoA = asignadoA;
		this.operadoPor = operadoPor;
		this.nomina = nomina;
		this.autorizador = autorizador;
	}
	
	public Integer getIsActualizar() {
		return isActualizar;
	}

	public void setIsActualizar(Integer isActualizar) {
		this.isActualizar = isActualizar;
	}

	public Integer getCete() {
		return cete;
	}

	public void setCete(Integer cete) {
		this.cete = cete;
	}

	public Integer getPorcenCete() {
		return porcenCete;
	}

	public void setPorcenCete(Integer porcenCete) {
		this.porcenCete = porcenCete;
	}

	public String getObservaWeb() {
		return observaWeb;
	}

	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}

	public String getNomEjec() {
		return nomEjec;
	}

	public void setNomEjec(String nomEjec) {
		this.nomEjec = nomEjec;
	}

	public Date getFechacap() {
		return fechacap;
	}

	public void setFechacap(Date fechacap) {
		this.fechacap = fechacap;
	}

	public Date getFechaEstatus() {
		return fechaEstatus;
	}

	public void setFechaEstatus(Date fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}

	public Integer getIsWeb() {
		return isWeb;
	}

	public void setIsWeb(Integer isWeb) {
		this.isWeb = isWeb;
	}

	public Integer getIsTasaBase() {
		return isTasaBase;
	}

	public void setIsTasaBase(Integer isTasaBase) {
		this.isTasaBase = isTasaBase;
	}

	public String getCampanaWeb() {
		return campanaWeb;
	}

	public void setCampanaWeb(String campanaWeb) {
		this.campanaWeb = campanaWeb;
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

	public String getNomina() {
		return nomina;
	}

	public void setNomina(String nomina) {
		this.nomina = nomina;
	}

	public String getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(String autorizador) {
		this.autorizador = autorizador;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Integer gettPer() {
		return tPer;
	}

	public void settPer(Integer tPer) {
		this.tPer = tPer;
	}

	public Integer getIdTasa() {
		return idTasa;
	}

	public void setIdTasa(Integer idTasa) {
		this.idTasa = idTasa;
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

	public Long getNumcte() {
		return numcte;
	}

	public void setNumcte(Long numcte) {
		this.numcte = numcte;
	}

	public Long getContrato() {
		return contrato;
	}

	public void setContrato(Long contrato) {
		this.contrato = contrato;
	}

	public Integer getSucSolic() {
		return sucSolic;
	}

	public void setSucSolic(Integer sucSolic) {
		this.sucSolic = sucSolic;
	}

	public Integer getNumAutoriUEC() {
		return numAutoriUEC;
	}

	public void setNumAutoriUEC(Integer numAutoriUEC) {
		this.numAutoriUEC = numAutoriUEC;
	}

	public Integer getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(Integer tipoPersona) {
		this.tipoPersona = tipoPersona;
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

	public Date getHoraAutori() {
		return horaAutori;
	}

	public void setHoraAutori(Date horaAutori) {
		this.horaAutori = horaAutori;
	}

	public Double getProducto() {
		return producto;
	}

	public void setProducto(Double producto) {
		this.producto = producto;
	}

	public Integer getOperadorUEC() {
		return operadorUEC;
	}

	public void setOperadorUEC(Integer operadorUEC) {
		this.operadorUEC = operadorUEC;
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

	public String getNomCte() {
		return nomCte;
	}

	public void setNomCte(String nomCte) {
		this.nomCte = nomCte;
	}

	public Integer getInstr() {
		return instr;
	}

	public void setInstr(Integer instr) {
		this.instr = instr;
	}

	public Integer getCveMonto() {
		return cveMonto;
	}

	public void setCveMonto(Integer cveMonto) {
		this.cveMonto = cveMonto;
	}

	public Integer getCvePlazo() {
		return cvePlazo;
	}

	public void setCvePlazo(Integer cvePlazo) {
		this.cvePlazo = cvePlazo;
	}

	public String getSoeidRep() {
		return soeidRep;
	}

	public void setSoeidRep(String soeidRep) {
		this.soeidRep = soeidRep;
	}
}
