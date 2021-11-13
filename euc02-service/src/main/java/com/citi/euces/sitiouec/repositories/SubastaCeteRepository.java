package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.sitiouec.entities.SubastaCetes;


public interface SubastaCeteRepository extends JpaRepository<SubastaCetes, Integer> {
	
	@Query(value = " select * from UEC_TB_HISTORICO_CETES a order by  a.FECHA asc ",nativeQuery = true )
	List<SubastaCetes> obtenerSubastaCetes();

}
