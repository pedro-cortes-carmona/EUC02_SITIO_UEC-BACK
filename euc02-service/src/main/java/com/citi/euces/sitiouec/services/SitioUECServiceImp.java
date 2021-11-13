package com.citi.euces.sitiouec.services;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.springframework.http.HttpStatus;
import javax.transaction.Transactional;

import com.citi.euces.sitiouec.infra.utils.ConstantUtils;
import com.citi.euces.sitiouec.infra.utils.FormatUtils;
import com.citi.euces.sitiouec.repositories.AcumuladoCampJDBCRepository;
import com.citi.euces.sitiouec.repositories.AutoCetesJDBCRepository;
import com.citi.euces.sitiouec.repositories.AutoTasasJDBCRepository;
import com.citi.euces.sitiouec.repositories.CatAutorizadores2021JDBCRepository;
import com.citi.euces.sitiouec.repositories.CatCampañasJDBCRepository;
import com.citi.euces.sitiouec.repositories.CatGralCtesJDBCRepository;
import com.citi.euces.sitiouec.repositories.TasasJDBCRepository;
import com.citi.euces.sitiouec.repositories.solicitudCampanaJDBCRepository;
import com.citi.euces.sitiouec.repositories.CatSucursalesDBCRepository;
import com.citi.euces.sitiouec.repositories.LogEliminacionJDBCRepository;
import com.citi.euces.sitiouec.repositories.ResumenAutDivJDBCRepository;
import com.citi.euces.sitiouec.repositories.ResumenJDCBRepository;
import com.citi.euces.sitiouec.repositories.TasasBoletinJDBCRepository;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.euces.sitiouec.dto.AutoTasaGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.MensajeDTO;
import com.citi.euces.sitiouec.dto.ReportDataSource;
import com.citi.euces.sitiouec.dto.SucursalGerenciaResponseDTO;
import com.citi.euces.sitiouec.infra.dto.ArchivoDiaCargaDTO;
import com.citi.euces.sitiouec.infra.dto.AutDivisionalesDTO;
import com.citi.euces.sitiouec.infra.dto.AutoTasaSoeidDTO;
import com.citi.euces.sitiouec.infra.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.infra.dto.AutocetesDTO;
import com.citi.euces.sitiouec.infra.dto.BoletinesDTO;
import com.citi.euces.sitiouec.infra.dto.BusquedaCampanaDetalleDTO;
import com.citi.euces.sitiouec.infra.dto.BusquedaCampanaResumenDTO;
import com.citi.euces.sitiouec.infra.dto.BusquedaSolicitudesAplicadasDTO;
import com.citi.euces.sitiouec.infra.dto.CampanaEstatusDTO;
import com.citi.euces.sitiouec.infra.dto.CampanaTipoAutoriDTO;
import com.citi.euces.sitiouec.infra.dto.CargaDatosDTO;
import com.citi.euces.sitiouec.infra.dto.CatCampanaDTO;
import com.citi.euces.sitiouec.infra.dto.CatFolioDTO;
import com.citi.euces.sitiouec.infra.dto.Cat_AsignacionBEDTO;
import com.citi.euces.sitiouec.infra.dto.ComboDTO;
import com.citi.euces.sitiouec.infra.dto.CombosFacultamientoDTO;
import com.citi.euces.sitiouec.infra.dto.DivisionDTO;
import com.citi.euces.sitiouec.infra.dto.EstatusDTO;
import com.citi.euces.sitiouec.infra.dto.ListaComboDTO;
import com.citi.euces.sitiouec.infra.dto.LogEliminacionDTO;
import com.citi.euces.sitiouec.infra.dto.NominaEAVDTO;
import com.citi.euces.sitiouec.infra.dto.RegionesDTO;
import com.citi.euces.sitiouec.infra.dto.ReporteBoletinesDTO;
import com.citi.euces.sitiouec.infra.dto.ReporteResumenDTO;
import com.citi.euces.sitiouec.infra.dto.ResumenAutDivDTO;
import com.citi.euces.sitiouec.infra.dto.ResumenCampanaDTO;
import com.citi.euces.sitiouec.infra.dto.ResumenDTO;
import com.citi.euces.sitiouec.infra.dto.SolicitudEstatusDTO;
import com.citi.euces.sitiouec.infra.dto.SolicitudesAplicadasSinDatosDTO;
import com.citi.euces.sitiouec.infra.dto.TasasCampanaDTO;
import com.citi.euces.sitiouec.infra.dto.TbTasasDTO;
import com.citi.euces.sitiouec.infra.dto.TasasDiarioA;
import com.citi.euces.sitiouec.infra.dto.TasasTotal;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.services.api.SitioUECService;

@Service
@Transactional
public class SitioUECServiceImp implements SitioUECService {

	static final Logger log = LoggerFactory.getLogger(SitioUECServiceImp.class);
	
	@Autowired
	private AutoTasasJDBCRepository autoTasasJDBCRepository;
	@Autowired
	private TasasJDBCRepository tasasJDBCRepository;
	@Autowired
	private CatSucursalesDBCRepository catSucusal2021JDBCRepository;
	@Autowired
	private AutoCetesJDBCRepository autoCetesJDBCRepository;
	@Autowired
	private LogEliminacionJDBCRepository logEliminacionJDBCRepository;
	@Autowired
	private TasasBoletinJDBCRepository tasasBoletinJDBCRepository;
	@Autowired
	private ResumenJDCBRepository resumenJDCBRepository; 
	@Autowired
	private ResumenAutDivJDBCRepository resumenAutDivJDBCRepository;
	@Autowired
	private CatCampañasJDBCRepository catCampañasJDBCRepository;
	@Autowired
	private AcumuladoCampJDBCRepository acumuladoCampJDBCRepository;
	@Autowired
	private CatAutorizadores2021JDBCRepository catAutorizadores2021JDBCRepository;
	@Autowired
	private solicitudCampanaJDBCRepository solicitudCampanaJDBCRepository;
	@Autowired
	private ServiceMenuGerenciaImp serviceMenuGerenciaImp;
	
	//ARCHIVO PLATINO
	@Override
	public MensajeDTO cargaArchivoPlatino(String file) throws GenericException, IOException, ParseException {
		MensajeDTO msg = new MensajeDTO();
		String message;
      Path testFile = Files.createTempFile("Platino", ".txt");
      byte[] decoder = Base64.getDecoder().decode(file);
      Files.write(testFile, decoder);
      message = leerArchivoPlatino(testFile);
      
      testFile.toFile().delete();
      msg.setMensajeInfo("Aviso");
      msg.setMensajeConfirm(message);
		return msg;
	}
	
