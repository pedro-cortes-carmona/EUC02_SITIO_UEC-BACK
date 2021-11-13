package com.citi.euces.sitiouec.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.http.HttpStatus;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;
import com.citi.euces.sitiouec.infra.dto.AutocetesDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

@Repository
public class AutoCetesJDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(AutoCetesJDBCRepository.class);
	
	public AutoCetesJDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	public List<AutocetesDTO> obtenerAutoCetes()
	{
		String sql = "SELECT ID_PLAZO,CETE FROM UEC_TB_AUTOCETES";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new AutocetesDTO (
                        cc.getInt("ID_PLAZO"),
                        cc.getInt("CETE")
                )
        );
	}
	
	@Transactional
	public void BorrarDLDatosAutoCetes() {
        String query = "DELETE FROM UEC_TB_AUTOCETES";
        jdbcTemplate.execute(query);
    }
	
	@Transactional
    public int[][] batchInsert(List<AutocetesDTO> books, int batchSize) throws GenericException {
		try {
			int[][] updateCounts = jdbcTemplate.batchUpdate(
	                "INSERT INTO UEC_TB_AUTOCETES(ID_PLAZO, CETE) VALUES(?,?)",
	                books,
	                batchSize,
	                new ParameterizedPreparedStatementSetter<AutocetesDTO>() {
	                    public void setValues(PreparedStatement ps, AutocetesDTO content) throws SQLException {
	                    	try {
	                    		ps.setInt(1, content.getIdPlazo());
		                    	ps.setInt(2, content.getCete());
	                    	} catch (SQLException e) {
	                			e.printStackTrace();
	                        }
	                    }
	                });
	        return updateCounts;	
		} catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al guardar en :: PPC_MIS_PRONOSTICOS_TMP ", HttpStatus.NOT_FOUND.toString());
        }
	}
}
