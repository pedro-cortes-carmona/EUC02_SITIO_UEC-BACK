package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.sitiouec.entities.CampanaGerencia;

public interface CampanaGerenciaRepo extends JpaRepository<CampanaGerencia, String>{
	
	@Query(value = " SELECT * FROM PER_CAT_CAMPANIAS C WHERE C.CAMPANIAS_ID =:campana ", nativeQuery = true)
	List<CampanaGerencia>  obtenerFechas(@Param("campana")String campana);
	
	@Query(value = "  SELECT * "
			+ "         FROM PER_CAT_CAMPANIAS C "
			+ "        WHERE C.CAMPANIAS_ID IN ('1','2','3','4','5','6','7','8','9','10','11','12') "
			+ "     ORDER BY TO_NUMBER(C.CAMPANIAS_ID) ", nativeQuery = true)
	List<CampanaGerencia>  ObtenerListaCampanas();

}
