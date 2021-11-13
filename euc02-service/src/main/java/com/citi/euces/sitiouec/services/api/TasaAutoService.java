package com.citi.euces.sitiouec.services.api;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.citi.euces.sitiouec.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.dto.CargaCeteDTO;
import com.citi.euces.sitiouec.dto.CargaGridDTO;
import com.citi.euces.sitiouec.dto.EditarTasaAutoDTO;
import com.citi.euces.sitiouec.dto.EmailTasaEspecialDTO;
import com.citi.euces.sitiouec.dto.MensajeDTO;
import com.citi.euces.sitiouec.dto.ResendMailDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

public interface TasaAutoService {
	
	List<CargaGridDTO> getCargaGrid();
	
	List<CargaGridDTO> getInBuscarClick(String estatus, String contrato, String numeroCliente, String fechaSolicitud);
	
	List<AutoTasasDTO> getInBuscarClickSolicitudes(String estatus, String contrato, String numeroCliente, String fechaSolicitud);
	
	List<AutoTasasDTO> getInBuscarClickSolicitudesVersion2(String estatus, String contrato, String numeroCliente, String fechaSolicitud);
	
	List<CargaCeteDTO> getCargaCetes();
	
	List<EditarTasaAutoDTO> getInBuscarEditar(Long idAutoTasa);
	
	MensajeDTO updateInkRechazar(String soeidOpe, String justificacion, String observaWeb, String idTasaAuto, String fechaSolicitud) throws GenericException, IOException, ParseException;

	MensajeDTO updateInkRechazarCancelar(String soeidOpe, String fechaEstatus, String justificacion, String observacionWeb, String numAutoriEUC, String estatus, String idTasaAuto) throws GenericException, IOException, ParseException;
	
	MensajeDTO updateInkCancelar(String soeidOpe, String estatus, String justificacion, String observacionWeb, String numAutoriEUC, String idTasaAuto) throws GenericException, IOException, ParseException;
	
	MensajeDTO insertChkRecibir(String soeid, String online, String nombre, String action) throws GenericException, IOException, ParseException;
	
	List<ResendMailDTO> getCargaResendMail();
	
	EmailTasaEspecialDTO emailTasaEspecialDTO(String folio, String linkAutoriza, String linkRechaza, String autorizadores, String urlRedirect, String idAutorizadores) throws GenericException;
	
	MensajeDTO actualizaSolicitud(String soeidOpe, String idTasaAuto) throws GenericException, IOException, ParseException;
	
}
