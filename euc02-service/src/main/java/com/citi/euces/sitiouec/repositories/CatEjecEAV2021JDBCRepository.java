package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.citi.euces.sitiouec.infra.dto.NominaEAVDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.infra.utils.FormatUtils;

@Repository
public class CatEjecEAV2021JDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(CatEjecEAV2021JDBCRepository.class);
	
	public CatEjecEAV2021JDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public List<NominaEAVDTO> obtenerNominaEAV()
	{
		String sql = " SELECT ID_ALTERNATIVO AS NOMINA FROM UEC_CAT_EJEC_EAV2021 ";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new NominaEAVDTO (
                    cc.getLong("NOMINA")
                )
        );
	}
	
	public void updateFechaEAV(String fecha, Integer totalventas, Long nomina) throws GenericException {
		try { 
			String sql = " UPDATE UEC_CAT_EJEC_EAV2021 SET ";
			String sqlAux = FormatUtils.seleccionarFecha(fecha, totalventas);
			if(sqlAux.length() > 0) {
				log.info("Query aux: " + sqlAux);
				sql += sqlAux + " WHERE ID_ALTERNATIVO=" + nomina;
				log.info("UPDATE 1: " + sql);
				jdbcTemplate.execute(sql);
			}
		}catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al actualizar Sucursales Tasas ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	public void updateRegistrosEAV(Integer totalVenta, Double importe, Integer cedeVenta, Double cedeImporte, 
					Integer campVenta, Double campImporte, Integer numVentasPORTAESPNOM, Double importePORTAESPNOM, Long nomina) throws GenericException {
		try { 
			String sql = " UPDATE UEC_CAT_EJEC_EAV2021 SET "
					+ " VENTAS=" + totalVenta 
					+ " ,IMPORTE=" + importe 
					+ " ,CEDE_VENTAS=" + cedeVenta  
					+ " ,CEDE_IMPORTE=" + cedeImporte  
					+ " ,CAMP_VENTAS=" + campVenta 
					+ " ,CAMP_IMPORTE=" + campImporte  
					+ " ,PORTAESP_VENTAS=" + numVentasPORTAESPNOM  
					+ " ,PORTAESP_IMPORTE=" + importePORTAESPNOM  
					+ " WHERE ID_ALTERNATIVO=" + nomina;
			log.info("Update Registros EAV: " + sql);
			jdbcTemplate.execute(sql);
		}catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al actualizar Sucursales Tasas ", HttpStatus.NOT_FOUND.toString());
        }
	}
}
