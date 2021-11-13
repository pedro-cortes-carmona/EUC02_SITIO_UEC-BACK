package com.citi.euces.sitiouec.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.citi.euces.sitiouec.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.dto.CargaCeteDTO;
import com.citi.euces.sitiouec.dto.CargaGridDTO;
import com.citi.euces.sitiouec.dto.EditarTasaAutoDTO;
import com.citi.euces.sitiouec.dto.EmailTasaEspecialDTO;
import com.citi.euces.sitiouec.dto.MensajeDTO;
import com.citi.euces.sitiouec.dto.ResendMailDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.infra.utils.MensajesUtils;
import com.citi.euces.sitiouec.repositories.TasaAutoRepository;
import com.citi.euces.sitiouec.services.api.TasaAutoService;

@Service
public class TasaAutoImpl implements TasaAutoService{
	
	private static final Logger LOGGER = LogManager.getLogger(TasaAutoImpl.class);
	
	@Autowired
	private TasaAutoRepository repository;
	
	@Override
	public List<CargaGridDTO> getCargaGrid() {
		List<CargaGridDTO> listaCargaGrid = new ArrayList<>();
		CargaGridDTO cargaGridDTO = new CargaGridDTO();

		listaCargaGrid = repository.getCargaGrid();

		if (listaCargaGrid.isEmpty() || listaCargaGrid.size() < 0) {
			cargaGridDTO.setSinRegistros(MensajesUtils.NO_REGISTROS);
		}

		return listaCargaGrid;
	}
	
	
	@Override
	public List<CargaGridDTO> getInBuscarClick(String estatus, String contrato, String numeroCliente, String fechaSolicitud){
		LOGGER.info("INGRESA AL METODO BUSCAR DEL IMPLEMENT");
		List<CargaGridDTO> listaInBuscarClick = new ArrayList<>();
		CargaGridDTO cargaGridDTO = new CargaGridDTO();
		listaInBuscarClick = repository.getInBuscarClick(estatus, contrato, numeroCliente, fechaSolicitud);
		if (listaInBuscarClick.isEmpty() || listaInBuscarClick.size() < 0) {
			cargaGridDTO.setSinRegistros(MensajesUtils.NO_REGISTROS);
		}
		return listaInBuscarClick;
		
	}
	
	@Override
	public List<CargaCeteDTO> getCargaCetes() {
		List<CargaCeteDTO> listaCargaCetes = new ArrayList<>();
		CargaCeteDTO cargaCeteDTO = new CargaCeteDTO();

		listaCargaCetes = repository.getCargaCeteDTO();

		if (listaCargaCetes.isEmpty() || listaCargaCetes.size() < 0) {
			LOGGER.info(MensajesUtils.NO_REGISTROS);
		}

		return listaCargaCetes;
	}
	
	@Override
	public List<EditarTasaAutoDTO> getInBuscarEditar(Long idAutoTasa){
		LOGGER.info("INGRESA AL EDITAR");
		List<EditarTasaAutoDTO> listaEditar = new ArrayList<>();
		EditarTasaAutoDTO editarTasaAutoDTO = new EditarTasaAutoDTO();
		listaEditar = repository.getInBuscarEditar(idAutoTasa);
		if (listaEditar.isEmpty() || listaEditar.size() < 0) {
			LOGGER.info(MensajesUtils.NO_REGISTROS);
		}
		return listaEditar;
	}
	
	
	@Override
	public MensajeDTO updateInkRechazar(String soeidOpe, String justificacion, String observaWeb, String idTasaAuto, String fechaSolicitud) throws GenericException, IOException, ParseException{
		try {
			MensajeDTO msg = new MensajeDTO();
			repository.updateInkRechazar(soeidOpe, justificacion, observaWeb, idTasaAuto, fechaSolicitud);
			msg.setMensajeInfo("Información Actualización registro...");
			msg.setMensajeConfirm("Se actualiza la información Satisfactoriamente.");
			return msg;
		} catch (Exception e) {
			e.getStackTrace();
			throw new GenericException("Error al actualizar el registro indicado", HttpStatus.NOT_FOUND.toString());
		}
	}
	
