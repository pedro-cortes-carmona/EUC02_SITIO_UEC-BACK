package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.Date;

public class LogEliminacionDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; 
	private String soeid;
	private Date fecha_ope;
	private Date fecha_elim;
	
	public LogEliminacionDTO() {}
	
	public LogEliminacionDTO(String soeid, Date fecha_ope, Date fecha_elim) {
		super();
		this.soeid = soeid;
		this.fecha_ope = fecha_ope;
		this.fecha_elim = fecha_elim;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSoeid() {
		return soeid;
	}

	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}

	public Date getFecha_ope() {
		return fecha_ope;
	}

	public void setFecha_ope(Date fecha_ope) {
		this.fecha_ope = fecha_ope;
	}

	public Date getFecha_elim() {
		return fecha_elim;
	}

	public void setFecha_elim(Date fecha_elim) {
		this.fecha_elim = fecha_elim;
	}
	
	
}
