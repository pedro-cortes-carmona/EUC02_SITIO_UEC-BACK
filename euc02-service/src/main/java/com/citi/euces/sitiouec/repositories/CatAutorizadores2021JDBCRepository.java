package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.infra.dto.AutDivisionalesDTO;
import com.citi.euces.sitiouec.infra.dto.DivisionDTO;

@Repository
public class CatAutorizadores2021JDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(CatAutorizadores2021JDBCRepository.class);
	
	public CatAutorizadores2021JDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public List<AutDivisionalesDTO> obtenerAutDivisionales(Integer idNivel, Integer alta,String autRegion, String division, String soeid)
	{
		String sql = "SELECT SOEID,DIVISION, DISTRISTO, NOMBRE,INIC,"
				+ "FECHA_INICIO,FECHA_TERMINO,ALTA,CORREO, ID_NIVEL_AUTO "
				+ "FROM UEC_CATALOGO_AUTORIZADORES2021 "
				+ "WHERE SOEID LIKE '" + soeid + "%' ";
		sql += idNivel != 0 ? " AND ID_NIVEL_AUTO = " + idNivel : "";
		sql += division.isEmpty() ? "" : " AND DIVISION LIKE '" + division + "' ";
		sql += autRegion.isEmpty() ? "" : " AND DISTRISTO LIKE '" + autRegion + "' ";
		sql += alta != 0 ? " AND ALTA = " + alta : "";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new AutDivisionalesDTO (
                        cc.getString("SOEID"),
                        cc.getString("DIVISION"),
                        cc.getString("DISTRISTO"),
                        cc.getString("NOMBRE"),
                        cc.getString("INIC"),
                        cc.getDate("FECHA_INICIO"),
                        cc.getDate("FECHA_TERMINO"),
                        cc.getInt("ALTA"),
                        cc.getString("CORREO"),
                        cc.getInt("ID_NIVEL_AUTO")
                )
        );
	}
}
