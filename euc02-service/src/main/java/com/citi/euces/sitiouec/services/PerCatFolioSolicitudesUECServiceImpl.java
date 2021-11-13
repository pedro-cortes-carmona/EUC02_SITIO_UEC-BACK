package com.citi.euces.sitiouec.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.euces.sitiouec.dto.PerCatFolioSolicitudesUECDTO;
import com.citi.euces.sitiouec.repositories.PerCatFolioSolicitudesUECRepository;
import com.citi.euces.sitiouec.repositories.TasasRepository;
import com.citi.euces.sitiouec.services.api.PerCatFolioSolicitudesUECService;

@Service
public class PerCatFolioSolicitudesUECServiceImpl implements PerCatFolioSolicitudesUECService {
	
	private static final Logger LOGGER = LogManager.getLogger(PerCatFolioSolicitudesUECServiceImpl.class);
	
	@Autowired
	PerCatFolioSolicitudesUECRepository folioRepository;

	@Override
	public Integer getPDFFolioCliente(String numCliente) {

		
		int res=0;
		List<PerCatFolioSolicitudesUECDTO> lsFolios = new ArrayList<>();
		
		lsFolios = folioRepository.getPDFFolioCliente(numCliente);
		
		List<String> lsFoliosActualizar = new ArrayList<>();
		
		for (PerCatFolioSolicitudesUECDTO clientes : lsFolios) {
			
			LOGGER.info("ENCONTRO LOS SIGUIENTES CLIENTES"+ " " + clientes.getPdfFolioIdCliente());
			LOGGER.info("ENCONTRO LOS SIGUIENTES CLIENTES"+ " " + clientes.getPdfFolioEstatus());
		}
		
		/**
		 * Si la lista es mayor a cero entonces hay elementos por actualizar
		 * 
		 */
		if(lsFolios.size()>0) {			
			LOGGER.info("SE ENCONTRARON FOLIOS PARA ACTUALIZAR" + " " +  "PerCatFolioSolicitudesUECServiceImpl");
			for (PerCatFolioSolicitudesUECDTO folios : lsFolios) {
				lsFoliosActualizar.add(String.valueOf(folios.getPdfFolioIdCliente()));
			}
			
			res = folioRepository.actualizarEstatusClientes(lsFoliosActualizar);
			
			res = folioRepository.actualizarPDFFolioClienteIdCliente(lsFoliosActualizar);
			
			
			LOGGER.info("ACTUALIZACION CORRECTA -  " + " " + res);
		}else {
			LOGGER.info("NO SE ENCONTRARON FOLIOS PARA ACTUALIZAR -  PerCatFolioSolicitudesUECServiceImpl");			
		}
		
		return res;
	}

}
