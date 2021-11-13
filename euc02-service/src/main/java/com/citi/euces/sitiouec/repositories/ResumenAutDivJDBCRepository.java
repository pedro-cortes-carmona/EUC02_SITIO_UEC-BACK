package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.infra.dto.ResumenAutDivDTO;

@Repository
public class ResumenAutDivJDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(ResumenAutDivJDBCRepository.class);
	
	public ResumenAutDivJDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public List<ResumenAutDivDTO> obtenerRegistros(String fecha1, String fecha2)
	{
		String sql =  " SELECT Division, TIPO_AUTORI AS Campana, COUNT(*) AS Operaciones, NVL(SUM(Monto),0) AS Monto, NVL(AVG(TASA_AUTORI),0) AS Tasa_Prom, NVL(AVG(Porcen_CETE),0) AS CETE "
				+ " FROM \"vw_autorizaciones_x_divisiones\" "
                + " WHERE TRUNC(FECHA) BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "','DD/MM/YY') "
                + " GROUP BY Division, TIPO_AUTORI";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new ResumenAutDivDTO (
                        cc.getString("Division"),
                        cc.getString("Campana"),
                        cc.getInt("Operaciones"),
                        cc.getDouble("Monto"),
                        cc.getDouble("Tasa_Prom"),
                        cc.getDouble("CETE")
                )
        );
	}
}
