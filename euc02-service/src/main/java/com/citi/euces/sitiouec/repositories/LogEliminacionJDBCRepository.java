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

import com.citi.euces.sitiouec.infra.dto.LogEliminacionDTO;
import com.citi.euces.sitiouec.infra.dto.TasasCampanaDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

@Repository
public class LogEliminacionJDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(LogEliminacionJDBCRepository.class);
	
	public LogEliminacionJDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public List<LogEliminacionDTO> selectLogEliminacion(String fecha1, String fecha2)
	{
		String sql =  " SELECT NVL(SOEID,'SIN SOEID') AS SOEID, FECHA_OPE, FECHA_ELIM"
                + " FROM UEC_TB_LOG_ELIMINACION"
                + " WHERE FECHA_OPE BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "', 'DD/MM/YY')";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new LogEliminacionDTO (
                        cc.getString("SOEID"),
                        cc.getDate("FECHA_OPE"),
                        cc.getDate("FECHA_ELIM")
                )
        );
	}
	
	@Transactional
    public Integer obtieneMax() throws GenericException {
        try {
            Integer id = jdbcTemplate.queryForObject("SELECT NVL(MAX(ID),0) FROM UEC_TB_LOG_ELIMINACION", Integer.class);
            if (id == null) {
                id = 0;
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el valor bruto :: PER_CAT_TASAS_SISTEMA80 ", HttpStatus.NOT_FOUND.toString());
        }

    }
	
	@Transactional
    public int[][] batchInsert(List<LogEliminacionDTO> books, int batchSize) throws GenericException {
		try {
			int[][] updateCounts = jdbcTemplate.batchUpdate(
	                "INSERT INTO UEC_TB_LOG_ELIMINACION(ID,SOEID,FECHA_OPE,FECHA_ELIM) "
	                + "VALUES(?,?,?,?)",
	                books,
	                batchSize,
	                new ParameterizedPreparedStatementSetter<LogEliminacionDTO>() {
	                    public void setValues(PreparedStatement ps, LogEliminacionDTO content) throws SQLException {
	                    	try {
	                    		ps.setInt(1, content.getId());
	                    		ps.setString(2, content.getSoeid());
	                    		ps.setDate(3, new Date(content.getFecha_ope().getTime()));
	                    		ps.setDate(4, new Date(content.getFecha_elim().getTime()));
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
}
