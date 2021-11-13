package com.citi.euces.sitiouec.services.api;

import java.text.ParseException;
import java.util.List;

import com.citi.euces.sitiouec.dto.ActualizarSoeidAtendidoDTO;
import com.citi.euces.sitiouec.dto.AsignacionesDTO;
import com.citi.euces.sitiouec.dto.AsignacionesInputDTO;
import com.citi.euces.sitiouec.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.dto.FechasInputDTO;
import com.citi.euces.sitiouec.dto.HistoricoAsignacionesDTO;
import com.citi.euces.sitiouec.dto.PetCatEjecutivoSucursalCampanaDTO;

public interface PetCatEjecutivoSucursalCampanaService {

	List<PetCatEjecutivoSucursalCampanaDTO> getEjecutivosSucursal(List<String> puestos);

	List<AsignacionesDTO> getAsignacionesEjecutivos(List<PetCatEjecutivoSucursalCampanaDTO> lsEjecutivosUEC);

	List<AutoTasasDTO> getAsignacionAutoTasas(List<AsignacionesInputDTO> lsEjecutivos) throws ParseException;

	public int insertarHistoricoAsignaciones(List<HistoricoAsignacionesDTO> lsAsignaciones) throws ParseException;

	public int actualizarAsignacionesInactivas(List<String> lsAsignacionesInactivas) throws ParseException;

	public int actualizarSoeidAsignadosSupervisor(List<ActualizarSoeidAtendidoDTO> lsSoeidAtendido) throws ParseException;
	
	List<HistoricoAsignacionesDTO> getHistoricoAsignacionesExcel (FechasInputDTO fechas);
	
	public int actualizarSoeidAsignaciones (Long online, String soeid,String nombre);
	
	AsignacionesDTO getEjecutivosUECAsignados(String soeid);
	
	public String calcularSoeidAsignadoNoAplica();
	
	

}
