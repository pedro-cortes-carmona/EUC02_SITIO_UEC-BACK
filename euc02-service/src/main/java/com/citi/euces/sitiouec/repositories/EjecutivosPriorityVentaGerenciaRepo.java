package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.sitiouec.entities.EjecutivosPriorityVentaGerencia;

public interface EjecutivosPriorityVentaGerenciaRepo  extends JpaRepository<EjecutivosPriorityVentaGerencia, String>{
	
	@Query(value = " SELECT  cs.DIVISION_NOMBRE as DIVISION, cs.DISTRITO_NOMBRE as DISTRITO, ac.SUC, cep.ID_ALTERNATIVO as NOMINA, "
			+ " cep.NOMBRE , ac.FECHA_APERTURA as FECHA ,NVL(ac.SUBTOTAL,0) as SUBTOTAL , NVL(ac.SUB_IMPORTE,0) as SUB_IMPORTE, ac.campana "
			+ " from UEC_CAT_EJECUTIVOS_PRIORITY2021 cep "
			+ " inner  join (select FECHA_APERTURA, NOMINA, count(NOMINA) as SUBTOTAL, sum(MONTO) as SUB_IMPORTE, SUC_SOLIC as SUC, NOM_CAMP  as CAMPANA "
			+ " from UEC_TB_ACUMULADO_CAMP where NOM_CAMP in (:CAMPANA) group by FECHA_APERTURA, NOMINA, MONTO ,SUC_SOLIC,NOM_CAMP) ac  on ac.nomina = cep.id_alternativo "
			+ " INNER JOIN PER_CAT_SUCURSALES cs on cs.SIRH_SUCURSAL_ID=ac.suc ", nativeQuery = true)
	List<EjecutivosPriorityVentaGerencia> ObtenerEjecutivosPriorityConVentas(@Param("CAMPANA") String CAMPANA);
	
	@Query(value = "  select cep.ID_ALTERNATIVO as NOMINA, cep.NOMBRE,cs.DIVISION_NOMBRE as DIVISION, cs.DISTRITO_NOMBRE as DISTRITO, cep.SIRH AS CAMPANA "
			+ " , '' AS SUC, SYSDATE AS FECHA, '' AS SUBTOTAL, '' AS SUB_IMPORTE"
			+ " from UEC_CAT_EJECUTIVOS_PRIORITY2021 cep  "
			+ " inner join PER_CAT_SUCURSALES cs on cs.SIRH_SUCURSAL_ID=cep.SIRH  "
			+ "  where cep.ID_ALTERNATIVO not in (select distinct(ac.NOMINA) from UEC_TB_ACUMULADO_CAMP ac where ac.NOM_CAMP in(:CAMPANA)) ", nativeQuery = true)
	List<EjecutivosPriorityVentaGerencia> ObtenerEjecutivosPrioritySinVentas(@Param("CAMPANA") String CAMPANA);

}