	//SERVICIO IN RECHAZAR CANCELAR CLICK
	@Override
	public MensajeDTO updateInkRechazarCancelar(String soeidOpe, String fechaEstatus, String justificacion, String observacionWeb, String numAutoriEUC,
			String estatus, String idTasaAuto) throws GenericException, IOException, ParseException{
		try {
			MensajeDTO msg = new MensajeDTO();
			repository.updateInkRechazarCancelar(soeidOpe, fechaEstatus, justificacion, observacionWeb, numAutoriEUC, estatus, idTasaAuto);
			msg.setMensajeInfo("Información Actualización registro...");
			msg.setMensajeConfirm("Se actualiza la información Satisfactoriamente.");
			return msg;
		} catch (Exception e) {
			e.getStackTrace();
			throw new GenericException("Error al actualizar el registro indicado", HttpStatus.NOT_FOUND.toString());
		}
	}
	
	//SERVICIO CANCELAR CLICK
		@Override
		public MensajeDTO updateInkCancelar(String soeidOpe, String estatus, String justificacion, String observacionWeb, String numAutoriEUC, String idTasaAuto) throws GenericException, IOException, ParseException{
			try {
				MensajeDTO msg = new MensajeDTO();
				repository.updateInkCancelar(soeidOpe, estatus, justificacion, observacionWeb, numAutoriEUC, idTasaAuto);
				msg.setMensajeInfo("Información Actualización registro...");
				msg.setMensajeConfirm("Se actualiza la información Satisfactoriamente.");
				return msg;
			} catch (Exception e) {
				e.getStackTrace();
				throw new GenericException("Error al actualizar el registro indicado", HttpStatus.NOT_FOUND.toString());
			}
		}
		
		//SERVICIO CHEKEAR RECIBIR
				@Override
				public MensajeDTO insertChkRecibir(String soeid, String online, String nombre, String action) throws GenericException, IOException, ParseException{
					try {
						MensajeDTO msg = new MensajeDTO();
						repository.insertChkRecibir(soeid, online, nombre, action);
						msg.setMensajeInfo("Información Actualización registro...");
						msg.setMensajeConfirm("Se actualiza la información Satisfactoriamente.");
						return msg;
					} catch (Exception e) {
						e.getStackTrace();
						throw new GenericException("Error al actualizar el registro indicado", HttpStatus.NOT_FOUND.toString());
					}
				}

		
				
		//getCargaResendMail
		@Override
		public List<ResendMailDTO> getCargaResendMail() {
			List<ResendMailDTO> listaResendMail = new ArrayList<>();
			
			listaResendMail = repository.getCargaResendMail();
			
			if (listaResendMail.isEmpty() || listaResendMail.size() < 0) {
				LOGGER.info(MensajesUtils.NO_REGISTROS);
			}

			return listaResendMail;
		}


		//ENVIO DE CORREO
		@Override
		public EmailTasaEspecialDTO emailTasaEspecialDTO(String folio, String linkAutoriza, String linkRechaza, String autorizadores, String urlRedirect, String idAutorizadores) throws GenericException{
			return null;
			
		}


		@Override
		public List<AutoTasasDTO> getInBuscarClickSolicitudes(String estatus, String contrato, String numeroCliente,
				String fechaSolicitud) {
		
		List<AutoTasasDTO> listaInBuscarClick = new ArrayList<>();
		
		listaInBuscarClick = repository.getCargaGridLoad(fechaSolicitud, estatus, contrato, numeroCliente);
		
		return listaInBuscarClick;
			
		}


		@Override
		public List<AutoTasasDTO> getInBuscarClickSolicitudesVersion2(String estatus, String contrato,
				String numeroCliente, String fechaSolicitud) {
			List<AutoTasasDTO> listaInBuscarClick = new ArrayList<>();
			
			listaInBuscarClick = repository.getCargaGridLoadVersion2(fechaSolicitud, estatus, contrato, numeroCliente);
			
			return listaInBuscarClick;
		}


		@Override
		public MensajeDTO actualizaSolicitud(String soeidOpe, String idTasaAuto)
				throws GenericException, IOException, ParseException {
			try {
				MensajeDTO msg = new MensajeDTO();
				msg = repository.actualizaSolicitud(soeidOpe, idTasaAuto);
				return msg;
			} catch (Exception e) {
				e.getStackTrace();
				throw new GenericException("Error al actualizar el registro indicado", HttpStatus.NOT_FOUND.toString());
			}
			
		}			
	
}
