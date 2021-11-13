package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_SUCURSALES")
public class Sucursales {
	@Id
	@Column(name="SIRH_SUCURSAL_ID", nullable=false)
	private Integer SirhSucursalelId;
	
	@Column(name="NOMBRE_SUCURSAL", nullable=false)
	private String NombreSucursal;
	
	@Column(name="DISTRITO_ID", nullable=false)
	private Integer DistritoId;
	
	@Column(name="DISTRITO_NOMBRE", nullable=false)
	private String DistritoNombre;
	
	@Column(name="DIVISION_ID", nullable=false)
	private Integer DivisionId;
	
	@Column(name="DIVISION_NOMBRE", nullable=false)
	private String DivisionNombre;
	
	@Column(name="TIPO_DISPOSITIVO", nullable=false)
	private String TipoDispositivo;
	
	@Column(name="EJECUTIVO_EAV", nullable=false)
	private Integer EjecutivoEAV;
	
	@Column(name="EJECUTIVO_PRIORITY", nullable=false)
	private Integer EjecutivoPriority;
	
	@Column(name="EJECUTIVO_TOTAL", nullable=false)
	private Integer EjecutivoTotal;
	
	@Column(name="IS_CLOSE", nullable=false)
	private Integer IsClose;

	@Override
	public String toString() {
		return "Sucursales [SirhSucursalelId=" + SirhSucursalelId + ", NombreSucursal=" + NombreSucursal
				+ ", DistritoId=" + DistritoId + ", DistritoNombre=" + DistritoNombre + ", DivisionId=" + DivisionId
				+ ", DivisionNombre=" + DivisionNombre + ", TipoDispositivo=" + TipoDispositivo + ", EjecutivoEAV="
				+ EjecutivoEAV + ", EjecutivoPriority=" + EjecutivoPriority + ", EjecutivoTotal=" + EjecutivoTotal
				+ ", IsClose=" + IsClose + "]";
	}
	
	public String stringTitulo() {
		return "SirhSucursalelId	" + "NombreSucursal	" + "DistritoId	" + "DistritoNombre	" + "DivisionId	"
				+ "DivisionNombre	" + "TipoDispositivo	" + "EjecutivoEAV	"+ "EjecutivoPriority	" + "EjecutivoTotal	"
				+ " IsClose	";
	}
	
	public String stringCuerpo() {
		return SirhSucursalelId + "	" + NombreSucursal+ "	" + DistritoId + "	" + DistritoNombre + "	" 
				+ DivisionId+ "	" + DivisionNombre + "	" + TipoDispositivo + "	"+ EjecutivoEAV + "	" 
				+ EjecutivoPriority + "	" + EjecutivoTotal+ "	" + IsClose;
	}

	public Sucursales(Integer sirhSucursalelId, String nombreSucursal, Integer distritoId, String distritoNombre,
			Integer divisionId, String divisionNombre, String tipoDispositivo, Integer ejecutivoEAV, Integer ejecutivoPriority,
			Integer ejecutivoTotal, Integer isClose) {
		super();
		SirhSucursalelId = sirhSucursalelId;
		NombreSucursal = nombreSucursal;
		DistritoId = distritoId;
		DistritoNombre = distritoNombre;
		DivisionId = divisionId;
		DivisionNombre = divisionNombre;
		TipoDispositivo = tipoDispositivo;
		EjecutivoEAV = ejecutivoEAV;
		EjecutivoPriority = ejecutivoPriority;
		EjecutivoTotal = ejecutivoTotal;
		IsClose = isClose;
	}

	public Sucursales() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSirhSucursalelId() {
		return SirhSucursalelId;
	}

	public void setSirhSucursalelId(Integer sirhSucursalelId) {
		SirhSucursalelId = sirhSucursalelId;
	}

	public String getNombreSucursal() {
		return NombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		NombreSucursal = nombreSucursal;
	}

	public Integer getDistritoId() {
		return DistritoId;
	}

	public void setDistritoId(Integer distritoId) {
		DistritoId = distritoId;
	}

	public String getDistritoNombre() {
		return DistritoNombre;
	}

	public void setDistritoNombre(String distritoNombre) {
		DistritoNombre = distritoNombre;
	}

	public Integer getDivisionId() {
		return DivisionId;
	}

	public void setDivisionId(Integer divisionId) {
		DivisionId = divisionId;
	}

	public String getDivisionNombre() {
		return DivisionNombre;
	}

	public void setDivisionNombre(String divisionNombre) {
		DivisionNombre = divisionNombre;
	}

	public String getTipoDispositivo() {
		return TipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		TipoDispositivo = tipoDispositivo;
	}

	public Integer getEjecutivoEAV() {
		return EjecutivoEAV;
	}

	public void setEjecutivoEAV(Integer ejecutivoEAV) {
		EjecutivoEAV = ejecutivoEAV;
	}

	public Integer getEjecutivoPriority() {
		return EjecutivoPriority;
	}

	public void setEjecutivoPriority(Integer ejecutivoPriority) {
		EjecutivoPriority = ejecutivoPriority;
	}

	public Integer getEjecutivoTotal() {
		return EjecutivoTotal;
	}

	public void setEjecutivoTotal(Integer ejecutivoTotal) {
		EjecutivoTotal = ejecutivoTotal;
	}

	public Integer getIsClose() {
		return IsClose;
	}

	public void setIsClose(Integer isClose) {
		IsClose = isClose;
	}

}
