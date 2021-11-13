package com.citi.euces.sitiouec.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.euces.sitiouec.dto.ActualizarSoeidAtendidoDTO;
import com.citi.euces.sitiouec.dto.AsignacionesDTO;
import com.citi.euces.sitiouec.dto.AsignacionesInputDTO;
import com.citi.euces.sitiouec.dto.AsignacionesRevolverDTO;
import com.citi.euces.sitiouec.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.dto.FechasInputDTO;
import com.citi.euces.sitiouec.dto.HistoricoAsignacionesDTO;
import com.citi.euces.sitiouec.dto.PetCatEjecutivoSucursalCampanaDTO;
import com.citi.euces.sitiouec.entities.Asignaciones;
import com.citi.euces.sitiouec.entities.AutoTasas;
import com.citi.euces.sitiouec.entities.HistoricoAsignaciones;
import com.citi.euces.sitiouec.repositories.AsignacionesRepository;
import com.citi.euces.sitiouec.repositories.AutoTasasRepository;
import com.citi.euces.sitiouec.repositories.HistoricoAsignacionesRepository;
import com.citi.euces.sitiouec.repositories.PetCatEjecSucuCampanaRepository;
import com.citi.euces.sitiouec.repositories.TasasRepository;
import com.citi.euces.sitiouec.services.api.PetCatEjecutivoSucursalCampanaService;

@Service
public class PetCatEjecutivoSucursalCampanaServiceImpl implements PetCatEjecutivoSucursalCampanaService {
	
	
	private static final Logger LOGGER = LogManager.getLogger(PetCatEjecutivoSucursalCampanaServiceImpl.class);
	
	@Autowired
	private PetCatEjecSucuCampanaRepository petCatEjecSucuCampanaRepository;
	
	@Autowired
	private AutoTasasRepository autoTasasRepository;
	
	@Autowired
	private TasasRepository tasasService;
	
	@Autowired
	private HistoricoAsignacionesRepository historicoAsignRepository;
	
	@Autowired
	private AsignacionesRepository asignacionesRepository;
	
	@Override
	public List<PetCatEjecutivoSucursalCampanaDTO> getEjecutivosSucursal(List<String> puestos) {
		
		List<PetCatEjecutivoSucursalCampanaDTO> lsEjecutivos = new ArrayList<>();
		
		lsEjecutivos = petCatEjecSucuCampanaRepository.getEjecutivosSucursal(puestos);
		
		return lsEjecutivos;
	}


	@Override
	public List<AsignacionesDTO> getAsignacionesEjecutivos(List<PetCatEjecutivoSucursalCampanaDTO> lsEjecutivosUEC) {
		// TODO Auto-generated method stub
		
		List<AsignacionesDTO> lsAsginaciones = new ArrayList<>();
		
		List<String> lsEjecutivos = new ArrayList<>();
		
		for (PetCatEjecutivoSucursalCampanaDTO ejec : lsEjecutivosUEC) {
			lsEjecutivos.add(ejec.getSoied());
		}
		
		lsAsginaciones = petCatEjecSucuCampanaRepository.getAsignacionesEjecutivos(lsEjecutivos);
		
		return lsAsginaciones;
	}


