package com.citi.euces.sitiouec.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.dto.ActualizarSoeidAtendidoDTO;
import com.citi.euces.sitiouec.dto.AsignacionesDTO;
import com.citi.euces.sitiouec.dto.AsignacionesRevolverDTO;
import com.citi.euces.sitiouec.dto.FechasInputDTO;
import com.citi.euces.sitiouec.dto.HistoricoAsignacionesDTO;
import com.citi.euces.sitiouec.dto.PetCatEjecutivoSucursalCampanaDTO;
import com.citi.euces.sitiouec.entities.Asignaciones;

@Repository
public class PetCatEjecSucuCampanaRepository {

	private static final Logger LOGGER = LogManager.getLogger(PetCatEjecSucuCampanaRepository.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AsignacionesRepository asignacionesRepository;

	@Transactional
	public List<PetCatEjecutivoSucursalCampanaDTO> getEjecutivosSucursal(List<String> puestos) {

		String inSql = String.join(",", Collections.nCopies(puestos.size(), "?"));

		LOGGER.info("sql :: method :: getEjecutivosSucursal " + " " + inSql.toString());

		List<PetCatEjecutivoSucursalCampanaDTO> ejecutivoDTO = jdbcTemplate.query(
				String.format("SELECT * FROM PER_CAT_EJECUTIVO_SUCURSAL " + "WHERE SOIED in (%s)", inSql),
				puestos.toArray(),
				(cc, rowNum) -> new PetCatEjecutivoSucursalCampanaDTO(cc.getString("SOIED"), cc.getLong("NOMINA"),
						cc.getString("NOMBRE"), cc.getLong("SIRH_SUCURSAL"), cc.getString("PUESTO_TIPO"),
						cc.getString("PRIORITY_")));

		LOGGER.info("ejecutivoDTO :: method :: getEjecutivosSucursal " + " " + ejecutivoDTO.toString());

		LOGGER.info("size() :: method :: getEjecutivosSucursal " + " " + ejecutivoDTO.size());
		return ejecutivoDTO;

	}

	@Transactional
	public List<AsignacionesDTO> getAsignacionesEjecutivos(List<String> asignaciones) {

		String inSql = String.join(",", Collections.nCopies(asignaciones.size(), "?"));

		LOGGER.info("sql :: method :: getAsignacionesEjecutivos " + " " + inSql.toString());

		List<AsignacionesDTO> asignacionesDTO = jdbcTemplate.query(
				String.format("SELECT * FROM UEC_TB_ASIGNACIONES" + " WHERE ONLINE_=1 AND SOEID in (%s)", inSql),
				asignaciones.toArray(), (cc, rowNum) -> new AsignacionesDTO(cc.getString("ID"), cc.getString("SOEID"),
						cc.getLong("ONLINE_"), cc.getString("NOMBRE")));

		LOGGER.info("ejecutivoDTO :: method :: getAsignacionesEjecutivos " + " " + asignacionesDTO.toString());

		LOGGER.info("size() :: method :: getAsignacionesEjecutivos " + " " + asignacionesDTO.size());

		return asignacionesDTO;

	}

	@Transactional
	public List<HistoricoAsignacionesDTO> getHistoricoAsignaciones(List<ActualizarSoeidAtendidoDTO> lsSoeidAtendido) {

		String sql = "";

		HistoricoAsignacionesDTO historico = new HistoricoAsignacionesDTO();
		List<HistoricoAsignacionesDTO> lsHistorico = new ArrayList<>();

		for (ActualizarSoeidAtendidoDTO historicoAsignacionesDTO : lsSoeidAtendido) {

			sql = "SELECT * FROM UEC_TB_HISTORICO_ASIGNACIONES where " + "ID_TASAUTO='"
					+ historicoAsignacionesDTO.getIdTasaAuto() + "'";

			LOGGER.info("sql :: method :: getHistoricoAsignaciones " + " " + sql.toString());

			historico = new HistoricoAsignacionesDTO();
			historico = jdbcTemplate.queryForObject(sql,
					(cc, rowNum) -> new HistoricoAsignacionesDTO(cc.getLong("ID_TASAUTO"), cc.getString("SOEID"),
							cc.getString("SOEID_ATENDIDO"), cc.getTimestamp("FECHA_SOLIC"),
							cc.getTimestamp("FECHA_DESC"), cc.getLong("ESTATUS")));

			historico.setSoeidAtendido(historicoAsignacionesDTO.getSoiedAtendido());

			LOGGER.info("OBJETO ENCONTRADO getHistoricoAsignaciones " + " " + historico.toString());

			lsHistorico.add(historico);
		}

		LOGGER.info(
				"getHistoricoAsignaciones " + " Tamaño de la lista historicos encontrados" + " " + lsHistorico.size());

		return lsHistorico;

	}

	@Transactional
	public List<HistoricoAsignacionesDTO> getHistoricoAsignacionesExcel(FechasInputDTO fechas) {

		String sql = "SELECT ID_TASAUTO,FECHA_SOLIC,FECHA_DESC,SOEID_ATENDIDO,ESTATUS,SOEID"
				+ " FROM UEC_TB_HISTORICO_ASIGNACIONES where " + "trunc(FECHA_SOLIC)  BETWEEN  " + "TO_DATE('"
				+ fechas.getFechaInicial() + "','YYYY-MM-DD') AND TO_DATE('" + fechas.getFechaFinal()
				+ "','YYYY-MM-DD')";

		LOGGER.info("Query - Method -  getHistoricoAsignacionesExcel" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new HistoricoAsignacionesDTO(cc.getLong("ID_TASAUTO"), cc.getString("SOEID"),
						cc.getString("SOEID_ATENDIDO"), cc.getTimestamp("FECHA_SOLIC"), cc.getTimestamp("FECHA_DESC"),
						cc.getLong("ESTATUS")));
	}

	
	/**
	 * Si el operador esta en la tabla de asignaciones actualiza el estatus para que pueda recibir o no solicitudes.
	 * 
	 * Si el operador no esta en la tabla de asignaciones lo agrega con el estatus de 1 para que pueda recibir solicitudes.
	 * @param online
	 * @param soeid
	 * @param nombre
	 * @return
	 */
	@Transactional
	public int actualizarSoeidAsignaciones(Long online, String soeid, String nombre) {

		int res = 0;

		String sqlBusquedaMax = "Select max(ID) from uec_tb_asignaciones";

		Integer max = jdbcTemplate.queryForObject(sqlBusquedaMax, Integer.class);
		
		LOGGER.info("Query - Method -Select max(ID) from uec_tb_asignaciones" + " " + max);
		
		String sqlBusquedaSOEID = "Select count(ONLINE_) operaciones from uec_tb_asignaciones where Soeid = '" + soeid + "'";

		Integer operaciones = jdbcTemplate.queryForObject(sqlBusquedaSOEID, Integer.class);

		LOGGER.info("Query - Method - Select * from uec_tb_asignaciones where Soeid" + " " + operaciones);
		
		Asignaciones asignaciones = new Asignaciones();

		if (operaciones == 0) {
			
			if(max==null) {
				max=0;
			}
			
			LOGGER.info("Query - Method - actualizarSoeidAsignaciones - operaciones == 0 " + " " + operaciones);
			asignaciones.setId(String.valueOf(max + 1));
			asignaciones.setNombre(nombre);
			asignaciones.setOnline(Long.valueOf(1));
			asignaciones.setSoeid(soeid);

			try {
				asignacionesRepository.save(asignaciones);
				res = 1;
			} catch (Exception e) {
				LOGGER.error(
						"Error:: Inserta en la tabla de Asignaciones no encontro registro - " + " " + e.getMessage());
				LOGGER.error(
						"Error:: Inserta en la tabla de Asignaciones no encontro registro  - " + " " + e.getCause());
				LOGGER.error("Error:: Inserta en la tabla de Asignaciones no encontro registro  - " + " "
						+ e.getStackTrace());
			}

		} else {

			String sql = "update uec_tb_asignaciones Set ONLINE_=" + online + " Where Soeid = '" + soeid + "'";

			LOGGER.info("Query - Method -  actualizarSoeidAsignaciones" + " " + sql.toString());

			try {
				res = jdbcTemplate.update(sql);
				LOGGER.info("Query - Method -  res" + " " + res);
				res = 1;
			} catch (Exception e) {
				LOGGER.error("Error:: actualizarSoeidAsignaciones - " + " " + e.getMessage());
				LOGGER.error("Error:: actualizarSoeidAsignaciones - " + " " + e.getCause());
				LOGGER.error("Error:: actualizarSoeidAsignaciones - " + " " + e.getStackTrace());
			}

		}

		return res;
	}

	@Transactional
	public AsignacionesDTO getEjecutivosUECAsignados(String puesto) {

		String sql = "select ID,SOEID,ONLINE_,NOMBRE from uec_tb_asignaciones where ONLINE_ =1 AND SOEID = '" + puesto
				+ "'";

		LOGGER.info("Query - Method -  getEjecutivosUECAsignados" + " " + sql.toString());

		AsignacionesDTO asignaciones = new AsignacionesDTO();

		try {

			asignaciones = jdbcTemplate.queryForObject(sql, (cc, rowNum) -> new AsignacionesDTO(cc.getString("ID"),
					cc.getString("SOEID"), cc.getLong("ONLINE_"), cc.getString("NOMBRE")));

		} catch (Exception e) {
			LOGGER.error("Error:: getEjecutivosUECAsignados - " + " " + e.getMessage());
			LOGGER.error("Error:: getEjecutivosUECAsignados - " + " " + e.getCause());
			LOGGER.error("Error:: getEjecutivosUECAsignados - " + " " + e.getStackTrace());
		}

		LOGGER.info(
				"Query - Method -  getHistoricoAsignacionesExcel Objeto Encontrado " + " " + asignaciones.toString());

		return asignaciones;
	}
	
	
	@Transactional
	public List<AsignacionesRevolverDTO> obtenerAsignaciones() {

		String sql = "Select  soeid, online_ from uec_tb_asignaciones";

		LOGGER.info("Query - Method -  obtenerAsignaciones - Revolver" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new AsignacionesRevolverDTO(cc.getString("soeid"), cc.getLong("online_")));
	}	
		
	
	/**
	 * ObtenerUltSoeidAsignado
	 * 
	 */
	
	@Transactional
	public String obtenerUltSoeidAsignadoNoAplica() {
		
		String soeid="";
		
		String sql = "SELECT SOEID_ASIG FROM uec_tb_autotasas where ID_TASAUTO ="
				+ "(SELECT max(ID_TASAUTO) FROM uec_tb_autotasas where SOEID_ASIG is not null and SOEID_ASIG <> ' ')";
				
		try {
			soeid = jdbcTemplate.queryForObject(sql, String.class);	
			LOGGER.info("Query - Method -  Soeid Encontrado - SOEID_ASIG " + " " + sql.toString());
		} catch (Exception e) {
			LOGGER.info("Query - Method -  obtenerUltSoeidAsignado - Revolver " + " " + sql.toString());
			
		}
		
		
		
		return soeid;
		
		
	}
	
}
