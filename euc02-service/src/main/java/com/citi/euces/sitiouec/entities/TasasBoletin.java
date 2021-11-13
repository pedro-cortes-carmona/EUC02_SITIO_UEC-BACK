package com.citi.euces.sitiouec.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UEC_TB_TASAS_BOLETIN")
public class TasasBoletin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TASAUTO")
	private Integer idTasaAuto;

	@Column(name = "FECHA_OPE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaOpe;
	
	@Column(name = "ESTATUS")
	private Integer estatus;
	
	@Column(name = "DIVISION")
	private String division;

	@Column(name = "NUM_AUTORI_UEC")
	private Integer numAutoriUec;
	
	@Column(name = "T_PER")
	private Integer tPer;
	
	@Column(name = "MONTO")
	private Integer monto;
	
	@Column(name = "PRODUCTO")
	private Integer producto;
	
	@Column(name = "IS_TASA_BASE")
	private Integer isTasaBase;

	public Integer getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(Integer idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
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

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Integer getNumAutoriUec() {
		return numAutoriUec;
	}

	public void setNumAutoriUec(Integer numAutoriUec) {
		this.numAutoriUec = numAutoriUec;
	}

	public Integer gettPer() {
		return tPer;
	}

	public void settPer(Integer tPer) {
		this.tPer = tPer;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public Integer getProducto() {
		return producto;
	}

	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	public Integer getIsTasaBase() {
		return isTasaBase;
	}

	public void setIsTasaBase(Integer isTasaBase) {
		this.isTasaBase = isTasaBase;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
