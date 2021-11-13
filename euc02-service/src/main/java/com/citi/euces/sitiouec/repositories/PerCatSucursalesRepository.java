package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.dto.PerCatSucursalesDTO;

@Repository
public class PerCatSucursalesRepository {
	
	private static final Logger LOGGER = LogManager.getLogger(TasasRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Transactional
	public List<PerCatSucursalesDTO> getDivisiones(String descripcion) {
		
		String sql =""
				+ "select Distinct DIVISION_NOMBRE "
				+ "from PER_CAT_SUCURSALES Where NOMBRE_SUCURSAL like '%" + descripcion + "%' order by DIVISION_NOMBRE";

		LOGGER.info("Query - Method -  DIVISION_NOMBRE" + " " + sql.toString());
		
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new PerCatSucursalesDTO(
						cc.getString("DIVISION_NOMBRE")
				));
	}
		
}
