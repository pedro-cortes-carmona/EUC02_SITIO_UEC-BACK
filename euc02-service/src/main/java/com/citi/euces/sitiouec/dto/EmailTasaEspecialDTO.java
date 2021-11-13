package com.citi.euces.sitiouec.dto;

import java.io.Serializable;

public class EmailTasaEspecialDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	public String idTasaAuto;
	
	public String sucursal;
	
	public String nombreCliente;
	
	public String numeroCliente;
	
	public String contrato;
	
	public String monto;
	
	public String plazo;
	
	public String tasaAutori;
	
	public String justificacion;
	
	public String nomejec;
	
	
	public EmailTasaEspecialDTO() {
		
	}
	
	
	public EmailTasaEspecialDTO(String idTasaAuto, String sucursal, String nombreCliente, String numeroCliente,
			String contrato, String monto, String plazo, String tasaAutori, String justificacion, String nomejec) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.sucursal = sucursal;
		this.nombreCliente = nombreCliente;
		this.numeroCliente = numeroCliente;
		this.contrato = contrato;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
		this.justificacion = justificacion;
		this.nomejec = nomejec;
	}

	public String getIdTasaAuto() {
		return idTasaAuto;
	}


	public void setIdTasaAuto(String idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}


	public String getSucursal() {
		return sucursal;
	}


	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public String getNumeroCliente() {
		return numeroCliente;
	}


	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}


	public String getContrato() {
		return contrato;
	}


	public void setContrato(String contrato) {
		this.contrato = contrato;
	}


	public String getMonto() {
		return monto;
	}


	public void setMonto(String monto) {
		this.monto = monto;
	}


	public String getPlazo() {
		return plazo;
	}


	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}


	public String getTasaAutori() {
		return tasaAutori;
	}


	public void setTasaAutori(String tasaAutori) {
		this.tasaAutori = tasaAutori;
	}


	public String getJustificacion() {
		return justificacion;
	}


	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}


	public String getNomejec() {
		return nomejec;
	}


	public void setNomejec(String nomejec) {
		this.nomejec = nomejec;
	}
	
		
}
