package com.citi.euces.sitiouec.services.api;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.citi.euces.sitiouec.dto.BuscarWebDTO;
import com.citi.euces.sitiouec.dto.CatSucursalesDTO;
import com.citi.euces.sitiouec.dto.ConsultarAutorizadorDTO;
import com.citi.euces.sitiouec.dto.MensajeDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;


public interface WebAutorizadoresService {
	
	List<BuscarWebDTO> getBuscarWebAutorizadores(String Inic, String division) throws GenericException, IOException, ParseException;
	
	List<CatSucursalesDTO>getListaSucursal() throws GenericException, IOException, ParseException;
	
	MensajeDTO desativarUsuario(String soeid) throws GenericException, IOException, ParseException;
	
	MensajeDTO insertarAutorizadores(String soeid, String soeidDivisional, String soeidDistrital, String division, String distrito
	,String nombre, String inic, String fechaInicio, String fechaTermino, Long alta, String correo, Long isCete100, Long isCampesp,
	Long idNivelAuto) throws GenericException, IOException, ParseException;
	
	List<ConsultarAutorizadorDTO> consultarAutorizadores(String soeid) throws GenericException, IOException, ParseException;
	
	MensajeDTO modificarAutorizadores(String soeid, String soeidDivisional, String soeidDistrital, String division, String distrito
			,String nombre, String inic, String fechaInicio, String fechaTermino, Long alta, String correo, Long isCete100, Long isCampesp,
			Long idNivelAuto) throws GenericException, IOException, ParseException;
	
	
}
