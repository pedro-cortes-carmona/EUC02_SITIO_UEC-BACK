/**
 * 
 */
package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.entities.ConsultaDisponible;
import com.citi.euces.sitiouec.entities.ConsultaDisponibleIdentity;

/**
 * @author lbermejo
 *
 */
@Repository
public interface ConsultaDisponibleRepository 
	extends JpaRepository<ConsultaDisponible, ConsultaDisponibleIdentity> {

	List<ConsultaDisponible> findByIdTarjetaCredito(String ntdc);
	
	
	
}
