package com.citi.euces.sitiouec.repositories;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.citi.euces.sitiouec.infra.dto.CatCampanaDTO;

@Repository
public class CatCampañasJDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(CatCampañasJDBCRepository.class);
	
	public CatCampañasJDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public List<CatCampanaDTO> obtenerCampana()
	{
		String sql =  " SELECT CAMPANIAS_ID, CAMPANIAS_NOMBRE"
				+ " FROM PER_CAT_CAMPANIAS"
                + " WHERE CAMPANIAS_ESTATUS = '1'";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new CatCampanaDTO (
                        cc.getString("CAMPANIAS_ID"),
                        cc.getString("CAMPANIAS_NOMBRE")
                )
        );
	}
}
