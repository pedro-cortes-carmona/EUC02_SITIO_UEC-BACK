package com.citi.euces.sitiouec.services;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.euces.sitiouec.dto.AutoCetesDTO;
import com.citi.euces.sitiouec.dto.SubastaCetesDTO;
import com.citi.euces.sitiouec.repositories.CetesRepository;
import com.citi.euces.sitiouec.services.api.CetesService;


@Service
public class CetesServiceImpl implements CetesService{
	
	private static final Logger LOGGER = LogManager.getLogger(CetesServiceImpl.class);
	
	@Autowired
	private CetesRepository cetesRepository;
	

	@Override
	public List<SubastaCetesDTO> getSubastaCetes() {		
		LOGGER.info("CetesServiceImpl - getSubastaCetes");
		return cetesRepository.getSubastaCetes();
	}

	@Override
	public List<AutoCetesDTO> getAutoCetes() {
		LOGGER.info("CetesServiceImpl - getAutoCetes");
		return cetesRepository.getAutoCetes();
	}
	
	
	

}
