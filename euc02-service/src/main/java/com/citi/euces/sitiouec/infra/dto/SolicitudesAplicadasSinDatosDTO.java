package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.Date;

public class SolicitudesAplicadasSinDatosDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTasa; 
	private Integer estatus;
	private String fechaOpe;
	private Integer numcte;
	private Integer contrato;
	private Integer sucSolic;
	private Integer numAutoriUEC;
	private Integer monto;
	private Integer tasaAutori;
	private Integer plazo;
	private String nomCte;
	
	public SolicitudesAplicadasSinDatosDTO() {}
	
	public SolicitudesAplicadasSinDatosDTO(Integer idTasa, Integer estatus, String fechaOpe, Integer numcte,
			Integer contrato, Integer sucSolic, Integer numAutoriUEC, Integer monto, Integer tasaAutori, Integer plazo,
			String nomCte) {
		super();
		this.idTasa = idTasa;
		this.estatus = estatus;
		this.fechaOpe = fechaOpe;
		this.numcte = numcte;
		this.contrato = contrato;
		this.sucSolic = sucSolic;
		this.numAutoriUEC = numAutoriUEC;
		this.monto = monto;
		this.tasaAutori = tasaAutori;
		this.plazo = plazo;
		this.nomCte = nomCte;
	}

	public Integer getIdTasa() {
		return idTasa;
	}

	public void setIdTasa(Integer idTasa) {
		this.idTasa = idTasa;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public String getFechaOpe() {
		return fechaOpe;
	}

	public void setFechaOpe(String fechaOpe) {
		this.fechaOpe = fechaOpe;
	}

	public Integer getNumcte() {
		return numcte;
	}

	public void setNumcte(Integer numcte) {
		this.numcte = numcte;
	}

	public Integer getContrato() {
		return contrato;
	}

	public void setContrato(Integer contrato) {
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

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Integer getTasaAutori() {
		return tasaAutori;
	}

	public void setTasaAutori(Integer tasaAutori) {
		this.tasaAutori = tasaAutori;
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
	
	
}
