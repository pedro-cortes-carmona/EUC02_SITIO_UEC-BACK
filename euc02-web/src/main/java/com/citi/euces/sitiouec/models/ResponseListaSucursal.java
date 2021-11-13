package com.citi.euces.sitiouec.models;

import java.io.Serializable;
import java.util.List;

import com.citi.euces.sitiouec.dto.CatSucursalesDTO;

public class ResponseListaSucursal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CatSucursalesDTO> listaSucursal;
	private String code;
	
	public ResponseListaSucursal() {}
	
	public ResponseListaSucursal(List<CatSucursalesDTO> listaSucursal, String code) {
		super();
		this.listaSucursal = listaSucursal;
		this.code = code;
	}

	public List<CatSucursalesDTO> getListaSucursal() {
		return listaSucursal;
	}

	public void setListaSucursal(List<CatSucursalesDTO> listaSucursal) {
		this.listaSucursal = listaSucursal;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
