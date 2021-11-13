package com.citi.euces.sitiouec.dto;

import java.io.Serializable;

public class CatSucursalesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sucursal;
	
	
	
	public String getSucursal() {
		return sucursal;
	}



	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	
	public CatSucursalesDTO() {
		
	}

	
	public CatSucursalesDTO(String sucursal) {
		super();
		this.sucursal = sucursal;
	}



	@Override
	public String toString() {
		return "CatSucursalesDTO[sucursal="+sucursal+"]";
	}
	
	

}
