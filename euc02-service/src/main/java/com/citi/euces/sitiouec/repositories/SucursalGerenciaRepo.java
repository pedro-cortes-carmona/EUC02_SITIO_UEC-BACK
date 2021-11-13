package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.sitiouec.entities.SucursalGerencia;


public interface SucursalGerenciaRepo extends JpaRepository<SucursalGerencia, Long>{
	

	@Query(value = " select s.DIVISION_NOMBRE, case when 1=:is_ejec_priority then NVL(sum(s.EJECUTIVO_PRIORITY),0) else NVL(sum(s.EJECUTIVO_TOTAL),0) end as CANTEJEC, count(s.SIRH_SUCURSAL_ID)  as CANTSUC, '' as DISTRITO_NOMBRE  "
			+ "  from PER_CAT_SUCURSALES s "
			+ " where s.DIVISION_NOMBRE is not null and s.EJECUTIVO_TOTAL > 0 and s.IS_CLOSE = 0 group by  s.DIVISION_NOMBRE ", nativeQuery = true)
	List<SucursalGerencia> ObtenerSucursalesAgrupadasEnCampanaPorDivision(@Param("is_ejec_priority")int  is_ejec_priority);
	
	@Query(value = " select s.DIVISION_NOMBRE, case when 1=:is_ejec_priority then NVL(sum(s.EJECUTIVO_PRIORITY),0) else NVL(sum(s.EJECUTIVO_TOTAL),0) end as CANTEJEC, count(s.SIRH_SUCURSAL_ID)  as CANTSUC, s.DISTRITO_NOMBRE  "
			+ "  from PER_CAT_SUCURSALES s "
			+ " where s.DIVISION_NOMBRE is not null and s.EJECUTIVO_TOTAL > 0 and s.IS_CLOSE = 0 group by  s.DIVISION_NOMBRE, s.DISTRITO_NOMBRE ", nativeQuery = true)
	List<SucursalGerencia> ObtenerSucursalesAgrupadasEnCampanaPorRegion(@Param("is_ejec_priority")int  is_ejec_priority);
	
	////////////////////////////////////////////////////////
	
	@Query(value = " select suc.DIVISION_NOMBRE, count(suc.SIRH_SUCURSAL_ID) as CANTSUC ,'0' as  CANTEJEC, '' as DISTRITO_NOMBRE "
			+ "   from PER_CAT_SUCURSALES suc inner join (  "
			+ "  SELECT  SUC_SOLIC from UEC_TB_AUTOTASAS tas where tas.ESTATUS= 'LIBERADA'   "
			+ "  AND  TO_CHAR(tas.FECHA_SOLIC, ' DD/MM/YYYY') = TO_DATE(TO_CHAR(:fecha),' DD/MM/YYYY') and tas.TIPO_AUTORI in (:campana)  "
            + "  group by tas.SUC_SOLIC ) tas "
			+ " on suc.SIRH_SUCURSAL_ID = tas.SUC_SOLIC  where suc.EJECUTIVO_TOTAL>0 and suc.IS_CLOSE = 0 group by suc.DIVISION_NOMBRE, suc.DISTRITO_NOMBRE",nativeQuery = true)
	List<SucursalGerencia> ObtenerSucursalesAgrupadasEnCampanaPorDivisionConVentas(@Param("fecha")String  fecha,
			@Param("campana")String campana);

