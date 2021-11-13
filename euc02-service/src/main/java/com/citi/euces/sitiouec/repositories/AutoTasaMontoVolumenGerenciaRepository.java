package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.infra.dto.AutoTasaMontoVolumenGerencias;

@Repository
public class AutoTasaMontoVolumenGerenciaRepository {
	
	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(AutoTasaMontoVolumenGerenciaRepository.class);
	
	
	
	
	
	public AutoTasaMontoVolumenGerenciaRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Transactional
	public List<AutoTasaMontoVolumenGerencias> ObtenerVistaCampanaporDivision(String Semana_In, String  Semana_Fin , boolean enablePM)
	
	//String campana, String  fecha,  boolean is_ejec_priority, boolean is_Premio, boolean enablePM
	{
		
		String sql = " SELECT tas.TIPO_AUTORI as CAMPANA, tas.FECHA_SOLIC as FECHA, count(tas.ID_TASAUTO) as VOLUMEN, sum(tas.MONTO) as MONTO "
				+ "    FROM UEC_TB_AUTOTASAS  tas ";
		       sql += enablePM ? "inner join UEC_TB_EJEC_PYME  ep on tas.NOMINA = ep.NOMINA":  ""
				+ "    WHERE TO_CHAR(tas.FECHA_SOLIC, 'DD/MM/YYYY')  BETWEEN TO_CHAR('"+Semana_In+"') "
				+ "    AND  TO_CHAR('"+Semana_Fin+"') "
				+ "    AND tas.ESTATUS = 'LIBERADA' "
				+ "	   GROUP BY tas.TIPO_AUTORI,tas.FECHA_SOLIC ";

        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new AutoTasaMontoVolumenGerencias (
                        cc.getString("VOLUMEN"),
                        cc.getString("CAMPANA"),
                        cc.getTimestamp("FECHA"),
                        cc.getString("MONTO")
                )
        );
	}

	
}
