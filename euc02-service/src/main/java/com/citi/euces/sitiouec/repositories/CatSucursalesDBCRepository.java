package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.infra.dto.CatSuc2021DTO;
import com.citi.euces.sitiouec.infra.dto.DivisionDTO;
import com.citi.euces.sitiouec.infra.dto.RegionesDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

@Repository
public class CatSucursalesDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(CatSucursalesDBCRepository.class);
	
	public CatSucursalesDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public List<RegionesDTO> obtenerRegiones(String division)
	{
		String sql = "SELECT DISTINCT DISTRITO_NOMBRE "
					+ " FROM PER_CAT_SUCURSALES ";
		sql += division.isEmpty() ? "" : " WHERE DIVISION_NOMBRE LIKE '" + division + "' " ;
		sql += " ORDER BY DISTRITO_NOMBRE";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new RegionesDTO (
//                        cc.getLong("SIRH_SUCURSAL_ID"),
//                        cc.getString("DIVISION_NOMBRE"),
                        cc.getString("DISTRITO_NOMBRE")
                )
        );
	}
	
	
	@Transactional
	public List<DivisionDTO> obtenerDivisiones()
	{
		String sql = "SELECT DISTINCT DIVISION_NOMBRE FROM PER_CAT_SUCURSALES WHERE NOMBRE_SUCURSAL LIKE '%'";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new DivisionDTO (
                        cc.getString("DIVISION_NOMBRE")
                )
        );
	}
	
	
	@Transactional
	public List<CatSuc2021DTO> selectAll()
	{
		String sql = "SELECT SIRH_SUCURSAL_ID, NOMBRE_SUCURSAL, DIVISION_NOMBRE FROM PER_CAT_SUCURSALES";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new CatSuc2021DTO (
                        cc.getInt("SIRH_SUCURSAL_ID"),
                        cc.getString("NOMBRE_SUCURSAL"),
                        cc.getString("DIVISION_NOMBRE")
                )
        );
	}
	
	
	@Transactional
    public String obtieneDivision(Integer div) throws GenericException {
        try {
        	String id = jdbcTemplate.queryForObject("SELECT DIVISION_NOMBRE FROM PER_CAT_SUCURSALES WHERE SIRH_SUCURSAL_ID = " + div, String.class);
            if (id == null) {
                id = "NA";
            }
            log.info("Division: " + id + " , Suc Solic: " + div);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener la division :: PER_CAT_SUCURSALES ", HttpStatus.NOT_FOUND.toString());
        }

    }
	
	
	@Transactional
    public String obtieneSucursalesPorSuc(Integer sucSolic) throws GenericException {
        try {
        	String id = jdbcTemplate.queryForObject("SELECT SIRH_SUCURSAL_ID || ' - ' || NOMBRE_SUCURSAL || ' - ' || DIVISION_NOMBRE SUC FROM PER_CAT_SUCURSALES WHERE SIRH_SUCURSAL_ID = " + sucSolic, String.class);
            if (id == null) {
                id = "NA";
            }
            log.info("Suc Solic: " + sucSolic);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener la division :: PER_CAT_SUCURSALES ", HttpStatus.NOT_FOUND.toString());
        }

    }
}
