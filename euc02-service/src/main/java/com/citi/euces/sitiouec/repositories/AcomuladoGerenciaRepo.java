package com.citi.euces.sitiouec.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.sitiouec.entities.AcomuladoGerencia;

public interface AcomuladoGerenciaRepo extends JpaRepository<AcomuladoGerencia, BigInteger> {
	
	@Query(value = " select  CAM.NOMINA,CAM.NOM_EJEC AS NOMBRE,SC.SIRH_SUCURSAL_ID AS SUC,SC.DIVISION_NOMBRE AS DIVISION ,SC.DISTRITO_NOMBRE AS DISTRITO, "
			+ "        EJE.SOIED AS SOIED,'PRIO_VENTAS' AS PRIO_VENTAS, count(*) as SUB_TOTAL,sum(CAM.MONTO) as SUB_IMPORTE, "
			+ "        ( SELECT  COUNT(NOM_CAMP)    "
			+ "            FROM   UEC_TB_ACUMULADO_CAMP   "
			+ "           WHERE NOM_CAMP = 'PTU2021' "
			+ "             AND NOMINA = CAM.NOMINA)AS CEDE_VENTAS, "
			+ "        sum(TO_NUMBER(CASE  "
			+ "                      WHEN CAM.NOM_CAMP = 'PTU2021' "
			+ "                      THEN  TO_CHAR(CAM.MONTO)  "
			+ "                      ELSE '0' END)) AS CEDE_IMPORTE,      "
			+ "        ( SELECT  COUNT(NOM_CAMP)    "
			+ "            FROM   UEC_TB_ACUMULADO_CAMP   "
			+ "           WHERE NOM_CAMP = 'PTUSDO42021' "
			+ "             AND NOMINA = CAM.NOMINA)AS CAMP_VENTAS, "
			+ "        sum(TO_NUMBER(CASE  "
			+ "                      WHEN CAM.NOM_CAMP = 'PTUSDO42021'  "
			+ "                      THEN  TO_CHAR(CAM.MONTO)  "
			+ "                      ELSE '0' END)) AS CAMP_IMPORTE,EJE.PUESTO_TIPO AS PUESTO, "
			+ "       ( SELECT  COUNT(NOM_CAMP)    "
			+ "           FROM   UEC_TB_ACUMULADO_CAMP   "
			+ "          WHERE NOM_CAMP = 'PORTAESPNOM' "
			+ "            AND NOMINA = CAM.NOMINA)AS PORTAESP_VENTAS, "
			+ "        sum(TO_NUMBER(CASE  "
			+ "                      WHEN CAM.NOM_CAMP = 'PORTAESPNOM'  "
			+ "                      THEN  TO_CHAR(CAM.MONTO)  "
			+ "                      ELSE '0' END)) AS PORTAESP_IMPORTE, "
			+ "         TO_CHAR(CASE WHEN TO_CHAR(TO_DATE(CAM.FECHA_APERTURA,'DD/MM/YYYY')) = TO_CHAR(TO_DATE(:fecha,'DD/MM/YYYY')) "
			+ "        THEN COUNT(CAM.FECHA_APERTURA) "
			+ "        ELSE 0 END) AS NUM_FECHA, CAM.FECHA_APERTURA AS FECHA "
			+ " FROM UEC_TB_ACUMULADO_CAMP CAM, PER_CAT_SUCURSALES SC, PER_CAT_EJECUTIVO_SUCURSAL EJE "
			+ " WHERE CAM.SUC_SOLIC = SC.SIRH_SUCURSAL_ID "
			+ " AND CAM.NOMINA = EJE.NOMINA "
			+ " group by CAM.NOMINA, CAM.NOM_EJEC,SC.SIRH_SUCURSAL_ID,SC.DIVISION_NOMBRE,SC.DISTRITO_NOMBRE,EJE.SOIED,EJE.PUESTO_TIPO,CAM.FECHA_APERTURA ", nativeQuery = true)
	List<AcomuladoGerencia>  ObtenerlistaEAV(@Param("fecha")String  fecha);

}
