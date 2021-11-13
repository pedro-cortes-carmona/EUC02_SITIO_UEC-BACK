package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_HISTORICO_ASIGNACIONES")
public class HistoricoAsignaciones {

	@Id
	@Column(name = "ID_TASAUTO", nullable = true)
	private Long idTasaAuto;

	@Column(name = "SOEID", nullable = true)
	private String soeid;
	
	@Column(name = "SOEID_ATENDIDO", nullable = true)
	private String soeidAtendido;

	@Column(name = "FECHA_SOLIC", nullable = true)
	private java.sql.Timestamp fechaSoli;

	@Column(name = "FECHA_DESC", nullable = true)
	private java.sql.Timestamp fechaDesc;

	@Column(name = "ESTATUS", nullable = true)
	private Long estatus;
	
	public HistoricoAsignaciones() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	public String getSoeid() {
		return soeid;
	}

	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}

	public String getSoeidAtendido() {
		return soeidAtendido;
	}

	public void setSoeidAtendido(String soeidAtendido) {
		this.soeidAtendido = soeidAtendido;
	}

	public java.sql.Timestamp getFechaSoli() {
		return fechaSoli;
	}

	public void setFechaSoli(java.sql.Timestamp fechaSoli) {
		this.fechaSoli = fechaSoli;
	}

	public java.sql.Timestamp getFechaDesc() {
		return fechaDesc;
	}

	public void setFechaDesc(java.sql.Timestamp fechaDesc) {
		this.fechaDesc = fechaDesc;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "HistoricoAsignaciones [idTasaAuto=" + idTasaAuto + ", soeid=" + soeid + ", soeidAtendido="
				+ soeidAtendido + ", fechaSoli=" + fechaSoli + ", fechaDesc=" + fechaDesc + ", estatus=" + estatus
				+ "]";
	}

	
	

}
