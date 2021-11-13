package com.citi.euces.sitiouec.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
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

import com.citi.euces.sitiouec.dto.TasasDTO;
import com.citi.euces.sitiouec.infra.dto.NominaEAVDTO;
import com.citi.euces.sitiouec.infra.dto.SolicitudesAplicadasSinDatosDTO;
import com.citi.euces.sitiouec.infra.dto.TbTasasDTO;
import com.citi.euces.sitiouec.infra.dto.TasasDiarioA;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

@Repository
public class TasasJDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(TasasJDBCRepository.class);
	
	public TasasJDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
    public Integer GetNumRegTbAcumuladoTasas(String fecha) throws GenericException {
        try {
            Integer id = jdbcTemplate.queryForObject("SELECT COUNT(*) total FROM UEC_TB_TASAS tasas "
            		+ "	INNER JOIN PER_CAT_SUCURSALES suc ON tasas.SUC_SOLIC=suc.SIRH_SUCURSAL_ID " 
            		+ "	WHERE Estatus=1 AND FECHA_OPE='" + fecha + "'"
            		+ " AND CAMPANA_WEB IN ('PORTAESPNOM','PTUSDO12021','PTUSDO22021','PTUSDO32021','PTUSDO42021',"
            		+ " 'CREDNOM2021','PTU2021100','PTU2021105','PTU2021110','PTU2021','CREDONLY2021105',"
            		+ " 'CREDONLY2021110','CREDONLY2021105','CREDONLY2021','ONBOARDING2021') ", Integer.class);
            if (id == null) {
                id = 0;
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el total :: UEC_TB_TASAS ", HttpStatus.NOT_FOUND.toString());
        }

    }
	
	
    public int[][] batchInsert(List<TbTasasDTO> books, int batchSize) throws GenericException {
		try {
			int[][] updateCounts = jdbcTemplate.batchUpdate(
	                "INSERT INTO UEC_TB_TASAS(ID_TASA, FECHA_OPE, ESTATUS, NUM_CTE, CONTRATO, SUC_SOLIC, DIVISION, NUM_AUTORI_UEC, TIPO_PERSONA, "
	                + " T_PER, MONTO, TASA_AUTORI, HORA_AUTORI, PRODUCTO, OPERADOR_UEC, NUM_INVERSION, PLAZO, NOM_CTE, INSTR, CVE_MONTO, CVE_PLAZO, SOEID_REP) "
	                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
	                books,
	                batchSize,
	                new ParameterizedPreparedStatementSetter<TbTasasDTO>() {
	                    public void setValues(PreparedStatement ps, TbTasasDTO content) throws SQLException {
	                    	try {
	                    		ps.setInt(1, content.getIdTasa());
	                    		ps.setDate(2, new Date(content.getFechaOpe().getTime()));
	                    		ps.setInt(3, content.getEstatus());
	                    		ps.setLong(4, content.getNumcte());
	                    		ps.setLong(5, content.getContrato());
	                    		ps.setInt(6, content.getSucSolic());
	                    		ps.setString(7, content.getDivision());
	                    		ps.setInt(8, content.getNumAutoriUEC());
	                    		ps.setInt(9, content.getTipoPersona());
	                    		ps.setInt(10, content.gettPer());
	                    		ps.setDouble(11, content.getMonto());
	                    		ps.setDouble(12, content.getTasaAutori());
	                    		ps.setDate(13, new Date(content.getHoraAutori().getTime()));
	                    		ps.setDouble(14, content.getProducto());
	                    		ps.setInt(15, content.getOperadorUEC());
	                    		ps.setInt(16, content.getNumInversion());
	                    		ps.setInt(17, content.getPlazo());
	                    		ps.setString(18, content.getNomCte());
	                    		ps.setInt(19, content.getPlazo());
	                    		ps.setInt(20, content.getCveMonto());
	                    		ps.setInt(21, content.getCvePlazo());
	                    		ps.setString(22, content.getSoeidRep());
	                    	} catch (SQLException e) {
	                			e.printStackTrace();
	                        }
	                    }
	                });
	        return updateCounts;	
		} catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al guardar en :: UEC_TB_TASAS ", HttpStatus.NOT_FOUND.toString());
        }
	}

    @Transactional
    public Integer obtieneReg(String fecha) throws GenericException {
        try {
            Integer id = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM UEC_TB_TASAS WHERE FECHA_OPE = TO_DATE('" + fecha + "', 'DD/MM/YY') ", Integer.class);
            if (id == null) {
                id = 0;
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el total :: UEC_TB_TASAS ", HttpStatus.NOT_FOUND.toString());
        }

    }
    
	@Transactional
	public List<TasasDiarioA> selectRegTasasDiario(Integer enfoque, String fechaCargaInicial, String fechaCargaFinal, Integer estatus)
	{
		String sql = ""; Integer opcion = 0;
		if(estatus == 1 || estatus == 2 || estatus == 3) {
			opcion = 1;
			if(enfoque == 0) {
				sql = " select t.FECHA_OPE,t.ESTATUS,t.CONTRATO,t.NUM_INVERSION,t.NUM_CTE, "
						+ " t.NOM_CTE,t.PLAZO,t.MONTO,t.TASA_AUTORI,TO_CHAR(t.HORA_AUTORI,'HH24:MM:SSSSS') AS HORA_AUTORI,t.NUM_AUTORI_UEC, "
						+ " t.SUC_SOLIC,t.DIVISION, s.DISTRITO_NOMBRE AS REGION,t.NOMINA,t.NOMEJEC,t.CAMPANA_WEB, t.is_web, t.observa_web, t.asignado_a, t.operado_por,"
						+ "(ROWNUM +(select NVL(MAX(ID_ACUMULADO),0) AS ID FROM UEC_TB_ACUMULADO_CAMP)) AS ID "
						+ " FROM UEC_TB_TASAS t, PER_CAT_SUCURSALES s "
						+ " WHERE  t.SUC_SOLIC = s.SIRH_SUCURSAL_ID ";
			}
			
		}
		
		switch(estatus) {
			case 1: sql += " AND t.Estatus=1 "; break;
			case 2:	sql += " AND t.Estatus <> 1"; break;
			case 3: break;
			case 4: sql += " AND t.IS_TASA_BASE=1"; break;
		}
		
		sql += " AND TRUNC(t.FECHA_OPE) BETWEEN TO_DATE('" + fechaCargaInicial + "','DD/MM/YY') AND TO_DATE('" + fechaCargaFinal + "','DD/MM/YY') ";
		sql += estatus == 4 ? " ORDER BY Division " : "";
		log.info("Consulta TASAS DIARIO: " + sql);
		
		if(opcion == 1) {
			return jdbcTemplate.query(sql, (cc, rowNum) ->
            new TasasDiarioA (
            		cc.getDate("FECHA_OPE"),
	                cc.getInt("ESTATUS"),
	                cc.getInt("CONTRATO"),
	                cc.getInt("NUM_INVERSION"),
	                cc.getInt("PLAZO"),
	                cc.getDouble("MONTO"),
	                cc.getDouble("TASA_AUTORI"),
	                cc.getString("HORA_AUTORI"),
	                cc.getInt("NUM_AUTORI_UEC"),
	                cc.getString("REGION"),
	                cc.getInt("SUC_SOLIC"),
	                cc.getString("DIVISION"),
	                cc.getString("CAMPANA_WEB"),
	                cc.getInt("IS_WEB"),
	                cc.getString("NOMINA"),
	                cc.getString("NOMEJEC"),
	                cc.getString("NOM_CTE"),
	                cc.getInt("NUM_CTE"),
	                cc.getString("observa_web"),
	                cc.getString("asignado_a"),
	                cc.getString("operado_por"),
	                cc.getInt("ID")
            		)
			);	
		}else {
			return jdbcTemplate.query(sql, (cc, rowNum) ->
            new TasasDiarioA (
            		cc.getDate("FECHA_OPE"),
	                cc.getInt("ESTATUS"),
	                cc.getInt("CONTRATO"),
	                cc.getInt("PLAZO"),
	                cc.getDouble("MONTO"),
	                cc.getDouble("TASA_AUTORI"),
	                cc.getInt("NUM_AUTORI_UEC"),
	                cc.getString("DISTRITO"),
	                cc.getInt("SUC_SOLIC"),
	                cc.getString("DIVISION"),
	                cc.getString("CAMPANA_WEB"),
	                cc.getString("NOM_CTE"),
	                cc.getInt("NUM_CTE"),
	                cc.getString("observa_web"),
	                cc.getDouble("CETE"),
	                cc.getDouble("PORCEN_CETE"),
	                cc.getString("AUTORIZADOR"),
	                cc.getInt("IS_BEI"),
	                cc.getString("SEGMENTO"),
	                cc.getString("NOMEJEC"),
	                cc.getString("NOMINA")
            	)
			);
		}
	}
	
	public List<TbTasasDTO> selectRegTasas(String fechaCarga, Integer estatus) throws GenericException
	{
		try {
			String sql = " SELECT ID_TASA,TO_DATE(FECHA_OPE, 'DD/MM/YY') AS FECHA_OPE,ESTATUS,NUM_CTE,CONTRATO, IS_TASA_BASE, "
					+ "NUM_INVERSION,PLAZO,MONTO,TASA_AUTORI,NUM_AUTORI_UEC,OPERADOR_UEC, "
					+ "SUC_SOLIC,NVL(NOM_CTE,'0') AS NOM_CTE,TIPO_PERSONA,  INSTR, NVL(CAMPANA_WEB, '0') AS CAMPANA_WEB, NVL(ASIGNADO_A, '0') AS ASIGNADO_A, "
					+ "NVL(OPERADO_POR, '0') AS OPERADO_POR, NVL(NOMINA, '0') AS NOMINA, NVL(AUTORIZADOR, '0') AS AUTORIZADOR, NVL(IS_WEB, 0) AS IS_WEB, NVL(OBSERVA_WEB, '0') AS OBSERVA_WEB, "
					+ "NVL(NOMEJEC, '0') AS NOMEJEC, NVL(FECHA_CAPTURA, TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_CAPTURA, NVL(FECHA_ESTATUS, TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_ESTATUS, "
					+ "NVL(DIVISION,'0') AS DIVISION"
					+ " FROM UEC_TB_TASAS "
					+ "WHERE TRUNC(FECHA_OPE) = TO_DATE('" + fechaCarga + "', 'DD/MM/YY') ";
	              if(estatus != 0) {
	            	  sql += " AND ESTATUS = " + estatus;
	              }
	              log.info("Consulta TASAS 1: " + sql);
	        return jdbcTemplate.query(sql, (cc, rowNum) ->
	                new TbTasasDTO (
	                	cc.getInt("ID_TASA"),
	                    cc.getDate("FECHA_OPE"),
	                    cc.getInt("ESTATUS"),
	                    cc.getLong("NUM_CTE"),
	                    cc.getLong("CONTRATO"),
	                    cc.getInt("IS_TASA_BASE"),
	                    cc.getInt("NUM_INVERSION"),
	                    cc.getInt("PLAZO"),
	                    cc.getDouble("MONTO"),
	                    cc.getDouble("TASA_AUTORI"),
	                    cc.getInt("NUM_AUTORI_UEC"),
	                    cc.getInt("OPERADOR_UEC"),
	                    cc.getInt("SUC_SOLIC"),
	                    cc.getString("NOM_CTE"),
	                    cc.getInt("TIPO_PERSONA"),
	                    cc.getInt("INSTR"),
	                    cc.getString("CAMPANA_WEB"),
	                    cc.getString("ASIGNADO_A"),
	                    cc.getString("OPERADO_POR"),
	                    cc.getString("NOMINA"),
	                    cc.getString("AUTORIZADOR"),
	                    cc.getInt("IS_WEB"),
	                    cc.getString("OBSERVA_WEB"),
	                    cc.getString("NOMEJEC"),
	                    cc.getDate("FECHA_CAPTURA"),
	                    cc.getDate("FECHA_ESTATUS"),
	                    cc.getString("DIVISION")
	                )
	        );	
		}catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al consultas platino ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	public void updateSucTasas(TbTasasDTO items) throws GenericException {
		try {
			String query = " UPDATE UEC_TB_TASAS SET SUC_SOLIC =" + items.getSucSolic() + "," + " DIVISION = '" + items.getDivision() + "', IS_TASA_BASE = 2 "
                    		+ " WHERE ID_TASA=" + items.getIdTasa();
			log.info("UPDATE 1: " + query);
			jdbcTemplate.execute(query);	
		}catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al actualizar Sucursales Tasas ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	public void updateAsignadoOperadoTasas(TbTasasDTO items) throws GenericException {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
			String query = " UPDATE UEC_TB_TASAS SET IS_WEB=" + items.getIsWeb() + ", "
					+ " ASIGNADO_A ='" + items.getAsignadoA() + "',"
	                + " OPERADO_POR= '" + items.getOperadoPor()+ "',"
	                + " OBSERVA_WEB= '" + items.getObservaWeb() + "',"
	                + " CAMPANA_WEB= '" + items.getCampanaWeb() + "',"
	                + " NOMINA = '"     + items.getNomina() + "',"
	                + " NOMEJEC= '"     + items.getNomEjec() + "',"
	                + " NOM_CTE= '"     + items.getNomCte() + "',"
	                + " NUM_CTE= " + items.getNumcte() + "";
			
					if(items.getFechacap() == null) {
						query += ", FECHA_CAPTURA = TO_DATE('" + formato.format(items.getFechacap()) + "','DD/MM/YY') ";
					}
	                
					if(items.getFechaEstatus() == null) {
						query += ", FECHA_ESTATUS = TO_DATE('" + formato.format(items.getFechaEstatus()) + "','DD/MM/YY') ";
					}
                	query += " WHERE ID_TASA=" + items.getIdTasa();
			log.info("UPDATE 2: " + query);
			jdbcTemplate.execute(query);	
		
		}catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al actualizar Operado Tasas ", HttpStatus.NOT_FOUND.toString());
        }
	}

	@Transactional
    public void updateTasasAutorizadas(String fechaOpe) throws GenericException {
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cstmt = connection.prepareCall("{call UEC_USP_UPDATE_TASASAUTORIZADAS_WEB(?)}");
            cstmt.setString("p_fecha_ope", fechaOpe);
            cstmt.execute();
            cstmt.close();
        } catch (SQLException ex) {
            throw new GenericException("Error al actualizar las Tasas Autorizadas :: ", HttpStatus.NOT_FOUND.toString());
        }
    }

	public void updateAutorizadoresTasas(List<TbTasasDTO> items) throws GenericException {
		try {
			for(TbTasasDTO item : items) {
				 String query = " UPDATE UEC_TB_TASAS SET AUTORIZADOR = '" + item.getAutorizador() +"',"
                         + " CETE = " + item.getCete() + " ,"
                         + " PORCEN_CETE = " + item.getPorcenCete() + " ,"
                         + " NUM_CTE = " + item.getNumcte() + " ,"
                         + " OBSERVA_WEB = '"+item.getObservaWeb() +"', "
                         + " NOM_CTE = '"+ item.getNomCte() +"',  " 
                         + " IS_WEB = 0, "
                         + " CAMPANA_WEB=''  "
                         + " WHERE ID_TASA = " + item.getIdTasa();
				jdbcTemplate.execute(query);	
			}
		}catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al actualizar Autorizadores Tasas ", HttpStatus.NOT_FOUND.toString());
        }
	}

	public void updatetasasTipoTasaBaseSuc(String fecha) throws GenericException {
		 try {
			 String query = "  UPDATE UEC_TB_TASAS tas "
	                 + "  SET tas.IS_TASA_BASE  =  4 "
	                 + "  WHERE  AUTORIZADOR IS NULL  "
	                 + "  AND ( CAMPANA_WEB IS NULL OR CAMPANA_WEB = '')  "
	                 + "  AND num_cte NOT IN (SELECT num_cte FROM  tb_suc_gobierno) "
	                 + "  AND tas.FECHA_OPE = TO_DATE('" + fecha + "','DD/MM/YY') ";
			jdbcTemplate.execute(query);
		 }catch (Exception e) {
				e.printStackTrace();
	            throw new GenericException( "Error al actualizar Autorizadores Tasas ", HttpStatus.NOT_FOUND.toString());
	        }
	}
	
	public void updatetasasTipoAutorizador(String fecha) throws GenericException {
		 try {
			 String query = "  UPDATE  UEC_TB_TASAS tas "
                     + "  SET tas.IS_TASA_BASE  =  1 "
                     + "  WHERE  AUTORIZADOR IS NOT NULL "
                     + "  AND CETE IS NOT NULL "
                     + "  AND CETE <> 0 "
                     + "  AND tas.FECHA_OPE = TO_DATE('" + fecha+ "', 'DD/MM/YY')";
			jdbcTemplate.execute(query);	 
		 }catch (Exception e) {
				e.printStackTrace();
	            throw new GenericException( "Error al actualizar Tipo Autorizadores ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	public void updateTasasBeiClientes(String fecha) throws GenericException {
		 try {
			 String query = " UPDATE "
			 		+ "( SELECT tas.IS_BEI "
			 		+ "FROM UEC_TB_TASAS tas "
			 		+ "INNER JOIN UEC_CAT_GRAL_CTES cli "
			 		+ "ON tas.NUM_CTE = cli.NUM_CTE "
			 		+ "WHERE tas.FECHA_OPE = TO_DATE('" + fecha + "','DD/MM/YY')"
			 		+ ") tb "
			 		+ "SET tb.IS_BEI  =  1";
			jdbcTemplate.execute(query);	 
		 }catch (Exception e) {
				e.printStackTrace();
	            throw new GenericException( "Error al actualizar Bei Clientes ", HttpStatus.NOT_FOUND.toString());
       }
	}
	
	public void updateTasasBeiContratos(String fecha) throws GenericException {
		 try {
			 //VERIFICAR
			 String query = "  UPDATE ( SELECT tas.IS_BEI "
			 		+ "FROM UEC_TB_TASAS tas "
			 		+ "INNER JOIN tb_contratos_clientes con "
			 		+ "    ON con.Cuenta=tas.CONTRATO "
			 		+ "INNER JOIN UEC_CAT_GRAL_CTES cli "
			 		+ "    ON cli.NUM_CTE = con.Numcliente "
			 		+ "WHERE tas.FECHA_OPE = TO_DATE('  ','DD/MM/YY') ) tb "
			 		+ "SET tb.IS_BEI  =  1";
			jdbcTemplate.execute(query);	 
		 }catch (Exception e) {
				e.printStackTrace();
	            throw new GenericException( "Error al actualizar Bei Clientes ", HttpStatus.NOT_FOUND.toString());
      }
	}
	
	public void updateTasasTipoGobierno(String fecha) throws GenericException {
		 try {
			 String query = "  UPDATE  UEC_TB_TASAS tas "
                     + "  SET tas.IS_TASA_BASE  =  3 "
                     + "  WHERE  num_cte IN (SELECT num_cte FROM tb_suc_gobierno) "
                     + "  AND tas.FECHA_OPE = '" + fecha + "'";
			jdbcTemplate.execute(query);	 
		 }catch (Exception e) {
				e.printStackTrace();
	            throw new GenericException( "Error al actualizar Bei Clientes ", HttpStatus.NOT_FOUND.toString());
		 }
	}
	
	@Transactional
    public void updateTasasTPer(String fecha) throws GenericException {
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cstmt = connection.prepareCall("{call UEC_UPD_TASAS_T_PER(?)}");
            cstmt.setString(1, fecha);
            cstmt.execute();
            cstmt.close();
        } catch (SQLException ex) {
            throw new GenericException("Error al ejecutar el sp UEC_UPD_TASAS_T_PER :: ", HttpStatus.NOT_FOUND.toString());
        }
    }
	
	@Transactional
    public void updateTasasTPerxCatGralCtes(String fecha) throws GenericException {
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cstmt = connection.prepareCall("{call UEC_UPD_TASAS_TPER_X_CAT_GRAL_CTES(?)}");
            cstmt.setString(1, fecha);
            cstmt.execute();
            cstmt.close();
        } catch (SQLException ex) {
            throw new GenericException("Error al ejecutar el sp UEC_UPD_TASAS_TPER_X_CAT_GRAL_CTES :: ", HttpStatus.NOT_FOUND.toString());
        }
    }
	
	@Transactional
    public void updateTasasTPerxVacio(String fecha) throws GenericException {
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement cstmt = connection.prepareCall("{call UEC_UPD_TASAS_T_PER_X_VACIO(?)}");
            cstmt.setString(1, fecha);
            cstmt.execute();
            cstmt.close();
        } catch (SQLException ex) {
            throw new GenericException("Error ejecutar el sp UEC_UPD_TASAS_T_PER_X_VACIO :: ", HttpStatus.NOT_FOUND.toString());
        }
    }

	public void updateValidacionPlatino(TbTasasDTO platino) throws GenericException {
		try {
			String cad = "";
			if (platino.getIsTasaBase() == 1)
            {
                cad = " AUTORIZADOR ='" +platino.getAutorizador()+ "', " ;
            }
			
			String query = " UPDATE UEC_TB_TASAS SET " +
                    "  num_cte =" +    platino.getNumcte() + ", "+
                    "  contrato =" +   platino.getContrato() + ", " +
                    "  MONTO=" +       platino.getMonto() + ", " +
                    "  SUC_SOLIC=" +   platino.getSucSolic() + ", " +
                    cad +
                    "  PLAZO="+        platino.getPlazo() + ", " +
                    "  ASIGNADO_A='"+  platino.getAsignadoA().trim() + "', " +
                    "  OPERADO_POR='"+ platino.getOperadoPor().trim() + "', " +
                    "  IS_TASA_BASE="+ platino.getIsTasaBase() + ", " +
                    "  CAMPANA_WEB='"+ platino.getCampanaWeb().trim() + "', " +
                    "  NOMINA='" +      platino.getNomina() + "', " +
                    "  IS_WEB=1 " +
                    " WHERE ID_TASA =" + platino.getIdTasa();
       
			jdbcTemplate.execute(query);
		} catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error ejecutar el sp Upd_Tasas_T_Per_X_Vacio :: ", HttpStatus.NOT_FOUND.toString());
        }
	} 

	public void deleteFechaOperacion(String fecha_ope) throws GenericException {
		try {
			String query = " DELETE FROM UEC_TB_TASAS WHERE FECHA_OPE = TO_DATE('" + fecha_ope + "', 'DD/MM/YYYY') ";
			jdbcTemplate.execute(query);
		} catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al eliminar la carga con la fecha indicada :: ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	@Transactional
	public List<SolicitudesAplicadasSinDatosDTO> obtenerRegTasasSinDatos(String fecha)
	{
		String sql = "SELECT ID_TASA, ESTATUS,FECHA_OPE,NUM_CTE, CONTRATO, SUC_SOLIC, NUM_AUTORI_UEC,MONTO, TASA_AUTORI,PLAZO,NOM_CTE "
                + " FROM UEC_TB_TASAS WHERE IS_TASA_BASE = 4 AND TO_DATE(FECHA_OPE, 'DD/MM/YY')  = TO_DATE('" + fecha + "','DD/MM/YY')  AND ESTATUS=1  "
                + " AND AUTORIZADOR IS NULL AND IS_WEB=0";
        return jdbcTemplate.query(sql, (cc, rowNum) ->
                new SolicitudesAplicadasSinDatosDTO (
                    cc.getInt("ID_TASA"),
                    cc.getInt("ESTATUS"),
                    cc.getString("FECHA_OPE"),
                    cc.getInt("NUM_CTE"),
                    cc.getInt("CONTRATO"),
                    cc.getInt("SUC_SOLIC"),
                    cc.getInt("NUM_AUTORI_UEC"),
                    cc.getInt("MONTO"),
                    cc.getInt("TASA_AUTORI"),
                    cc.getInt("PLAZO"),
                    cc.getString("NOM_CTE")
                )
        );
	}
	
//	@Transactional
//	public List<TasasDTO> ObtenerRegTasasDiario(Date fechaCargaInicial, Date fechaCargaFinal, int Estatus){
//		String sql = "  select FECHA_OPE, ts.ESTATUS, ts.CONTRATO, ts.NUM_INVERSION, ts.PLAZO, ts.MONTO, ts.TASA_AUTORI, ts.FECHA_CAPTURA, ts.NUM_CTE, ts.NOM_CTE, "
//                + " ts.FECHA_ESTATUS, ts.NUM_AUTORI_UEC, ts.SUC_SOLIC, suc.DIVISION, suc.DISTRITO,  ts.CAMPANA_WEB, ts.Is_WEB, ts.IS_BEI, "
//                + " ts.NOMINA, ts.NOMEJEC, au.observa_web, au.SOEID_ASIG, au.SOEID_OPE "+ 
//                  " from tb_tasas ts "
//                + " inner join cat_suc2021 suc on ts.SUC_SOLIC = suc.SIRH "
//                + " inner join tb_autotasas au on au.NUM_AUTORI_UEC = ts.NUM_AUTORI_UEC AND(ts.FECHA_OPE = CAST(au.FECHA_SOLIC AS DATE)) ";
//        return jdbcTemplate.query(sql, (cc, rowNum) ->
//                new TasasDTO (
//                    cc.getDate("FECHA_OPE"),
//                    cc.getInt("ts.ESTATUS"),
//                    cc.getInt("ts.CONTRATO"),
//                    cc.getInt("ts.NUM_INVERSION"),
//                    cc.getInt("ts.PLAZO"),
//                    cc.getInt("ts.MONTO"),
//                    cc.getInt("ts.TASA_AUTORI"),
//                    cc.getDate("FECHA_CAPTURA"),
//                    cc.getInt("NUM_CTE"),
//                    cc.getString("NOM_CTE"),
//                    cc.getDate("FECHA_ESTATUS"),
//                    cc.getInt("NUM_AUTORI_UEC"),
//                    cc.getInt("SUC_SOLIC"),
//                    cc.getString("ts.DIVISION"),
//                    cc.getString("suc.DISTRITO"),
//                    cc.getString("CAMPANA_WEB"),
//                    cc.getInt("Is_WEB"),
//                    cc.getInt("IS_BEI"),
//                    cc.getString("NOMINA"),
//                    cc.getString("NOMEJEC"),
//                    cc.getString("OBSERVA_WEB"),
//                    cc.getString("ASIGNADO_A"),
//                    cc.getString("OPERADO_POR")
//                )
//        );
//	}

}
