package com.citi.euces.sitiouec.repositories;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.infra.dto.NominaEAVDTO;
import com.citi.euces.sitiouec.infra.dto.TasasDiarioA;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

@Repository
public class AcumuladoCampJDBCRepository {


	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(AcumuladoCampJDBCRepository.class);
	
	public AcumuladoCampJDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
    public Integer GetNumMax() throws GenericException {
        try {
            Integer id = jdbcTemplate.queryForObject("SELECT MAX(ID_ACUMULADO) FROM UEC_TB_ACUMULADO_CAMP", Integer.class);
            if (id == null) {
                id = 0;
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el total :: UEC_TB_TASAS ", HttpStatus.NOT_FOUND.toString());
        }

    }
	
	@Transactional
    public Integer GetNumRegTbAcumuladoTasas(String fecha) throws GenericException {
        try {
            Integer id = jdbcTemplate.queryForObject("SELECT COUNT(*) total FROM UEC_TB_ACUMULADO_CAMP "
            		+ " WHERE FECHA_APERTURA = '" + fecha + "'"
            		+ " AND NOM_CAMP IN ('PORTAESPNOM','PTUSDO12021','PTUSDO22021','PTUSDO32021','PTUSDO42021',"
            		+ " 'CREDNOM2021','PTU2021100','PTU2021105','PTU2021110','PTU2021','CREDONLY2021105',"
            		+ " 'CREDONLY2021110','CREDONLY2021105','CREDONLY2021','ONBOARDING2021') ", Integer.class);
            if (id == null) {
                id = 0;
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el total :: UEC_TB_TASAS ", HttpStatus.NOT_FOUND.toString());
        }

    }
	
	@Transactional
    public int[][] batchInsert(List<TasasDiarioA> books, int batchSize) throws GenericException {
		try {
			int[][] updateCounts = jdbcTemplate.batchUpdate(
	                "INSERT INTO UEC_TB_ACUMULADO_CAMP(FECHA_APERTURA, ESTATUS, CONTRATO, NUM_INVER, NUM_CTE, NOM_CTE,"
	                + " PLAZO, MONTO, TASA_AUTO, HORA_AUTO, NUM_AUTO_UEC, SUC_SOLIC, DIVISION, DISTRITO, NOMINA, NOM_EJEC, NOM_CAMP, ID_ACUMULADO) "
	                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
	                books,
	                batchSize,
	                new ParameterizedPreparedStatementSetter<TasasDiarioA>() {
	                    public void setValues(PreparedStatement ps, TasasDiarioA content) throws SQLException {
	                    	try {
	                    		ps.setDate(1, new Date(content.getFechaOpe().getTime()));
	                    		ps.setInt(2, content.getEstatus());
	                    		ps.setInt(3, content.getContrato());
	                    		ps.setInt(4, content.getNumInversion());
	                    		ps.setInt(5, content.getNumCte());
	                    		ps.setString(6, content.getNomCte());
	                    		ps.setInt(7, content.getPlazo());
	                    		ps.setDouble(8, content.getMonto());
	                    		ps.setDouble(9, content.getTasaAutori());
	                    		ps.setString(10, content.getHoraAutori());
	                    		ps.setInt(11, content.getNumAutoriUEC());
	                    		ps.setInt(12, content.getSucSolic());
	                    		ps.setString(13, content.getDivision());
	                    		ps.setString(14, content.getDistrito());
	                    		ps.setString(15, content.getNomina());
	                    		ps.setString(16, content.getNomEjec());
	                    		ps.setString(17, content.getCampanaWeb());
	                    		ps.setInt(18, content.getIdAcum());
	                    	} catch (SQLException e) {
	                			e.printStackTrace();
	                        }
	                    }
	                });
	        return updateCounts;	
		} catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al guardar en :: UEC_TB_TASAS ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	@Transactional
	public List<NominaEAVDTO> obtenerNominaEAV(Long nomina)
	{
		String sql = " SELECT NVL(fecha_apertura,TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_APERTURA, NVL(monto,0) AS MONTO, NVL(nom_camp,'NA') AS nom_camp FROM UEC_TB_ACUMULADO_CAMP WHERE nomina = " + nomina;
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new NominaEAVDTO (
                    cc.getDate("fecha_apertura"),
                    cc.getDouble("MONTO"),
                    cc.getString("nom_camp")
                )
        );
	}
	
}
