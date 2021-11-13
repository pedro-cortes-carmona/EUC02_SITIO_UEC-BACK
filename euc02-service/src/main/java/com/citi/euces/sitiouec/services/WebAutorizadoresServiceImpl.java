package com.citi.euces.sitiouec.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.citi.euces.sitiouec.dto.BuscarWebDTO;
import com.citi.euces.sitiouec.dto.CatSucursalesDTO;
import com.citi.euces.sitiouec.dto.ConsultarAutorizadorDTO;
import com.citi.euces.sitiouec.dto.MensajeDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.infra.utils.MensajesUtils;
import com.citi.euces.sitiouec.repositories.WebAutorizadoresRepository;
import com.citi.euces.sitiouec.services.api.WebAutorizadoresService;

@Service
public class WebAutorizadoresServiceImpl implements WebAutorizadoresService {
	
	
private static final Logger LOGGER = LogManager.getLogger(WebAutorizadoresServiceImpl.class);
	
	@Autowired
	private WebAutorizadoresRepository repository;
	
	@Override
	public List<BuscarWebDTO> getBuscarWebAutorizadores(String Inic, String division) throws GenericException, IOException, ParseException{
		LOGGER.info("INGRESA AL METODO BUSCAR DEL WEB AUTORIZADOR");
		List<BuscarWebDTO> listaBuscarWeb = new ArrayList<>();
		listaBuscarWeb = repository.getBuscarWebAutorizadores(Inic, division);
		if (listaBuscarWeb.isEmpty() || listaBuscarWeb.size() < 0) {
			LOGGER.info(MensajesUtils.NO_REGISTROS);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (BuscarWebDTO buscarWebDTO : listaBuscarWeb) {
			String fechaini = sdf.format(buscarWebDTO.getFechaInicio());
			String fechater = sdf.format(buscarWebDTO.getFechaTermino());
			System.out.println(fechaini);
			System.out.println(fechater);
			buscarWebDTO.setFechaInicioString(fechaini);
			buscarWebDTO.setFechaTerminoString(fechater);
		}
		return listaBuscarWeb;
	}
	
	@Override
	public List<CatSucursalesDTO> getListaSucursal() throws GenericException, IOException, ParseException{
		LOGGER.info("INGRESA AL METODO BUSCAR DEL WEB AUTORIZADOR");
		List<CatSucursalesDTO> listaSucursal = new ArrayList<>();
		listaSucursal = repository.getCatalogoSucursales();
		if (listaSucursal.isEmpty() || listaSucursal.size() < 0) {
			LOGGER.info(MensajesUtils.NO_REGISTROS);
		}
		return listaSucursal;
	}

	@Override
	public MensajeDTO desativarUsuario(String soeid) throws GenericException, IOException, ParseException{
		try {
			MensajeDTO msg = new MensajeDTO();
			repository.desativarUsuario(soeid);
			msg.setMensajeInfo("Usuario Inactivo...");
			msg.setMensajeConfirm("Se inactiva el usuario Satisfactoriamente.");
			return msg;
		} catch (Exception e) {
			e.getStackTrace();
			throw new GenericException("Error al actualizar el registro indicado", HttpStatus.NOT_FOUND.toString());
		}		
	}
	
	@Override
	public MensajeDTO insertarAutorizadores(String soeid, String soeidDivisional, String soeidDistrital, String division, String distrito
			,String nombre, String inic, String fechaInicio, String fechaTermino, Long alta, String correo, Long isCete100, Long isCampesp,
			Long idNivelAuto) throws GenericException, IOException, ParseException{
		try {
			MensajeDTO msg = new MensajeDTO();
			repository.insertarAutorizadores(soeid, soeidDivisional, soeidDistrital, division, distrito, nombre, inic, fechaInicio,
					fechaTermino, alta, correo, isCete100, isCampesp, idNivelAuto);
			msg.setMensajeInfo("Se inserta el usuario...");
			msg.setMensajeConfirm("Se inserta el usuario Satisfactoriamente.");
			return msg;
		} catch (Exception e) {
			e.getStackTrace();
			throw new GenericException("Error al actualizar el registro indicado", HttpStatus.NOT_FOUND.toString());
		}		
	}
	
	//OBTENER EL AUTORIZADOR PARA MODIFICAR
	@Override
	public List<ConsultarAutorizadorDTO> consultarAutorizadores(String soeid) throws GenericException, IOException, ParseException{
		LOGGER.info("INGRESA AL METODO BUSCAR AUTORIZADOR PARA MODIFICAR");
		List<ConsultarAutorizadorDTO> listaAutorizadorUpdate = new ArrayList<>();
		listaAutorizadorUpdate = repository.consultarAutorizadores(soeid);
		if(listaAutorizadorUpdate.isEmpty() || listaAutorizadorUpdate.size() < 0) {
			LOGGER.info(MensajesUtils.NO_REGISTROS);
		}
		return listaAutorizadorUpdate;
	}
	
	//MODIFICAR LOS CAMPOS DEL AUTORIZADR
	@Override
	public MensajeDTO modificarAutorizadores(String soeid, String soeidDivisional, String soeidDistrital, String division, String distrito
			,String nombre, String inic, String fechaInicio, String fechaTermino, Long alta, String correo, Long isCete100, Long isCampesp,
			Long idNivelAuto) throws GenericException, IOException, ParseException{
		try {
			MensajeDTO msg = new MensajeDTO();
			repository.modificarAutorizadores(soeid, soeidDivisional, soeidDistrital, division, distrito
					,nombre, inic, fechaInicio, fechaTermino, alta, correo, isCete100, isCampesp,
					idNivelAuto);
			msg.setMensajeInfo("Usuario Actualizado Satisfactoriamente...");
			msg.setMensajeConfirm("Se actualiza el usuario Satisfactoriamente.");
			return msg;
		} catch (Exception e) {
			e.getStackTrace();
			throw new GenericException("Error al actualizar el registro indicado", HttpStatus.NOT_FOUND.toString());
		}	
	}
	

}
