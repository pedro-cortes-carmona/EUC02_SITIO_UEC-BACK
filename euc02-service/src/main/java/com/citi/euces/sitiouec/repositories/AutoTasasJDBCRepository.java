package com.citi.euces.sitiouec.repositories;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.infra.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.infra.dto.CatFolioDTO;
import com.citi.euces.sitiouec.infra.dto.SolicitudEstatusDTO;
import com.citi.euces.sitiouec.infra.dto.TasasCampanaDTO;
import com.citi.euces.sitiouec.infra.dto.TasasTotal;
import com.citi.euces.sitiouec.infra.dto.TbTasasDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

@Repository
public class AutoTasasJDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(AutoTasasJDBCRepository.class);
	
	public AutoTasasJDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void updateVOBO(SolicitudEstatusDTO items, String idTasa) throws GenericException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String query = " UPDATE UEC_TB_AUTOTASAS SET SOEID_AUTORI ='" + items.getSoeidAutori() + "', "
					+ "  INIC_AUTORI= '" + items.getInicAutori() + "', "
					+ "  ESTATUS= '" + items.getEstatus() + "',"
					+ "  OBSERVA_WEB= '', "
					+ "  SOEID_ASIG= '"+ items.getSoeidAsig()+"', "
					+ "  FECHA_AUTORI = TO_DATE('" + sdf.format(items.getFechaAutori()) + "','DD/MM/YY hh24:mi:ss') , "
					+ "  FECHA_ESTATUS = TO_DATE('" + sdf.format(items.getFechaEstatus()) + "','DD/MM/YY hh24:mi:ss') "
					+ "  WHERE ID_TASAUTO= " + idTasa;
			log.info("UPDATE VOBO: " + query);
			jdbcTemplate.execute(query);	
		}catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al actualizar Sucursales Tasas ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	public void updateCatGralCtes(String fecha) throws GenericException {
		try {
			String query = "UPDATE  ( SELECT tas.T_PER AS v1, CASE cat.FISICA_MORAL WHEN 'PM' THEN 2 ELSE 1 END AS v2 "
					+ " FROM UEC_TB_TASAS tas "
					+ " INNER JOIN UEC_CAT_GRAL_CTES cat "
					+ " ON  tas.NUM_CTE = cat.NUM_CTE "
					+ " WHERE tas.FECHA_OPE = TO_DATE('" + fecha +"','DD/MM/YY')) tb "
					+ " SET tb.v1  =  tb.v2";
			jdbcTemplate.execute(query);	
		}catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al actualizar Sucursales Tasas ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	@Transactional
	public List<SolicitudEstatusDTO> obtenerRegAutoTasa(String idAutoTasa)
	{
		String sql =  " SELECT NVL(FECHA_SOLIC,TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_SOLIC, "
				+ "NVL(FECHA_AUTORI,TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_AUTORI, "
				+ "NVL(FECHA_ESTATUS,TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_ESTATUS, "
				+ "NVL(FECHA_PROCESS,TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_PROCESS, "
				+ "ESTATUS,SUC_SOLIC,DIVISION,NUM_CTE,NOM_CTE,CONTRATO, NOMINA,NOMEJEC,MONTO,PLAZO, "
				+ "TASA_AUTORI,TIPO_AUTORI,NVL(SOEID_AUTORI,'NA') AS SOEID_AUTORI, "
				+ "SOEID_ASIG,NVL(INIC_AUTORI,'NA') AS INIC_AUTORI,NVL(NUM_AUTORI_UEC,0) AS NUM_AUTORI_UEC, "
				+ "CETE,PORCEN_CETE, NVL(OBSERVA_WEB,'NA') AS OBSERVA_WEB, JUSTIFICACION, CEL,NVL(IS_PROCESS,0) AS IS_PROCESS, "
				+ "NVL(FECHA_SOLIC_CANCEL, TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_SOLIC_CANCEL, NVL(NOMINA_CANCEL,'NA') AS NOMINA_CANCEL, "
				+ "NVL(NOMEJEC_CANCEL,'NA') AS NOMEJEC_CANCEL, NVL(JUSTIFICACION_CANCEL,'NA') AS JUSTIFICACION_CANCEL, "
				+ "NVL(b.Autorizadores,'NA') AS Autorizadores "
				+ "FROM UEC_TB_AUTOTASAS a "
				+ "LEFT JOIN UEC_TB_AUTORIZADORES_ELEGIDOS b "
				+ "    ON id_tasauto= id_tasaAuto "
				+ "WHERE ID_TASAUTO = " + idAutoTasa;
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new SolicitudEstatusDTO (
                    cc.getDate("FECHA_SOLIC"),
                    cc.getDate("FECHA_AUTORI"),
                    cc.getDate("FECHA_ESTATUS"),
                    cc.getDate("FECHA_PROCESS"),
                    cc.getString("ESTATUS"),
                    cc.getString("DIVISION"),
                    cc.getInt("SUC_SOLIC"),
                    cc.getLong("NUM_CTE"),
                    cc.getString("NOM_CTE"),
                    cc.getLong("CONTRATO"),
                    cc.getString("NOMINA"),
                    cc.getString("NOMEJEC"),
                    cc.getString("CEL"),
                    cc.getDouble("MONTO"),
                    cc.getInt("PLAZO"),
                    cc.getDouble("TASA_AUTORI"),
                    cc.getString("TIPO_AUTORI"),
                    cc.getString("SOEID_AUTORI"),
                    cc.getString("INIC_AUTORI"),
                    cc.getLong("NUM_AUTORI_UEC"),
                    cc.getDouble("CETE"),
                    cc.getDouble("PORCEN_CETE"),
                    cc.getString("OBSERVA_WEB"),
                    cc.getString("JUSTIFICACION"),
                    cc.getInt("IS_PROCESS"),
                    cc.getDate("FECHA_SOLIC_CANCEL"),
                    cc.getString("NOMEJEC_CANCEL"),
                    cc.getString("JUSTIFICACION_CANCEL"),
                    cc.getString("Autorizadores")
                )
        );
	}
	
	
	@Transactional
    public Long obtieneUltiFolioTasas() throws GenericException {
        try {
            Long id = jdbcTemplate.queryForObject("SELECT MAX(ID_TASAUTO) ID_TASAUTO FROM UEC_TB_AUTOTASAS", Long.class);
            log.info("Valor máx de Autotasas: " + id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el máximo :: UEC_TB_AUTOTASAS ", HttpStatus.NOT_FOUND.toString());
        }
    }
	
	@Transactional
	public List<TasasCampanaDTO> selectTasaCampaña(String fecha1, String fecha2) throws Exception 
	{
		try {
			String sql =  " SELECT ID_TASAUTO, NVL(tas.FECHA_PROCESS,TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_PROCESS, NVL(ts.NUM_AUTORI_UEC,0) AS NUM_AUTORI_UEC , "
					+ "NVL(cs.DIVISION_NOMBRE,'NA') AS DIVISION,NVL(cs.DISTRITO_NOMBRE,'NA') AS DISTRITO,NVL(cs.NOMBRE_SUCURSAL,'NA') AS SUCURSAL, "
					+ "tas.SUC_SOLIC,tas.NOMINA,tas.NOMEJEC,tas.NUM_CTE,tas.CONTRATO,tas.NOM_CTE,"
					+ "tas.TIPO_AUTORI,tas.MONTO,tas.PLAZO,tas.TASA_AUTORI,   tas.ESTATUS, "
					+ "NVL(ts.ESTATUS,0) AS STAT,NVL(tas.FECHA_ESTATUS,TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_ESTATUS,tas.FECHA_SOLIC,NVL(tas.OBSERVA_WEB,'NA') AS OBSERVA_WEB,"
					+ "NVL(tas.SOEID_OPE,'NA') AS SOEID_OPE,NVL(tas.NUM_AUTORI_UEC,0) as Folio_UEC,NVL(tas.SOEID_ASIG,'NA') AS SOEID_ASIG, "
					+ "NVL(tas.SOEID_AUTORI,'NA') AS SOEID_AUTORI,  "
					+ "NVL(tas.IS_PORTABILIDAD,'NA') AS IS_PORTABILIDAD, NVL(tas.OFERTA_ID,'NA') AS OFERTA_ID, cs.SIRH_SUCURSAL_ID, tas.GATNOMINAOFER, tas.GATREALOFER, tas.RENDIMIENTOBRUTO, "
					+ "ts.PRODUCTO, ts.NUM_INVERSION, tas.CERTIFICADO_FISICO, NVL(ts.T_PER,NVL(cat.CLIENTE_TIPO_PERSONA,1)) AS TIPO_PERSONA, NVL(ofer.OFERTA_PDF_ESPECIAL_ID,'NA') AS OFERTA_PDF_ESPECIAL_ID,"
					+ "NVL(camp.CAMPANIAS_ID,tas.ID_CAMPANA) AS CAMPANIAS_ID, NVL(ejec.soied,'NA') AS SOEID_EJEC "
					+ "FROM UEC_TB_AUTOTASAS tas "
					+ "LEFT JOIN UEC_CAT_GRAL_CTES cat ON tas.NUM_CTE = cat.NUM_CTE "
					+ "LEFT JOIN PER_CAT_OFERTA ofer ON tas.TIPO_AUTORI = ofer.OFERTA_ID "
					+ "LEFT JOIN PER_CAT_CAMPANIAS camp ON ofer.OFERTA_CAMPANIA_ID = camp.CAMPANIAS_ID "
					+ "LEFT JOIN PER_CAT_SUCURSALES cs ON cs.SIRH_SUCURSAL_ID= tas.SUC_SOLIC "
					+ "LEFT JOIN UEC_TB_TASAS ts ON ts.num_autori_uec= tas.NUM_AUTORI_UEC AND ts.FECHA_OPE = CAST(TRUNC(tas.FECHA_SOLIC) AS DATE) "
					+ "LEFT JOIN PER_CAT_EJECUTIVO_SUCURSAL ejec ON tas.SUC_SOLIC  = ejec.SIRH_SUCURSAL AND CAST(tas.NOMINA AS NUMBER) = ejec.NOMINA  "
					+ "AND tas.NOMEJEC = ejec.NOMBRE "
					+ "WHERE TRUNC(tas.FECHA_SOLIC) BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "','DD/MM/YY') "
					+ "ORDER BY ID_TASAUTO ";
			return jdbcTemplate.query(sql, (cc, rowNum) ->
			        new TasasCampanaDTO (
			        			cc.getLong("ID_TASAUTO"),
			                    cc.getDate("FECHA_PROCESS"),
			                    cc.getInt("Folio_UEC"),
			                    cc.getString("DIVISION"),
			                    cc.getString("DISTRITO"),
			                    cc.getString("SUCURSAL"),
			                    cc.getInt("SUC_SOLIC"),
			                    cc.getString("NOMINA"),
			                    cc.getString("NOMEJEC"),
			                    cc.getLong("NUM_CTE"),
			                    cc.getString("CONTRATO"),
			                    cc.getString("NOM_CTE"),
			                    cc.getString("TIPO_AUTORI"),
			                    cc.getDouble("MONTO"),
			                    cc.getInt("PLAZO"),
			                    cc.getDouble("TASA_AUTORI"),
			                    cc.getString("ESTATUS"),
			                    cc.getInt("STAT"),
			                    cc.getDate("FECHA_ESTATUS"),
			                    cc.getDate("FECHA_SOLIC"),
			                    cc.getString("OBSERVA_WEB"),
			                    cc.getString("SOEID_OPE"),
			                    cc.getInt("NUM_AUTORI_UEC"),
			                    cc.getString("SOEID_ASIG"),
			                    cc.getString("SOEID_AUTORI"),
			                    cc.getString("IS_PORTABILIDAD"),
			                    cc.getString("OFERTA_ID"),
			                    cc.getString("SIRH_SUCURSAL_ID"),
			                    cc.getString("GATNOMINAOFER"),
			                    cc.getString("GATREALOFER"),
			                    cc.getDouble("RENDIMIENTOBRUTO"),
			                    cc.getString("PRODUCTO"),
			                    cc.getInt("NUM_INVERSION"),
			                    cc.getString("CERTIFICADO_FISICO"),
			                    cc.getInt("TIPO_PERSONA"),
			                    cc.getString("OFERTA_PDF_ESPECIAL_ID"),
			                    cc.getString("CAMPANIAS_ID"),
			                    cc.getString("SOEID_EJEC"),
			                    cc.getString("FECHA_PROCESS"),
			                    cc.getString("FECHA_ESTATUS"),
			                    cc.getString("FECHA_SOLIC")
			        )
			);	
		} catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el autorizador :: UEC_TB_AUTOTASAS ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	@Transactional
	public List<TasasTotal> selectTasaTotal(String fecha1, String fecha2, String campana, String estatus)
	{
		String sql =  " SELECT COUNT(*) AS TOTAL,SUM(tas.MONTO) AS MONTO"
                + " FROM UEC_TB_AUTOTASAS tas "
                + " LEFT JOIN PER_CAT_SUCURSALES cs ON cs.SIRH_SUCURSAL_ID= tas.SUC_SOLIC"
                + " LEFT JOIN UEC_TB_TASAS ts ON ts.num_autori_uec= tas.NUM_AUTORI_UEC AND ts.FECHA_OPE = tas.FECHA_SOLIC "
                + " WHERE tas.FECHA_SOLIC >= TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE(tas.FECHA_SOLIC,'DD/MM/YY') <= TO_DATE('" + fecha2 + "','DD/MM/YY') "
        		+ "  AND tas.TIPO_AUTORI = '" + campana + "'"
        		+ "  AND tas.ESTATUS = '" + estatus + "'";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new TasasTotal (
                    cc.getInt("TOTAL"),
                    cc.getDouble("MONTO")
                )
        );
	}
	
	@Transactional
    public String obtieneAutorizadorAutoTasas(Long idSolicitud) throws GenericException {
        try {
            String id = jdbcTemplate.queryForObject("SELECT SOEID_AUTORI FROM UEC_TB_AUTOTASAS WHERE ID_TASAUTO= " + idSolicitud, String.class);
            if (id == null) {
                id = "";
            }
            log.info("Autorizador: " + id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el autorizador :: UEC_TB_AUTOTASAS ", HttpStatus.NOT_FOUND.toString());
        }

    }
	
	@Transactional
    public Integer validaOfertaExistente(String oferta) throws GenericException {
        try {
            Integer id = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM PER_CAT_OFERTA WHERE OFERTA_ID = '" + oferta + "'", Integer.class);;
            log.info("Oferta: " + id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el autorizador :: UEC_TB_AUTOTASAS ", HttpStatus.NOT_FOUND.toString());
        }

    }
	
	@Transactional
    public String obtieneOfertaParticipacionUnica(String oferta) throws GenericException {
        try {
            String id = jdbcTemplate.queryForObject("SELECT NVL(OFERTA_PARTICIPACION_UNICA,'NA') FROM PER_CAT_OFERTA WHERE OFERTA_ID = '" + oferta + "'", String.class);;
            log.info("Oferta: " + id);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el autorizador :: UEC_TB_AUTOTASAS ", HttpStatus.NOT_FOUND.toString());
        }

    }
	
	@Transactional
    public String obtieneOfertaCampaña(String oferta) throws GenericException {
        try {
        	String id;
            String campID = jdbcTemplate.queryForObject("SELECT NVL(OFERTA_CAMPANIA_ID,'NA') FROM PER_CAT_OFERTA WHERE OFERTA_ID = '" + oferta + "'", String.class);;
            if(campID != "NA") {
            	id = jdbcTemplate.queryForObject("SELECT NVL(CAMPANIAS_NOMBRE,'NA') FROM PER_CAT_CAMPANIAS WHERE CAMPANIAS_ID = '" + campID + "'", String.class);;	
            }else {
            	id = "id";
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el autorizador :: UEC_TB_AUTOTASAS ", HttpStatus.NOT_FOUND.toString());
        }

    }
	
	@Transactional
    public int[][] batchInsert(List<AutoTasasDTO> books, int batchSize) throws GenericException {
		try {
			int[][] updateCounts = jdbcTemplate.batchUpdate(
	                "INSERT INTO UEC_TB_AUTOTASAS(ID_TASAUTO,FECHA_SOLIC,FECHA_AUTORI,FECHA_PROCESS,FECHA_ESTATUS,"
	                + "IS_PROCESS,ESTATUS,SUC_SOLIC,DIVISION,NUM_CTE,NOM_CTE,CONTRATO,NOMINA,NOMEJEC,MONTO,PLAZO,TASA_AUTORI,"
	                + "TIPO_AUTORI,SOEID_AUTORI,INIC_AUTORI,NUM_AUTORI_UEC,SOEID_ASIG,SOEID_PROC,SOEID_OPE,CETE,PORCEN_CETE,ID_CAMPANA, OFERTA_ID) "
	                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
	                books,
	                batchSize,
	                new ParameterizedPreparedStatementSetter<AutoTasasDTO>() {
	                    public void setValues(PreparedStatement ps, AutoTasasDTO content) throws SQLException {
	                    	try {
	                    		ps.setLong(1, content.getIdTasaAuto());
	                    		ps.setDate(2, new Date(content.getFechaSolic().getTime()));
	                    		ps.setDate(3, new Date(content.getFechaAutori().getTime()));
	                    		ps.setDate(4, new Date(content.getFechaProcess().getTime()));
	                    		ps.setDate(5, new Date(content.getFechaEstatus().getTime()));
	                    		ps.setInt(6, content.getIsProcess());
	                    		ps.setString(7, content.getStatus());
	                    		ps.setInt(8, content.getSucSolic());
	                    		ps.setString(9, content.getDivision());
	                    		ps.setInt(10, content.getNumCte());
	                    		ps.setString(11, content.getNomCte());
	                    		ps.setString(12, content.getContrato());
	                    		ps.setString(13, content.getNomina());
	                    		ps.setString(14, content.getNomEjec());
	                    		ps.setDouble(15, content.getMonto());
	                    		ps.setInt(16, content.getPlazo());
	                    		ps.setDouble(17, content.getTasaAutori());
	                    		ps.setString(18, content.getTipoAutori());
	                    		ps.setString(19, content.getSoeidAutori());
	                    		ps.setString(20, content.getInicAutori());
	                    		ps.setInt(21, content.getNumAutoriUEC());
	                    		ps.setString(22, content.getSoeidAsig());
	                    		ps.setString(23, content.getSoeidProc());
	                    		ps.setString(24, content.getSoeidOpe());
	                    		ps.setInt(25, content.getCete());
	                    		ps.setDouble(26, content.getPorcenCete());
	                    		ps.setString(27, content.getIdCampana());
	                    		ps.setString(28, content.getIdOferta());
	                    	} catch (SQLException e) {
	                			e.printStackTrace();
	                        }
	                    }
	                });
	        return updateCounts;	
		} catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al guardar en :: UEC_TB_AUTOTASAS ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	@Transactional
	public List<CatFolioDTO> getFolioEspUtilizado(Long num_cli)throws GenericException {
		try {

			String sql = "SELECT PDF_FOLIO_VALOR, PDF_FOLIO_ESPECIAL_OFERTA_ID, PDF_FOLIO_ID_CLIENTE, PDF_FOLIO_ESTATUS"
					+ " FROM PER_CAT_FOLIO WHERE PDF_FOLIO_ESTATUS = 1 AND PDF_FOLIO_ID_CLIENTE = "+num_cli;

			System.out.println("QUERY_SQL_ getFolioEsp :: ejecute:: " + sql);

			return jdbcTemplate.query(sql, (rs, rowNum) -> new CatFolioDTO(rs.getString("PDF_FOLIO_VALOR"),rs.getString("PDF_FOLIO_ESPECIAL_OFERTA_ID"),
					rs.getLong("PDF_FOLIO_ID_CLIENTE"),rs.getInt("PDF_FOLIO_ESTATUS")));
		} catch (Exception e) {
			e.printStackTrace();
			throw new GenericException("Error al ejecutar getFolioEsp :: ",
					HttpStatus.NOT_FOUND.toString());
		}
	}
	
	@Transactional
	public void actualizaCatFolio(Long num_cli) {
        String query = "UPDATE PER_CAT_FOLIO SET PDF_FOLIO_ID_CLIENTE = 0, PDF_FOLIO_ESTATUS = 0 WHERE PDF_FOLIO_ID_CLIENTE = " + num_cli;
        jdbcTemplate.execute(query);
	}
	
}