	/**
	 * Servicio que actualizara el campo SOEID_ASIG en la tabla de UEC_TB_AUTOTASAS
	 * @throws ParseException 
	 */
	@Override
	public List<AutoTasasDTO> getAsignacionAutoTasas(List<AsignacionesInputDTO> lsEjecutivos) throws ParseException {
		// TODO Auto-generated method stub
		
		List<AutoTasasDTO> lsAutoTasasAsignadas = new ArrayList<>();
		AutoTasasDTO       ejecutivosAsignados  = null;
		
		/**
		 * Traer todas las asignaciones pendientes de la tabla de UEC_TB_AUTOTASAS
		 */
		     
		List<AutoTasasDTO> lsAutoTasasPendiente = new ArrayList<>();
		List<HistoricoAsignacionesDTO> lsAsignaciones = new ArrayList<>();
		HistoricoAsignacionesDTO historicoAsignados = new HistoricoAsignacionesDTO();
		
		lsAutoTasasPendiente  = tasasService.getAutoTasasSoeidAsignacionPendiente();
		
		LOGGER.info("Size () de la lista de No Asignados " + " "  +  lsAutoTasasPendiente.size());
		
		/**
		 * Se recorre toda la lista de auto tasas pendientes de asignar para recuperar la informacion
		 * y depues actualizar el SOEID_ASIG
		 */
		
		
		int i=0;
		String soeidAsig="";
		String puestoSoeid="";
		for (AutoTasasDTO autoTasasDTO : lsAutoTasasPendiente) {
			
			LOGGER.info("Entra al ciclo  AutoTasasDTO -  autoTasasDTO");
			
			Optional<AutoTasas> solicitud = Optional.ofNullable(new AutoTasas());
			AutoTasas actSolicitud = new AutoTasas();
		
			/**
			 * Obten un numero random para buscar en esa posicion la asignacion a realizar
			 */
		
			solicitud = autoTasasRepository.findById(autoTasasDTO.getIdTasaAuto());
			
			LOGGER.info("ELEMENTO CANDIDATO A ACTUALIZAR SOEID_ASIG " + " " + solicitud.toString());
				
			     if(lsEjecutivos.size()>i) {
			    	 
			    	 soeidAsig = lsEjecutivos.get(i).getSoeid();
			    	 puestoSoeid = lsEjecutivos.get(i).getSoeid();
			    	 solicitud.get().setSoeidAsig(soeidAsig);	 
			    	 i++;
			     }else {
			    	 i=0;
			    	 soeidAsig = lsEjecutivos.get(i).getSoeid();
			    	 puestoSoeid = lsEjecutivos.get(i).getSoeid();
			    	 solicitud.get().setSoeidAsig(soeidAsig);
			    	 i=1;
			     }
			    
				actSolicitud = solicitud.get();
								
				LOGGER.info("OBJETO COMPLETO ACTUALIZAR " + " " + actSolicitud.toString());
				try {
					 tasasService.asignarPendientesEjecutivo(actSolicitud);
					 LOGGER.info("getAsignacionAutoTasas Actualizada con Exito " + " " +"getAsignacionAutoTasas");
					 LOGGER.info("autoTasasDTO Actualizado" + " " + autoTasasDTO.toString());
					 ejecutivosAsignados  = new AutoTasasDTO();
					 autoTasasDTO.setSoeidAsig(soeidAsig);
					 ejecutivosAsignados = autoTasasDTO;
					 lsAutoTasasAsignadas.add(ejecutivosAsignados);
					 
					 /**
					  * Save en la tabla de Historico de Asignaciones
					  * 
					  * Timestamp fechaDesconexion = new Timestamp(System.currentTimeMillis());
					  */
					 Timestamp fechaSolic = new Timestamp(System.currentTimeMillis());
					 historicoAsignados = new HistoricoAsignacionesDTO();
					 historicoAsignados.setIdTasaAuto(ejecutivosAsignados.getIdTasaAuto());
					 historicoAsignados.setSoeid(puestoSoeid.equals("ejecutivo UEC")?soeidAsig:"");
					 historicoAsignados.setSoeidAtendido(!puestoSoeid.equals("ejecutivo UEC")?soeidAsig:"");
					 historicoAsignados.setFechaSoli(fechaSolic);
					 historicoAsignados.setFechaDesc(null);
					 historicoAsignados.setEstatus(Long.valueOf("1"));
					 lsAsignaciones.add(historicoAsignados);
					 
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
				}					
		}
		
		/**
		 * Terminando el ciclo de asignados en la tabla de autotasas hace el Insert
		 * en la tabla de Historico de Asignaciones.
		 * //insertarHistoricoAsignaciones(lsAsignaciones);
		 */
		
		
		
		LOGGER.info("lsAutoTasasAsignadas" + " " + lsAutoTasasAsignadas.toString());
		
		return lsAutoTasasAsignadas;
	}


