package com.citi.euces.sitiouec.dto;

import java.sql.Timestamp;
import java.util.Date;

public class AutoTasasDTO {
	
	private Long idTasaAuto;
	
	private java.sql.Timestamp fechaSoli;
	
	private java.sql.Timestamp fechaAutori;
	
	private java.sql.Timestamp fechaProcess;
	
	private java.sql.Timestamp fechaEstatus;
	
	private java.sql.Timestamp fechaCaptura;
	

	private String fechaAuto;
	
	private String fechaLiberacion;
	
	private String fechaEstatusS;
	
	private String fechaCapturaS;
	
	private String fechaSoliS;
	
	
	private Long isProcess;
	
	private String estatus;
	
	private Long sucSolic;
	
	private String division;
	
	private Long numCliente;
	
	private String nomCliente;	
	
	private String contrato;
	
	private String nomina;
	
	private String nomEjecutivo;
	
	private Double monto;
	
	private Long plazo;
	
	private Double tasaAutori; //Cambiar a double 
	
	private String tipoAutori;
	
	private String soeid_Autori;
	
	private String inicAutori;
	
	private Long numAutoriUEC;
	
	private String soeidAsig;
	
	private String soeidProc;
	
	private String soeidOpe;
	
	private Long cete;
	
	private Long porcenCete;
	
	private String observaWeb;
	
	private String justificacion;
	
	private String cel;
	
	private Long tPer;
	
	private Date fechaSolicCancel;
	
	private String nominaCancel;
	
	private String nomEjeCancel;
	
	private String justificacionCancel;
	
	private String reinversion;
	
	private Long isCuentaMaestra;
	
	private String isPortabilidad;
	
	private String email;
	
	private String autorizadores;
	
	private String certificadoFisico;
	
	private String certificadoMoral;
	
	private String suc;
	
	private String idCampana;
	
	private Long montoVentas;
	
	private Long ventas;
	
	private String distrito;
	
	private Float capita;
	
	private Float ejecutivos;
	
	private String ofertaId;
	
	private String distritoNombre;
	
	private Float ejecutivoTotal;
	
	private String estatusCliente;
	
	private String sinRegistros;
	
	private String convertirToString;
	
	private String asginadoA;
	
	private String operadorPor;
	
	private Long estatusTasas; 
	
	
	
	private String campanaWeb;
	
	private String soeidRep;
	
	private Long numAutoriUec;
	
	private Integer operaciones;
	
	private String ofertaCampanaID;
	
	
	
	

	public AutoTasasDTO() {
		// TODO Auto-generated constructor stub
	}

	public AutoTasasDTO(Integer operaciones) {
		super();
		this.operaciones = operaciones;
	}


	public AutoTasasDTO(Long idTasaAuto, Timestamp fechaSoli,Timestamp fechaEstatus, 
			Long sucSolic, Double monto, Long plazo, Double tasaAutori,
			String estatus, Long numCliente, String nomCliente, String contrato, String soeidOpe, String nomEjecutivo,
			String observaWeb) {
		super();
		this.numAutoriUec=numAutoriUec;
		this.idTasaAuto = idTasaAuto;
		this.fechaSoli = fechaSoli;
		this.fechaEstatus= fechaEstatus;
		this.sucSolic = sucSolic;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.estatus = estatus;
		this.numCliente = numCliente;
		this.nomCliente = nomCliente;
		this.contrato = contrato;
		this.soeidOpe = soeidOpe;
		this.nomEjecutivo = nomEjecutivo;
		this.observaWeb = observaWeb;
	}
	
