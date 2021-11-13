package com.citi.euces.sitiouec.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.citi.euces.sitiouec.dto.TasasDTO;
import com.citi.euces.sitiouec.dto.TasasReprocesoDTO;
import com.citi.euces.sitiouec.dto.TasasTimeLinessDTO;
import com.citi.euces.sitiouec.entities.AutoTasas;
import com.citi.euces.sitiouec.entities.FechasFestivas;
import com.citi.euces.sitiouec.entities.TasasReproceso;
import com.citi.euces.sitiouec.entities.TasasTimeLiness;
import com.citi.euces.sitiouec.infra.utils.MensajesUtils;
import com.citi.euces.sitiouec.infra.utils.StringUtils;
import com.citi.euces.sitiouec.repositories.AutoTasasRepository;
import com.citi.euces.sitiouec.repositories.FechasFestivasRepository;
import com.citi.euces.sitiouec.repositories.TasaAutoRepository;
import com.citi.euces.sitiouec.repositories.TasasRepository;
import com.citi.euces.sitiouec.repositories.TasasReprocesoRepository;
import com.citi.euces.sitiouec.repositories.TasasTimeLinessRepository;
import com.citi.euces.sitiouec.services.api.TasasService;

@Service
public class TasasServiceImpl implements TasasService {
		
	private static final Logger LOGGER = LogManager.getLogger(TasasServiceImpl.class);

	@Autowired
	private TasasRepository tasasService;	
	
	@Autowired
	private AutoTasasRepository autoTasasRepository;
	
	@Autowired
	private FechasFestivasRepository fechasFestivasRepository;
	
	@Autowired
	private TasasTimeLinessRepository tasasTimeLinessRepository;
	
	@Autowired
	private TasasReprocesoRepository tasasReprocesoRepository;
	
	@Autowired
	private TasaAutoRepository tasaAutoRepository;
	
	
	@Override
	public List<TasasDTO> getContratosRepetidosCampana(String date1, String date2) {

		List<TasasDTO> lsContratosRepetidosCampana = new ArrayList<>();
		List<TasasDTO> lsContratosRepetidosCampanaFinal = new ArrayList<>();
		TasasDTO tasasDTOFinal = new TasasDTO();

		lsContratosRepetidosCampana = tasasService.getContratosRepetidosCampana(date1, date2);
		
		for (TasasDTO tasasDTO : lsContratosRepetidosCampana) {
			
			tasasDTO.setFechaOperacion(tasasDTO.getFechaOpe()!=null?tasasDTO.getFechaOpe().toString():"");
			tasasDTOFinal = new TasasDTO();
			tasasDTOFinal = tasasDTO;
			lsContratosRepetidosCampanaFinal.add(tasasDTOFinal);
		}

		return lsContratosRepetidosCampanaFinal;
	}

	@Override
	public List<AutoTasasDTO> getContratosRepetidosOperativo(String date1, String date2) {

		List<AutoTasasDTO> lsContratosRepetidosOperativo = new ArrayList<>();
		List<AutoTasasDTO> lsContratosRepetidosOperativoFinal = new ArrayList<>();
		AutoTasasDTO autoTasasDTOFinal = new AutoTasasDTO();
		
		lsContratosRepetidosOperativo = tasasService.getContratosRepetidosOperativo(date1, date2);
		
		for (AutoTasasDTO autoTasasDTORecorre : lsContratosRepetidosOperativo) {
			
			autoTasasDTORecorre.setFechaSoliS(autoTasasDTORecorre.getFechaSoli()!=null?autoTasasDTORecorre.getFechaSoli().toString():"");
			autoTasasDTORecorre.setFechaEstatusS(autoTasasDTORecorre.getFechaEstatus()!=null?autoTasasDTORecorre.getFechaEstatus().toString():"");
			autoTasasDTORecorre.setFechaAuto(autoTasasDTORecorre.getFechaAutori()!=null?autoTasasDTORecorre.getFechaAutori().toString():"");
			autoTasasDTOFinal = new AutoTasasDTO();
			autoTasasDTOFinal = autoTasasDTORecorre;
			lsContratosRepetidosOperativoFinal.add(autoTasasDTOFinal);			
		}

		return lsContratosRepetidosOperativoFinal;
	}

	@Override
	public List<TasasDTO> getClientesRepetidosCampana(String date1, String date2) {

		List<TasasDTO> lsClientesRepTasas = new ArrayList<>();
		List<TasasDTO> lsClientesRepTasasFinal = new ArrayList<>();
		TasasDTO tasasDTOFinal = new TasasDTO();
		
		lsClientesRepTasas = tasasService.getClientesRepetidosCampana(date1, date2);

		for (TasasDTO tasasDTO : lsClientesRepTasas) {
			
			tasasDTO.setFechaOperacion(tasasDTO.getFechaOpe()!=null?tasasDTO.getFechaOpe().toString():"");
			tasasDTOFinal = new TasasDTO();
			tasasDTOFinal = tasasDTO;
			lsClientesRepTasasFinal.add(tasasDTOFinal);
		}

		
		
		return lsClientesRepTasasFinal;
	}

	@Override
	public List<AutoTasasDTO> getClientesRepetidosOperativo(String date1, String date2) {
		List<AutoTasasDTO> lsClientesRepOperativo = new ArrayList<>();
		List<AutoTasasDTO> lsClientesRepOperativoFinal = new ArrayList<>();
		AutoTasasDTO autoTasasDTOFinal = new AutoTasasDTO();

		lsClientesRepOperativo = tasasService.getClientesRepetidosOperativo(date1, date2);
		
		for (AutoTasasDTO autoTasasDTORecorre : lsClientesRepOperativo) {
			
			autoTasasDTORecorre.setFechaSoliS(autoTasasDTORecorre.getFechaSoli()!=null?autoTasasDTORecorre.getFechaSoli().toString():"");
			autoTasasDTORecorre.setFechaEstatusS(autoTasasDTORecorre.getFechaEstatus()!=null?autoTasasDTORecorre.getFechaEstatus().toString():"");
			autoTasasDTORecorre.setFechaAuto(autoTasasDTORecorre.getFechaAutori()!=null?autoTasasDTORecorre.getFechaAutori().toString():"");
			autoTasasDTOFinal = new AutoTasasDTO();
			autoTasasDTOFinal = autoTasasDTORecorre;
			lsClientesRepOperativoFinal.add(autoTasasDTOFinal);
		}

		return lsClientesRepOperativoFinal;
	}

	@Override
	public List<AutoTasasDTO> getRegistroObservacionesTasaOperativa(String date1, String date2) {
		List<AutoTasasDTO> lsRegistrosOb = new ArrayList<>();
		List<AutoTasasDTO> lsRegistrosFinal = new ArrayList<>();
		AutoTasasDTO autoTasasDTOfinal = new AutoTasasDTO();


		lsRegistrosOb = tasasService.getRegistroObservacionesTasaOperativa(date1, date2);
		
		
		for (AutoTasasDTO autoTasasDTO2 : lsRegistrosOb) {
			
			autoTasasDTO2.setFechaSoliS(autoTasasDTO2.getFechaSoli()!=null?autoTasasDTO2.getFechaSoli().toString():"");
			autoTasasDTOfinal = new AutoTasasDTO();
			autoTasasDTOfinal = autoTasasDTO2;
			lsRegistrosFinal.add(autoTasasDTOfinal);
			
		}
		
		return lsRegistrosFinal;
	}

	@Override
	public List<RegistrosTimeLineDTO> getRegistrosTimeLines(String date1, String date2) {

		List<AutoTasasDTO> lsContratosRepetidosOperativo = new ArrayList<>();
		RegistrosTimeLineDTO registrosTimeLineDTO = null;
		List<RegistrosTimeLineDTO> lsRegistrosTime = new ArrayList<RegistrosTimeLineDTO>();

		lsContratosRepetidosOperativo = tasasService.getRegistrosTimeLines(date1, date2);

		for (AutoTasasDTO autoTasasDTO : lsContratosRepetidosOperativo) {
			registrosTimeLineDTO = new RegistrosTimeLineDTO();
			registrosTimeLineDTO.setIdTasa(autoTasasDTO.getIdTasaAuto());
			registrosTimeLineDTO.setFechaEstatus(autoTasasDTO.getFechaEstatus().toString());
			registrosTimeLineDTO.setNumCliente(autoTasasDTO.getNumCliente());
			registrosTimeLineDTO.setContrato(autoTasasDTO.getContrato());
			registrosTimeLineDTO.setObservaWeb(autoTasasDTO.getObservaWeb());
			registrosTimeLineDTO.setAsginadoA(autoTasasDTO.getAsginadoA());
			registrosTimeLineDTO.setOperadorPor(autoTasasDTO.getOperadorPor());
			registrosTimeLineDTO.setEstatusTasas(autoTasasDTO.getEstatusTasas());
			registrosTimeLineDTO.setFechaCaptura(autoTasasDTO.getFechaCaptura().toString());
			registrosTimeLineDTO.setFechaAutori(autoTasasDTO.getFechaAutori()!=null?autoTasasDTO.getFechaAutori().toString():null);
			registrosTimeLineDTO.setCampanaWeb(autoTasasDTO.getCampanaWeb());
			registrosTimeLineDTO.setSoeidRep(autoTasasDTO.getSoeidRep()!=null?autoTasasDTO.getSoeidRep():null);
			lsRegistrosTime.add(registrosTimeLineDTO);
		}

		return lsRegistrosTime;
	}

