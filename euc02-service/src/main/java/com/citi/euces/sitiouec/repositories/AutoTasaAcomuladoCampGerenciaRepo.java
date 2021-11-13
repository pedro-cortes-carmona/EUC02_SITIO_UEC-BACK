package com.citi.euces.sitiouec.repositories;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.sitiouec.entities.AutoTasaAcomuladoCampGerencia;

public interface AutoTasaAcomuladoCampGerenciaRepo extends JpaRepository<AutoTasaAcomuladoCampGerencia, Long> {
	
	@Transactional
	@Modifying
	@Query(value = " DELETE FROM UEC_TB_ACUMULADO_CAMP "
			+ " WHERE TO_CHAR(FECHA_APERTURA, ' DD/MM/YYYY') = TO_DATE(TO_CHAR(:FECHA_APERTURA),' DD/MM/YYYY') ",nativeQuery = true )
	int EliminarCargaAcumulado(@Param("FECHA_APERTURA") String FECHA_APERTURA);
	
	
	@Query(value = " select TO_NUMBER(count(distinct(a.FECHA_APERTURA))) as FECHA_APERTURA "
			+ " from UEC_TB_ACUMULADO_CAMP a where a.NOM_CAMP IN (:CAMPANA) ",nativeQuery = true )
	Long ObtenerDiasHabiles(@Param("CAMPANA") String CAMPANA);
	
	@Query(value = " select TO_CHAR(max(nvl(a.FECHA_APERTURA,TO_DATE('1000/01/01',' YYYY/DD/MM')))) as FECHA_APERTURA "
			+ " from UEC_TB_ACUMULADO_CAMP a where a.NOM_CAMP IN (:CAMPANA) ",nativeQuery = true )
	String ObtenerFechaMaxima(@Param("CAMPANA") String CAMPANA);
	

}
