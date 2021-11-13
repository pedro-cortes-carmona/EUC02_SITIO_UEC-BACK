package com.citi.euces.sitiouec.dto;

import java.util.List;

public class AsignacionesSoeidInputDTO {
	
	
	private List<String> lsSoeidInactivos;
	
	public AsignacionesSoeidInputDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<String> getLsSoeidInactivos() {
		return lsSoeidInactivos;
	}
	
	
	public void setLsSoeidInactivos(List<String> lsSoeidInactivos) {
		this.lsSoeidInactivos = lsSoeidInactivos;
	}


	@Override
	public String toString() {
		return "AsignacionesSoeidInputDTO [lsSoeidInactivos=" + lsSoeidInactivos + "]";
	}
	
	
	
	

}
