package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.sitiouec.entities.AutoTasasOnLineGerencia;

public interface AutoTasasOnLineGerenciaRepo extends JpaRepository<AutoTasasOnLineGerencia, Long> {
	
	@Query(value = " SELECT tas.ID_TASAUTO,tas.FECHA_SOLIC,NVL(tas.FECHA_AUTORI,TO_DATE('1000/01/01',' YYYY/DD/MM')) as FECHA_AUTORI "
			     + ",NVL(tas.FECHA_ESTATUS,TO_DATE('1000/01/01',' YYYY/DD/MM')) as FECHA_ESTATUS ,tas.ESTATUS,   tas.SUC_SOLIC,tas.DIVISION, tas.PLAZO, "
			     +"  tas.TASA_AUTORI, tas.TIPO_AUTORI, tas.SOEID_AUTORI, tas.SOEID_ASIG, tas.SOEID_OPE, NVL(tas.NUM_AUTORI_UEC,0) AS NUM_AUTORI_UEC "
			     +"  FROM UEC_TB_AUTOTASAS tas "
			     +"  left join UEC_TB_AUTORIZADORES_ELEGIDOS eleg on tas.ID_TASAUTO = eleg.ID_TASAAUTO "
			     +"  WHERE TO_CHAR(tas.FECHA_SOLIC, ' DD/MM/YYYY') = TO_CHAR(sysdate,' DD/MM/YYYY') "
			     +"  order by tas. FECHA_SOLIC ",nativeQuery = true )
	List<AutoTasasOnLineGerencia>ObtenerRegistrosAutoTasasOnLine();  
	
	@Query(value = "  select  a.TIPO_AUTORI  from UEC_TB_AUTOTASAS a where a.TIPO_AUTORI<>' ' group by a.TIPO_AUTORI"
		    ,nativeQuery = true )
    List<String>TodasCampanas();  

}
