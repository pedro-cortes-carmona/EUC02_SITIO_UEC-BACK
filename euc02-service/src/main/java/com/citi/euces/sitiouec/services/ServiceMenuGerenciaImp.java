package com.citi.euces.sitiouec.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.citi.euces.sitiouec.entities.AcomuladoGerencia;
import com.citi.euces.sitiouec.entities.AutoTasaAcomuladoCampGerencia;
import com.citi.euces.sitiouec.entities.AutoTasaGerencia;
import com.citi.euces.sitiouec.entities.AutoTasaSucursalesGerencia;
import com.citi.euces.sitiouec.entities.AutoTasasOnLineGerencia;
import com.citi.euces.sitiouec.entities.CampanaGerencia;
import com.citi.euces.sitiouec.entities.EjecutivosNoLocalizablesGerencia;
import com.citi.euces.sitiouec.entities.EjecutivosPriorityGerencia;
import com.citi.euces.sitiouec.entities.EjecutivosPriorityVentaGerencia;
import com.citi.euces.sitiouec.entities.ObtenerListaCampanasGerencia;
import com.citi.euces.sitiouec.entities.SucursalAgrupadasGerencia;
import com.citi.euces.sitiouec.entities.SucursalGerencia;
import com.citi.euces.sitiouec.entities.TotalEjecutivosGerencia;
import com.citi.euces.sitiouec.infra.dto.AutoTasaMontoVolumenGerencias;
import com.citi.euces.sitiouec.infra.dto.Data_ChartBEResponSeDTO;
import com.citi.euces.sitiouec.infra.dto.DatosAgrupadosResponseDTO;
import com.citi.euces.sitiouec.infra.dto.RegAutoTasasBEResponseDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.dto.AutoTasaAcomuladoCampGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.AutoTasaAcomuladoCampGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.AutoTasaGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.AutoTasaMontoVolumenGerenciaRepoResponseBEDTO;
import com.citi.euces.sitiouec.dto.AutoTasaMontoVolumenGerenciaRepoResponseDTO;
import com.citi.euces.sitiouec.dto.AutoTasasOnLineGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.CampGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.CampanaDiasGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.CampanaGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.CatOfertaResposeDTO;
import com.citi.euces.sitiouec.dto.DibujarChartAgrupadoResponseDTO;
import com.citi.euces.sitiouec.dto.DibujarChartResponseBEDTO;
import com.citi.euces.sitiouec.dto.DibujarChartResponseDTO;
import com.citi.euces.sitiouec.dto.EjecutivosPriorityGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.EjecutivosPriorityGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.EjecutivosPrioritySinVentaGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.EjecutivosPriorityVentaGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.GetNumRegTbAcumuladoTasasGerenciaResponseBEDTO;
import com.citi.euces.sitiouec.dto.ObtenerTotalEjecutivosDivisionResponseDTO;
import com.citi.euces.sitiouec.dto.ObtenerTotalEjecutivosRegionResponseDTO;
import com.citi.euces.sitiouec.dto.ObtenerlistaEjecutivosNoLocalizablesResponseDTO;
import com.citi.euces.sitiouec.dto.ReportDataSource;
import com.citi.euces.sitiouec.dto.ReporteDivisionesBEResponseDTO;
import com.citi.euces.sitiouec.dto.SucursalGerenciaRegionResponseDTO;
import com.citi.euces.sitiouec.dto.SucursalGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.SucursalGerenciaResponseSumaDTO;
import com.citi.euces.sitiouec.dto.SucursalGerenciaVentasResponseDTO;
import com.citi.euces.sitiouec.dto.SucursalesAgrupadaGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.SucursalesAgrupadaGerenciaResponseDTO;
import com.citi.euces.sitiouec.repositories.AcomuladoGerenciaRepo;
import com.citi.euces.sitiouec.repositories.AcumuladoGerenciaRepo;
import com.citi.euces.sitiouec.repositories.AutoTasaAcomuladoCampGerenciaRepo;
import com.citi.euces.sitiouec.repositories.AutoTasaMontoVolumenGerenciaRepository;
import com.citi.euces.sitiouec.repositories.AutoTasasOnLineGerenciaRepo;
import com.citi.euces.sitiouec.repositories.CampanaGerenciaRepo;
import com.citi.euces.sitiouec.repositories.EjecutivosNoLocalizablesGerenciaRepo;
import com.citi.euces.sitiouec.repositories.EjecutivosPriorityGerenciaRepo;
import com.citi.euces.sitiouec.repositories.EjecutivosPriorityVentaGerenciaRepo;
import com.citi.euces.sitiouec.repositories.ImprimirReporteOnLineRepo;
import com.citi.euces.sitiouec.repositories.ObtenerListaCampanasGerenciaRepo;
import com.citi.euces.sitiouec.repositories.SucursalGerenciaAgrupadasRepo;
import com.citi.euces.sitiouec.repositories.SucursalGerenciaRepo;
import com.citi.euces.sitiouec.repositories.TasaGerenciaRepo;
import com.citi.euces.sitiouec.repositories.TotalEjecutivosGerenciaRepo;
import com.citi.euces.sitiouec.services.api.ServiceMenuGerencia;


@Service 
public class ServiceMenuGerenciaImp  implements ServiceMenuGerencia {
	private static final Logger LOGGER = LogManager.getLogger(ServiceMenuGerenciaImp.class);
	List<SucursalGerencia> listSucursal = null;
	List<SucursalGerencia> listSucursalA = null;
	List<AutoTasaGerencia> listAutoTasa = null;
	List<AutoTasaSucursalesGerencia> listAutoTasaSucursal = null;
	List<SucursalAgrupadasGerencia> listAutoTasaSucursalAgrupadas = null;
	List<TotalEjecutivosGerencia> listEjecutivosGerencia = null;
	List<AutoTasasOnLineGerencia> listAutoTasaOnLine = null;
	List<AutoTasaAcomuladoCampGerencia> listAutoTasaAcomulado = null;
	List<EjecutivosPriorityGerencia> listEjecutivosPriorityGerencia = null;
	List<EjecutivosPriorityVentaGerencia> listEjecutivosPriorityVentaGerencia = null;
	List<ObtenerListaCampanasGerencia> listCampanasGerencia = null;
	List<CampanaGerencia> listCampanaGerenciaFecha = null;
	List<AcomuladoGerencia> listAcomuladoGerencia = null;
	List<EjecutivosNoLocalizablesGerencia> ejecutivosNoLocalizablesGerencia = null;
	//List<Double> CantEjec ;
	//List<Double> CantSuc ;
	//List<Double> CantEjecV ;
	//List<Double> CantSucV ;
	List<AutoTasaMontoVolumenGerencias> listMontVent2 = null;
	String Agrupacion;
//	double CantSuc_v = 0;
	//double CantEjec_v = 0;
	//double Per_Capita = 0;
	@Autowired
	SucursalGerenciaRepo sucursalGerenciaRepo;
	@Autowired
	ImprimirReporteOnLineRepo imprimirReporteOnLineRepo;
	@Autowired
	SucursalGerenciaAgrupadasRepo sucursalGerenciaAgrupadasRepo;
	@Autowired
	AutoTasasOnLineGerenciaRepo autoTasasOnLineGerenciaRepo;
	@Autowired
	AutoTasaAcomuladoCampGerenciaRepo autoTasaAcomuladoCampGerenciaRepo;
	@Autowired
	EjecutivosPriorityGerenciaRepo ejecutivosPriorityGerenciaRepo;
	@Autowired
	EjecutivosPriorityVentaGerenciaRepo ejecutivosPriorityVentaGerenciaRepo;  
	@Autowired
	AcumuladoGerenciaRepo acumuladoGerenciaRepo;
	@Autowired
	TasaGerenciaRepo tasaGerenciaRepo; 
	@Autowired
	TotalEjecutivosGerenciaRepo totalEjecutivosGerenciaRepo;
	@Autowired
	ObtenerListaCampanasGerenciaRepo obtenerListaCampanasGerenciaRepo; 
	@Autowired
	CampanaGerenciaRepo campanaGerenciaRepo;
	@Autowired
	AcomuladoGerenciaRepo acomuladoGerenciaRepo;  
	@Autowired
	EjecutivosNoLocalizablesGerenciaRepo ejecutivosNoLocalizablesGerenciaRepo ; 
	@Autowired
	AutoTasaMontoVolumenGerenciaRepository autoTasaMontoVolumenGerenciaRepository;

	@Override
	public List<ReportDataSource> ObtenerVistaCampanaporDivision(AutoTasaGerenciaBEDTO request)throws GenericException, IOException {
		List<ReportDataSource> reportDataSource = new ArrayList<ReportDataSource>();
		
		String dataCampana = "";
		List<CatOfertaResposeDTO> camp =   imprimirReporteOnLineRepo.ObtenerCampana();

		
		
		for(CatOfertaResposeDTO campa : camp) {
			dataCampana+= "'"+campa.getOFERTA_ID()+"',";	
		}
		dataCampana = dataCampana.substring(0, dataCampana.length()-1);
		request.setCampana(dataCampana);
		List<CatOfertaResposeDTO> camptasa =   imprimirReporteOnLineRepo.ObtenerCampanaUno(request.getCampana(),request.getFecha());
		
		List<SucursalGerenciaResponseDTO> autoTasaDivisiones = ObtenerVistaCampanaporDivisionObtener(request);	
		request.setCampana(dataCampana);
		List<SucursalGerenciaResponseDTO> autoTasaRegiones = ObtenerVistaCampanaporDirRegional(request);
		request.setCampana(dataCampana);
		List<SucursalGerenciaResponseDTO> autoTasaSucursales = ObtenerVistaCampanaporSucursales(request);
//		System.out.println("ENTRADA suc "+ autoTasaSucursales.size());


		try{
		    List<SucursalGerenciaResponseDTO> ListaVistaDivisiones;
			List<SucursalGerenciaResponseDTO> ListaVistaRegiones ;
			List<SucursalGerenciaResponseDTO> ListaVistaMercado ;
		    List<SucursalGerenciaResponseDTO> ListaVistaSucursales ;
			if(!request.isIs_ejec_priority()) {
				listSucursal = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivision(2);
			}else {
				listSucursal = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivision(1);
			}
			/////////////////////////////////
			String dataCampana2 = "";
			for(CatOfertaResposeDTO campa : camptasa) {
				dataCampana2+= "'"+campa.getOFERTA_ID()+"',";	
			}
			dataCampana2 = dataCampana2.substring(0, dataCampana2.length()-1);
			request.setCampana(dataCampana2);
			request.setIs_ejec_priority(true);
			List<SucursalGerenciaResponseDTO> ListaVistaDivisionesCam1 = ObtenerVistaCampanaporDivisionObtener(request);
			List<SucursalGerenciaResponseDTO> ListaVistaRegionesCam1 = ObtenerVistaCampanaporDirRegional(request);
		//	List<SucursalGerenciaResponseDTO> ListaVistaSucursalesCam1 = ObtenerVistaCampanaporSucursales(request);
			List<AutoTasaSucursalesGerencia> sac = imprimirReporteOnLineRepo.ObtenerVistaCampanaporSucursales(dataCampana2, request.getFecha(), true, false, false);

			
			for(SucursalGerenciaResponseDTO item : autoTasaDivisiones ) {	
				if(ListaVistaDivisionesCam1.stream().filter(x-> x.getDIVISION().equals(item.getDIVISION())).count() >0 ) {		
					item.setVENTAS(0); 
					item.setMONTO(0);
					item.setPer_Capita(0);
					item.setMONTOVENTAS(0);
				    item.setCantSucSinVentas(Double.parseDouble(listSucursal.stream()
							.filter(x-> x.getDIVISION_NOMBRE().equals(item.getDIVISION()))
							.map(x->x.getCantsuc())
							.findFirst().get()));	
	
				}
				List<SucursalGerenciaVentasResponseDTO> nuevo = new ArrayList<SucursalGerenciaVentasResponseDTO>() ;
				for(SucursalGerenciaResponseDTO item12 : ListaVistaDivisionesCam1 ) {
					if(item.getDIVISION().equals(item12.getDIVISION())) {
						nuevo.add(new SucursalGerenciaVentasResponseDTO(item12.getCantejec(), item12.getCantsuc()));
						
					}else {
						nuevo.add(new SucursalGerenciaVentasResponseDTO(0, 0));
					}
					
				}
				item.setVentaImporte2(nuevo);

			}
			System.out.println("acabo 1");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
				for(SucursalGerenciaResponseDTO item2 : autoTasaRegiones){
				List<SucursalGerenciaVentasResponseDTO> nuevo = new ArrayList<SucursalGerenciaVentasResponseDTO>() ;
				System.out.println("entro sucr 2 "+item2.getDISTRITO());
                for(SucursalGerenciaResponseDTO item13 : ListaVistaRegionesCam1 ) {
                	System.out.println("entro s 2 "+item2.getDISTRITO()+ " :: "+item13.getDISTRITO());
					if(item2.getDISTRITO().equals(item13.getDISTRITO())) {
						
						nuevo.add(new SucursalGerenciaVentasResponseDTO(item13.getCantejec(), item13.getCantsuc()));
						
					}else {
						nuevo .add(new SucursalGerenciaVentasResponseDTO(0, 0));
					}	
				}
				item2.setVentaImporte2(nuevo);
			}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			System.out.println("sac " + sac.size()+ "autoTasaSucursales"+ autoTasaSucursales.size());
			
				for(SucursalGerenciaResponseDTO item3 : autoTasaSucursales){
		  		List<SucursalGerenciaVentasResponseDTO> nuevo = new ArrayList<SucursalGerenciaVentasResponseDTO>() ;
				for(AutoTasaSucursalesGerencia item14 : sac) {	
					if(item14.getSUC_SOLIC()==item3.getSuc()) {	
						nuevo.add(new SucursalGerenciaVentasResponseDTO(item14.getVENTAS(), item14.getMONTO()));
					}else {
						nuevo .add(new SucursalGerenciaVentasResponseDTO(0, 0));
					}
				}
				item3.setVentaImporte2(nuevo);
			}		
			System.out.println("acabo 3");
			///////////////////////////////
			ListaVistaDivisiones =autoTasaDivisiones;
			ListaVistaRegiones =autoTasaRegiones;
			ListaVistaMercado = ListaVistaDivisiones;
			ListaVistaSucursales = autoTasaSucursales;

		    System.out.println("1entro fin " + autoTasaRegiones.size()+""+ListaVistaRegiones.size());
			
		/*	reportDataSource.add(new ReportDataSource(ListaVistaDivisiones,
					ListaVistaRegiones, 
					ListaVistaMercado, 
					ListaVistaSucursales));*/
		    reportDataSource.add(new ReportDataSource(ListaVistaDivisiones,
		    		ListaVistaRegiones, 
		    		ListaVistaMercado, 
		    		ListaVistaSucursales,
		    		null));
		    
		//	LOGGER.debug("fin total"+ListaVistaSucursales.size());
			System.out.println("ListaVistaSucursalesCam1 " + ListaVistaRegiones.size()+ "autoTasaSucursales"+ autoTasaRegiones.size());

		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}

		return reportDataSource;
	}



