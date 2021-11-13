package com.citi.euces.sitiouec.services.api;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.citi.euces.sitiouec.dto.AutoTasaAcomuladoCampGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.AutoTasaAcomuladoCampGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.AutoTasaGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.AutoTasaMontoVolumenGerenciaRepoResponseBEDTO;
import com.citi.euces.sitiouec.dto.AutoTasaMontoVolumenGerenciaRepoResponseDTO;
import com.citi.euces.sitiouec.dto.AutoTasasOnLineGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.CampGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.CampanaGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.CampanaporSucursalesResponseDTO;
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
import com.citi.euces.sitiouec.dto.ObtenerVistaCampanaporDivisionResponseDTO;
import com.citi.euces.sitiouec.dto.ObtenerlistaEjecutivosNoLocalizablesResponseDTO;
import com.citi.euces.sitiouec.dto.ReportDataSource;
import com.citi.euces.sitiouec.dto.SucursalGerenciaRegionResponseDTO;
import com.citi.euces.sitiouec.dto.SucursalGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.SucursalRegionalGerenciaResponseDTO;
import com.citi.euces.sitiouec.dto.SucursalesAgrupadaGerenciaBEDTO;
import com.citi.euces.sitiouec.dto.SucursalesAgrupadaGerenciaResponseDTO;

import com.citi.euces.sitiouec.infra.exceptions.GenericException;


public interface ServiceMenuGerencia {
	
//	List<SucursalGerenciaResponseDTO>ObtenerVistaCampanaporDivision(AutoTasaGerenciaBEDTO request) throws GenericException, IOException;
	List<ReportDataSource>ObtenerVistaCampanaporDivision(AutoTasaGerenciaBEDTO request) throws GenericException, IOException;
	List<ReportDataSource>ImprimirReporteOnLine(AutoTasaGerenciaBEDTO request) throws GenericException, IOException;
	//List<SucursalRegionalGerenciaResponseDTO>ObtenerVistaCampanaporDirRegional(AutoTasaGerenciaBEDTO request) throws GenericException, IOException;
    List<SucursalesAgrupadaGerenciaResponseDTO>ObtenerSucursalesAgrupadasEnCampanaPorDivision(SucursalesAgrupadaGerenciaBEDTO request)throws GenericException, IOException;
 //   List<ObtenerVistaCampanaporSucursales>ObtenerVistaCampanaporSucursales(AutoTasaGerenciaBEDTO request)throws GenericException, IOException;
    List<AutoTasasOnLineGerenciaResponseDTO>ObtenerRegistrosAutoTasasOnLine()throws GenericException, IOException;
    List<String>ObtenerListaTodasCampanas()throws GenericException, IOException;
    String LeerInsumosReporteDiario (AutoTasaGerenciaBEDTO request)throws GenericException, IOException;
    String EliminarCargaAcumulado(AutoTasaAcomuladoCampGerenciaBEDTO request )throws GenericException, IOException;
    List<AutoTasaAcomuladoCampGerenciaResponseDTO> ObtenerRegistrosAcumuCamp()throws GenericException, IOException;
    List<EjecutivosPriorityGerenciaResponseDTO>ObtenerEjecutivosPriority(EjecutivosPriorityGerenciaBEDTO request)throws GenericException, IOException;
    List<EjecutivosPriorityVentaGerenciaResponseDTO>ObtenerEjecutivosPriorityConVentas(EjecutivosPriorityGerenciaBEDTO request)throws GenericException, IOException;
    List<EjecutivosPrioritySinVentaGerenciaResponseDTO>ObtenerEjecutivosPrioritySinVentas(EjecutivosPriorityGerenciaBEDTO request)throws GenericException, IOException;
    Long ObtenerDiasHabiles(EjecutivosPriorityGerenciaBEDTO request)throws GenericException, IOException;
    String ObtenerFechaMaxima(EjecutivosPriorityGerenciaBEDTO request)throws GenericException, IOException;
    List<ObtenerTotalEjecutivosDivisionResponseDTO>ObtenerTotalEjecutivosDivision()throws GenericException, IOException;
    List<ObtenerTotalEjecutivosRegionResponseDTO> ObtenerTotalEjecutivosRegion()throws GenericException, IOException;
    Long GetNumRegTbAcumuladoTasas(GetNumRegTbAcumuladoTasasGerenciaResponseBEDTO request)throws GenericException, IOException;
    List<CampanaGerenciaResponseDTO> ObtenerlistaEAV (AutoTasaGerenciaBEDTO request) throws GenericException, IOException;
    List<CampGerenciaResponseDTO> ObtenerListaCampanas () throws GenericException, IOException;
    List<ObtenerlistaEjecutivosNoLocalizablesResponseDTO> ObtenerlistaEjecutivosNoLocalizables()throws GenericException, IOException;
    List<SucursalGerenciaRegionResponseDTO> ObtenerVistaCampanaporGerMercado(AutoTasaGerenciaBEDTO request)throws GenericException, IOException;
    List<DibujarChartAgrupadoResponseDTO> ObtenerMontoVolumenPorDiaCampanaProcesada(AutoTasaMontoVolumenGerenciaRepoResponseBEDTO request)throws GenericException, IOException;
    List<DibujarChartResponseDTO> LoadCharts(DibujarChartResponseBEDTO request)throws GenericException, IOException;
    void lnkGenReporteAcumulado_Click()throws GenericException, IOException;
    
    
}
