package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.dto.CatOfertaResposeDTO;
import com.citi.euces.sitiouec.entities.AutoTasaGerencia;
import com.citi.euces.sitiouec.entities.AutoTasaSucursalesGerencia;

@Repository
public class ImprimirReporteOnLineRepo {
	
	
	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(ImprimirReporteOnLineRepo.class);
	
	
	
	
	
	public ImprimirReporteOnLineRepo(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}




	@Transactional
	public List<AutoTasaGerencia> ObtenerVistaCampanaporDivision(String campana, String  fecha ,boolean is_ejec_priority, boolean is_Premio, boolean enablePM)
	
	//String campana, String  fecha,  boolean is_ejec_priority, boolean is_Premio, boolean enablePM
	{
		
		String sql = "SELECT suc.DIVISION_NOMBRE AS DIVISION ,'DISTRITO' AS DISTRITO, count(tas.ID_TASAUTO) AS VENTAS, sum(tas.MONTO) AS MONTO, sum(tas.MONTO)/ count(tas.ID_TASAUTO) AS MONTOVENTAS"
				+ "	    FROM UEC_TB_AUTOTASAS tas  inner join PER_CAT_SUCURSALES suc on suc.SIRH_SUCURSAL_ID= tas.SUC_SOLIC ";
			   sql += enablePM ? " inner join tb_ejec_pyme as ep on tas.nomina = ep.nomina " : "" ;
			   sql += is_ejec_priority ?"":" inner join per_cat_oferta ofer on tas.TIPO_AUTORI = ofer.OFERTA_ID ";
			   sql += is_ejec_priority ?"": " inner join per_cat_campanias cap on ofer.oferta_campania_id = cap.CAMPANIAS_ID ";

		       sql += " where tas.ESTATUS= 'LIBERADA' ";
		       sql += is_ejec_priority? "AND  TRUNC(tas.FECHA_SOLIC) = TO_DATE(TO_CHAR('"+fecha+"'),'DD/MM/YYYY') and tas.TIPO_AUTORI in ("+campana+")":"  AND TRUNC(tas.FECHA_SOLIC) = TO_DATE(TO_CHAR('"+fecha+"'),'DD/MM/YYYY') and cap.CAMPANIAS_ID in ("+campana+")"
		            + "  AND suc.IS_CLOSE = 0 and suc.EJECUTIVO_TOTAL > 0 ";
		     //  sql2 += is_ejec_priority ? " and tas.nomina in (select nomina from tb_ejec_br500)" : "";
		       sql += is_Premio ? " AND tas.MONTO >= 75000 AND ( tas.PLAZO >= 180 or tas.PLAZO = 0) " : "";
		       sql += " GROUP BY suc.DIVISION_NOMBRE ";

        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new AutoTasaGerencia (
                        cc.getString("DIVISION"),
                        cc.getDouble("VENTAS"),
                        cc.getDouble("MONTO"),
                        cc.getDouble("MONTOVENTAS"),
                        cc.getString("DISTRITO")
                )
        );
	}
	
	
	@Transactional
	public List<AutoTasaGerencia> ObtenerVistaCampanaporDivisionAplicada(String campana, String  fecha ,String  fecha_fin,boolean is_ejec_priority, boolean is_Premio, boolean enablePM)
	{
		
		String sql = "SELECT suc.DIVISION_NOMBRE AS DIVISION ,'DISTRITO' AS DISTRITO, count(tas.ID_TASA) AS VENTAS, sum(tas.MONTO) AS MONTO, sum(tas.MONTO)/ count(tas.ID_TASA) AS MONTOVENTAS"
				+ "	    FROM UEC_TB_TASAS tas  inner join PER_CAT_SUCURSALES suc on suc.SIRH_SUCURSAL_ID= tas.SUC_SOLIC  ";
			   sql += enablePM ? " inner join tb_ejec_pyme as ep on tas.nomina = ep.nomina " : "";
		       sql += " where tas.ESTATUS= 1 " 
		       		+ "  AND TRUNC(tas.FECHA_OPE) BETWEEN TO_DATE(TO_CHAR('"+fecha+"'),'DD/MM/YYYY') "
		       		+ "  AND TO_DATE(TO_CHAR('"+fecha_fin+"'),'DD/MM/YYYY')  AND  tas.CAMPANA_WEB in ("+campana+")"
		            + "  AND suc.IS_CLOSE = 0 ";
		     //  sql2 += is_ejec_priority ? " and tas.nomina in (select nomina from tb_ejec_br500)" : "";
		       sql += is_Premio ? " AND tas.MONTO >= 75000 AND ( tas.PLAZO >= 180 or tas.PLAZO = 0) " : "";
		       sql += " GROUP BY suc.DIVISION_NOMBRE ";

        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new AutoTasaGerencia (
                        cc.getString("DIVISION"),
                        cc.getDouble("VENTAS"),
                        cc.getDouble("MONTO"),
                        cc.getDouble("MONTOVENTAS"),
                        cc.getString("DISTRITO")
                )
        );
	}
	
	@Transactional
	public List<AutoTasaGerencia> ObtenerVistaCampanaporDirRegional(String campana, String  fecha ,boolean is_ejec_priority, boolean is_Premio, boolean enablePM)
	
	//String campana, String  fecha,  boolean is_ejec_priority, boolean is_Premio, boolean enablePM
	{
		
		String sql = "SELECT suc.DIVISION_NOMBRE AS DIVISION ,suc.DISTRITO_NOMBRE AS DISTRITO, count(tas.ID_TASAUTO) AS VENTAS, sum(tas.MONTO) AS MONTO, sum(tas.MONTO)/ count(tas.ID_TASAUTO) AS MONTOVENTAS"
				+ "	    FROM UEC_TB_AUTOTASAS tas  inner join PER_CAT_SUCURSALES suc on suc.SIRH_SUCURSAL_ID= tas.SUC_SOLIC ";
			   sql += enablePM ? " inner join tb_ejec_pyme as ep on tas.nomina = ep.nomina " : "";
			   sql += is_ejec_priority ?"":" inner join per_cat_oferta ofer on tas.TIPO_AUTORI = ofer.OFERTA_ID ";
			   sql += is_ejec_priority ?"": " inner join per_cat_campanias cap on ofer.oferta_campania_id = cap.CAMPANIAS_ID ";
		       sql += " where tas.ESTATUS= 'LIBERADA' ";
		       sql += is_ejec_priority ? "AND  TRUNC(tas.FECHA_SOLIC) = TO_DATE(TO_CHAR('"+fecha+"'),'DD/MM/YYYY') and tas.TIPO_AUTORI in ("+campana+")":"  AND TRUNC(tas.FECHA_SOLIC) = TO_DATE(TO_CHAR('"+fecha+"'),'DD/MM/YYYY') and cap.CAMPANIAS_ID in ("+campana+")"
		            + "  AND suc.IS_CLOSE = 0 and suc.EJECUTIVO_TOTAL > 0 ";
		     //  sql2 += is_ejec_priority ? " and tas.nomina in (select nomina from tb_ejec_br500)" : "";
		       sql += is_Premio ? " AND tas.MONTO >= 75000 AND ( tas.PLAZO >= 180 or tas.PLAZO = 0) " : "";
		       sql += " GROUP BY suc.DIVISION_NOMBRE, suc.DISTRITO_NOMBRE order by Ventas desc ";

        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new AutoTasaGerencia (
                        cc.getString("DIVISION"),
                        cc.getDouble("VENTAS"),
                        cc.getDouble("MONTO"),
                        cc.getDouble("MONTOVENTAS"),
                        cc.getString("DISTRITO")
                )
        );
	}
	
	@Transactional
	public List<AutoTasaGerencia> ObtenerVistaCampanaporDirRegionalAplicada(String campana, String  fecha ,String  fecha_fin,boolean is_ejec_priority, boolean is_Premio, boolean enablePM)
	{
		
		String sql = "SELECT suc.DIVISION_NOMBRE AS DIVISION ,suc.DISTRITO_NOMBRE AS DISTRITO, count(tas.ID_TASA) AS VENTAS, sum(tas.MONTO) AS MONTO, sum(tas.MONTO)/ count(tas.ID_TASA) AS MONTOVENTAS"
				+ "	    FROM UEC_TB_TASAS tas  inner join PER_CAT_SUCURSALES suc on suc.SIRH_SUCURSAL_ID= tas.SUC_SOLIC  ";
			   sql += enablePM ? " inner join tb_ejec_pyme as ep on tas.nomina = ep.nomina " : "";
		       sql += " where tas.ESTATUS= 1 " 
		       		+ "  AND TRUNC(tas.FECHA_OPE) BETWEEN TO_DATE(TO_CHAR('"+fecha+"'),'DD/MM/YYYY') "
		       		+ "  AND TO_DATE(TO_CHAR('"+fecha_fin+"'),' DD/MM/YYYY')  AND  tas.CAMPANA_WEB in ("+campana+")"
		            + "  AND suc.IS_CLOSE = 0  ";
		     //  sql2 += is_ejec_priority ? " and tas.nomina in (select nomina from tb_ejec_br500)" : "";
		       sql += is_Premio ? " AND tas.MONTO >= 75000 AND ( tas.PLAZO >= 180 or tas.PLAZO = 0) " : "";
		       sql += " GROUP BY suc.DIVISION_NOMBRE, suc.DISTRITO_NOMBRE order by Ventas desc ";

        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new AutoTasaGerencia (
                        cc.getString("DIVISION"),
                        cc.getDouble("VENTAS"),
                        cc.getDouble("MONTO"),
                        cc.getDouble("MONTOVENTAS"),
                        cc.getString("DISTRITO")
                )
        );
	}
	
	@Transactional
	public List<AutoTasaSucursalesGerencia> ObtenerVistaCampanaporSucursales(String campana, String  fecha ,boolean is_ejec_priority, boolean is_Premio, boolean enablePM)
	
	//String campana, String  fecha,  boolean is_ejec_priority, boolean is_Premio, boolean enablePM
	{
		
				
		String sql = "SELECT suc.DIVISION_NOMBRE as DIVISION ,suc.DISTRITO_NOMBRE as DISTRITO,  tas.SUC_SOLIC as SUC_SOLIC, count(tas.ID_TASAUTO) AS VENTAS, sum(tas.MONTO) AS MONTO, (sum(tas.MONTO)/ count(tas.ID_TASAUTO)) AS MONTOVENTAS,"
				+ "	 NVL((count(ID_TASAUTO) / suc.EJECUTIVO_TOTAL),0) as CAPITA, suc.EJECUTIVO_TOTAL as EJECUTIVOS "
				+ "	 from UEC_TB_AUTOTASAS tas  inner join PER_CAT_SUCURSALES suc on suc.SIRH_SUCURSAL_ID= tas.SUC_SOLIC ";
			   sql += enablePM ? " inner join UEC_TB_EJEC_PYME  ep on tas.NOMINA = ep.NOMINA  " : "";
			   sql += is_ejec_priority ?"":" inner join per_cat_oferta ofer on tas.TIPO_AUTORI = ofer.OFERTA_ID ";
			   sql += is_ejec_priority ?"": " inner join per_cat_campanias cap on ofer.oferta_campania_id = cap.CAMPANIAS_ID ";
		       sql += " where tas.ESTATUS= 'LIBERADA' ";
		       sql += is_ejec_priority ? "AND  TRUNC(tas.FECHA_SOLIC) = TO_DATE(TO_CHAR('"+fecha+"'),'DD/MM/YYYY') and tas.TIPO_AUTORI in ("+campana+")":"  AND TRUNC(tas.FECHA_SOLIC) = TO_DATE(TO_CHAR('"+fecha+"'),'DD/MM/YYYY') and cap.CAMPANIAS_ID in ("+campana+")"
		            + "  AND suc.IS_CLOSE = 0  ";
		     //  sql2 += is_ejec_priority ? " and tas.nomina in (select nomina from tb_ejec_br500)" : "";
		       sql += is_Premio ? " AND tas.MONTO >= 75000 AND ( tas.PLAZO >= 180 or tas.PLAZO = 0) " : "";
		       sql += " group by suc.DIVISION_NOMBRE,suc.DISTRITO_NOMBRE, tas.SUC_SOLIC, suc.EJECUTIVO_TOTAL order by VENTAS desc ";

        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new AutoTasaSucursalesGerencia (
                        cc.getString("DIVISION"),
                        cc.getLong("SUC_SOLIC"),
                        cc.getDouble("VENTAS"),
                        cc.getDouble("MONTO"),
                        cc.getDouble("MONTOVENTAS"),
                        cc.getString("DISTRITO"),
                        cc.getDouble("CAPITA"),
                        cc.getDouble("EJECUTIVOS")
                )
        );
	}
	
	@Transactional
	public List<AutoTasaSucursalesGerencia> ObtenerVistaCampanaporDirSucursalesAplicada(String campana, String  fecha ,String  fecha_fin,boolean is_ejec_priority, boolean is_Premio, boolean enablePM)
	{
		
		String sql = "SELECT suc.DIVISION_NOMBRE as DIVISION ,suc.DISTRITO_NOMBRE as DISTRITO,  tas.SUC_SOLIC as SUC_SOLIC, count(tas.ID_TASA) AS VENTAS, sum(tas.MONTO) AS MONTO, (sum(tas.MONTO)/ count(tas.ID_TASA)) AS MONTOVENTAS,"
				+ "	 NVL((count(ID_TASA) / suc.EJECUTIVO_TOTAL),0) as CAPITA, suc.EJECUTIVO_TOTAL as EJECUTIVOS "
				+ "	 from UEC_TB_TASAS tas  inner join PER_CAT_SUCURSALES suc on suc.SIRH_SUCURSAL_ID= tas.SUC_SOLIC ";
			//   sql += enablePM ? " inner join UEC_TB_EJEC_PYME  ep on tas.NOMINA = ep.NOMINA  " : "";

		       sql += " where tas.ESTATUS= 1 "
		    	   + "  AND TRUNC(tas.FECHA_OPE) BETWEEN TO_DATE(TO_CHAR('"+fecha+"'),'DD/MM/YYYY') "
			       + "  AND TO_DATE(TO_CHAR('"+fecha_fin+"'),' DD/MM/YYYY')  AND  tas.CAMPANA_WEB in ("+campana+")"
		            + "  AND suc.IS_CLOSE = 0 ";
		     //  sql2 += is_ejec_priority ? " and tas.nomina in (select nomina from tb_ejec_br500)" : "";
		       sql += is_Premio ? " AND tas.MONTO >= 75000 AND ( tas.PLAZO >= 180 or tas.PLAZO = 0) " : "";
		       sql += " group by suc.DIVISION_NOMBRE,suc.DISTRITO_NOMBRE, tas.SUC_SOLIC, suc.EJECUTIVO_TOTAL order by VENTAS desc ";

        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new AutoTasaSucursalesGerencia (
                		cc.getString("DIVISION"),
                        cc.getLong("SUC_SOLIC"),
                        cc.getDouble("VENTAS"),
                        cc.getDouble("MONTO"),
                        cc.getDouble("MONTOVENTAS"),
                        cc.getString("DISTRITO"),
                        cc.getDouble("CAPITA"),
                        cc.getDouble("EJECUTIVOS")
                )
        );
	}
	
	@Transactional
	public List<CatOfertaResposeDTO> ObtenerCampana()
	{
		
		String sql = "select cap.CAMPANIAS_ID AS OFERTA_ID "
				+ "                  from per_cat_oferta ofer "
				+ "		    inner join per_cat_campanias cap  "
				+ "		            on ofer.oferta_campania_id = cap.CAMPANIAS_ID "
				+ "		         where (sysdate >= cap.campanias_inicio  and sysdate <= cap.campanias_fin) "
				+ "               GROUP BY cap.CAMPANIAS_ID ";
			

        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new CatOfertaResposeDTO (
                		cc.getString("OFERTA_ID")
                )
        );
	}
	
	@Transactional
	public List<CatOfertaResposeDTO> ObtenerCampanaUno(String campana, String fecha)
	{
		
		String sql = " SELECT tas.TIPO_AUTORI AS OFERTA_ID"
				+ "			 from UEC_TB_AUTOTASAS tas  inner join PER_CAT_SUCURSALES suc on suc.SIRH_SUCURSAL_ID= tas.SUC_SOLIC "
				+ "             inner join per_cat_oferta ofer on tas.TIPO_AUTORI = ofer.OFERTA_ID "
				+ "             inner join per_cat_campanias cap on ofer.oferta_campania_id = cap.CAMPANIAS_ID "
				+ "		        where tas.ESTATUS= 'LIBERADA' "
				+ "		       	 AND TO_CHAR(tas.FECHA_SOLIC, ' DD/MM/YYYY') = TO_DATE(TO_CHAR('"+fecha+"'),' DD/MM/YYYY') and cap.CAMPANIAS_ID in ("+campana+") "
				+ "		         AND suc.IS_CLOSE = 0 "
				+ "		        group by tas.TIPO_AUTORI  ";
			

        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new CatOfertaResposeDTO (
                		cc.getString("OFERTA_ID")
                )
        );
	}
}
