package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.sitiouec.entities.SucursalAgrupadasGerencia;

public interface SucursalGerenciaAgrupadasRepo extends JpaRepository<SucursalAgrupadasGerencia, Long>{

	@Query(value = " select s.DIVISION_NOMBRE, s.SIRH_SUCURSAL_ID, case when 1=:is_ejec_priority then NVL(sum(s.EJECUTIVO_PRIORITY),0) else NVL(sum(s.EJECUTIVO_TOTAL),0) end as CANTEJEC, '0'  as CANTSUC, s.DISTRITO_NOMBRE  "
			+ "  from PER_CAT_SUCURSALES s "
			+ " where s.DIVISION_NOMBRE is not null  and s.IS_CLOSE = 0  group by  s.SIRH_SUCURSAL_ID, s.DIVISION_NOMBRE, s.DISTRITO_NOMBRE ", nativeQuery = true)
	List<SucursalAgrupadasGerencia> ObtenerSucursalesAgrupadas(@Param("is_ejec_priority")int  is_ejec_priority);
	
	@Query(value = " select s.DIVISION_NOMBRE, s.SIRH_SUCURSAL_ID, case when 1=:is_ejec_priority then NVL(sum(s.EJECUTIVO_PRIORITY),0) else NVL(sum(s.EJECUTIVO_TOTAL),0) end as CANTEJEC, '0'  as CANTSUC, s.DISTRITO_NOMBRE  "
			+ "  from PER_CAT_SUCURSALES s "
			+ " where s.DIVISION_NOMBRE is not null  and s.IS_CLOSE = 0  group by  s.DISTRITO_NOMBRE, s.DIVISION_NOMBRE,s.SIRH_SUCURSAL_ID ", nativeQuery = true)
	List<SucursalAgrupadasGerencia> ObtenerSucursalesAgrupadasAplicada(@Param("is_ejec_priority")int  is_ejec_priority);



}
