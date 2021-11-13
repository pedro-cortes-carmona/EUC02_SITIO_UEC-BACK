package com.citi.euces.sitiouec.dto;

import java.util.ArrayList;
import java.util.List;

public class InsertarReprocesosDTO {
	
	List<TasasReprocesoDTO> lsReprocesos;
	
	
	public List<TasasReprocesoDTO> getLsReprocesos() {
		
		if(lsReprocesos==null) {
			lsReprocesos = new ArrayList<>();
		}
		return lsReprocesos;
	}
	
	public void setLsReprocesos(List<TasasReprocesoDTO> lsReprocesos) {
		this.lsReprocesos = lsReprocesos;
	}

}
