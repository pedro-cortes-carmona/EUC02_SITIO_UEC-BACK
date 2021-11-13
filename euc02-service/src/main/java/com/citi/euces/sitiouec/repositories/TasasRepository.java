package com.citi.euces.sitiouec.repositories;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.dto.AsignacionesDTO;
import com.citi.euces.sitiouec.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.dto.CompletarInformacionKPIDTO;
import com.citi.euces.sitiouec.dto.FechasFestivasDTO;
import com.citi.euces.sitiouec.dto.FolioNumAutorizacionDTO;
import com.citi.euces.sitiouec.dto.ListaUsuariosSoeidDTO;
import com.citi.euces.sitiouec.dto.PerCatParametrosDTO;
import com.citi.euces.sitiouec.dto.PerCatSucursalesDTO;
import com.citi.euces.sitiouec.dto.TasasDTO;
import com.citi.euces.sitiouec.dto.TasasReprocesoDTO;
import com.citi.euces.sitiouec.dto.TasasTimeLinessDTO;
import com.citi.euces.sitiouec.entities.AutoTasas;
import com.citi.euces.sitiouec.entities.FechasFestivas;
import com.citi.euces.sitiouec.infra.utils.MensajesUtils;

@Repository
public class TasasRepository {

	private static final Logger LOGGER = LogManager.getLogger(TasasRepository.class);
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	FechasFestivasRepository fechasFestivasRepository;
	
	@Autowired
	private AutoTasasRepository autoTasasRepository;
	
	

	public List<AutoTasas> findAll() {
		return jdbcTemplate.query("select * from uec_tb_autotasas",
				new BeanPropertyRowMapper<AutoTasas>(AutoTasas.class));
	}

