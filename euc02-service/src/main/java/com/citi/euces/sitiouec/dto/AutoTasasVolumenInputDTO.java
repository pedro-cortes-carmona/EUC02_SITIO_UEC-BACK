package com.citi.euces.sitiouec.dto;


import java.util.ArrayList;
import java.util.List;


public class AutoTasasVolumenInputDTO {
	
	private String fechaInicial;	
	
	private String soeid;
	
	private List<ListaUsuariosSoeidDTO> lsUsuariosSoeid;
		
	public List<ListaUsuariosSoeidDTO> getLsUsuariosSoeid() {
		
		if(lsUsuariosSoeid==null) {
			lsUsuariosSoeid = new ArrayList<>();
		}
		
		return lsUsuariosSoeid;
	}
	
	public void setLsUsuariosSoeid(List<ListaUsuariosSoeidDTO> lsUsuariosSoeid) {
		this.lsUsuariosSoeid = lsUsuariosSoeid;
	}
	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getSoeid() {
		return soeid;
	}

	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}
	
}