	public String leerArchivoPlatino(Path tempFile) throws IOException, GenericException, ParseException{
		try {
			String linea, fechaOpeCompleta = "", fechaOpe = "";
			String[] valores;
			Integer id = 1, dia = 0, mes = 0, anio = 0, count = 0;
			FileReader f = new FileReader(tempFile.toFile());
			BufferedReader b = new BufferedReader(f);
			List<TbTasasDTO> listaPlatino = new ArrayList<TbTasasDTO>();
			Boolean flag = true;
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			while ((linea= b.readLine()) != null) {
				valores = linea.split("\t");
	      	
				if(flag) {
					fechaOpe = valores[0].substring(42, 44) + "/" + valores[0].substring(45, 47) + "/" + (Integer.parseInt(valores[0].substring(48, 50)) + 2000);
					dia = Integer.parseInt(valores[0].substring(42, 44));
					mes = Integer.parseInt(valores[0].substring(45, 47));
					anio = Integer.parseInt(valores[0].substring(48, 50));
					fechaOpeCompleta = (Integer.parseInt(valores[0].substring(48, 50)) + 2000) + "-" +valores[0].substring(45, 47) + "-" + valores[0].substring(42, 44);
					flag = false;
				}
	  		
				if(StringUtils.isNumeric(valores[0])) {
					TbTasasDTO tasa = new TbTasasDTO();
					String idTasa = dia + "" + (mes <= 9 ? "0" + mes : mes) + "" + anio + "" + id;
					tasa.setIdTasa(Integer.parseInt(idTasa));
					tasa.setFechaOpe(formatter.parse(fechaOpe));
					tasa.setEstatus(Integer.parseInt(valores[0]));
					tasa.setNumcte(Long.parseLong(valores[1]));
					tasa.setContrato(valores[2].isEmpty() ? 0 : Long.parseLong(valores[2].replace("XXX", "")));
					tasa.setSucSolic(valores[14].isEmpty() ? 0 : Integer.parseInt(valores[14]));
					tasa.setDivision("");
					tasa.setNumAutoriUEC(Integer.parseInt(valores[10]));
					tasa.setTipoPersona(valores[17].isEmpty() ? 0 : Integer.parseInt(valores[17]));
					tasa.settPer(0);
					tasa.setMonto(Double.parseDouble(validaMontos(valores[5])));
					tasa.setTasaAutori(Double.parseDouble(valores[6]));
		  			tasa.setHoraAutori(Timestamp.valueOf(fechaOpeCompleta + " " + valores[9].substring(0,2) + ":" + valores[9].substring(3, 5) + ":" + valores[9].substring(6, 8)));
		  			tasa.setProducto(tasa.getTasaAutori() * tasa.getMonto());
		  			tasa.setOperadorUEC(valores[11].isEmpty() ? 0 : Integer.parseInt(valores[11]));
		  			tasa.setNumInversion(Integer.parseInt(valores[3]));
		  			tasa.setPlazo(Integer.parseInt(valores[4]));
		  			tasa.setNomCte(valores[16]);
		  			tasa.setInstr(valores[21].isEmpty() ? 0 : Integer.parseInt(valores[21]));
		  			tasa.setCveMonto(obtenerClaveMonto(tasa.getMonto()));
		  			tasa.setCvePlazo(obtenerClavePlazo(tasa.getPlazo()));
		  			tasa.setSoeidRep(""); //NOMBRE DEL USUARIO ACTUAL
		  			id++;
		  			count++;
		  			listaPlatino.add(tasa);
				}
			}
			b.close();
	      
			tasasJDBCRepository.batchInsert(listaPlatino, 500);
			actualizarSucursalesBandejaWEB(formatter.parse(fechaOpe));
			log.info("Ejecucion SP: " + formatter.format(formatter.parse(fechaOpe)));
			tasasJDBCRepository.updateTasasAutorizadas(formatter.format(formatter.parse(fechaOpe)));
	      
			return "Se importaron exitosamente: " + count + " registros.";	
		}catch (Exception e) {
			e.getStackTrace();
	          throw new GenericException( "Error al procesar la información de platino :: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	public void actualizarSucursalesBandejaWEB(Date fecha) throws GenericException {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
			List<TasasCampanaDTO> listaTasasCampana = new ArrayList<TasasCampanaDTO>();
			List<TasasCampanaDTO> subLista = new ArrayList<TasasCampanaDTO>();
			List<TbTasasDTO> listaInsumosPlatino = new ArrayList<TbTasasDTO>();
			Calendar c = Calendar.getInstance();
			c.setTime(fecha);
			Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			
			log.info("Consulta Campaña");
			listaTasasCampana = autoTasasJDBCRepository.selectTasaCampaña(formato.format(fecha), formato.format(fecha));
			
			if(dayOfWeek == Calendar.MONDAY) {
				Date fechaAnterior = DateUtils.addDays(fecha, -2);
				listaTasasCampana.addAll(autoTasasJDBCRepository.selectTasaCampaña(formato.format(fechaAnterior), formato.format(fechaAnterior)));
			}
			
			log.info("Consulta Platino");
			log.info("Numero reg: " + tasasJDBCRepository.obtieneReg(formato.format(fecha)));
			listaInsumosPlatino = tasasJDBCRepository.selectRegTasas(formato.format(fecha), 0);
			
			log.info("Paso 1");
			for(TbTasasDTO val:listaInsumosPlatino) {
				log.info("Paso 2");
				if(val.getEstatus() == 1 && val.getIsWeb() == 0) {
					
					if(listaTasasCampana.size() > 0) {
						listaTasasCampana.forEach(value -> { if(value.getNumAutoriUEC() == val.getNumAutoriUEC()) { subLista.add(value); } });
					}
					
					log.info("Paso 3");
					if(subLista.size() > 0) {
						log.info("Paso 4");
						TasasCampanaDTO tasa = new TasasCampanaDTO();
						tasa = subLista.get(0);
						val.setSucSolic(tasa.getSucSolic());
						val.setAsignadoA(tasa.getSoeidAsig());
						val.setOperadoPor(tasa.getSoeidOpe());
						val.setFechacap(tasa.getFechaSolic());
						val.setFechaEstatus(tasa.getFechaEstatus());
						val.setObservaWeb(tasa.getObservaWeb());
						val.setCampanaWeb(tasa.getTipoAutori());
						val.setNomina(tasa.getNomina());
						val.setNomEjec(tasa.getNomEjec());
						val.setIsWeb(1);
						if(val.getNomCte().isEmpty()) { val.setNomCte(tasa.getNomCte()); }
						if(val.getNumcte() == 0) { val.setNumcte(tasa.getNumCte()); }
						
						log.info("Paso 5");
						if(val.getSucSolic() > 0) {
							val.setDivision(catSucusal2021JDBCRepository.obtieneDivision(val.getSucSolic()));
						}
						tasasJDBCRepository.updateSucTasas(val);
						tasasJDBCRepository.updateAsignadoOperadoTasas(val);
					}
				}
				
			}
			
		}catch (Exception e) {
			e.getStackTrace();
          throw new GenericException( "Error al procesar la información de platino :: " , HttpStatus.NOT_FOUND.toString());
      }
	}
	
	public Integer obtenerClavePlazo (Integer dias) {
		int claveplazo=0;
      if(dias >=1 && dias<7){claveplazo=1;}
      if (dias >= 7 && dias < 14) { claveplazo = 7; }
      if (dias >= 14 && dias < 30) { claveplazo = 28; }
      if (dias >= 30 && dias < 35) { claveplazo = 31; }
      if (dias >= 35 && dias < 40) { claveplazo = 35; }
      if (dias >= 40 && dias < 53) { claveplazo = 42; }
      if (dias >= 53 && dias < 78) { claveplazo = 63; }
      if (dias >= 78 && dias < 100) { claveplazo = 91; }
      if (dias >= 100 && dias < 137) { claveplazo = 120; }
      if (dias >= 137 && dias < 366) { claveplazo = 182; }
      if (dias >= 366 && dias < 379) { claveplazo = 378; }            
      return claveplazo;
	}
	
	public Integer obtenerClaveMonto(Double monto) {
		int clavemonto=0;
      if (monto >=         0 && monto <= 99999.99)   { clavemonto = 0; }
      if (monto >=    100000 && monto <= 249999.99) { clavemonto = 1; }
      if (monto >=    250000 && monto <= 499999.99) { clavemonto = 2; }
      if (monto >=    500000 && monto <= 7499999.99) { clavemonto = 3; }
      if (monto >=    750000 && monto <= 9999999.99) { clavemonto = 4; }
      if (monto >=   1000000 && monto <= 2499999.99) { clavemonto = 5; }
      if (monto >=   2500000 && monto <= 4999999.99) { clavemonto = 6; }
      if (monto >=   5000000 && monto <= 7499999.99) { clavemonto = 7; }
      if (monto >=   7500000 && monto <= 9999999.99) { clavemonto = 8; }
      if (monto >=  10000000 && monto <= 19999999.99) { clavemonto = 9; }
      if (monto >=  20000000 && monto <= 49999999.99) { clavemonto = 10; }
      if (monto >=  50000000 && monto <= 99999999.99) { clavemonto = 11; }
      if (monto >= 100000000 && monto <= 199999999.99) { clavemonto = 12; }
      if (monto >= 200000000) { clavemonto = 13; }
      return clavemonto;
	}
	
	public String validaMontos(String valor) {
		valor = valor.replace("\"", "");
		valor = valor.replace("$", "");
		valor = valor.replace(",", "");
		return valor;
	}
	
	//ARCHIVO REGISTRO SOLICITUDES
	@Override
	public MensajeDTO cargaArchivoRegistroSolicitudes(String file) throws GenericException, IOException, ParseException {
		MensajeDTO msg = new MensajeDTO();
		String message;
		Path testFile = Files.createTempFile("ArchivoSolicitudes", ".txt");
		byte[] decoder = Base64.getDecoder().decode(file);
		Files.write(testFile, decoder);
      	message = leerArchivoRegistroSolicitudes(testFile);
      	testFile.toFile().delete();
      	msg.setMensajeInfo("Aviso");
      	msg.setMensajeConfirm(message);
      	return msg;
	}

	public String leerArchivoRegistroSolicitudes(Path tempFile) throws IOException, GenericException, ParseException{
		try {
			String linea;
			String[] valores;
			Long maxID;
			Integer id = 0, tasa100Porc = 0;
			FileReader f = new FileReader(tempFile.toFile());
	        BufferedReader b = new BufferedReader(f);
	        List<AutocetesDTO> listaAutoCetes = new ArrayList<AutocetesDTO>();
	        List<AutoTasasDTO> listaAutotasas = new ArrayList<AutoTasasDTO>();
	        DecimalFormat formato1 = new DecimalFormat("#.00");
	        
	        listaAutoCetes = autoCetesJDBCRepository.obtenerAutoCetes();
	        maxID = autoTasasJDBCRepository.obtieneUltiFolioTasas();
	        if(listaAutoCetes.size() == 0) { return "Favor de avisar a la UEC que cargue los cetes Falta informacion de CETES. "; }
	        
	        log.info("Id: " + maxID);
	        while ((linea= b.readLine()) != null) {
	        	valores = linea.split("\t");
	        	AutoTasasDTO tasa = new AutoTasasDTO();
	        	tasa.setFechaSolic(fechaTimeStamp(valores[0]));
	        	tasa.setFechaAutori(fechaTimeStamp(valores[1]));
	        	tasa.setFechaProcess(fechaTimeStamp(valores[2]));
	        	tasa.setFechaEstatus(fechaTimeStamp(valores[3]));
	        	tasa.setIsProcess(0);
	        	tasa.setStatus(valores[4]);
	        	tasa.setSucSolic(Integer.parseInt(valores[5]));
	        	tasa.setDivision(valores[6]);
	        	tasa.setNumCte(Integer.parseInt(valores[7]));
	        	tasa.setNomCte(valores[8]);
	        	tasa.setContrato(valores[9]);
	        	tasa.setNomina(valores[10]);
	        	tasa.setNomEjec(valores[11]);
	        	tasa.setMonto(Double.parseDouble(valores[12].replace("\"", "").replace("$", "").replace(",", ""))); //VERIFICAR CAMPO BD
	        	tasa.setPlazo(Integer.parseInt(valores[13]));
	        	tasa.setTasaAutori(valores[14] == null ? 0 : Double.parseDouble(valores[14]));
	        	tasa.setTipoAutori(valores[15]); //ID_OFERTA
	        	tasa.setIdCampana(valores[16]);
	        	tasa.setSoeidAutori(valores[17]);
	        	tasa.setInicAutori(valores[18]);
	        	tasa.setNumAutoriUEC(Integer.parseInt(valores[19]));
	        	tasa.setSoeidAsig(valores[20]);
	        	tasa.setSoeidProc(valores[21]);
	        	tasa.setSoeidOpe(valores[22]);
	        	if(tasa.getTipoAutori().equals("DISTRITALES") || tasa.getTipoAutori().equals("DIVISIONALES") || tasa.getTipoAutori().equals("EXCEPGERENCIA")) {
	        		for(AutocetesDTO item: listaAutoCetes) { if(item.getIdPlazo() == tasa.getPlazo()) { tasa100Porc = item.getCete(); }; }
	        		log.info("Porcen: " + tasa100Porc);
	        		if(tasa100Porc > 0) {
	        			Double total = (tasa.getTasaAutori() * 100) / tasa100Porc;
		        		String valor = formato1.format(total);
		        		log.info("Total: " + valor);
		        		tasa.setPorcenCete(Double.parseDouble(valor));
		        		log.info("Porcen Cete: " + tasa.getPorcenCete());
	        		}else {
	        			tasa.setPorcenCete(0.0);
	        		}
	        	}
	        	tasa.setCete(tasa100Porc);
	        	tasa.setIdOferta(valores[15]); 
	        	listaAutotasas.add(tasa);
	    		id++;
	        }
	        b.close();
	        
	        for(AutoTasasDTO value: listaAutotasas) {
	        	maxID++;
	        	value.setIdTasaAuto(maxID);
	        	value.setIsTasaBase(evaluartasaBase(value.getTipoAutori()));
	        }
	        
	        autoTasasJDBCRepository.batchInsert(listaAutotasas, 500);
	        return "Se cargaron " + id + " registros.";
		}catch (Exception e) {
			e.getStackTrace();
          throw new GenericException( "Error al cargar el Archivo Registro de Solicitudes :: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	public Date fechaTimeStamp(String fecha) throws GenericException {
		try {
			SimpleDateFormat formatoCompleto = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String año = fecha.substring(0, 4); String mes = fecha.substring(5, 7); String dia = fecha.substring(8, 10); String hora = fecha.substring(11, 19);
			log.info("Fecha original: " + fecha);
			fecha = dia + "-" + mes + "-" + año + " " + hora;
			log.info("Fecha construida: " + fecha);
			Date formatFecha = formatoCompleto.parse(fecha);
			log.info("Fecha date: " + formatFecha);
			fecha = formatoCompleto.format(formatFecha);
			log.info("Fecha: " + fecha);
			
			return formatoCompleto.parse(fecha);
		}catch (Exception e) {
			e.getStackTrace();
	          throw new GenericException( "Error al cargar el Archivo Registro de Solicitudes :: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	public Integer evaluartasaBase(String campana) throws GenericException {
		try {
			Integer tasa = 0;
			
			if (campana.equals("DIVISIONAL") || campana.equals("DISTRITAL") || campana.equals("EXCEPGERENCIA")
              || campana.equals("PORTAESPNOM") || campana.equals("CANCELPORTA2020")) {
				tasa = 1;
			}
			
			if (campana.equals("RETEN2021") || campana.equals("RETENSDO12021") || campana.equals("RETENSDO22021") ||
              campana.equals("RETENSDO32021") || campana.equals("RETENSDO42021") || campana.equals("PORTASAFIJA") || 
              campana.equals("HIPOTECA2021")) {
				tasa = 2;
			}
				
			return tasa;
		}catch (Exception e) {
			e.getStackTrace();
          throw new GenericException( "Error al evaluar la Tasa Base :: " , HttpStatus.NOT_FOUND.toString());
      }
	}

	
	//ARCHIVO AUTORIZADORES
	@Override
	public MensajeDTO cargaArchivoAutorizadores(String file, String fecha) throws GenericException, IOException, ParseException {
		MensajeDTO msg = new MensajeDTO();
		String message;
		Path testFile = Files.createTempFile("ArchivoAutorizadores", ".txt");
		byte[] decoder = Base64.getDecoder().decode(file);
		Files.write(testFile, decoder);
      	message = leerArchivoAutorizadores(testFile, fecha);
      	testFile.toFile().delete();
      	msg.setMensajeInfo("Aviso");
      	msg.setMensajeConfirm(message);
      	return msg;
	}
	
	public String leerArchivoAutorizadores(Path tempFile, String fecha) throws IOException, GenericException, ParseException{
		try {
			String linea;
			String[] valores;
			Date fechaActual = new Date();
			FileReader f = new FileReader(tempFile.toFile());
	        BufferedReader b = new BufferedReader(f);
	        List<TbTasasDTO> listaAutorizadores = new ArrayList<TbTasasDTO>();
	        List<TbTasasDTO> listaInsumosPorActualizar = new ArrayList<TbTasasDTO>();
	        List<TbTasasDTO> listaAutorizadorEncontrado = new ArrayList<TbTasasDTO>();
	        List<TbTasasDTO> listaInsumosPlatino = new ArrayList<TbTasasDTO>();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
	        
	        log.info("Fecha Actual Archivo Autorizadores: " + format.format(fechaActual));
	        listaInsumosPlatino = tasasJDBCRepository.selectRegTasas(format.format(fecha), 0);
	        
	        if(fecha.isEmpty()) {
				return "Falta la fecha de registros, Es la fecha de los registros que serán actualizados";
			}
	        
	        while ((linea= b.readLine()) != null) {
	        	valores = linea.split("\t");
	        	if(valores.length > 25) {
	        		if(StringUtils.isNumeric(valores[2]) && !valores[0].isEmpty()) {
	        			TbTasasDTO tasa = new TbTasasDTO();
	        			tasa.setNumAutoriUEC(Integer.parseInt(valores[2]));
	        			tasa.setAutorizador(valores[12].trim());
	        			tasa.setCete(Integer.parseInt(valores[15].trim()));
	        			tasa.setPorcenCete(Integer.parseInt(valores[16].replace("%", "")));
	        			tasa.setNumcte(Long.parseLong(valores[3].trim()));
	        			tasa.setNomCte(valores[6].trim());
	        			tasa.setObservaWeb(valores[11].trim());
	        			listaAutorizadores.add(tasa);
	        		}
	        	}
	        	
	        }
	        b.close();
	        
	        for(TbTasasDTO item : listaInsumosPlatino) {
	        	TbTasasDTO nuevaTasa = new TbTasasDTO();
	        	listaAutorizadores.forEach(c -> {if(c.getNumAutoriUEC() == item.getNumAutoriUEC()) { listaAutorizadorEncontrado.clear(); listaAutorizadorEncontrado.add(c); } });
	        	if(listaAutorizadorEncontrado.size() > 0) {
	        		nuevaTasa.setCete(listaAutorizadorEncontrado.get(0).getCete());
	        		nuevaTasa.setPorcenCete(listaAutorizadorEncontrado.get(0).getPorcenCete());
	        		nuevaTasa.setAutorizador(listaAutorizadorEncontrado.get(0).getAutorizador());
	        		nuevaTasa.setNumAutoriUEC(listaAutorizadorEncontrado.get(0).getNumAutoriUEC());
	        		nuevaTasa.setNumcte(listaAutorizadorEncontrado.get(0).getNumcte());
	        		nuevaTasa.setNomCte(listaAutorizadorEncontrado.get(0).getNomCte());
	        		nuevaTasa.setIdTasa(item.getIdTasa());
	        		nuevaTasa.setObservaWeb(listaAutorizadorEncontrado.get(0).getObservaWeb());
	        		listaInsumosPorActualizar.add(nuevaTasa);
	        	}
	        }
	        
	        tasasJDBCRepository.updateAutorizadoresTasas(listaInsumosPorActualizar);
			return "El archivo se importó existosamente.";
		}catch (Exception e) {
			e.getStackTrace();
	          throw new GenericException( "Error al cargar el Archivo Autorizadores :: " , HttpStatus.NOT_FOUND.toString());
		}
	}

	//CALCULO AUTORIZADORES
	@Override
	public MensajeDTO calculoRestantes(String fecha) throws GenericException, IOException, ParseException {
		MensajeDTO msg = new MensajeDTO();
		
		if(fecha.isEmpty() || fecha == null) {
			msg.setMensajeInfo("Alerta");
			msg.setMensajeConfirm("Falta la fecha de registros, es la fecha de los registros que serán ajustados.");
			return msg;
		}
		
		actualizarSucursalesBandejaWEB(FormatUtils.stringToDate(fecha));
		tasasJDBCRepository.updateTasasAutorizadas(fecha);
		calRestantes(fecha);
		validadorRegistrosDiarios(fecha);
		
		msg.setMensajeInfo("Aviso");
		msg.setMensajeConfirm("Calculos-Ajustes realizados exitosamente.");
		return msg;
	}
	
	public void calRestantes(String fecha) throws GenericException {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String date = formato.format(formato.parse(fecha));
			log.info("Fecha calculo: " + date);
			tasasJDBCRepository.updatetasasTipoAutorizador(date);
			tasasJDBCRepository.updateTasasBeiClientes(date);
			log.info("Paso SP");
			tasasJDBCRepository.updateTasasTPer(date);
			//tasasJDBCRepository.updateTasasTPerxCatGralCtes(date);
			autoTasasJDBCRepository.updateCatGralCtes(date);
			tasasJDBCRepository.updateTasasTPerxVacio(date);
		}catch (Exception e) {
			e.getStackTrace();
	          throw new GenericException( "Error al calcular los restantes :: " , HttpStatus.NOT_FOUND.toString());
		}
	}

	public void validadorRegistrosDiarios(String fecha) throws GenericException {
		try {
			List<TasasCampanaDTO> listaInsumosUEC = new ArrayList<TasasCampanaDTO>();
			List<TasasCampanaDTO> listaInsumosUECSabado = new ArrayList<TasasCampanaDTO>();
			List<TbTasasDTO> listaInsumosPlatinoDiario = new ArrayList<TbTasasDTO>();
			List<TasasCampanaDTO> listaSolicitudEncontrada = new ArrayList<TasasCampanaDTO>();
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
			SimpleDateFormat formatoCompleto = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
			log.info("Paso 1.1");
			log.info("Fecha completa 2: " + formatoCompleto.format(FormatUtils.stringToDate(fecha)));
			listaInsumosUEC = autoTasasJDBCRepository.selectTasaCampaña(formato.format(FormatUtils.stringToDate(fecha)), formato.format(FormatUtils.stringToDate(fecha)));
			Calendar c = Calendar.getInstance();
			c.setTime(FormatUtils.stringToDate(fecha));
			Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			log.info("Paso 1");
			if(dayOfWeek == Calendar.MONDAY) {
				Date fechaAnterior = DateUtils.addDays(FormatUtils.stringToDate(fecha), -2);
				String dateLast = formato.format(fechaAnterior);
				listaInsumosUECSabado = autoTasasJDBCRepository.selectTasaCampaña(dateLast, dateLast);
			}
			log.info("Paso 2");
			if(listaInsumosUECSabado.size() > 0) {
				listaInsumosUEC.addAll(listaInsumosUECSabado);
			}
			
			listaInsumosPlatinoDiario = tasasJDBCRepository.selectRegTasas(fecha, 0);
			
			log.info("Paso 3");
			for(TbTasasDTO platino: listaInsumosPlatinoDiario) {
				listaInsumosUEC.forEach(x -> { if(x.getNumAutoriUEC() == platino.getNumAutoriUEC()) { log.info("Num Autori UEC: " + platino.getNumAutoriUEC());  listaSolicitudEncontrada.add(x); } });
				
				log.info("Paso 4");
				log.info("Solicitudes Encontradas: " + listaSolicitudEncontrada.size());
				if(listaSolicitudEncontrada.size() > 0) {
					for(TasasCampanaDTO uec: listaSolicitudEncontrada) {
						platino.setIsActualizar(0);
						
						if(!uec.getTipoAutori().equals(platino.getCampanaWeb())) {
							platino.setIsActualizar(1);
							platino.setCampanaWeb(uec.getTipoAutori().trim());
						}
						
						//NUEVO
						if(!uec.getDivision().trim().equals(platino.getDivision())) {
							platino.setIsActualizar(1);
							platino.setDivision(uec.getDivision());
						}
						
						//NUEVO
						if(!uec.getObservaWeb().trim().equals(platino.getObservaWeb().trim())) {
							platino.setIsActualizar(1);
							platino.setObservaWeb(uec.getObservaWeb().trim());
						}
						
						//NUEVO
						if(!uec.getNomEjec().trim().equals(platino.getNomEjec().trim())) {
							platino.setIsActualizar(1);
							platino.setNomEjec(uec.getNomEjec().trim());
						}
						
						//NUEVO
						if(!uec.getNomCte().trim().equals(platino.getNomCte().trim())) {
							platino.setIsActualizar(1);
							platino.setNomCte(uec.getNomCte().trim());
						}
						
						//NUEVO
						if(!formato.format(platino.getFechaEstatus()).equals("01/01/99")) {
							if(!uec.getFechaEstatus().equals(platino.getFechaEstatus())) {
								platino.setIsActualizar(1);
								platino.setFechaEstatus(uec.getFechaEstatus());
							}	
						}
						
						//NUEVO
						if(!formato.format(platino.getFechacap()).equals("01/01/99")) {
							if(!uec.getFechaProcess().equals(platino.getFechacap())) {
								platino.setIsActualizar(1);
								platino.setFechacap(uec.getFechaProcess());
							}
						}
						
						if(uec.getNumCte() != platino.getNumcte()) {
							platino.setIsActualizar(1);
							platino.setNumcte(uec.getNumCte());
						}
						
						if(Long.parseLong(uec.getContrato()) != platino.getContrato()) {
							platino.setIsActualizar(1);
							platino.setContrato(Long.parseLong(uec.getContrato()));
						}
						
						if(uec.getSucSolic() != platino.getSucSolic()) {
							platino.setIsActualizar(1);
							platino.setSucSolic(uec.getSucSolic());
						}
						
						if((double)uec.getMonto() != platino.getMonto()) {
							platino.setIsActualizar(1);
							platino.setMonto((double) uec.getMonto());
						}
						
						if(uec.getPlazo() != platino.getPlazo()) {
							platino.setIsActualizar(1);
							platino.setPlazo(uec.getPlazo());
						}
						
						if(!uec.getSoeidAsig().trim().equals(platino.getAsignadoA().trim())) {
							platino.setIsActualizar(1);
							platino.setAsignadoA(uec.getSoeidAsig().trim());
						}
						
						if(!uec.getSoeidOpe().trim().equals(platino.getOperadoPor().trim())) {
							platino.setIsActualizar(1);
							platino.setOperadoPor(uec.getSoeidOpe().trim());
						}
						
						if(evaluarTasaBaseRegistrosDiarios(uec.getTipoAutori().trim()) != platino.getIsTasaBase()) {
							platino.setIsActualizar(1);
							platino.setIsTasaBase(evaluarTasaBaseRegistrosDiarios(uec.getTipoAutori().trim()));
							
							if(platino.getIsTasaBase() == 1) {
								if(platino.getAutorizador().isEmpty() || platino.getAutorizador() == null) {
									platino.setAutorizador(uec.getSoeidAsig().length() == 5 ? uec.getSoeidAsig() : autoTasasJDBCRepository.obtieneAutorizadorAutoTasas(uec.getIdTasaAuto()));
								}
							}
						}
						
						if(platino.getIsTasaBase() == 1) {
							if(platino.getAutorizador().isEmpty() || platino.getAutorizador() == null) {
								platino.setAutorizador(uec.getSoeidAutori().length() == 5 ? uec.getSoeidAutori() : autoTasasJDBCRepository.obtieneAutorizadorAutoTasas(uec.getIdTasaAuto()));
							}
						}
						
						if(platino.getIsWeb() != 1) {
							platino.setIsActualizar(1);
							platino.setIsWeb(1);
						}
						
						if(!uec.getNomina().trim().equals(platino.getNomina().trim())) {
							platino.setIsActualizar(1);
							platino.setNomina(uec.getNomina());
						}
						
						log.info("Actualizacion");
						if(platino.getIsActualizar() == 1) {
							tasasJDBCRepository.updateValidacionPlatino(platino);
						}
					}
				}
			}
			
		}catch (Exception e) {
			e.getStackTrace();
	        throw new GenericException( "Error al validar los registros diarios :: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	public Integer evaluarTasaBaseRegistrosDiarios(String campana) throws GenericException {
		try {
			 Integer n = 0;
	            if (campana.equals("DIVISIONALES") || campana.equals("DISTRITALES") || campana.equals("EXCEPGERENCIA") 
	                || campana.equals("PORTAESPNOM") || campana.equals("CANCELPORTA2020")) {
	                n = 1;
	            }
	            if (campana.contains("PTU2021") || campana.equals("PTUSDO12021") || campana.equals("PTUSDO22021") ||
	                campana.equals("PTUSDO32021") || campana.equals("PTUSDO42021") || campana.equals("PTUSDO52021") || campana.equals("CREDNOM2021")
	                || campana.equals("HIPOTECA2021") || campana.equals("CREDONLY2021105") || campana.equals("CREDONLY2021110")) {
	                n = 2;
	            }

	            return n;
		}catch (Exception e) {
			e.getStackTrace();
	        throw new GenericException( "Error al validar la tasa base :: " , HttpStatus.NOT_FOUND.toString());
		}
	}

	//ELIMINAR DÍA DE CARGA
	@Override
	public MensajeDTO eliminarDiaCarga(String fecha) throws GenericException, IOException, ParseException {
		MensajeDTO msg = new MensajeDTO();
		String fechaEliminacion = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		List<LogEliminacionDTO> listaLog = new ArrayList<LogEliminacionDTO>();
		LogEliminacionDTO logg = new LogEliminacionDTO();
		Integer id = 0;
		
		if(fecha.isEmpty() || fecha == null) {
			msg.setMensajeInfo("Alerta");
			msg.setMensajeConfirm("Falta la fecha de operación, Es la fecha de los registros que serán eliminados");
			return msg;
		}
		
		id = logEliminacionJDBCRepository.obtieneMax();
		id++;
		logg.setId(id);
		logg.setSoeid(""); //VERIFICAR VALOR
		logg.setFecha_ope(FormatUtils.stringToDate(fecha));
		log.info("Fecha eliminacion: " + fechaEliminacion);
		logg.setFecha_elim(FormatUtils.stringToDate(fechaEliminacion));
		listaLog.add(logg);
		
		log.info("Fecha ingreso: " + formato.format(formato.parse(fecha)));
		tasasJDBCRepository.deleteFechaOperacion(formato.format(formato.parse(fecha)));
		logEliminacionJDBCRepository.batchInsert(listaLog, 500);
		
		msg.setMensajeInfo("Aviso");
		msg.setMensajeConfirm("Registros eliminados, todas las tasas de la fecha: " + fecha + " han sido eliminadas");
		return msg;
	}

	//DESCARGA ARCHIVO DIA CARGA
	@Override
	public ArchivoDiaCargaDTO reporteArchivoDiaCarga(String fecha1, String fecha2) throws GenericException, IOException, ParseException {
		try {
			ArchivoDiaCargaDTO msg = new ArchivoDiaCargaDTO();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			log.info("Fecha 1: " + formato.format(formato.parse(fecha1)) + " , Fecha 2:" + formato.format(formato.parse(fecha2)));
			Path fileDiaCarga = Files.createTempFile("TasasPorta", ".txt");
			fileDiaCarga.toFile().deleteOnExit();
			FileOutputStream test = new FileOutputStream(fileDiaCarga.toFile());
			String content;
			
			List<LogEliminacionDTO> listaLog = logEliminacionJDBCRepository.selectLogEliminacion(formato.format(formato.parse(fecha1)), formato.format(formato.parse(fecha2)));
			
			if(listaLog.isEmpty()) { throw new GenericException( "No hay registros en la tabla Log Eliminacion ::", HttpStatus.NOT_FOUND.toString()); }
			
			test.write(ConstantUtils.ENCABEZADO_ARCH_CARGA_DIA.getBytes(StandardCharsets.UTF_8));
			for(LogEliminacionDTO value : listaLog) {
				content = "";
				content += value.getSoeid().concat("\t").concat(formato.format(value.getFecha_ope())).concat("\t").concat(formato.format(value.getFecha_elim())).concat("\n");
				test.write(content.getBytes(StandardCharsets.UTF_8));
			}
			
			
			String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(fileDiaCarga.toFile()));
			msg.setFile(ecoder);
			return msg;
		}catch (Exception e) {
			e.getStackTrace();
	        throw new GenericException( "Error al crear el reporte día carga :: " , HttpStatus.NOT_FOUND.toString());
		}
	}

	//BUSQUEDA SOLICITUDES APLICADAS SIN DATOS
	@Override
	public BusquedaSolicitudesAplicadasDTO busquedaSolicitudesAplicadasSinDatos(String fechaBusqueda) 
			throws GenericException, IOException, ParseException {
		try {
			BusquedaSolicitudesAplicadasDTO msg = new BusquedaSolicitudesAplicadasDTO();
			List<SolicitudesAplicadasSinDatosDTO> listaSolicitudes = new ArrayList<SolicitudesAplicadasSinDatosDTO>(); 
			listaSolicitudes = tasasJDBCRepository.obtenerRegTasasSinDatos(fechaBusqueda);
			msg.setListaSolicitudes(listaSolicitudes);
			return msg;	
		}catch (Exception e) {
			e.getStackTrace();
	          throw new GenericException( "Error al realizar la busqueda de Solicitudes Aplicadas :: " , HttpStatus.NOT_FOUND.toString());
		}
	}

	//REPORTE CAMPAÑA DETALLE OPERACIÓN 
	@Override
	public BusquedaCampanaDetalleDTO reporteCampanaDetalleOpe(String fecha1, String fecha2, Integer reporte)
			throws GenericException, IOException, ParseException {
		try {
			BusquedaCampanaDetalleDTO msg = new BusquedaCampanaDetalleDTO();
			List<TasasCampanaDTO> listaInsumosWEB = new ArrayList<TasasCampanaDTO>();
			List<TasasCampanaDTO> listaInsumosWEBMorales = new ArrayList<TasasCampanaDTO>();
			List<TasasCampanaDTO> listaInsumosWEBFisicas = new ArrayList<TasasCampanaDTO>();
			SimpleDateFormat formatoCompleto = new SimpleDateFormat("dd/MM/yy");
			SimpleDateFormat fc = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Calendar c = Calendar.getInstance();
			c.setTime(FormatUtils.stringToDate(fecha1));
			Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK); 
					
			log.info("Fecha1: " + formatoCompleto.format(FormatUtils.stringToDate(fecha1)));
			log.info("Fecha2: " + formatoCompleto.format(FormatUtils.stringToDate(fecha2)));
			listaInsumosWEB = autoTasasJDBCRepository.selectTasaCampaña(formatoCompleto.format(FormatUtils.stringToDate(fecha1)), formatoCompleto.format(FormatUtils.stringToDate(fecha2)));
			
			if(dayOfWeek == Calendar.MONDAY) {
				Date fechaAnterior = DateUtils.addDays(FormatUtils.stringToDate(fecha1), -2);
				String dateLast = formatoCompleto.format(fechaAnterior);
				listaInsumosWEB.addAll(autoTasasJDBCRepository.selectTasaCampaña(dateLast, dateLast));
			}
			
			//LLENAR TIPO PERSONA
			for(TasasCampanaDTO value: listaInsumosWEB) {
				Date vigencia = FormatUtils.sumarRestarDiasFecha(fechaActual(), value.getPlazo());
				SimpleDateFormat vig = new SimpleDateFormat("dd/MM/yyyy");
				value.setFechaVigencia(vig.format(vigencia));
				if(autoTasasJDBCRepository.validaOfertaExistente(value.getTipoAutori()) >= 1) {
					value.setOfertaParticipacionUnica(autoTasasJDBCRepository.obtieneOfertaParticipacionUnica(value.getTipoAutori()));
					value.setCampana(autoTasasJDBCRepository.obtieneOfertaCampaña(value.getTipoAutori()));
				}
				
				if(value.getEstatus2() == 1) {
					value.setAplicado("SI");
				}else if (value.getEstatus2() != 1) {
					value.setAplicado("NO");
				}
			}
			
			listaInsumosWEB.forEach(x -> { if(x.getTipoPersona() == 2) { listaInsumosWEBMorales.add(x); } });
			listaInsumosWEB.forEach(t -> { if(t.getTipoPersona() != 2) { listaInsumosWEBFisicas.add(t); } });
			
			if(reporte == 1) {
				List<List<String>> filas = procesoDatosF(listaInsumosWEBFisicas);
				List<List<String>> filas2 = procesoDatosM(listaInsumosWEBMorales);
				List<String> encabezado = Arrays.asList(ConstantUtils.TITLE_DETALLE_OPE);
				List<String> encabezado2 = Arrays.asList(ConstantUtils.TITLE_DETALLE_M);
				Path excel = createExcelDO(encabezado, filas, encabezado2, filas2,""); 
				String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(excel.toFile()));
				msg.setReporte(ecoder);
			}
			
			msg.setConsultaCampanaFisicas(listaInsumosWEBFisicas);
			msg.setConsultaCampanaMorales(listaInsumosWEBMorales);			
			return msg;	
		} catch (Exception e) {
			e.getStackTrace();
	          throw new GenericException( "Error al generar el reporte Campaña Detalle Operacion :: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	private List<List<String>> procesoDatosM(List<TasasCampanaDTO> moral) throws GenericException{
		try {
			SimpleDateFormat fc = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			DecimalFormat dec = new DecimalFormat("#.00");
			List<List<String>> filas = new ArrayList<>();
			for(TasasCampanaDTO value: moral) {
				List<String> fila = new ArrayList<String>();
				fila.add(value.getIdTasaAuto().toString());
				fila.add(value.getNumAutoriUEC().toString()); 
				fila.add(value.getFechaS());
				fila.add(value.getFechaE());
				fila.add(value.getSoeidAsig());
				fila.add(value.getSoeidOpe());
				fila.add(value.getObservaWeb());
				fila.add(value.getDivision());
				fila.add(value.getDistrito());
				fila.add(value.getSucursal());
				fila.add(value.getEstatus());
				fila.add(value.getAplicado());
				fila.add(value.getTipoAutori()); //PRODUCTO
				fila.add(value.getIdCampana()); //CAMPAÑA
				if(value.getTipoPersona() == 1) {
					fila.add("PF");
				}else if(value.getTipoPersona() == 2) {
					fila.add("PM");
				}else if(value.getTipoPersona() == 3) {
					fila.add("PFAE");
				}
				fila.add(value.getContrato());
				fila.add(value.getNumCte().toString());
				fila.add(value.getNomCte());
				fila.add(value.getNumInver().toString()); 
				fila.add("$" + value.getMonto().toString()); 
				fila.add(value.getPlazo().toString());
				fila.add(value.getTasa().toString());
				fila.add(value.getFechaVigencia());
				fila.add(value.getCert());
				fila.add(value.getGatNominalOferta());
				fila.add(value.getGatRealOferta());
				fila.add(value.getRendimiento().toString());
				fila.add(value.getOfertaParticipacionUnica());
				fila.add(value.getSucSolic().toString());
				fila.add(value.getSoeidEjecSuc());
				fila.add(value.getNomina());
				fila.add(value.getNomEjec());
				fila.add(value.getSoeidAutori());
				filas.add(fila);
			}
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
	          throw new GenericException( "Error al generar el reporte Campaña Detalle Operacion :: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	private List<List<String>> procesoDatosF(List<TasasCampanaDTO> fisica) throws GenericException{
		try {
		SimpleDateFormat fc = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		DecimalFormat dec = new DecimalFormat("#.00");
		List<List<String>> filas = new ArrayList<>();
		for(TasasCampanaDTO value: fisica) {
			List<String> fila = new ArrayList<String>();
			fila.add(value.getIdTasaAuto().toString());
			fila.add(value.getNumAutoriUEC().toString());
			fila.add(value.getFechaS());
			fila.add(value.getFechaE());
			fila.add(value.getSoeidAsig());
			fila.add(value.getSoeidOpe());
			fila.add(value.getObservaWeb());
			fila.add(value.getDivision());
			fila.add(value.getDistrito());
			fila.add(value.getSucursal());
			fila.add(value.getEstatus());
			fila.add(value.getAplicado());
			fila.add(value.getTipoAutori()); //PRODUCTO
			fila.add(value.getIdCampana()); //CAMPAÑA
			if(value.getTipoPersona() == 1 || value.getTipoPersona() == 0) {
				fila.add("PF");
			}else if(value.getTipoPersona() == 2) {
				fila.add("PM");
			}else if(value.getTipoPersona() == 3) {
				fila.add("PFAE");
			}
			fila.add(value.getContrato());
			fila.add(value.getNumCte().toString());
			fila.add(value.getNomCte());
			fila.add(value.getNumInver().toString());
			fila.add("$" + value.getMonto().toString()); 
			fila.add(value.getPlazo().toString());
			fila.add(value.getTasa().toString());
			fila.add(value.getFechaVigencia());
			fila.add(value.getCert()); 
			fila.add(value.getGatNominalOferta());
			fila.add(value.getGatRealOferta());
			fila.add(value.getRendimiento().toString());
			fila.add(value.getOfertaParticipacionUnica());
			fila.add(value.getSucSolic().toString());
			fila.add(value.getFolioPDFEspecial());				
			fila.add(value.getIsPortabilidad()); 		
			fila.add(value.getSoeidEjecSuc());
			fila.add(value.getNomina());
			fila.add(value.getNomEjec());
			fila.add(value.getSoeidAutori());
			filas.add(fila);
		}
		return filas;	
		}catch (Exception e) {
			e.getStackTrace();
	          throw new GenericException( "Error al generar el reporte Campaña Detalle Operacion :: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	public static Path createExcelDO(List<String> titulos, List<List<String>> renglones,List<String> titulos2, List<List<String>> renglones2, String nameFile ) throws IOException {
        Path testFile = Files.createTempFile("CampanaDetalleOperacion", ".xlsx");
        testFile.toFile().deleteOnExit();
        try(XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("PerFísica");
            int colHeader = 0;
            Row rowheader = sheet.createRow(colHeader++);
            int colCell = 0;
            for (String field : titulos) {
                Cell cell = rowheader.createCell(colCell++);
                if (field instanceof String) {
                	CellStyle style = workbook.createCellStyle();
                	XSSFFont font = workbook.createFont();
                	font.setBold(true);
                	style.setFont(font);
                	cell.setCellStyle(style);
                    cell.setCellValue((String) field);
                }
            }
            int rowNum = 1;
            for (List<String> key : renglones) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (String field : key) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    }
                }
            }
            
            XSSFSheet sheet2 = workbook.createSheet("PerMoral");
            int colHeader2 = 0;
            Row rowheader2 = sheet2.createRow(colHeader2++);
            int colCell2 = 0;
            for (String field2 : titulos2) {
                Cell cell2 = rowheader2.createCell(colCell2++);
                if (field2 instanceof String) {
                	CellStyle style2 = workbook.createCellStyle();
                	XSSFFont font2 = workbook.createFont();
                	font2.setBold(true);
                	style2.setFont(font2);
                	cell2.setCellStyle(style2);
                    cell2.setCellValue((String) field2);
                }
            }
            int rowNum2 = 1;
            for (List<String> key : renglones2) {
                Row row = sheet2.createRow(rowNum2++);
                int colNum2 = 0;
                for (String field2 : key) {
                    Cell cell2 = row.createCell(colNum2++);
                    if (field2 instanceof String) {
                        cell2.setCellValue((String) field2);
                    }
                }
            }
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workbook.write(bos);
            bos.close();
            Files.write(testFile, bos.toByteArray());
        }
        return testFile;
    }

	
	@Override
	public BusquedaCampanaResumenDTO reporteCampanaResumen(String fecha1, String fecha2)
			throws GenericException, IOException, ParseException {
		try {
			BusquedaCampanaResumenDTO msg = new BusquedaCampanaResumenDTO();
			List<TasasCampanaDTO> listaInsumosWEB = new ArrayList<TasasCampanaDTO>();
			List<CampanaEstatusDTO> listaEstatus = new ArrayList<CampanaEstatusDTO>();
			List<CampanaTipoAutoriDTO> listaCampana = new ArrayList<CampanaTipoAutoriDTO>();
			List<ResumenCampanaDTO> resumen = new ArrayList<ResumenCampanaDTO>();
			List<TasasCampanaDTO> listaInsumosWEBMorales = new ArrayList<TasasCampanaDTO>();
			List<TasasCampanaDTO> listaInsumosWEBFisicas = new ArrayList<TasasCampanaDTO>();
			SimpleDateFormat formatoCompleto = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			
			Calendar c = Calendar.getInstance();
			c.setTime(FormatUtils.stringToDate(fecha1));
			Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			Integer cont = 0, noClasif = 0, PF = 0, PM = 0;
			Double monto = 0.0;
			
			listaInsumosWEB = autoTasasJDBCRepository.selectTasaCampaña(formatoCompleto.format(FormatUtils.stringToDate(fecha1)), formatoCompleto.format(FormatUtils.stringToDate(fecha2)));
			
			if(dayOfWeek == Calendar.MONDAY) {
				Date fechaAnterior = DateUtils.addDays(FormatUtils.stringToDate(fecha1), -2);
				String dateLast = formatoCompleto.format(fechaAnterior);
				listaInsumosWEB.addAll(autoTasasJDBCRepository.selectTasaCampaña(dateLast, dateLast));
			}
			
			listaInsumosWEB.forEach(i -> { CampanaEstatusDTO item = new CampanaEstatusDTO(); item.setEstatus(i.getEstatus()); listaEstatus.add(item); });
			listaInsumosWEB.forEach(x -> { CampanaTipoAutoriDTO item = new CampanaTipoAutoriDTO(); item.setCampana(x.getTipoAutori()); listaCampana.add(item); }); 
			
			//DISTINCT ESTATUS
			Set<String> contentSet = new HashSet<>();
			listaEstatus.removeIf(value -> !contentSet.add(value.getEstatus()));
			listaEstatus.sort(Comparator.comparing(CampanaEstatusDTO::getEstatus));
	        
			//DISTINCT CAMPAÑA
			Set<String> contentCampana = new HashSet<>();
			listaCampana.removeIf(value -> !contentCampana.add(value.getCampana()));
			listaCampana.sort(Comparator.comparing(CampanaTipoAutoriDTO::getCampana));
	        
			for(CampanaEstatusDTO item: listaEstatus) {
				ResumenCampanaDTO reporte = new ResumenCampanaDTO();
				Double montoEstatus = 0.0;
				Integer totalEstatus = 0;
				
				for(TasasCampanaDTO value: listaInsumosWEB) {
					if(item.getEstatus() == value.getEstatus()) {
						totalEstatus++;
						montoEstatus += value.getMonto(); 
					}
				}
				log.info("Estatus " + item.getEstatus() + ":" + totalEstatus);
				log.info("Monto: " + montoEstatus);
				
				monto += montoEstatus;
				cont += totalEstatus; 
				reporte.setEstatus(item.getEstatus()); reporte.setSubTotal(totalEstatus.toString()); reporte.setMonto(montoEstatus.toString());
				resumen.add(reporte);
			}
			
			ResumenCampanaDTO reporte1 = new ResumenCampanaDTO();
			log.info("Total Estatus " + cont + ": " + monto);
			reporte1.setCampana("TOTAL: "); reporte1.setEstatus(" "); reporte1.setSubTotal(cont.toString()); reporte1.setMonto(monto.toString());
			resumen.add(reporte1);
			
			ResumenCampanaDTO reporte2 = new ResumenCampanaDTO();
			//ESPACIO VACÍO
			reporte2.setCampana(" "); reporte2.setEstatus(" "); reporte2.setSubTotal(" "); reporte2.setMonto(" ");
			resumen.add(reporte2);
			

			log.info("WEB: "  + listaInsumosWEB.size() + " , PM: "+ listaInsumosWEBMorales.size() + " , PF: "+  listaInsumosWEBFisicas.size());
			noClasif = listaInsumosWEB.size() - listaInsumosWEBMorales.size() - listaInsumosWEBFisicas.size();
			PF = listaInsumosWEBFisicas.size();
			PM = listaInsumosWEBMorales.size();
			log.info("No Clasificados: " + noClasif);
			log.info("Morales: " + PM);
			log.info("Fisicas: " + PF);
			
			ResumenCampanaDTO reporte3 = new ResumenCampanaDTO();
			//TOTAL FISICAS
			reporte3.setCampana("Personas Físicas"); reporte3.setEstatus(" "); reporte3.setSubTotal("Total: "); reporte3.setMonto(PF.toString());
			resumen.add(reporte3);
			
			ResumenCampanaDTO reporte4 = new ResumenCampanaDTO();
			//TOTAL MORALES
			reporte4.setCampana("Personas Morales"); reporte4.setEstatus(" "); reporte4.setSubTotal("Total: "); reporte4.setMonto(PM.toString());
			resumen.add(reporte4);
			
			ResumenCampanaDTO reporte5 = new ResumenCampanaDTO();
			//TOTAL NO CLASIFICADAS
			reporte5.setCampana("No clasificadas"); reporte5.setEstatus(" "); reporte5.setSubTotal("Total: "); reporte5.setMonto(noClasif.toString());
			resumen.add(reporte5);
			
			ResumenCampanaDTO reportevacio = new ResumenCampanaDTO();
			//ESPACIO VACÍO
			reportevacio.setCampana(" "); reportevacio.setEstatus(" "); reportevacio.setSubTotal(" "); reportevacio.setMonto(" ");
			resumen.add(reportevacio);
			
			cont = 0; monto = 0.0;
			for(CampanaTipoAutoriDTO campana: listaCampana) {
				ResumenCampanaDTO reporte = new ResumenCampanaDTO();
				List<TasasTotal> cantidad = new ArrayList<TasasTotal>();
				for(CampanaEstatusDTO estatus: listaEstatus) {
					//QUERY
					cantidad = autoTasasJDBCRepository.selectTasaTotal(formatoCompleto.format(FormatUtils.stringToDate(fecha1)), 
							formatoCompleto.format(FormatUtils.stringToDate(fecha2)), campana.getCampana(), estatus.getEstatus());
					cont += cantidad.get(0).getTotal();
					monto += cantidad.get(0).getMonto();
					log.info("Campana: " + campana.getCampana() + " , Estatus: " + estatus.getEstatus());
					log.info("Total 2.0: " + cantidad.get(0).getTotal() + " , Monto: " + cantidad.get(0).getMonto());
					//TOTAL
					reporte.setCampana(campana.getCampana()); reporte.setEstatus(estatus.getEstatus()); 
					reporte.setSubTotal(cantidad.get(0).getTotal().toString()); reporte.setMonto(cantidad.get(0).getMonto().toString());
					resumen.add(reporte);
				}
			}
			
			ResumenCampanaDTO reporte6 = new ResumenCampanaDTO();
			log.info("Total 2: " + cont + " , Monto: " + monto);
			//TOTAL
			reporte6.setCampana("TOTAL: "); reporte6.setEstatus(" "); reporte6.setSubTotal(cont.toString()); reporte6.setMonto(monto.toString());
			resumen.add(reporte6);
			
			ResumenCampanaDTO reporte7 = new ResumenCampanaDTO();
			//ESPACIO VACÍO
			reporte7.setCampana(" "); reporte7.setEstatus(" "); reporte7.setSubTotal(" "); reporte7.setMonto(" ");
			resumen.add(reporte7);
			
			ResumenCampanaDTO reporte8 = new ResumenCampanaDTO();
			reporte8.setCampana("CAMPAÑAS: "); reporte8.setEstatus(" "); reporte8.setSubTotal(" "); reporte8.setMonto(" ");
			resumen.add(reporte8);
			
			List<CampanaTipoAutoriDTO> listaCAMP = new ArrayList<CampanaTipoAutoriDTO>();
			CampanaTipoAutoriDTO camp = new CampanaTipoAutoriDTO();
			
			camp.setCampana("PORTAESPNOM"); camp.setCampana("PTU2021100"); camp.setCampana("PTU2021105");
			camp.setCampana("PTU2021110"); camp.setCampana("PTUSDO12021"); camp.setCampana("PTUSDO22021");
			camp.setCampana("PTUSDO32021"); camp.setCampana("PTUSDO42021"); camp.setCampana("PTUSDO52021");
			camp.setCampana("CREDNOM2021");
			listaCAMP.add(camp);
			
			cont = 0; monto = 0.0;
			for(CampanaTipoAutoriDTO campana: listaCAMP) {
				ResumenCampanaDTO reporte = new ResumenCampanaDTO();
				List<TasasTotal> cantidad = new ArrayList<TasasTotal>();
				for(CampanaEstatusDTO estatus: listaEstatus) {
					//QUERY
					cantidad = autoTasasJDBCRepository.selectTasaTotal(formatoCompleto.format(FormatUtils.stringToDate(fecha1)), 
							formatoCompleto.format(FormatUtils.stringToDate(fecha2)), campana.getCampana(), estatus.getEstatus());
					cont += cantidad.get(0).getTotal();
					monto += cantidad.get(0).getMonto();
					log.info("Campana: " + campana.getCampana() + " , Estatus: " + estatus.getEstatus());
					log.info("Total 2.1: " + cantidad.get(0).getTotal() + " , Monto: " + cantidad.get(0).getMonto());
					//TOTAL
					reporte.setCampana(campana.getCampana()); reporte.setEstatus(estatus.getEstatus()); 
					reporte.setSubTotal(cantidad.get(0).getTotal().toString()); reporte.setMonto(cantidad.get(0).getMonto().toString());
					resumen.add(reporte);
				}
			}
			
			ResumenCampanaDTO reporte9 = new ResumenCampanaDTO();
			log.info("Total 3: " + cont + " , Monto: " + monto);
			//TOTAL
			reporte9.setCampana("TOTAL: "); reporte9.setEstatus(" "); reporte9.setSubTotal(cont.toString()); reporte9.setMonto(monto.toString());
			resumen.add(reporte9);
			
			ResumenCampanaDTO reporte10 = new ResumenCampanaDTO();
			//ESPACIO VACÍO
			reporte10.setCampana(" "); reporte10.setEstatus(" "); reporte10.setSubTotal(" "); reporte10.setMonto(" ");
			resumen.add(reporte10);
			
			ResumenCampanaDTO reporte11 = new ResumenCampanaDTO();
			//ESPACIO ESPECIALES
			reporte11.setCampana("ESPECIALES: "); reporte11.setEstatus(" "); reporte11.setSubTotal(" "); reporte11.setMonto(" ");
			resumen.add(reporte11);
			
			List<CampanaTipoAutoriDTO> listaESP = new ArrayList<CampanaTipoAutoriDTO>();
			CampanaTipoAutoriDTO esp = new CampanaTipoAutoriDTO();
			
			esp.setCampana("AutCETE98"); esp.setCampana("ESPECIAL"); esp.setCampana("EXCEPGER"); esp.setCampana("PORTAESPNOM"); listaESP.add(esp);
			
			cont = 0; monto = 0.0;
			for(CampanaTipoAutoriDTO especiales: listaESP) {
				ResumenCampanaDTO reporte = new ResumenCampanaDTO();
				List<TasasTotal> cantidad = new ArrayList<TasasTotal>();
				for(CampanaEstatusDTO estatus: listaEstatus) {
					//QUERY
					cantidad = autoTasasJDBCRepository.selectTasaTotal(formatoCompleto.format(FormatUtils.stringToDate(fecha1)), 
														formatoCompleto.format(FormatUtils.stringToDate(fecha2)), especiales.getCampana(), estatus.getEstatus());
					cont += cantidad.get(0).getTotal();
					monto += cantidad.get(0).getMonto();
					log.info("Campana: " + especiales.getCampana() + " , Estatus: " + estatus.getEstatus());
					log.info("Total 2.1: " + cantidad.get(0).getTotal() + " , Monto: " + cantidad.get(0).getMonto());
					//TOTAL
					reporte.setCampana(especiales.getCampana()); reporte.setEstatus(estatus.getEstatus()); 
					reporte.setSubTotal(cantidad.get(0).getTotal().toString()); reporte.setMonto(cantidad.get(0).getMonto().toString());
					resumen.add(reporte);
				}
			}
			
			ResumenCampanaDTO report12 = new ResumenCampanaDTO();
			log.info("Total 4: " + cont + " , Monto: " + monto);
			//TOTAL
			report12.setCampana("TOTAL: "); report12.setEstatus(" "); report12.setSubTotal(cont.toString()); report12.setMonto(monto.toString());
			resumen.add(report12);
			
			ResumenCampanaDTO reporte13 = new ResumenCampanaDTO();
			//ESPACIO VACÍO
			reporte13.setCampana(" "); reporte13.setEstatus(" "); reporte13.setSubTotal(" "); reporte13.setMonto(" ");
			resumen.add(reporte13);
			
			msg.setCampanaResumen(resumen);
			return msg;	
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte Campaña Resumen :: " , HttpStatus.NOT_FOUND.toString());
		}
	}

	//REPORTE BOLETINES
	@Override
	public ReporteBoletinesDTO reporteBoletines(String estatus, Integer enfoque, String fechaInicial, String fechaFinal, Integer reporte)
			 throws GenericException, IOException, ParseException {
		try {
			List<BoletinesDTO> listaSegmento = new ArrayList<BoletinesDTO>();
			List<BoletinesDTO> listaTipoTasa = new ArrayList<BoletinesDTO>();
			List<BoletinesDTO> listaTipoTasaGrafica = new ArrayList<BoletinesDTO>();
			List<BoletinesDTO> listaEstatus = new ArrayList<BoletinesDTO>();
			ReporteBoletinesDTO response = new ReporteBoletinesDTO();
			SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat ftd = new DecimalFormat("#.00");
			Integer stat = 0;
			Double monto = 0.0;
			
			switch (estatus)
	        {
	            case "Aplicadas": stat = 1; break;
	            case "Rechazadas": stat = 2; break;
	            case "Todas": stat = 0; break;
	        }
			
			if(fechaInicial.isEmpty() || fechaInicial == " " || fechaFinal.isEmpty() || fechaFinal == " ") {
				response.setMsg("Aviso, falta establecer alguna fecha de búsqueda.");
				return response;
			}
			
			if(enfoque == 1) {
				log.info("Fecha Final: " + ft.parse(fechaFinal));
				log.info("Fecha Ultimo: " + tasasBoletinJDBCRepository.obtieneUltimaFecha());
				if(ft.parse(fechaFinal).after(tasasBoletinJDBCRepository.obtieneUltimaFecha())) {
					log.info("Proceso eliminacion");
					tasasBoletinJDBCRepository.deleteBoletin();
					tasasBoletinJDBCRepository.llenarBoletinTasa(fechaInicial, fechaFinal);
				}
			}
			
			log.info("Fecha Inicial: " + fechaInicial);
			log.info("Fecha Anual: " + "01/"+ "01/" + fechaInicial.substring(6, 10));
			/******************************************************SEGMENTO PF***********************************************************/
			BoletinesDTO registroPF = new BoletinesDTO();
			List<BoletinesDTO> registroFisicoMensual = tasasBoletinJDBCRepository.obtenerMontoProductoxPersona(enfoque, fechaInicial, 
																											fechaFinal, true, stat);
			List<BoletinesDTO> registroFisicoAnual = tasasBoletinJDBCRepository.obtenerMontoProductoxPersona(enfoque, "01/"+ "01/" + fechaInicial.substring(6, 10), 
																											fechaFinal, true, stat);
			registroPF.setDescripcion("Personas Físicas"); 
			registroPF.setSubProductoMen(registroFisicoMensual.get(0).getSubProductoMen()); 
			registroPF.setOperacionesMen(registroFisicoMensual.get(0).getOperacionesMen());
			registroPF.setMontoMen(registroFisicoMensual.get(0).getMontoMen());
			registroPF.setTpMen(registroFisicoMensual.get(0).getTpMen());
			registroPF.setSubProductoAnual(registroFisicoAnual.get(0).getSubProductoMen());
			registroPF.setOperacionAnual(registroFisicoAnual.get(0).getOperacionesMen());
			registroPF.setMontoAnual(registroFisicoAnual.get(0).getMontoMen());
			registroPF.setTpAnual(registroFisicoAnual.get(0).getTpMen());
			listaSegmento.add(registroPF);
			
			/******************************************************SEGMENTO PM***********************************************************/
			BoletinesDTO registroPM = new BoletinesDTO();
			List<BoletinesDTO> registroMoralMensual = tasasBoletinJDBCRepository.obtenerMontoProductoxPersona(enfoque, fechaInicial, 
																											fechaFinal, false, stat);
			List<BoletinesDTO> registroMoralAnual = tasasBoletinJDBCRepository.obtenerMontoProductoxPersona(enfoque, "01/"+ "01/" + fechaInicial.substring(6, 10), 
																											fechaFinal, false, stat);
			registroPM.setDescripcion("Personas Morales"); 
			registroPM.setSubProductoMen(registroMoralMensual.get(0).getSubProductoMen()); 
			registroPM.setOperacionesMen(registroMoralMensual.get(0).getOperacionesMen());
			registroPM.setMontoMen(registroMoralMensual.get(0).getMontoMen());
			registroPM.setTpMen(registroMoralMensual.get(0).getTpMen());
			registroPM.setSubProductoAnual(registroMoralAnual.get(0).getSubProductoMen());
			registroPM.setOperacionAnual(registroMoralAnual.get(0).getOperacionesMen());
			registroPM.setMontoAnual(registroMoralAnual.get(0).getMontoMen());
			registroPM.setTpAnual(registroMoralAnual.get(0).getTpMen());
			listaSegmento.add(registroPM);
			
			/******************************************************SEGMENTO TASAS AUTORIZADAS*****************************************************/
			BoletinesDTO registroTipoTasa = new BoletinesDTO();
			BoletinesDTO registroTipoTasaGrafica = new BoletinesDTO();
			List<BoletinesDTO> registroAutoriMensual = tasasBoletinJDBCRepository.obtenerMontoProductoxTasaAutorizada(enfoque, fechaInicial, 
																													fechaFinal, stat);
			List<BoletinesDTO> registroAutoriAnual = tasasBoletinJDBCRepository.obtenerMontoProductoxTasaAutorizada(enfoque, 
																		"01/"+ "01/" + fechaInicial.substring(6, 10), fechaFinal, stat);
			
			registroTipoTasa.setDescripcion("Tasas Autorizadas"); 
			registroTipoTasa.setSubProductoMen(registroAutoriMensual.get(0).getSubProductoMen()); 
			registroTipoTasa.setOperacionesMen(registroAutoriMensual.get(0).getOperacionesMen());
			registroTipoTasa.setMontoMen(registroAutoriMensual.get(0).getMontoMen());
			registroTipoTasa.setTpMen(registroAutoriMensual.get(0).getTpMen());
			registroTipoTasa.setSubProductoAnual(registroAutoriAnual.get(0).getSubProductoMen());
			registroTipoTasa.setOperacionAnual(registroAutoriAnual.get(0).getOperacionesMen());
			registroTipoTasa.setMontoAnual(registroAutoriAnual.get(0).getMontoMen());
			registroTipoTasa.setTpAnual(registroAutoriAnual.get(0).getTpMen());
			listaTipoTasa.add(registroTipoTasa);
			
			registroTipoTasaGrafica.setDescripcion("Tasas Autorizadas"); 
			registroTipoTasaGrafica.setSubProductoMen(registroAutoriMensual.get(0).getSubProductoMen()); 
			registroTipoTasaGrafica.setOperacionesMen(registroAutoriMensual.get(0).getOperacionesMen());
			registroTipoTasaGrafica.setMontoMen(registroAutoriMensual.get(0).getMontoMen()); 
			registroTipoTasaGrafica.setTpMen(registroAutoriMensual.get(0).getTpMen());
			registroTipoTasaGrafica.setSubProductoAnual(registroAutoriAnual.get(0).getSubProductoMen());
			registroTipoTasaGrafica.setOperacionAnual(registroAutoriAnual.get(0).getOperacionesMen());
			registroTipoTasaGrafica.setMontoAnual(registroAutoriAnual.get(0).getMontoMen());
			registroTipoTasaGrafica.setTpAnual(registroAutoriAnual.get(0).getTpMen());
			listaTipoTasaGrafica.add(registroTipoTasaGrafica);
			
			/******************************************************SEGMENTO TASAS CAMPAÑA*****************************************************/
			BoletinesDTO registroTipoTasaCamp = new BoletinesDTO();
			BoletinesDTO registroTipoTasaGraficaCamp = new BoletinesDTO();
			List<BoletinesDTO> registroCampanaMensual = tasasBoletinJDBCRepository.obtenerMontoProductoxTasaSucursalCampana(enfoque, fechaInicial, 
																													fechaFinal, stat, 1);
			List<BoletinesDTO> registroCampanaAnual = tasasBoletinJDBCRepository.obtenerMontoProductoxTasaSucursalCampana(enfoque, 
																	"01/"+ "01/" + fechaInicial.substring(6, 10), fechaFinal, stat, 1);
			
			registroTipoTasaCamp.setDescripcion("Tasas Campaña"); 
			registroTipoTasaCamp.setSubProductoMen(registroCampanaMensual.get(0).getSubProductoMen()); 
			registroTipoTasaCamp.setOperacionesMen(registroCampanaMensual.get(0).getOperacionesMen());
			registroTipoTasaCamp.setMontoMen(registroCampanaMensual.get(0).getMontoMen());
			registroTipoTasaCamp.setTpMen(registroCampanaMensual.get(0).getTpMen());
			registroTipoTasaCamp.setSubProductoAnual(registroCampanaAnual.get(0).getSubProductoMen());
			registroTipoTasaCamp.setOperacionAnual(registroCampanaAnual.get(0).getOperacionesMen());
			registroTipoTasaCamp.setMontoAnual(registroCampanaAnual.get(0).getMontoMen());
			registroTipoTasaCamp.setTpAnual(registroCampanaAnual.get(0).getTpMen());
			listaTipoTasa.add(registroTipoTasaCamp);
			
			registroTipoTasaGraficaCamp.setDescripcion("Tasas Campaña"); 
			registroTipoTasaGraficaCamp.setSubProductoMen(registroCampanaMensual.get(0).getSubProductoMen()); 
			registroTipoTasaGraficaCamp.setOperacionesMen(registroCampanaMensual.get(0).getOperacionesMen());
			registroTipoTasaGraficaCamp.setMontoMen(registroCampanaMensual.get(0).getMontoMen()); 
			registroTipoTasaGraficaCamp.setTpMen(registroCampanaMensual.get(0).getTpMen());
			registroTipoTasaGraficaCamp.setSubProductoAnual(registroCampanaAnual.get(0).getSubProductoMen());
			registroTipoTasaGraficaCamp.setOperacionAnual(registroCampanaAnual.get(0).getOperacionesMen());
			registroTipoTasaGraficaCamp.setMontoAnual(registroCampanaAnual.get(0).getMontoMen());
			registroTipoTasaGraficaCamp.setTpAnual(registroCampanaAnual.get(0).getTpMen());
			listaTipoTasaGrafica.add(registroTipoTasaGraficaCamp);
			
			/******************************************************SEGMENTO TASAS SUCURSAL*****************************************************/
			if(enfoque == 0) {
				BoletinesDTO registroTipoTasaSuc = new BoletinesDTO();
				List<BoletinesDTO> registroSucursalMensual = tasasBoletinJDBCRepository.obtenerMontoProductoxTasaSucursalCampana(enfoque, 
																										fechaInicial, fechaFinal, stat, 2);
				List<BoletinesDTO> registroSucursalAnual = tasasBoletinJDBCRepository.obtenerMontoProductoxTasaSucursalCampana(enfoque, 
																		"01/"+ "01/" + fechaInicial.substring(6, 10), fechaFinal, stat, 2);
				
				registroTipoTasaSuc.setDescripcion("Tasas Campaña"); 
				registroTipoTasaSuc.setSubProductoMen(registroSucursalMensual.get(0).getSubProductoMen()); 
				registroTipoTasaSuc.setOperacionesMen(registroSucursalMensual.get(0).getOperacionesMen());
				registroTipoTasaSuc.setMontoMen(registroSucursalMensual.get(0).getMontoMen());
				registroTipoTasaSuc.setTpMen(registroSucursalMensual.get(0).getTpMen());
				registroTipoTasaSuc.setSubProductoAnual(registroSucursalAnual.get(0).getSubProductoMen());
				registroTipoTasaSuc.setOperacionAnual(registroSucursalAnual.get(0).getOperacionesMen());
				registroTipoTasaSuc.setMontoAnual(registroSucursalAnual.get(0).getMontoMen());
				registroTipoTasaSuc.setTpAnual(registroSucursalAnual.get(0).getTpMen());
				listaTipoTasa.add(registroTipoTasaSuc);
			}
			
			//REPRESENTACION DATOS GRAFICA DE BOLETIN
			log.info("Ciclo Monto");
			for(BoletinesDTO item: listaTipoTasaGrafica) {
				log.info("Cantidad: " + monto + " , Mensual: " + item.getMontoMen());
				monto += item.getMontoMen();
			}
			
			log.info("Ciclo Total");
			for(BoletinesDTO item: listaTipoTasaGrafica) {
				log.info("Cantidad: " + monto + " , Mensual: " + item.getMontoMen());
				if(monto > 0.0) {
					Double total = (item.getMontoMen() * 100) / monto;
					log.info("Total: " + total);
					String stotal = ftd.format(total);
					log.info("Total: " + Double.parseDouble(stotal));
					item.setMontoMen(Double.parseDouble(stotal));
				}else {
					item.setMontoMen(0.0);
				}
			}
			
			/******************************************************SEGMENTO TASAS DIVISION*****************************************************/
			List<BoletinesDTO> listaDivision = tasasBoletinJDBCRepository.obtenerMontoProductoxDivision(enfoque, fechaInicial, fechaFinal, stat);
			List<BoletinesDTO> listaDivisionAnual = tasasBoletinJDBCRepository.obtenerMontoProductoxDivision(enfoque, 
																	"01/"+ "01/" + fechaInicial.substring(6, 10), fechaFinal, stat);
			
			/***********************************************SEGMENTO TASAS ESTATUS APLICADAS**************************************************/
			BoletinesDTO registroA = new BoletinesDTO();
			
			List<BoletinesDTO> registroAplicadasMensual = tasasBoletinJDBCRepository.obtenerMontoProductoxAplicadasRechazadas(enfoque, 
																										fechaInicial, fechaFinal, 1);
			List<BoletinesDTO> registroAplicadasAnual = tasasBoletinJDBCRepository.obtenerMontoProductoxAplicadasRechazadas(enfoque, 
																			"01/"+ "01/" + fechaInicial.substring(6, 10), fechaFinal, 1);
			
			registroA.setDescripcion("Aplicadas"); 
			registroA.setSubProductoMen(registroAplicadasMensual.get(0).getSubProductoMen()); 
			registroA.setOperacionesMen(registroAplicadasMensual.get(0).getOperacionesMen());
			registroA.setMontoMen(registroAplicadasMensual.get(0).getMontoMen());
			registroA.setTpMen(registroAplicadasMensual.get(0).getTpMen());
			registroA.setSubProductoAnual(registroAplicadasAnual.get(0).getSubProductoMen());
			registroA.setOperacionAnual(registroAplicadasAnual.get(0).getOperacionesMen());
			registroA.setMontoAnual(registroAplicadasAnual.get(0).getMontoMen());
			registroA.setTpAnual(registroAplicadasAnual.get(0).getTpMen());
			listaEstatus.add(registroA);
			
			/***********************************************SEGMENTO TASAS ESTATUS RECHAZADAS**************************************************/
			BoletinesDTO registroR = new BoletinesDTO();
			
			List<BoletinesDTO> registroRechazadasMensual = tasasBoletinJDBCRepository.obtenerMontoProductoxAplicadasRechazadas(enfoque, 
																										fechaInicial, fechaFinal, 0);
			List<BoletinesDTO> registroRechazadasAnual = tasasBoletinJDBCRepository.obtenerMontoProductoxAplicadasRechazadas(enfoque, 
																			"01/"+ "01/" + fechaInicial.substring(6, 10), fechaFinal, 0);
			
			registroR.setDescripcion("No Aplicadas"); 
			registroR.setSubProductoMen(registroRechazadasMensual.get(0).getSubProductoMen()); 
			registroR.setOperacionesMen(registroRechazadasMensual.get(0).getOperacionesMen());
			registroR.setMontoMen(registroRechazadasMensual.get(0).getMontoMen());
			registroR.setTpMen(registroRechazadasMensual.get(0).getTpMen());
			registroR.setSubProductoAnual(registroRechazadasAnual.get(0).getSubProductoMen());
			registroR.setOperacionAnual(registroRechazadasAnual.get(0).getOperacionesMen());
			registroR.setMontoAnual(registroRechazadasAnual.get(0).getMontoMen());
			registroR.setTpAnual(registroRechazadasAnual.get(0).getTpMen());
			listaEstatus.add(registroR);
			
			if(reporte == 1) {
				String[] title = {FormatUtils.obtenerMes(fechaInicial.substring(3,5)) + " " + fechaInicial.substring(6, 10), 
							"Por Tipo de Persona", "Por Estrategia | Tipo de Tasa", "División", "Estatus"};
				String[] encabezado = {"",FormatUtils.obtenerMes(fechaInicial.substring(3,5)) + " " + fechaInicial.substring(6, 10), 
						"Anual" + fechaInicial.substring(6, 10)};
	        	List<String> encabezadoReg = Arrays.asList(ConstantUtils.TITLE_BOLETIN);
				List<List<String>> filaTipoPersona = procesoDatosTipoPersona(listaSegmento);
				List<List<String>> filaEstategia = procesoDatosEstrategia(listaTipoTasa);
				List<List<String>> filaDivision = procesoDatosDivision(listaDivision, listaDivisionAnual);
				List<List<String>> filaEstatus = procesoDatosEstatus(listaEstatus);
				Path excel = createExcelBoletin(title, encabezado, encabezadoReg, 
						filaTipoPersona, filaEstategia, filaDivision, filaEstatus, "");
				String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(excel.toFile()));
				response.setReporte(ecoder);
			}
			
			response.setListaSegmento(listaSegmento);
			response.setListaTipoTasaGrafica(listaTipoTasaGrafica);
			response.setListaTipoTasa(listaTipoTasa);
			response.setListaDivision(listaDivision);
			response.setListaDivisionAnual(listaDivisionAnual);
			response.setListaEstatus(listaEstatus);
			
			return response;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte Boletines:: " , HttpStatus.NOT_FOUND.toString());
		}
	}

	private List<List<String>> procesoDatosEstatus(List<BoletinesDTO> regES) throws GenericException{
		try {
			Integer opeMen = 0, opeAn = 0;
			Double montoMen = 0.0, montoAn = 0.0, tpMen = 0.0, tpAn = 0.0;
			List<List<String>> filas = new ArrayList<>();
			for(BoletinesDTO value: regES) {
				List<String> fila = new ArrayList<String>();
				fila.add(value.getDescripcion());
				fila.add(value.getOperacionesMen().toString());
				fila.add(value.getMontoMen().toString());
				fila.add(value.getTpMen().toString());
				fila.add(value.getOperacionAnual().toString());
				fila.add(value.getMontoAnual().toString());
				fila.add(value.getTpAnual().toString());
				opeMen += value.getOperacionesMen();
				opeAn += value.getOperacionAnual();
				montoMen += value.getMontoMen();
				montoAn += value.getMontoAnual();
				tpMen += value.getTpMen();
				tpAn += value.getTpAnual();
				filas.add(fila);
			}
			
			List<String> total = new ArrayList<String>();
			total .add("Total");
			total.add(opeMen.toString());
			total.add(montoMen.toString());
			total .add(tpMen.toString());
			total.add(opeAn.toString());
			total.add(montoAn.toString());
			total.add(tpAn.toString());
			filas.add(total);
			
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte resumen:: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	private List<List<String>> procesoDatosDivision(List<BoletinesDTO> regDIV, List<BoletinesDTO> regDIVANUAL) throws GenericException{
		try {
			Integer opeMen = 0, opeAn = 0;
			Double montoMen = 0.0, montoAn = 0.0, tpMen = 0.0, tpAn = 0.0;
			List<List<String>> filas = new ArrayList<>();
			for(int i = 0; i < regDIV.size(); i++) {
				List<String> fila = new ArrayList<String>();
				fila.add(regDIV.get(i).getDescripcion());
				fila.add(regDIV.get(i).getOperacionesMen().toString());
				fila.add(regDIV.get(i).getMontoMen().toString());
				fila.add(regDIV.get(i).getTpMen().toString());
				fila.add(regDIVANUAL.get(i).getOperacionesMen().toString());
				fila.add(regDIVANUAL.get(i).getMontoMen().toString());
				fila.add(regDIVANUAL.get(i).getTpMen().toString());
				opeMen += regDIV.get(i).getOperacionesMen();
				opeAn += regDIVANUAL.get(i).getOperacionesMen();
				montoMen += regDIV.get(i).getMontoMen();
				montoAn += regDIVANUAL.get(i).getMontoMen();
				tpMen += regDIV.get(i).getTpMen();
				tpAn += regDIVANUAL.get(i).getTpMen();
				filas.add(fila);
			}
			
			List<String> total = new ArrayList<String>();
			total .add("Total");
			total.add(opeMen.toString());
			total.add(montoMen.toString());
			total .add(tpMen.toString());
			total.add(opeAn.toString());
			total.add(montoAn.toString());
			total.add(tpAn.toString());
			filas.add(total);
			
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte resumen:: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	private List<List<String>> procesoDatosEstrategia(List<BoletinesDTO> regES) throws GenericException{
		try {
			Integer opeMen = 0, opeAn = 0;
			Double montoMen = 0.0, montoAn = 0.0, tpMen = 0.0, tpAn = 0.0;
			List<List<String>> filas = new ArrayList<>();
			for(BoletinesDTO value: regES) {
				List<String> fila = new ArrayList<String>();
				fila.add(value.getDescripcion());
				fila.add(value.getOperacionesMen().toString());
				fila.add(value.getMontoMen().toString());
				fila.add(value.getTpMen().toString());
				fila.add(value.getOperacionAnual().toString());
				fila.add(value.getMontoAnual().toString());
				fila.add(value.getTpAnual().toString());
				opeMen += value.getOperacionesMen();
				opeAn += value.getOperacionAnual();
				montoMen += value.getMontoMen();
				montoAn += value.getMontoAnual();
				tpMen += value.getTpMen();
				tpAn += value.getTpAnual();
				filas.add(fila);
			}
			
			List<String> total = new ArrayList<String>();
			total .add("Total");
			total.add(opeMen.toString());
			total.add(montoMen.toString());
			total .add(tpMen.toString());
			total.add(opeAn.toString());
			total.add(montoAn.toString());
			total.add(tpAn.toString());
			filas.add(total);
			
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte resumen:: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	private List<List<String>> procesoDatosTipoPersona(List<BoletinesDTO> regTP) throws GenericException{
		try {
			Integer opeMen = 0, opeAn = 0;
			Double montoMen = 0.0, montoAn = 0.0, tpMen = 0.0, tpAn = 0.0;
			List<List<String>> filas = new ArrayList<>();
			for(BoletinesDTO value: regTP) {
				List<String> fila = new ArrayList<String>();
				fila.add(value.getDescripcion());
				fila.add(value.getOperacionesMen().toString());
				fila.add(value.getMontoMen().toString());
				fila.add(value.getTpMen().toString());
				fila.add(value.getOperacionAnual().toString());
				fila.add(value.getMontoAnual().toString());
				fila.add(value.getTpAnual().toString());
				opeMen += value.getOperacionesMen();
				opeAn += value.getOperacionAnual();
				montoMen += value.getMontoMen();
				montoAn += value.getMontoAnual();
				tpMen += value.getTpMen();
				tpAn += value.getTpAnual();
				filas.add(fila);
			}
			
			List<String> total = new ArrayList<String>();
			total .add("Total");
			total.add(opeMen.toString());
			total.add(montoMen.toString());
			total .add(tpMen.toString());
			total.add(opeAn.toString());
			total.add(montoAn.toString());
			total.add(tpAn.toString());
			filas.add(total);
			
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte resumen:: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	public static Path createExcelBoletin(String[] titulos, String[] periodo, List<String> encabezado, List<List<String>> renglones, 
								List<List<String>> renglonesES, List<List<String>> renglonesDIV, List<List<String>> renglonesEST, String nameFile ) throws IOException, GenericException {
		try {
			Path testFile = Files.createTempFile("ReporteBoletin", ".xlsx");
	        testFile.toFile().deleteOnExit();
	        try(XSSFWorkbook workbook = new XSSFWorkbook()) {
	        	//ENCABEZADO
	        	log.info("Encabezado");
	            XSSFSheet sheet = workbook.createSheet("Boletin");
	            Row rowheader2 = sheet.createRow(1);
                Cell cell2 = rowheader2.createCell(0);
            	CellStyle style2 = workbook.createCellStyle();
            	XSSFFont font2 = workbook.createFont();
            	font2.setBold(true);
            	style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	style2.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
            	style2.setFont(font2);
            	style2.setAlignment(HorizontalAlignment.CENTER);
            	cell2.setCellStyle(style2);
            	cell2.setCellValue((String) titulos[0]);
                sheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
                
                //TIPO TIPO PERSONA
                log.info("Tipo");
                Row rowheader3 = sheet.createRow(2);
                Cell cell3 = rowheader3.createCell(0);
            	CellStyle style3 = workbook.createCellStyle();
            	XSSFFont font3 = workbook.createFont();
            	font3.setBold(true);
            	style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	style3.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
            	style3.setFont(font3);
            	style3.setAlignment(HorizontalAlignment.CENTER);
            	cell3.setCellStyle(style3);
            	cell3.setCellValue((String) titulos[1]);
                sheet.addMergedRegion(new CellRangeAddress(2,2,0,6));
                
                //MENSUAL Y ANUAL TP
                Row row = sheet.createRow(3);
	            log.info("Periodo: " + periodo.length);
            	Cell cell = row.createCell(0);
            	cell.setCellValue((String) "");
            	
            	Cell cellP1 = row.createCell(1);
            	CellStyle stylep1 = workbook.createCellStyle();
            	stylep1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	stylep1.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
            	stylep1.setAlignment(HorizontalAlignment.CENTER);
        		cellP1.setCellStyle(stylep1);
        		cellP1.setCellValue((String) periodo[1]);
                sheet.addMergedRegion(new CellRangeAddress(3,3,1,3));
                
                Cell cellP2 = row.createCell(4);
                CellStyle stylep2 = workbook.createCellStyle();
                stylep2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                stylep2.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
            	stylep2.setAlignment(HorizontalAlignment.CENTER);
        		cellP2.setCellStyle(stylep2);
        		cellP2.setCellValue((String) periodo[2]);
                sheet.addMergedRegion(new CellRangeAddress(3,3,4,6));
        		
	            	
	            //ENCABEZADO REG
	            log.info("Encabezado REG");
	            Row rowheader = sheet.createRow(4);
	            int colCell3 = 0;
	            for (String field : encabezado) {
	                Cell cellREG = rowheader.createCell(colCell3++);
	                if (field instanceof String) {
	                	CellStyle style = workbook.createCellStyle();
	                	XSSFFont font = workbook.createFont();
	                	font.setBold(true);
	                	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	                	if(field.equals("Tipo de Persona")) {
	                		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
	                	}else if(field.equals("Operaciones")) {
	                		style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
	                	}else if(field.equals("Monto")) {
	                		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	                	}else if(field.equals("Tasa P.")) {
	                		style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
	                	}
	                	style.setFont(font);
	                	cellREG.setCellStyle(style);
	                	cellREG.setCellValue((String) field);
	                }
	            }
	            
	            //REGISTROS
	            log.info("Renglones: " + renglones.size());
	            int colHeader = 5;
	            for (List<String> key : renglones) {
	                Row rowR = sheet.createRow(colHeader++);
	                int colNum = 0;
	                for (String field : key) {
	                    Cell cellR = rowR.createCell(colNum++);
	                    if (field instanceof String) {
	                    	cellR.setCellValue((String) field);
	                    }
	                }
	            }
	            
	            /*******************TIPO ESTRATEGIA/TIPO DE TASA****************************/
                log.info("Tipo");
                Row rowheaderT = sheet.createRow(8);
                Cell cellT = rowheaderT.createCell(0);
            	CellStyle styleT = workbook.createCellStyle();
            	XSSFFont fontT = workbook.createFont();
            	fontT.setBold(true);
            	styleT.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	styleT.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
            	styleT.setFont(fontT);
            	styleT.setAlignment(HorizontalAlignment.CENTER);
            	cellT.setCellStyle(styleT);
            	cellT.setCellValue((String) titulos[2]);
                sheet.addMergedRegion(new CellRangeAddress(8,8,0,6));
                
                //MENSUAL Y ANUAL ES
                Row rowES = sheet.createRow(9);
            	Cell cellES = rowES.createCell(0);
            	cellES.setCellValue((String) "");
            	
            	Cell cellES1 = rowES.createCell(1);
            	CellStyle styleES1 = workbook.createCellStyle();
            	styleES1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	styleES1.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
            	styleES1.setAlignment(HorizontalAlignment.CENTER);
            	cellES1.setCellStyle(styleES1);
        		cellES1.setCellValue((String) periodo[1]);
                sheet.addMergedRegion(new CellRangeAddress(9,9,1,3));
                
                Cell cellES2 = rowES.createCell(4);
                CellStyle styleES2 = workbook.createCellStyle();
                styleES2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                styleES2.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
                styleES2.setAlignment(HorizontalAlignment.CENTER);
            	cellES2.setCellStyle(styleES2);
        		cellES2.setCellValue((String) periodo[2]);
                sheet.addMergedRegion(new CellRangeAddress(9,9,4,6));
                
                //ENCABEZADO REG
	            log.info("Encabezado REG");
	            Row rowheaderREGES = sheet.createRow(10);
	            int colCellREGES = 0;
	            for (String field : encabezado) {
	                Cell cellREGES = rowheaderREGES.createCell(colCellREGES++);
	                if (field instanceof String) {
	                	CellStyle style = workbook.createCellStyle();
	                	XSSFFont font = workbook.createFont();
	                	font.setBold(true);
	                	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	                	if(field.equals("Tipo de Persona")) {
	                		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
	                	}else if(field.equals("Operaciones")) {
	                		style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
	                	}else if(field.equals("Monto")) {
	                		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	                	}else if(field.equals("Tasa P.")) {
	                		style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
	                	}
	                	style.setFont(font);
	                	cellREGES.setCellStyle(style);
	                	cellREGES.setCellValue((String) field);
	                }
	            }
                
	            //REGISTROS
	            log.info("Renglones: " + renglonesES.size());
	            int colHeaderES = 11;
	            for (List<String> key : renglonesES) {
	                Row row1 = sheet.createRow(colHeaderES++);
	                int colNumES = 0;
	                for (String field : key) {
	                    Cell cellR = row1.createCell(colNumES++);
	                    if (field instanceof String) {
	                    	cellR.setCellValue((String) field);
	                    }
	                }
	            }
	            
	            /*******************DIVISION****************************/
                log.info("Tipo");
                Row rowheaderD = sheet.createRow(14);
                Cell cellD = rowheaderD.createCell(0);
            	CellStyle styleD = workbook.createCellStyle();
            	XSSFFont fontD = workbook.createFont();
            	fontD.setBold(true);
            	styleD.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	styleD.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
            	styleD.setFont(fontD);
            	styleD.setAlignment(HorizontalAlignment.CENTER);
            	cellD.setCellStyle(styleD);
            	cellD.setCellValue((String) titulos[3]);
                sheet.addMergedRegion(new CellRangeAddress(14,14,0,6));
	            
                //MENSUAL Y ANUAL ES
                Row rowDIV = sheet.createRow(15);
            	Cell cellDIV = rowDIV.createCell(0);
            	cellDIV.setCellValue((String) "");
            	
            	Cell cellDIV1 = rowDIV.createCell(1);
            	CellStyle styleDIV1 = workbook.createCellStyle();
            	styleDIV1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	styleDIV1.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
            	styleDIV1.setAlignment(HorizontalAlignment.CENTER);
            	cellDIV1.setCellStyle(styleDIV1);
        		cellDIV1.setCellValue((String) periodo[1]);
                sheet.addMergedRegion(new CellRangeAddress(15,15,1,3));
                
                Cell cellEDIV2 = rowDIV.createCell(4);
                CellStyle styleDIV2 = workbook.createCellStyle();
                styleDIV2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                styleDIV2.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
                styleDIV2.setAlignment(HorizontalAlignment.CENTER);
                cellEDIV2.setCellStyle(styleDIV2);
        		cellEDIV2.setCellValue((String) periodo[2]);
                sheet.addMergedRegion(new CellRangeAddress(15,15,4,6));
                
                //ENCABEZADO REG
	            log.info("Encabezado REG");
	            Row rowheaderREGDIV = sheet.createRow(16);
	            int colCellRESDIV = 0;
	            for (String field : encabezado) {
	                Cell cellREGDIV = rowheaderREGDIV.createCell(colCellRESDIV++);
	                if (field instanceof String) {
	                	CellStyle style = workbook.createCellStyle();
	                	XSSFFont font = workbook.createFont();
	                	font.setBold(true);
	                	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	                	if(field.equals("Tipo de Persona")) {
	                		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
	                	}else if(field.equals("Operaciones")) {
	                		style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
	                	}else if(field.equals("Monto")) {
	                		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	                	}else if(field.equals("Tasa P.")) {
	                		style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
	                	}
	                	style.setFont(font);
	                	cellREGDIV.setCellStyle(style);
	                	cellREGDIV.setCellValue((String) field);
	                }
	            }
                
	            //REGISTROS
	            log.info("Renglones: " + renglonesDIV.size());
	            int colHeaderDIV = 17;
	            for (List<String> key : renglonesDIV) {
	                Row row1 = sheet.createRow(colHeaderDIV++);
	                int colNumDIV = 0;
	                for (String field : key) {
	                    Cell cellR = row1.createCell(colNumDIV++);
	                    if (field instanceof String) {
	                    	cellR.setCellValue((String) field);
	                    }
	                }
	            }
                
	            /*******************ESTATUS****************************/
                log.info("Tipo");
                int val = 0;
                if(renglonesDIV.size() == 0) {
                	val = 18; 
                }else {
                	val = 18 + renglonesDIV.size();
                }
                Row rowheaderEST = sheet.createRow(val);
                Cell cellEST = rowheaderEST.createCell(0);
            	CellStyle styleEST = workbook.createCellStyle();
            	XSSFFont fontEST = workbook.createFont();
            	fontEST.setBold(true);
            	styleEST.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	styleEST.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
            	styleEST.setFont(fontEST);
            	styleEST.setAlignment(HorizontalAlignment.CENTER);
            	cellEST.setCellStyle(styleEST);
            	cellEST.setCellValue((String) titulos[4]);
                sheet.addMergedRegion(new CellRangeAddress(val,val,0,6));
	            
                //MENSUAL Y ANUAL ES
                val += 1;
                Row rowEST = sheet.createRow(val);
            	Cell cellESTATUS = rowEST.createCell(0);
            	cellESTATUS.setCellValue((String) "");
            	
            	Cell cellESTATUS1 = rowEST.createCell(1);
            	CellStyle styleestatus1 = workbook.createCellStyle();
            	styleestatus1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            	styleestatus1.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
            	styleestatus1.setAlignment(HorizontalAlignment.CENTER);
            	cellESTATUS1.setCellStyle(styleestatus1);
            	cellESTATUS1.setCellValue((String) periodo[1]);
                sheet.addMergedRegion(new CellRangeAddress(val,val,1,3));
                
                Cell cellESTATUS2 = rowEST.createCell(4);
                CellStyle styleestatus2 = workbook.createCellStyle();
                styleestatus2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                styleestatus2.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
                styleestatus2.setAlignment(HorizontalAlignment.CENTER);
                cellESTATUS2.setCellStyle(styleestatus2);
                cellESTATUS2.setCellValue((String) periodo[2]);
                sheet.addMergedRegion(new CellRangeAddress(val,val,4,6));
                
                //ENCABEZADO REG
                val += 1;
	            log.info("Encabezado REG");
	            Row rowheaderREGEST = sheet.createRow(val);
	            int colCellREST = 0;
	            for (String field : encabezado) {
	                Cell cellREGest = rowheaderREGEST.createCell(colCellREST++);
	                if (field instanceof String) {
	                	CellStyle style = workbook.createCellStyle();
	                	XSSFFont font = workbook.createFont();
	                	font.setBold(true);
	                	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	                	if(field.equals("Tipo de Persona")) {
	                		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
	                	}else if(field.equals("Operaciones")) {
	                		style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
	                	}else if(field.equals("Monto")) {
	                		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	                	}else if(field.equals("Tasa P.")) {
	                		style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
	                	}
	                	style.setFont(font);
	                	cellREGest.setCellStyle(style);
	                	cellREGest.setCellValue((String) field);
	                }
	            }
	            
	            //REGISTROS
	            log.info("Renglones: " + renglonesEST.size());
	            int colHeaderESTA = val + 1;
	            for (List<String> key : renglonesEST) {
	                Row row1 = sheet.createRow(colHeaderESTA++);
	                int colNumDIV = 0;
	                for (String field : key) {
	                    Cell cellR = row1.createCell(colNumDIV++);
	                    if (field instanceof String) {
	                    	cellR.setCellValue((String) field);
	                    }
	                }
	            }
                
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	            workbook.write(bos);
	            bos.close();
	            Files.write(testFile, bos.toByteArray());
	        }
	        return testFile;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte resumen:: " , HttpStatus.NOT_FOUND.toString());
		}
    }
	
	//REPORTE RESUMEN
	@Override
	public ReporteResumenDTO reporteResumen(String fecha1, String fecha2, Integer reporte)
			throws GenericException, IOException, ParseException {
		try {
			ReporteResumenDTO resumen = new ReporteResumenDTO();
			List<ResumenDTO> listaRegistros = new ArrayList<ResumenDTO>();
			List<ResumenDTO> listaRegistrosGerInv = new ArrayList<ResumenDTO>();
			List<ResumenAutDivDTO> listaRegistrosAutDiv = new ArrayList<ResumenAutDivDTO>();
			List<ResumenDTO> listaRegistrosUEC = new ArrayList<ResumenDTO>();
			List<CampanaEstatusDTO> listaEstatus = new ArrayList<CampanaEstatusDTO>();
			Integer countA = 0, countNA = 0, countNL = 0;
			Double montoA = 0.0, montoNA = 0.0, montoNL = 0.0;
			
			listaRegistros = resumenJDCBRepository.obtenerRegistros(fecha1, fecha2);
			listaRegistrosGerInv = resumenJDCBRepository.obtenerRegistrosGerenciaInv(fecha1, fecha2);
			listaRegistrosAutDiv = resumenAutDivJDBCRepository.obtenerRegistros(fecha1, fecha2);
			
			listaRegistros.forEach(i -> { CampanaEstatusDTO item = new CampanaEstatusDTO(); item.setEstatus(i.getEstatusUEC()); listaEstatus.add(item); });
			
			//DISTINCT ESTATUS
			Set<String> contentSet = new HashSet<>();
			listaEstatus.removeIf(value -> !contentSet.add(value.getEstatus()));
			listaEstatus.sort(Comparator.comparing(CampanaEstatusDTO::getEstatus));
			
			for(CampanaEstatusDTO item: listaEstatus) {
				ResumenDTO value = new ResumenDTO();
				value.setEstatusUEC(item.getEstatus());
				log.info("Estatus UEC: " + value.getEstatusUEC());
				for(ResumenDTO reg: listaRegistros) {
					log.info("Estatus PLA:" + reg.getEstatusPLA());
					if(value.getEstatusUEC().equals(reg.getEstatusUEC()) && reg.getEstatusPLA().equals("Aplicado")) {
						countA++;
						montoA += reg.getMonto();
					}
					if(value.getEstatusUEC().equals(reg.getEstatusUEC()) && reg.getEstatusPLA().equals("No_Aplicado")) {
						countNA++;
						montoNA += reg.getMonto();
					}
					if(value.getEstatusUEC().equals(reg.getEstatusUEC()) && reg.getEstatusPLA().equals("No_Localizado")) {
						countNL++;
						montoNL += reg.getMonto();
					}
				}
				value.setOperaciones(countA + countNA + countNL);
				value.setSubTotal(montoA + montoNA + montoNL);
				value.setAplicado(countA);
				value.setAplicadoMonto(montoA);
				value.setNoAplicado(countNA);
				value.setNoAplicadoMonto(montoNA);
				value.setNoLocalizado(countNL);
				value.setNoLocalizadoMonto(montoNL);
				if(value.getOperaciones() == null) {
					value.setOperaciones(0);
				}
				if(value.getSubTotal() == null) {
					value.setSubTotal(0.0);
				}
				listaRegistrosUEC.add(value);
				countA = 0;
				montoA = 0.0;
				countNA = 0;
				montoNA = 0.0;
				countNL = 0;
				montoNL = 0.0;
			}
			
			if(reporte == 1) {
				List<List<String>> filaUEC = procesoDatosUEC(listaRegistrosUEC);
				List<List<String>> filaGerInv = procesoDatosGerInv(listaRegistrosGerInv);
				List<List<String>> filaAutoDiv = procesoDatosAutDiv(listaRegistrosAutDiv);
				List<String> encabezadoUEC = Arrays.asList(ConstantUtils.TITLE_UEC);
				List<String> encabezadoGERINV = Arrays.asList(ConstantUtils.TITLE_GER_INV);
				List<String> encabezadoAUT = Arrays.asList(ConstantUtils.TITLE_AUT_DIV);
				Path excel = createExcelUEC(encabezadoUEC, filaUEC, encabezadoGERINV, filaGerInv, encabezadoAUT, filaAutoDiv, ""); 
				String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(excel.toFile()));
				resumen.setReporte(ecoder);
			}
			
			resumen.setListaRegistrosUEC(listaRegistrosUEC);
			resumen.setListaRegistrosGerInv(listaRegistrosGerInv);
			resumen.setListaRegistrosAutDiv(listaRegistrosAutDiv);
			return resumen;	
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte resumen:: " , HttpStatus.NOT_FOUND.toString());
		}
	}
 
	public static Path createExcelUEC(List<String> titulos, List<List<String>> renglones,List<String> titulos2, List<List<String>> renglones2, 
									List<String> titulos3, List<List<String>> renglones3, String nameFile ) throws IOException {
        Path testFile = Files.createTempFile("ResumenUEC", ".xlsx");
        testFile.toFile().deleteOnExit();
        try(XSSFWorkbook workbook = new XSSFWorkbook()) {
        	//HOJA 1
            XSSFSheet sheet = workbook.createSheet("Resumen_UEC");
            int colHeader = 0;
            Row rowheader = sheet.createRow(colHeader++);
            int colCell = 0;
            for (String field : titulos) {
                Cell cell = rowheader.createCell(colCell++);
                if (field instanceof String) {
                	CellStyle style = workbook.createCellStyle();
                	XSSFFont font = workbook.createFont();
                	font.setBold(true);
                	style.setFont(font);
                	cell.setCellStyle(style);
                    cell.setCellValue((String) field);
                }
            }
            int rowNum = 1;
            for (List<String> key : renglones) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (String field : key) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    }
                }
            }
            
            //HOJA 2
            XSSFSheet sheet2 = workbook.createSheet("Resumen_GerInv");
            int colHeader2 = 0;
            Row rowheader2 = sheet2.createRow(colHeader2++);
            int colCell2 = 0;
            for (String field2 : titulos2) {
                Cell cell2 = rowheader2.createCell(colCell2++);
                if (field2 instanceof String) {
                	CellStyle style2 = workbook.createCellStyle();
                	XSSFFont font2 = workbook.createFont();
                	font2.setBold(true);
                	style2.setFont(font2);
                	cell2.setCellStyle(style2);
                    cell2.setCellValue((String) field2);
                }
            }
            int rowNum2 = 1;
            for (List<String> key2 : renglones2) {
                Row row2 = sheet2.createRow(rowNum2++);
                int colNum2 = 0;
                for (String field2 : key2) {
                    Cell cell2 = row2.createCell(colNum2++);
                    if (field2 instanceof String) {
                        cell2.setCellValue((String) field2);
                    }
                }
            }
            
            //HOJA 3
            XSSFSheet sheet3 = workbook.createSheet("Aut_x_Div");
            int colHeader3 = 0;
            Row rowheader3 = sheet3.createRow(colHeader3++);
            int colCell3 = 0;
            for (String field3 : titulos3) {
                Cell cell3 = rowheader3.createCell(colCell3++);
                if (field3 instanceof String) {
                	CellStyle style3 = workbook.createCellStyle();
                	XSSFFont font3 = workbook.createFont();
                	font3.setBold(true);
                	style3.setFont(font3);
                	cell3.setCellStyle(style3);
                    cell3.setCellValue((String) field3);
                }
            }
            int rowNum3 = 1;
            for (List<String> key : renglones3) {
                Row row = sheet3.createRow(rowNum3++);
                int colNum3 = 0;
                for (String field3 : key) {
                    Cell cell3 = row.createCell(colNum3++);
                    if (field3 instanceof String) {
                        cell3.setCellValue((String) field3);
                    }
                }
            }
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workbook.write(bos);
            bos.close();
            Files.write(testFile, bos.toByteArray());
        }
        return testFile;
    }
	
	
	
	private List<List<String>> procesoDatosUEC(List<ResumenDTO> regUEC) throws GenericException{
		try {
			Integer aplicado = 0, noAplicado = 0, noLocalizado = 0, ope = 0;
			Double apliMonto = 0.0, noApliMonto = 0.0, noLocalizadoMonto = 0.0, subtotal = 0.0;
			List<List<String>> filas = new ArrayList<>();
			for(ResumenDTO value: regUEC) {
				List<String> fila = new ArrayList<String>();
				fila.add(value.getEstatusUEC());
				fila.add(value.getAplicado().toString());
				fila.add("$" + value.getAplicadoMonto().toString());
				fila.add(value.getNoAplicado().toString());
				fila.add("$" + value.getNoAplicadoMonto().toString());
				fila.add(value.getNoLocalizado().toString());
				fila.add("$" + value.getNoLocalizadoMonto().toString());
				fila.add(value.getOperaciones().toString());
				fila.add("$" + value.getSubTotal().toString());
				filas.add(fila);
				aplicado += value.getAplicado();
				apliMonto += value.getAplicadoMonto();
				noAplicado += value.getNoAplicado();
				noApliMonto += value.getNoAplicadoMonto();
				noLocalizado += value.getNoLocalizado(); 
				noLocalizadoMonto += value.getNoLocalizadoMonto();
				ope += value.getOperaciones();
				subtotal += value.getSubTotal();
			}
			
			List<String> total = new ArrayList<String>();
			total.add("TOTAL");
			total.add(aplicado.toString());
			total.add("$" + apliMonto.toString());
			total.add(noAplicado.toString());
			total.add("$" + noApliMonto.toString());
			total.add(noLocalizado.toString());
			total.add("$" + noLocalizadoMonto.toString());
			total.add(ope.toString());
			total.add("$" + subtotal.toString());
			filas.add(total);
			
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte resumen:: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	private List<List<String>> procesoDatosGerInv(List<ResumenDTO> regGerInv) throws GenericException{
		try {
			Integer ope = 0; Double monto = 0.0;
			List<List<String>> filas = new ArrayList<>();
			for(ResumenDTO value: regGerInv) {
				List<String> fila = new ArrayList<String>();
				fila.add(value.getCampana());
				fila.add(value.getEstatusUEC());
				fila.add(value.getOperaciones().toString());
				fila.add("$" + value.getMonto().toString());
				filas.add(fila);
				ope += value.getOperaciones();
				monto += value.getMonto();
			}
			List<String> total = new ArrayList<String>();
			total.add("");
			total.add("TOTAL");
			total.add(ope.toString());
			total.add("$" + monto.toString());
			filas.add(total);
			
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte resumen:: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	private List<List<String>> procesoDatosAutDiv(List<ResumenAutDivDTO> regAutDiv) throws GenericException{
		try {
			Integer ope = 0, count = 0;
			Double monto = 0.0, tasa = 0.0, cete = 0.0;
			List<List<String>> filas = new ArrayList<>();
			for(ResumenAutDivDTO value: regAutDiv) {
				List<String> fila = new ArrayList<String>();
				fila.add(value.getDivision());
				fila.add(value.getCampana());
				fila.add(value.getOperaciones().toString());
				fila.add("$" + value.getMonto().toString());
				fila.add(value.getTasa_Prom().toString());
				fila.add(value.getCete().toString());
				filas.add(fila);
				ope += value.getOperaciones();
				monto += value.getMonto();
				tasa += value.getTasa_Prom();
				cete += value.getCete();
				count++;
			}
			tasa = (tasa/count);
			cete = (cete/count);
			List<String> total = new ArrayList<String>();
			total.add("");
			total.add("TOTAL");
			total.add(ope.toString());
			total.add("$" + tasa.toString());
			total.add("$" + cete.toString());
			filas.add(total);
			
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte resumen:: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	//TRANSFERIR DATOS
	@Override
	public CargaDatosDTO transfiereDatos(String fecha) throws GenericException, IOException, ParseException {
		try {
			CargaDatosDTO msg = new CargaDatosDTO();
			String campana = "", cede = "", PORTAESPNOM = "PORTAESPNOM";
			List<CatCampanaDTO> listaCampana = new ArrayList<CatCampanaDTO>();
			List<TasasDiarioA> listaRegistro = new ArrayList<TasasDiarioA>();
			List<TasasDiarioA> listaRegistroFin = new ArrayList<TasasDiarioA>();
			List<NominaEAVDTO> listaNominaEAV = new ArrayList<NominaEAVDTO>();
			List<NominaEAVDTO> listaNomina = new ArrayList<NominaEAVDTO>();
			SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
			
			log.info("Consulta campaña");
			listaCampana = catCampañasJDBCRepository.obtenerCampana();
			log.info("Consulta Tasas");
			listaRegistro = tasasJDBCRepository.selectRegTasasDiario(0, fecha, fecha, 1);
			
			log.info("Total Reg Fin: " + listaRegistro.size());
			acumuladoCampJDBCRepository.batchInsert(listaRegistro, 500);
			
			/*if(listaRegistroFin.size() > 0) {
				
				listaNominaEAV = catEjecEAV2021JDBCRepository.obtenerNominaEAV();
				
				for(NominaEAVDTO nomina: listaNominaEAV) {
					Integer totalFecha = 0, numVentasCamp = 0, numVentasCede = 0, numVentasPORTAESPNOM = 0;
					Double importeTotal = 0.0, importeCamp = 0.0, importeCede = 0.0, importePORTAESPNOM = 0.0;
					
					listaNomina = acumuladoCampJDBCRepository.obtenerNominaEAV(nomina.getNomina());
					
					for(NominaEAVDTO lista: listaNomina) {
						if(lista.getFechaApertura().equals(ft.parse(fecha))) { totalFecha++; }
						importeTotal += lista.getMonto();
						if(lista.getNomCamp() == campana) { numVentasCamp++; importeCamp+= lista.getMonto(); }
						if(lista.getNomCamp() == cede) { numVentasCede++; importeCede += lista.getMonto(); }
						if(lista.getNomCamp() == PORTAESPNOM) { numVentasPORTAESPNOM++; importePORTAESPNOM += lista.getMonto(); }
					}
					
					catEjecEAV2021JDBCRepository.updateFechaEAV(fecha, totalFecha, nomina.getNomina());
					catEjecEAV2021JDBCRepository.updateRegistrosEAV(listaNomina.size(), importeTotal, numVentasCede, importeCede, numVentasCamp, 
												importeCamp, numVentasPORTAESPNOM, importePORTAESPNOM, nomina.getNomina());
					
				}
			}else {
				msg.setMensajeInfo("Aviso");
				msg.setMensajeConfirm("No hay registros a cargar");
				return msg;
			}*/
			Integer numRegTasas = tasasJDBCRepository.GetNumRegTbAcumuladoTasas(fecha);
			Integer numRegAcumulado = acumuladoCampJDBCRepository.GetNumRegTbAcumuladoTasas(fecha);
			
			msg.setFecha(fecha);
			msg.setNumRegTasas(numRegTasas);
			msg.setNumRegAcum(numRegAcumulado);
			msg.setMensajeInfo("Aviso");
			msg.setMensajeConfirm("Carga realizada, se agregaron " + listaRegistro.size() + " registros.");
			return msg;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al transferir los datos  :: " , HttpStatus.NOT_FOUND.toString());
		}
	}

	@Override
	public CombosFacultamientoDTO getCombo() throws GenericException, IOException, ParseException {
		CombosFacultamientoDTO msg = new CombosFacultamientoDTO();
		List<DivisionDTO> listaDivision = new ArrayList<DivisionDTO>();
		List<AutDivisionalesDTO> listaAutDivisionales = new ArrayList<AutDivisionalesDTO>();
		List<AutDivisionalesDTO> listaAutRegionales = new ArrayList<AutDivisionalesDTO>();
		List<RegionesDTO> listaRegion = new ArrayList<RegionesDTO>();
		
		DivisionDTO div = new DivisionDTO("Seleccione"); 
		DivisionDTO div2 = new DivisionDTO("Gerencia");
		listaDivision.add(div);
		listaDivision.add(div2);
		listaDivision.addAll(catSucusal2021JDBCRepository.obtenerDivisiones());
		
		AutDivisionalesDTO ad = new AutDivisionalesDTO();
		ad.setNombre("Seleccione");
		ad.setSoeid("Seleccione");
		ad.setAlta(1);
		listaAutDivisionales.add(ad);
		listaAutDivisionales.addAll(catAutorizadores2021JDBCRepository.obtenerAutDivisionales(1,1, "","", ""));
		
		AutDivisionalesDTO auReg = new AutDivisionalesDTO();
		auReg.setNombre("Seleccione");
		auReg.setSoeid("Seleccione");
		listaAutRegionales.add(auReg);
		listaAutRegionales.addAll(catAutorizadores2021JDBCRepository.obtenerAutDivisionales(2,0, "","", ""));
		
		RegionesDTO region = new RegionesDTO();
		region.setDistrito("Seleccione");
		listaRegion.add(region);
		listaRegion.addAll(catSucusal2021JDBCRepository.obtenerRegiones(""));
		
		msg.setListaDivision(listaDivision);
		msg.setListaAutDivisionales(listaAutDivisionales);
		msg.setListaAutRegionales(listaAutRegionales);
		msg.setListaRegion(listaRegion);
		return msg;
	}

	@Override
	public CombosFacultamientoDTO getDivisiones(String region, String autDiv) throws GenericException, IOException, ParseException {
		CombosFacultamientoDTO msg = new CombosFacultamientoDTO();
		List<AutDivisionalesDTO> listaAutDivisionales = new ArrayList<AutDivisionalesDTO>();
		List<RegionesDTO> listaRegion = new ArrayList<RegionesDTO>();
		
		RegionesDTO reg = new RegionesDTO();
		reg.setDistrito("Seleccione");
		listaRegion.add(reg);
		AutDivisionalesDTO ad = new AutDivisionalesDTO();
		ad.setNombre("Seleccione");
		ad.setSoeid("Seleccione");
		listaAutDivisionales.add(ad);
		
		listaRegion.addAll(catSucusal2021JDBCRepository.obtenerRegiones(region));
		listaAutDivisionales.addAll(catAutorizadores2021JDBCRepository.obtenerAutDivisionales(1,1, "",autDiv, ""));
		
		msg.setListaAutDivisionales(listaAutDivisionales);
		msg.setListaRegion(listaRegion);
		return msg;
	}

	@Override
	public CombosFacultamientoDTO getAutDivisionales(String region) throws GenericException, IOException, ParseException {
		CombosFacultamientoDTO msg = new CombosFacultamientoDTO();
		List<RegionesDTO> listaRegion = new ArrayList<RegionesDTO>();
		RegionesDTO reg = new RegionesDTO();
		reg.setDistrito("Seleccione");
		listaRegion.add(reg);
		listaRegion.addAll(catSucusal2021JDBCRepository.obtenerRegiones(region));
		msg.setListaRegion(listaRegion);
		return msg;
	}

	@Override
	public CombosFacultamientoDTO getRegiones(String autRegion, String division) throws GenericException, IOException, ParseException {
		CombosFacultamientoDTO msg = new CombosFacultamientoDTO();
		List<AutDivisionalesDTO> listaAutRegionales = new ArrayList<AutDivisionalesDTO>();
		AutDivisionalesDTO ad = new AutDivisionalesDTO();
		ad.setNombre("Seleccione");
		ad.setSoeid("Seleccione");
		listaAutRegionales.add(ad);
		listaAutRegionales.addAll(catAutorizadores2021JDBCRepository.obtenerAutDivisionales(2,0, autRegion,division, ""));
		msg.setListaAutRegionales(listaAutRegionales);
		return msg;
	}

	@Override
	public ComboDTO getListaCombo() throws GenericException, IOException, ParseException {
		ComboDTO lista = new ComboDTO();
		List<ListaComboDTO> valores = new ArrayList<ListaComboDTO>();
		ListaComboDTO cb1 = new ListaComboDTO();
		cb1.setValor(-1);
		cb1.setNombre("Seleccione");
		valores.add(cb1);
		ListaComboDTO cb2 = new ListaComboDTO();
		cb2.setValor(1);
		cb2.setNombre("Divisional");
		valores.add(cb2);
		ListaComboDTO cb3 = new ListaComboDTO();
		cb3.setValor(2);
		cb3.setNombre("Distrital");
		valores.add(cb3);
		ListaComboDTO cb4 = new ListaComboDTO();
		cb4.setValor(3);
		cb4.setNombre("Facultado");
		valores.add(cb4);
		ListaComboDTO cb5 = new ListaComboDTO();
		cb5.setValor(5);
		cb5.setNombre("Gerencia Inv.");
		valores.add(cb5);
		lista.setValores(valores);
		return lista;
	}

	@Override
	public EstatusDTO UpdateEstatus(String soeid, String idTasa, String estatus)
			throws GenericException, IOException, ParseException {
		EstatusDTO msg = new EstatusDTO();
		String autorizadores = "";
		List<SolicitudEstatusDTO> solicitud = new ArrayList<SolicitudEstatusDTO>();
		List<AutDivisionalesDTO> aprobador = new ArrayList<AutDivisionalesDTO>();
		String [] aut;
		solicitud = autoTasasJDBCRepository.obtenerRegAutoTasa(idTasa);
		aprobador = catAutorizadores2021JDBCRepository.obtenerAutDivisionales(0,0, "","", soeid);
		
		if(!solicitud.get(0).getAutorizadores().equals("NA")) {
			System.out.println("1635 Autorizadores->" + solicitud.get(0).getAutorizadores());
			aut = solicitud.get(0).getAutorizadores().split("\\|");
			System.out.println("1635 Autorizadores Lenght->" + aut.length);
			for(int i = 0; i < aut.length; i++) {
				System.out.println("1635 Autorizador->" + aut[i]);
				autorizadores += catAutorizadores2021JDBCRepository.obtenerAutDivisionales(0,0, "","", aut[i]).get(0).getNombre();
			}
			solicitud.get(0).setAutorizadores(autorizadores.substring(0, autorizadores.length() -2));
		}
		
		if(solicitud.get(0).getEstatus().equals("SOLICITADA")) {
			
			solicitud.get(0).setEstatus(estatus);
			solicitud.get(0).setFechaAutori(fechaActualCompleta());
			solicitud.get(0).setFechaEstatus(fechaActualCompleta());
			solicitud.get(0).setInicAutori(aprobador.get(0).getInic());
			solicitud.get(0).setSoeidAutori(aprobador.get(0).getSoeid());
			solicitud.get(0).setObservaWeb("");
			
			if(estatus.equals("ACEPTADA")) {
				msg.setFlag(true);
				msg.setMensaje("Aceptada para su operación");
				solicitud.get(0).setSoeidAsig(CalcularSoeidAsignado());
			}
			
			if(estatus.equals("RECHAZADA")) {
				msg.setFlag(false);
				msg.setMensaje("Rechazada para su operación");
				String msjFolio = deshabilitarFolioEspecial(solicitud);
				String[] partes = msjFolio.split(",");
				msg.setEstatusFolio(partes[0]);
				msg.setMensajeFolio(partes[1]);
			}
			
			if(estatus.equals("CANCELADA")) {
				msg.setFlag(false);
				msg.setMensaje("Solicitud previamente Cancelada para su operación");
			}
			
			autoTasasJDBCRepository.updateVOBO(solicitud.get(0), idTasa);
		}else {
			
			if(solicitud.get(0).getEstatus().equals("CANCELADA")) {
				msg.setMensaje("Solicitud previamente Cancelada para su operación");
				msg.setFlag(false);
			}else {
				if(solicitud.get(0).getSoeidAutori().equals("0")) {
					msg.setMensaje("");
				}else {
					msg.setMensaje("Previamente " + solicitud.get(0).getEstatus() + " por " 
								+ catAutorizadores2021JDBCRepository.obtenerAutDivisionales(0,0, "","", solicitud.get(0).getSoeidAutori()).get(0).getNombre());
				}
			}
			msg.setFlag(false);
		}
		
		msg.setSolicitud(solicitud.get(0));
		msg.setSucursalOpe(catSucusal2021JDBCRepository.obtieneSucursalesPorSuc(solicitud.get(0).getSucSolic()));
		msg.setNombreEjec(solicitud.get(0).getNomEjec());
		msg.setNombreAutorizador(catAutorizadores2021JDBCRepository.obtenerAutDivisionales(0,0, "","", solicitud.get(0).getSoeidAutori()).get(0).getNombre());
		return msg;
	}
	
	
	public String CalcularSoeidAsignado() throws GenericException {
		String soeidAsignado = "";
		String val = "";
		String soeid_asig_ant = "";
		List<Cat_AsignacionBEDTO> listaAsignaciones = solicitudCampanaJDBCRepository.ObtenerAsignaciones();
		List<AutoTasaSoeidDTO> listAutoTasMax_Id = solicitudCampanaJDBCRepository.ObtenerUltSoeidAsignadoMAX_ID();
		List<AutoTasaSoeidDTO> listAutoTas = new ArrayList<AutoTasaSoeidDTO>();
		listAutoTas = solicitudCampanaJDBCRepository.ObtenerUltSoeidAsignado(listAutoTasMax_Id.get(0).getMax());
		try {
			System.out.println("262 listaAsignaciones->" + listaAsignaciones);
			System.out.println("263 listAutoTasMax_Id->" + listAutoTasMax_Id);
			System.out.println("264 listAutoTas->" + listAutoTas);
			// obtenemos el ultimo soeid asignado
			if (listAutoTas == null || listAutoTas.size() == 0) {
				soeidAsignado = "";
			} else {
				soeid_asig_ant = listAutoTas.get(0).getSOEID_ASIG();
			}
			System.out.println("272 listAutoTas->" + listAutoTas);
			// obtenemos la posicion en el arreglo del elemento
			int pos = 0;
			for (int i = 0; i < listaAsignaciones.size(); i++) {
				if (listaAsignaciones.get(i).getSoeid().equals(soeid_asig_ant)) {
					pos = i;
					i = listaAsignaciones.size() + 1;
				}
			}
			System.out.println("288 listaAsignaciones.size()->" + listaAsignaciones.size());
			for (int i = pos; i < listaAsignaciones.size() - 1; i++) {
				if (listaAsignaciones.get(i + 1) != null) {
					if (listaAsignaciones.get(i + 1).getOnline() == 1) {
						soeidAsignado = listaAsignaciones.get(i + 1).getSoeid();
						i = listaAsignaciones.size();
					}
				}
			}

			System.out.println(
					"298 listaAsignaciones.size() + soeidAsignado->" + listaAsignaciones.size() + soeidAsignado);
			if (soeidAsignado.equals(null) || soeidAsignado.equals("")) {
				for (int i = -1; i < listaAsignaciones.size(); i++) {
					if (listaAsignaciones.get(i + 1) != null) {
						if (listaAsignaciones.get(i + 1).getOnline() == 1) {
							soeidAsignado = listaAsignaciones.get(i + 1).getSoeid();
							i = listaAsignaciones.size();
						}
					}
				}
			}

			System.out.println(
					"310 listaAsignaciones.size() + soeidAsignado->" + listaAsignaciones.size() + soeidAsignado);
		} catch (Exception ex) {
			System.out.println("ex 292->" + ex.getMessage());
			System.out.println("ex 293->" + ex.getCause());
		}
		return soeidAsignado;
	}
	
	public Date fechaActualCompleta() {
		Date date = new Date();
		Date fecha = null;

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico_City"));
		TimeZone timeZone = cal.getTimeZone();
		System.out.println("Time zone ID: " + timeZone.getID());
		cal.setTime(date);
		System.out.println("......------------------------ cal: " + cal);
		
		fecha = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String fechaComoCadena = sdf.format(fecha);
		System.out.println("......------------------------ fechaComoCadena: " + fechaComoCadena);
		System.out.println("......------------------------ fecha: " + fecha);

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			fecha = formato.parse(fechaComoCadena);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------fecha" + fecha);
		return fecha;
	}
	
	public Date fechaActual() {
		Date date = new Date();
		Date fecha = null;

		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico_City"));
		TimeZone timeZone = cal.getTimeZone();
		System.out.println("Time zone ID: " + timeZone.getID());
		cal.setTime(date);
		System.out.println("......------------------------ cal: " + cal);
		
		fecha = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaComoCadena = sdf.format(fecha);
		System.out.println("......------------------------ fechaComoCadena: " + fechaComoCadena);
		System.out.println("......------------------------ fecha: " + fecha);

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fecha = formato.parse(fechaComoCadena);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------fecha" + fecha);
		return fecha;
	}
	
	public String deshabilitarFolioEspecial(List<SolicitudEstatusDTO> solicitud) throws GenericException {
		List<CatFolioDTO> folioEspecial = new ArrayList<CatFolioDTO>();
		String result = "";
		folioEspecial = autoTasasJDBCRepository.getFolioEspUtilizado(solicitud.get(0).getNumCte());
		if (folioEspecial.isEmpty() || folioEspecial == null || folioEspecial.size() == 0) {
			return result = "404,No tenia folio especial asignado";
		}
		autoTasasJDBCRepository.actualizaCatFolio(solicitud.get(0).getNumCte());
		result = "200,Folio Especial Liberado";
		return result;
	}
	
	

	
	
	@Override
	public MensajeDTO generaReporteEspe(AutoTasaGerenciaBEDTO items) throws GenericException, IOException, ParseException {
		MensajeDTO msg = new MensajeDTO();

		String[] title = {"Seguimiento Campaña Divisiones " + items.getFecha() + " a " + items.getFecha_fin(), "ID_CAMPAÑA", "Seguimiento Campaña Direcciones Regionales FECHA 1  al  FECHA 2",
				"Seguimiento Campaña Sucursales " + items.getFecha() +"  al  " + items.getFecha_fin()};
		List<ReportDataSource> reporte = serviceMenuGerenciaImp.ImprimirReporteOnLine(items);
		
		
		List<String> encabezadoDIV = Arrays.asList(ConstantUtils.TITLE_DIV);
		List<String> encabezadoREG = Arrays.asList(ConstantUtils.TITLE_REG);
		List<String> encabezadoSUC = Arrays.asList(ConstantUtils.TITLE_SUC);
		
		List<List<String>> listaDIV = procesoDatosDIV(reporte.get(0).getListaVistaDivisiones());
		List<List<String>> listaREG = procesoDatosREG(reporte.get(0).getListaVistaRegiones());
		List<List<String>> listaSUC = procesoDatosSUC(reporte.get(0).getListaVistaSucursales());
		
		Path excel = createExcelESP(title, encabezadoDIV, listaDIV, encabezadoREG, listaREG, encabezadoSUC, listaSUC, ""); 
		String ecoder = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(excel.toFile()));
		msg.setMensajeConfirm("Se generó el reporte satisfactoriamente");
		msg.setMensajeInfo(ecoder);
		return msg;
	}
	
	private List<List<String>> procesoDatosSUC(List<SucursalGerenciaResponseDTO> regUEC) throws GenericException{
		try {
			Double ejecutivos = 0.0, ventas = 0.0, ventasIDCAMP = 0.0;
			Double importe = 0.0, perCAP = 0.0, promedio = 0.0, importeIDCAMP = 0.0, sucSn = 0.0;
			List<List<String>> filas = new ArrayList<>();
			for(SucursalGerenciaResponseDTO value: regUEC) {
				List<String> fila = new ArrayList<String>();
				fila.add("" + value.getRK());
				fila.add("" + value.getDIVISION());
				fila.add("" + value.getRegion());
				fila.add("" + value.getDISTRITO());
				fila.add("" + value.getSuc());
				fila.add("" + value.getCantejec());
				fila.add("" + value.getVENTAS());
				fila.add("" + value.getMONTO());
				fila.add("" + value.getPer_Capita());
				fila.add("" + value.getMONTOVENTAS());
				fila.add("" + value.getCantSucSinVentas());
				fila.add("" + value.getVentaImporte().getCantVentasCam());
				fila.add("$" + value.getVentaImporte().getVentasCam());
				filas.add(fila);
				ejecutivos += value.getCantejec();
				ventas += value.getVENTAS();
				importe += value.getMONTO(); 
				perCAP += value.getPer_Capita();
				promedio += value.getMONTOVENTAS(); 
				sucSn += value.getCantSucSinVentas();
				ventasIDCAMP += value.getVentaImporte().getCantVentasCam();
				importeIDCAMP += value.getVentaImporte().getVentasCam();
			}
			
			List<String> total = new ArrayList<String>();
			total.add("");
			total.add("");
			total.add("");
			total.add("TOTAL");
			total.add("");
			total.add(ejecutivos.toString());
			total.add(ventas.toString());
			total.add(importe.toString());
			total.add(perCAP.toString());
			total.add(promedio.toString());
			total.add(sucSn.toString());
			total.add(ventasIDCAMP.toString());
			total.add(importeIDCAMP.toString());
			filas.add(total);
			
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte Acumulado :: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	private List<List<String>> procesoDatosREG(List<SucursalGerenciaResponseDTO> regUEC) throws GenericException{
		try {
			Double ejecutivos = 0.0, ventas = 0.0, ventasIDCAMP = 0.0;
			Double importe = 0.0, perCAP = 0.0, promedio = 0.0, importeIDCAMP = 0.0, sucSn = 0.0;
			List<List<String>> filas = new ArrayList<>();
			for(SucursalGerenciaResponseDTO value: regUEC) {
				List<String> fila = new ArrayList<String>();
				fila.add("" + value.getRK());
				fila.add("" + value.getDIVISION());
				fila.add("" + value.getRegion());
				fila.add("" + value.getCantejec());
				fila.add("" + value.getVENTAS());
				fila.add("$" + value.getMONTO());
				fila.add("" + value.getPer_Capita());
				fila.add("" +value.getMONTOVENTAS()); //PROMEDIO
				fila.add("" + value.getCantSucSinVentas());
				fila.add("" + value.getVentaImporte().getCantVentasCam());
				fila.add("$" + value.getVentaImporte().getVentasCam());
				filas.add(fila);
				ejecutivos += value.getCantejec();
				ventas += value.getVENTAS();
				importe += value.getMONTO(); 
				perCAP += value.getPer_Capita();
				promedio += value.getMONTOVENTAS();
				sucSn += value.getCantSucSinVentas();
				ventasIDCAMP += value.getVentaImporte().getCantVentasCam();
				importeIDCAMP += value.getVentaImporte().getVentasCam();
			}
			
			List<String> total = new ArrayList<String>();
			total.add("");
			total.add("");
			total.add("TOTAL");
			total.add(ejecutivos.toString());
			total.add(ventas.toString());
			total.add(importe.toString());
			total.add(perCAP.toString());
			total.add(promedio.toString());
			total.add(sucSn.toString());
			total.add(ventasIDCAMP.toString());
			total.add(importeIDCAMP.toString());
			filas.add(total);
			
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte Acumulado :: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	private List<List<String>> procesoDatosDIV(List<SucursalGerenciaResponseDTO> regUEC) throws GenericException{
		try {
			Double ejecutivos = 0.0, ventas = 0.0, ventasIDCAMP = 0.0;
			Double importe = 0.0, perCAP = 0.0, promedio = 0.0, importeIDCAMP = 0.0, sucSn = 0.0;
			List<List<String>> filas = new ArrayList<>();
			for(SucursalGerenciaResponseDTO value: regUEC) {
				List<String> fila = new ArrayList<String>();
				fila.add("" + value.getRK());
				fila.add("" + value.getDIVISION());
				fila.add("" + value.getCantejec());
				fila.add("" + value.getVENTAS()); //VENTAS
				fila.add("$" + value.getMONTO()); //IMPORTE
				fila.add("" + value.getPer_Capita());
				fila.add("" + value.getMONTOVENTAS()); // PROM
				fila.add("" + value.getCantSucSinVentas());
				fila.add("" + value.getVentaImporte().getCantVentasCam());
				fila.add("$" + value.getVentaImporte().getVentasCam()); 
				filas.add(fila);
				ejecutivos += value.getCantejec();
				ventas += value.getVENTAS();
				importe += value.getMONTO(); 
				perCAP += value.getPer_Capita();
				promedio += value.getMONTOVENTAS();
				sucSn += value.getCantSucSinVentas();
				ventasIDCAMP += value.getVentaImporte().getCantVentasCam();
				importeIDCAMP += value.getVentaImporte().getVentasCam();
			}
			
			List<String> total = new ArrayList<String>();
			total.add("");
			total.add("TOTAL");
			total.add(ejecutivos.toString());
			total.add(ventas.toString());
			total.add(importe.toString());
			total.add(perCAP.toString());
			total.add(promedio.toString());
			total.add(sucSn.toString());
			total.add(ventasIDCAMP.toString());
			total.add(importeIDCAMP.toString());
			filas.add(total);
			
			return filas;
		}catch (Exception e) {
			e.getStackTrace();
			throw new GenericException( "Error al generar el reporte Acumulado :: " , HttpStatus.NOT_FOUND.toString());
		}
	}
	
	public static Path createExcelESP(String[] title ,List<String> titulos, List<List<String>> renglones,
			List<String> titulos2, List<List<String>> renglones2, 
			List<String> titulos3, List<List<String>> renglones3, String nameFile ) throws IOException {
		Path testFile = Files.createTempFile("ReporteEspeciales", ".xlsx");
        testFile.toFile().deleteOnExit();
        try(XSSFWorkbook workbook = new XSSFWorkbook()) {
        	//ENCABEZADO
        	log.info("Encabezado");
        	XSSFSheet sheet = workbook.createSheet("Divisiones");
            Row rowheaderENC = sheet.createRow(0);
            Cell cell1 = rowheaderENC.createCell(0);
        	CellStyle style1 = workbook.createCellStyle();
        	XSSFFont font1 = workbook.createFont();
        	font1.setBold(true);
        	style1.setFont(font1);
        	style1.setAlignment(HorizontalAlignment.CENTER);
        	cell1.setCellStyle(style1);
        	cell1.setCellValue((String) title[0]);
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
            
            Cell cellP1 = rowheaderENC.createCell(8);
        	CellStyle stylep1 = workbook.createCellStyle();
        	stylep1.setAlignment(HorizontalAlignment.CENTER);
    		cellP1.setCellStyle(stylep1);
    		cellP1.setCellValue((String) "ID_CAMPAÑA");
            sheet.addMergedRegion(new CellRangeAddress(0,0,8,9));
            
        	//HOJA 1
            int colHeader = 1;
            Row rowheader = sheet.createRow(colHeader++);
            int colCell = 0;
            for (String field : titulos) {
                Cell cell = rowheader.createCell(colCell++);
                if (field instanceof String) {
                	CellStyle style = workbook.createCellStyle();
                	XSSFFont font = workbook.createFont();
                	font.setBold(true);
                	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                	style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                	style.setFont(font);
                	cell.setCellStyle(style);
                    cell.setCellValue((String) field);
                }
            }
            int rowNum = 2;
            for (List<String> key : renglones) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (String field : key) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    }
                }
            }
            
            //HOJA 2
          //ENCABEZADO
        	log.info("Encabezado");
        	XSSFSheet sheet2 = workbook.createSheet("Regionales");
            Row rowheaderENC2 = sheet2.createRow(0);
            Cell cell12 = rowheaderENC2.createCell(0);
        	CellStyle style12 = workbook.createCellStyle();
        	XSSFFont font12 = workbook.createFont();
        	font12.setBold(true);
        	style12.setFont(font12);
        	style12.setAlignment(HorizontalAlignment.CENTER);
        	cell12.setCellStyle(style12);
        	cell12.setCellValue((String) title[2]);
            sheet2.addMergedRegion(new CellRangeAddress(0,0,0,8));
            
            Cell cellP2 = rowheaderENC2.createCell(9);
        	CellStyle stylep2 = workbook.createCellStyle();
        	stylep2.setAlignment(HorizontalAlignment.CENTER);
    		cellP2.setCellStyle(stylep2);
    		cellP2.setCellValue((String) "ID_CAMPAÑA");
    		sheet2.addMergedRegion(new CellRangeAddress(0,0,9,10));
            
            int colHeader2 = 1;
            Row rowheader2 = sheet2.createRow(colHeader2++);
            int colCell2 = 0;
            for (String field2 : titulos2) {
                Cell cell2 = rowheader2.createCell(colCell2++);
                if (field2 instanceof String) {
                	CellStyle style2 = workbook.createCellStyle();
                	XSSFFont font2 = workbook.createFont();
                	font2.setBold(true);
                	style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                	style2.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                	style2.setFont(font2);
                	cell2.setCellStyle(style2);
                    cell2.setCellValue((String) field2);
                }
            }
            int rowNum2 = 2;
            for (List<String> key2 : renglones2) {
                Row row2 = sheet2.createRow(rowNum2++);
                int colNum2 = 0;
                for (String field2 : key2) {
                    Cell cell2 = row2.createCell(colNum2++);
                    if (field2 instanceof String) {
                        cell2.setCellValue((String) field2);
                    }
                }
            }
            
            //HOJA 3
            log.info("Encabezado");
            XSSFSheet sheet3 = workbook.createSheet("Sucursales");
            Row rowheaderENC3 = sheet3.createRow(0);
            Cell cell13 = rowheaderENC3.createCell(0);
        	CellStyle style13 = workbook.createCellStyle();
        	XSSFFont font13 = workbook.createFont();
        	font13.setBold(true);
        	style13.setFont(font13);
        	style13.setAlignment(HorizontalAlignment.CENTER);
        	cell13.setCellStyle(style13);
        	cell13.setCellValue((String) title[3]);
            sheet3.addMergedRegion(new CellRangeAddress(0,0,0,10));
            
            Cell cellP3 = rowheaderENC3.createCell(11);
        	CellStyle stylep3 = workbook.createCellStyle();
        	stylep3.setAlignment(HorizontalAlignment.CENTER);
    		cellP3.setCellStyle(stylep3);
    		cellP3.setCellValue((String) "ID_CAMPAÑA");
    		sheet3.addMergedRegion(new CellRangeAddress(0,0,11,12));
            
            int colHeader3 = 1;
            Row rowheader3 = sheet3.createRow(colHeader3++);
            int colCell3 = 0;
            for (String field3 : titulos3) {
                Cell cell3 = rowheader3.createCell(colCell3++);
                if (field3 instanceof String) {
                	CellStyle style3 = workbook.createCellStyle();
                	XSSFFont font3 = workbook.createFont();
                	font3.setBold(true);
                	style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                	style3.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                	style3.setFont(font3);
                	cell3.setCellStyle(style3);
                    cell3.setCellValue((String) field3);
                }
            }
            int rowNum3 = 2;
            for (List<String> key : renglones3) {
                Row row = sheet3.createRow(rowNum3++);
                int colNum3 = 0;
                for (String field3 : key) {
                    Cell cell3 = row.createCell(colNum3++);
                    if (field3 instanceof String) {
                        cell3.setCellValue((String) field3);
                    }
                }
            }
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workbook.write(bos);
            bos.close();
            Files.write(testFile, bos.toByteArray());
        }
        return testFile;
	}	
	
}