	@Transactional
	public List<TasasDTO> getContratosRepetidosCampana(String date1, String date2) {

		String sql = " SELECT T1.id_tasa, T1.fecha_ope, T1.suc_solic, "
				+ "T1.MONTO, T1.plazo,T1.estatus,T1.num_cte,T1.nom_cte,T1.contrato,T1.OPERADO_POR,T1.NUM_AUTORI_UEC,"
				+ "T1.CAMPANA_WEB,T1.NOMEJEC,T1.OBSERVA_WEB,T1.SOEID_REP, "
				+ "sucu.SIRH_SUCURSAL_ID,"
				+ "T1.autorizador  " 
				+ "FROM uec_tb_tasas T1 left join per_cat_sucursales sucu on t1.SUC_SOLIC=sucu.SIRH_SUCURSAL_ID "
				+ "INNER JOIN (SELECT contrato, campana_web FROM uec_tb_tasas "
				+ "WHERE CAMPANA_WEB is not null and CONTRATO <>0 and estatus=1 and is_tasa_base <>1 AND "
				+ "FECHA_OPE  BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') AND TO_DATE('" + date2 + "','YYYY-MM-DD')"
				+ "  and  " + " " + " " + "autorizador is null GROUP BY contrato, campana_web HAVING COUNT(*) > 1) T2 "
				+ "ON T1.contrato = T2.contrato AND T1.campana_web = T2.campana_web";

		
		LOGGER.info("Query - Method -  getContratosRepetidosCampana" + " " + sql.toString());
		
		
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new TasasDTO(
						cc.getDouble("NUM_AUTORI_UEC"),
						cc.getLong("id_tasa"),
						cc.getDate("fecha_ope"),
						cc.getLong("suc_solic"),
						cc.getDouble("MONTO"),
						cc.getLong("plazo"), 
						cc.getLong("estatus"),
						cc.getLong("num_cte"),
						cc.getNString("nom_cte"),
						cc.getLong("CONTRATO"),
						cc.getString("OPERADO_POR"),
						cc.getString("CAMPANA_WEB"),
						cc.getString("NOMEJEC"),
						cc.getString("OBSERVA_WEB"),
						cc.getString("SOEID_REP")));
	}

	@Transactional
	public List<AutoTasasDTO> getContratosRepetidosOperativo(String date1, String date2) {

		String sql = " SELECT t1.ID_TASAUTO, " + "    t1.FECHA_SOLIC, t1.FECHA_ESTATUS,"
				+ "    T1.NUM_AUTORI_UEC,T1.SUC_SOLIC,t1.monto,t1.plazo,t1.TASA_AUTORI, sucu.SIRH_SUCURSAL_ID,"
				+ "    t1.ESTATUS,t1.num_cte,t1.nom_cte, T1.contrato,t1.soeid_ope,t1.nomejec,t1.observa_web" + " " + ""
				+ "    FROM uec_tb_autotasas T1 left join per_cat_sucursales sucu on t1.SUC_SOLIC=sucu.SIRH_SUCURSAL_ID  INNER JOIN (  SELECT contrato, TIPO_AUTORI FROM uec_tb_autotasas "
				+ "    WHERE estatus='LIBERADA' and tipo_autori <> 'ESPECIAL' and "
				+ "    TRUNC(fecha_solic)   BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') AND TO_DATE('" + date2
				+ "','YYYY-MM-DD')" + " " + "    GROUP BY contrato, TIPO_AUTORI HAVING COUNT(*) > 1) T2 "
				+ "    ON T1.contrato = T2.contrato AND T1.TIPO_AUTORI = T2.TIPO_AUTORI "
				+ "    where t1.estatus like 'LIBERADA' ";
		
		
		LOGGER.info("Query - Method -  getContratosRepetidosOperativo" + " " + sql.toString());
		
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new AutoTasasDTO(cc.getLong("NUM_AUTORI_UEC"),
						cc.getLong("ID_TASAUTO"), cc.getTimestamp("FECHA_SOLIC"),
						cc.getTimestamp("FECHA_ESTATUS"), cc.getLong("SUC_SOLIC"), cc.getDouble("MONTO"),
						cc.getLong("PLAZO"), cc.getDouble("TASA_AUTORI"), cc.getString("ESTATUS"), cc.getLong("NUM_CTE"),
						cc.getString("NOM_CTE"), cc.getString("CONTRATO"), cc.getString("SOEID_OPE"),
						cc.getString("NOMEJEC"), cc.getString("OBSERVA_WEB")));
	}

	@Transactional
	public List<TasasDTO> getClientesRepetidosCampana(String date1, String date2) {

		String sql = "SELECT t1.id_tasa,t1.num_autori_uec, t1.fecha_ope, T1.suc_solic, t1.monto, t1.plazo,t1.TASA_AUTORI, t1.estatus, "
				+ "  t1.num_cte,t1.nom_cte, t1.suc_solic, t1.contrato, t1.OPERADO_POR, t1.CAMPANA_WEB, t1.NOMEJEC ,t1.OBSERVA_WEB,T1.SOEID_REP,sucu.SIRH_SUCURSAL_ID "
				+ " " + " " + "  FROM uec_tb_tasas T1  left join per_cat_sucursales sucu on t1.SUC_SOLIC=sucu.SIRH_SUCURSAL_ID "
				+ " INNER JOIN (  SELECT contrato, campana_web FROM uec_tb_tasas "
				+ "  WHERE CAMPANA_WEB is not null and CONTRATO <>0 and estatus=1 and is_tasa_base <>1 AND "
				+ "  FECHA_OPE  BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') AND TO_DATE('" + date2
				+ "  ','YYYY-MM-DD')" + "  and  " + " " + " "
				+ "  autorizador is null GROUP BY contrato, campana_web HAVING COUNT(*) > 1) T2 "
				+ "  ON T1.contrato = T2.contrato AND T1.campana_web = T2.campana_web";
		
		
		LOGGER.info("Query - Method -  getClientesRepetidosCampana" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new TasasDTO(
						cc.getDouble("num_autori_uec"),
						cc.getLong("id_tasa"),
						cc.getDate("fecha_ope"),
						cc.getLong("suc_solic"),
						cc.getDouble("MONTO"), 
						cc.getLong("plazo"),
						cc.getLong("estatus"),
						cc.getLong("num_cte"),
						cc.getNString("nom_cte"),
						cc.getLong("CONTRATO"),
						cc.getString("OPERADO_POR"),
						cc.getString("CAMPANA_WEB"), 
						cc.getString("NOMEJEC"), 
						cc.getString("OBSERVA_WEB"),
						cc.getString("SOEID_REP")));
	  }

	@Transactional
	public List<AutoTasasDTO> getClientesRepetidosOperativo(String date1, String date2) {

		String sql = " SELECT T1.ID_TASAUTO, t1.NUM_AUTORI_UEC, T1.SUC_SOLIC, T1.FECHA_SOLIC,T1.suc_solic,T1.monto,"
				+ "  T1.plazo,T1.TASA_AUTORI, T1.ESTATUS, sucu.SIRH_SUCURSAL_ID,"
				+ "  T1.num_cte, T1.nom_cte, T1.nomejec, T1.contrato,T1.soeid_ope, t1.FECHA_ESTATUS,"
				+ "  T1.observa_web, T1.tipo_autori " + " " + " "
				+ "  FROM uec_tb_autotasas T1 left join per_cat_sucursales sucu on t1.SUC_SOLIC=sucu.SIRH_SUCURSAL_ID  INNER JOIN                          "
				+ "  (SELECT num_cte, contrato, TIPO_AUTORI FROM uec_tb_autotasas "
				+ "  WHERE   estatus='LIBERADA' and tipo_autori <> 'ESPECIAL' and "
				+ "  TRUNC(fecha_solic)   BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') AND TO_DATE('" + date2
				+ "','YYYY-MM-DD')" + " " + "  GROUP BY num_cte, contrato, TIPO_AUTORI HAVING COUNT(*) > 1) T2"
				+ "  ON T1.num_cte = T2.num_cte AND T1.TIPO_AUTORI = T2.TIPO_AUTORI "
				+ "  where t1.estatus like 'LIBERADA'";
		
		LOGGER.info("Query - Method -  getClientesRepetidosOperativo" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new AutoTasasDTO(cc.getLong("NUM_AUTORI_UEC"),cc.getLong("ID_TASAUTO"), cc.getTimestamp("FECHA_SOLIC"),
						cc.getTimestamp("FECHA_ESTATUS"), cc.getLong("SUC_SOLIC"), cc.getDouble("MONTO"),
						cc.getLong("PLAZO"), cc.getDouble("TASA_AUTORI"), cc.getString("ESTATUS"), cc.getLong("NUM_CTE"),
						cc.getString("NOM_CTE"), cc.getString("CONTRATO"), cc.getString("SOEID_OPE"),
						cc.getString("NOMEJEC"), cc.getString("OBSERVA_WEB")));
	}

	@Transactional
	public List<AutoTasasDTO> getRegistroObservacionesTasaOperativa(String date1, String date2) {

		String sql = " select ID_TASAUTO," + "          NUM_AUTORI_UEC," + "          FECHA_SOLIC,"
				+ "          FECHA_ESTATUS ," + "          SUC_SOLIC,MONTO, " + "          PLAZO,"
				+ "          TASA_AUTORI,ESTATUS , " + "          NUM_CTE, " + "          NOM_CTE, NOMEJEC,CONTRATO, "
				+ "         TIPO_AUTORI ,SOEID_OPE ,OBSERVA_WEB  " + "         from uec_tb_autotasas where  "
				+ "  TRUNC(fecha_solic)   BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') AND TO_DATE('" + date2
				+ "','YYYY-MM-DD')" + " "
				+ "         and (observa_web like '%1%' or observa_web like '%2%' or observa_web like '%3%' "
				+ "         or observa_web like '%4%' or observa_web like '%5%' or observa_web like '%6%' "
				+ "         or observa_web like '%7%' or observa_web like '%8%' or observa_web like '%9%'"
				+ "         or observa_web like '%0%' )  and (num_autori_uec <> 0) ";
		
		LOGGER.info("Query - Method -  getRegistroObservacionesTasaOperativa" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new AutoTasasDTO(cc.getLong("ID_TASAUTO"), cc.getTimestamp("FECHA_SOLIC"),
						cc.getTimestamp("FECHA_ESTATUS"), cc.getLong("SUC_SOLIC"), cc.getDouble("MONTO"),
						cc.getLong("PLAZO"), cc.getDouble("TASA_AUTORI"), cc.getString("ESTATUS"), cc.getLong("NUM_CTE"),
						cc.getString("NOM_CTE"), cc.getString("CONTRATO"), cc.getString("SOEID_OPE"),
						cc.getString("NOMEJEC"), cc.getString("OBSERVA_WEB"), cc.getLong("NUM_AUTORI_UEC"),
						cc.getString("TIPO_AUTORI")));
		
	}

	@Transactional
	public List<AutoTasasDTO> getRegistrosTimeLines(String date1, String date2) {

		String sql = "select  tas.id_tasa, " + "   tas.asignado_a,  sucu.SIRH_SUCURSAL_ID, tas.operado_por," + "   tas.num_cte,"
				+ "   tas.contrato, " + "   tas.estatus,  " + "   tas.FECHA_CAPTURA, " + "   tas.NUM_AUTORI_UEC,"
				+ "   auto.FECHA_AUTORI, " + "   tas.FECHA_ESTATUS, " + "   auto.SOEID_OPE, " + "   tas.observa_web,"
				+ "   tas.CAMPANA_WEB from uec_tb_tasas tas left join per_cat_sucursales sucu on tas.SUC_SOLIC=sucu.SIRH_SUCURSAL_ID "
				+ "   left join uec_tb_autotasas auto on ( auto.num_autori_uec = tas.NUM_AUTORI_UEC "
				+ "   and tas.fecha_ope = auto.fecha_solic ) " + "   where tas.fecha_ope  " + "   BETWEEN TO_DATE('"
				+ date1 + "','YYYY-MM-DD') AND TO_DATE('" + date2 + "','YYYY-MM-DD')" + "   and tas.is_web=1  "
				+ "   AND tas.HORA_AUTORI between" + "   To_timestamp(concat( '" + date1
				+ "','09:00:00'), 'YYYY-MM-DD HH24:MI:SS') " + "   and" + "   To_timestamp(concat( '" + date1
				+ "','19:30:00'), 'YYYY-MM-DD HH24:MI:SS') " + "   AND "
				+ "   EXTRACT(minute FROM   tas.FECHA_ESTATUS - tas.FECHA_CAPTURA) > 5";
		
		LOGGER.info("Query - Method -  getRegistrosTimeLines" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new AutoTasasDTO(cc.getLong("ID_TASA"), cc.getTimestamp("FECHA_ESTATUS"),
						cc.getLong("NUM_CTE"), cc.getString("CONTRATO"), cc.getString("OBSERVA_WEB"),
						cc.getString("ASIGNADO_A"), cc.getString("operado_por"), cc.getLong("ESTATUS"),
						cc.getTimestamp("FECHA_CAPTURA"), cc.getTimestamp("FECHA_AUTORI"), cc.getString("CAMPANA_WEB"),
						cc.getString("SOEID_OPE")));
	}

	@Transactional
	public List<TasasDTO> getMontoPlazoTasaRepetidoCampana(String date1, String date2) {

		String sql = "   SELECT t1.id_tasa,t1.num_autori_uec, t1.fecha_ope, "
				+ "   T1.suc_solic, t1.monto, t1.plazo,t1.TASA_AUTORI, t1.estatus, "
				+ "   t1.num_cte, t1.nom_cte, t1.contrato, t1.OPERADO_POR, t1.CAMPANA_WEB, "
				+ "   t1.NOMEJEC ,t1.OBSERVA_WEB,t1.SOEID_REP"
				+ "   FROM uec_tb_tasas T1 INNER JOIN (  SELECT concat(concat( fecha_ope,monto),concat(plazo, TASA_AUTORI))as llave"
				+ "   FROM uec_tb_tasas  WHERE CAMPANA_WEB is not null and is_web=1 AND "
				+ "   FECHA_OPE  BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') AND TO_DATE('" + date2
				+ "  ','YYYY-MM-DD')" + " " + " "
				+ "      GROUP BY concat(concat( fecha_ope,monto),concat(plazo, TASA_AUTORI))"
				+ "      HAVING COUNT( concat(concat( fecha_ope,monto),concat(TASA_AUTORI,plazo))) > 1 ) T2 "
				+ "      ON concat(concat(T1.fecha_ope,T1.monto),concat(T1.plazo, T1.TASA_AUTORI)) = T2.llave "
				+ "      order by t1.suc_solic, t1.fecha_ope, t1.monto, t1.plazo,t1.TASA_AUTORI";
		
		LOGGER.info("Query - Method -  getMontoPlazoTasaRepetidoCampana" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new TasasDTO(cc.getLong("id_tasa"), cc.getDate("fecha_ope"), cc.getLong("suc_solic"),
						cc.getDouble("monto"), cc.getLong("plazo"), cc.getLong("estatus"), cc.getLong("num_cte"),
						cc.getString("nom_cte"), cc.getLong("contrato"), cc.getString("OPERADO_POR"),
						cc.getString("CAMPANA_WEB"), cc.getString("OBSERVA_WEB"), cc.getString("SOEID_REP"),
						cc.getLong("num_autori_uec"), cc.getString("NOMEJEC"), cc.getInt("TASA_AUTORI")));
	}

	@Transactional
	public List<TasasReprocesoDTO> getReprocesosPorFecha(String date1, String date2) {

		String sql = "select id_tasa,num_autori_uec, fecha_ope, suc_solic, monto, plazo,tASA_AUTORI, "
				+ "   estatus, num_cte, NOM_CTE, contrato, OPERADO_POR, CAMPANA_WEB,"
				+ "   NOMEJEC ,OBSERVA_WEB, SOEID_RESP " + "   from uec_tb_tasas_reproceso where FECHA_OPE "
				+ "   BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') AND TO_DATE('" + date2 + "  ','YYYY-MM-DD')";
		
		LOGGER.info("Query - Method -  getReprocesosPorFecha" + " " + sql.toString());

		return jdbcTemplate.query(sql, (cc, rowNum) -> new TasasReprocesoDTO(cc.getLong("id_tasa"),
				cc.getLong("num_autori_uec"), cc.getDate("fecha_ope"), cc.getLong("suc_solic"), cc.getLong("monto"),
				cc.getLong("plazo"), cc.getLong("TASA_AUTORI"), cc.getString("estatus"), cc.getLong("num_cte"),
				cc.getString("NOM_CTE"), cc.getString("NOMEJEC"), cc.getLong("contrato"), cc.getString("OPERADO_POR"),
				cc.getString("CAMPANA_WEB"), cc.getString("OBSERVA_WEB"), cc.getString("SOEID_RESP")));
	}

	@Transactional
	public List<TasasTimeLinessDTO> getTimelinessPorFecha(String date1, String date2) {

		String sql = "  select id_tasa, asignado_a,operado_por, contrato,NUM_CTE, estatus,"
				+ "     FECHA_CAPTURA, FECHA_ESTATUS, " + "     FECHA_AUTORI, observa_web, CAMPANA_WEB, SOEID_RESP "
				+ "     from uec_tb_tasas_timeliness " + "     where  TRUNC(fecha_captura)   "
				+ "     BETWEEN  TO_DATE('" + date1 + "','YYYY-MM-DD')" + "     AND TO_DATE('" + date2
				+ "','YYYY-MM-DD')";
		
		LOGGER.info("Query - Method -  getTimelinessPorFecha" + " " + sql.toString());		
		
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new TasasTimeLinessDTO(cc.getLong("ID_TASA"), cc.getString("asignado_a"),
						cc.getString("operado_por"), cc.getLong("CONTRATO"), cc.getLong("NUM_CTE"),
						cc.getString("ESTATUS"), cc.getTimestamp("FECHA_CAPTURA"), cc.getTimestamp("FECHA_AUTORI"),
						cc.getTimestamp("FECHA_ESTATUS"), cc.getString("OBSERVA_WEB"), cc.getString("CAMPANA_WEB"),
						cc.getString("SOEID_RESP")));
	}

	@Transactional
	public Integer getVolumenPorFecha(String date1) {

		String sql = "Select count(*) Conteo from uec_tb_tasas where is_web=1 AND" + " " + "   FECHA_OPE  =  TO_DATE('"
				+ date1 + "','YYYY-MM-DD')";
		
		LOGGER.info("Query - Method -  getVolumenPorFecha" + " " + sql.toString());		
		
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if(count==null) {
			count =0;
		}
		
		return count;

	}
	
	@Transactional
	public Integer getVolumenAsignadas(String date1, String soeid) {

		String sql = " Select count(SOEID_ASIG) operaciones from uec_tb_autotasas where SOEID_ASIG like '" + soeid + "' AND"
				+ "  TRUNC(fecha_solic)= TO_DATE('" + date1 + "', 'YYYY-MM-DD')";

		
		LOGGER.info("Query - Method -  getVolumenAsignadas" + " " + sql.toString());
		
		
		Integer operaciones = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if(operaciones==null) {
			operaciones =0;
		}
		
		
		return operaciones;
		
	}
		
	@Transactional
	public Integer getVolumenOperadas(String date1, String soeid) {

		String sql = "SELECT count(SOEID_OPE) operaciones FROM uec_tb_autotasas Where SOEID_OPE like '" + soeid + "' AND"
				+ "   TRUNC(fecha_solic)= TO_DATE('" + date1 + "', 'YYYY-MM-DD') "
				+ " ";
		
		LOGGER.info("Query - Method -  getVolumenOperadas" + " " + sql.toString());
		
		Integer operaciones = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if(operaciones==null) {
			operaciones =0;
		}
		
		return operaciones;
	}
	
	@Transactional
	public Integer getVolumenReproceso(String date1, String soeid) {

		String sql = "SELECT count(SOEID_RESP) operaciones FROM uec_tb_tasas_reproceso Where trim(SOEID_RESP) like '" + soeid + "' "
				+ "   AND FECHA_OPE = TO_DATE('" + date1 + "', 'YYYY-MM-DD')";
		
		LOGGER.info("Query - Method -  getVolumenReproceso" + " " + sql.toString());

		Integer operaciones = jdbcTemplate.queryForObject(sql, Integer.class);
		
		
		if(operaciones==null) {
			operaciones =0;
		}
		
		
		
		return operaciones;
	}
		
	@Transactional
	public Integer getVolumenTimeliness(String date1, String soeid) {

		String sql = "SELECT count(SOEID_RESP) operaciones FROM uec_tb_tasas_timeliness Where trim(SOEID_RESP) like '" + soeid + "' "
				+ "        AND TRUNC(FECHA_ESTATUS)=  TO_DATE('" + date1 + "', 'YYYY-MM-DD') "
				+ "  ";

		
		LOGGER.info("Query - Method -  getVolumenTimeliness" + " " + sql.toString());
		
		
		Integer operaciones = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if(operaciones==null) {
			operaciones =0;
		}
		
		
		return operaciones;
	}	
		
	@Transactional
	public Integer obtenerVolumen(String date1) {

		String sql = "select count(*) volumen from uec_tb_autotasas where TRUNC(fecha_solic) = TO_DATE('" + date1 + "', 'YYYY-MM-DD')"
				+ "   and soeid_asig is not null and soeid_asig != ' '";

		
		LOGGER.info("Query - Method -  obtenerVolumen" + " " + sql.toString());
		
		
		Integer volumen = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if(volumen==null) {
			volumen =0;
		}
		
		return volumen;
	}	
	
	@Transactional
	public Integer obtenerMonto(String date1) {

		String sql = "select sum(monto)/1000000 monto from uec_tb_autotasas "
				+ "where TRUNC(fecha_solic) = TO_DATE('" + date1 + "', 'YYYY-MM-DD')  "
				+ "                             and soeid_asig is not null and soeid_asig != ' '";
				
		
		LOGGER.info("Query - Method -  obtenerMonto" + " " + sql.toString());
		
		

		Integer monto = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if(monto==null) {
			monto =0;
		}
		
		return monto;
	}	

	@Transactional
	public Integer obtenerVolTimeliness(String date1) {

		String sql = "select count(*) volumen from uec_tb_tasas_timeliness where "
				+ " TRUNC(FECHA_ESTATUS)=  TO_DATE('" + date1 + "', 'YYYY-MM-DD')";
		
		LOGGER.info("Query - Method -  obtenerVolTimeliness" + " " + sql.toString());
		
		

		Integer volumen = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if(volumen==null) {
			volumen =0;
		}
		
		return volumen;
	}	
	
	@Transactional
	public Integer obtenerVolAccuracy(String date1) {

		String sql = "select count(*) volumen from uec_tb_tasas_reproceso where "
				+ "FECHA_OPE = TO_DATE('" + date1 + "', 'YYYY-MM-DD')";

		
		LOGGER.info("Query - Method -  obtenerVolAccuracy" + " " + sql.toString());
		
		
	    Integer volumen = jdbcTemplate.queryForObject(sql, Integer.class);
	    
	    if(volumen==null) {
			volumen =0;
		}
				
		return volumen;
	}			
	
	@Transactional
	public Integer obtenerOperadoresporDia(String date1) {

		String sql =" SELECT Count(distinct(SOEID_OPE)) operadores FROM uec_tb_autotasas "
				+ "     WHERE SOEID_OPE is not null and SOEID_OPE not in('','RA27169') "
				+ "                           AND TRUNC(fecha_solic) = TO_DATE('" + date1 + "', 'YYYY-MM-DD')";
		
		LOGGER.info("Query - Method -  obtenerOperadoresporDia" + " " + sql.toString());
		
		
		
		Integer operadores = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if(operadores==null) {
			operadores =0;
		}
		
		return operadores;
	}
	
	/**
	 *  En el codigo .NET esta consulta se encuentra en el siguiente metodo
	 *  ObtenerTasasdeCampanaPorFecha en la siguiente clase (WSFechas.asmx.cs)
	 * @param date1
	 * @param date2
	 * @return
	 */
	@Transactional
	public List<CompletarInformacionKPIDTO> reporteComplementoKPI(String date1, String date2) {

		String sql = "SELECT  ID_TASAUTO, tas.FECHA_PROCESS, ts.NUM_AUTORI_UEC, cs.DIVISION_NOMBRE,"
		+ " cs.DISTRITO_NOMBRE,cs.NOMBRE_SUCURSAL,cs.DISTRITO_ID,"
		+ " tas.SUC_SOLIC,tas.NOMINA,tas.NOMEJEC,tas.NUM_CTE,tas.CONTRATO,tas.NOM_CTE, tas.ID_CAMPANA,"
		+ " tas.TIPO_AUTORI,tas.MONTO,tas.PLAZO,tas.TASA_AUTORI, tas.soeid_proc, "
		+ " tas.ESTATUS as  ESTATUSAUTOTASAS, ts.ESTATUS as STAT,tas.FECHA_ESTATUS,tas.FECHA_SOLIC,tas.OBSERVA_WEB,"
		+ " tas.SOEID_OPE,tas.NUM_AUTORI_UEC as Folio_UEC,tas.SOEID_ASIG,  "
		+ " tas.SOEID_AUTORI, tas.is_portabilidad as folioporta                         "
		+ " from uec_tb_autotasas tas "
		+ " left join per_cat_sucursales cs on cs.SIRH_SUCURSAL_ID= tas.SUC_SOLIC     "
		+ " left join uec_tb_tasas ts on ts.num_autori_uec= tas.NUM_AUTORI_UEC and ts.FECHA_OPE = tas.FECHA_SOLIC "
		+ " where TRUNC(tas.fecha_solic)  BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') AND TO_DATE('" + date2+ "','YYYY-MM-DD')" + " ";  
				
		
		LOGGER.info("Query - Method -  reporteComplementoKPI" + " " + sql.toString());
		
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new CompletarInformacionKPIDTO(
				   cc.getLong("ID_TASAUTO"),cc.getLong("NUM_AUTORI_UEC"),
				   cc.getTimestamp("FECHA_SOLIC"),cc.getString("ESTATUSAUTOTASAS"),cc.getLong("STAT"),
				   cc.getString("TIPO_AUTORI"),cc.getString("CONTRATO"),cc.getLong("NUM_CTE"),
				   cc.getString("NOM_CTE"),cc.getString("DIVISION_NOMBRE"),cc.getString("NOMBRE_SUCURSAL"),
				   cc.getString("OBSERVA_WEB"),cc.getLong("SUC_SOLIC"), cc.getLong("MONTO"),
				   cc.getLong("PLAZO"),cc.getLong("TASA_AUTORI"),cc.getString("SOEID_ASIG"),
				   cc.getString("soeid_proc"),cc.getString("SOEID_OPE"),cc.getString("NOMINA"),
				   cc.getString("NOMEJEC"), cc.getDate("FECHA_PROCESS"),cc.getString("SOEID_AUTORI")						
				));
	}
		
	@Transactional
	public List<FechasFestivasDTO> obtenerListaFechas() {
		

		String sql = "SELECT id_fecha, descripcion, fecha FROM  uec_tb_cat_fechas_festivas ORDER BY fecha ASC";
		
		LOGGER.info("Query - Method -  obtenerListaFechas Festivas " + " " + sql.toString());
		
		
				
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new FechasFestivasDTO(
						cc.getLong("id_fecha"),cc.getDate("fecha"),cc.getString("descripcion")										
						));
	     }
		
	@Transactional
	public  void  guardarFecha(FechasFestivas fechasFestivas) throws ParseException {
		LOGGER.info("guardarFecha - Fechas Festivas" + fechasFestivas.toString());
		
		
		String sql = "Select max(id_fecha) from UEC_TB_CAT_FECHAS_FESTIVAS";
		
		Integer max  = jdbcTemplate.queryForObject(sql, Integer.class);
		
		fechasFestivas.setIdFecha(Long.valueOf(max+1));
		
		try {
			fechasFestivasRepository.save(fechasFestivas);	
		} catch (Exception e) {			
			LOGGER.error("guardarFecha - TasasRepository "+ e.getMessage());			
		}	
	}
		
	@Transactional
	public int  borrarFecha(Long id) {
		
		String sql="delete from uec_tb_cat_fechas_festivas WHERE id_fecha = '"+id+"'";
		
		LOGGER.info("Query - Method -  borrarFecha" + " " + sql.toString());
		
		
		
		int res = jdbcTemplate.update(sql);
		
		return res;
		
	}
		
	@Transactional
	public List<ListaUsuariosSoeidDTO> getUsuariosSoeid(String date1, String date2) {
		
		String sql ="select distinct(SOEID) from ( "
				+ "       select distinct(SOEID_OPE) as SOEID from uec_tb_autotasas "
				+ "       where TRUNC(fecha_solic)  BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') "
				+ "		  AND TO_DATE('" + date2+ "','YYYY-MM-DD')  and SOEID_OPE is not null "
				+ "       union all"
				+ "       select distinct(SOEID_ASIG) as SOEID from uec_tb_autotasas"
				+ "       where TRUNC(fecha_solic)  BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') "
				+ "		  AND TO_DATE('" + date2+ "','YYYY-MM-DD') "
				+ "       and SOEID_ASIG is not null  ) consulta where SOEID <>' '"; 
		 
		LOGGER.info("Query - Method -  getUsuariosSoeid" + " " + sql.toString());
		
				
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new ListaUsuariosSoeidDTO(
				  	cc.getString("SOEID")
				));
	}
	
	/**
	 * Se require que pueda dar mantenimiento a través de un 
	 * check list donde aparezcan los soeids de los usuarios 
	 * con rol Operador UEC para activar o desactivar en la generación 
	 * del reporte. Solo se deberán tomar en cuenta para la generación del
	 * reporte a todos los usuarios con rol operador UEC que se encuentren activos.
	 * 
	 * Lo lógica de este servicio se obtuvo de una versión 2 del código .NET.
	 * 
	 * Archivo : Tasas_Personal_KPI_DA.cs
	 * 
	 * En este archivo se encuentran las dos consultas que el usuario comento en una reunion 
	 * que se deben considerar.
	 * 
	 * @param date1
	 * @return
	 */
	@Transactional
	public List<ListaUsuariosSoeidDTO> getUsuariosSoeidActivos(String date1, String date2) {
		
		String sql ="select distinct(SOEID) from ( "
				+ "       select distinct(SOEID_OPE) as SOEID from uec_tb_autotasas "
				+ "       where TRUNC(fecha_solic)  BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') "
				+ "		  AND TO_DATE('" + date2+ "','YYYY-MM-DD')  and SOEID_OPE is not null "
				+ "       union all"
				+ "       select distinct(SOEID_ASIG) as SOEID from uec_tb_autotasas"
				+ "       where TRUNC(fecha_solic)  BETWEEN TO_DATE('" + date1 + "','YYYY-MM-DD') "
				+ "		  AND TO_DATE('" + date2+ "','YYYY-MM-DD') "
				+ "       and SOEID_ASIG is not null  ) consulta where SOEID <>' '"; 
		 
		LOGGER.info("Query - Method -  getUsuariosSoeidActivos" + " " + sql.toString());
		
				
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new ListaUsuariosSoeidDTO(
				  	cc.getString("SOEID")
				));
	}
	
	
	
			
	@Transactional
	public AsignacionesDTO getStatusEjecutivo(String soeid) {
		
		AsignacionesDTO asignacionesDTO  = new AsignacionesDTO();
		Object[] inputs                  = new Object[] {soeid};
		
		String sql ="SELECT nombre FROM uec_tb_asignaciones where soeid =?";
		
		LOGGER.info("Query - Method -  getUsuariosSoeid" + " " + sql.toString());
		
		try {
			String nombre = jdbcTemplate.queryForObject(sql, inputs, String.class);
		    asignacionesDTO.setNombre(nombre);		    
		} catch (Exception e) {
			asignacionesDTO.setNombre(MensajesUtils.SOEIDNOENCONTRADO);
		}
	        
	    return asignacionesDTO;		
	}	
	
	
	@Transactional
	public AsignacionesDTO getUsuariosSoeid(String soeid) {
		
		AsignacionesDTO asignacionesDTO  = new AsignacionesDTO();
		Object[] inputs                  = new Object[] {soeid};
		
		String sql ="SELECT nombre FROM uec_tb_asignaciones where soeid =?";
		
		LOGGER.info("Query - Method -  getUsuariosSoeid" + " " + sql.toString());
		
		try {
			String nombre = jdbcTemplate.queryForObject(sql, inputs, String.class);
		    asignacionesDTO.setNombre(nombre);		    
		} catch (Exception e) {
			asignacionesDTO.setNombre(MensajesUtils.SOEIDNOENCONTRADO);
		}
	        
	    return asignacionesDTO;		
	}	
	
	
	
	@Transactional
	public AsignacionesDTO getUsuariosSoeidActivoAsignaciones(String soeid) {
		
		AsignacionesDTO asignacionesDTO  = new AsignacionesDTO();
		Object[] inputs                  = new Object[] {soeid};
		
		String sql ="SELECT nombre FROM uec_tb_asignaciones where soeid =?";
		
		LOGGER.info("Query - Method -  getUsuariosSoeid" + " " + sql.toString());
		
		try {
			String nombre = jdbcTemplate.queryForObject(sql, inputs, String.class);
		    asignacionesDTO.setNombre(nombre);		    
		} catch (Exception e) {
			asignacionesDTO.setNombre(MensajesUtils.SOEIDNOENCONTRADO);
		}
	        
	    return asignacionesDTO;		
	}
	
	
	
	@Transactional
	public  void  complementarSolicitudKPI(AutoTasas solicitudDTO) throws ParseException {
		LOGGER.info("ComplementarSolicitudKPI" + solicitudDTO.toString());
		try {
			autoTasasRepository.save(solicitudDTO);
			LOGGER.info("Solicitud Actualizada con Exito " + " " +"@Transactional");
		} catch (Exception e) {			
			LOGGER.error("actualizar Solicitud KPI -    -  "+ e.getMessage());			
		}	
	}
	
	
	@Transactional
	public  void  updateInkCancelar(AutoTasas solicitudDTO) throws ParseException {
		LOGGER.info("updateInkCancelar" + solicitudDTO.toString());
		try {
			autoTasasRepository.save(solicitudDTO);
			LOGGER.info("Solicitud Actualizada con Exito " + " " +"@Transactional");
		} catch (Exception e) {			
			LOGGER.error("actualizar updateInkCancelar -    -  "+ e.getMessage());			
		}	
	}
	
	
	
	@Transactional
	public int  borrarContratosRepetidos(List<Long> lsContratosRepetidos) {
		
		int res=0;	

		for (Long deleteContrato : lsContratosRepetidos) {
			String sql = "delete from uec_tb_tasas WHERE ID_TASA= '" +  deleteContrato +"'";
		    res = jdbcTemplate.update(sql);
		}
		
		LOGGER.info("Respuesta " + " " +"borrarContratosRepetidos" + " " + res);
		
		return res;
		
	}
	
	@Transactional
	public int  borrarClienteRepetidos(List<Long> lsClientesRepetidos) {
		
		int res=0;
		
		for (Long deleteClientes : lsClientesRepetidos) {
			String sql="delete from uec_tb_autotasas WHERE ID_TASAUTO= '"+ deleteClientes  + "'";
			res = jdbcTemplate.update(sql);
		}
		
		LOGGER.info("Respuesta " + " " +"borrarClienteRepetidos" + " " + res);
		
		return res;
		
	}
	
	@Transactional
	public int  borrarObservacionesDigitosEnTasa(List<Long> lsRegistros) {
		
		int res=0;
		
		for (Long deleteRegistros : lsRegistros) {
			String sql="delete from uec_tb_autotasas WHERE ID_TASAUTO= '"+ deleteRegistros  + "'";
			res = jdbcTemplate.update(sql);
		}
		
		LOGGER.info("Respuesta " + " " +"borrarObservacionesDigitosEnTasa" + " " + res);
		
		return res;
		
	}
	
	
	@Transactional
	public  void  editarFechasFestivas(FechasFestivas fechasFestivas) throws ParseException {
		LOGGER.info("editarFechasFestivas" + fechasFestivas.toString());
		try {
			fechasFestivasRepository.save(fechasFestivas);
			LOGGER.info("Fecha Festiva Editada con Exito " + " " +"@editarFechasFestivas");
		} catch (Exception e) {			
			LOGGER.error("editarFechasFestivas Error -    -  "+ e.getMessage());			
		}	
	}
	
	
	@Transactional
	public List<PerCatParametrosDTO> getParametros() {

		String sql = "Select PARAMETRO_ID, PARAMETRO_NOM,PARAMETRO_VALOR from per_cat_parametros";
		
		LOGGER.info("Query - Method -  getParametros" + " " + sql.toString());		
		
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new PerCatParametrosDTO(cc.getLong("PARAMETRO_ID"), cc.getString("PARAMETRO_NOM"),
						cc.getString("PARAMETRO_VALOR")));
	}
	
	
	/**
	 * 
	 * @param lsReprocesos
	 * @return
	 * 
	 * Metodo para eliminar Reprocesos
	 */
	@Transactional
	public int  eliminarReprocesos(List<Long> lsReprocesos) {
		
		int res=0;
		
		for (Long reproceso : lsReprocesos) {
			String sql="delete from uec_tb_tasas_reproceso where id_tasa='" +  reproceso +"'";
			res = jdbcTemplate.update(sql);
		}
		
		LOGGER.info("Respuesta " + " " +"eliminarReprocesos" + " " + res);
		
		return res;
		
	}
	
	
	/**
	 * 
	 * @param lsReprocesos
	 * @return
	 */
	@Transactional
	public int  eliminarTimeLiness(List<Long> lsReprocesos) {
		
		int res=0;
		
		for (Long reproceso : lsReprocesos) {
			String sql="delete from uec_tb_tasas_timeliness where id_tasa='" +  reproceso +"'";
			res = jdbcTemplate.update(sql);
		}
		
		LOGGER.info("Respuesta " + " " +"eliminarTimeLiness" + " " + res);
		
		return res;
		
	}
	
	
	@Transactional
	public List<AutoTasasDTO> getAutoTasasSoeidAsignacionPendiente() {

		String sql = "SELECT * FROM UEC_TB_AUTOTASAS WHERE ESTATUS='ACEPTADA' AND SOEID_ASIG IS NULL";
		
		LOGGER.info("Query - Method -  getAutoTasasSoeidAsignacionPendiente" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new AutoTasasDTO(
						cc.getLong("ID_TASAUTO"), 
						cc.getTimestamp("FECHA_SOLIC"),
						cc.getTimestamp("FECHA_AUTORI"),
						cc.getTimestamp("FECHA_PROCESS"),
						cc.getTimestamp("FECHA_ESTATUS"),
						cc.getLong("IS_PROCESS"), 
						cc.getString("ESTATUS"),
						cc.getLong("SUC_SOLIC"), 
						cc.getString("DIVISION"),
						cc.getLong("NUM_CTE"), 
						cc.getString("NOM_CTE"),
						cc.getString("CONTRATO"),
						cc.getString("NOMINA"),
						cc.getString("NOMEJEC"),						
						cc.getDouble("MONTO"),
						cc.getLong("PLAZO"),
						cc.getDouble("TASA_AUTORI"),
						cc.getString("TIPO_AUTORI"),
						cc.getString("SOEID_AUTORI"),
						cc.getString("INIC_AUTORI"),
						cc.getLong("NUM_AUTORI_UEC"),
						cc.getString("SOEID_ASIG"),
						cc.getString("SOEID_PROC"),
						cc.getString("SOEID_OPE"),
						cc.getLong("CETE"),
						cc.getLong("PORCEN_CETE"),
						cc.getString("OBSERVA_WEB"),
						cc.getString("JUSTIFICACION"),
						cc.getString("CEL"),
						cc.getLong("T_PER"),
						cc.getDate("FECHA_SOLIC_CANCEL"),
						cc.getString("NOMINA_CANCEL"),
						cc.getString("NOMEJEC_CANCEL"),
						cc.getString("JUSTIFICACION_CANCEL"),
						cc.getString("REINVERSION"),
						cc.getLong("IS_CUENTA_MAESTRA"),
						cc.getString("IS_PORTABILIDAD"),
						cc.getString("EMAIL"),
						cc.getString("AUTORIZADORES"),
						cc.getString("CERTIFICADO_FISICO"),
						cc.getString("CERTIFICADO_MORAL"),
						cc.getString("SUC"),
						cc.getString("ID_CAMPANA"),
						cc.getLong("MONTOVENTAS"),
						cc.getLong("VENTAS"),
						cc.getString("DISTRITO"),
						cc.getFloat("CAPITA"),
						cc.getFloat("EJECUTIVOS"),
						cc.getString("OFERTA_ID"),
						cc.getString("DISTRITO_NOMBRE"),
						cc.getFloat("EJECUTIVO_TOTAL"),
						cc.getString("ESTATUS_CLIENTE")
						));
	}	
	
	@Transactional
	public  void  asignarPendientesEjecutivo(AutoTasas solicitudDTO) throws ParseException {
		LOGGER.info("asignarPendientesEjecutivo" + solicitudDTO.toString());
		try {
			autoTasasRepository.save(solicitudDTO);
			LOGGER.info("Asignacion AutoTasas SOEID con Exito " + " " +"@Transactional");
		} catch (Exception e) {			
			LOGGER.error("Asignacion AutoTasas SOEID -    -  "+ e.getMessage());			
		}	
	}	
	
	@Transactional
	public AsignacionesDTO getAsignacionesBySoeid(String soeid) {

		String sql = "SELECT * FROM UEC_TB_ASIGNACIONES WHERE SOEID='" + soeid + "'";
		
		LOGGER.info("Query - Method -  getAsignacionesBySoeid" + " " + sql.toString());
		
		AsignacionesDTO asignaciones = new AsignacionesDTO();
		
		try {
			asignaciones =  jdbcTemplate.queryForObject(sql,
					(cc, rowNum) -> new AsignacionesDTO(cc.getString("ID"), cc.getString("SOEID"),
							cc.getLong("ONLINE_"),cc.getString("NOMBRE")));
						
		} catch (Exception e) {
			LOGGER.error("Asignacion - getAsignacionesBySoeid" + " " + e.getMessage());
		}
		
		LOGGER.info("getAsignacionesBySoeid" + asignaciones.toString());
		
		
		return asignaciones;
	}
	
	@Transactional
	public List<FolioNumAutorizacionDTO> getFoliosAutorizacion(String numAutoriEuc) {
		
		String sql =  "select ID_TASAUTO,FECHA_SOLIC,ESTATUS,SOEID_ASIG,NUM_AUTORI_UEC " + " " 
				+ "from UEC_TB_AUTOTASAS where  TRUNC(FECHA_SOLIC) = TO_DATE(to_char(SYSDATE, 'MM/DD/YY'),'MM/DD/YY')" + " "
				+ " AND NUM_AUTORI_UEC='"+ numAutoriEuc  + "'";
		
		LOGGER.info("Query - Method -  getFoliosAutorizacion  " + " " + sql.toString());
		
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new FolioNumAutorizacionDTO(
						cc.getLong("ID_TASAUTO"),cc.getTimestamp("FECHA_SOLIC"),cc.getString("ESTATUS"),cc.getString("SOEID_ASIG"),
						cc.getLong("NUM_AUTORI_UEC")
						));
	  }	
	
	/**
	 * Metodo Para la funcionalidad de Operaciones UEC
	 * 
	 * @param campana
	 * @param fecha
	 * @return
	 */
	@Transactional
	public List<AutoTasasDTO> obtenerRegistrosDeClienteRepetidosPorCampana(String campana, String fecha) {

		String sql = "SELECT num_cte, count(num_cte) "
				+ " FROM uec_tb_autotasas WHERE  TIPO_AUTORI like '" + campana + "'"
				+ " and   to_date(to_char(FECHA_SOLIC, 'MM/DD/YY'),'MM/DD/YY')"
				+ " = to_date(to_char(SYSDATE, 'MM/DD/YY'),'MM/DD/YY')"
				+ "	group by NUM_CTE having count(num_cte)>1";
				
		LOGGER.info("Query - Method -  obtenerRegistrosDeClienteRepetidosPorCampana" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new AutoTasasDTO(cc.getLong("num_cte")));
		
		
	}
	/**
	 * Metodo Para la funcionalidad de Operaciones UEC
	 * 
	 * Para fechas null
	 * @param campana
	 * @param fecha
	 * @return
	 */
	@Transactional
	public List<AutoTasasDTO> obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(String campana, String fecha) {

		String sql = "SELECT num_cte, count(num_cte) "
				+ " FROM uec_tb_autotasas WHERE  TIPO_AUTORI like '" + campana + "'"
				+ "	group by NUM_CTE having count(num_cte)>1";
				
		LOGGER.info("Query - Method -  obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new AutoTasasDTO(cc.getLong("num_cte")));
		
		
	}
	
	
	/**
	 * Metodo para funcionalidad de Oeraciones UEC
	 */
	
	@Transactional
	public List<AutoTasasDTO> obtenerRegistrosAutoTasas(String fecha, String estatus, String contrato, String cliente) {

	 
		
		StringBuilder sql = new StringBuilder("SELECT tas.nomina_cancel,\r\n" + 
				"       tas.nomejec_cancel,\r\n" + 
				"       tas.justificacion_cancel,\r\n" + 
				"       ofer.oferta_nombre_largo,\r\n" + 
				"       ofer.oferta_campania_id,\r\n" + 
				"       tas.id_campana,\r\n" + 
				"       tas.estatus_cliente,\r\n" + 
				"       tas.oferta_id,\r\n" + 
				"       tas.distrito_nombre,\r\n" + 
				"       tas.id_tasauto,\r\n" + 
				"       tas.fecha_solic,\r\n" + 
				"       tas.fecha_autori,\r\n" + 
				"       tas.fecha_estatus,\r\n" + 
				"       tas.estatus,\r\n" + 
				"       nvl( (select INIC from UEC_CATALOGO_AUTORIZADORES2021 where SOEID = tas.SOEID_AUTORI),'' ) autorizadores,       \r\n" + 
				"       tas.suc_solic,\r\n" + 
				"       tas.division,\r\n" + 
				"       tas.num_cte,\r\n" + 
				"       tas.nom_cte,\r\n" + 
				"       tas.contrato,\r\n" + 
				"       tas.nomina,\r\n" + 
				"       tas.nomejec,\r\n" + 
				"       tas.monto,\r\n" + 
				"       tas.plazo,\r\n" + 
				"       tas.tasa_autori,\r\n" + 
				"       tas.tipo_autori,\r\n" + 
				"       tas.soeid_autori,\r\n" + 
				"       tas.soeid_asig,\r\n" + 
				"       tas.soeid_ope,\r\n" + 
				"       tas.inic_autori,\r\n" + 
				"       tas.num_autori_uec,\r\n" + 
				"       tas.cete,\r\n" + 
				"       tas.porcen_cete,\r\n" + 
				"       tas.observa_web,\r\n" + 
				"       tas.justificacion,\r\n" + 
				"       tas.cel,\r\n" + 
				"       Concat(\r\n" + 
				"       Concat(Concat(sucu.sirh_sucursal_id, ' - '),\r\n" + 
				"       Concat(sucu.nombre_sucursal, ' - ')), sucu.distrito_nombre) AS suc\r\n" + 
				"FROM   uec_tb_autotasas tas\r\n" + 
				"       LEFT JOIN per_cat_sucursales sucu\r\n" + 
				"              ON tas.suc_solic = sucu.sirh_sucursal_id\r\n" + 
				"       LEFT JOIN uec_tb_autorizadores_elegidos eleg\r\n" + 
				"              ON tas.id_tasauto = eleg.id_tasaauto\r\n" + 
				"       LEFT JOIN per_cat_oferta ofer\r\n" + 
				"              ON tas.tipo_autori = ofer.oferta_id\r\n" + 
				"WHERE  1 = 1 \r\n" );		
		/**
		 *  CASO CON EL QUE INICIA  
		 */
		
		if(!fecha.equals("") && estatus.equals("ACEPTADA") && contrato.equals("") && cliente.equals("") ) {
			sql.append("and TRUNC(tas.fecha_solic) = TO_DATE('" + fecha + "','YYYY-MM-DD')");	
			sql.append("AND tas.ESTATUS like '" + estatus + "'");
			LOGGER.info("fecha.equals() estatus.equals(ACEPTADA) " + " " + sql.toString());
		}else if(!fecha.equals("") && estatus.equals("TODAS") && !contrato.equals("")) {
			sql.append("and TRUNC(tas.fecha_solic) = TO_DATE('" + fecha + "','YYYY-MM-DD')");
			sql.append("and tas.CONTRATO = '" + contrato + "'");			
			LOGGER.info("and TRUNC(tas.fecha_solic) = " + " " + sql.toString());
	    }else if(!fecha.equals("") && estatus.equals("TODAS") && !cliente.equals("")) {
			sql.append("and TRUNC(tas.fecha_solic) = TO_DATE('" + fecha + "','YYYY-MM-DD')");
			sql.append("AND tas.NUM_CTE like '" + cliente + "'");
			LOGGER.info("and TRUNC(tas.fecha_solic) = " + " " + sql.toString());
	    }else if(!fecha.equals("") && !estatus.equals("")  && !estatus.equals("TODAS") &&  !contrato.equals("")) {
				sql.append("and TRUNC(tas.fecha_solic) = TO_DATE('" + fecha + "','YYYY-MM-DD')");
				sql.append("and tas.CONTRATO = '" + contrato + "'");
				sql.append("AND tas.ESTATUS like '" + estatus + "'");
				LOGGER.info("and TRUNC(tas.fecha_solic) = " + " " + sql.toString());
		 }else if(!fecha.equals("") && !estatus.equals("") && !estatus.equals("TODAS")  && !cliente.equals("")) {
				sql.append("and TRUNC(tas.fecha_solic) = TO_DATE('" + fecha + "','YYYY-MM-DD')");
				sql.append("AND tas.NUM_CTE like '" + cliente + "'");
				sql.append("AND tas.ESTATUS like '" + estatus + "'");
				LOGGER.info("and TRUNC(tas.fecha_solic) = " + " " + sql.toString());
		 }	else if(!fecha.equals("") && !estatus.equals("")  && !estatus.equals("TODAS") && !cliente.equals("") && !contrato.equals("")) {
				sql.append("and TRUNC(tas.fecha_solic) = TO_DATE('" + fecha + "','YYYY-MM-DD')");
				sql.append("and tas.CONTRATO = '" + contrato + "'");
				sql.append("AND tas.ESTATUS like '" + estatus + "'");
				sql.append("AND tas.NUM_CTE like '" + cliente + "'");
				LOGGER.info("and TRUNC(tas.fecha_solic) = " + " " + sql.toString());
		 }else if(!fecha.equals("") && estatus.equals("TODAS")) {
				sql.append("and TRUNC(tas.fecha_solic) = TO_DATE('" + fecha + "','YYYY-MM-DD')");
				LOGGER.info("and TRUNC(tas.fecha_solic) = " + " " + sql.toString());
		 }else if(!fecha.equals("") && !estatus.equals("TODAS") && !estatus.equals("")) {
			    sql.append("AND tas.ESTATUS like '" + estatus + "'");
				sql.append("and TRUNC(tas.fecha_solic) = TO_DATE('" + fecha + "','YYYY-MM-DD')");				
		 }	
			
		
				
		sql.append("  ORDER BY tas.FECHA_SOLIC ASC");
						
		LOGGER.info("Query - Method -  obtenerRegistrosAutoTasas - " + " " + sql.toString());

		return jdbcTemplate.query(sql.toString(),
				(cc, rowNum) -> new AutoTasasDTO(
						cc.getLong("ID_TASAUTO"),
						cc.getTimestamp("FECHA_SOLIC"),
						cc.getTimestamp("FECHA_AUTORI"),
						cc.getTimestamp("FECHA_ESTATUS"),						
						cc.getString("ESTATUS"),
						cc.getLong("SUC_SOLIC"),						
						cc.getLong("NUM_CTE"),						
						cc.getString("NOM_CTE"),
						cc.getString("CONTRATO"),
						cc.getString("NOMINA"),
						cc.getString("NOMEJEC"),
						cc.getDouble("MONTO"),
						cc.getLong("PLAZO"),						
						cc.getDouble("TASA_AUTORI"),
						cc.getString("TIPO_AUTORI"),
						cc.getString("SOEID_AUTORI"),
						cc.getString("INIC_AUTORI"),
						cc.getLong("NUM_AUTORI_UEC"),
						cc.getString("SOEID_ASIG"),
						cc.getString("SOEID_OPE"),						
						cc.getLong("CETE"),
						cc.getLong("PORCEN_CETE"),
						cc.getString("OBSERVA_WEB"),
						cc.getString("JUSTIFICACION"),
						cc.getString("cel"),
						cc.getString("autorizadores"),
						cc.getString("suc"),
						cc.getString("DISTRITO_NOMBRE"),
						cc.getString("OFERTA_ID"),
						cc.getString("ID_CAMPANA"),
						cc.getString("NOMINA_CANCEL"),
						cc.getString("NOMEJEC_CANCEL"),
						cc.getString("JUSTIFICACION_CANCEL"),
						cc.getString("ESTATUS_CLIENTE"),
						cc.getString("OFERTA_CAMPANIA_ID")
						));	
		
	}
	
	
	@Transactional
	public List<AutoTasasDTO> obtenerRegistrosAutoTasasV1(String fecha, String estatus, String contrato, String cliente) {
		
		StringBuilder sql = new StringBuilder("SELECT tas.NOMINA_CANCEL,tas.NOMEJEC_CANCEL,tas.JUSTIFICACION_CANCEL,"
			    + " ofer.OFERTA_NOMBRE_LARGO,ofer.OFERTA_CAMPANIA_ID, "
				+ "tas.ID_CAMPANA,tas.ESTATUS_CLIENTE,tas.OFERTA_ID,tas.DISTRITO_NOMBRE, tas.ID_TASAUTO,tas.FECHA_SOLIC,tas.FECHA_AUTORI,tas.FECHA_ESTATUS,tas.ESTATUS, "
				+ "eleg.autorizadores,"
				+ "	   tas.SUC_SOLIC,tas.DIVISION,tas.NUM_CTE,tas.NOM_CTE,tas.CONTRATO, tas.NOMINA,tas.NOMEJEC,tas.MONTO,tas.PLAZO, "
				+ "	   tas.TASA_AUTORI,tas.TIPO_AUTORI,tas.SOEID_AUTORI,tas.SOEID_ASIG, tas.SOEID_OPE,tas.INIC_AUTORI,tas.NUM_AUTORI_UEC, "
				+ "	   tas.CETE,tas.PORCEN_CETE, tas.OBSERVA_WEB, tas.JUSTIFICACION, tas.CEL , "
				+ "	   concat(concat(concat(sucu.SIRH_SUCURSAL_ID,' - '),concat(sucu.NOMBRE_SUCURSAL,' - ')),sucu.DISTRITO_NOMBRE) as suc" + " " 
				+ "	   FROM uec_tb_autotasas tas left join per_cat_sucursales sucu on tas.SUC_SOLIC=sucu.SIRH_SUCURSAL_ID "
				+ "	   left join uec_tb_autorizadores_elegidos eleg on tas.ID_TASAUTO = eleg.ID_TASAAUTO "
				+ "    left join  per_cat_oferta ofer on tas.TIPO_AUTORI = ofer.Oferta_Id"
				+ "				where 1=1    ");

		/**
		 *  CASO CON EL QUE INICIA  
		 */
		if(!cliente.equals("") ) {
			sql.append("AND tas.NUM_CTE like '" + cliente + "'");
		}
				
		sql.append("  ORDER BY tas.FECHA_SOLIC ASC");
						
		LOGGER.info("Query - Method -  obtenerRegistrosAutoTasas - " + " " + sql.toString());

		return jdbcTemplate.query(sql.toString(),
				(cc, rowNum) -> new AutoTasasDTO(
						cc.getLong("ID_TASAUTO"),
						cc.getTimestamp("FECHA_SOLIC"),
						cc.getTimestamp("FECHA_AUTORI"),
						cc.getTimestamp("FECHA_ESTATUS"),						
						cc.getString("ESTATUS"),
						cc.getLong("SUC_SOLIC"),						
						cc.getLong("NUM_CTE"),						
						cc.getString("NOM_CTE"),
						cc.getString("CONTRATO"),
						cc.getString("NOMINA"),
						cc.getString("NOMEJEC"),
						cc.getDouble("MONTO"),
						cc.getLong("PLAZO"),						
						cc.getDouble("TASA_AUTORI"),
						cc.getString("TIPO_AUTORI"),
						cc.getString("SOEID_AUTORI"),
						cc.getString("INIC_AUTORI"),
						cc.getLong("NUM_AUTORI_UEC"),
						cc.getString("SOEID_ASIG"),
						cc.getString("SOEID_OPE"),						
						cc.getLong("CETE"),
						cc.getLong("PORCEN_CETE"),
						cc.getString("OBSERVA_WEB"),
						cc.getString("JUSTIFICACION"),
						cc.getString("cel"),
						cc.getString("autorizadores"),
						cc.getString("suc"),
						cc.getString("DISTRITO_NOMBRE"),
						cc.getString("OFERTA_ID"),
						cc.getString("ID_CAMPANA"),
						cc.getString("NOMINA_CANCEL"),
						cc.getString("NOMEJEC_CANCEL"),
						cc.getString("JUSTIFICACION_CANCEL"),
						cc.getString("ESTATUS_CLIENTE"),
						cc.getString("OFERTA_CAMPANIA_ID")
						));	
		
	}
	
	
	@Transactional
	public PerCatSucursalesDTO obtenerSucursal(String sirh) {

		String sql = "select concat(concat(concat(SIRH_SUCURSAL_ID,' - '),concat(NOMBRE_SUCURSAL,'-')),DISTRITO_NOMBRE) as suc"
				+ " from  per_cat_sucursales where SIRH_SUCURSAL_ID='" +  sirh +"'";
		
		LOGGER.info("Query - Method - ObtenerSucursal - PerCatSucursalesDTO" + " " + sql.toString());

		PerCatSucursalesDTO perCatSucu =  jdbcTemplate.queryForObject(sql,
				(cc, rowNum) -> new PerCatSucursalesDTO(
						cc.getString("suc")));
		
		return perCatSucu;
		
	}
		
	
	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();

	}
	
	
}
