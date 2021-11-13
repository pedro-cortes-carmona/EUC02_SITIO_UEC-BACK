package com.citi.euces.sitiouec.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.euces.sitiouec.entities.AutoCetes;
import com.citi.euces.sitiouec.entities.AutoTasas;
import com.citi.euces.sitiouec.entities.Sucursales;
import com.citi.euces.sitiouec.entities.UecCatalogoAutorizadores2021;
import com.citi.euces.sitiouec.infra.dto.ActSolicitudDtoRequest;
import com.citi.euces.sitiouec.infra.dto.ActSolicitudDtoResponse;
import com.citi.euces.sitiouec.infra.dto.DiasFestivosBEDTO;
import com.citi.euces.sitiouec.infra.dto.DiasFestivosResponseDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.repositories.AutoTasasRepository;
import com.citi.euces.sitiouec.repositories.Autorizadores2021Repository;
import com.citi.euces.sitiouec.services.api.ServiceSolicitudInversion;






@Service 
public class ServiceSolicitudInversionImp implements ServiceSolicitudInversion {
	private static final Logger LOGGER = LogManager.getLogger(ServiceSolicitudInversionImp.class);
//	List<DiasFestivos> lstdias = null;
	List<Sucursales> listSucursal = null;
	List<AutoCetes> listCetes = null;

	Long id_Tasa;
	double porsentaje  ;
	double tasa100Porc;
	
	@Autowired
	AutoTasasRepository autoTasasRepository;
	@Autowired
	Autorizadores2021Repository autorizadores2021Repository;
	
//	@Override
//	public List<DiasFestivosResponseDTO> ObtenerDiasFeriados(DiasFestivosBEDTO request) throws GenericException, IOException {
//		Date  actual=  new Date();
//		Calendar c = Calendar.getInstance();
//		SimpleDateFormat objSDF = new SimpleDateFormat("dd/MM/yyyy"); 
//		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy"); 
//		int aumento = 0;
//		int plazo = 0;
//		int validacion = 0;
//		lstdias = diasFestivosRepo.obtenerListaFechas();
//		List<DiasFestivosResponseDTO> diasFestivosResponse = new ArrayList<DiasFestivosResponseDTO>();
//		try{			
//			c.setTime(actual);
//	        c.add(Calendar.DATE, request.getPlazo().intValue());
//	        actual = c.getTime();
//	        objSDF.applyLocalizedPattern("E");
//	        LOGGER.debug( objSDF2.format(actual).toString());
//	        
//			for(DiasFestivos dia : lstdias) {
//				objSDF.applyLocalizedPattern("E");
//		        LOGGER.debug( objSDF2.format(actual).toString()+ " - "+ dia.getFECHA()+ " --- "+objSDF2.format(dia.getFECHA()));
//		      //  diasFestivosResponse.add(new DiasFestivosResponseDTO(plazo,"1"+objSDF2.format(actual)));
//				if(objSDF2.format(actual).toString().equals(objSDF2.format(dia.getFECHA()))) {
//					if(dia.getDESCRIPCION().equals("Semana Santa")) {
//						c.setTime(actual);
//						aumento = (objSDF.format(actual).toString().equals("jue") || objSDF.format(actual).toString().equals("Thu") ) ? aumento+2:aumento+1;
//			        	//aumento = aumento+1;
//			            c.add(Calendar.DATE, aumento);
//			            actual = c.getTime();
//			            validacion =1;
//			            if(objSDF.format(actual).toString().equals("sáb") || objSDF.format(actual).toString().equals("Sat")) {
//			            	c.setTime(actual);
//			            	aumento = aumento+ 2;
//			                c.add(Calendar.DATE, 2);
//			                actual = c.getTime();
//			                plazo = request.getPlazo().intValue() +aumento; 
//			                diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo) , objSDF2.format(actual)));
//			            }else {
//			            	plazo = request.getPlazo().intValue() +aumento;
//			            	diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo),objSDF2.format(actual)));
//			            }
//					}else {
//						c.setTime(actual);
//			        	aumento = aumento+1;
//			            c.add(Calendar.DATE, aumento);
//			            actual = c.getTime();
//			            validacion =1;
//			            if(objSDF.format(actual).toString().equals("sáb") || objSDF.format(actual).toString().equals("Sat")) {
//			            	c.setTime(actual);
//			            	aumento = aumento+ 2;
//			                c.add(Calendar.DATE, 2);
//			                actual = c.getTime();
//			                plazo = request.getPlazo().intValue() +aumento;
//			                diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo),objSDF2.format(actual)));
//			            }else {
//			            	plazo = request.getPlazo().intValue() +aumento;
//			            	diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo),objSDF2.format(actual)));
//			            }
//					}
//					
//				}
//			}
//			if(validacion == 0) {
//				if(objSDF.format(actual).toString().equals("sáb") || objSDF.format(actual).toString().equals("Sat")) {
//					c.setTime(actual);
//					aumento = 2;
//					c.add(Calendar.DATE, aumento);
//					actual = c.getTime();
//					plazo = request.getPlazo().intValue() +aumento;
//					diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo),objSDF2.format(actual)));
//				}else if (objSDF.format(actual).toString().equals("dom") || objSDF.format(actual).toString().equals("Sun")) {
//					c.setTime(actual);
//					aumento = 1;
//					c.add(Calendar.DATE, aumento);
//					actual = c.getTime();
//					plazo = request.getPlazo().intValue() +aumento;
//					diasFestivosResponse.add(new DiasFestivosResponseDTO(Long.valueOf(plazo),objSDF2.format(actual)));
//				}else {
//					diasFestivosResponse.add(new DiasFestivosResponseDTO(request.getPlazo(),objSDF2.format(actual)));
//				}
//			}
//			
//		}catch (Exception ex) {
//			System.out.println("ex ->" + ex.getMessage());
//			System.out.println("ex ->" + ex.getCause());
//		}		
//		return diasFestivosResponse;
//	}
//	
	
	@Override
	public ActSolicitudDtoResponse actSolicitud(ActSolicitudDtoRequest actSolicitudDtoRequest) {
		Optional<UecCatalogoAutorizadores2021> autorizadores = autorizadores2021Repository.findById(actSolicitudDtoRequest.getSoeId());
	    Optional<AutoTasas> autoTasas =  autoTasasRepository.findById(actSolicitudDtoRequest.getTasaId());
	    ActSolicitudDtoResponse actSolicitudDtoResponse = new ActSolicitudDtoResponse();	    
		    if(autorizadores.isPresent() && autoTasas.isPresent()) {
			    	autoTasas.get().setEstatus(actSolicitudDtoRequest.getNuevoEstado());	    	
			    	autoTasas.get().setFechaAutori(new Date());
			    	autoTasas.get().setInicAutori(autorizadores.get().getInic());
			    	autoTasas.get().setSoeidAutori(autorizadores.get().getSoeid());
			    	autoTasas.get().setObservaWeb(actSolicitudDtoRequest.getCausaRechazo());
			    	autoTasasRepository.save(autoTasas.get());	
			    	actSolicitudDtoResponse.setStatus(true);
			    	actSolicitudDtoResponse.setMnsj("Gracias por su contribución");
		    	return actSolicitudDtoResponse;

		    }else {
		    	actSolicitudDtoResponse.setStatus(false);
		    	actSolicitudDtoResponse.setMnsj("No se han encontrado conisidencias con los datos proporcionados");
		    	return actSolicitudDtoResponse;
		    }    
	}

	@Override
	public List<DiasFestivosResponseDTO> ObtenerDiasFeriados(DiasFestivosBEDTO request)
			throws GenericException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