	public AutoTasasDTO(Long numAutoriUec,Long idTasaAuto, Timestamp fechaSoli,Timestamp fechaEstatus, 
			Long sucSolic, Double monto, Long plazo, Double tasaAutori,
			String estatus, Long numCliente, String nomCliente, String contrato, String soeidOpe, String nomEjecutivo,
			String observaWeb,Long numAutoriUecm,String tipoAutori ) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaSoli = fechaSoli;
		this.fechaEstatus= fechaEstatus;
		this.sucSolic = sucSolic;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.estatus = estatus;
		this.numCliente = numCliente;
		this.nomCliente = nomCliente;
		this.contrato = contrato;
		this.soeidOpe = soeidOpe;
		this.nomEjecutivo = nomEjecutivo;
		this.observaWeb = observaWeb;
		this.numAutoriUec= numAutoriUec;
		this.tipoAutori=tipoAutori;
	}
	
	public AutoTasasDTO(Long idTasaAuto, Timestamp fechaSoli,Timestamp fechaEstatus, 
			Long sucSolic, Double monto, Long plazo, Double tasaAutori,
			String estatus, Long numCliente, String nomCliente, String contrato, String soeidOpe, String nomEjecutivo,
			String observaWeb,String soeidAsig) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaSoli = fechaSoli;
		this.fechaEstatus= fechaEstatus;
		this.sucSolic = sucSolic;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.estatus = estatus;
		this.numCliente = numCliente;
		this.nomCliente = nomCliente;
		this.contrato = contrato;
		this.soeidOpe = soeidOpe;
		this.nomEjecutivo = nomEjecutivo;
		this.observaWeb = observaWeb;
		this.soeidAsig=soeidAsig;
	}
	
	
	
	
	
	public AutoTasasDTO(Long idTasaAuto, Timestamp fechaEstatus, Long numCliente, String contrato, String observaWeb,
			String asginadoA, String operadorPor, Long estatusTasas, Timestamp fechaCaptura, Timestamp fechaAutori,
			String campanaWeb, String soeidRep) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaEstatus = fechaEstatus;
		this.numCliente = numCliente;
		this.contrato = contrato;
		this.observaWeb = observaWeb;
		this.asginadoA = asginadoA;
		this.operadorPor = operadorPor;
		this.estatusTasas = estatusTasas;
		this.fechaCaptura = fechaCaptura;
		this.fechaAutori = fechaAutori;
		this.campanaWeb = campanaWeb;
		this.soeidRep = soeidRep;
	}
	
	public AutoTasasDTO(Long idTasaAuto, Timestamp fechaSoli, Timestamp fechaAutori, Timestamp fechaProcess,
			Timestamp fechaEstatus, Long isProcess, String estatus, Long sucSolic, String division, Long numCliente,
			String nomCliente, String contrato, String nomina, String nomEjecutivo, Double monto, Long plazo,
			Double tasaAutori, String tipoAutori, String soeid_Autori, String inicAutori, Long numAutoriUEC,
			String soeidAsig, String soeidProc, String soeidOpe, Long cete, Long porcenCete, String observaWeb,
			String justificacion, String cel, Long tPer, Date fechaSolicCancel, String nominaCancel,
			String nomEjeCancel, String justificacionCancel, String reinversion, Long isCuentaMaestra,
			String isPortabilidad, String email, String autorizadores, String certificadoFisico,
			String certificadoMoral, String suc, String idCampana, Long montoVentas, Long ventas, String distrito,
			Float capita, Float ejecutivos, String ofertaId, String distritoNombre, Float ejecutivoTotal,
			String estatusCliente) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaSoli = fechaSoli;
		this.fechaAutori = fechaAutori;
		this.fechaProcess = fechaProcess;
		this.fechaEstatus = fechaEstatus;
		this.isProcess = isProcess;
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
		this.soeid_Autori = soeid_Autori;
		this.inicAutori = inicAutori;
		this.numAutoriUEC = numAutoriUEC;
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
		this.reinversion = reinversion;
		this.isCuentaMaestra = isCuentaMaestra;
		this.isPortabilidad = isPortabilidad;
		this.email = email;
		this.autorizadores = autorizadores;
		this.certificadoFisico = certificadoFisico;
		this.certificadoMoral = certificadoMoral;
		this.suc = suc;
		this.idCampana = idCampana;
		this.montoVentas = montoVentas;
		this.ventas = ventas;
		this.distrito = distrito;
		this.capita = capita;
		this.ejecutivos = ejecutivos;
		this.ofertaId = ofertaId;
		this.distritoNombre = distritoNombre;
		this.ejecutivoTotal = ejecutivoTotal;
		this.estatusCliente = estatusCliente;
	}

	/**
	 * Constructor para el método  - obtenerRegistrosAutoTasas
	 * @param idTasaAuto
	 * @param fechaSoli
	 * @param fechaAutori
	 * @param fechaEstatus
	 * @param estatus
	 * @param sucSolic
	 * @param numCliente
	 * @param nomCliente
	 * @param contrato
	 * @param nomina
	 * @param nomEjecutivo
	 * @param monto
	 * @param plazo
	 * @param tasaAutori
	 * @param tipoAutori
	 * @param soeid_Autori
	 * @param inicAutori
	 * @param numAutoriUEC
	 * @param soeidAsig
	 * @param soeidOpe
	 * @param cete
	 * @param porcenCete
	 * @param observaWeb
	 * @param justificacion
	 * @param cel
	 * @param autorizadores
	 * @param suc
	 */
	

	
	public AutoTasasDTO(Long idTasaAuto, Timestamp fechaSoli, Timestamp fechaAutori, Timestamp fechaEstatus,
			String estatus, Long sucSolic, Long numCliente, String nomCliente, String contrato, String nomina,
			String nomEjecutivo, Double monto, Long plazo, Double tasaAutori, String tipoAutori, String soeid_Autori,
			String inicAutori, Long numAutoriUEC, String soeidAsig, String soeidOpe, Long cete, Long porcenCete,
			String observaWeb, String justificacion, String cel, String autorizadores, String suc,String distrito,
			String ofertaId,String idCampana,String nominaCancel,String nomEjeCancel,String justificacionCancel,String estatusCliente,String ofertaCampanaID) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaSoli = fechaSoli;
		this.fechaAutori = fechaAutori;
		this.fechaEstatus = fechaEstatus;
		this.estatus = estatus;
		this.sucSolic = sucSolic;
		this.numCliente = numCliente;
		this.nomCliente = nomCliente;
		this.contrato = contrato;
		this.nomina = nomina;
		this.nomEjecutivo = nomEjecutivo;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.tipoAutori = tipoAutori;
		this.soeid_Autori = soeid_Autori;
		this.inicAutori = inicAutori;
		this.numAutoriUEC = numAutoriUEC;
		this.soeidAsig = soeidAsig;
		this.soeidOpe = soeidOpe;
		this.cete = cete;
		this.porcenCete = porcenCete;
		this.observaWeb = observaWeb;
		this.justificacion = justificacion;
		this.cel = cel;
		this.autorizadores = autorizadores;
		this.suc = suc;
		this.distrito=distrito;		
		this.ofertaId=ofertaId;
		this.idCampana=idCampana;
		this.nominaCancel=nominaCancel;
		this.nomEjeCancel= nomEjeCancel;
		this.justificacionCancel=justificacionCancel;
		this.estatusCliente= estatusCliente;
		this.ofertaCampanaID=ofertaCampanaID;
		
	}
	
	


	public AutoTasasDTO( Long numAutoriUec, Long idTasaAuto, Timestamp fechaSoli, Timestamp fechaEstatus, Long sucSolic,
			Double monto, Long plazo, Double tasaAutori, String estatus, 
			Long numCliente, String nomCliente, String contrato, String soeidOpe, String nomEjecutivo, 
			 String observaWeb) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaSoli = fechaSoli;
		this.fechaEstatus = fechaEstatus;
		this.estatus = estatus;
		this.sucSolic = sucSolic;
		this.numCliente = numCliente;
		this.nomCliente = nomCliente;
		this.contrato = contrato;
		this.nomEjecutivo = nomEjecutivo;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.soeidOpe = soeidOpe;
		this.observaWeb = observaWeb;
		this.numAutoriUec = numAutoriUec;
	}

	

	public AutoTasasDTO(Long idTasaAuto, Timestamp fechaSoli, Timestamp fechaEstatus, Long sucSolic,
			Double monto, Long plazo, Double tasaAutori, String estatus, 
			Long numCliente, String nomCliente, String contrato, String soeidOpe, String nomEjecutivo, 
			 String observaWeb, Long numAutoriUec,String tipoAutori) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.fechaSoli = fechaSoli;
		this.fechaEstatus = fechaEstatus;
		this.estatus = estatus;
		this.sucSolic = sucSolic;
		this.numCliente = numCliente;
		this.nomCliente = nomCliente;
		this.contrato = contrato;
		this.nomEjecutivo = nomEjecutivo;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.soeidOpe = soeidOpe;
		this.observaWeb = observaWeb;
		this.numAutoriUec = numAutoriUec;
		this.tipoAutori=tipoAutori;
		
	}

	public AutoTasasDTO(Long numCliente) {
		super();
		this.numCliente = numCliente;
	}

	/**
	 * 
	 * @return
	 * 
	 * Constructor para traer los usuarios SOIED
	 */
	public AutoTasasDTO(String soeidOpe) {
		super();
		this.soeidOpe = soeidOpe;
	}
	
	public String getOfertaCampanaID() {
		return ofertaCampanaID;
	}
	
	public void setOfertaCampanaID(String ofertaCampanaID) {
		this.ofertaCampanaID = ofertaCampanaID;
	}
	
	public String getSoeidAsig() {
		return soeidAsig;
	}
	
	public void setSoeidAsig(String soeidAsig) {
		this.soeidAsig = soeidAsig;
	}
	
	public Integer getOperaciones() {
		return operaciones;
	}
	
	public void setOperaciones(Integer operaciones) {
		this.operaciones = operaciones;
	}
	
	public String getTipoAutori() {
		return tipoAutori;
	}
	
	public void setTipoAutori(String tipoAutori) {
		this.tipoAutori = tipoAutori;
	}
	
	public Long getNumAutoriUec() {
		return numAutoriUec;
	}
	
	public void setNumAutoriUec(Long numAutoriUec) {
		this.numAutoriUec = numAutoriUec;
	}

	public String getAsginadoA() {
		return asginadoA;
	}


	public void setAsginadoA(String asginadoA) {
		this.asginadoA = asginadoA;
	}


	public String getOperadorPor() {
		return operadorPor;
	}


	public void setOperadorPor(String operadorPor) {
		this.operadorPor = operadorPor;
	}


	public Long getEstatusTasas() {
		return estatusTasas;
	}


	public void setEstatusTasas(Long estatusTasas) {
		this.estatusTasas = estatusTasas;
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


	public String getCampanaWeb() {
		return campanaWeb;
	}


	public void setCampanaWeb(String campanaWeb) {
		this.campanaWeb = campanaWeb;
	}


	public String getSoeidRep() {
		return soeidRep;
	}


	public void setSoeidRep(String soeidRep) {
		this.soeidRep = soeidRep;
	}



	public String getConvertirToString() {
		return convertirToString;
	}
	
	public void setConvertirToString(String convertirToString) {
		this.convertirToString = convertirToString;
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


	public Long getSucSolic() {
		return sucSolic;
	}


	public void setSucSolic(Long sucSolic) {
		this.sucSolic = sucSolic;
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


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
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

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	
    public String getContrato() {
		return contrato;
	}	

	public String getSoeidOpe() {
		return soeidOpe;
	}


	public void setSoeidOpe(String soeidOpe) {
		this.soeidOpe = soeidOpe;
	}


	public String getNomEjecutivo() {
		return nomEjecutivo;
	}


	public void setNomEjecutivo(String nomEjecutivo) {
		this.nomEjecutivo = nomEjecutivo;
	}


	public String getObservaWeb() {
		return observaWeb;
	}


	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}


	public String getSinRegistros() {
		return sinRegistros;
	}


	public void setSinRegistros(String sinRegistros) {
		this.sinRegistros = sinRegistros;
	}
	
	public java.sql.Timestamp getFechaEstatus() {
		return fechaEstatus;
	}
	
	public void setFechaEstatus(java.sql.Timestamp fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}
	
	public String getDistritoNombre() {
		return distritoNombre;
	}
	
	public void setDistritoNombre(String distritoNombre) {
		this.distritoNombre = distritoNombre;
	}
	
	public String getDistrito() {
		return distrito;
	}
	
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getAutorizadores() {
		return autorizadores;
	}
	
	public void setAutorizadores(String autorizadores) {
		this.autorizadores = autorizadores;
	}
	
	public String getIdCampana() {
		return idCampana;
	}
	
	public void setIdCampana(String idCampana) {
		this.idCampana = idCampana;
	}
	
	public String getJustificacion() {
		return justificacion;
	}
	public String getJustificacionCancel() {
		return justificacionCancel;
	}
	
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	
	public void setJustificacionCancel(String justificacionCancel) {
		this.justificacionCancel = justificacionCancel;
	}
	
	public void setNominaCancel(String nominaCancel) {
		this.nominaCancel = nominaCancel;
	}
	
	public String getNominaCancel() {
		return nominaCancel;
	}	
	
	public String getNomEjeCancel() {
		return nomEjeCancel;
	}
	
	public void setNomEjeCancel(String nomEjeCancel) {
		this.nomEjeCancel = nomEjeCancel;
	}
	
	public String getSuc() {
		return suc;
	}
	
	public void setSuc(String suc) {
		this.suc = suc;
	}

	public java.sql.Timestamp getFechaProcess() {
		return fechaProcess;
	}

	public void setFechaProcess(java.sql.Timestamp fechaProcess) {
		this.fechaProcess = fechaProcess;
	}

	public String getFechaAuto() {
		return fechaAuto;
	}

	public void setFechaAuto(String fechaAuto) {
		this.fechaAuto = fechaAuto;
	}

	public String getFechaLiberacion() {
		return fechaLiberacion;
	}

	public void setFechaLiberacion(String fechaLiberacion) {
		this.fechaLiberacion = fechaLiberacion;
	}

	public String getFechaEstatusS() {
		return fechaEstatusS;
	}

	public void setFechaEstatusS(String fechaEstatusS) {
		this.fechaEstatusS = fechaEstatusS;
	}

	public String getFechaCapturaS() {
		return fechaCapturaS;
	}

	public void setFechaCapturaS(String fechaCapturaS) {
		this.fechaCapturaS = fechaCapturaS;
	}

	public Long getIsProcess() {
		return isProcess;
	}

	public void setIsProcess(Long isProcess) {
		this.isProcess = isProcess;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getNomina() {
		return nomina;
	}

	public void setNomina(String nomina) {
		this.nomina = nomina;
	}

	public String getSoeid_Autori() {
		return soeid_Autori;
	}

	public void setSoeid_Autori(String soeid_Autori) {
		this.soeid_Autori = soeid_Autori;
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

	public String getSoeidProc() {
		return soeidProc;
	}

	public void setSoeidProc(String soeidProc) {
		this.soeidProc = soeidProc;
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

	public String getReinversion() {
		return reinversion;
	}

	public void setReinversion(String reinversion) {
		this.reinversion = reinversion;
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

	public Float getCapita() {
		return capita;
	}

	public void setCapita(Float capita) {
		this.capita = capita;
	}

	public Float getEjecutivos() {
		return ejecutivos;
	}

	public void setEjecutivos(Float ejecutivos) {
		this.ejecutivos = ejecutivos;
	}

	public String getOfertaId() {
		return ofertaId;
	}

	public void setOfertaId(String ofertaId) {
		this.ofertaId = ofertaId;
	}

	public Float getEjecutivoTotal() {
		return ejecutivoTotal;
	}

	public void setEjecutivoTotal(Float ejecutivoTotal) {
		this.ejecutivoTotal = ejecutivoTotal;
	}

	public String getEstatusCliente() {
		return estatusCliente;
	}

	public void setEstatusCliente(String estatusCliente) {
		this.estatusCliente = estatusCliente;
	}
	
	public String getFechaSoliS() {
		return fechaSoliS;
	}
	
	public void setFechaSoliS(String fechaSoliS) {
		this.fechaSoliS = fechaSoliS;
	}

	@Override
	public String toString() {
		return "AutoTasasDTO [idTasaAuto=" + idTasaAuto + ", fechaSoli=" + fechaSoli + ", fechaAutori=" + fechaAutori
				+ ", fechaProcess=" + fechaProcess + ", fechaEstatus=" + fechaEstatus + ", fechaCaptura=" + fechaCaptura
				+ ", fechaAuto=" + fechaAuto + ", fechaLiberacion=" + fechaLiberacion + ", fechaEstatusS="
				+ fechaEstatusS + ", fechaCapturaS=" + fechaCapturaS + ", isProcess=" + isProcess + ", estatus="
				+ estatus + ", sucSolic=" + sucSolic + ", division=" + division + ", numCliente=" + numCliente
				+ ", nomCliente=" + nomCliente + ", contrato=" + contrato + ", nomina=" + nomina + ", nomEjecutivo="
				+ nomEjecutivo + ", monto=" + monto + ", plazo=" + plazo + ", tasaAutori=" + tasaAutori
				+ ", tipoAutori=" + tipoAutori + ", soeid_Autori=" + soeid_Autori + ", inicAutori=" + inicAutori
				+ ", numAutoriUEC=" + numAutoriUEC + ", soeidAsig=" + soeidAsig + ", soeidProc=" + soeidProc
				+ ", soeidOpe=" + soeidOpe + ", cete=" + cete + ", porcenCete=" + porcenCete + ", observaWeb="
				+ observaWeb + ", justificacion=" + justificacion + ", cel=" + cel + ", tPer=" + tPer
				+ ", fechaSolicCancel=" + fechaSolicCancel + ", nominaCancel=" + nominaCancel + ", nomEjeCancel="
				+ nomEjeCancel + ", justificacionCancel=" + justificacionCancel + ", reinversion=" + reinversion
				+ ", isCuentaMaestra=" + isCuentaMaestra + ", isPortabilidad=" + isPortabilidad + ", email=" + email
				+ ", autorizadores=" + autorizadores + ", certificadoFisico=" + certificadoFisico
				+ ", certificadoMoral=" + certificadoMoral + ", suc=" + suc + ", idCampana=" + idCampana
				+ ", montoVentas=" + montoVentas + ", ventas=" + ventas + ", distrito=" + distrito + ", capita="
				+ capita + ", ejecutivos=" + ejecutivos + ", ofertaId=" + ofertaId + ", distritoNombre="
				+ distritoNombre + ", ejecutivoTotal=" + ejecutivoTotal + ", estatusCliente=" + estatusCliente
				+ ", sinRegistros=" + sinRegistros + ", convertirToString=" + convertirToString + ", asginadoA="
				+ asginadoA + ", operadorPor=" + operadorPor + ", estatusTasas=" + estatusTasas + ", campanaWeb="
				+ campanaWeb + ", soeidRep=" + soeidRep + ", numAutoriUec=" + numAutoriUec + ", operaciones="
				+ operaciones + "]";
	}

}
