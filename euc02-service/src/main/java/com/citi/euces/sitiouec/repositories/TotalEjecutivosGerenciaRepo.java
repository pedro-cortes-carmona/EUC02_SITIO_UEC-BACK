package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.sitiouec.entities.TotalEjecutivosGerencia;

public interface TotalEjecutivosGerenciaRepo  extends JpaRepository<TotalEjecutivosGerencia, String>{
	
	@Query(value = " SELECT s.DIVISION_NOMBRE, sum(NVL(s.EJECUTIVO_TOTAL,0)) as CANTEJEC,  sum(NVL(s.EJECUTIVO_TOTAL,0)) as DISTRITO_NOMBRE   "
			+ "  FROM PER_CAT_SUCURSALES s where s.IS_CLOSE = 0 group by s.DIVISION_NOMBRE ", nativeQuery = true)
	List<TotalEjecutivosGerencia> ObtenerTotalEjecutivosDivision();
	
	@Query(value = " SELECT s.DISTRITO_NOMBRE, sum(NVL(s.EJECUTIVO_TOTAL,0)) as CANTEJEC ,  sum(NVL(s.EJECUTIVO_TOTAL,0)) as  DIVISION_NOMBRE  "
			+ "  FROM PER_CAT_SUCURSALES s where s.IS_CLOSE = 0 group by s.DISTRITO_NOMBRE ", nativeQuery = true)
	List<TotalEjecutivosGerencia> ObtenerTotalEjecutivosRegion();

}
