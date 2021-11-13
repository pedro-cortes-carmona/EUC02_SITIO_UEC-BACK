package com.citi.euces.sitiouec.models;

import java.util.List;

import com.citi.euces.sitiouec.dto.PerCatSucursalesDTO;

public class MensajeResponseDivisiones {

	private String code;
	private List<PerCatSucursalesDTO> lsDivisiones;

	public MensajeResponseDivisiones() {
		// TODO Auto-generated constructor stub
	}

	public MensajeResponseDivisiones(List<PerCatSucursalesDTO> lsDivisiones,String code) {
		super();
		this.code = code;
		this.lsDivisiones = lsDivisiones;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<PerCatSucursalesDTO> getLsDivisiones() {
		return lsDivisiones;
	}

	public void setLsDivisiones(List<PerCatSucursalesDTO> lsDivisiones) {
		this.lsDivisiones = lsDivisiones;
	}

	@Override
	public String toString() {
		return "MensajeResponseDivisiones [code=" + code + ", lsDivisiones=" + lsDivisiones + "]";
	}

}
