package com.citi.euces.sitiouec.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.sitiouec.entities.AcumuladoGerencia;



public interface AcumuladoGerenciaRepo extends JpaRepository<AcumuladoGerencia, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "  INSERT INTO UEC_TB_ACUMULADO_CAMP "
			+ " (FECHA_APERTURA,ESTATUS,CONTRATO,NUM_INVER,NUM_CTE, "
			+ "	NOM_CTE,PLAZO,MONTO,TASA_AUTO,HORA_AUTO,NUM_AUTO_UEC, "
			+ "	SUC_SOLIC,DIVISION,REGION,NOMINA,NOM_EJEC,NOM_CAMP,ID_ACUMULADO) "
			+ " SELECT t.FECHA_OPE,t.ESTATUS,t.CONTRATO,t.NUM_INVERSION,t.NUM_CTE, "
			+ "	t.NOM_CTE,t.PLAZO,t.MONTO,t.TASA_AUTORI,TO_CHAR(t.HORA_AUTORI,'HH24:MM:SSSSS') AS HORA_AUTORI,t.NUM_AUTORI_UEC, "
			+ " t.SUC_SOLIC,t.DIVISION, s.DISTRITO_NOMBRE AS REGION,t.NOMINA,t.NOMEJEC,t.CAMPANA_WEB, "
			+ "	(ROWNUM+(select NVL(MAX(ID_ACUMULADO),0) AS ID from UEC_TB_ACUMULADO_CAMP)) AS ID "
			+ "	FROM UEC_TB_TASAS t, PER_CAT_SUCURSALES s "
			+ " WHERE  t.SUC_SOLIC = s.SIRH_SUCURSAL_ID "
			+ " AND TO_CHAR(FECHA_OPE,'DD/MM/YYYY')  =  TO_DATE(:FECHA,'DD/MM/YYYY') ",nativeQuery = true )
	int Guardar_Acumulado(@Param("FECHA") String FECHA);
	
	@Query(value = " select count(*) AS ID_ACUMULADO from UEC_TB_ACUMULADO_CAMP a "
			+ " where TRUNC(a.FECHA_APERTURA) = TO_DATE(TO_CHAR(:FECHA),'DD/MM/YYYY') "
			+ " and a.NOM_CAMP in (:CAMPANA) ",nativeQuery = true )
	Long GetNumRegTbAcumuladoTasas(@Param("CAMPANA") String CAMPANA, @Param("FECHA") String FECHA);
	

}
