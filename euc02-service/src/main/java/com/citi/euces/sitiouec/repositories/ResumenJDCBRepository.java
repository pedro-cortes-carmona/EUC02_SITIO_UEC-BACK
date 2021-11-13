package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.citi.euces.sitiouec.infra.dto.ResumenDTO;

@Repository
public class ResumenJDCBRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(ResumenJDCBRepository.class);
	
	public ResumenJDCBRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public List<ResumenDTO> obtenerRegistros(String fecha1, String fecha2)
	{
		String sql =  " SELECT * FROM \"vw_resumen\" "
                + " WHERE TRUNC(FECHA) BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "','DD/MM/YY') ";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new ResumenDTO (
                        cc.getString("ESTATUS_UEC"),
                        cc.getString("ESTATUS_PLA"),
                        cc.getString("CAMPANA"),
                        cc.getDouble("MONTO")
                )
        );
	}
	
	@Transactional
	public List<ResumenDTO> obtenerRegistrosGerenciaInv(String fecha1, String fecha2)
	{
		String sql =  " SELECT CAMPANA, ESTATUS_PLA, COUNT(*) as OPERACIONES, NVL(SUM(monto),0) AS MONTO, "
				+ " 0 as OPE, 0.0 as SUBTOTAL, 0 AS APLICADO, 0.0 AS APLICADO_MONTO, 0 AS NO_APLICADO, 0.0 AS NO_APLICADO_MONTO,"
				+ " 0 AS NO_LOCALIZADO, 0.0 AS NO_LOCALIZADO_MONTO "
				+ " FROM \"vw_resumen\" "
                + " WHERE TRUNC(FECHA) BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "','DD/MM/YY') "
                + " AND estatus_pla <> 'No_Localizado' GROUP BY CAMPANA, ESTATUS_PLA ORDER BY estatus_pla, campana  ";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
        		new ResumenDTO (
        				cc.getString("ESTATUS_PLA"),
                        cc.getString("OPERACIONES"),
                        cc.getString("CAMPANA"),
                        cc.getDouble("MONTO"),
                        cc.getInt("OPE"),
                        cc.getDouble("SUBTOTAL"),
                        cc.getInt("APLICADO"),
                        cc.getDouble("APLICADO_MONTO"),
                        cc.getInt("NO_APLICADO"),
                        cc.getDouble("NO_APLICADO_MONTO"),
                        cc.getInt("NO_LOCALIZADO"),
                        cc.getDouble("NO_LOCALIZADO_MONTO")
        		)
        );
	}
}