	public List<SucursalGerenciaResponseDTO> ObtenerVistaCampanaporDirRegional(AutoTasaGerenciaBEDTO request)
			throws GenericException, IOException {
		List<SucursalGerenciaResponseDTO> autoTasaGerenciaResponseDTO = new ArrayList<SucursalGerenciaResponseDTO>();

		
		
		try{
			double CantEjec =0;
			double CantSuc =0;
		//	double CantSucSinVentas =0;
		//	double CantSucConVentas =0;
			
				LOGGER.debug("entro" );
				 System.out.println("cam : :"+request.getCampana());
				if(!request.isIs_ejec_priority()) {
					listSucursal = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorRegion(2);//falso
				}else {
					listSucursal = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorRegion(1);
				}

				if(request.getFecha_fin().isEmpty()){
					listAutoTasa = imprimirReporteOnLineRepo.ObtenerVistaCampanaporDirRegional(request.getCampana(),request.getFecha(),request.isIs_ejec_priority(),request.isIs_Premio(),request.isEnablePM());

				}else {
					listAutoTasa = imprimirReporteOnLineRepo.ObtenerVistaCampanaporDirRegionalAplicada(request.getCampana(),request.getFecha(),request.getFecha_fin(),request.isIs_ejec_priority(),request.isIs_Premio(),request.isEnablePM());

				}
				
				
				if(request.isEnablePM()) {
					if(request.getFecha_fin().isEmpty()){
						listSucursalA = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorRegionConVentas2(request.getFecha(), request.getCampana());//falso
					}else {
						listSucursalA = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorRegionConVentas2Aplicada(request.getFecha(), request.getFecha_fin() ,request.getCampana());
					}
				}else {
					if(request.getFecha_fin().isEmpty()){
						listSucursalA = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorRegionConVentas(request.getFecha(), request.getCampana());

					}else{
						listSucursalA = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorRegionConVentasAplicada(request.getFecha() , request.getFecha_fin(), request.getCampana());

					}

				}
				LOGGER.debug("tamaño "+listAutoTasa.size()+" es "+listSucursal.size());
				 int rk = 1;
				for(AutoTasaGerencia aut : listAutoTasa) {	
					
				autoTasaGerenciaResponseDTO.add(new SucursalGerenciaResponseDTO(aut.getDIVISION(),
					aut.getDISTRITO(),
					aut.getVENTAS(), 
	        		aut.getMONTO(), 
	        		aut.getMONTOVENTAS(), 
	        		0, 
	        		0, 
	        		0, 
	        		0, 
	        		0, 
	        		rk));
				rk++;	
	            }
				
				for(SucursalGerenciaResponseDTO sa : autoTasaGerenciaResponseDTO) {
					for(SucursalGerencia suc : listSucursal) {	
						
						 if(sa.getDISTRITO().equals(suc.getDISTRITO_NOMBRE())) {
							 sa.setCantejec(Double.parseDouble(suc.getCantsuc()));
							 sa.setCantsuc(Double.parseDouble(suc.getCantsuc()));
							 sa.setPer_Capita(sa.getVENTAS()/sa.getCantejec());
							 
						 }
						}
				}
				
				for(SucursalGerenciaResponseDTO f : autoTasaGerenciaResponseDTO ) {
					for(SucursalGerencia suc : listSucursal) {	
						if(!f.getDISTRITO().equals(suc.getDISTRITO_NOMBRE())) {
							autoTasaGerenciaResponseDTO.add(new SucursalGerenciaResponseDTO(suc.getDIVISION_NOMBRE(),
									suc.getDISTRITO_NOMBRE(),
					        		0, 
					        		0, 
					        		0, 
					        		Double.parseDouble(suc.getCantsuc()), 
					        		Double.parseDouble(suc.getCantejec()), 
					        		0, 
					        		0, 
					        		0, 
					        		rk));
							rk++;
						}
					}											
				}
				for(SucursalGerenciaResponseDTO t : autoTasaGerenciaResponseDTO ) {
						
					if(listSucursalA.stream().filter(x-> x.getDISTRITO_NOMBRE().equals(t.getDISTRITO())).count() >0) {
						t.setCantSucSinVentas(t.getCantsuc() - Double.parseDouble(listSucursalA.stream().filter(x-> x.getDISTRITO_NOMBRE().equals(t.getDISTRITO())).map(x-> x.getCantsuc()).findFirst().get()));
						t.setCantSucConVentas(Double.parseDouble(listSucursalA.stream().filter(x-> x.getDISTRITO_NOMBRE().equals(t.getDISTRITO())).map(x-> x.getCantsuc()).findFirst().get()));
					}else {
						t.setCantSucSinVentas(t.getCantsuc());
					}
					
				}
				
				
				LOGGER.debug("tamaño 2 "+autoTasaGerenciaResponseDTO.size());
	
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		LOGGER.debug(listAutoTasa.size());
		return autoTasaGerenciaResponseDTO.stream().sorted(Comparator.comparingDouble(SucursalGerenciaResponseDTO ::getRK)).collect(Collectors.toList());
	}

 //--	
	@Override
	public List<SucursalGerenciaRegionResponseDTO> ObtenerVistaCampanaporGerMercado(AutoTasaGerenciaBEDTO request)throws GenericException, IOException {
		List<SucursalGerenciaRegionResponseDTO> sucursalGerenciaRegionResponseDTO = new ArrayList<SucursalGerenciaRegionResponseDTO>();
	/*	try{
			if (1 == 1) {
				LOGGER.debug("entro" );
				listSucursal = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivision(1);
				listAutoTasa = null ;
				//autoTasaGerenciaRepo.CampanaporDivision(request.getCampana(),request.getFecha());
				for(AutoTasaGerencia aut : listAutoTasa) {	
					CantEjec  = listSucursal.stream()
							  .filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
					          .mapToDouble(x -> x.getCantejec())
					          .boxed().collect(Collectors.toList());
					CantSuc  = listSucursal.stream()
							  .filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
					          .mapToDouble(x -> x.getCantsuc())
					          .boxed().collect(Collectors.toList());
		        listSucursalA = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivisionConVentas(request.getFecha(), request.getCampana());
		        	CantEjecV = listSucursal.stream()
								.filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
						        .mapToDouble(x -> x.getCantejec())
						        .boxed().collect(Collectors.toList());
	        		CantSucV  = listSucursal.stream()
								.filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
						        .mapToDouble(x -> x.getCantsuc())
						        .boxed().collect(Collectors.toList());
		        		
		        if(listSucursalA.size() == 0) {
		        	CantSuc_v = CantSuc.stream().findFirst().get().doubleValue();
			    }else {
			        CantEjec_v = CantEjecV.stream().findFirst().get().doubleValue();
			        CantSuc_v = CantSucV.stream().findFirst().get().doubleValue();
			    }
	        	if(CantEjec.stream().findFirst().get().doubleValue()> 0) {
	        		LOGGER.debug("?"+ Per_Capita );
	        		Per_Capita = (aut.getVENTAS()) / (CantEjec.stream().findFirst().get().doubleValue());
	        	}else {
	        		LOGGER.debug("?"+ Per_Capita );
	        		Per_Capita = 0;
	        		
	        	}
	        	sucursalGerenciaRegionResponseDTO.add(new SucursalGerenciaRegionResponseDTO(aut.getDIVISION(),
	        		aut.getDISTRITO(),	
	        		aut.getVENTAS(), 
	        		aut.getMONTO(), 
	        		aut.getMONTOVENTAS(), 
	        		CantSuc.stream().findFirst().get().doubleValue(), 
	        		CantEjec.stream().findFirst().get().doubleValue(), 
	        		CantSuc_v, 
	        		CantEjec_v, 
	        		Per_Capita, 
	        		(long) listAutoTasa.size()));
	            }
			}else {
				LOGGER.debug("no entro" );
				listSucursal = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivision(1);
				listAutoTasa = null;
				//autoTasaGerenciaRepo.CampanaporDivision2(request.getCampana(),request.getFecha());
				for(AutoTasaGerencia aut : listAutoTasa) {	
					CantEjec  = listSucursal.stream()
							  .filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
					          .mapToDouble(x -> x.getCantejec())
					          .boxed().collect(Collectors.toList());
					CantSuc  = listSucursal.stream()
							  .filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
					          .mapToDouble(x -> x.getCantsuc())
					          .boxed().collect(Collectors.toList());
		        listSucursalA = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivisionConVentas2(request.getFecha(), request.getCampana());
		        	CantEjecV = listSucursal.stream()
								.filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
						        .mapToDouble(x -> x.getCantejec())
						        .boxed().collect(Collectors.toList());
	        		CantSucV  = listSucursal.stream()
								.filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
						        .mapToDouble(x -> x.getCantsuc())
						        .boxed().collect(Collectors.toList());
		        		
		        if(listSucursalA.size() == 0) {
		        	CantSuc_v = CantSuc.stream().findFirst().get().doubleValue();
			    }else {
			        CantEjec_v = CantEjecV.stream().findFirst().get().doubleValue();
			        CantSuc_v = CantSucV.stream().findFirst().get().doubleValue();
			    }
	        	if(CantEjec.stream().findFirst().get().doubleValue()> 0) {
	        		Per_Capita = (aut.getVENTAS()) / (CantEjec.stream().findFirst().get().doubleValue());
	        		LOGGER.debug("?"+ Per_Capita );
	        	}else {
	        		LOGGER.debug("?"+ Per_Capita );
	        		Per_Capita = 0;
	        	}
	        	sucursalGerenciaRegionResponseDTO.add(new SucursalGerenciaRegionResponseDTO(aut.getDIVISION(),
	        		aut.getDISTRITO(),
	        		aut.getVENTAS(), 
	        		aut.getMONTO(), 
	        		aut.getMONTOVENTAS(), 
	        		CantSuc.stream().findFirst().get().doubleValue(), 
	        		CantEjec.stream().findFirst().get().doubleValue(), 
	        		CantSuc_v, 
	        		CantEjec_v, 
	        		Per_Capita, 
	        		(long) listAutoTasa.size()));
	            }
            }
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		LOGGER.debug(listAutoTasa.size());*/
		return sucursalGerenciaRegionResponseDTO.stream().sorted(Comparator.comparingDouble(SucursalGerenciaRegionResponseDTO ::getPer_Capita)).collect(Collectors.toList());
	}

	
	//---

	@Override
	public List<SucursalesAgrupadaGerenciaResponseDTO> ObtenerSucursalesAgrupadasEnCampanaPorDivision(
			SucursalesAgrupadaGerenciaBEDTO request) throws GenericException, IOException {
		List<SucursalesAgrupadaGerenciaResponseDTO> sucursalesAgrupadaGerenciaResponseDTO = new ArrayList<SucursalesAgrupadaGerenciaResponseDTO>();
		try{
			listSucursal = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivision(request.getIs_ejec_priority());
			for(SucursalGerencia suc : listSucursal) {	
				sucursalesAgrupadaGerenciaResponseDTO.add(new SucursalesAgrupadaGerenciaResponseDTO(suc.getDIVISION_NOMBRE(), Double.parseDouble(suc.getCantsuc()), Double.parseDouble(suc.getCantejec())));
			}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return sucursalesAgrupadaGerenciaResponseDTO;
	}


	//@Override
	public List<SucursalGerenciaResponseDTO> ObtenerVistaCampanaporSucursales(
			AutoTasaGerenciaBEDTO request) throws GenericException, IOException {
		List<SucursalGerenciaResponseDTO> campanaporSucursalesResponseDTO = new ArrayList<SucursalGerenciaResponseDTO>();
		try {
			 System.out.println("entro suc: ");
			
			 if(request.getFecha_fin().isEmpty()){
				 listAutoTasaSucursal = imprimirReporteOnLineRepo.ObtenerVistaCampanaporSucursales(request.getCampana(),request.getFecha(),request.isIs_ejec_priority(),request.isIs_Premio(),request.isEnablePM());

			 }else {
				 listAutoTasaSucursal = imprimirReporteOnLineRepo.ObtenerVistaCampanaporDirSucursalesAplicada(request.getCampana(),request.getFecha(),request.getFecha_fin(),request.isIs_ejec_priority(),request.isIs_Premio(),request.isEnablePM());

			 }
				//listAutoTasaSucursal = autoTasaSucursalGerenciaRepo.ObtenerVistaCampanapor(request.getCampana(), request.getFecha());
			
			 
			 if(request.getFecha_fin().isEmpty()){
				 if(!request.isIs_ejec_priority()) {
						System.out.println("entro suc:2 ");
						listAutoTasaSucursalAgrupadas = sucursalGerenciaAgrupadasRepo.ObtenerSucursalesAgrupadas(2); //flaso
					}else {
						System.out.println("entro suc:2 ");
						listAutoTasaSucursalAgrupadas = sucursalGerenciaAgrupadasRepo.ObtenerSucursalesAgrupadas(1);
					}
			 }else {
				 if(!request.isIs_ejec_priority()) {
						System.out.println("entro suc:3 ");
						listAutoTasaSucursalAgrupadas = sucursalGerenciaAgrupadasRepo.ObtenerSucursalesAgrupadasAplicada(2); //flaso
					}else {
						System.out.println("entro suc:3");
						listAutoTasaSucursalAgrupadas = sucursalGerenciaAgrupadasRepo.ObtenerSucursalesAgrupadasAplicada(1);
					}
			 }
			 
		
			int rk =1;
			//	listAutoTasaSucursal = autoTasaSucursalGerenciaRepo.ObtenerVistaCampanapor(request.getCampana(), request.getFecha());
				for(AutoTasaSucursalesGerencia aut : listAutoTasaSucursal) {
					campanaporSucursalesResponseDTO.add(new SucursalGerenciaResponseDTO(aut.getDIVISION(),
							aut.getDISTRITO(), 
							aut.getSUC_SOLIC(), 
							aut.getVENTAS(), 
							aut.getMONTO(), 
							aut.getMONTOVENTAS(), 
							0,
							aut.getEJECUTIVOS(),
							0,
							0,
							aut.getCAPITA(), 
							rk) );
					rk++;
					
				}
				for(SucursalGerenciaResponseDTO f : campanaporSucursalesResponseDTO ) {
					for(SucursalAgrupadasGerencia suc : listAutoTasaSucursalAgrupadas) {
						if(f.getSuc() != suc.getSIRH()) {
							campanaporSucursalesResponseDTO.add(new SucursalGerenciaResponseDTO(suc.getDIVISION(),
									suc.getDISTRITO(), 
									suc.getSIRH(), 
									0, 
									0, 
									0, 
									1,
									suc.getCantejec(),
									0,
									0,
									suc.getCantsuc(), 
									rk) );
							rk++;
						}
					}	
				}
				
				System.out.println("fin sucursales");
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return campanaporSucursalesResponseDTO;
	}


	@Override
	public List<AutoTasasOnLineGerenciaResponseDTO> ObtenerRegistrosAutoTasasOnLine() // quitar
			throws GenericException, IOException {
		 List<AutoTasasOnLineGerenciaResponseDTO> autoTasasOnLineGerenciaResponseDTO = new ArrayList<AutoTasasOnLineGerenciaResponseDTO>();
		try {
			SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy");
			listAutoTasaOnLine =autoTasasOnLineGerenciaRepo.ObtenerRegistrosAutoTasasOnLine();
			for(AutoTasasOnLineGerencia aut : listAutoTasaOnLine) {
				
				LOGGER.debug(objSDF2.format(aut.getFECHA_SOLIC())+
						objSDF2.format(aut.getFECHA_AUTORI())+ 
						objSDF2.format(aut.getFECHA_ESTATUS())+
						aut.getESTATUS()+ 
						aut.getSUC_SOLIC()+ 
						aut.getDIVISION()+ 
						aut.getPLAZO()+ 
						aut.getTASA_AUTORI()+ 
						aut.getTIPO_AUTORI()+
						aut.getSOEID_AUTORI()+
						aut.getSOEID_ASIG()+ 
						aut.getSOEID_OPE()+
						aut.getNUM_AUTORI_UEC() );
				autoTasasOnLineGerenciaResponseDTO.add(new AutoTasasOnLineGerenciaResponseDTO(aut.getID_TASAUTO(),
						objSDF2.format(aut.getFECHA_SOLIC()),
						objSDF2.format(aut.getFECHA_AUTORI()),
						objSDF2.format(aut.getFECHA_ESTATUS()),
						aut.getESTATUS(), 
						aut.getSUC_SOLIC(), 
						aut.getDIVISION(), 
						aut.getPLAZO(), 
						aut.getTASA_AUTORI(), 
						aut.getTIPO_AUTORI(), 
						aut.getSOEID_AUTORI(), 
						aut.getSOEID_ASIG(), 
						aut.getSOEID_OPE(), 
						aut.getNUM_AUTORI_UEC()));
			}
			
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return autoTasasOnLineGerenciaResponseDTO;
	}


	@Override
	public List<String> ObtenerListaTodasCampanas() throws GenericException, IOException {
		List<String> autoTasas = new ArrayList<String>();
		try {
			autoTasas =autoTasasOnLineGerenciaRepo.TodasCampanas();
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return autoTasas;
	}


	@Override
	public String LeerInsumosReporteDiario(AutoTasaGerenciaBEDTO request) throws GenericException, IOException {
		 String mensaje = null;
       
		try {
			int salida  = 0;
			salida = acumuladoGerenciaRepo.Guardar_Acumulado(request.getFecha());
			
			if(salida >0) {
				mensaje = "Guardo "+salida;
			}else {
				mensaje = "Error";
			}
	    	
	      }catch (Exception e) {
	    	  e.printStackTrace();
		}
		return mensaje;
	}


	@Override
	public String EliminarCargaAcumulado(AutoTasaAcomuladoCampGerenciaBEDTO request) throws GenericException, IOException {
		int salida = 0;
		   String mensaje = null ;
		try {
			salida = autoTasaAcomuladoCampGerenciaRepo.EliminarCargaAcumulado(request.getFecha_Apertura());
			if(salida > 0) {
				mensaje ="Eliminado";	
				
			}else {
				mensaje = "Error";	
				throw new GenericException("Error");
			}
			
		
		}catch (GenericException ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return mensaje;
	}


	@Override
	public List<AutoTasaAcomuladoCampGerenciaResponseDTO> ObtenerRegistrosAcumuCamp() throws GenericException, IOException {
		List<AutoTasaAcomuladoCampGerenciaResponseDTO>  autoTasaAcomuladoCampGerenciaResponseDTO = new  ArrayList<AutoTasaAcomuladoCampGerenciaResponseDTO>();
		
		try { 
			listCampanasGerencia = obtenerListaCampanasGerenciaRepo.ObtenerRegistrosAcumuCamp();
			for(ObtenerListaCampanasGerencia aut : listCampanasGerencia) {
				LOGGER.debug(listCampanasGerencia.size());
				if(aut.getNOM_CAMP() != null) {
					if(aut.getNOM_CAMP().trim().equals("PTU2021") || aut.getNOM_CAMP().trim().equals("PTUSDO")) {
						aut.setNOM_CAMP("PTU2021");
					}
					if(aut.getNOM_CAMP().trim().equals("CREDONLY2021") ) {
						aut.setNOM_CAMP("CREDONLY2021");
					}
				}
				LOGGER.debug(aut.getDIVISION()+ 
						aut.getDISTRITO()+ 
						aut.getNOM_CAMP()+
						aut.getTIPO_DISP()+ 
						aut.getTIPO()+
						aut.getMONTO()+ 
						aut.getNUM_EJECUTIVOS()+
						aut.getNUM_VENTAS());
				autoTasaAcomuladoCampGerenciaResponseDTO.add(new AutoTasaAcomuladoCampGerenciaResponseDTO(aut.getSIRH(),
						aut.getDIVISION(), 
						aut.getDISTRITO(), 
						aut.getNOM_CAMP(), 
						aut.getTIPO_DISP(), 
						aut.getTIPO(),
						aut.getMONTO(), 
						aut.getNUM_EJECUTIVOS(),
						aut.getNUM_VENTAS()) );
			}  
		} catch (Exception e) {
			System.out.println("ex ->" + e.getMessage());
			System.out.println("ex ->" + e.getCause());
		}
		return autoTasaAcomuladoCampGerenciaResponseDTO;
	}

//falta probar
	@Override
	public List<EjecutivosPriorityGerenciaResponseDTO> ObtenerEjecutivosPriority(
			EjecutivosPriorityGerenciaBEDTO request) throws GenericException, IOException{
		List<EjecutivosPriorityGerenciaResponseDTO>  ejecutivosPriorityGerenciaResponseDTO = new  ArrayList<EjecutivosPriorityGerenciaResponseDTO>();
        try {
		listEjecutivosPriorityGerencia = ejecutivosPriorityGerenciaRepo.ObtenerEjecutivosPriority();
		for(EjecutivosPriorityGerencia ejec : listEjecutivosPriorityGerencia) {
			ejecutivosPriorityGerenciaResponseDTO.add(new EjecutivosPriorityGerenciaResponseDTO(ejec.getDIVISION(), 
					ejec.getDISTRITO(), 
					ejec.getSIRH(), 
					ejec.getID_ALTERNATIVO(), 
					ejec.getNOMBRE(), 
					request.getCampana().split(",")[0].trim().replace("'", ""), 
					"2020-02-01"));
		}
        } catch (Exception e) {
			System.out.println("ex ->" + e.getMessage());
			System.out.println("ex ->" + e.getCause());
		}
		return ejecutivosPriorityGerenciaResponseDTO;
	}


	@Override
	public List<EjecutivosPriorityVentaGerenciaResponseDTO> ObtenerEjecutivosPriorityConVentas(
			EjecutivosPriorityGerenciaBEDTO request)throws GenericException, IOException {
		 List<EjecutivosPriorityVentaGerenciaResponseDTO>  ejecutivosPriorityVentaGerenciaResponseDTO = new  ArrayList<EjecutivosPriorityVentaGerenciaResponseDTO>();
		 try {
		 listEjecutivosPriorityVentaGerencia = ejecutivosPriorityVentaGerenciaRepo.ObtenerEjecutivosPriorityConVentas(request.getCampana());
		 SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy");
		 for(EjecutivosPriorityVentaGerencia ejec : listEjecutivosPriorityVentaGerencia) { 
			 ejecutivosPriorityVentaGerenciaResponseDTO.add(new EjecutivosPriorityVentaGerenciaResponseDTO(ejec.getDIVISION(),
					 ejec.getDISTRITO(),
					 ejec.getSUC(),
					 ejec.getNOMINA(), 
					 ejec.getNOMBRE(), 
					 objSDF2.format(ejec.getFECHA()), 
					 ejec.getSUBTOTAL(), 
					 ejec.getSUB_IMPORTE(), 
					 ejec.getCAMPANA()));
			}
		 } catch (Exception e) {
				System.out.println("ex ->" + e.getMessage());
				System.out.println("ex ->" + e.getCause());
			}
		return ejecutivosPriorityVentaGerenciaResponseDTO;
	}


	@Override
	public List<EjecutivosPrioritySinVentaGerenciaResponseDTO> ObtenerEjecutivosPrioritySinVentas(
			EjecutivosPriorityGerenciaBEDTO request) throws GenericException, IOException {
		List<EjecutivosPrioritySinVentaGerenciaResponseDTO>  ejecutivosPrioritySinVentaGerenciaResponseDTO = new  ArrayList<EjecutivosPrioritySinVentaGerenciaResponseDTO>();
        try {
		listEjecutivosPriorityVentaGerencia = ejecutivosPriorityVentaGerenciaRepo.ObtenerEjecutivosPrioritySinVentas(request.getCampana());
		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy");
		 for(EjecutivosPriorityVentaGerencia ejec : listEjecutivosPriorityVentaGerencia) { 
			 ejecutivosPrioritySinVentaGerenciaResponseDTO.add(new EjecutivosPrioritySinVentaGerenciaResponseDTO(ejec.getDIVISION(),
					 ejec.getDISTRITO(),
					 ejec.getSUC(),
					 ejec.getNOMINA(), 
					 ejec.getNOMBRE(), 
					 ejec.getCAMPANA(),
					 objSDF2.format(ejec.getFECHA())));
			}
        } catch (Exception e) {
			System.out.println("ex ->" + e.getMessage());
			System.out.println("ex ->" + e.getCause());
		}

		return ejecutivosPrioritySinVentaGerenciaResponseDTO;
	}


	@Override
	public Long ObtenerDiasHabiles(EjecutivosPriorityGerenciaBEDTO request) throws GenericException, IOException {
		Long dias = null;
		try {
			dias =autoTasaAcomuladoCampGerenciaRepo.ObtenerDiasHabiles(request.getCampana());
			LOGGER.debug(dias);
		} catch (Exception e) {
				System.out.println("ex ->" + e.getMessage());
				System.out.println("ex ->" + e.getCause());
		}
		LOGGER.debug(dias);
		return dias;
	}


	@Override
	public String ObtenerFechaMaxima(EjecutivosPriorityGerenciaBEDTO request) throws GenericException, IOException {
		String fecha = null;
		try {
			fecha =autoTasaAcomuladoCampGerenciaRepo.ObtenerFechaMaxima(request.getCampana());
		} catch (Exception e) {
				System.out.println("ex ->" + e.getMessage());
				System.out.println("ex ->" + e.getCause());
		}
		return fecha;
	}


	@Override
	public List<ObtenerTotalEjecutivosDivisionResponseDTO> ObtenerTotalEjecutivosDivision()
			throws GenericException, IOException {
		List<ObtenerTotalEjecutivosDivisionResponseDTO>  obtenerTotalEjecutivosDivisionResponseDTO = new  ArrayList<ObtenerTotalEjecutivosDivisionResponseDTO>();
		try {
		listEjecutivosGerencia = totalEjecutivosGerenciaRepo.ObtenerTotalEjecutivosDivision();
		for(TotalEjecutivosGerencia suc : listEjecutivosGerencia) { 
			obtenerTotalEjecutivosDivisionResponseDTO.add(new ObtenerTotalEjecutivosDivisionResponseDTO(suc.getDIVISION(), suc.getCantejec()) );
			LOGGER.debug("entro"+ suc.getDIVISION()+ suc.getCantejec() );
		}
		} catch (Exception e) {
			System.out.println("ex ->" + e.getMessage());
			System.out.println("ex ->" + e.getCause());
	    }
		return obtenerTotalEjecutivosDivisionResponseDTO;
	}


	@Override
	public List<ObtenerTotalEjecutivosRegionResponseDTO> ObtenerTotalEjecutivosRegion()
			throws GenericException, IOException {
		List<ObtenerTotalEjecutivosRegionResponseDTO>  obtenerTotalEjecutivosRegionResponseDTO = new  ArrayList<ObtenerTotalEjecutivosRegionResponseDTO>();
		try {
			listEjecutivosGerencia = totalEjecutivosGerenciaRepo.ObtenerTotalEjecutivosRegion();
			for(TotalEjecutivosGerencia suc : listEjecutivosGerencia) { 
				obtenerTotalEjecutivosRegionResponseDTO.add(new ObtenerTotalEjecutivosRegionResponseDTO(suc.getDISTRITO(), suc.getCantejec()) );
			
				LOGGER.debug("entro"+ suc.getDISTRITO()+ suc.getCantejec() );
			}
			} catch (Exception e) {
				System.out.println("ex ->" + e.getMessage());
				System.out.println("ex ->" + e.getCause());
		    }
		return obtenerTotalEjecutivosRegionResponseDTO;
	}


	@Override
	public Long GetNumRegTbAcumuladoTasas(GetNumRegTbAcumuladoTasasGerenciaResponseBEDTO request)
			throws GenericException, IOException {
		Long salida = null;
		try {
		if(request.getAcum_o_tasas() == 1){
			salida = tasaGerenciaRepo.GetNumRegTbAcumuladoTasas(request.getCampana(),request.getFercha());
			
		}
		else if(request.getAcum_o_tasas() == 2) {
			salida = acumuladoGerenciaRepo.GetNumRegTbAcumuladoTasas(request.getCampana(),request.getFercha());
			
		}
		 
		} catch (Exception e) {
			System.out.println("ex ->" + e.getMessage());
			System.out.println("ex ->" + e.getCause());
	    }
		return salida;
	}


	@Override
	public List<CampanaGerenciaResponseDTO> ObtenerlistaEAV(AutoTasaGerenciaBEDTO request) throws GenericException, IOException {
		List<CampanaGerenciaResponseDTO> campanaGerenciaResponseDTO = new ArrayList<CampanaGerenciaResponseDTO>();
		try {
		List<CampanaDiasGerenciaResponseDTO> fechas = new ArrayList<CampanaDiasGerenciaResponseDTO>();
		SimpleDateFormat objSDF23 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH); 
		Date  actual=  new Date();
		Date  inic=  new Date();
		Date  fin=  new Date();
		listCampanaGerenciaFecha = campanaGerenciaRepo.obtenerFechas(request.getCampana());
		listAcomuladoGerencia = acomuladoGerenciaRepo.ObtenerlistaEAV(objSDF23.format(actual).toString());
		for(CampanaGerencia camp : listCampanaGerenciaFecha) { 
			inic = camp.getCAMPANIAS_INICIO();
			fin = camp.getCAMPANIAS_FIN();
		}
		Date startDate = inic;
		Date endDate = fin;
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		SimpleDateFormat fo = new SimpleDateFormat("u");
		for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
			if( Integer.parseInt(fo.format(date)) < 6 ) {
			//	 String fecha_ult = (objSDF23.format(acum.getFECHA()).toString().equals(objSDF23.format(actual).toString())) ? acum.getNUM_FECHA() :"0";
						// fechas.add(new CampanaDiasGerenciaResponseDTO(objSDF23.format(date).toString()+": "+"0"));
					 //fechas.add(new CampanaDiasGerenciaResponseDTO(objSDF23.format(date).toString()+": "+"0"));
				 fechas.add(new CampanaDiasGerenciaResponseDTO(objSDF23.format(date).toString()));
					 }	 
			}   

		 for(AcomuladoGerencia acum : listAcomuladoGerencia) {
				

				campanaGerenciaResponseDTO.add(new CampanaGerenciaResponseDTO(acum.getNOMINA(),
						acum.getNOMBRE(),
						acum.getSUC(), 
						acum.getDIVISION(), 
						acum.getDISTRITO(), 
						acum.getSOIED(), 
						acum.getPRIO_VENTAS(), 
						acum.getSUB_TOTAL(), 
						acum.getSUB_IMPORTE(), 
						acum.getCEDE_VENTAS(), 
						acum.getCEDE_IMPORTE(), 
						acum.getCAMP_VENTAS(), 
						acum.getCAMP_IMPORTE(),
						acum.getPUESTO(), 
						acum.getPORTAESP_VENTAS(), 
						acum.getPORTAESP_IMPORTE(), 
						ObtenerFecha(request.getCampana(), acum.getFECHA(), acum.getNUM_FECHA())) );

			}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error :: ",
					HttpStatus.NOT_FOUND.toString());
	    }
		return campanaGerenciaResponseDTO;
	}


	@Override
	public List<CampGerenciaResponseDTO> ObtenerListaCampanas() throws GenericException, IOException {
		List<CampGerenciaResponseDTO> campGerenciaResponseDTO = new ArrayList<CampGerenciaResponseDTO>();
		try {
		listCampanaGerenciaFecha = campanaGerenciaRepo.ObtenerListaCampanas();
		for(CampanaGerencia camp : listCampanaGerenciaFecha) { 
			campGerenciaResponseDTO.add(new CampGerenciaResponseDTO(camp.getCAMPANIAS_ID(), 
					camp.getCAMPANIAS_NOMBRE(),
					camp.getCAMPANIAS_ESTATUS()));
			
		}
		} catch (Exception e) { 
			e.printStackTrace();
			throw new GenericException("Error :: ",
					HttpStatus.NOT_FOUND.toString());
	    }
		return campGerenciaResponseDTO;
	}


	@Override
	public List<ObtenerlistaEjecutivosNoLocalizablesResponseDTO> ObtenerlistaEjecutivosNoLocalizables()
			throws GenericException, IOException {
		List<ObtenerlistaEjecutivosNoLocalizablesResponseDTO> obtenerlistaEjecutivosNoLocalizablesResponseDTO = new ArrayList<ObtenerlistaEjecutivosNoLocalizablesResponseDTO>();
	    try {
		ejecutivosNoLocalizablesGerencia = ejecutivosNoLocalizablesGerenciaRepo.ObtenerlistaEjecutivosNoLocalizables();
		for(EjecutivosNoLocalizablesGerencia ejec : ejecutivosNoLocalizablesGerencia) { 
			obtenerlistaEjecutivosNoLocalizablesResponseDTO.add(new ObtenerlistaEjecutivosNoLocalizablesResponseDTO(ejec.getNOMINA(),
					ejec.getNOMBRE(),
					ejec.getSUC(),
					ejec.getMONTOVENTAS(),
					ejec.getNUMVENTAS()));
		}
	    } catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error :: ",
					HttpStatus.NOT_FOUND.toString());
	    }
		return obtenerlistaEjecutivosNoLocalizablesResponseDTO;
	}

 public List<CampanaDiasGerenciaResponseDTO>  ObtenerFecha (String cam, Date fecha, String valor) {
	 
	 List<CampanaDiasGerenciaResponseDTO> fechas = new ArrayList<CampanaDiasGerenciaResponseDTO>();
		SimpleDateFormat objSDF23 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH); 
		Date  inic=  new Date();
		Date  fin=  new Date();
		listCampanaGerenciaFecha = campanaGerenciaRepo.obtenerFechas(cam);
		for(CampanaGerencia camp : listCampanaGerenciaFecha) { 
			inic = camp.getCAMPANIAS_INICIO();
			fin = camp.getCAMPANIAS_FIN();
		}
		Date startDate = inic;
		Date endDate = fin;
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		SimpleDateFormat fo = new SimpleDateFormat("u");
		for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
			if( Integer.parseInt(fo.format(date)) < 6 ) {
				 String fecha_ult = (objSDF23.format(fecha).toString().equals(objSDF23.format(date).toString())) ? valor :"0";
						 fechas.add(new CampanaDiasGerenciaResponseDTO(objSDF23.format(date).toString()+" : "+fecha_ult));

					 }	 
			}   
	 return fechas;
 }