	@Query(value = " select suc.DIVISION_NOMBRE, count(suc.SIRH_SUCURSAL_ID) as CANTSUC ,'0' as  CANTEJEC, '' as DISTRITO_NOMBRE  "
			+ "   from PER_CAT_SUCURSALES suc inner join (  "
			+ "  SELECT  SUC_SOLIC from UEC_TB_AUTOTASAS tas where tas.ESTATUS= 'LIBERADA'   "
			+ "  and tas.Monto >= 75000 and ( tas.PLAZO >=180 or tas.PLAZO =0) "
			+ "  AND  TO_CHAR(tas.FECHA_SOLIC, ' DD/MM/YYYY') = TO_DATE(TO_CHAR(:fecha),' DD/MM/YYYY') and tas.TIPO_AUTORI in (:campana)  "
            + "  group by tas.SUC_SOLIC ) tas "
			+ " on suc.SIRH_SUCURSAL_ID = tas.SUC_SOLIC  where suc.EJECUTIVO_TOTAL>0 and suc.IS_CLOSE = 0 group by suc.DIVISION_NOMBRE ,suc.DISTRITO_NOMBRE ",nativeQuery = true)
	List<SucursalGerencia> ObtenerSucursalesAgrupadasEnCampanaPorDivisionConVentas2(@Param("fecha")String  fecha,
			@Param("campana")String campana);
	
	
	@Query(value = " select suc.DIVISION_NOMBRE, count(suc.SIRH_SUCURSAL_ID) as CANTSUC ,'0' as  CANTEJEC, '' as DISTRITO_NOMBRE "
			+ "   from PER_CAT_SUCURSALES suc inner join (  "
			+ "   SELECT  SUC_SOLIC from UEC_TB_TASAS tas where tas.ESTATUS= 1    "
			+ "   AND TO_CHAR(tas.FECHA_OPE, ' DD/MM/YYYY') BETWEEN TO_DATE(TO_CHAR(:fecha),' DD/MM/YYYY')"
			+ "   AND  TO_DATE(TO_CHAR(:fecha_fin),' DD/MM/YYYY')  AND  tas.CAMPANA_WEB in (:campana)  "
            + "  group by tas.SUC_SOLIC ) tas "
			+ " on suc.SIRH_SUCURSAL_ID = tas.SUC_SOLIC  where suc.EJECUTIVO_TOTAL>0 and suc.IS_CLOSE = 0 group by suc.DIVISION_NOMBRE, suc.DISTRITO_NOMBRE",nativeQuery = true)
	List<SucursalGerencia> ObtenerSucursalesAgrupadasEnCampanaPorDivisionConVentasAplicada(@Param("fecha")String  fecha,
			@Param("fecha_fin")String  fecha_fin,@Param("campana")String campana);

	@Query(value = " select suc.DIVISION_NOMBRE, count(suc.SIRH_SUCURSAL_ID) as CANTSUC ,'0' as  CANTEJEC, '' as DISTRITO_NOMBRE  "
			+ "   from PER_CAT_SUCURSALES suc inner join (  "
			+ "   SELECT  SUC_SOLIC from UEC_TB_TASAS tas where tas.ESTATUS= 1 "
			+ "   AND tas.Monto >= 75000 and ( tas.PLAZO >=180 or tas.PLAZO =0) "
			+ "   AND TO_CHAR(tas.FECHA_OPE, ' DD/MM/YYYY') BETWEEN TO_DATE(TO_CHAR(:fecha),' DD/MM/YYYY')"
			+ "   AND  TO_DATE(TO_CHAR(:fecha_fin),' DD/MM/YYYY')  AND  tas.CAMPANA_WEB in (:campana)  "
            + "  group by tas.SUC_SOLIC ) tas "
			+ " on suc.SIRH_SUCURSAL_ID = tas.SUC_SOLIC  where suc.EJECUTIVO_TOTAL>0 and suc.IS_CLOSE = 0 group by suc.DIVISION_NOMBRE, suc.DISTRITO_NOMBRE",nativeQuery = true)
	List<SucursalGerencia> ObtenerSucursalesAgrupadasEnCampanaPorDivisionConVentas2Aplicada(@Param("fecha")String  fecha,
			@Param("fecha_fin")String  fecha_fin,@Param("campana")String campana);
	
	
	
	////////////////////////////////////////////////////////
	@Query(value = " select suc.DIVISION_NOMBRE, count(suc.SIRH_SUCURSAL_ID) as CANTSUC ,'0' as CANTSUC, suc.DISTRITO_NOMBRE "
			+ "   from PER_CAT_SUCURSALES suc inner join (  "
			+ "  SELECT  SUC_SOLIC from UEC_TB_AUTOTASAS tas where tas.ESTATUS= 'LIBERADA'   "
			+ "  AND  TO_CHAR(tas.FECHA_SOLIC, ' DD/MM/YYYY') = TO_DATE(TO_CHAR(:fecha),' DD/MM/YYYY') and tas.TIPO_AUTORI in (:campana)  "
            + "  group by tas.SUC_SOLIC ) tas "
			+ " on suc.SIRH_SUCURSAL_ID = tas.SUC_SOLIC  where suc.EJECUTIVO_TOTAL>0 and suc.IS_CLOSE = 0 group by suc.DIVISION_NOMBRE ,suc.DISTRITO_NOMBRE ",nativeQuery = true)
	List<SucursalGerencia> ObtenerSucursalesAgrupadasEnCampanaPorRegionConVentas(@Param("fecha")String  fecha,
			@Param("campana")String campana);

