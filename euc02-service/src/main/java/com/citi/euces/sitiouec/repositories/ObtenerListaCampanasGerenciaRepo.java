package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.sitiouec.entities.ObtenerListaCampanasGerencia;

public interface ObtenerListaCampanasGerenciaRepo extends JpaRepository<ObtenerListaCampanasGerencia, String>{
	
	@Query(value = " SELECT replace(cs.DIVISION_NOMBRE,'DIVISION ','') as DIVISION , cs.DISTRITO_NOMBRE as DISTRITO, cs.SIRH_SUCURSAL_ID  as SIRH,  "
			+ "  NVL(ac.MONTO,0) as MONTO, NVL(ac.NUM_VENTAS,0) as NUM_VENTAS, ac.NOM_CAMP as NOM_CAMP, "
			+ " ce.TIPO_DISP as TIPO_DISP, NVL(ce.TOTAL,0) as NUM_EJECUTIVOS, cs.TIPO_DISPOSITIVO as TIPO  "
			+ " FROM PER_CAT_SUCURSALES cs  "
			+ " left outer join (select sum(ac.MONTO) AS MONTO, count(ac.MONTO) AS NUM_VENTAS, ac.SUC_SOLIC, ac.NOM_CAMP from "
			+ " UEC_TB_ACUMULADO_CAMP ac where ac.NOM_CAMP IN ('PORTAESPNOM','CREDNOM2021','PTU2021','PTUSDO12021','PTUSDO22021',"
			+ " 'PTUSDO32021','PTUSDO42021','PTUSDO52021','CREDONLY2021105','CREDONLY2021110','CREDONLY2021','ONBOARDING2021') "
			+ " group by ac.NOM_CAMP, ac.SUC_SOLIC) ac on  ac.SUC_SOLIC=cs.SIRH_SUCURSAL_ID "
			+ " left outer join UEC_CAT_EJECUTIVOS2021 ce on ce.SIRH=cs.SIRH_SUCURSAL_ID where cs.IS_CLOSE=0 "
			+ " group by cs.DIVISION_NOMBRE, cs.DISTRITO_NOMBRE, cs.SIRH_SUCURSAL_ID, ac.MONTO,ac.NUM_VENTAS, ac.NOM_CAMP,ce.TIPO_DISP,ce.TOTAL,cs.TIPO_DISPOSITIVO\r\n"
			+ " order by cs.DIVISION_NOMBRE", nativeQuery = true)
	List<ObtenerListaCampanasGerencia> ObtenerRegistrosAcumuCamp(); //revisar ObtenerRegistrosAcumuCamp

}