@Override
public List<DibujarChartAgrupadoResponseDTO> ObtenerMontoVolumenPorDiaCampanaProcesada(
		AutoTasaMontoVolumenGerenciaRepoResponseBEDTO request) throws GenericException, IOException {
	List<AutoTasaMontoVolumenGerenciaRepoResponseDTO> auto = new ArrayList<AutoTasaMontoVolumenGerenciaRepoResponseDTO>();
	List<DibujarChartAgrupadoResponseDTO> Salida  = new ArrayList<DibujarChartAgrupadoResponseDTO>();
	
	Calendar c = Calendar.getInstance();
	SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy"); 
	
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("u");
    String dias =simpleDateFormat.format(date).toString();
    String fecha_inicio = null;
    String fecha_fin  = null;
	String Campana = null;
	try {
		
        switch (dias) {
        case "1": 
			c.setTime(date);
	        c.add(Calendar.DATE, 0);
	        date = c.getTime();
	        fecha_inicio = objSDF2.format(date).toString();
	        c.setTime(date);
	        c.add(Calendar.DATE, 6);
	        date = c.getTime();
	        fecha_fin = objSDF2.format(date).toString();
			break;
		case "2": 
			c.setTime(date);
	        c.add(Calendar.DATE, -1);
	        date = c.getTime();
	        fecha_inicio = objSDF2.format(date).toString();
	        c.setTime(date);
	        c.add(Calendar.DATE, 6);
	        date = c.getTime();
	        fecha_fin = objSDF2.format(date).toString();
			break;
		case "3": 
			c.setTime(date);
	        c.add(Calendar.DATE, -2);
	        date = c.getTime();
	        fecha_inicio = objSDF2.format(date).toString();
	        c.setTime(date);
	        c.add(Calendar.DATE, 6);
	        date = c.getTime();
	        fecha_fin = objSDF2.format(date).toString();
			break;
		case "4": 
			c.setTime(date);
	        c.add(Calendar.DATE, -3);
	        date = c.getTime();
	        fecha_inicio = objSDF2.format(date).toString();
	        c.setTime(date);
	        c.add(Calendar.DATE, 6);
	        date = c.getTime();
	        fecha_fin = objSDF2.format(date).toString();
			break;
		case "5": 
			c.setTime(date);
	        c.add(Calendar.DATE, -4);
	        date = c.getTime();
	        fecha_inicio = objSDF2.format(date).toString();
	        c.setTime(date);
	        c.add(Calendar.DATE, 6);
	        date = c.getTime();
	        fecha_fin = objSDF2.format(date).toString();
			break;
		case "6": 
			c.setTime(date);
	        c.add(Calendar.DATE, -5);
	        date = c.getTime();
	        fecha_inicio = objSDF2.format(date).toString();
	        c.setTime(date);
	        c.add(Calendar.DATE, 6);
	        date = c.getTime();
	        fecha_fin = objSDF2.format(date).toString();
			break;
		case "7": 
			c.setTime(date);
	        c.add(Calendar.DATE, -6);
	        date = c.getTime();
	        fecha_inicio = objSDF2.format(date).toString();
	        c.setTime(date);
	        c.add(Calendar.DATE, 6);
	        date = c.getTime();
	        fecha_fin = objSDF2.format(date).toString();
			break;
		default:
			break;
		}

	/*if(request.isCheckts() == true) {
		listMontVent = autoTasaMontoVolumenGerenciaRepo.ObtenerMontoVolumenPorDiaCampanaProcesada(fecha_inicio, fecha_fin);
	}else if(request.isCheckts() == false) {
		listMontVent = autoTasaMontoVolumenGerenciaRepo.ObtenerMontoVolumenPorDiaCampanaProcesada2(fecha_inicio, fecha_fin);
	}*/
       System.out.println("entro");
        listMontVent2= autoTasaMontoVolumenGerenciaRepository.ObtenerVistaCampanaporDivision(fecha_inicio, fecha_fin, false);
        System.out.println("salio");
        
	SimpleDateFormat objSDF3 = new SimpleDateFormat("dd/MM/yyyy"); 
	for(AutoTasaMontoVolumenGerencias automonto : listMontVent2) {
		switch(automonto.getCAMPANA())
		{
		   case "CREDONLY2021" :
			   Campana =  "CREDONLY2021";
		           break; 
		   case "PTU2021":
            	  Campana = "PTU 2021";
            	  break;
           case "PTUSDO":
            	  Campana = "PTU SALDO BASE";
            	  break;  
           case "HIPOTECA":
            	  Campana = "HIPOTECA 2021";
            	  break;
           case "CREDNOM2021":
            	  Campana = "CREDITO DE NOMINA";
            	  break;
           case "PORTAESPNOM":
            	  Campana = "PORTABILIDAD ESP. NOMINA";
            	  break;
           case "EXCEPGER":
            	  Campana = "EXCEPCION GERENCIA";
            	  break;
           case "AutCETE98":
            	  Campana ="AUT. DISTRITALES";
            	  break;
           case "ESPECIAL":
            	  Campana = "AUT. DIVISIONALES";
            	  break;
           case "ONBOARDING":
            	  Campana = "ONBOARDING2021";
            	  break;
		   default : 
			   Campana = automonto.getCAMPANA();
		}
		System.out.println("entro3");
	//	BigInteger volumen = new BigInteger(automonto.getVOLUMEN());
	//	BigInteger monto = new BigInteger(automonto.getMONTO());
		System.out.println(objSDF3.format(automonto.getFECHA())+ " "+automonto.getFECHA()+ " "+automonto.getCAMPANA()+ " " +automonto.getVOLUMEN()+ " "+ automonto.getMONTO());
		auto.add(new AutoTasaMontoVolumenGerenciaRepoResponseDTO(
				automonto.getVOLUMEN(), 
				Campana, 
				objSDF3.format(automonto.getFECHA()),
				automonto.getMONTO()
			));
	}
	
	List<String> ListaCategorias ;
	List<String> campana ;
	List<DatosAgrupadosResponseDTO> datos_agrupados = null;
	List<DatosAgrupadosResponseDTO> datos_agrupados_mixtos = null;
	List<Data_ChartBEResponSeDTO> listaDatos = null;
	List<Data_ChartBEResponSeDTO> listaDato2 = null;
	List<Data_ChartBEResponSeDTO> listaDato3 = null;
	
	double valor2 = 0 ;
	double valor3 = 0 ;
	double valor4 = 0 ;
	
	
	ListaCategorias = auto.stream()
			.map(x-> x.getFECHA())
			.distinct()
			.collect(Collectors.toList());
	ListaCategorias.stream().toString();
	
	
	campana = auto.stream()
	              .map(x-> x.getCAMPANA())
	              .distinct()
	              .collect(Collectors.toList());
	campana.stream().toString();
	/////////////////////////////////////////////////////////////////////////////////
	datos_agrupados = new ArrayList<DatosAgrupadosResponseDTO>();
	for(String cam : campana) {
		 listaDatos = new ArrayList<Data_ChartBEResponSeDTO>();
		for(String fec : ListaCategorias) {
    		
			 valor2 = auto.stream()
					.filter(x-> x.getCAMPANA().equals(cam) && x.getFECHA().toString().equals(fec.toString()))
					//.mapToDouble(x->x.getVOLUMEN().doubleValue())
					.mapToDouble(x->  Double.parseDouble(x.getVOLUMEN()))
					.sum();
			
			 listaDatos.add(new Data_ChartBEResponSeDTO("", valor2));
    	}
		datos_agrupados.add(new DatosAgrupadosResponseDTO(cam, listaDatos));
		
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////
	datos_agrupados_mixtos = new ArrayList<DatosAgrupadosResponseDTO>();
	listaDato2 = new ArrayList<Data_ChartBEResponSeDTO>();
	for(String fec3 : ListaCategorias) {
    	if((int) auto.stream().filter(x-> x.getFECHA().toString().equals(fec3.toString())).count() >0) {
			 System.out.println("entro");
			 valor3 = auto.stream()
						.filter(x->  x.getFECHA().toString().equals(fec3.toString()))
						//.mapToDouble(x->x.getMONTO().doubleValue())
						 .mapToDouble(x->  Double.parseDouble(x.getMONTO()))
						.sum() / auto.stream()
						.filter(x->  x.getFECHA().toString().equals(fec3.toString()))
						.count();
			 listaDato2.add(new Data_ChartBEResponSeDTO(fec3, valor3));
		//	
			
			 
		 }
    }
	datos_agrupados_mixtos.add(new DatosAgrupadosResponseDTO("Promedio", listaDato2));
	/////////////////////////////////////////////////////////////////////////////////
	
	listaDato3 = new ArrayList<Data_ChartBEResponSeDTO>();
	for(String camp : campana) {
		 listaDatos = new ArrayList<Data_ChartBEResponSeDTO>();
		
			 valor4 = auto.stream()
					.filter(x-> x.getCAMPANA().equals(camp))
					//.mapToDouble(x->x.getMONTO().doubleValue())
					 .mapToDouble(x->  Double.parseDouble(x.getMONTO()))
					.sum() / 1000000;
			
			 listaDato3.add(new Data_ChartBEResponSeDTO(camp, valor4));

	}
	
	
	
	
	
	if(request.getTipo().equals("ChartSolicitudes")) {
		Salida.add(new DibujarChartAgrupadoResponseDTO("ChartSolicitudes",
                "bar", 
                 true, 
                 "top", 
                 "Solicitudes por Campaña",
                 0.75, 
                 false,
                 datos_agrupados, 
                 ListaCategorias,
                 null,
                 null));
	}else if(request.getTipo().equals("ChartMontos")) {
		Salida.add(new DibujarChartAgrupadoResponseDTO("ChartSolicitudes",
                "bar", 
                 true, 
                 "top", 
                 "Solicitudes por Campaña",
                 0.75, 
                 false,
                 datos_agrupados, 
                 ListaCategorias,
                 datos_agrupados_mixtos,
                 null));
	
	}else if(request.getTipo().equals("ChartMontoSemanal")) {
		Salida.add(new DibujarChartAgrupadoResponseDTO("ChartSolicitudes",
                "bar", 
                 true, 
                 "top", 
                 "Solicitudes por Campaña",
                 0.75, 
                 false,
                 null, 
                 null,
                 null,
                 listaDato3));
	}
	
	
	
	 
	} catch (Exception e) {
		e.printStackTrace();
		throw new GenericException("Error :: ",
				HttpStatus.NOT_FOUND.toString());
    }
	return Salida;
}


@Override
public List<DibujarChartResponseDTO> LoadCharts(DibujarChartResponseBEDTO request) throws GenericException, IOException {
	List<DibujarChartResponseDTO> dibujarChartResponseDTO = new ArrayList<DibujarChartResponseDTO>();
	listAutoTasaOnLine =autoTasasOnLineGerenciaRepo.ObtenerRegistrosAutoTasasOnLine();
	List<RegAutoTasasBEResponseDTO> listaSolicitudes = null;
	List<Data_ChartBEResponSeDTO> listaDatos = null;
    Calendar calendar = Calendar.getInstance();
    Date today =  new Date();
    Date fecha_Actual_v1 = new Date();
    Date fecha_Actual_v2 = new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	List<String> leve = null;
	double value  = 0;
	
    calendar.setTime(today);
    today = calendar.getTime();
	
	listaSolicitudes = listAutoTasaOnLine.stream()
										 .filter(x -> x.getESTATUS().equals("ACEPTADA")  || x.getESTATUS().equals("SOLIC_CANCEL") || x.getESTATUS().equals("SOLICITADA"))
										 .map(this:: TipoSolicitudToDto)
										 .collect(Collectors.toList());
	
	listaDatos = new ArrayList<Data_ChartBEResponSeDTO>();
	try {
		for (RegAutoTasasBEResponseDTO item : listaSolicitudes)
        {
			System.out.println("item");
			System.out.println(item.getSOEID_AUTORI());
            if (item.getSOEID_AUTORI() != null)
            {
            	System.out.println("entro");
                if ( !item.getSOEID_AUTORI().isEmpty()  && !item.getSOEID_AUTORI().equals("0") )
                {
                	System.out.println("entro2");
                    if (item.getESTATUS().equals("ACEPTADA"))
                    {
                    	System.out.println("entro3");
                        item.setDelay(1);
                        item.setStrDelay("En tiempo") ;
                        String fecha1 = item.getFECHA_SOLIC();
                        fecha_Actual_v1 = sdf.parse(fecha1);
            		    calendar.setTime(fecha_Actual_v1);
            		    calendar.add(Calendar.MINUTE, 3);
            		    fecha_Actual_v1 = calendar.getTime();
            		    
            		    fecha_Actual_v2 = sdf.parse(fecha1);
            		    calendar.setTime(fecha_Actual_v2);
            		    calendar.add(Calendar.MINUTE, 5);
            		    fecha_Actual_v2 = calendar.getTime();
            		    
            		    System.out.println(fecha_Actual_v1+ " :: "+today);
                        
                        if (fecha_Actual_v1.compareTo(today) <= 0) { item.setDelay(2); item.setStrDelay("Próximo a Vencer"); }
                        if (fecha_Actual_v2.compareTo(today) <= 0) { item.setDelay(3); item.setStrDelay("Vencidos"); }
                    }
                }
            }
            else
            {       
            	 System.out.println("else");
                    item.setDelay(1);
                    item.setStrDelay("En tiempo") ;
                    System.out.println(item.getDelay() + " :: " +item.getStrDelay());
                    System.out.println(" :: " +item.getFECHA_SOLIC());
                    String fecha1 = item.getFECHA_SOLIC();
                    System.out.println(" :: " +fecha1);
                    
                    fecha_Actual_v1 = sdf.parse(fecha1);
                    System.out.println(" :: " +fecha_Actual_v1);
        		    calendar.setTime(fecha_Actual_v1);
        		    calendar.add(Calendar.MINUTE, 3);
        		    fecha_Actual_v1 = calendar.getTime();
        		    System.out.println(" :: " +fecha_Actual_v1);
        		    
        		    fecha_Actual_v2 = sdf.parse(fecha1);
        		    System.out.println(" :: " +fecha_Actual_v2);
        		    calendar.setTime(fecha_Actual_v2);
        		    calendar.add(Calendar.MINUTE, 5);
        		    fecha_Actual_v2 = calendar.getTime();
        		    System.out.println(" :: " +fecha_Actual_v2);
        		    
        		    System.out.println(fecha_Actual_v1+ " :: "+today);
                    if (fecha_Actual_v1.compareTo(today) <= 0) { item.setDelay(2); item.setStrDelay("Próximo a Vencer"); }
                    if (fecha_Actual_v2.compareTo(today) <= 0) { item.setDelay(3); item.setStrDelay("Vencidos"); }                 
            }
        }
		
		
		if(request.getTipo().equals("Especiales por Tiempo")) {
	        if (listaSolicitudes.stream().filter(x -> x.getTIPO_AUTORI().equals("ESPECIAL") || x.getTIPO_AUTORI().equals("AutCETE98" )).count() > 0)
	        {     
	        	System.out.println( " entro 1.1 ");
	        	
	        	Map<String, List<RegAutoTasasBEResponseDTO>> result =  listaSolicitudes.stream()
	        			.filter(x-> x.getTIPO_AUTORI().equals("ESPECIAL") || x.getTIPO_AUTORI().equals("AutCETE98"))
	        			.collect(Collectors.groupingBy(RegAutoTasasBEResponseDTO::getStrDelay));
	        	
	        	Map<String, Long> result2 =  listaSolicitudes.stream()
	        			.filter(x-> x.getTIPO_AUTORI().equals("ESPECIAL") || x.getTIPO_AUTORI().equals("AutCETE98"))
	        			.collect(Collectors.groupingBy(RegAutoTasasBEResponseDTO::getStrDelay, Collectors.counting()));
	        	
	        	Iterator it = result.keySet().iterator();
		    	while(it.hasNext()){
		    	  Object key =  it.next();
		    	  System.out.println("Clave: " + key + " -> Valor: " + result2.get(key));
		    	  listaDatos.add(new Data_ChartBEResponSeDTO(key.toString(), result2.get(key)));
		    	}
	        	
		    	dibujarChartResponseDTO.add(new DibujarChartResponseDTO("ChartTime1",
		    			"doughnut",
		    			"Por Estatus",
		    			true,
		    			"right",
		    			"Especiales por Tiempo",
		    			0.75,
		    			false, 
		    			listaDatos));
	        }
			
		}else if(request.getTipo().equals("Especiales por Estatus")) {
			
			if (listaSolicitudes.stream().filter(x -> x.getTIPO_AUTORI().equals("ESPECIAL") || x.getTIPO_AUTORI().equals("AutCETE98")).count() > 0)
            {
               /* 

                DibujarChart("ChartEstatus1", "bar", "Por Estatus", false, "right", "Especiales por Estatus", 0.75, false, listaDatos);*/
	        	Map<String, List<RegAutoTasasBEResponseDTO>> result =  listaSolicitudes.stream()
	        			.filter(x-> x.getTIPO_AUTORI().equals("ESPECIAL") || x.getTIPO_AUTORI().equals("AutCETE98"))
	        			.collect(Collectors.groupingBy(RegAutoTasasBEResponseDTO::getESTATUS));
	        	
	        	Map<String, Long> result2 =  listaSolicitudes.stream()
	        			.filter(x-> x.getTIPO_AUTORI().equals("ESPECIAL") || x.getTIPO_AUTORI().equals("AutCETE98"))
	        			.collect(Collectors.groupingBy(RegAutoTasasBEResponseDTO::getESTATUS, Collectors.counting()));
	        	
	        	Iterator it = result.keySet().iterator();
		    	while(it.hasNext()){
		    	  Object key =  it.next();
		    	  System.out.println("Clave: " + key + " -> Valor: " + result2.get(key));
		    	  listaDatos.add(new Data_ChartBEResponSeDTO(key.toString(), result2.get(key)));
		    	}
	        	
		    	dibujarChartResponseDTO.add(new DibujarChartResponseDTO("ChartEstatus1",
		    			"bar",
		    			"Por Estatus",
		    			false,
		    			"right",
		    			"Especiales por Estatus",
		    			0.75,
		    			false, 
		    			listaDatos));
				
            }
			
		}else if(request.getTipo().equals("Campaña PTU2021 por Tiempo")) {
			
	        if (listaSolicitudes.stream().filter(x -> x.getTIPO_AUTORI().equals("PTUSDO12021")||
	        		x.getTIPO_AUTORI().equals("PTUSDO22021") ||	x.getTIPO_AUTORI().equals("PTUSDO32021") ||
	        	    x.getTIPO_AUTORI().equals("PTUSDO42021") || x.getTIPO_AUTORI().equals( "PTUSDO52020") ||
	                x.getTIPO_AUTORI().equals("PTU2021100")  || x.getTIPO_AUTORI().equals("PTU2021105")  ||
	                x.getTIPO_AUTORI().equals("PTU2021110")  || x.getTIPO_AUTORI().equals("CREDNOM2021")).count() > 0) {
	        	

	        			
	        Map<String, List<RegAutoTasasBEResponseDTO>> result =  listaSolicitudes.stream()
	        		.filter(x -> x.getTIPO_AUTORI().equals("PTUSDO12021")||
	                		x.getTIPO_AUTORI().equals("PTUSDO22021") ||	x.getTIPO_AUTORI().equals("PTUSDO32021") ||
	                	    x.getTIPO_AUTORI().equals("PTUSDO42021") || x.getTIPO_AUTORI().equals( "PTUSDO52020") ||
	                        x.getTIPO_AUTORI().equals("PTU2021100")  || x.getTIPO_AUTORI().equals("PTU2021105")  ||
	                        x.getTIPO_AUTORI().equals("PTU2021110")  || x.getTIPO_AUTORI().equals("CREDNOM2021"))
	                		.collect(Collectors.groupingBy(RegAutoTasasBEResponseDTO::getStrDelay));
	                	
	        Map<String, Long> result2 =  listaSolicitudes.stream()
	                .filter(x -> x.getTIPO_AUTORI().equals("PTUSDO12021")||
	                	    x.getTIPO_AUTORI().equals("PTUSDO22021") ||	x.getTIPO_AUTORI().equals("PTUSDO32021") ||
	                	    x.getTIPO_AUTORI().equals("PTUSDO42021") || x.getTIPO_AUTORI().equals( "PTUSDO52020") ||
	                	    x.getTIPO_AUTORI().equals("PTU2021100")  || x.getTIPO_AUTORI().equals("PTU2021105")  ||
	                	    x.getTIPO_AUTORI().equals("PTU2021110")  || x.getTIPO_AUTORI().equals("CREDNOM2021"))
	                		.collect(Collectors.groupingBy(RegAutoTasasBEResponseDTO::getStrDelay, Collectors.counting()));
	                	
	        Iterator it = result.keySet().iterator();
	        while(it.hasNext()){
	        	Object key =  it.next();
	        	System.out.println("Clave: " + key + " -> Valor: " + result2.get(key));
	        	listaDatos.add(new Data_ChartBEResponSeDTO(key.toString(), result2.get(key)));
	        }
	                	
	        dibujarChartResponseDTO.add(new DibujarChartResponseDTO("ChartTime2",
	        	    "doughnut",
	        	    "Por Estatus",
	        	    true,
	        	    "right",
	        	    "Campaña PTU2021 por Tiempo",
	        	    0.75,
	        	    false, 
	        	    listaDatos));        			
	        			

	       // DibujarChart("ChartTime2", "doughnut", "Por Estatus", true, "right", "Campaña PTU2021 por Tiempo", 0.75, false, listaDatos);
	        }
			
		}else if(request.getTipo().equals("Campaña PTU2021 gana por Estatus")) {
			
	        if (listaSolicitudes.stream().filter(x -> x.getTIPO_AUTORI().equals("PTUSDO12021")||
	        		x.getTIPO_AUTORI().equals("PTUSDO22021") ||	x.getTIPO_AUTORI().equals("PTUSDO32021") ||
	        	    x.getTIPO_AUTORI().equals("PTUSDO42021") || x.getTIPO_AUTORI().equals( "PTUSDO52020") ||
	                x.getTIPO_AUTORI().equals("PTU2021100")  || x.getTIPO_AUTORI().equals("PTU2021105")  ||
	                x.getTIPO_AUTORI().equals("PTU2021110")  || x.getTIPO_AUTORI().equals("CREDNOM2021")).count() > 0) {
	        	

	        			
	        Map<String, List<RegAutoTasasBEResponseDTO>> result =  listaSolicitudes.stream()
	        		.filter(x -> x.getTIPO_AUTORI().equals("PTUSDO12021")||
	                		x.getTIPO_AUTORI().equals("PTUSDO22021") ||	x.getTIPO_AUTORI().equals("PTUSDO32021") ||
	                	    x.getTIPO_AUTORI().equals("PTUSDO42021") || x.getTIPO_AUTORI().equals( "PTUSDO52020") ||
	                        x.getTIPO_AUTORI().equals("PTU2021100")  || x.getTIPO_AUTORI().equals("PTU2021105")  ||
	                        x.getTIPO_AUTORI().equals("PTU2021110")  || x.getTIPO_AUTORI().equals("CREDNOM2021"))
	                		.collect(Collectors.groupingBy(RegAutoTasasBEResponseDTO::getESTATUS));
	                	
	        Map<String, Long> result2 =  listaSolicitudes.stream()
	                .filter(x -> x.getTIPO_AUTORI().equals("PTUSDO12021")||
	                	    x.getTIPO_AUTORI().equals("PTUSDO22021") ||	x.getTIPO_AUTORI().equals("PTUSDO32021") ||
	                	    x.getTIPO_AUTORI().equals("PTUSDO42021") || x.getTIPO_AUTORI().equals( "PTUSDO52020") ||
	                	    x.getTIPO_AUTORI().equals("PTU2021100")  || x.getTIPO_AUTORI().equals("PTU2021105")  ||
	                	    x.getTIPO_AUTORI().equals("PTU2021110")  || x.getTIPO_AUTORI().equals("CREDNOM2021"))
	                		.collect(Collectors.groupingBy(RegAutoTasasBEResponseDTO::getESTATUS, Collectors.counting()));
	                	
	        Iterator it = result.keySet().iterator();
	        while(it.hasNext()){
	        	Object key =  it.next();
	        	System.out.println("Clave: " + key + " -> Valor: " + result2.get(key));
	        	listaDatos.add(new Data_ChartBEResponSeDTO(key.toString(), result2.get(key)));
	        }
	                	
	        dibujarChartResponseDTO.add(new DibujarChartResponseDTO("ChartEstatus2",
	        	    "bar",
	        	    "Por Estatus",
	        	    false,
	        	    "right",
	        	    "Campaña PTU2021 gana por Estatus",
	        	    0.75,
	        	    false, 
	        	    listaDatos));        			
	        }
			
		}else if(request.getTipo().equals("EXCEPGER por Estatus")) {
			if (listaSolicitudes.stream().filter(x -> x.getTIPO_AUTORI().equals("EXCEPGER")).count() > 0)
            {
               /* 

                DibujarChart("ChartEstatus1", "bar", "Por Estatus", false, "right", "Especiales por Estatus", 0.75, false, listaDatos);*/
	        	Map<String, List<RegAutoTasasBEResponseDTO>> result =  listaSolicitudes.stream()
	        			.filter(x-> x.getTIPO_AUTORI().equals("EXCEPGER"))
	        			.collect(Collectors.groupingBy(RegAutoTasasBEResponseDTO::getESTATUS));
	        	
	        	Map<String, Long> result2 =  listaSolicitudes.stream()
	        			.filter(x-> x.getTIPO_AUTORI().equals("EXCEPGER"))
	        			.collect(Collectors.groupingBy(RegAutoTasasBEResponseDTO::getESTATUS, Collectors.counting()));
	        	
	        	Iterator it = result.keySet().iterator();
		    	while(it.hasNext()){
		    	  Object key =  it.next();
		    	  System.out.println("Clave: " + key + " -> Valor: " + result2.get(key));
		    	  listaDatos.add(new Data_ChartBEResponSeDTO(key.toString(), result2.get(key)));
		    	}
	        	
		    	dibujarChartResponseDTO.add(new DibujarChartResponseDTO("ChartEstatus1",
		    			"bar",
		    			"Por Estatus",
		    			false,
		    			"right",
		    			"Especiales por Estatus",
		    			0.75,
		    			false, 
		    			listaDatos));
				
            }
			
		}
////////////////

        
		////////////////
        
  
        ////////////////

	} catch (Exception e) {
		e.printStackTrace();
		throw new GenericException("Error :: ",
				HttpStatus.NOT_FOUND.toString());
    }
	return dibujarChartResponseDTO;
}

	public RegAutoTasasBEResponseDTO TipoSolicitudToDto (AutoTasasOnLineGerencia t) {
		SimpleDateFormat objSDF2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		RegAutoTasasBEResponseDTO responce = new RegAutoTasasBEResponseDTO(t.getID_TASAUTO(),
				objSDF2.format(t.getFECHA_SOLIC()).toString(), 
				objSDF2.format(t.getFECHA_AUTORI()).toString(), 
				objSDF2.format(t.getFECHA_ESTATUS()).toString(), 
				t.getESTATUS(),
				t.getSUC_SOLIC(),
				t.getPLAZO(),
				t.getTASA_AUTORI(),
				t.getTIPO_AUTORI(),
				t.getSOEID_AUTORI(),
				t.getSOEID_ASIG(),
				t.getSOEID_OPE(),
				t.getNUM_AUTORI_UEC(),
				0,
				"");
	
		return responce;
	}  //Data_ChartBEResponSeDTO


	public List<SucursalGerenciaResponseDTO> ObtenerVistaCampanaporDivisionObtener(AutoTasaGerenciaBEDTO request)throws GenericException, IOException {
		List<SucursalGerenciaResponseDTO> autoTasaGerenciaResponseDTO = new ArrayList<SucursalGerenciaResponseDTO>();
		try{
			double CantEjec =0;
			double CantSuc =0;
			double CantSucSinVentas =0;
			double CantSucConVentas =0;
			
				LOGGER.debug("entro" );
				
				if(!request.isIs_ejec_priority()) {
					listSucursal = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivision(2);//falso
				}else {
					listSucursal = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivision(1);
				}

				if(request.getFecha_fin().isEmpty()){
					listAutoTasa = imprimirReporteOnLineRepo.ObtenerVistaCampanaporDivision(request.getCampana(),request.getFecha(),request.isIs_ejec_priority(),request.isIs_Premio(),request.isEnablePM());

				}else {
					listAutoTasa = imprimirReporteOnLineRepo.ObtenerVistaCampanaporDivisionAplicada(request.getCampana(),request.getFecha(),request.getFecha_fin(),request.isIs_ejec_priority(),request.isIs_Premio(),request.isEnablePM());

				}
				
				if(request.isEnablePM()) {
					if(request.getFecha_fin().isEmpty()){
						listSucursalA = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivisionConVentas(request.getFecha(), request.getCampana());//falso
					}else {
						listSucursalA = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivisionConVentasAplicada(request.getFecha(), request.getFecha_fin() ,request.getCampana());
					}
				}else {
					if(request.getFecha_fin().isEmpty()){
						listSucursalA = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivisionConVentas2(request.getFecha(), request.getCampana());

					}else{
						listSucursalA = sucursalGerenciaRepo.ObtenerSucursalesAgrupadasEnCampanaPorDivisionConVentas2Aplicada(request.getFecha() , request.getFecha_fin(), request.getCampana());

					}

				}
		        int rk = 1;
				for(AutoTasaGerencia aut : listAutoTasa) {	
					
					CantEjec  = Double.parseDouble(listSucursal.stream()
							  .filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
					          .map(x -> x.getCantejec()).findFirst().get());
					 LOGGER.debug("dentro reg CantEjec" +CantEjec);
					CantSuc  = Double.parseDouble(listSucursal.stream()
							  .filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
					          .map(x -> x.getCantsuc()).findFirst().get());
		      /*  	CantEjecV = listSucursal.stream()
								.filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
						        .mapToDouble(x -> x.getCantejec())
						        .boxed().collect(Collectors.toList());
	        		CantSucV  = listSucursal.stream()
								.filter(x ->x.getDIVISION_NOMBRE().equals(aut.getDIVISION()))
						        .mapToDouble(x -> x.getCantsuc())
						        .boxed().collect(Collectors.toList());
		        		
		        if(listSucursalA.size() == 0) {
		        	CantSuc_v = CantSuc.stream().findFirst().get().doubleValue();
			    }else {
			        CantEjec_v = CantEjecV.stream().findFirst().get().doubleValue();
			        CantSuc_v = CantSucV.stream().findFirst().get().doubleValue();
			    }
	        	if(CantEjec.stream().findFirst().get().doubleValue()> 0) {
	        		LOGGER.debug("?"+ Per_Capita );
	        		Per_Capita = (aut.getVENTAS()) / (CantEjec.stream().findFirst().get().doubleValue());
	        	}else {
	        		LOGGER.debug("?"+ Per_Capita );
	        		Per_Capita = 0;
	        		
	        	}*/
				autoTasaGerenciaResponseDTO.add(new SucursalGerenciaResponseDTO(aut.getDIVISION(),
	        		aut.getVENTAS(), 
	        		aut.getMONTO(), 
	        		aut.getMONTOVENTAS(), 
	        		CantSuc, 
	        		CantEjec, 
	        		0, 
	        		0, 
	        		(aut.getVENTAS()/CantEjec), 
	        		rk));
				rk++;
	            }
				
				for(SucursalGerenciaResponseDTO t : autoTasaGerenciaResponseDTO ) {
					if(listSucursalA.stream().filter(x-> x.getDIVISION_NOMBRE().equals(t.getDIVISION())).count() >0) {
						t.setCantSucSinVentas(t.getCantsuc() - Double.parseDouble(listSucursalA.stream().filter(x-> x.getDIVISION_NOMBRE().equals(t.getDIVISION())).map(x-> x.getCantsuc()).findFirst().get()));
						t.setCantSucConVentas(Double.parseDouble(listSucursalA.stream().filter(x-> x.getDIVISION_NOMBRE().equals(t.getDIVISION())).map(x-> x.getCantsuc()).findFirst().get()));
					}else {
						t.setCantSucSinVentas(t.getCantsuc());
					}
					
				}
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		LOGGER.debug(listAutoTasa.size());
		return autoTasaGerenciaResponseDTO.stream().sorted(Comparator.comparingDouble(SucursalGerenciaResponseDTO ::getRK)).collect(Collectors.toList());
	}



	@Override
	public List<ReportDataSource> ImprimirReporteOnLine(AutoTasaGerenciaBEDTO request)
			throws GenericException, IOException {
List<ReportDataSource> reportDataSource = new ArrayList<ReportDataSource>();
		
        String 
        campana = "'"+request.getCampana()+"'";
        request.setCampana(campana);
        //listMontVent2= autoTasaMontoVolumenGerenciaRepository.ObtenerVistaCampanaporDivision(fecha_inicio, fecha_fin, false);
		List<SucursalGerenciaResponseDTO> autoTasaDivisiones = ObtenerVistaCampanaporDivisionObtener(request);
		System.out.println("1entro dis "+autoTasaDivisiones.size() );
		List<SucursalGerenciaResponseDTO> ListaVistaDivisionesCam1 = ObtenerVistaCampanaporDivisionObtener(request);
		
		List<SucursalGerenciaResponseDTO> autoTasaRegiones = ObtenerVistaCampanaporDirRegional(request);
		System.out.println("1entro reg "+autoTasaRegiones.size() );
		List<SucursalGerenciaResponseDTO> ListaVistaRegionesCam1 = ObtenerVistaCampanaporDirRegional(request);

		List<SucursalGerenciaResponseDTO> autoTasaSucursales = ObtenerVistaCampanaporSucursales(request);
		System.out.println("1entro suc  "+autoTasaSucursales.size() );
		List<SucursalGerenciaResponseDTO> ListaVistaSucursalesCam1 = ObtenerVistaCampanaporSucursales(request);
		
		


		try{
		    List<SucursalGerenciaResponseDTO> ListaVistaDivisiones;
			List<SucursalGerenciaResponseDTO> ListaVistaRegiones ;
			List<SucursalGerenciaResponseDTO> ListaVistaMercado ;
		    List<SucursalGerenciaResponseDTO> ListaVistaSucursales ;
			for(SucursalGerenciaResponseDTO item : autoTasaDivisiones ) {

				if(ListaVistaDivisionesCam1.stream().filter(x-> x.getDIVISION().equals(item.getDIVISION())).count() >0) {
					
					item.setVentaImporte(new SucursalGerenciaVentasResponseDTO(ListaVistaDivisionesCam1.stream().filter(x-> x.getDIVISION().equals(item.getDIVISION())).mapToDouble(x-> x.getVENTAS()).findFirst().getAsDouble(), 
							ListaVistaDivisionesCam1.stream().filter(x-> x.getDIVISION().equals(item.getDIVISION())).mapToDouble(x-> x.getMONTO()).findFirst().getAsDouble()));
					
				}else {
					item.setVentaImporte(new SucursalGerenciaVentasResponseDTO(0, 0));
				}
			}
			

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			for(SucursalGerenciaResponseDTO item2 : autoTasaRegiones){
				
				if(ListaVistaRegionesCam1.stream().filter(x-> x.getDIVISION().equals(item2.getDIVISION())).count() >0) {
					
					item2.setVentaImporte(new SucursalGerenciaVentasResponseDTO(ListaVistaRegionesCam1.stream().filter(x-> x.getDIVISION().equals(item2.getDIVISION())).mapToDouble(x-> x.getVENTAS()).findFirst().getAsDouble(), 
							ListaVistaRegionesCam1.stream().filter(x-> x.getDIVISION().equals(item2.getDIVISION())).mapToDouble(x-> x.getMONTO()).findFirst().getAsDouble()));

				}else {
					item2.setVentaImporte(new SucursalGerenciaVentasResponseDTO(0, 0));
				}
			
			}
			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			
			for(SucursalGerenciaResponseDTO item3 : autoTasaSucursales){
				
				if(ListaVistaSucursalesCam1.stream().filter(x-> x.getSuc().equals(item3.getSuc())).count() >0) {		
					item3.setVentaImporte(new SucursalGerenciaVentasResponseDTO(ListaVistaSucursalesCam1.stream().filter(x-> x.getSuc().equals(item3.getSuc())).mapToDouble(x-> x.getVENTAS()).findFirst().getAsDouble(), 
							ListaVistaSucursalesCam1.stream().filter(x-> x.getSuc().equals(item3.getSuc())).mapToDouble(x-> x.getMONTO()).findFirst().getAsDouble()));
				}else {
					item3.setVentaImporte(new SucursalGerenciaVentasResponseDTO(0, 0));
				}
				
			}	
			List<SucursalGerenciaResponseSumaDTO> calculo = new ArrayList<SucursalGerenciaResponseSumaDTO>();
			calculo.add(new SucursalGerenciaResponseSumaDTO("autoTasaDivisiones",autoTasaDivisiones.stream().mapToDouble(x-> x.getVENTAS()).sum(),
					autoTasaDivisiones.stream().mapToDouble(x-> x.getMONTO()).sum(), 
					autoTasaDivisiones.stream().mapToDouble(x-> x.getMONTOVENTAS()).sum(), 
					autoTasaDivisiones.stream().mapToDouble(x-> x.getCantsuc()).sum(),  
					autoTasaDivisiones.stream().mapToDouble(x-> x.getCantejec()).sum(), 
					autoTasaDivisiones.stream().mapToDouble(x-> x.getCantSucSinVentas()).sum(), 
					autoTasaDivisiones.stream().mapToDouble(x-> x.getCantSucConVentas()).sum(), 
					autoTasaDivisiones.stream().mapToDouble(x-> x.getPer_Capita()).sum(),  
					autoTasaDivisiones.stream().mapToDouble(x-> x.getVentaImporte().getCantVentasCam()).sum(),  
					autoTasaDivisiones.stream().mapToDouble(x-> x.getVentaImporte().getVentasCam()).sum()));
		
			calculo.add(new SucursalGerenciaResponseSumaDTO("autoTasaSucursales",autoTasaSucursales.stream().mapToDouble(x-> x.getVENTAS()).sum(),
					autoTasaSucursales.stream().mapToDouble(x-> x.getMONTO()).sum(), 
					autoTasaSucursales.stream().mapToDouble(x-> x.getMONTOVENTAS()).sum(), 
					autoTasaSucursales.stream().mapToDouble(x-> x.getCantsuc()).sum(),  
					autoTasaSucursales.stream().mapToDouble(x-> x.getCantejec()).sum(), 
					autoTasaSucursales.stream().mapToDouble(x-> x.getCantSucSinVentas()).sum(), 
					autoTasaSucursales.stream().mapToDouble(x-> x.getCantSucConVentas()).sum(), 
					autoTasaSucursales.stream().mapToDouble(x-> x.getPer_Capita()).sum(),  
					autoTasaSucursales.stream().mapToDouble(x-> x.getVentaImporte().getCantVentasCam()).sum(),  
					autoTasaSucursales.stream().mapToDouble(x-> x.getVentaImporte().getVentasCam()).sum()));
			
			calculo.add(new SucursalGerenciaResponseSumaDTO("autoTasaRegiones",autoTasaRegiones.stream().mapToDouble(x-> x.getVENTAS()).sum(),
					autoTasaRegiones.stream().mapToDouble(x-> x.getMONTO()).sum(), 
					autoTasaRegiones.stream().mapToDouble(x-> x.getMONTOVENTAS()).sum(), 
					autoTasaRegiones.stream().mapToDouble(x-> x.getCantsuc()).sum(),  
					autoTasaRegiones.stream().mapToDouble(x-> x.getCantejec()).sum(), 
					autoTasaRegiones.stream().mapToDouble(x-> x.getCantSucSinVentas()).sum(), 
					autoTasaRegiones.stream().mapToDouble(x-> x.getCantSucConVentas()).sum(), 
					autoTasaRegiones.stream().mapToDouble(x-> x.getPer_Capita()).sum(),  
					autoTasaRegiones.stream().mapToDouble(x-> x.getVentaImporte().getCantVentasCam()).sum(),  
					autoTasaRegiones.stream().mapToDouble(x-> x.getVentaImporte().getVentasCam()).sum()));
			calculo.add(new SucursalGerenciaResponseSumaDTO("autoTasaMercado",autoTasaRegiones.stream().mapToDouble(x-> x.getVENTAS()).sum(),
					autoTasaRegiones.stream().mapToDouble(x-> x.getMONTO()).sum(), 
					autoTasaRegiones.stream().mapToDouble(x-> x.getMONTOVENTAS()).sum(), 
					autoTasaRegiones.stream().mapToDouble(x-> x.getCantsuc()).sum(),  
					autoTasaRegiones.stream().mapToDouble(x-> x.getCantejec()).sum(), 
					autoTasaRegiones.stream().mapToDouble(x-> x.getCantSucSinVentas()).sum(), 
					autoTasaRegiones.stream().mapToDouble(x-> x.getCantSucConVentas()).sum(), 
					autoTasaRegiones.stream().mapToDouble(x-> x.getPer_Capita()).sum(),  
					autoTasaRegiones.stream().mapToDouble(x-> x.getVentaImporte().getCantVentasCam()).sum(),  
					autoTasaRegiones.stream().mapToDouble(x-> x.getVentaImporte().getVentasCam()).sum()));
			
			
			System.out.println("stream  "+autoTasaSucursales.stream().mapToDouble(x-> x.getMONTO()).sum() );
			///////////////////////////////
			ListaVistaRegiones =autoTasaRegiones;
			ListaVistaMercado = ListaVistaRegiones;

			
			ListaVistaSucursales = autoTasaSucursales;
			ListaVistaDivisiones =autoTasaDivisiones;
			System.out.println("1entro dis4 "+calculo.size() );
			for(SucursalGerenciaResponseSumaDTO g : calculo) {
				
				System.out.println("1entfr "+g.getCantejec() );
			}
			
			reportDataSource.add(new ReportDataSource(ListaVistaDivisiones,
					ListaVistaRegiones, 
					ListaVistaMercado, 
					ListaVistaSucursales,
					calculo));
			
		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return reportDataSource;
	}



	@Override
	public void lnkGenReporteAcumulado_Click() throws GenericException, IOException {
		// TODO Auto-generated method stub
		
		List<ReporteDivisionesBEResponseDTO> listaPorDivision = new ArrayList<ReporteDivisionesBEResponseDTO>();
		
		List<CampGerenciaResponseDTO> listaCamp =ObtenerListaCampanas().stream().filter(x-> x.getActivo().equals("1")).collect(Collectors.toList()); // c
		
		List<AutoTasaAcomuladoCampGerenciaResponseDTO> listaRegistros = ObtenerRegistrosAcumuCamp();//c
		EjecutivosPriorityGerenciaBEDTO request = null;
		List<EjecutivosPriorityGerenciaResponseDTO> listaPorEjPriorityAll =  ObtenerEjecutivosPriority(request);//c; no ll
		
		List<EjecutivosPriorityVentaGerenciaResponseDTO> listaPorEjPriority = new ArrayList<EjecutivosPriorityVentaGerenciaResponseDTO>(); //c
		List<EjecutivosPriorityVentaGerenciaResponseDTO> cargar = ObtenerEjecutivosPriorityConVentas(request); // si ll
		List<EjecutivosPrioritySinVentaGerenciaResponseDTO> cargar2 = ObtenerEjecutivosPrioritySinVentas(request); // si ll
		
		for(EjecutivosPriorityVentaGerenciaResponseDTO PorEjPriority : cargar.stream().sorted(Comparator.comparing(EjecutivosPriorityVentaGerenciaResponseDTO::getSUB_TOTAL)).collect(Collectors.toList())) {
			listaPorEjPriority.add(new EjecutivosPriorityVentaGerenciaResponseDTO(PorEjPriority.getDIVISION(),
					PorEjPriority.getDISTRITO(),
					PorEjPriority.getSuc(),
					PorEjPriority.getNOMINA(),
					PorEjPriority.getNOMBRE(),
					PorEjPriority.getFECHA(),
					PorEjPriority.getSUB_TOTAL(),
					PorEjPriority.getIMPORTE(), 
					PorEjPriority.getCAMPANA()));
			for(EjecutivosPrioritySinVentaGerenciaResponseDTO PorEjPriority2 : cargar2) {
				listaPorEjPriority.add(new EjecutivosPriorityVentaGerenciaResponseDTO(PorEjPriority2.getDIVISION(),
						PorEjPriority2.getDISTRITO(),
						PorEjPriority2.getSuc(),
						PorEjPriority2.getNOMINA(),
						PorEjPriority2.getNOMBRE(),
						PorEjPriority2.getFECHA(),
						null,
						null, 
						PorEjPriority2.getCAMPANA()));	
			}
			
			for(EjecutivosPriorityGerenciaResponseDTO ejecutivo :listaPorEjPriorityAll) {
				
				if(listaPorEjPriority.stream().filter(x-> x.getNOMINA() == ejecutivo.getNOMINA()).count() == 0) {
					
					listaPorEjPriority.add(new EjecutivosPriorityVentaGerenciaResponseDTO(PorEjPriority.getDIVISION(),
							PorEjPriority.getDISTRITO(),
							PorEjPriority.getSuc(),
							PorEjPriority.getNOMINA(),
							PorEjPriority.getNOMBRE(),
							PorEjPriority.getFECHA(),
							PorEjPriority.getSUB_TOTAL(),
							PorEjPriority.getIMPORTE(), 
							PorEjPriority.getCAMPANA()));
				}
				
			}
			
		}
		
		AutoTasaGerenciaBEDTO  requestA= null;
		List<CampanaGerenciaResponseDTO> ObtenerlistaEAV = ObtenerlistaEAV(requestA).stream().sorted(Comparator.comparing(CampanaGerenciaResponseDTO::getSUB_TOTAL)).collect(Collectors.toList());// si ll
        
		List<ObtenerlistaEjecutivosNoLocalizablesResponseDTO> listaEjecNoLocalizables = ObtenerlistaEjecutivosNoLocalizables(); //c //no ll
		EjecutivosPriorityGerenciaBEDTO requesth = null; 
		Long Dias_Habiles = ObtenerDiasHabiles( request);// c //si ll
		EjecutivosPriorityGerenciaBEDTO requestm = null;
		String fecha_max = ObtenerFechaMaxima (requestm); 
		
		List<ObtenerTotalEjecutivosDivisionResponseDTO> listaDivisionTotalesEjecutivos = ObtenerTotalEjecutivosDivision();
        Long  TotalEjecutivos = listaDivisionTotalesEjecutivos.stream().mapToLong(x-> x.getNUM_EJECUTIVO()).sum();
        		
     //  List<AutoTasaAcomuladoCampGerenciaResponseDTO> listaRegistros = new  ArrayList<AutoTasaAcomuladoCampGerenciaResponseDTO>();
       

       //listaPorDivision
       Map<String, List<AutoTasaAcomuladoCampGerenciaResponseDTO>> result = listaRegistros.stream()
   		    .collect(Collectors.groupingBy(AutoTasaAcomuladoCampGerenciaResponseDTO::getDIVICION));
   	
       Map<String,Long> result2 = listaRegistros.stream()
    		   .collect(Collectors.groupingBy(AutoTasaAcomuladoCampGerenciaResponseDTO::getDIVICION, Collectors.summingLong(x-> x.getNUM_VENTAS())));

       Map<String,Long> result3 = listaRegistros.stream()
    		   .collect(Collectors.groupingBy(AutoTasaAcomuladoCampGerenciaResponseDTO::getDIVICION, Collectors.summingLong(x-> x.getMONTO())));
       
       Iterator it = result.keySet().iterator();
   	   while(it.hasNext()){
   		   Object key =  it.next();
   	//	   double d = result2.get(key);
//   		   System.out.println("Clave: " + key.toString() + " -> Valor: " + d);
   		   listaPorDivision.add(new ReporteDivisionesBEResponseDTO("0",
   				   key.toString(),
   				"0", 
   				   result2.get(key).toString(),
   				   result3.get(key).toString(), "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"));
       }
   	   
       for(ReporteDivisionesBEResponseDTO item :listaPorDivision) {
    	   
 /*   	   item.setNum_ejecutivos( listaRegistros.stream()
    			   .filter(x-> !x.getTIPO_DISPOSITIVO().startsWith("SEC") && !x.getTIPO_DISPOSITIVO().equals("MOD RESTRING") && x.getDIVICION().equals(item.getDivision()))
    			   .mapToLong(s-> s.getSIRH()).distinct().sum()+
    			   listaRegistros.stream()
    			   .filter(x-> !x.getTIPO_DISPOSITIVO().startsWith("SEC") && !x.getTIPO_DISPOSITIVO().equals("MOD RESTRING") && x.getDIVICION().equals(item.getDivision()))
    			   .mapToLong(s-> s.getNUM_EJECUTIVO()).distinct().sum());
    			   
    	   */

       }

    	
		
	//	listaPorEjPriority = listaPorEjPriority.stream().sorted(Comparator.comparing(EjecutivosPriorityVentaGerenciaResponseDTO::getSUB_TOTAL)).collect(Collectors.toList());
		
		
	}
	

	
}
