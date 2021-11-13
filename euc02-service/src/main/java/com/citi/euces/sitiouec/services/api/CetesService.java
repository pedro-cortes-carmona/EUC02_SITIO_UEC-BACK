package com.citi.euces.sitiouec.services.api;

import java.util.List;

import com.citi.euces.sitiouec.dto.AutoCetesDTO;
import com.citi.euces.sitiouec.dto.SubastaCetesDTO;

public interface CetesService {

	
	public List<SubastaCetesDTO> getSubastaCetes();
	
	public List<AutoCetesDTO> getAutoCetes ();
	
	
	
	
}
