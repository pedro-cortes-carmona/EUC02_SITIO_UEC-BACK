package com.citi.euces.sitiouec.repositories;


import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

@Repository
public class CatGralCtesJDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(CatGralCtesJDBCRepository.class);
	
	public CatGralCtesJDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
    public String obtieneTipoPersona(Long numCte) throws GenericException {
        try {
        	String tp = "";
        	Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM UEC_CAT_GRAL_CTES WHERE NUM_CTE = " + numCte, Integer.class);
        	
        	if(count > 0) {
        		String id = jdbcTemplate.queryForObject("SELECT CLIENTE_TIPO_PERSONA FROM UEC_CAT_GRAL_CTES WHERE NUM_CTE = " + numCte, String.class);
                
            	if (id.equals("1")) {
                    tp = "PF";
                }else if(id.equals("2")) {
                	tp = "PM";
                }else if (id.equals("3")) {
                	tp = "PFAE";
                }
        	}else {
        		tp = "PF";
        	}
            
            return tp;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el valor bruto :: PER_CAT_TASAS_SISTEMA80 ", HttpStatus.NOT_FOUND.toString());
        }

    }
}
