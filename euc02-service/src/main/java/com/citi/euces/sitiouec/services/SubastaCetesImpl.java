package com.citi.euces.sitiouec.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.citi.euces.sitiouec.dto.AutoRangoDTO;
import com.citi.euces.sitiouec.dto.CetePaginaDTO;
import com.citi.euces.sitiouec.dto.HistoricoCetesDTO;
import com.citi.euces.sitiouec.dto.MensajeDTO;
import com.citi.euces.sitiouec.dto.ReporteCetesDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

import com.citi.euces.sitiouec.repositories.AutoCetesRepo;
import com.citi.euces.sitiouec.repositories.AutoRangoRepo;

import com.citi.euces.sitiouec.repositories.CalculoCetesRepository;

import com.citi.euces.sitiouec.repositories.SubastaCetesRepository;
import com.citi.euces.sitiouec.services.api.SubastaCetesService;

@Service
public class SubastaCetesImpl implements SubastaCetesService {

	private static final Logger LOGGER = LogManager.getLogger(SubastaCetesImpl.class);

	@Autowired
	private SubastaCetesRepository repository;
	@Autowired
	private AutoRangoRepo autoRangoRepo;
	@Autowired
	private AutoCetesRepo autoCetesRepo;
	
	@Autowired
	private CalculoCetesRepository calculoCetesRepository;

	@Override
	public List<HistoricoCetesDTO> listadoSubastaCetes() {
		List<HistoricoCetesDTO> listaHistoricoCete = new ArrayList<>();

		listaHistoricoCete = repository.listadoSubastaCetes();

		if (listaHistoricoCete.isEmpty() || listaHistoricoCete.size() < 0) {
			LOGGER.info("class:: SubastaCetesImpl - Method::listadoSubastaCetes  " + " " + " SIN REGISTROS");
		}
		return listaHistoricoCete;
	}

	@Override
	public MensajeDTO insertHistoricoCetes(String fecha, Double cete1plazo, Double cete1tasa, Double cete2plazo,
			Double cete2tasa, Double cete3plazo, Double cete3tasa, Double cete4plazo, Double cete4tasa,
			Boolean subasta4plazos) throws GenericException, IOException, ParseException {
		try {
			MensajeDTO msg = new MensajeDTO();
			calculoCetesRepository.insertHistoricoCetes(fecha, cete1plazo, cete1tasa, cete2plazo, cete2tasa, cete3plazo,
					cete3tasa, cete4plazo, cete4tasa, subasta4plazos);
			msg.setMensajeInfo("La lista de Cetes fue actualizada");
			msg.setMensajeConfirm("Lista Actualizada");
			return msg;

		} catch (Exception e) {
			e.getStackTrace();
			throw new GenericException("Error al actualizar el registro indicado", HttpStatus.NOT_FOUND.toString());
		}
	}

