package com.citi.euces.sitiouec.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_CAT_FECHAS_FESTIVAS") // TSC_EUCS_OWN
public class FechasFestivas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@Basic(optional = false)
	@Column(name = "ID_FECHA")
	private Long idFecha;

	@Column(name = "DESCRIPCION", nullable = true)
	private String descripcion;

	@Column(name = "FECHA", nullable = true)
	private Date fecha;

	public Long getIdFecha() {
		return idFecha;
	}

	public void setIdFecha(Long idFecha) {
		this.idFecha = idFecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "FechasFestivas [idFecha=" + idFecha + ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
	}

}
