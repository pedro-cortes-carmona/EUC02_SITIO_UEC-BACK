package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_SUCURSALES") // TSC_EUCS_OWN
public class CatSucursales {

	@Id
	@Column(name = "SIRH_SUCURSAL_ID", nullable = true)
	private Long idSucursalSirh;

	@Column(name = "NOMBRE_SUCURSAL", nullable = true)
	private String nombreSucursal;

	@Column(name = "DISTRITO_ID", nullable = true)
	private String distritoID;

	@Column(name = "DISTRITO_NOMBRE", nullable = true)
	private String distritoNombre;

	@Column(name = "DIVISION_ID", nullable = true)
	private String divisionId;

	@Column(name = "DIVISION_NOMBRE", nullable = true)
	private String divisionNombre;

	@Column(name = "TIPO_DISPOSITIVO", nullable = true)
	private String tipoDispositivo;

	@Column(name = "EJECUTIVO_EAV", nullable = true)
	private String ejecutivoEAV;

	@Column(name = "EJECUTIVO_PRIORITY", nullable = true)
	private String ejecutivoPriority;

	@Column(name = "EJECUTIVO_TOTAL", nullable = true)
	private Long ejecutivoTotal;

	@Column(name = "IS_CLOSE", nullable = true)
	private String isClose;
	
	

	public CatSucursales() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdSucursalSirh() {
		return idSucursalSirh;
	}

	public void setIdSucursalSirh(Long idSucursalSirh) {
		this.idSucursalSirh = idSucursalSirh;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getDistritoID() {
		return distritoID;
	}

	public void setDistritoID(String distritoID) {
		this.distritoID = distritoID;
	}

	public String getDistritoNombre() {
		return distritoNombre;
	}

	public void setDistritoNombre(String distritoNombre) {
		this.distritoNombre = distritoNombre;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionNombre() {
		return divisionNombre;
	}

	public void setDivisionNombre(String divisionNombre) {
		this.divisionNombre = divisionNombre;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public String getEjecutivoEAV() {
		return ejecutivoEAV;
	}

	public void setEjecutivoEAV(String ejecutivoEAV) {
		this.ejecutivoEAV = ejecutivoEAV;
	}

	public String getEjecutivoPriority() {
		return ejecutivoPriority;
	}

	public void setEjecutivoPriority(String ejecutivoPriority) {
		this.ejecutivoPriority = ejecutivoPriority;
	}

	public Long getEjecutivoTotal() {
		return ejecutivoTotal;
	}

	public void setEjecutivoTotal(Long ejecutivoTotal) {
		this.ejecutivoTotal = ejecutivoTotal;
	}

	public String getIsClose() {
		return isClose;
	}

	public void setIsClose(String isClose) {
		this.isClose = isClose;
	}

	@Override
	public String toString() {
		return "CatSucursales [idSucursalSirh=" + idSucursalSirh + ", nombreSucursal=" + nombreSucursal
				+ ", distritoID=" + distritoID + ", distritoNombre=" + distritoNombre + ", divisionId=" + divisionId
				+ ", divisionNombre=" + divisionNombre + ", tipoDispositivo=" + tipoDispositivo + ", ejecutivoEAV="
				+ ejecutivoEAV + ", ejecutivoPriority=" + ejecutivoPriority + ", ejecutivoTotal=" + ejecutivoTotal
				+ ", isClose=" + isClose + "]";
	}

}
