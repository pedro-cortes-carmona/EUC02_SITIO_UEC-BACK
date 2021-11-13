package com.citi.euces.sitiouec.services.api;

import java.util.List;

import com.citi.euces.sitiouec.dto.PerCatSucursalesDTO;

public interface PerCatSucursalesService {

	
	List<PerCatSucursalesDTO> getDivisiones(String descripcion);
	
	
	
}
