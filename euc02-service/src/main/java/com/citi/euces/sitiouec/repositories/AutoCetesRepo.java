package com.citi.euces.sitiouec.repositories;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.sitiouec.entities.AutoCetes;

public interface AutoCetesRepo extends JpaRepository<AutoCetes, Long>{
	
	@Transactional
	@Modifying
	@Query(value = " DELETE FROM UEC_TB_AUTOCETES ",nativeQuery = true )
	int Eliminar();
	
	@Transactional
	@Modifying
	@Query(value = " INSERT INTO UEC_TB_AUTOCETES (ID_PLAZO, CETE) "
			+"       VALUES (:ID_PLAZO, :CETE) ",nativeQuery = true )
	int Insertar(@Param("ID_PLAZO") Long ID_PLAZO,
			@Param("CETE") double CETE);

}