	@Override
	public List<MontoPlazoTasaCampanaDTO> getMontoPlazoTasaRepetidoCampana(String date1, String date2) {

		List<TasasDTO> lsMontoPlazoRepetidos = new ArrayList<>();
		MontoPlazoTasaCampanaDTO montoPlazo = null;

		List<MontoPlazoTasaCampanaDTO> lsMontoPlazo = new ArrayList<>();

		lsMontoPlazoRepetidos = tasasService.getMontoPlazoTasaRepetidoCampana(date1, date2);

		for (TasasDTO tasasDTO : lsMontoPlazoRepetidos) {
			montoPlazo = new MontoPlazoTasaCampanaDTO();
			montoPlazo.setIdTasa(tasasDTO.getIdTasa());
			montoPlazo.setFechaOpe(StringUtils.formatDateString("dd/MM/yyyy", tasasDTO.getFechaOpe()));
			montoPlazo.setSuc_solic(tasasDTO.getSuc_solic());
			montoPlazo.setMonto(tasasDTO.getMonto());
			montoPlazo.setPlazo(tasasDTO.getPlazo());
			montoPlazo.setEstatus(tasasDTO.getEstatus());
			montoPlazo.setNum_cte(tasasDTO.getNum_cte());
			montoPlazo.setNomCliente(tasasDTO.getNomCliente());
			montoPlazo.setContrato(tasasDTO.getContrato());
			montoPlazo.setOperadoPor(tasasDTO.getOperadoPor());
			montoPlazo.setCampanaWeb(tasasDTO.getCampanaWeb());
			montoPlazo.setObservaWeb(tasasDTO.getObservaWeb());
			montoPlazo.setSoeidRep(tasasDTO.getSoeidRep());
			montoPlazo.setNumAutoriUec(tasasDTO.getNumAutoriUec());
			montoPlazo.setNomEjecutivo(tasasDTO.getNomEjecutivo());
			montoPlazo.setTasaAutori(tasasDTO.getTasaAutori());
			lsMontoPlazo.add(montoPlazo);
		}

		return lsMontoPlazo;
	}

	@Override
	public List<TasasReprocesoDTO> getReprocesosPorFecha(String date1, String date2) {

		List<TasasReprocesoDTO> lsReprocesos = new ArrayList<>();

		lsReprocesos = tasasService.getReprocesosPorFecha(date1, date2);

		return lsReprocesos;
	}

	@Override
	public List<TasasTimeLinessDTO> getTimelinessPorFecha(String date1, String date2) {

		List<TasasTimeLinessDTO> lsTimeLiness = new ArrayList<>();

		lsTimeLiness = tasasService.getTimelinessPorFecha(date1, date2);

		return lsTimeLiness;
	}

	@Override
	public Integer getVolumenPorFecha(String date1) {

		Integer count = tasasService.getVolumenPorFecha(date1);

		return count;
	}

	@Override
	public List<ReporteAccuracyDTO> reporteDiasAccuracy(String date1, String date2) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		double cntRepro = 0;

		double meta = 0;

		double porcenAccuracy = 0;

		double cntTimeliness = 0;

		double porcenTimeliness = 0;

		double volumen = 0;

		List<TasasReprocesoDTO> lsReprocesos = new ArrayList<>();

		List<TasasTimeLinessDTO> lsTimeLiness = new ArrayList<>();

		List<ReporteAccuracyDTO> lsAccuracy = new ArrayList<>();

		ReporteAccuracyDTO accuracyDTO = null;

		lsTimeLiness = tasasService.getTimelinessPorFecha(date1, date2);

		lsReprocesos = tasasService.getReprocesosPorFecha(date1, date2);

		cntRepro = lsReprocesos.size();

		cntTimeliness = lsTimeLiness.size();

		/**
		 * Primero determinar número de dias que abarca el reporte
		 */

		long days = diffHours(date1, date2);

		for (int i = 0; i < days; i++) {

			accuracyDTO = new ReporteAccuracyDTO();

			/**
			 * Pasamos las fechas a Date para sumar los dias
			 */
			Date firstDate = format.parse(date1);
			Date secondtDate = format.parse(date2);
			firstDate = addDays(firstDate, i);
			secondtDate = addDays(secondtDate, i);

			/**
			 * Regresamos las fechas a String para hacer la consultas
			 */

			String f1 = format.format(firstDate);
			String f2 = format.format(secondtDate);

			/**
			 * En la primera iteraccion manda las fechas tal cual
			 */
			lsReprocesos = tasasService.getReprocesosPorFecha(f1, f2);
			
			LOGGER.info("Query - Method -  reporteDiasAccuracy" + " lsReprocesos " + lsReprocesos.size());		
			
			lsTimeLiness = tasasService.getTimelinessPorFecha(f1, f2);
			
			LOGGER.info("Query - Method -  reporteDiasAccuracy" + " lsTimeLiness " + lsTimeLiness.size());		
			
			volumen = tasasService.getVolumenPorFecha(f1);
			
			LOGGER.info("Query - Method -  reporteDiasAccuracy" + "  volumen " + volumen);		
			
			
			cntRepro = lsReprocesos.size();
			cntTimeliness = lsTimeLiness.size();

			if (volumen == 0) {
				LOGGER.info("Query - Method -  reporteDiasAccuracy" + "  volumen == 0 " + volumen);
				porcenAccuracy = meta = porcenTimeliness = 0;
				LOGGER.info("Query - Method -  reporteDiasAccuracy" + "  porcenAccuracy " + porcenAccuracy);
			} else {
				porcenAccuracy = (volumen - cntRepro) / volumen;
				meta = .99;
				LOGGER.info("Query - Method -  reporteDiasAccuracy" + "  porcenAccuracy " + porcenAccuracy);
				porcenTimeliness = (volumen - cntTimeliness) / volumen;
				LOGGER.info("Query - Method -  reporteDiasAccuracy" + "  porcenTimeliness " + porcenTimeliness);
				meta = .99;
			}

			/**
			 * Llenamos el Bean Correspondiente
			 */
			accuracyDTO.setFecha(f1);
			accuracyDTO.setVolumen(volumen);
			accuracyDTO.setCntRepro(cntRepro);
			accuracyDTO.setMeta(meta);
			accuracyDTO.setPorcenAccuracy(porcenAccuracy);

			lsAccuracy.add(accuracyDTO);

			cntRepro = 0;
			cntTimeliness = 0;
			volumen = 0;

		}

