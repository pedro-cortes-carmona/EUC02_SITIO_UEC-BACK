package com.citi.euces.sitiouec.dto;

import java.util.Date;

public class TasasReprocesoDTO {
	
	private Long idTasa;

	private Long numAutoriUec;

	private Date fechaOpe;

	private String fechaOpeS;

	private Long sucSolic;

	private Long monto;

	private Long plazo;

	private Long tasaAutori;

	private String estatus;

	private Long num_cte;

	private String nomCliente;

	private String nomEjecutivo;

	private Long contrato;

	private String operadoPor;

	private String campanaWeb;

	private String observaWeb;

	private String soeidResp;
	
	public TasasReprocesoDTO() {
		// TODO Auto-generated constructor stub
	}

	public TasasReprocesoDTO(Long idTasa, Long numAutoriUec, Date fechaOpe, Long sucSolic, Long monto, Long plazo,
			Long tasaAutori, String estatus, Long num_cte, String nomCliente, String nomEjecutivo, Long contrato,
			String operadoPor, String campanaWeb, String observaWeb, String soeidResp) {
		super();
		this.idTasa = idTasa;
		this.numAutoriUec = numAutoriUec;
		this.fechaOpe = fechaOpe;
		this.sucSolic = sucSolic;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.estatus = estatus;
		this.num_cte = num_cte;
		this.nomCliente = nomCliente;
		this.nomEjecutivo = nomEjecutivo;
		this.contrato = contrato;
		this.operadoPor = operadoPor;
		this.campanaWeb = campanaWeb;
		this.observaWeb = observaWeb;
		this.soeidResp = soeidResp;
	}

	public Long getIdTasa() {
		return idTasa;
	}

	public void setIdTasa(Long idTasa) {
		this.idTasa = idTasa;
	}

	public Long getNumAutoriUec() {
		return numAutoriUec;
	}

	public void setNumAutoriUec(Long numAutoriUec) {
		this.numAutoriUec = numAutoriUec;
	}

	public Date getFechaOpe() {
		return fechaOpe;
	}

	public void setFechaOpe(Date fechaOpe) {
		this.fechaOpe = fechaOpe;
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

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Long getNum_cte() {
		return num_cte;
	}

	public void setNum_cte(Long num_cte) {
		this.num_cte = num_cte;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public String getNomEjecutivo() {
		return nomEjecutivo;
	}

	public void setNomEjecutivo(String nomEjecutivo) {
		this.nomEjecutivo = nomEjecutivo;
	}

	public Long getContrato() {
		return contrato;
	}

	public void setContrato(Long contrato) {
		this.contrato = contrato;
	}

	public String getOperadoPor() {
		return operadoPor;
	}

	public void setOperadoPor(String operadoPor) {
		this.operadoPor = operadoPor;
	}

	public String getCampanaWeb() {
		return campanaWeb;
	}

	public void setCampanaWeb(String campanaWeb) {
		this.campanaWeb = campanaWeb;
	}

	public String getObservaWeb() {
		return observaWeb;
	}

	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}

	public String getSoeidResp() {
		return soeidResp;
	}

	public void setSoeidResp(String soeidResp) {
		this.soeidResp = soeidResp;
	}

	public String getFechaOpeS() {
		return fechaOpeS;
	}

	public void setFechaOpeS(String fechaOpeS) {
		this.fechaOpeS = fechaOpeS;
	}

	@Override
	public String toString() {
		return "TasasReprocesoDTO [idTasa=" + idTasa + ", numAutoriUec=" + numAutoriUec + ", fechaOpe=" + fechaOpe
				+ ", fechaOpeS=" + fechaOpeS + ", sucSolic=" + sucSolic + ", monto=" + monto + ", plazo=" + plazo
				+ ", tasaAutori=" + tasaAutori + ", estatus=" + estatus + ", num_cte=" + num_cte + ", nomCliente="
				+ nomCliente + ", nomEjecutivo=" + nomEjecutivo + ", contrato=" + contrato + ", operadoPor="
				+ operadoPor + ", campanaWeb=" + campanaWeb + ", observaWeb=" + observaWeb + ", soeidResp=" + soeidResp
				+ "]";
	}

}
