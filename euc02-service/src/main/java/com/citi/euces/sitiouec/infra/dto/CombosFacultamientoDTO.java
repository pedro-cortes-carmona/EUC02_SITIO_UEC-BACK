package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;
import java.util.List;

public class CombosFacultamientoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<DivisionDTO> listaDivision;
	private List<AutDivisionalesDTO> listaAutDivisionales;
	private List<AutDivisionalesDTO> listaAutRegionales;
	private List<RegionesDTO> listaRegion;
	
	public CombosFacultamientoDTO() {}
	
	public CombosFacultamientoDTO(List<DivisionDTO> listaDivision, List<AutDivisionalesDTO> listaAutDivisionales,
			List<AutDivisionalesDTO> listaAutRegionales, List<RegionesDTO> listaRegion) {
		super();
		this.listaDivision = listaDivision;
		this.listaAutDivisionales = listaAutDivisionales;
		this.listaAutRegionales = listaAutRegionales;
		this.listaRegion = listaRegion;
	}

	public List<DivisionDTO> getListaDivision() {
		return listaDivision;
	}

	public void setListaDivision(List<DivisionDTO> listaDivision) {
		this.listaDivision = listaDivision;
	}

	public List<AutDivisionalesDTO> getListaAutDivisionales() {
		return listaAutDivisionales;
	}

	public void setListaAutDivisionales(List<AutDivisionalesDTO> listaAutDivisionales) {
		this.listaAutDivisionales = listaAutDivisionales;
	}

	public List<AutDivisionalesDTO> getListaAutRegionales() {
		return listaAutRegionales;
	}

	public void setListaAutRegionales(List<AutDivisionalesDTO> listaAutRegionales) {
		this.listaAutRegionales = listaAutRegionales;
	}

	public List<RegionesDTO> getListaRegion() {
		return listaRegion;
	}

	public void setListaRegion(List<RegionesDTO> listaRegion) {
		this.listaRegion = listaRegion;
	}
	
	
	
}