	@Query(value = " select suc.DIVISION_NOMBRE, count(suc.SIRH_SUCURSAL_ID) as CANTSUC ,'0' as CANTSUC, suc.DISTRITO_NOMBRE "
			+ "   from PER_CAT_SUCURSALES suc inner join (  "
			+ "  SELECT  SUC_SOLIC from UEC_TB_AUTOTASAS tas where tas.ESTATUS= 'LIBERADA'   "
			+ "  and tas.Monto >= 75000 and ( tas.PLAZO >=180 or tas.PLAZO =0) "
			+ "  AND  TO_CHAR(tas.FECHA_SOLIC, ' DD/MM/YYYY') = TO_DATE(TO_CHAR(:fecha),' DD/MM/YYYY') and tas.TIPO_AUTORI in (:campana)  "
            + "  group by tas.SUC_SOLIC ) tas "
			+ " on suc.SIRH_SUCURSAL_ID = tas.SUC_SOLIC  where suc.EJECUTIVO_TOTAL>0 and suc.IS_CLOSE = 0 group by suc.DIVISION_NOMBRE ,suc.DISTRITO_NOMBRE ",nativeQuery = true)
	List<SucursalGerencia> ObtenerSucursalesAgrupadasEnCampanaPorRegionConVentas2(@Param("fecha")String  fecha,
			@Param("campana")String campana);
	
	
	@Query(value = " select suc.DIVISION_NOMBRE, count(suc.SIRH_SUCURSAL_ID) as CANTSUC ,'0' as CANTSUC, suc.DISTRITO_NOMBRE "
			+ "   from PER_CAT_SUCURSALES suc inner join (  "
			+ "   SELECT  SUC_SOLIC from UEC_TB_TASAS tas where tas.ESTATUS= 1    "
			+ "   AND TO_CHAR(tas.FECHA_OPE, ' DD/MM/YYYY') BETWEEN TO_DATE(TO_CHAR(:fecha),' DD/MM/YYYY')"
			+ "   AND  TO_DATE(TO_CHAR(:fecha_fin),' DD/MM/YYYY')  AND  tas.CAMPANA_WEB in (:campana)  "
            + "  group by tas.SUC_SOLIC ) tas "
			+ " on suc.SIRH_SUCURSAL_ID = tas.SUC_SOLIC  where suc.EJECUTIVO_TOTAL>0 and suc.IS_CLOSE = 0 group by suc.DIVISION_NOMBRE, suc.DISTRITO_NOMBRE",nativeQuery = true)
	List<SucursalGerencia> ObtenerSucursalesAgrupadasEnCampanaPorRegionConVentasAplicada(@Param("fecha")String  fecha,
			@Param("fecha_fin")String  fecha_fin,@Param("campana")String campana);

	@Query(value = " select suc.DIVISION_NOMBRE, count(suc.SIRH_SUCURSAL_ID) as CANTSUC ,'0' as CANTSUC, suc.DISTRITO_NOMBRE "
			+ "   from PER_CAT_SUCURSALES suc inner join (  "
			+ "   SELECT  SUC_SOLIC from UEC_TB_TASAS tas where tas.ESTATUS= 1 "
			+ "   AND tas.Monto >= 75000 and ( tas.PLAZO >=180 or tas.PLAZO =0) "
			+ "   AND TO_CHAR(tas.FECHA_OPE, ' DD/MM/YYYY') BETWEEN TO_DATE(TO_CHAR(:fecha),' DD/MM/YYYY')"
			+ "   AND  TO_DATE(TO_CHAR(:fecha_fin),' DD/MM/YYYY')  AND  tas.CAMPANA_WEB in (:campana)  "
            + "  group by tas.SUC_SOLIC ) tas "
			+ " on suc.SIRH_SUCURSAL_ID = tas.SUC_SOLIC  where suc.EJECUTIVO_TOTAL>0 and suc.IS_CLOSE = 0 group by suc.DIVISION_NOMBRE, suc.DISTRITO_NOMBRE",nativeQuery = true)
	List<SucursalGerencia> ObtenerSucursalesAgrupadasEnCampanaPorRegionConVentas2Aplicada(@Param("fecha")String  fecha,
			@Param("fecha_fin")String  fecha_fin,@Param("campana")String campana);
	
}
