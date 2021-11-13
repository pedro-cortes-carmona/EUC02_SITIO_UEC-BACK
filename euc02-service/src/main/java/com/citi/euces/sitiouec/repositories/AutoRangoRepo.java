package com.citi.euces.sitiouec.repositories;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.sitiouec.entities.Autorango;

public interface AutoRangoRepo extends JpaRepository<Autorango, Long>{
	

	@Transactional
	@Modifying
	@Query(value = " DELETE FROM UEC_TB_AUTORANGOS ",nativeQuery = true )
	int Eliminar();
	
	@Transactional
	@Modifying
	@Query(value = " INSERT INTO UEC_TB_AUTORANGOS (ID_RANGO, RANGOMIN, RANGOMAX, MILL_DOSMILLQUIN, FECHA, FECHAFIN) "
			+"       VALUES (:ID_RANGO, :RANGOMIN,:RANGOMAX,:MILL_DOSMILLQUIN,:FECHA,:FECHAFIN) ",nativeQuery = true )
	int Insertar(@Param("ID_RANGO") Long ID_RANGO,
			@Param("RANGOMIN") Long RANGOMIN,
			@Param("RANGOMAX") Long RANGOMAX,
			@Param("MILL_DOSMILLQUIN") double MILL_DOSMILLQUIN,
			@Param("FECHA") Timestamp FECHA,
			@Param("FECHAFIN") Timestamp FECHAFIN);

}