	@Override
	public MensajeDTO cargarAutoRangos(String code ,String fecha_inicio, String fecha_fin) throws GenericException, IOException, ParseException{
		try {
			MensajeDTO msg = new MensajeDTO();
			byte[] bytes = code.getBytes();
	    	byte[] decodedBytess = Base64.getDecoder().decode(code);
	        byte[] encodedBytes = Base64.getEncoder().encode(decodedBytess);
	        String cadenaencodedBytes2 = new String(encodedBytes);
	        byte[] decodedBytes2 = Base64.getDecoder().decode(cadenaencodedBytes2.getBytes());
	    	String message;
			Path testFile = Files.createTempFile("AutoRangoCetes", ".txt");
			byte[] decoder = Base64.getDecoder().decode(cadenaencodedBytes2);
	        Files.write(testFile, decoder);
	        message = leerArchivoRangoCetes(testFile,fecha_inicio,  fecha_fin);
	        testFile.toFile().delete();
	        msg.setMensajeInfo("Ingresa para leer el archivo");
	        msg.setMensajeConfirm(message);
			return msg;	
		}catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al cargar información en Autorango Cetes ::  ",
					HttpStatus.NOT_FOUND.toString());
		}
	}
	
	public String leerArchivoRangoCetes(Path tempFile,String fecha_inicio, String fecha_fin) throws IOException, GenericException, ParseException{
		
		String Mensaje = "";
		try {

			String linea;
   			Integer id = 0;
   			Integer id2 = 0;
   			Integer acum = 0;
   			FileReader f = new FileReader(tempFile.toFile());
   	        BufferedReader b = new BufferedReader(f);
   	        String cadena ;
            String plazo = null;
            String cete = null;

             int valida_cetes = 0;
             int valida_rangos = 0;
             Long idR =null;
             Long RangoMin = null;
             Long RangoMax = null;
             String MILL_DOSMILLQUIN = null;
             String FECHA  = null;
             String FECHAFIN  = null;
             int idacum = 1;
        
             SimpleDateFormat objSDF3 = new SimpleDateFormat("yyyy-MM-dd");
             Date d = new Date();
             int valida = 0;
             
             autoRangoRepo.Eliminar();
            
             autoCetesRepo.Eliminar();
             
 	        
             FECHA = objSDF3.format(objSDF3.parse(fecha_inicio))+" 00:00:00";
             FECHAFIN = objSDF3.format(objSDF3.parse(fecha_fin))+" 00:00:00";
 	        
   	     while ((linea= b.readLine()) != null) {
   	   	   
	        	for (String part2 : linea.split("\\t")) {
	        		if(id >= 5) {
	        			if(!part2.replaceAll("[A-Z-a-z-\"]","").isEmpty() ) {
	        					if(!part2.replaceAll("[A-Z-a-z-\"]","").equals("20,000,000.00") ) {
	        						
	        						cadena = part2.replaceAll("[A-Z-a-z-\"]","");
	        						
	        						switch (id2) {
	        						
	        						case 0: 
										plazo = cadena.replace("%", "");
										System.out.println("id = "+ id+ " plazo = "+ plazo+ " id2 = "+ id2);
										break;
									case 1: 
										cete = cadena.replace("%", "");
										System.out.println(" plazo2 = "+ plazo);
										System.out.println("id = "+ id+ " cete = "+ cete+ " id2 = "+ id2);
										valida_cetes = autoCetesRepo.Insertar(Long.parseLong(plazo), Double.parseDouble(cete));
										
										
										break;
	        						
	        						case 4: 
	        							System.out.println(id+ "id"+ "id2"+ id2);
										if(id>8) {
											System.out.println("entro");
											String min = cadena.replace("%", "").replaceAll("[A-Z-a-z-\"]","").replace("í", "");
											System.out.println("entro = min = "+ min);
											min = min.replaceAll("\\s+","|");
											System.out.println("entro = min2 = "+ min);
											int  num1 = min.indexOf("|");
											int  num2 = min.lastIndexOf("|");
											
												System.out.println("en 1 "+min.indexOf("|"));
												System.out.println("en 2 "+min.lastIndexOf("|"));
												System.out.println("en 3 "+min.valueOf(num1+", "+num2));
												System.out.println("en 4 "+min.valueOf(num1+", "+num2));
												System.out.println("en 5 "+min.substring(0,min.indexOf("|"))+" :: "+min.substring(min.indexOf("|")+1,min.lastIndexOf("|")));
											
											RangoMin =  Long.parseLong( min.substring(0,  min.indexOf("|")))  ;
											System.out.println("entro = RangoMin = "+ RangoMin +" 0, "+min.indexOf("|"));
									      //  RangoMax = Long.parseLong( min.substring(min.indexOf("|"),min.length()).replace("|", ""));	
											RangoMax = Long.parseLong( min.substring(min.indexOf("|")+1,min.lastIndexOf("|")));
									        System.out.println("entro = RangoMax = "+ RangoMax +" "+min.indexOf("|")+" , "+min.length());
									        System.out.println("entro = RangoMax = "+ RangoMax);
									        System.out.println(RangoMin +"::"+RangoMax);
										}
										break;
									case 6: 
									Timestamp timestamp = Timestamp.valueOf(FECHA);
									Timestamp timestamp2 = Timestamp.valueOf(FECHAFIN);
									System.out.println((long) idacum+ " : "+ RangoMin+ " : "+ RangoMax+ " : "+ Double.parseDouble(cadena.replace("%", ""))+ " : "+ timestamp+ " : "+  timestamp2);
									valida_rangos =autoRangoRepo.Insertar((long) idacum, RangoMin, RangoMax, Double.parseDouble(cadena.replace("%", "")), timestamp, timestamp2);
									
									
									idacum++;
										break;
									default:
										break;
									}
	        						
	   	   	        		     id2++;  	   	        	

	        					}
	        			}
	        		}
	        		
	        	}
	        	id2 = 0;
	        	id++;
	        }
    	    
   	        if(valida_cetes > 0 || valida_rangos > 0) {
   	        	 Mensaje =  "Se importaron exitosamente: " + id + " registros.";	
   	        }else {
   	        	 Mensaje = "Error al cargar los autorangos de Cetes ";	
				throw new GenericException("Error");
   	        }
   	     
   	        b.close();
	        return Mensaje;	
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al cargar los autorangos de Cetes ::  ", HttpStatus.NOT_FOUND.toString());
		}
	}

	@Override
	public List<CetePaginaDTO> excelCetesVariacion() throws GenericException {

		List<CetePaginaDTO> listaCetes = new ArrayList<CetePaginaDTO>();
		List<CetePaginaDTO> listaCetesVariacion = new ArrayList<>();
		HistoricoCetesDTO ceteHistorico = repository.obtenerHistorialCetes();
		List<HistoricoCetesDTO> listaTemporal = repository.obtenerListaHistorialCetes();
		listaTemporal.remove(listaTemporal.get(listaTemporal.size() - 1));
		HistoricoCetesDTO ceteHistoPenultimo = listaTemporal.get(listaTemporal.size() - 1);
		boolean yaGenerado = false;
		boolean yaCopiado = false;

		LOGGER.info("ceteHistorico - excelCetesVariacion " + " " + ceteHistorico.toString());

		LOGGER.info("ceteHistorico - listaTemporal - size() " + " " + listaTemporal.size());

		LOGGER.info("ceteHistorico - ceteHistoPenultimo - " + " " + ceteHistoPenultimo.toString());

		try {

			listaCetes = repository.obtenerCetes();

			for (CetePaginaDTO historicoCetesDTO : listaCetes) {
				LOGGER.info("historicoCetesDTO - " + " " + historicoCetesDTO.getPlazo());
				LOGGER.info("historicoCetesDTO - " + " " + historicoCetesDTO.getTasa());
			}

			LOGGER.info("ceteHistorico - repository.obtenerCetes() - " + " " + listaCetes.size());

			Optional<CetePaginaDTO> ceteAux1 = listaCetes.stream().filter(x -> x.getPlazo() == 1.0).findFirst();

			if (ceteAux1.isPresent()) {
				listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 1.0).findFirst().get());
			}

			Optional<CetePaginaDTO> ceteAux2 = listaCetes.stream().filter(x -> x.getPlazo() == 7.0).findFirst();

			if (ceteAux2.isPresent()) {
				listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 7.0).findFirst().get());
			}

			listaCetesVariacion.add(new CetePaginaDTO(ceteHistorico.getCete1plazo(), ceteHistorico.getCete1tasa(),
					getVariance(ceteHistoPenultimo.getCete1tasa(), ceteHistorico.getCete1tasa())));

			Optional<CetePaginaDTO> ceteAux34 = listaCetes.stream().filter(x -> x.getPlazo() == 34.0).findFirst();

			if (ceteAux34.isPresent()) {
				listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 34.0).findFirst().get());
			}

			Optional<CetePaginaDTO> ceteAux39 = listaCetes.stream().filter(x -> x.getPlazo() == 39.0).findFirst();

			if (ceteAux39.isPresent()) {
				listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 39.0).findFirst().get());
			}

			Optional<CetePaginaDTO> ceteAux52 = listaCetes.stream().filter(x -> x.getPlazo() == 52.0).findFirst();

			if (ceteAux52.isPresent()) {
				listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 52.0).findFirst().get());
			}

			Optional<CetePaginaDTO> ceteAux63 = listaCetes.stream().filter(x -> x.getPlazo() == 63.0).findFirst();

			if (ceteAux63.isPresent()) {
				listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 63.0).findFirst().get());
			}

			listaCetesVariacion.add(new CetePaginaDTO(ceteHistorico.getCete2plazo(), ceteHistorico.getCete2tasa(),
					getVariance(ceteHistoPenultimo.getCete2tasa(), ceteHistorico.getCete2tasa())));

			Optional<CetePaginaDTO> ceteAux136 = listaCetes.stream().filter(x -> x.getPlazo() == 136.0).findFirst();

			if (ceteAux136.isPresent()) {
				listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 136.0).findFirst().get());
			}

			listaCetesVariacion.add(new CetePaginaDTO(ceteHistorico.getCete3plazo(), ceteHistorico.getCete3tasa(),
					getVariance(ceteHistoPenultimo.getCete3tasa(), ceteHistorico.getCete3tasa())));

			listaCetesVariacion.add(new CetePaginaDTO(ceteHistorico.getCete4plazo(), ceteHistorico.getCete4tasa(),
					getVariance(ceteHistoPenultimo.getCete4tasa(), ceteHistorico.getCete4tasa())));

			LOGGER.info("Termino las validaciones -  listaCetesVariacion");

			/**
			 * si el penultimo es 0 y tenemos una semana con 4 tasas
			 */

			if (ceteHistoPenultimo.getCete4tasa() == 0 && ceteHistorico.getCete4tasa() != 0) {

				LOGGER.info(
						"ceteHistorico - ceteHistoPenultimo.getCete4tasa() == 0 && ceteHistorico.getCete4tasa() != 0 -");

				for (int i = listaTemporal.size() - 1; i >= 0; i--) {
					if (listaTemporal.get(i).getCete4tasa() != 0) {
						if (!yaCopiado) {
							ceteHistoPenultimo.setCete4tasa(listaTemporal.get(i).getCete4tasa());
							yaCopiado = true;
						}
					}
				}
				listaCetesVariacion.add(new CetePaginaDTO(ceteHistorico.getCete4plazo(), ceteHistorico.getCete4tasa(),
						getVariance(ceteHistoPenultimo.getCete4tasa(), ceteHistorico.getCete4tasa())));
			} else {
				LOGGER.info("ceteHistorico - ceteHistoPenultimo.getCete4tasa() == 0 &&"
						+ " ceteHistorico.getCete4tasa() != 0 - Sin informacion por Procesar");
			}

			/**
			 * si tenemos un penultimo de cete 4= 0 y la semana es de 3 tasas
			 */

			if (ceteHistoPenultimo.getCete4tasa() == 0 && ceteHistorico.getCete4tasa() == 0) {
				LOGGER.info(
						"ceteHistorico - ceteHistoPenultimo.getCete4tasa() == 0 && ceteHistorico.getCete4tasa() == 0");

				for (int i = listaTemporal.size() - 1; i >= 0; i--) {
					if (listaTemporal.get(i).getCete4tasa() != 0) {
						if (!yaCopiado) {
							ceteHistoPenultimo.setCete4tasa(listaTemporal.get(i).getCete4tasa());
							ceteHistoPenultimo.setCete4plazo(listaTemporal.get(i).getCete4plazo());
							ceteHistoPenultimo.setFecha(listaTemporal.get(i).getFecha());
							yaCopiado = true;
						}
					}
				}

				listaCetesVariacion
						.add(new CetePaginaDTO(ceteHistoPenultimo.getCete4plazo(), ceteHistoPenultimo.getCete4tasa(),
								"Subasta Mensual: " + ceteHistoPenultimo.getFecha().toString()));
				yaGenerado = true;
			} else {
				LOGGER.info("ceteHistorico - ceteHistoPenultimo.getCete4tasa() == 0 "
						+ "&& ceteHistorico.getCete4tasa() == 0 - Sin informacion por Procesar");
			}

			/**
			 * si tenemos un penultimo de cete4 con una tasa y la semana es de 3 tasas no
			 * hacemos busqueda hacia atras
			 */

			if (!yaGenerado) {
				LOGGER.info(
						"ceteHistorico - ceteHistoPenultimo.getCete4tasa() != 0 && ceteHistorico.getCete4tasa() == 0");
				if (ceteHistoPenultimo.getCete4tasa() != 0 && ceteHistorico.getCete4tasa() == 0)
					LOGGER.info(
							"ceteHistorico - ceteHistoPenultimo.getCete4tasa() != 0 && ceteHistorico.getCete4tasa() == 0");
				{
					listaCetesVariacion.add(
							new CetePaginaDTO(ceteHistoPenultimo.getCete4plazo(), ceteHistoPenultimo.getCete4tasa(),
									"Subasta Mensual: " + ceteHistoPenultimo.getFecha().toString()));
				}
			} else {
				LOGGER.info("ceteHistorico - ceteHistoPenultimo.getCete4tasa() != 0 "
						+ "&& ceteHistorico.getCete4tasa() == 0 - Sin informacion por procesar");
			}

			Optional<CetePaginaDTO> ceteAux378 = listaCetes.stream().filter(x -> x.getPlazo() == 378.0).findFirst();

			if (ceteAux378.isPresent()) {
				listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 378).findFirst().get());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al ejecutar metodo excelCetesVariacion ::  ",
					HttpStatus.NOT_FOUND.toString());
		}

		LOGGER.info("ceteHistorico - Lista Final " + " " + listaCetesVariacion.size());

		return listaCetesVariacion;
	}

	/**
	 * Preguntar a Demetrio el formato de tasa2 - tasa1
	 * 
	 * @param tasa1
	 * @param tasa2
	 * @return
	 */
	public String getVariance(double tasa1, double tasa2) {
		String diferencia = "";
		tasa1 *= 10000;
		tasa2 *= 10000;
		if (tasa1 - tasa2 == 0) {
			diferencia = "Sin Variación";
		}
		if (tasa1 - tasa2 < 0) {
			diferencia = "Aumentó " + String.valueOf(tasa2 - tasa1) + " Punto(s) Básico(s)";
		}
		if (tasa1 - tasa2 > 0) {
			diferencia = "Disminuyó " + String.valueOf(tasa2 - tasa1) + " Punto(s) Básico(s)";
		}
		return diferencia;
	}

	@Override
	public List<ReporteCetesDTO> getSubastaCetes() throws GenericException {

		List<ReporteCetesDTO> lsReporteCetes     = new ArrayList<>();
		ReporteCetesDTO reporteCetes             = new ReporteCetesDTO();
		List<CetePaginaDTO> listaCetes           = new ArrayList<CetePaginaDTO>();
		List<CetePaginaDTO> listaCetesVariacion  = new ArrayList<>();
		HistoricoCetesDTO ceteHistoPenultimo     = new HistoricoCetesDTO();

		HistoricoCetesDTO ceteHistorico = repository.obtenerHistorialCetes();
		listaCetes = repository.obtenerCetes();

		LOGGER.info("Paso por - " + "HistoricoCetesDTO ceteHistorico         = repository.obtenerHistorialCetes();"
				+ "Size()" + ceteHistorico.toString());

		List<HistoricoCetesDTO> listaTemporal = repository.obtenerListaHistorialCetes();

		LOGGER.info("Paso por - " + "List<HistoricoCetesDTO> listaTemporal   = repository.obtenerListaHistorialCetes();"
				+ "Size()" + listaTemporal.size());

		boolean yaGenerado = false;
		boolean yaCopiado = false;

		LOGGER.info("getSubastaCetes - " + "1");

		try {

			LOGGER.info("getSubastaCetes - " + "2");

			listaTemporal.remove(listaTemporal.get(listaTemporal.size() - 1));
			ceteHistoPenultimo = listaTemporal.get(listaTemporal.size() - 1);
				
				LOGGER.info("getSubastaCetes - " + "3");
			
				for (CetePaginaDTO historicoCetesDTO : listaCetes) {
					LOGGER.info("historicoCetesDTO - " + " " + historicoCetesDTO.getPlazo());
					LOGGER.info("historicoCetesDTO - " + " " + historicoCetesDTO.getTasa());
				}

				LOGGER.info("getSubastaCetes - " + "4");

				Optional<CetePaginaDTO> ceteAux1 = listaCetes.stream().filter(x -> x.getPlazo() == 1.0).findFirst();

				if (ceteAux1.isPresent()) {
					listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 1.0).findFirst().get());
				}

				LOGGER.info("getSubastaCetes - " + "5");
				Optional<CetePaginaDTO> ceteAux2 = listaCetes.stream().filter(x -> x.getPlazo() == 7.0).findFirst();

				if (ceteAux2.isPresent()) {
					listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 7.0).findFirst().get());
				}

				listaCetesVariacion.add(new CetePaginaDTO(ceteHistorico.getCete1plazo(), ceteHistorico.getCete1tasa(),
						getVariance(ceteHistoPenultimo.getCete1tasa(), ceteHistorico.getCete1tasa())));

				Optional<CetePaginaDTO> ceteAux34 = listaCetes.stream().filter(x -> x.getPlazo() == 34.0).findFirst();

				LOGGER.info("getSubastaCetes - " + "6");
				
				if (ceteAux34.isPresent()) {
					listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 34.0).findFirst().get());
				}

				Optional<CetePaginaDTO> ceteAux39 = listaCetes.stream().filter(x -> x.getPlazo() == 39.0).findFirst();

				if (ceteAux39.isPresent()) {
					listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 39.0).findFirst().get());
				}

				Optional<CetePaginaDTO> ceteAux52 = listaCetes.stream().filter(x -> x.getPlazo() == 52.0).findFirst();

				if (ceteAux52.isPresent()) {
					listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 52.0).findFirst().get());
				}

				Optional<CetePaginaDTO> ceteAux63 = listaCetes.stream().filter(x -> x.getPlazo() == 63.0).findFirst();

				if (ceteAux63.isPresent()) {
					listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 63.0).findFirst().get());
				}
				
				LOGGER.info("getSubastaCetes - " + "7");

				listaCetesVariacion.add(new CetePaginaDTO(ceteHistorico.getCete2plazo(), ceteHistorico.getCete2tasa(),
						getVariance(ceteHistoPenultimo.getCete2tasa(), ceteHistorico.getCete2tasa())));

				Optional<CetePaginaDTO> ceteAux136 = listaCetes.stream().filter(x -> x.getPlazo() == 136.0).findFirst();

				if (ceteAux136.isPresent()) {
					listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 136.0).findFirst().get());
				}

				listaCetesVariacion.add(new CetePaginaDTO(ceteHistorico.getCete3plazo(), ceteHistorico.getCete3tasa(),
						getVariance(ceteHistoPenultimo.getCete3tasa(), ceteHistorico.getCete3tasa())));

				listaCetesVariacion.add(new CetePaginaDTO(ceteHistorico.getCete4plazo(), ceteHistorico.getCete4tasa(),
						getVariance(ceteHistoPenultimo.getCete4tasa(), ceteHistorico.getCete4tasa())));

				LOGGER.info("getSubastaCetes - " + "8");
				
				
				LOGGER.info("Termino las validaciones -  listaCetesVariacion");

				/**
				 * si el penultimo es 0 y tenemos una semana con 4 tasas
				 */

				if (ceteHistoPenultimo.getCete4tasa() == 0 && ceteHistorico.getCete4tasa() != 0) {

					LOGGER.info(
							"ceteHistorico - ceteHistoPenultimo.getCete4tasa() == 0 && ceteHistorico.getCete4tasa() != 0 -");

					for (int i = listaTemporal.size() - 1; i >= 0; i--) {
						if (listaTemporal.get(i).getCete4tasa() != 0) {
							if (!yaCopiado) {
								ceteHistoPenultimo.setCete4tasa(listaTemporal.get(i).getCete4tasa());
								yaCopiado = true;
							}
						}
					}
					listaCetesVariacion
							.add(new CetePaginaDTO(ceteHistorico.getCete4plazo(), ceteHistorico.getCete4tasa(),
									getVariance(ceteHistoPenultimo.getCete4tasa(), ceteHistorico.getCete4tasa())));
				} else {
					LOGGER.info("ceteHistorico - ceteHistoPenultimo.getCete4tasa() == 0 &&"
							+ " ceteHistorico.getCete4tasa() != 0 - Sin informacion por Procesar");
				}

				/**
				 * si tenemos un penultimo de cete 4= 0 y la semana es de 3 tasas
				 */

				if (ceteHistoPenultimo.getCete4tasa() == 0 && ceteHistorico.getCete4tasa() == 0) {
					LOGGER.info(
							"ceteHistorico - ceteHistoPenultimo.getCete4tasa() == 0 && ceteHistorico.getCete4tasa() == 0");

					for (int i = listaTemporal.size() - 1; i >= 0; i--) {
						if (listaTemporal.get(i).getCete4tasa() != 0) {
							if (!yaCopiado) {
								ceteHistoPenultimo.setCete4tasa(listaTemporal.get(i).getCete4tasa());
								ceteHistoPenultimo.setCete4plazo(listaTemporal.get(i).getCete4plazo());
								ceteHistoPenultimo.setFecha(listaTemporal.get(i).getFecha());
								yaCopiado = true;
							}
						}
					}

					listaCetesVariacion.add(
							new CetePaginaDTO(ceteHistoPenultimo.getCete4plazo(), ceteHistoPenultimo.getCete4tasa(),
									"Subasta Mensual: " + ceteHistoPenultimo.getFecha().toString()));
					yaGenerado = true;
				} else {
					LOGGER.info("ceteHistorico - ceteHistoPenultimo.getCete4tasa() == 0 "
							+ "&& ceteHistorico.getCete4tasa() == 0 - Sin informacion por Procesar");
				}

				/**
				 * si tenemos un penultimo de cete4 con una tasa y la semana es de 3 tasas no
				 * hacemos busqueda hacia atras
				 */

				if (!yaGenerado) {
					LOGGER.info(
							"ceteHistorico - ceteHistoPenultimo.getCete4tasa() != 0 && ceteHistorico.getCete4tasa() == 0");
					if (ceteHistoPenultimo.getCete4tasa() != 0 && ceteHistorico.getCete4tasa() == 0)
						LOGGER.info(
								"ceteHistorico - ceteHistoPenultimo.getCete4tasa() != 0 && ceteHistorico.getCete4tasa() == 0");
					{
						listaCetesVariacion.add(
								new CetePaginaDTO(ceteHistoPenultimo.getCete4plazo(), ceteHistoPenultimo.getCete4tasa(),
										"Subasta Mensual: " + ceteHistoPenultimo.getFecha().toString()));
					}
				} else {
					LOGGER.info("ceteHistorico - ceteHistoPenultimo.getCete4tasa() != 0 "
							+ "&& ceteHistorico.getCete4tasa() == 0 - Sin informacion por procesar");
				}

				LOGGER.info("getSubastaCetes - " + "9");
				
				
				Optional<CetePaginaDTO> ceteAux378 = listaCetes.stream().filter(x -> x.getPlazo() == 378.0).findFirst();

				if (ceteAux378.isPresent()) {
					listaCetesVariacion.add(listaCetes.stream().filter(x -> x.getPlazo() == 378).findFirst().get());
				}else {
					LOGGER.info("(ceteAux378.isPresent() - No hay Elemento Presente");
				}

		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al ejecutar metodo excelCetesVariacion ::  ",
					HttpStatus.NOT_FOUND.toString());
		}

		reporteCetes.setListaCetes(listaCetes);
		reporteCetes.setListaCetesVariacion(listaCetesVariacion);
		lsReporteCetes.add(reporteCetes);

		return lsReporteCetes;
	}

}
