package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.infra.dto.Cat_SucBEDTO;
import com.citi.euces.sitiouec.infra.dto.AutoTasaSoeidDTO;
import com.citi.euces.sitiouec.infra.dto.Cat_AsignacionBEDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

@Repository
public class solicitudCampanaJDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(solicitudCampanaJDBCRepository.class);
	
	public solicitudCampanaJDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public List<Cat_AsignacionBEDTO> ObtenerAsignaciones() throws GenericException {

		try {
			String sql = "SELECT soeid, online_ FROM UEC_TB_ASIGNACIONES";

			System.out.println("QUERY_SQL_ ObtenerAsignaciones :: ejecute:: " + sql);

			return jdbcTemplate.query(sql,
					(rs, rowNum) -> new Cat_AsignacionBEDTO(rs.getString("SOEID"), rs.getInt("ONLINE_")));

		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al ejecutar ObtenerAsignaciones :: ", HttpStatus.NOT_FOUND.toString());
		}
	}
	
	@Transactional
	public List<AutoTasaSoeidDTO> ObtenerUltSoeidAsignado(Long idMax) throws GenericException {
		try {
			String sql = "SELECT SOEID_ASIG FROM UEC_TB_AUTOTASAS where ID_TASAUTO = " + idMax;

			System.out.println("QUERY_SQL_ ObtenerAsignaciones :: ejecute:: " + sql);

			return jdbcTemplate.query(sql, (rs, rowNum) -> new AutoTasaSoeidDTO(rs.getString("SOEID_ASIG")));

		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al ejecutar ObtenerUltSoeidAsignado :: ",
					HttpStatus.NOT_FOUND.toString());
		}
	}

	@Transactional
	public List<AutoTasaSoeidDTO> ObtenerUltSoeidAsignadoMAX_ID() throws GenericException {
		try {
			String sql = "SELECT max(ID_TASAUTO) as max FROM UEC_TB_AUTOTASAS where SOEID_ASIG is not null";

			System.out.println("QUERY_SQL_ ObtenerUltSoeidAsignadoMAX_ID :: ejecute:: " + sql);

			return jdbcTemplate.query(sql, (rs, rowNum) -> new AutoTasaSoeidDTO(rs.getLong("max")));

		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al ejecutar ObtenerUltSoeidAsignado :: ",
					HttpStatus.NOT_FOUND.toString());
		}
	}
	
	@Transactional
	public List<Cat_SucBEDTO> GetItem(Long NUM_CTE) throws GenericException {
		try {

			String sql = "SELECT SIRH_SUCURSAL_ID, NOMBRE_SUCURSAL, DIVISION_ID, DIVISION_NOMBRE, DISTRITO_ID, DISTRITO_NOMBRE, EJECUTIVO_EAV, EJECUTIVO_PRIORITY, IS_CLOSE "
					+ "FROM PER_CAT_SUCURSALES where SIRH_SUCURSAL_ID = " + NUM_CTE;

			System.out.println("QUERY_SQL_ GetItem :: ejecute:: " + sql);

			return jdbcTemplate.query(sql,
					(rs, rowNum) -> new Cat_SucBEDTO(rs.getLong("SIRH_SUCURSAL_ID"), rs.getString("NOMBRE_SUCURSAL"), rs.getString("DIVISION_ID"),
							rs.getString("DIVISION_NOMBRE"), rs.getString("DISTRITO_ID"), rs.getString("DISTRITO_NOMBRE"),
							rs.getString("EJECUTIVO_EAV"), rs.getString("EJECUTIVO_PRIORITY"), rs.getString("IS_CLOSE")));
		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al ejecutar GetItem :: ", HttpStatus.NOT_FOUND.toString());
		}
	}
}
