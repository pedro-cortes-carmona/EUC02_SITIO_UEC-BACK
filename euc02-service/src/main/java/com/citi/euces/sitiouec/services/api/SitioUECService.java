package com.citi.euces.sitiouec.services.api;

import java.io.IOException;
import java.text.ParseException;

import com.citi.euces.sitiouec.dto.AutoTasaGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.MensajeDTO;
import com.citi.euces.sitiouec.infra.dto.ArchivoDiaCargaDTO;
import com.citi.euces.sitiouec.infra.dto.BusquedaCampanaDetalleDTO;
import com.citi.euces.sitiouec.infra.dto.BusquedaCampanaResumenDTO;
import com.citi.euces.sitiouec.infra.dto.BusquedaSolicitudesAplicadasDTO;
import com.citi.euces.sitiouec.infra.dto.CargaDatosDTO;
import com.citi.euces.sitiouec.infra.dto.ComboDTO;
import com.citi.euces.sitiouec.infra.dto.CombosFacultamientoDTO;
import com.citi.euces.sitiouec.infra.dto.EstatusDTO;
import com.citi.euces.sitiouec.infra.dto.ListaComboDTO;
import com.citi.euces.sitiouec.infra.dto.ReporteBoletinesDTO;
import com.citi.euces.sitiouec.infra.dto.ReporteResumenDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

public interface SitioUECService {

	MensajeDTO generaReporteEspe(AutoTasaGerenciaBEDTO items) throws GenericException, IOException, ParseException;
	
	MensajeDTO cargaArchivoPlatino(String file) throws GenericException, IOException, ParseException;
	
	MensajeDTO cargaArchivoRegistroSolicitudes(String file) throws GenericException, IOException, ParseException;
	
	MensajeDTO cargaArchivoAutorizadores(String file, String fecha) throws GenericException, IOException, ParseException;
	
	MensajeDTO calculoRestantes(String fecha) throws GenericException, IOException, ParseException;
	
	MensajeDTO eliminarDiaCarga(String fecha) throws GenericException, IOException, ParseException;
	
	ArchivoDiaCargaDTO reporteArchivoDiaCarga(String fecha1, String fecha2) throws GenericException, IOException, ParseException;
	
	BusquedaSolicitudesAplicadasDTO busquedaSolicitudesAplicadasSinDatos(String fechaBusqueda)throws GenericException, IOException, ParseException;
	
	BusquedaCampanaDetalleDTO reporteCampanaDetalleOpe(String fecha1, String fecha2, Integer reporte)throws GenericException, IOException, ParseException ;
	
	BusquedaCampanaResumenDTO reporteCampanaResumen(String fecha1, String fecha2)throws GenericException, IOException, ParseException ;
	
	ReporteBoletinesDTO reporteBoletines(String estatus, Integer enfoque, String fechaInicial, String fechaFinal, Integer reporte)  throws GenericException, IOException, ParseException ;
	
	ReporteResumenDTO reporteResumen(String fecha1, String fecha2, Integer reporte)  throws GenericException, IOException, ParseException ;
	
	CargaDatosDTO transfiereDatos(String fecha)throws GenericException, IOException, ParseException ;
	
	CombosFacultamientoDTO getCombo()throws GenericException, IOException, ParseException ;
	
	CombosFacultamientoDTO getDivisiones(String region, String autDiv)throws GenericException, IOException, ParseException ;
	
	CombosFacultamientoDTO getAutDivisionales(String region)throws GenericException, IOException, ParseException ;
	
	CombosFacultamientoDTO getRegiones(String autRegion, String division)throws GenericException, IOException, ParseException ;
	
	ComboDTO getListaCombo()throws GenericException, IOException, ParseException ;
	
	EstatusDTO UpdateEstatus(String soeid, String idTasa, String estatus)throws GenericException, IOException, ParseException ;
}
