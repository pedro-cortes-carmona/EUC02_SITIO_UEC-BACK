package com.citi.euces.sitiouec.dto;

import java.util.List;

public class ActualizarSoeidAtendidoInputDTO {
	
	List<ActualizarSoeidAtendidoDTO> lsSoeidAtendido;
	
	
	public List<ActualizarSoeidAtendidoDTO> getLsSoeidAtendido() {
		return lsSoeidAtendido;
	}
	
	
	public void setLsSoeidAtendido(List<ActualizarSoeidAtendidoDTO> lsSoeidAtendido) {
		this.lsSoeidAtendido = lsSoeidAtendido;
	}


	@Override
	public String toString() {
		return "ActualizarSoeidAtendidoInputDTO [lsSoeidAtendido=" + lsSoeidAtendido + "]";
	}
	
	

}