		return lsAccuracy;
	}

	@Override
	public List<ReporteAccuracyDTO> reporteTimesAccuracy(String date1, String date2) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		double cntRepro = 0;

		double meta = 0;

		double porcenAccuracy = 0;

		double cntTimeliness = 0;

		double porcenTimeliness = 0;

		double volumen = 0;

		List<TasasReprocesoDTO> lsReprocesos = new ArrayList<>();

		List<TasasTimeLinessDTO> lsTimeLiness = new ArrayList<>();

		List<ReporteAccuracyDTO> lsDiasTimesAccuracy = new ArrayList<>();

		ReporteAccuracyDTO accuracyDTO = null;

		lsTimeLiness = tasasService.getTimelinessPorFecha(date1, date2);

		lsReprocesos = tasasService.getReprocesosPorFecha(date1, date2);

		cntRepro = lsReprocesos.size();

		cntTimeliness = lsTimeLiness.size();

		/**
		 * Primero determinar número de dias que abarca el reporte
		 */

		long days = diffHours(date1, date2);

		for (int i = 0; i < days; i++) {

			accuracyDTO = new ReporteAccuracyDTO();

			/**
			 * Pasamos las fechas a Date para sumar los dias
			 */
			Date firstDate = format.parse(date1);
			Date secondtDate = format.parse(date2);
			firstDate = addDays(firstDate, i);
			secondtDate = addDays(secondtDate, i);

			/**
			 * Regresamos las fechas a String para hacer la consultas
			 */

			String f1 = format.format(firstDate);
			String f2 = format.format(secondtDate);

			/**
			 * En la primera iteraccion manda las fechas tal cual
			 */
			
			lsReprocesos = tasasService.getReprocesosPorFecha(f1, f2);
			LOGGER.info("Query - Method -  reporteDiasAccuracy" + " lsReprocesos " + lsReprocesos.size());
			
			lsTimeLiness = tasasService.getTimelinessPorFecha(f1, f2);
			LOGGER.info("Query - Method -  reporteDiasAccuracy" + " lsReprocesos " + lsReprocesos.size());
			
			volumen = tasasService.getVolumenPorFecha(f1);
			LOGGER.info("Query - Method -  reporteDiasAccuracy" + " lsReprocesos " + lsReprocesos.size());

			cntRepro = lsReprocesos.size();
			cntTimeliness = lsTimeLiness.size();

			if (volumen == 0) {
				porcenAccuracy = meta = porcenTimeliness = 0;
				LOGGER.info("Query - Method -  reporteDiasAccuracy" + " porcenAccuracy " + porcenAccuracy);
			} else {
				porcenAccuracy = (volumen - cntRepro) / volumen;
				LOGGER.info("Query - Method -  reporteDiasAccuracy" + " porcenAccuracy " + porcenAccuracy);
				meta = .99;
				porcenTimeliness = (volumen - cntTimeliness) / volumen;
				LOGGER.info("Query - Method -  reporteDiasAccuracy" + " porcenTimeliness " + porcenTimeliness);
				meta = .99;
			}

			/**
			 * Llenamos el Bean Correspondiente
			 */
			accuracyDTO.setFecha(f1);
			accuracyDTO.setVolumen(volumen);
			accuracyDTO.setCntTimeliness(cntTimeliness);
			accuracyDTO.setMeta(meta);
			accuracyDTO.setPorcenTimeliness(porcenTimeliness);

			lsDiasTimesAccuracy.add(accuracyDTO);

			cntRepro = 0;
			cntTimeliness = 0;
			volumen = 0;

		}

		return lsDiasTimesAccuracy;
	}

	public static long diffHours(String date1, String date2) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = sdf.parse(date1);
		Date secondDate = sdf.parse(date2);

		long diffMilies = Math.abs(secondDate.getTime() - firstDate.getTime());
		long diff = TimeUnit.DAYS.convert(diffMilies, TimeUnit.MILLISECONDS);

		return diff;

	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();

	}

	@Override
	public Integer getVolumenAsignadas(String date1, String soeid) {
		Integer count = tasasService.getVolumenAsignadas(date1, soeid);

		return count;
	}

	@Override
	public Integer getVolumenOperadas(String date1, String soeid) {
		Integer count = tasasService.getVolumenOperadas(date1, soeid);

		return count;
	}

	@Override
	public Integer getVolumenReproceso(String date1, String soeid) {

		Integer count = tasasService.getVolumenReproceso(date1, soeid);

		return count;

	}

	@Override
	public Integer getVolumenTimeliness(String date1, String soeid) {

		Integer count = tasasService.getVolumenTimeliness(date1, soeid);

		return count;

	}

	@Override
	public Integer obtenerVolumen(String date1) {

		Integer volumen = tasasService.obtenerVolumen(date1);

		return volumen;
	}

	@Override
	public Integer obtenerMonto(String date1) {

		Integer monto = tasasService.obtenerMonto(date1);

		return monto;
	}

	@Override
	public Integer obtenerVolTimeliness(String date1) {

		Integer volumen = tasasService.obtenerVolTimeliness(date1);

		return volumen;
	}

	@Override
	public Integer obtenerVolAccuracy(String date1) {

		Integer volumen = tasasService.obtenerVolAccuracy(date1);

		return volumen;
	}

	@Override
	public Integer obtenerOperadoresporDia(String date1) {

		Integer operadores = tasasService.obtenerOperadoresporDia(date1);

		return operadores;

	}

	@Override
	public List<ReporteWeekDTO> generarReporteKPI(String date1) throws ParseException {
		
	
		/**
		 * Obtener Porcentaje TimeLines 
		 */
		double timeLiness=0.00;
		double acuraccy=0.00;
		
		List<PerCatParametrosDTO>  lsParametros = new ArrayList<>();
		
		lsParametros = tasasService.getParametros();
		
		for (PerCatParametrosDTO perCatParametrosDTO : lsParametros) {			
			
			if(perCatParametrosDTO.getParametroNom().equals("TIMELINES")) {
				timeLiness = Double.parseDouble(perCatParametrosDTO.getParametroValor());	
			}
			if( perCatParametrosDTO.getParametroNom().equals("ACCURACY")) {
				acuraccy =Double.parseDouble(perCatParametrosDTO.getParametroValor());	
			}			
		}
		
		LOGGER.info("Valores de la tabla de parametros para timeLiness " +" " + timeLiness);
		LOGGER.info("Valores de la tabla de parametros para  acuraccy " +" " + acuraccy);

		
		
		List<ReporteWeekDTO> listaWeek = new ArrayList<>();
		List<String> fechas = new ArrayList<>();
		ReporteWeekDTO semanaDia = new ReporteWeekDTO();
		ReporteWeekDTO semanaVolumen = new ReporteWeekDTO();
		ReporteWeekDTO semanaMonto = new ReporteWeekDTO();
		ReporteWeekDTO semanaPercenTimeliness = new ReporteWeekDTO();
		ReporteWeekDTO semanaMetaTimeliness = new ReporteWeekDTO();
		ReporteWeekDTO semanaFueraTiempo = new ReporteWeekDTO();
		ReporteWeekDTO semanaPercnetAccuracy = new ReporteWeekDTO();
		ReporteWeekDTO semanaMetaAccuracy = new ReporteWeekDTO();
		ReporteWeekDTO semanaReproceso = new ReporteWeekDTO();
		
		ReporteWeekDTO semanaMetaQuejas = new ReporteWeekDTO();
		ReporteWeekDTO semanaNoQuejas = new ReporteWeekDTO();
		ReporteWeekDTO semanaCapacityPlan = new ReporteWeekDTO();
		ReporteWeekDTO semanaCapacityMax = new ReporteWeekDTO();
		ReporteWeekDTO semanaFTE = new ReporteWeekDTO();

		/**
		 * El usuario selecciona una fecha sábado y a esa fecha se le debe sumar 2 dias
		 * - Lunes 3 dias - Martes 4 dias - Miercoles 5 dias - Jueves 6 dias - Viernes
		 *
		 */

		/**
		 * Pasamos las fechas a Date para sumar los dias
		 */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(date1);
		Date firstDate = addDays(date, 0);
		Date secondDate = addDays(date, 2);
		Date thirdDate = addDays(date, 3);
		Date fourDate = addDays(date, 4);
		Date fivetDate = addDays(date, 5);
		Date sixtDate = addDays(date, 6);

		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(firstDate);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(secondDate);

		Calendar cal3 = Calendar.getInstance();
		cal3.setTime(thirdDate);

		Calendar cal4 = Calendar.getInstance();
		cal4.setTime(fourDate);

		Calendar cal5 = Calendar.getInstance();
		cal5.setTime(fivetDate);

		Calendar cal6 = Calendar.getInstance();
		cal6.setTime(sixtDate);

		/**
		 * Regreso la fechas a String con la suma de los dias correspondientes para
		 * hacer las busquedas en base de datos
		 */
		String fecha1 = format.format(firstDate);
		String fecha2 = format.format(secondDate);
		String fecha3 = format.format(thirdDate);
		String fecha4 = format.format(fourDate);
		String fecha5 = format.format(fivetDate);
		String fecha6 = format.format(sixtDate);

		semanaDia.setConcepto("Dia del Mes");
		semanaDia.setSab(cal1.get(Calendar.DAY_OF_MONTH));
		semanaDia.setLun(cal2.get(Calendar.DAY_OF_MONTH));
		semanaDia.setMar(cal3.get(Calendar.DAY_OF_MONTH));
		semanaDia.setMie(cal4.get(Calendar.DAY_OF_MONTH));
		semanaDia.setJue(cal5.get(Calendar.DAY_OF_MONTH));
		semanaDia.setVie(cal6.get(Calendar.DAY_OF_MONTH));

		semanaVolumen.setConcepto("Volumen");
		semanaVolumen.setSab(tasasService.obtenerVolumen(fecha1));
		semanaVolumen.setLun(tasasService.obtenerVolumen(fecha2));
		semanaVolumen.setMar(tasasService.obtenerVolumen(fecha3));
		semanaVolumen.setMie(tasasService.obtenerVolumen(fecha4));
		semanaVolumen.setJue(tasasService.obtenerVolumen(fecha5));
		semanaVolumen.setVie(tasasService.obtenerVolumen(fecha6));
		semanaVolumen.setSem(semanaVolumen.getLun() + semanaVolumen.getMar() + semanaVolumen.getMie()
				+ semanaVolumen.getJue() + semanaVolumen.getVie());

		semanaMonto.setConcepto("Monto");
		semanaMonto.setSab(tasasService.obtenerMonto(fecha1));
		semanaMonto.setLun(tasasService.obtenerMonto(fecha2));
		semanaMonto.setMar(tasasService.obtenerMonto(fecha3));
		semanaMonto.setMie(tasasService.obtenerMonto(fecha4));
		semanaMonto.setJue(tasasService.obtenerMonto(fecha5));
		semanaMonto.setVie(tasasService.obtenerMonto(fecha6));
		semanaMonto.setSem(semanaMonto.getLun() + semanaMonto.getMar() + semanaMonto.getMie() + semanaMonto.getJue()
				+ semanaMonto.getVie());

		semanaMetaTimeliness.setConcepto("Meta");
		semanaMetaTimeliness.setSab(99.95);
		semanaMetaTimeliness.setLun(99.95);
		semanaMetaTimeliness.setMar(99.95);
		semanaMetaTimeliness.setMie(99.95);
		semanaMetaTimeliness.setJue(99.95);
		semanaMetaTimeliness.setVie(99.95);

		semanaFueraTiempo.setConcepto("Fuera de Tiempo");
		semanaFueraTiempo.setSab(tasasService.obtenerVolTimeliness(fecha1));
		semanaFueraTiempo.setLun(tasasService.obtenerVolTimeliness(fecha2));
		semanaFueraTiempo.setMar(tasasService.obtenerVolTimeliness(fecha3));
		semanaFueraTiempo.setMie(tasasService.obtenerVolTimeliness(fecha4));
		semanaFueraTiempo.setJue(tasasService.obtenerVolTimeliness(fecha5));
		semanaFueraTiempo.setVie(tasasService.obtenerVolTimeliness(fecha6));
		semanaFueraTiempo.setSem(semanaFueraTiempo.getLun() + semanaFueraTiempo.getMar() + semanaFueraTiempo.getMie()
				+ semanaFueraTiempo.getJue() + semanaFueraTiempo.getVie());

		
		semanaPercenTimeliness.setConcepto("% TimeLiness");
		if (semanaFueraTiempo.getSab() > 0) {
			semanaPercenTimeliness.setSab((1 - (semanaFueraTiempo.getSab() / semanaVolumen.getSab())) * timeLiness);
		} else {
			semanaPercenTimeliness.setSab(100);
		}

		if (semanaFueraTiempo.getLun() > 0) {
			semanaPercenTimeliness.setLun((1 - (semanaFueraTiempo.getLun() / semanaVolumen.getLun())) * timeLiness);
		} else {
			semanaPercenTimeliness.setLun(100);
		}

		if (semanaFueraTiempo.getMar() > 0) {
			semanaPercenTimeliness.setMar((1 - (semanaFueraTiempo.getMar() / semanaVolumen.getMar())) * timeLiness);
		} else {
			semanaPercenTimeliness.setMar(100);
		}

		if (semanaFueraTiempo.getMie() > 0) {
			semanaPercenTimeliness.setMie((1 - (semanaFueraTiempo.getMie() / semanaVolumen.getMie())) * timeLiness);
		} else {
			semanaPercenTimeliness.setMie(100);
		}

		if (semanaFueraTiempo.getJue() > 0) {
			semanaPercenTimeliness.setJue((1 - (semanaFueraTiempo.getJue() / semanaVolumen.getJue())) * timeLiness);
		} else {
			semanaPercenTimeliness.setJue(100);
		}

		if (semanaFueraTiempo.getVie() > 0) {
			semanaPercenTimeliness.setVie((1 - (semanaFueraTiempo.getVie() / semanaVolumen.getVie())) * timeLiness);
		} else {
			semanaPercenTimeliness.setVie(100);
		}

		if (semanaFueraTiempo.getSem() > 0) {
			semanaPercenTimeliness.setSem((1 - (semanaFueraTiempo.getSem() / semanaVolumen.getSem())) * timeLiness);
		} else {
			semanaPercenTimeliness.setSem(100);
		}

		semanaReproceso.setConcepto("Reproceso");
		semanaReproceso.setSab(tasasService.obtenerVolAccuracy(fecha1));
		semanaReproceso.setLun(tasasService.obtenerVolAccuracy(fecha2));
		semanaReproceso.setMar(tasasService.obtenerVolAccuracy(fecha3));
		semanaReproceso.setMie(tasasService.obtenerVolAccuracy(fecha4));
		semanaReproceso.setJue(tasasService.obtenerVolAccuracy(fecha5));
		semanaReproceso.setVie(tasasService.obtenerVolAccuracy(fecha6));
		semanaReproceso.setSem(semanaReproceso.getLun() + semanaReproceso.getMar() + semanaReproceso.getMie()
				+ semanaReproceso.getJue() + semanaReproceso.getVie());

		semanaMetaAccuracy.setConcepto("Meta");
		semanaMetaAccuracy.setSab(99.00);
		semanaMetaAccuracy.setLun(99.00);
		semanaMetaAccuracy.setMar(99.00);
		semanaMetaAccuracy.setMie(99.00);
		semanaMetaAccuracy.setJue(99.00);
		semanaMetaAccuracy.setVie(99.00);

		semanaPercnetAccuracy.setConcepto("% Accuracy");

		if (semanaReproceso.getSab() > 0) {
			semanaPercnetAccuracy.setSab(1 - (semanaReproceso.getSab() / semanaVolumen.getSab()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setSab(100);
		}
		
		
		if (semanaReproceso.getLun() > 0) {
			semanaPercnetAccuracy.setLun(1 - (semanaReproceso.getLun() / semanaVolumen.getLun()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setLun(100);
		}
		
		if (semanaReproceso.getMar() > 0) {
			semanaPercnetAccuracy.setMar(1 - (semanaReproceso.getMar() / semanaVolumen.getMar()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setMar(100);
		}
		
		if (semanaReproceso.getMie() > 0) {
			semanaPercnetAccuracy.setMie(1 - (semanaReproceso.getMie() / semanaVolumen.getMie()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setMie(100);
		}
		
		
		if (semanaReproceso.getJue() > 0) {
			semanaPercnetAccuracy.setJue(1 - (semanaReproceso.getJue() / semanaVolumen.getJue()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setJue(100);
		}
		
		
		if (semanaReproceso.getVie() > 0) {
			semanaPercnetAccuracy.setVie(1 - (semanaReproceso.getVie() / semanaVolumen.getVie()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setVie(100);
		}
		
		if (semanaReproceso.getSem() > 0) {
			semanaPercnetAccuracy.setSem(1 - (semanaReproceso.getSem() / semanaVolumen.getSem()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setSem(100);
		}
		
		
		semanaFTE.setConcepto("FTE");
		semanaFTE.setSab(tasasService.obtenerOperadoresporDia(fecha1));
		semanaFTE.setLun(tasasService.obtenerOperadoresporDia(fecha2));
		semanaFTE.setMar(tasasService.obtenerOperadoresporDia(fecha3));
		semanaFTE.setMie(tasasService.obtenerOperadoresporDia(fecha4));
		semanaFTE.setJue(tasasService.obtenerOperadoresporDia(fecha5));
		semanaFTE.setVie(tasasService.obtenerOperadoresporDia(fecha6));
		
	
		semanaFTE.setSab(semanaFTE.getSab()>0?semanaFTE.getSab():0);
		semanaFTE.setLun(semanaFTE.getLun()>0?semanaFTE.getLun():0);
		semanaFTE.setMar(semanaFTE.getMar()>0?semanaFTE.getMar():0);
		semanaFTE.setMie(semanaFTE.getMie()>0?semanaFTE.getMie():0);
		semanaFTE.setJue(semanaFTE.getJue()>0?semanaFTE.getJue():0);
		semanaFTE.setVie(semanaFTE.getVie()>0?semanaFTE.getVie():0);
		
		semanaFTE.setSem(semanaFTE.getSab()+semanaFTE.getLun()+semanaFTE.getMar()+semanaFTE.getMie()+
				semanaFTE.getJue()+semanaFTE.getVie());
		
		
		semanaCapacityMax.setConcepto("Capacity Max");
		semanaCapacityMax.setSab(semanaFTE.getSab()*96);
		semanaCapacityMax.setLun(semanaFTE.getLun()*96);
		semanaCapacityMax.setMar(semanaFTE.getMar()*96);
		semanaCapacityMax.setMie(semanaFTE.getMie()*96);
		semanaCapacityMax.setJue(semanaFTE.getJue()*96);
		semanaCapacityMax.setVie(semanaFTE.getVie()*96);
		
		semanaCapacityMax.setSem(semanaCapacityMax.getSab()+semanaCapacityMax.getLun()+semanaCapacityMax.getMar()+
				semanaCapacityMax.getMie()+semanaCapacityMax.getJue()+semanaCapacityMax.getVie());
		
		
		
		semanaCapacityPlan.setConcepto("Capacity Plan");
		
		if (semanaFTE.getSab() > 0) { semanaCapacityPlan.setSab((semanaVolumen.getSab() / semanaCapacityMax.getSab()) * 100); }
		if (semanaFTE.getLun() > 0) { semanaCapacityPlan.setLun((semanaVolumen.getLun() / semanaCapacityMax.getLun()) * 100); }
		if (semanaFTE.getMar() > 0) { semanaCapacityPlan.setMar((semanaVolumen.getMar() / semanaCapacityMax.getMar()) * 100); }
		if (semanaFTE.getMie() > 0) { semanaCapacityPlan.setMie((semanaVolumen.getMie() / semanaCapacityMax.getMie()) * 100); }
		if (semanaFTE.getJue() > 0) { semanaCapacityPlan.setJue((semanaVolumen.getJue() / semanaCapacityMax.getJue()) * 100); }
		if (semanaFTE.getVie() > 0) { semanaCapacityPlan.setVie((semanaVolumen.getVie() / semanaCapacityMax.getVie()) * 100); }
		if (semanaFTE.getSem() > 0) { semanaCapacityPlan.setSem((semanaVolumen.getSem() / semanaCapacityMax.getSem()) * 100); }
		
		listaWeek.add(semanaDia);
        listaWeek.add(semanaVolumen);
        listaWeek.add(semanaMonto);
        listaWeek.add(semanaPercenTimeliness);
        listaWeek.add(semanaMetaTimeliness);
        listaWeek.add(semanaFueraTiempo);
        listaWeek.add(semanaPercnetAccuracy);
        listaWeek.add(semanaMetaAccuracy);
        listaWeek.add(semanaReproceso);        
        listaWeek.add(semanaCapacityPlan);
        listaWeek.add(semanaCapacityMax);
        listaWeek.add(semanaFTE);
		
		

		return listaWeek;
	}



	@Override
	public List<ReporteWeekDTO> generarReporteKPISemanal(String date1) throws ParseException {
		
		/**
		 * Obtener Porcentaje TimeLines 
		 */
		double timeLiness=0.00;
		double acuraccy=0.00;
		
		List<PerCatParametrosDTO>  lsParametros = new ArrayList<>();
		
		lsParametros = tasasService.getParametros();
		
		for (PerCatParametrosDTO perCatParametrosDTO : lsParametros) {			
			
			if(perCatParametrosDTO.getParametroNom().equals("TIMELINES")) {
				timeLiness = Double.parseDouble(perCatParametrosDTO.getParametroValor());	
			}
			if( perCatParametrosDTO.getParametroNom().equals("ACCURACY")) {
				acuraccy =Double.parseDouble(perCatParametrosDTO.getParametroValor());	
			}			
		}
		
		LOGGER.info("Valores de la tabla de parametros para timeLiness " +" " + timeLiness);
		LOGGER.info("Valores de la tabla de parametros para  acuraccy " +" " + acuraccy);

		
		List<ReporteWeekDTO> listaWeek = new ArrayList<>();
		List<String> fechas = new ArrayList<>();
		ReporteWeekDTO semanaDia = new ReporteWeekDTO();
		ReporteWeekDTO semanaVolumen = new ReporteWeekDTO();
		ReporteWeekDTO semanaMonto = new ReporteWeekDTO();
		ReporteWeekDTO semanaPercenTimeliness = new ReporteWeekDTO();
		ReporteWeekDTO semanaMetaTimeliness = new ReporteWeekDTO();
		ReporteWeekDTO semanaFueraTiempo = new ReporteWeekDTO();
		ReporteWeekDTO semanaPercnetAccuracy = new ReporteWeekDTO();
		ReporteWeekDTO semanaMetaAccuracy = new ReporteWeekDTO();
		ReporteWeekDTO semanaReproceso = new ReporteWeekDTO();
		ReporteWeekDTO semanaPercentQuejas = new ReporteWeekDTO();
		ReporteWeekDTO semanaMetaQuejas = new ReporteWeekDTO();
		ReporteWeekDTO semanaNoQuejas = new ReporteWeekDTO();
		ReporteWeekDTO semanaCapacityPlan = new ReporteWeekDTO();
		ReporteWeekDTO semanaCapacityMax = new ReporteWeekDTO();
		ReporteWeekDTO semanaFTE = new ReporteWeekDTO();

		/**
		 * El usuario selecciona una fecha sábado y a esa fecha se le debe sumar 2 dias
		 * - Lunes 3 dias - Martes 4 dias - Miercoles 5 dias - Jueves 6 dias - Viernes
		 *
		 */

		/**
		 * Pasamos las fechas a Date para sumar los dias
		 */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(date1);
		Date firstDate = addDays(date, 0);
		Date secondDate = addDays(date, 2);
		Date thirdDate = addDays(date, 3);
		Date fourDate = addDays(date, 4);
		Date fivetDate = addDays(date, 5);
		Date sixtDate = addDays(date, 6);

		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(firstDate);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(secondDate);

		Calendar cal3 = Calendar.getInstance();
		cal3.setTime(thirdDate);

		Calendar cal4 = Calendar.getInstance();
		cal4.setTime(fourDate);

		Calendar cal5 = Calendar.getInstance();
		cal5.setTime(fivetDate);

		Calendar cal6 = Calendar.getInstance();
		cal6.setTime(sixtDate);

		/**
		 * Regreso la fechas a String con la suma de los dias correspondientes para
		 * hacer las busquedas en base de datos
		 */
		String fecha1 = format.format(firstDate);
		String fecha2 = format.format(secondDate);
		String fecha3 = format.format(thirdDate);
		String fecha4 = format.format(fourDate);
		String fecha5 = format.format(fivetDate);
		String fecha6 = format.format(sixtDate);

		semanaDia.setConcepto("Dia del Mes");
		semanaDia.setSab(cal1.get(Calendar.DAY_OF_MONTH));
		semanaDia.setLun(cal2.get(Calendar.DAY_OF_MONTH));
		semanaDia.setMar(cal3.get(Calendar.DAY_OF_MONTH));
		semanaDia.setMie(cal4.get(Calendar.DAY_OF_MONTH));
		semanaDia.setJue(cal5.get(Calendar.DAY_OF_MONTH));
		semanaDia.setVie(cal6.get(Calendar.DAY_OF_MONTH));

		semanaVolumen.setConcepto("Volumen");
		semanaVolumen.setSab(tasasService.obtenerVolumen(fecha1));
		semanaVolumen.setLun(tasasService.obtenerVolumen(fecha2));
		semanaVolumen.setMar(tasasService.obtenerVolumen(fecha3));
		semanaVolumen.setMie(tasasService.obtenerVolumen(fecha4));
		semanaVolumen.setJue(tasasService.obtenerVolumen(fecha5));
		semanaVolumen.setVie(tasasService.obtenerVolumen(fecha6));
		semanaVolumen.setSem(semanaVolumen.getLun() + semanaVolumen.getMar() + semanaVolumen.getMie()
				+ semanaVolumen.getJue() + semanaVolumen.getVie());

		semanaMonto.setConcepto("Monto");
		semanaMonto.setSab(tasasService.obtenerMonto(fecha1));
		semanaMonto.setLun(tasasService.obtenerMonto(fecha2));
		semanaMonto.setMar(tasasService.obtenerMonto(fecha3));
		semanaMonto.setMie(tasasService.obtenerMonto(fecha4));
		semanaMonto.setJue(tasasService.obtenerMonto(fecha5));
		semanaMonto.setVie(tasasService.obtenerMonto(fecha6));
		semanaMonto.setSem(semanaMonto.getLun() + semanaMonto.getMar() + semanaMonto.getMie() + semanaMonto.getJue()
				+ semanaMonto.getVie());

		semanaMetaTimeliness.setConcepto("Meta");
		semanaMetaTimeliness.setSab(99.95);
		semanaMetaTimeliness.setLun(99.95);
		semanaMetaTimeliness.setMar(99.95);
		semanaMetaTimeliness.setMie(99.95);
		semanaMetaTimeliness.setJue(99.95);
		semanaMetaTimeliness.setVie(99.95);

		semanaFueraTiempo.setConcepto("Fuera de Tiempo");
		semanaFueraTiempo.setSab(tasasService.obtenerVolTimeliness(fecha1));
		semanaFueraTiempo.setLun(tasasService.obtenerVolTimeliness(fecha2));
		semanaFueraTiempo.setMar(tasasService.obtenerVolTimeliness(fecha3));
		semanaFueraTiempo.setMie(tasasService.obtenerVolTimeliness(fecha4));
		semanaFueraTiempo.setJue(tasasService.obtenerVolTimeliness(fecha5));
		semanaFueraTiempo.setVie(tasasService.obtenerVolTimeliness(fecha6));
		semanaFueraTiempo.setSem(semanaFueraTiempo.getLun() + semanaFueraTiempo.getMar() + semanaFueraTiempo.getMie()
				+ semanaFueraTiempo.getJue() + semanaFueraTiempo.getVie());

		semanaPercenTimeliness.setConcepto("% TimeLiness");
		if (semanaFueraTiempo.getSab() > 0) {
			semanaPercenTimeliness.setSab((1 - (semanaFueraTiempo.getSab() / semanaVolumen.getSab())) * timeLiness);
		} else {
			semanaPercenTimeliness.setSab(100);
		}

		if (semanaFueraTiempo.getLun() > 0) {
			semanaPercenTimeliness.setLun((1 - (semanaFueraTiempo.getLun() / semanaVolumen.getLun())) * timeLiness);
		} else {
			semanaPercenTimeliness.setLun(100);
		}

		if (semanaFueraTiempo.getMar() > 0) {
			semanaPercenTimeliness.setMar((1 - (semanaFueraTiempo.getMar() / semanaVolumen.getMar())) * timeLiness);
		} else {
			semanaPercenTimeliness.setMar(100);
		}

		if (semanaFueraTiempo.getMie() > 0) {
			semanaPercenTimeliness.setMie((1 - (semanaFueraTiempo.getMie() / semanaVolumen.getMie())) * timeLiness);
		} else {
			semanaPercenTimeliness.setMie(100);
		}

		if (semanaFueraTiempo.getJue() > 0) {
			semanaPercenTimeliness.setJue((1 - (semanaFueraTiempo.getJue() / semanaVolumen.getJue())) * timeLiness);
		} else {
			semanaPercenTimeliness.setJue(100);
		}

		if (semanaFueraTiempo.getVie() > 0) {
			semanaPercenTimeliness.setVie((1 - (semanaFueraTiempo.getVie() / semanaVolumen.getVie())) * timeLiness);
		} else {
			semanaPercenTimeliness.setVie(100);
		}

		if (semanaFueraTiempo.getSem() > 0) {
			semanaPercenTimeliness.setSem((1 - (semanaFueraTiempo.getSem() / semanaVolumen.getSem())) * timeLiness);
		} else {
			semanaPercenTimeliness.setSem(100);
		}

		semanaReproceso.setConcepto("Reproceso");
		semanaReproceso.setSab(tasasService.obtenerVolAccuracy(fecha1));
		semanaReproceso.setLun(tasasService.obtenerVolAccuracy(fecha2));
		semanaReproceso.setMar(tasasService.obtenerVolAccuracy(fecha3));
		semanaReproceso.setMie(tasasService.obtenerVolAccuracy(fecha4));
		semanaReproceso.setJue(tasasService.obtenerVolAccuracy(fecha5));
		semanaReproceso.setVie(tasasService.obtenerVolAccuracy(fecha6));
		semanaReproceso.setSem(semanaReproceso.getLun() + semanaReproceso.getMar() + semanaReproceso.getMie()
				+ semanaReproceso.getJue() + semanaReproceso.getVie());

		semanaMetaAccuracy.setConcepto("Meta");
		semanaMetaAccuracy.setSab(99.00);
		semanaMetaAccuracy.setLun(99.00);
		semanaMetaAccuracy.setMar(99.00);
		semanaMetaAccuracy.setMie(99.00);
		semanaMetaAccuracy.setJue(99.00);
		semanaMetaAccuracy.setVie(99.00);

		semanaPercnetAccuracy.setConcepto("% Accuracy");

		if (semanaReproceso.getSab() > 0) {
			semanaPercnetAccuracy.setSab(1 - (semanaReproceso.getSab() / semanaVolumen.getSab()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setSab(100);
		}
		
		
		if (semanaReproceso.getLun() > 0) {
			semanaPercnetAccuracy.setLun(1 - (semanaReproceso.getLun() / semanaVolumen.getLun()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setLun(100);
		}
		
		if (semanaReproceso.getMar() > 0) {
			semanaPercnetAccuracy.setMar(1 - (semanaReproceso.getMar() / semanaVolumen.getMar()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setMar(100);
		}
		
		if (semanaReproceso.getMie() > 0) {
			semanaPercnetAccuracy.setMie(1 - (semanaReproceso.getMie() / semanaVolumen.getMie()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setMie(100);
		}
		
		
		if (semanaReproceso.getJue() > 0) {
			semanaPercnetAccuracy.setJue(1 - (semanaReproceso.getJue() / semanaVolumen.getJue()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setJue(100);
		}
		
		
		if (semanaReproceso.getVie() > 0) {
			semanaPercnetAccuracy.setVie(1 - (semanaReproceso.getVie() / semanaVolumen.getVie()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setVie(100);
		}
		
		if (semanaReproceso.getSem() > 0) {
			semanaPercnetAccuracy.setSem(1 - (semanaReproceso.getSem() / semanaVolumen.getSem()) * acuraccy);
		} else {
			semanaPercnetAccuracy.setSem(100);
		}
		
		
		semanaMetaQuejas.setConcepto("Meta");
		semanaMetaQuejas.setSab(99.00);
		semanaMetaQuejas.setLun(99.00);
		semanaMetaQuejas.setMar(99.00);
		semanaMetaQuejas.setMie(99.00);
		semanaMetaQuejas.setJue(99.00);
		semanaMetaQuejas.setVie(99.00);
		
		
		semanaNoQuejas.setConcepto("No. Quejas");
		semanaNoQuejas.setSab(0);
		semanaNoQuejas.setLun(0);
		semanaNoQuejas.setMar(0);
		semanaNoQuejas.setMie(0);
		semanaNoQuejas.setJue(0);
		semanaNoQuejas.setVie(0);
		
		semanaPercentQuejas.setConcepto("% Quejas");
		semanaPercentQuejas.setSab(100);
		semanaPercentQuejas.setLun(100);
		semanaPercentQuejas.setMar(100);
		semanaPercentQuejas.setMie(100);
		semanaPercentQuejas.setJue(100);
		semanaPercentQuejas.setVie(100);
		
		
		semanaFTE.setConcepto("FTE");
		semanaFTE.setSab(tasasService.obtenerOperadoresporDia(fecha1));
		semanaFTE.setLun(tasasService.obtenerOperadoresporDia(fecha2));
		semanaFTE.setMar(tasasService.obtenerOperadoresporDia(fecha3));
		semanaFTE.setMie(tasasService.obtenerOperadoresporDia(fecha4));
		semanaFTE.setJue(tasasService.obtenerOperadoresporDia(fecha5));
		semanaFTE.setVie(tasasService.obtenerOperadoresporDia(fecha6));
		
	
		semanaFTE.setSab(semanaFTE.getSab()>0?semanaFTE.getSab():0);
		semanaFTE.setLun(semanaFTE.getLun()>0?semanaFTE.getLun():0);
		semanaFTE.setMar(semanaFTE.getMar()>0?semanaFTE.getMar():0);
		semanaFTE.setMie(semanaFTE.getMie()>0?semanaFTE.getMie():0);
		semanaFTE.setJue(semanaFTE.getJue()>0?semanaFTE.getJue():0);
		semanaFTE.setVie(semanaFTE.getVie()>0?semanaFTE.getVie():0);
		
		semanaFTE.setSem(semanaFTE.getSab()+semanaFTE.getLun()+semanaFTE.getMar()+semanaFTE.getMie()+
				semanaFTE.getJue()+semanaFTE.getVie());
		
		
		semanaCapacityMax.setConcepto("Capacity Max");
		semanaCapacityMax.setSab(semanaFTE.getSab()*96);
		semanaCapacityMax.setLun(semanaFTE.getLun()*96);
		semanaCapacityMax.setMar(semanaFTE.getMar()*96);
		semanaCapacityMax.setMie(semanaFTE.getMie()*96);
		semanaCapacityMax.setJue(semanaFTE.getJue()*96);
		semanaCapacityMax.setVie(semanaFTE.getVie()*96);
		
		semanaCapacityMax.setSem(semanaCapacityMax.getSab()+semanaCapacityMax.getLun()+semanaCapacityMax.getMar()+
				semanaCapacityMax.getMie()+semanaCapacityMax.getJue()+semanaCapacityMax.getVie());
		
		
		
		semanaCapacityPlan.setConcepto("Capacity Plan");
		
		if (semanaFTE.getSab() > 0) { semanaCapacityPlan.setSab((semanaVolumen.getSab() / semanaCapacityMax.getSab()) * 100); }
		if (semanaFTE.getLun() > 0) { semanaCapacityPlan.setLun((semanaVolumen.getLun() / semanaCapacityMax.getLun()) * 100); }
		if (semanaFTE.getMar() > 0) { semanaCapacityPlan.setMar((semanaVolumen.getMar() / semanaCapacityMax.getMar()) * 100); }
		if (semanaFTE.getMie() > 0) { semanaCapacityPlan.setMie((semanaVolumen.getMie() / semanaCapacityMax.getMie()) * 100); }
		if (semanaFTE.getJue() > 0) { semanaCapacityPlan.setJue((semanaVolumen.getJue() / semanaCapacityMax.getJue()) * 100); }
		if (semanaFTE.getVie() > 0) { semanaCapacityPlan.setVie((semanaVolumen.getVie() / semanaCapacityMax.getVie()) * 100); }
		if (semanaFTE.getSem() > 0) { semanaCapacityPlan.setSem((semanaVolumen.getSem() / semanaCapacityMax.getSem()) * 100); }
		
		listaWeek.add(semanaDia);
        listaWeek.add(semanaVolumen);
        listaWeek.add(semanaMonto);
        listaWeek.add(semanaPercenTimeliness);
        listaWeek.add(semanaMetaTimeliness);
        listaWeek.add(semanaFueraTiempo);
        listaWeek.add(semanaPercnetAccuracy);
        listaWeek.add(semanaMetaAccuracy);
        listaWeek.add(semanaReproceso);
        listaWeek.add(semanaPercentQuejas);
        listaWeek.add(semanaMetaQuejas);
        listaWeek.add(semanaNoQuejas);
        listaWeek.add(semanaCapacityPlan);
        listaWeek.add(semanaCapacityMax);
        listaWeek.add(semanaFTE);
		

		return listaWeek;
		
		
	}

	@Override
	public Map<String, List<ReporteEjecutivoKPIDTO>> generarReporteEjecutivo(String date1,List<ListaUsuariosSoeidDTO> lsUsuariosSoeid) throws ParseException {
		
		
		Map<String, List<ReporteEjecutivoKPIDTO>> mapGente       = new HashedMap<>();
		List<ReporteEjecutivoKPIDTO>              ListaPersonal  = new ArrayList<>();
		
		ReporteEjecutivoKPIDTO usuario = null;
		
		List<String> usuarios = new ArrayList<>();
		
		/**
		 * Solo quiero ver que se imprima la lista de usuarios que manda el usuario
		 */		
		
		for (ListaUsuariosSoeidDTO usuarioSoeid : lsUsuariosSoeid) {
			  if(!usuarioSoeid.getNombre().equals("SOEID NO ENCONTRADO, FAVOR DE VALIDAR")) {
				  LOGGER.info("generarReporteEjecutivo - usuarioSoeid.getNombre() " + " "+ usuarioSoeid.getNombre());				  
				  LOGGER.info("generarReporteEjecutivo - usuarioSoeid.getSoeidOpe()"+  " "+ usuarioSoeid.getSoeidOpe());
				  usuarios.add(usuarioSoeid.getNombre());
			  }
	     }	
		
		/**
		 * Pasamos las fechas a Date para sumar los dias
		 */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(date1);
		Date firstDate = addDays(date, 0);
		Date secondDate = addDays(date, 2);
		Date thirdDate = addDays(date, 3);
		Date fourDate = addDays(date, 4);
		Date fivetDate = addDays(date, 5);
		Date sixtDate = addDays(date, 6);
		
		
			
		
		/**
		 * Regreso la fechas a String con la suma de los dias correspondientes para
		 * hacer las busquedas en base de datos
		 */
		String fecha1 = format.format(firstDate);
		String fecha2 = format.format(secondDate);
		String fecha3 = format.format(thirdDate);
		String fecha4 = format.format(fourDate);
		String fecha5 = format.format(fivetDate);
		String fecha6 = format.format(sixtDate);
		
		List<String> lsFechas = new ArrayList<>();
		lsFechas.add(fecha1);
		lsFechas.add(fecha2);
		lsFechas.add(fecha3);
		lsFechas.add(fecha4);
		lsFechas.add(fecha5);
		lsFechas.add(fecha6);
		
		
		/**
		 * Recorremos Usuarios
		 */
		
		for (String itUsuarios : usuarios) {
			
			LOGGER.info("GenerarReporteEjecutivo -  Usuario  - Method: generarReporteEjecutivo - "+itUsuarios);
			
			ListaPersonal.clear();
			
			for (String fechas : lsFechas) {
				usuario = new ReporteEjecutivoKPIDTO();
				
				usuario.setFecha(fechas);
				usuario.setAsignadas(tasasService.getVolumenAsignadas(fechas, itUsuarios));
				usuario.setOperadas(tasasService.getVolumenOperadas(fechas, itUsuarios));
				usuario.setProductividad(usuario.getOperadas()>0?(usuario.getOperadas()/usuario.getAsignadas()):0);
				usuario.setReprocesos(tasasService.getVolumenReproceso(fechas, itUsuarios));
				usuario.setAccuracy(usuario.getReprocesos()>0?1-(usuario.getReprocesos()/usuario.getOperadas()):1);
				usuario.setFueraDeTiempo(tasasService.getVolumenTimeliness(fechas, itUsuarios));
				usuario.setTimeliness(usuario.getFueraDeTiempo()>0?1-(usuario.getFueraDeTiempo()/usuario.getOperadas()):1);

				LOGGER.info("GenerarReporteEjecutivo -  ListaPersonal  - "+ListaPersonal.toString());
				ListaPersonal.add(usuario);
			}
			
			mapGente.put(itUsuarios, ListaPersonal);		
			
		    }
		
		LOGGER.info("GenerarReporteEjecutivo -  size of map - mapGente  "+ mapGente.size());
		
		return mapGente;
	}

	
	/**
	 * Este metodo recibe dos fechas pero desde el front se debe de mandar la misma 
	 * fecha para que no se tengan inconvenientes.
	 */
	@Override
	public List<CompletarInformacionKPIDTO> reporteComplementoKPI(String date1, String date2) {
		
		List<CompletarInformacionKPIDTO> lsCompletarInfo      = new ArrayList<>();
		List<CompletarInformacionKPIDTO> lsCompletarInfoFinal = new ArrayList<>();
		
		CompletarInformacionKPIDTO completarInformacionKPIDTOFinal = new CompletarInformacionKPIDTO();
		
		lsCompletarInfo = tasasService.reporteComplementoKPI(date1, date2);		
		
		LOGGER.info("reporteComplementoKPI -  size() - "+ lsCompletarInfo.size());
		
		for (CompletarInformacionKPIDTO completarInformacionKPIDTO : lsCompletarInfo) {
			
			completarInformacionKPIDTO.setFechaSolicitud(
					completarInformacionKPIDTO.getFechaSoli()!=null?completarInformacionKPIDTO.getFechaSoli().toString():"");
			
			completarInformacionKPIDTOFinal = new CompletarInformacionKPIDTO();
			completarInformacionKPIDTOFinal = completarInformacionKPIDTO;
			lsCompletarInfoFinal.add(completarInformacionKPIDTOFinal);
			
		}
		

		return lsCompletarInfoFinal;
	}

	@Override
	public List<FechasFestivasDTO> obtenerListaFechas() {
		
		List<FechasFestivasDTO> lsFechasFestivas = new ArrayList<FechasFestivasDTO>();
		
		
		List<FechasFestivasDTO> lsFechasFest = new ArrayList<FechasFestivasDTO>();
		FechasFestivasDTO    fechasFEst = new FechasFestivasDTO();
		
		lsFechasFestivas = tasasService.obtenerListaFechas();
		
		
		for (FechasFestivasDTO fechasFestivasDTO : lsFechasFestivas) {
			
			fechasFEst = new FechasFestivasDTO();
			fechasFEst.setIdFecha(fechasFestivasDTO.getIdFecha());
			fechasFEst.setDescripcion(fechasFestivasDTO.getDescripcion());
			fechasFEst.setFecha(fechasFestivasDTO.getFecha());
			fechasFEst.setFechaDescrip(fechasFestivasDTO.getFecha().toString());
			lsFechasFest.add(fechasFEst);
			
		}
		
		
				
		return lsFechasFest;
	}

	@Override
	public void guardarFecha (FechasFestivas fechasFestivas) throws ParseException {
		
		try {
			LOGGER.info("TasasServiceImpl - "+" "+fechasFestivas.toString());
		   tasasService.guardarFecha(fechasFestivas);	
		} catch (Exception e) {
			LOGGER.error("ERROR - TasasServiceImpl - guardarFecha" + "  "+  e.getMessage());
		}		
	}

	@Override
	public int borrarFecha(Long id) {
		
		int res=0;
		
		try {
			res = tasasService.borrarFecha(id);	
		} catch (Exception e) {
			
		}
		
		LOGGER.info("TasasServiceImpl - "+" borrarFecha");	
		
		return res;
		
	}

	@Override
	public List<ListaUsuariosSoeidDTO> getUsuariosSoeid(String date1, String date2) {
		
		List<ListaUsuariosSoeidDTO>  lsUsuariosSoeid      = new ArrayList<>();
		AsignacionesDTO     asignacion                    = new AsignacionesDTO();
		ListaUsuariosSoeidDTO lsAuxiSoeid                 = null;
		List<ListaUsuariosSoeidDTO>  lsUsuariosSoeidRepo  = new ArrayList<>();
		
		lsUsuariosSoeid =  tasasService.getUsuariosSoeid(date1, date2);
		
		String soeid ="";
		String nombreSoied="";
		
		for (ListaUsuariosSoeidDTO autoTasasDTO : lsUsuariosSoeid) {
			lsAuxiSoeid = new ListaUsuariosSoeidDTO();
			   soeid   = autoTasasDTO.getSoeidOpe();
			   
			   if(soeid!=null && !soeid.equals("")) {
				   asignacion = tasasService.getUsuariosSoeid(soeid);
				   
				   if(asignacion.getNombre()!=null) {
					   nombreSoied = asignacion.getNombre();
					   lsAuxiSoeid.setNombre(nombreSoied);
					   lsAuxiSoeid.setSoeidOpe(soeid);
					   lsUsuariosSoeidRepo.add(lsAuxiSoeid);					   
				   }
			   }
		}
		
		return lsUsuariosSoeidRepo;
	}

	@Override
	public AsignacionesDTO getNombreSoeidAsignacion(String soeid) {
		AsignacionesDTO asignacion = new AsignacionesDTO();
		
		asignacion = tasasService.getUsuariosSoeid(soeid);
		
		return asignacion;
	}

	@Override
	public int complementarSolicitudKPI(ActualizarSolicitudKPIDTO solicitudDTO) {
		
		Optional<AutoTasas> solicitud = Optional.ofNullable(new AutoTasas());
		AutoTasas actSolicitud = new AutoTasas();
		int res=0;
		
		solicitud = autoTasasRepository.findById(solicitudDTO.getIdTasaAuto());
		
		if(solicitud.isPresent()) {
			LOGGER.info("Id AutoTasas Encontrado"+ " " +  solicitud.get().getIdTasaAuto());	
			
			if(solicitudDTO.getSoeidAsig()!=null && !solicitudDTO.getSoeidAsig().equals("")) {
				solicitud.get().setSoeidAsig(solicitudDTO.getSoeidAsig());
			}if(solicitudDTO.getSoeidOpe()!=null && !solicitudDTO.getSoeidOpe().equals("")) {
				solicitud.get().setSoeidOpe(solicitudDTO.getSoeidOpe());	
			}if(solicitudDTO.getSoeidProc()!=null && !solicitudDTO.getSoeidProc().equals("")) {
				solicitud.get().setSoeidProc(solicitudDTO.getSoeidProc());	
			}
			
			actSolicitud = solicitud.get();
			try {
				tasasService.complementarSolicitudKPI(actSolicitud);
				LOGGER.info("Solicitud Actualizada con Exito " + " " +"complementarSolicitudKPI");
				res=1;
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}	
		}
		
		return res;
		
		
	}

	@Override
	public int borrarContratosRepetidos(List<Long> lsContratosRepetidos) {
		
		int res=0;
		
		try {
			res = tasasService.borrarContratosRepetidos(lsContratosRepetidos);	
		} catch (Exception e) {
			
		}
		
		return res;
	}

	@Override
	public int borrarClienteRepetidos(List<Long> lsClienteRepetidos) {
		
		int res=0;
		
		try {
			res= tasasService.borrarClienteRepetidos(lsClienteRepetidos);	
		} catch (Exception e) {
			
		}
		
		return res;
		
	}

	@Override
	public int borrarObservacionesDigitosEnTasa(List<Long> lsRegistros) {
		int res=0;
		
		try {
			res= tasasService.borrarObservacionesDigitosEnTasa(lsRegistros);	
		} catch (Exception e) {
			
		}		
		return res;
	}

	@Override
	public int editarFechasFestivas(ActualizarFechasFestivasDTO editarFechas) throws ParseException {
		Optional<FechasFestivas> solicitud = Optional.ofNullable(new FechasFestivas());
		
		FechasFestivas fecha    = new FechasFestivas();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		solicitud               = fechasFestivasRepository.findById(editarFechas.getIdFecha());
		int res                 = 0;
		
		if(solicitud.isPresent()) {
			LOGGER.info("Id Fecha Festiva Encontrado"+ " " +  solicitud.get().getIdFecha());	
			if(editarFechas.getDescripcion()!=null && !editarFechas.getDescripcion().equals("")) {
				solicitud.get().setDescripcion(editarFechas.getDescripcion());
			}if(editarFechas.getFecha()!=null && !editarFechas.getFecha().equals("")) {
				Date date = format.parse(editarFechas.getFecha());
				solicitud.get().setFecha(date);
			}
			
			fecha = solicitud.get();
			
			try {
				
				tasasService.editarFechasFestivas(fecha);
				res=1;
				LOGGER.info("editarFechasFestivas - TasasServiceImple - Exito ");
				
			} catch (Exception e) {
			    LOGGER.error(e.getMessage());
		    }	
		}else {			
			LOGGER.info("NO SE ENCONTRO EL ID DE LA FECHA A EDITAR - TasasServiceImple - editarFechasFestivas ");
		}
		
		return res;
		
	}

	@Override
	public List<PerCatParametrosDTO> getParametros() {
		
		List<PerCatParametrosDTO>  lsParametros = new ArrayList<>();
		
		lsParametros = tasasService.getParametros();
		
		return lsParametros;
	}

	
	/**
	 * Insertar TimeLiness  : Tabla uec_tb_tasas_timeliness
	 */
	@Override
	public int insertarTimeLiness(List<TasasTimeLinessDTO> lsTimeLiness) {
		
		LOGGER.info("InsertarTimeLiness - TasasServiceImple - Ingresa al método ");
		
		/**
		 * Se recorre lista para hacer el Save de cada registro de Reproceso
		 */
		int res=0;
		TasasTimeLiness saveTasasTimeLiness =null; new TasasTimeLiness();
		
		for (TasasTimeLinessDTO tasasTimeLinessDTO : lsTimeLiness) {
			      saveTasasTimeLiness =  new TasasTimeLiness();
			      saveTasasTimeLiness.setIdTasa(tasasTimeLinessDTO.getIdTasa());
			      saveTasasTimeLiness.setAsignadoA(tasasTimeLinessDTO.getAsignadoA());
			      saveTasasTimeLiness.setOperadoPor(tasasTimeLinessDTO.getOperadoPor());
			      saveTasasTimeLiness.setContrato(tasasTimeLinessDTO.getContrato());
			      saveTasasTimeLiness.setNum_cte(tasasTimeLinessDTO.getNum_cte());
			      saveTasasTimeLiness.setEstatus(tasasTimeLinessDTO.getEstatus());
			      saveTasasTimeLiness.setFechaCaptura(Timestamp.valueOf(tasasTimeLinessDTO.getFechaSCaptura().concat(" ").concat("01:02:03.123456789")));
			      saveTasasTimeLiness.setFechaAutori(Timestamp.valueOf(tasasTimeLinessDTO.getFechaSAutori().concat(" ").concat("01:02:03.123456789")));
			      saveTasasTimeLiness.setFechaEstatus(Timestamp.valueOf(tasasTimeLinessDTO.getFechaSEstatus().concat(" ").concat("01:02:03.123456789")));
			      saveTasasTimeLiness.setObservaWeb(tasasTimeLinessDTO.getObservaWeb());
			      saveTasasTimeLiness.setCampanaWeb(tasasTimeLinessDTO.getCampanaWeb());
			      saveTasasTimeLiness.setSoeidResp(tasasTimeLinessDTO.getSoeidResp());			      
			try {
				  tasasTimeLinessRepository.save(saveTasasTimeLiness);
				  LOGGER.info("Insertar TimeLiness - "+ "Save Object"+ " " + saveTasasTimeLiness.toString());
				  res=1;
			} catch (Exception e) {
				LOGGER.error("ERROR - Insertar TimeLiness - " + "  "+  e.getMessage());
			}
		}	
		
		return res;
	}

	
	/**
	 * Insertar Reprocesos :  Tabla uec_tb_tasas_reproceso
	 */
	@Override
	public int insertarReprocesos(List<TasasReprocesoDTO> lsReprocesos) throws ParseException {

		LOGGER.info("insertarReprocesos - TasasServiceImple - Ingresa al método ");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
	
		
		/**
		 * Se recorre lista para hacer el Save de cada registro de Reproceso
		 */
		int res=0;
		
		
		TasasReproceso saveReproceso = new TasasReproceso();
		
		for (TasasReprocesoDTO tasasReprocesoDTO : lsReprocesos) {
			       saveReproceso = new TasasReproceso();
			       saveReproceso.setIdTasa(tasasReprocesoDTO.getIdTasa());
			       saveReproceso.setNumAutoriUec(tasasReprocesoDTO.getNumAutoriUec());
			       saveReproceso.setFechaOpe(format.parse(tasasReprocesoDTO.getFechaOpeS()));
			       saveReproceso.setSucSolic(tasasReprocesoDTO.getSucSolic());
			       saveReproceso.setMonto(tasasReprocesoDTO.getMonto());
			       saveReproceso.setPlazo(tasasReprocesoDTO.getPlazo());
			       saveReproceso.setTasaAutori(tasasReprocesoDTO.getTasaAutori());
			       saveReproceso.setEstatus(tasasReprocesoDTO.getEstatus());
			       saveReproceso.setNum_cte(tasasReprocesoDTO.getNum_cte());
			       saveReproceso.setNomCliente(tasasReprocesoDTO.getNomCliente());
			       saveReproceso.setContrato(tasasReprocesoDTO.getContrato());
			       saveReproceso.setOperadoPor(tasasReprocesoDTO.getOperadoPor());
			       saveReproceso.setCampanaWeb(tasasReprocesoDTO.getCampanaWeb());
			       saveReproceso.setNomEjecutivo(tasasReprocesoDTO.getNomEjecutivo());
			       saveReproceso.setObservaWeb(tasasReprocesoDTO.getObservaWeb());
			       saveReproceso.setSoeidResp(tasasReprocesoDTO.getSoeidResp());
			       
			       try {
			    	   tasasReprocesoRepository.save(saveReproceso);
			    	   LOGGER.info("insertarReprocesos - Save Object" + " " + saveReproceso.toString());
			    	   res=1;
				} catch (Exception e) {
					LOGGER.error("ERROR - Insertar Reprocesos - " + "  "+  e.getMessage());
				}		       
		}
		
		return res;
	}
	
	/**
	 * Eliminar Registros de la tabla  : uec_tb_tasas_reproceso
	 */

	@Override
	public int eliminarReprocesos(List<Long> lsRegistros) {
		
		int res=0;
		
		try {
			res= tasasService.eliminarReprocesos(lsRegistros);	
		} catch (Exception e) {
			
		}		
		return res;
	}

	
	/**
	 * Eliminar Registros de la tabla : uec_tb_tasas_timeliness
	 */
	@Override
	public int eliminarTimeLiness(List<Long> lsRegistros) {
		int res=0;
		
		try {
			res= tasasService.eliminarTimeLiness(lsRegistros);	
		} catch (Exception e) {
			
		}		
		return res;
	}

	@Override
	public List<AutoTasasDTO> getAutoTasasSoeidAsignacionPendiente() {
		
		List<AutoTasasDTO> lsAutoTasasPendiente = new ArrayList<>();
		
		lsAutoTasasPendiente = tasasService.getAutoTasasSoeidAsignacionPendiente();
		
		for (AutoTasasDTO autoTasasDTO : lsAutoTasasPendiente) {
			
			LOGGER.info("AUTOTASAS ASIGNACIONES PENDIENTES" + " " + autoTasasDTO.getIdTasaAuto());
			LOGGER.info("AUTOTASAS ASIGNACIONES PENDIENTES" + " " + autoTasasDTO.getFechaSoli().toString());
			LOGGER.info("AUTOTASAS ASIGNACIONES PENDIENTES" + " " + autoTasasDTO.getMonto());
			LOGGER.info("AUTOTASAS ASIGNACIONES PENDIENTES" + " " + autoTasasDTO.getPlazo());
			LOGGER.info("AUTOTASAS ASIGNACIONES PENDIENTES" + " " + autoTasasDTO.getSoeidOpe());
			LOGGER.info("AUTOTASAS ASIGNACIONES PENDIENTES" + " " + autoTasasDTO.getNomEjecutivo());
			
		}
				
		return lsAutoTasasPendiente;
	}

	@Override
	public List<ListaUsuariosSoeidDTO> getUsuariosSoeidActivos(String date) throws ParseException {
		
		List<ListaUsuariosSoeidDTO>  lsUsuariosSoeid      = new ArrayList<>();
		AsignacionesDTO     asignacion                    = new AsignacionesDTO();
		ListaUsuariosSoeidDTO lsAuxiSoeid                 = null;
		List<ListaUsuariosSoeidDTO>  lsUsuariosSoeidRepo  = new ArrayList<>();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = format.parse(date);
		Date firstDate = addDays(date2, 6);
		
		String fecha2 = format.format(firstDate);
		
		
		lsUsuariosSoeid =  tasasService.getUsuariosSoeidActivos(date,fecha2);
		
		String soeid ="";
		String nombreSoied="";
		
		for (ListaUsuariosSoeidDTO autoTasasDTO : lsUsuariosSoeid) {
			lsAuxiSoeid = new ListaUsuariosSoeidDTO();
			   soeid   = autoTasasDTO.getSoeidOpe();
			   
			   if(soeid!=null && !soeid.equals("")) {
				   asignacion = tasasService.getUsuariosSoeidActivoAsignaciones(soeid);
				   
				   if(asignacion.getNombre()!=null) {
					   nombreSoied = asignacion.getNombre();
					   lsAuxiSoeid.setNombre(nombreSoied);
					   lsAuxiSoeid.setSoeidOpe(soeid);
					   lsUsuariosSoeidRepo.add(lsAuxiSoeid);					   
				   }
			   }
		}
		
		return lsUsuariosSoeidRepo;
		
	}

	@Override
	public List<AutoTasasEmailDTO> obtenerRegistrosSinAutorizacion() {
		
		List<AutoTasasEmailDTO> lsSolicitudes = new ArrayList<>();
		
		List<AutoTasasEmailDTO> lsSolicitudFinal = new ArrayList<>();
		
		AutorizadorElegidoDTO autorizacion   = new AutorizadorElegidoDTO();
		
		
		AutoAutorizadorDTO autori = new AutoAutorizadorDTO();
		
		/**
		 * Primero se obtiene los registros sin Autorizacion 
		 */		
		lsSolicitudes = tasaAutoRepository.obtenerRegistrosSinAutorizacion();
		
		LOGGER.info("obtenerRegistrosSinAutorizacion:: lsSolicitudes" +  " " + lsSolicitudes.size());
		
		StringBuilder nombres = new StringBuilder();
		
		for (AutoTasasEmailDTO autoTasasEmailDTO : lsSolicitudes) {
			List<AutoAutorizadorDTO> lsAutorizadores  = new ArrayList<>();
			
			try {
				
				autorizacion = 	tasaAutoRepository.obtenerAutorizador(autoTasasEmailDTO.getIdTasaAuto());
				nombres = new StringBuilder();
				LOGGER.info("obtenerRegistrosSinAutorizacion:: Objeto Autorizacion -  ObtenerAutorizador()" +  " " + autorizacion.toString());
				
				for (AutoAutorizadorDTO autoAutorizadorDTO : autorizacion.getLsAutorizadores()) {
					LOGGER.info("obtenerRegistrosSinAutorizacion:: Objeto Autorizacion -  Concatena Nombre Autorizador " + " " + autoAutorizadorDTO.getNombre());
					nombres.append(autoAutorizadorDTO.getNombre()).append("-");
					autoTasasEmailDTO.setAutorizadores(nombres.toString());		
					
					LOGGER.info("Contenido de los elementos que meteria a la lista por cada autorizador");
					LOGGER.info("Contenido de los autorizadores " + "getNombre " + " " + autoAutorizadorDTO.getNombre());
					LOGGER.info("Contenido de los autorizadores " + "getCorreo " + " " + autoAutorizadorDTO.getCorreo());
					LOGGER.info("Contenido de los autorizadores " + "getSoeidDistrital " + " " + autoAutorizadorDTO.getSoeidDistrital());
					LOGGER.info("Contenido de los autorizadores " + "getDvision " + " " + autoAutorizadorDTO.getDvision());
					LOGGER.info("Contenido de los autorizadores " + "getAlta " + " " + autoAutorizadorDTO.getAlta());
					LOGGER.info("Contenido de los autorizadores " + "getInic " + " " + autoAutorizadorDTO.getInic());
					
					autori = new AutoAutorizadorDTO();
					autori.setAlta(autoAutorizadorDTO.getAlta());
					autori.setCorreo(autoAutorizadorDTO.getCorreo());
					autori.setFechaInicio(autoAutorizadorDTO.getFechaInicio());
					autori.setDvision(autoAutorizadorDTO.getDvision());
					autori.setFechaTermino(autoAutorizadorDTO.getFechaTermino());
					autori.setIdNivelAuto(autoAutorizadorDTO.getIdNivelAuto());
					autori.setInic(autoAutorizadorDTO.getInic());
					autori.setIsCampesp(autoAutorizadorDTO.getIsCampesp());
					autori.setIsCete100(autoAutorizadorDTO.getIsCete100());
					autori.setNombre(autoAutorizadorDTO.getNombre());
					autori.setSoeidDistrital(autoAutorizadorDTO.getSoeidDistrital());
					autori.setSoied(autoAutorizadorDTO.getSoied());
					autori.setSoiedDivisional(autoAutorizadorDTO.getSoiedDivisional());
					autori.setDistrito(autoAutorizadorDTO.getDistrito());	
					lsAutorizadores.add(autori);				
				}	
				
				
			} catch (Exception e) {
				LOGGER.error("obtenerRegistrosSinAutorizacion -    -  "+ e.getMessage());
				LOGGER.error("obtenerRegistrosSinAutorizacion -    -  "+ e.getStackTrace());
			}
			
			autoTasasEmailDTO.setLsAutorizadores(lsAutorizadores);
			lsSolicitudFinal.add(autoTasasEmailDTO);			
		}			
		
		LOGGER.info("obtenerRegistrosSinAutorizacion:: lsSolicitudFinal" +  " " + lsSolicitudFinal.size());		
		
		return lsSolicitudFinal;
	}

	@Override
	public List<AutoAutorizadorDTO> ObtenerAutorizadoresDivisionales(String soeid, String division) {
		
		List<AutoAutorizadorDTO> lsAutoAutorizador = tasaAutoRepository.obtenerAutorizadoresDivisionales(soeid, division);
		
		LOGGER.info("ObtenerAutorizadoresDivisionales:: lsAutoAutorizador" +  " " + lsAutoAutorizador.size());
		
		return lsAutoAutorizador;
	}

	@Override
	public AutorizadorElegidoDTO obtenerAutorizador(Long idAutoTasa) {
		// TODO Auto-generated method stub
		
		AutorizadorElegidoDTO autorizadores = new AutorizadorElegidoDTO();
		
		autorizadores = tasaAutoRepository.obtenerAutorizador(idAutoTasa);
		
		LOGGER.info("obtenerAutorizador:: AutorizadorElegidoDTO" +  " " + autorizadores.toString());		
		
		return autorizadores;
	}

	@Override
	public AsignacionesDTO getStatusEjecutivo(String soeid) {
		
		AsignacionesDTO asignacion = new AsignacionesDTO();
		
		asignacion = tasasService.getAsignacionesBySoeid(soeid);
		
		LOGGER.info("getStatusEjecutivo:: asignacion" +  " " + asignacion.toString());
		
		return asignacion;
		
	}

	@Override
	public List<FolioNumAutorizacionDTO> getFoliosAutorizacion(String numAutoriEuc) {
				
		List<FolioNumAutorizacionDTO> lsFoliosAutorizacion = tasasService.getFoliosAutorizacion(numAutoriEuc);
		
		LOGGER.info("Query - Method -  getFoliosAutorizacion  -  List<FolioNumAutorizacionDTO>" + " " + lsFoliosAutorizacion.size());
				
		return lsFoliosAutorizacion;
	}
	
}