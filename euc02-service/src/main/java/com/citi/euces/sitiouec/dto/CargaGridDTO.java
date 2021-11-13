package com.citi.euces.sitiouec.dto;



public class CargaGridDTO {
	
	private Long idTasaAuto;
	
	private String soeid;
	
	private String estatus;
	
	private String fechaSolicitud;
	
	private String ofertaId;
	
	private String idCampana;
	
	private String contrato;
	
	private Long numCliente;
	
	private String nomCliente;
	
	private String sucursal;
	
	private Long plazo;
	
	private Long monto;
	
	private Long tasaAutori;
	
	private String fechaAutori;
	
	private String inicAutori;
	
	private String fechaEstatus;
	
	private Long numAutoriEuc;
	
	private String observaWeb;
	
	private String sinRegistros;
	
	private String autorizadores;
		
	

	public CargaGridDTO() {
		
	}



	public CargaGridDTO(Long idTasaAuto, String soeid, String estatus, String fechaSolicitud, String ofertaId, String idCampana, String contrato,
			Long numCliente, String nomCliente, String sucursal, Long plazo, Long monto, Long tasaAutori,
			String fechaAutori, String inicAutori, String fechaEstatus, Long numAutoriEuc, String observaWeb, String autorizadores) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.soeid = soeid;
		this.estatus = estatus;
		this.fechaSolicitud = fechaSolicitud;
		this.ofertaId = ofertaId;
		this.idCampana = idCampana;
		this.contrato = contrato;
		this.numCliente = numCliente;
		this.nomCliente = nomCliente;
		this.sucursal = sucursal;
		this.plazo = plazo;
		this.monto = monto;
		this.tasaAutori = tasaAutori;
		this.fechaAutori = fechaAutori;
		this.inicAutori = inicAutori;
		this.fechaEstatus = fechaEstatus;
		this.numAutoriEuc = numAutoriEuc;
		this.observaWeb = observaWeb;
		this.autorizadores=autorizadores;
	}

	public String getAutorizadores() {
		return autorizadores;
	}
	
	public void setAutorizadores(String autorizadores) {
		this.autorizadores = autorizadores;
	}


	public String getEstatus() {
		return estatus;
	}



	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	public String getFechaSolicitud() {
		return fechaSolicitud;
	}



	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}



	public String getOfertaId() {
		return ofertaId;
	}



	public void setOfertaId(String ofertaId) {
		this.ofertaId = ofertaId;
	}



	public String getIdCampana() {
		return idCampana;
	}



	public void setIdCampana(String idCampana) {
		this.idCampana = idCampana;
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



	public String getSucursal() {
		return sucursal;
	}



	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}



	public Long getPlazo() {
		return plazo;
	}



	public void setPlazo(Long plazo) {
		this.plazo = plazo;
	}



	public Long getMonto() {
		return monto;
	}



	public void setMonto(Long monto) {
		this.monto = monto;
	}



	public Long getTasaAutori() {
		return tasaAutori;
	}



	public void setTasaAutori(Long tasaAutori) {
		this.tasaAutori = tasaAutori;
	}


	public String getFechaAutori() {
		return fechaAutori;
	}



	public void setFechaAutori(String fechaAutori) {
		this.fechaAutori = fechaAutori;
	}



	public String getInicAutori() {
		return inicAutori;
	}



	public void setInicAutori(String inicAutori) {
		this.inicAutori = inicAutori;
	}


	public String getFechaEstatus() {
		return fechaEstatus;
	}



	public void setFechaEstatus(String fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}



	public Long getNumAutoriEuc() {
		return numAutoriEuc;
	}



	public void setNumAutoriEuc(Long numAutoriEuc) {
		this.numAutoriEuc = numAutoriEuc;
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



	public String getSoeid() {
		return soeid;
	}



	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}



	public Long getIdTasaAuto() {
		return idTasaAuto;
	}



	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}



	@Override
	public String toString() {
		return "CargaGridDTO [idTasaAuto=" + idTasaAuto + ", soeid=" + soeid + ", estatus=" + estatus
				+ ", fechaSolicitud=" + fechaSolicitud + ", ofertaId=" + ofertaId + ", idCampana=" + idCampana
				+ ", contrato=" + contrato + ", numCliente=" + numCliente + ", nomCliente=" + nomCliente + ", sucursal="
				+ sucursal + ", plazo=" + plazo + ", monto=" + monto + ", tasaAutori=" + tasaAutori + ", fechaAutori="
				+ fechaAutori + ", inicAutori=" + inicAutori + ", fechaEstatus=" + fechaEstatus + ", numAutoriEuc="
				+ numAutoriEuc + ", observaWeb=" + observaWeb + ", sinRegistros=" + sinRegistros + ", autorizadores="
				+ autorizadores + "]";
	}

	
	
					
}
