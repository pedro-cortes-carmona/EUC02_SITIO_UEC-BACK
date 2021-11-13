package com.citi.euces.sitiouec.services.api;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.citi.euces.sitiouec.dto.ActualizarFechasFestivasDTO;
import com.citi.euces.sitiouec.dto.ActualizarSolicitudKPIDTO;
import com.citi.euces.sitiouec.dto.AsignacionesDTO;
import com.citi.euces.sitiouec.dto.AutoAutorizadorDTO;
import com.citi.euces.sitiouec.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.dto.AutoTasasEmailDTO;
import com.citi.euces.sitiouec.dto.AutorizadorElegidoDTO;
import com.citi.euces.sitiouec.dto.AutorizadoresElegidosEmailDTO;
import com.citi.euces.sitiouec.dto.CompletarInformacionKPIDTO;
import com.citi.euces.sitiouec.dto.FechasFestivasDTO;
import com.citi.euces.sitiouec.dto.FolioNumAutorizacionDTO;
import com.citi.euces.sitiouec.dto.ListaUsuariosSoeidDTO;
import com.citi.euces.sitiouec.dto.MontoPlazoTasaCampanaDTO;
import com.citi.euces.sitiouec.dto.PerCatParametrosDTO;
import com.citi.euces.sitiouec.dto.RegistrosTimeLineDTO;
import com.citi.euces.sitiouec.dto.ReporteAccuracyDTO;
import com.citi.euces.sitiouec.dto.ReporteEjecutivoKPIDTO;
import com.citi.euces.sitiouec.dto.ReporteWeekDTO;
import com.citi.euces.sitiouec.dto.RequestTasasTimeLinessDTO;
import com.citi.euces.sitiouec.dto.TasasDTO;
import com.citi.euces.sitiouec.dto.TasasReprocesoDTO;
import com.citi.euces.sitiouec.dto.TasasTimeLinessDTO;
import com.citi.euces.sitiouec.entities.FechasFestivas;

public interface TasasService {

	 List<TasasDTO> getContratosRepetidosCampana(String date1, String date2);
	
	 List<AutoTasasDTO> getContratosRepetidosOperativo(String date1, String date2);
	 
	 List<TasasDTO> getClientesRepetidosCampana(String date1, String date2);
	 
	 List<AutoTasasDTO> getClientesRepetidosOperativo(String date1, String date2);
	 
	 List<AutoTasasDTO> getRegistroObservacionesTasaOperativa(String date1, String date2);
	 
	 List<RegistrosTimeLineDTO> getRegistrosTimeLines(String date1, String date2);
	 
	 List<MontoPlazoTasaCampanaDTO> getMontoPlazoTasaRepetidoCampana(String date1, String date2);
	 
	 List<TasasReprocesoDTO> getReprocesosPorFecha(String date1, String date2);
	 
	 List<TasasTimeLinessDTO> getTimelinessPorFecha(String date1, String date2);
	 
	 Integer getVolumenPorFecha(String date1);
	 
	 List<ReporteAccuracyDTO> reporteDiasAccuracy(String date1, String date2) throws ParseException;
	 
	 List<ReporteAccuracyDTO> reporteTimesAccuracy(String date1, String date2) throws ParseException;
	 
	 Integer getVolumenAsignadas(String date1,String soeid);	 
	 
	 Integer getVolumenOperadas(String date1,String soeid);
	 
	 Integer getVolumenReproceso(String date1,String soeid);
	 
	 Integer getVolumenTimeliness(String date1,String soeid);
	 
	 Integer obtenerVolumen(String date1);
	 
	 Integer obtenerMonto(String date1);
	 
	 Integer obtenerVolTimeliness(String date1);
	 
	 Integer obtenerVolAccuracy(String date1);
	 
	 Integer obtenerOperadoresporDia(String date1);
	 
	 List<ReporteWeekDTO> generarReporteKPI(String date1) throws ParseException;
	 
	 List<ReporteWeekDTO> generarReporteKPISemanal(String date1) throws ParseException;
	 
	 Map<String, List<ReporteEjecutivoKPIDTO>> generarReporteEjecutivo(String date1, List<ListaUsuariosSoeidDTO> lsUsuariosSoeid) throws ParseException;
	 
	 List<CompletarInformacionKPIDTO> reporteComplementoKPI(String date1, String date2);
	 
	 List<FechasFestivasDTO> obtenerListaFechas();
	 
	 public void guardarFecha(FechasFestivas fechasFestivas) throws ParseException;
	 
	 public int borrarFecha(Long id);
	 
	 List<ListaUsuariosSoeidDTO> getUsuariosSoeid(String date1, String date2);
	 
	 AsignacionesDTO getNombreSoeidAsignacion(String soeid);
	 
	 public int complementarSolicitudKPI (ActualizarSolicitudKPIDTO solicitudDTO);
	 
	 public int borrarContratosRepetidos(List<Long> lsContratosRepetidos);
	 
	 public int borrarClienteRepetidos(List<Long> lsClienteRepetidos);
	 
	 public int borrarObservacionesDigitosEnTasa(List<Long> lsRegistros);
	 
	 public int editarFechasFestivas(ActualizarFechasFestivasDTO editarFechas) throws ParseException;
	 
	 public List<PerCatParametrosDTO> getParametros ();
	 
	 public int insertarTimeLiness (List<TasasTimeLinessDTO> lsTimeLiness);
	 
	 public int insertarReprocesos (List<TasasReprocesoDTO> lsReprocesos)  throws ParseException;
	 
	 public int eliminarReprocesos (List<Long> lsRegistros);
	 
	 public int eliminarTimeLiness (List<Long> lsRegistros);
	 
	 List<AutoTasasDTO> getAutoTasasSoeidAsignacionPendiente();
	 
	 List<ListaUsuariosSoeidDTO> getUsuariosSoeidActivos(String date) throws ParseException;
	 
	 List<AutoTasasEmailDTO> obtenerRegistrosSinAutorizacion();
	 
	 List<AutoAutorizadorDTO> ObtenerAutorizadoresDivisionales(String soeid, String division);
	 
	 AutorizadorElegidoDTO obtenerAutorizador(Long idAutoTasa);	 
	 
	 AsignacionesDTO getStatusEjecutivo(String soeid);
	 
	 List<FolioNumAutorizacionDTO> getFoliosAutorizacion (String numAutoriEuc);
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
