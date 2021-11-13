/**
 * 
 */
package com.citi.euces.sitiouec.services.api;

import java.util.List;
import java.util.Optional;

import com.citi.euces.sitiouec.entities.ConsultaDisponible;
import com.citi.euces.sitiouec.entities.ConsultaDisponibleIdentity;

/**
 * @author lbermejo
 *
 */
public interface ConsultaDisponibleService{
	
	/**
	 * 
	 * @param pk
	 * @return
	 */
	Optional<ConsultaDisponible> getConsultaDisponible(ConsultaDisponibleIdentity pk );
	
	/**
	 * 
	 * @param ntdc
	 * @return List<ConsultaDisponible>
	 */
	List<ConsultaDisponible> getConsultaDisponibleByTDC( String ntdc);
	
	/**
	 * 
	 * @return List<ConsultaDisponible>
	 */
	List<ConsultaDisponible> getAllCustomerDetail();
	
	

	
	
}
