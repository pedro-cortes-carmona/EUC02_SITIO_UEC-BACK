package com.citi.euces.sitiouec.repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.dto.AutoCetesDTO;
import com.citi.euces.sitiouec.dto.SubastaCetesDTO;
import com.citi.euces.sitiouec.entities.AutoCetes;
import com.citi.euces.sitiouec.entities.SubastaCetes;


@Repository
public class CetesRepository {
	
	private static final Logger LOGGER = LogManager.getLogger(CetesRepository.class);
	
	@Autowired
	private AutoCetesRepository autoCetesRepository;
	
	@Autowired
	private SubastaCeteRepository subastaCetesRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<SubastaCetesDTO> getSubastaCetes(){
		
		List<SubastaCetes>    lsSub       = new ArrayList<>();
		List<SubastaCetesDTO> lsSubastas  = new ArrayList<>();
		SubastaCetesDTO       sub         = new SubastaCetesDTO();
		
		try {
			
			lsSub  =  subastaCetesRepository.obtenerSubastaCetes();	

			for (SubastaCetes subastaCetesDTO : lsSub) {
				       sub = new SubastaCetesDTO();
					   sub.setFecha(subastaCetesDTO.getFecha());
					   sub.setCete1plazo(subastaCetesDTO.getCete1plazo());
					   sub.setCete1tasa(subastaCetesDTO.getCete1tasa());
					   sub.setCete2plazo(subastaCetesDTO.getCete2plazo());
					   sub.setCete2tasa(subastaCetesDTO.getCete2tasa());
					   sub.setCete3plazo(subastaCetesDTO.getCete3plazo());
					   sub.setCete3tasa(subastaCetesDTO.getCete3tasa());
					   sub.setCete4plazo(subastaCetesDTO.getCete4plazo());
					   sub.setCete4tasa(subastaCetesDTO.getCete4tasa());
					   lsSubastas.add(sub);
			}
			LOGGER.info("getSubastaCetes - CetesRepository" + " - " +  lsSub.size());
		} catch (Exception e) {
			LOGGER.error("Error :: getSubastaCetes - CetesRepository" + "  " +  e.getLocalizedMessage());
			LOGGER.error("Error :: getSubastaCetes - CetesRepository" + "  " +  e.getMessage());
			LOGGER.error("Error :: getSubastaCetes - CetesRepository" + "  " +  e.getCause());
		}	 
		
		return lsSubastas;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public List<AutoCetesDTO> getAutoCetes () {
		
		List<AutoCetes>    lsCetes       = new ArrayList<>();
		List<AutoCetesDTO> lsCetesDTO    = new ArrayList<>();
		AutoCetesDTO       autoCetesDTO  = new AutoCetesDTO();
		
		try {
			lsCetes = autoCetesRepository.obtenerCetes();
			
			for (AutoCetes cetes : lsCetes) {
				      autoCetesDTO  = new AutoCetesDTO();
				      autoCetesDTO.setIdPlazo(cetes.getIdPlazo());
				      autoCetesDTO.setCete(cetes.getCete());
				      lsCetesDTO.add(autoCetesDTO);
			}
			
			LOGGER.info("getAutoCetes - CetesRepository" + " - " +  lsCetes.size());
		} catch (Exception e) {
			LOGGER.error("Error :: getAutoCetes - CetesRepository" + "  " +  e.getLocalizedMessage());
			LOGGER.error("Error :: getAutoCetes - CetesRepository" + "  " +  e.getMessage());
			LOGGER.error("Error :: getAutoCetes - CetesRepository" + "  " +  e.getCause());
		}
		
		return lsCetesDTO;
	}
	
	

}