	@Override
	public int insertarHistoricoAsignaciones(List<HistoricoAsignacionesDTO> lsAsignaciones) throws ParseException {
		// TODO Auto-generated method stub
		
		HistoricoAsignaciones historico = new HistoricoAsignaciones();
		int res=0;
		
		for (HistoricoAsignacionesDTO historicoAsignacionesDTO : lsAsignaciones) {
			historico = new HistoricoAsignaciones();
			historico.setIdTasaAuto(historicoAsignacionesDTO.getIdTasaAuto());
			historico.setSoeid(historicoAsignacionesDTO.getSoeid());
			historico.setSoeidAtendido(historicoAsignacionesDTO.getSoeidAtendido());
			if(historicoAsignacionesDTO.getFechaSoliS()==null) {
				historico.setFechaSoli(historicoAsignacionesDTO.getFechaSoli());
			}else {
				historico.setFechaSoli(Timestamp.valueOf(historicoAsignacionesDTO.getFechaSoliS().concat(" ").concat("01:02:03.123456789")));	
			}			
			if(historicoAsignacionesDTO.getFechaDescS()==null) {
				historico.setFechaDesc(historicoAsignacionesDTO.getFechaDesc());
			}else {
				historico.setFechaDesc(Timestamp.valueOf(historicoAsignacionesDTO.getFechaDescS().concat(" ").concat("01:02:03.123456789")));	
			}			
			historico.setEstatus(historicoAsignacionesDTO.getEstatus());
			
			try {
				historicoAsignRepository.save(historico);
				LOGGER.info("REGISTRO ALMACENADO CORRECTAMENTE"+ " " + historico.toString() );
				res=1;
			} catch (Exception e) {
				LOGGER.error("Error:: insertarHistoricoAsignaciones - " + " " + e.getMessage());
				LOGGER.error("Error:: insertarHistoricoAsignaciones - " + " " + e.getCause());
				LOGGER.error("Error:: insertarHistoricoAsignaciones - " + " " + e.getStackTrace());
			}			
		}
		
		return res;
	}


	@Override
	public int actualizarAsignacionesInactivas(List<String> lsAsignacionesInactivas) throws ParseException {
		// TODO Auto-generated method stub
		
		AsignacionesDTO asignaciones = new AsignacionesDTO();
		HistoricoAsignaciones historico = null;
		Asignaciones  asig = new Asignaciones();
		int res=0;
		for (String inactivas : lsAsignacionesInactivas) {
			LOGGER.info("SOEID INACTIVO inactivo" + " " + inactivas.toString());
			asignaciones = new AsignacionesDTO();
			asignaciones = tasasService.getAsignacionesBySoeid(inactivas);
			LOGGER.info("SE ENCONTRO EL SIGUIENTE SOEID A ACTUALIZAR" + " " + asignaciones.toString());
			asig.setId(asignaciones.getId());
			asig.setNombre(asignaciones.getNombre());
			asig.setOnline(Long.valueOf(3));
			asig.setSoeid(asignaciones.getSoeid());	
			
			/**
			 * Inserto en la tabla de Historico de Asignaciones
			 */
			Timestamp fechaDesconexion = new Timestamp(System.currentTimeMillis());
			
			historico = new HistoricoAsignaciones();
			historico.setIdTasaAuto(Long.valueOf("0"));
			historico.setSoeid(asignaciones.getSoeid());
			historico.setSoeidAtendido("");
			historico.setFechaSoli(null);
			historico.setFechaDesc(fechaDesconexion);
			historico.setEstatus(Long.valueOf(3));
			
			try {
				asignacionesRepository.save(asig);
				LOGGER.info("ELEMENTO ASIGNACIONES ACTUALIZADO" + " " + asig.toString());
				historicoAsignRepository.save(historico);
				LOGGER.info("ELEMENTO HISTORICO ACTUALIZADO" + " " + historico.toString());
				res=1;
			} catch (Exception e) {
				LOGGER.error("Error:: actualizarAsignacionesInactivas - " + " " + e.getMessage());
				LOGGER.error("Error:: actualizarAsignacionesInactivas - " + " " + e.getCause());
				LOGGER.error("Error:: actualizarAsignacionesInactivas - " + " " + e.getStackTrace());				
			}			
		}
		return res;
	}


	@Override
	public int actualizarSoeidAsignadosSupervisor(List<ActualizarSoeidAtendidoDTO> lsSoeidAtendido) throws ParseException {
		// TODO Auto-generated method stub
		
		int res=0;
		
		List<HistoricoAsignacionesDTO> lsHistoricoAsignaciones = petCatEjecSucuCampanaRepository.getHistoricoAsignaciones(lsSoeidAtendido);
		
		HistoricoAsignaciones historico = new HistoricoAsignaciones();
		
		for (HistoricoAsignacionesDTO historicoAsignacionesDTO : lsHistoricoAsignaciones) {
			historico = new HistoricoAsignaciones();
			historico.setIdTasaAuto(historicoAsignacionesDTO.getIdTasaAuto());
			historico.setSoeid(historicoAsignacionesDTO.getSoeid());
			historico.setSoeidAtendido(historicoAsignacionesDTO.getSoeidAtendido());
			historico.setFechaSoli(historicoAsignacionesDTO.getFechaSoli());
			historico.setFechaDesc(historicoAsignacionesDTO.getFechaDesc());
			historico.setEstatus(historicoAsignacionesDTO.getEstatus());
			
			try {
				historicoAsignRepository.save(historico);
				LOGGER.info("ELEMENTO HISTORICO ACTUALIZADO SUPERVISOR - EJECUTIVO" + " " + historico.toString());
				res=1;
			} catch (Exception e) {
				LOGGER.error("Error:: actualizarSoeidAsignadosSupervisor - " + " " + e.getMessage());
				LOGGER.error("Error:: actualizarSoeidAsignadosSupervisor - " + " " + e.getCause());
				LOGGER.error("Error:: actualizarSoeidAsignadosSupervisor - " + " " + e.getStackTrace());	
			}	
		}
		
		return res;
	}


