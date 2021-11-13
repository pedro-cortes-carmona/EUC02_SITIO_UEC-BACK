package com.citi.euces.sitiouec.services.api;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.citi.euces.sitiouec.dto.CetePaginaDTO;
import com.citi.euces.sitiouec.dto.HistoricoCetesDTO;
import com.citi.euces.sitiouec.dto.MensajeDTO;
import com.citi.euces.sitiouec.dto.ReporteCetesDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;


public interface SubastaCetesService {
	
	//BUSCAR EL HISTORICO
	List<HistoricoCetesDTO> listadoSubastaCetes();
	
	//CALCULAR EL HISTORICO
	MensajeDTO insertHistoricoCetes(String fecha, Double cete1plazo, Double cete1tasa, Double cete2plazo, Double cete2tasa, Double cete3plazo, 
			   Double cete3tasa, Double cete4plazo, Double cete4tasa, Boolean subasta4plazos) throws GenericException, IOException, ParseException;
	
	//IMPORTAR DATOS DESDE TXT
	MensajeDTO cargarAutoRangos(String file,String fecha_inicio, String fecha_fin) throws GenericException, IOException, ParseException;	
	
	List<CetePaginaDTO> excelCetesVariacion()throws GenericException;	
	
	List<ReporteCetesDTO>  getSubastaCetes() throws GenericException;
	

}