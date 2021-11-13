package com.citi.euces.sitiouec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citi.euces.sitiouec.entities.TasaGerencia;

public interface TasaGerenciaRepo extends JpaRepository<TasaGerencia, Long>{
	
	@Query(value = " SELECT count(*) AS ID_TASA FROM UEC_TB_TASAS t   "
			+ " inner join PER_CAT_SUCURSALES s on t.SUC_SOLIC =s.SIRH_SUCURSAL_ID  "
			+ " where t.Estatus=1 AND TRUNC(t.FECHA_OPE) = TO_DATE(TO_CHAR(:FECHA),'DD/MM/YYYY') "
			+ "  and t.CAMPANA_WEB in (:CAMPANA) ",nativeQuery = true )
	Long GetNumRegTbAcumuladoTasas(@Param("CAMPANA") String CAMPANA, @Param("FECHA") String FECHA);

}
