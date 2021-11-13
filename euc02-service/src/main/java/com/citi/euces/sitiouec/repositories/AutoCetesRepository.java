package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.sitiouec.entities.AutoCetes;

public interface AutoCetesRepository extends JpaRepository<AutoCetes, Long> {
	
	@Query(value = " select * from UEC_TB_AUTOCETES a order by  a.ID_PLAZO asc ",nativeQuery = true )
	List<AutoCetes> obtenerCetes();

}
