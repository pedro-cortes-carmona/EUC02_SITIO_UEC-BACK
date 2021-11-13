package com.citi.euces.sitiouec.services.api;

import java.util.List;

import com.citi.euces.sitiouec.dto.ClientesRepetidosDTO;

public interface ClientesRepetidosService {
	
	List<ClientesRepetidosDTO> getClientesRepetidosCampana(String date1, String date2);
	
	List<ClientesRepetidosDTO> getClientesRepetidosOperativo(String date1, String date2);
	
	
	

}