	@Override
	public List<HistoricoAsignacionesDTO> getHistoricoAsignacionesExcel(FechasInputDTO fechas) {
		// TODO Auto-generated method stub
		
		List<HistoricoAsignacionesDTO> lsHistorico = petCatEjecSucuCampanaRepository.getHistoricoAsignacionesExcel(fechas);
		
		LOGGER.info("TAMAÑO DE LA LISTA getHistoricoAsignacionesExcel" + " " + lsHistorico.size());
		
		return lsHistorico;
	}


	@Override
	public int actualizarSoeidAsignaciones(Long online, String soeid,String nombre) {
		
		int res = petCatEjecSucuCampanaRepository.actualizarSoeidAsignaciones(online, soeid,nombre);
		
		return res;
	}


	@Override
	public AsignacionesDTO getEjecutivosUECAsignados(String puestos) {
		
		AsignacionesDTO asignaciones = petCatEjecSucuCampanaRepository.getEjecutivosUECAsignados(puestos);
		
		return asignaciones;
	}


	@Override
	public String calcularSoeidAsignadoNoAplica() {
		
		String soeidAsignado="";
		
		List<AsignacionesRevolverDTO> listaAsignaciones = petCatEjecSucuCampanaRepository.obtenerAsignaciones();
		
		int pos=0;
		
		/**
		 * Obtenemos el ultimo soeid asignado
		 * 
		 */
		
		String soeid_asig_ant  = petCatEjecSucuCampanaRepository.obtenerUltSoeidAsignadoNoAplica();
		
				/**
		 * Obtener la posicion en el arreglo del elemento 
		 * x => x.SOEID == soeid_asig_ant
		 */
	
		
		for (int i = 0; i < listaAsignaciones.size(); i++) {
			
			LOGGER.info("ELEMENTOS DE LA LISTA - listaAsignaciones " + " " + listaAsignaciones.get(i).getSoeid());
			LOGGER.info("ELEMENTOS DE LA LISTA - listaAsignaciones " + " " + listaAsignaciones.get(i).getOnline());			
			if(listaAsignaciones.get(i).getSoeid().equals(soeid_asig_ant)) {
				LOGGER.info("listaAsignaciones.get(i).getSoeid().equals(soeid_asig_ant) - listaAsignaciones " + " " + listaAsignaciones.get(i).getOnline());
				pos = i;
				break;
			}
		}	
		
					
	
		long sum = listaAsignaciones.stream().mapToLong(AsignacionesRevolverDTO::getOnline).sum();
				
		if(sum==0) {
			return soeidAsignado;
		}
		

        for (int i = pos; i < listaAsignaciones.size() - 1; i++)
        {
        	LOGGER.info("ENTRO AL PRIMER FOR");
            if (listaAsignaciones.get(i + 1) != null)
            {
                if (listaAsignaciones.get(i + 1).getOnline() == 1) { 
                	soeidAsignado = listaAsignaciones.get(i + 1).getSoeid(); 
                	i = (int) listaAsignaciones.stream().count(); 
                }
            }
        }
        
        if (soeidAsignado.equals("") || soeidAsignado==null)
        {
        	LOGGER.info("ENTRO AL SEGUNDO IF soeidAsignado");
            for (int i = -1; i < (int) listaAsignaciones.stream().count(); i++)
            {
                if (listaAsignaciones.get(i + 1)!= null)
                {
                    if (listaAsignaciones.get(i + 1).getOnline() == 1) 
                    { 
                    	soeidAsignado = listaAsignaciones.get(i + 1).getSoeid(); 
                    	i = (int) listaAsignaciones.stream().count(); 
                    }
                }
            }
        }        
		
		
		return soeidAsignado;
	}
	
	
	
	
	
	
	

}
