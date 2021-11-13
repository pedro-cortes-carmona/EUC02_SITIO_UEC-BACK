package com.citi.euces.sitiouec.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.citi.euces.sitiouec.entities.EjecutivosNoLocalizablesGerencia;

public interface EjecutivosNoLocalizablesGerenciaRepo extends JpaRepository<EjecutivosNoLocalizablesGerencia, BigInteger> {

	@Query(value = "  SELECT NOMINA, NOM_EJEC AS NOMBRE,SUC_SOLIC AS SUC, SUM(MONTO) AS MONTOVENTAS, COUNT(MONTO) AS NUMVENTAS "
			+ "   FROM UEC_TB_ACUMULADO_CAMP "
			+ "  WHERE NOMINA NOT IN( SELECT ID_ALTERNATIVO "
			+ "                         FROM UEC_CAT_EJECUTIVOS_PRIORITY2021 "
			+ "                        UNION "
			+ "                       SELECT NOMINA AS ID_ALTERNATIVO "
			+ "                         FROM UEC_TB_ACUMULADO_CAMP) "
			+ "                     GROUP BY NOMINA,NOM_EJEC,SUC_SOLIC ", nativeQuery = true)
	List<EjecutivosNoLocalizablesGerencia>  ObtenerlistaEjecutivosNoLocalizables();
	
}
