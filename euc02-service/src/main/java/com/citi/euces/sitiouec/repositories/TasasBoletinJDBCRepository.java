package com.citi.euces.sitiouec.repositories;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.infra.dto.BoletinesDTO;
import com.citi.euces.sitiouec.infra.dto.TasasCampanaDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

@Repository
public class TasasBoletinJDBCRepository {

	private final JdbcTemplate jdbcTemplate;
	static final Logger log = LoggerFactory.getLogger(TasasBoletinJDBCRepository.class);
	
	public TasasBoletinJDBCRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
    public Date obtieneUltimaFecha() throws GenericException {
        try {
        	SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
            Date id = jdbcTemplate.queryForObject("SELECT NVL(MAX(FECHA_OPE), TO_DATE('01/01/01','DD/MM/YY')) FROM UEC_TB_TASAS_BOLETIN", Date.class);
            String fecha = ft.format(id);
            return ft.parse(fecha);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al obtener el máximo :: UEC_TB_AUTOTASAS ", HttpStatus.NOT_FOUND.toString());
        }
    }
	
	public void deleteBoletin() throws GenericException {
		try {
			String query = " DELETE FROM UEC_TB_TASAS_BOLETIN";
			jdbcTemplate.execute(query);
		} catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al eliminar la carga con la fecha indicada :: ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	
	public void llenarBoletinTasa(String fecha1, String fecha2) throws GenericException {
		try {
			String query = "INSERT INTO UEC_TB_TASAS_BOLETIN "
					+ "SELECT au.ID_TASAUTO, NVL(CAST(ts.FECHA_OPE AS DATE),TO_DATE('01/01/01','DD/MM/YY')) AS FECHA_OPE, NVL(ts.ESTATUS,0) AS ESTATUS, NVL(suc.DIVISION_NOMBRE,'NA') AS DIVISION, NVL(ts.NUM_AUTORI_UEC,0) AS NUM_AUTORI_UEC, NVL(ts.T_PER,0) AS T_PER,"
					+ "NVL(ts.MONTO,0) AS MONTO, NVL(ts.PRODUCTO,0) AS PRODUCTO, NVL(ts.IS_TASA_BASE,0) AS IS_TASA_BASE"
					+ " FROM UEC_TB_AUTOTASAS au " 
					+ " LEFT JOIN UEC_TB_TASAS ts "
					+ "    ON au.NUM_AUTORI_UEC = ts.NUM_AUTORI_UEC "
					+ "    AND ts.FECHA_OPE = CAST(TRUNC(au.FECHA_SOLIC) AS DATE) "
					+ " LEFT JOIN PER_CAT_SUCURSALES suc "
					+ "    ON ts.suc_solic = suc.SIRH_SUCURSAL_ID "
					+ "WHERE TRUNC(ts.FECHA_OPE) BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "','DD/MM/YY') ";
			jdbcTemplate.execute(query);
		} catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al cargar Tasas Boletin :: ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	@Transactional
	public List<BoletinesDTO> obtenerMontoProductoxPersona(Integer enfoque, String fecha1, String fecha2, Boolean fisica, Integer estatus) throws Exception 
	{
		try {
			String sql = "";
			if(enfoque == 0) {
				sql =  "SELECT '" + (fisica ? "Personas Físicas" : "Personas Morales") + "' AS DESCRIPCION,COUNT(ID_TASA) AS OPERACIONES, NVL(round(SUM(MONTO),2),0) AS MONTO, NVL(SUM(PRODUCTO),0) as SubProducto, NVL(round((SUM(PRODUCTO))/(SUM(MONTO)),2),0) as TP"
						+ " FROM UEC_TB_TASAS WHERE TRUNC(ts.FECHA_OPE) >= TO_DATE('" + fecha1 + "','DD/MM/YY') AND TRUNC(ts.FECHA_OPE) <= TO_DATE('" + fecha2 + "','DD/MM/YY') ";
				sql += fisica ? " AND T_PER = 1 " : " AND T_PER = 2 ";
				switch(estatus) {
					case 1: sql += " AND ESTATUS  = 1 "; break;
					case 2: sql += " AND ESTATUS <> 1 "; break;
				}
				sql += " AND NVL(DIVISION,' ') <> ' ' ";
	            sql += " AND IS_TASA_BASE <> 3 ";
			}else {
				sql = "SELECT '" + (fisica ? "Personas Físicas" : "Personas Morales") +  "' AS DESCRIPCION,COUNT( ID_TASAUTO) AS OPERACIONES, NVL(round(SUM(MONTO),2),0) AS MONTO, NVL(SUM(PRODUCTO),0) as SubProducto, "
						+ " CASE WHEN SUM(MONTO) = 0 THEN 0.0 ELSE NVL(ROUND((SUM(PRODUCTO))/(SUM(MONTO)),2),0) END AS TP "
						+ " FROM UEC_TB_TASAS_BOLETIN ts  WHERE TRUNC(ts.FECHA_OPE) BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "','DD/MM/YY') ";
				sql += fisica ? " AND T_PER = 1 " : " AND T_PER = 2 ";
				switch(estatus) {
					case 1: sql += " AND ESTATUS  = 1 "; break;
					case 2: sql += " AND ESTATUS <> 1 "; break;
				}
			}
			log.info("Query MontoProductoxPersona = " + sql);
			return jdbcTemplate.query(sql, (cc, rowNum) ->
			        new BoletinesDTO (
	        			cc.getString("DESCRIPCION"),
	                    cc.getInt("OPERACIONES"),
	                    cc.getDouble("MONTO"),
	                    cc.getDouble("TP"),
	                    cc.getDouble("SubProducto")	
			        )
			);	
		} catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al consulta productos por persona", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	@Transactional
	public List<BoletinesDTO> obtenerMontoProductoxTasaAutorizada(Integer enfoque, String fecha1, String fecha2, Integer estatus) throws Exception 
	{
		try {
			String sql = "";
			if(enfoque == 0) {
				sql =  "SELECT 'Tasas Autorizadas' AS DESCRIPCION,COUNT(ID_TASA) AS OPERACIONES, NVL(round(SUM(MONTO),2),0) AS MONTO, NVL(SUM(PRODUCTO),0) as SubProducto, NVL(round((SUM(PRODUCTO))/(SUM(MONTO)),2),0) as TP"
						+ " FROM UEC_TB_TASAS WHERE TRUNC(ts.FECHA_OPE) >= TO_DATE('" + fecha1 + "','DD/MM/YY') AND TRUNC(ts.FECHA_OPE) <= TO_DATE('" + fecha2 + "','DD/MM/YY') "
						+ " AND IS_TASA_BASE <> 3 AND IS_TASA_BASE=1  ";
				switch(estatus) {
					case 1: sql += " AND ESTATUS  = 1 "; break;
					case 2: sql += " AND ESTATUS <> 1 "; break;
				}
				sql += " AND NVL(DIVISION,' ') <> ' ' ";
			}else {
				sql = "SELECT 'Tasas Autorizadas' AS DESCRIPCION,COUNT( ID_TASAUTO) AS OPERACIONES, NVL(round(SUM(MONTO),2),0) AS MONTO, NVL(SUM(PRODUCTO),0) as SubProducto, "
						+ " CASE WHEN SUM(MONTO) = 0 THEN 0.0 ELSE NVL(ROUND((SUM(PRODUCTO))/(SUM(MONTO)),2),0) END AS TP "
						+ " FROM UEC_TB_TASAS_BOLETIN ts  WHERE TRUNC(ts.FECHA_OPE) BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "','DD/MM/YY') "
						+ " AND IS_TASA_BASE <> 3 AND IS_TASA_BASE=1  ";
				switch(estatus) {
					case 1: sql += " AND ESTATUS  = 1 "; break;
					case 2: sql += " AND ESTATUS <> 1 "; break;
				}
			}
			log.info("Query MontoProductoxTasaAutorizada = " + sql);
			return jdbcTemplate.query(sql, (cc, rowNum) ->
			        new BoletinesDTO (
	        			cc.getString("DESCRIPCION"),
	                    cc.getInt("OPERACIONES"),
	                    cc.getDouble("MONTO"),
	                    cc.getDouble("TP"),
	                    cc.getDouble("SubProducto")	
			        )
			);	
		} catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al consulta Tasa Autorizada ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	@Transactional
	public List<BoletinesDTO> obtenerMontoProductoxTasaSucursalCampana(Integer enfoque, String fecha1, String fecha2, Integer estatus, Integer tipoTasa) throws Exception 
	{
		try {
			String sql = "";
			if(enfoque == 0) {
				sql =  "SELECT '" + (tipoTasa == 2 ? "Tasas Sucursal" : "Tasas Campaña") + "' AS DESCRIPCION,COUNT(ID_TASA) AS OPERACIONES, NVL(round(SUM(MONTO),2),0) AS MONTO, NVL(SUM(PRODUCTO),0) as SubProducto, NVL(round((SUM(PRODUCTO))/(SUM(MONTO)),2),0) as TP"
						+ " FROM UEC_TB_TASAS WHERE TRUNC(FECHA_OPE) >= TO_DATE('" + fecha1 + "','DD/MM/YY') AND TRUNC(FECHA_OPE) <= TO_DATE('" + fecha2 + "','DD/MM/YY') ";
				
				if(tipoTasa == 2) { //SUCURSAL
					sql += " AND IS_TASA_BASE=4 ";
				}else if(tipoTasa == 1) { //CAMPAÑA
					sql += " AND IS_TASA_BASE=2 ";
				}
						
				switch(estatus) {
					case 1: sql += " AND ESTATUS  = 1 "; break;
					case 2: sql += " AND ESTATUS <> 1 "; break;
				}
				sql += " AND NVL(DIVISION,' ') <> ' ' ";
			}else {
				sql = "SELECT '" + (tipoTasa == 2 ? "Tasas Sucursal" : "Tasas Campaña") + "' AS DESCRIPCION,COUNT( ID_TASAUTO) AS OPERACIONES, NVL(round(SUM(MONTO),2),0) AS MONTO, NVL(SUM(PRODUCTO),0) as SubProducto, "
						+ " CASE WHEN SUM(MONTO) = 0 THEN 0.0 ELSE NVL(ROUND((SUM(PRODUCTO))/(SUM(MONTO)),2),0) END AS TP "
						+ " FROM UEC_TB_TASAS_BOLETIN ts  WHERE TRUNC(FECHA_OPE) BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "','DD/MM/YY') ";
				if(tipoTasa == 2) { //SUCURSAL
					sql += " AND IS_TASA_BASE=4 ";
				}else if(tipoTasa == 1) { //CAMPAÑA
					sql += " AND IS_TASA_BASE=2 ";
				}
				switch(estatus) {
					case 1: sql += " AND ESTATUS  = 1 "; break;
					case 2: sql += " AND ESTATUS <> 1 "; break;
				}
			}
			log.info("Query MontoProductoxtasaCampaña = " + sql);
			return jdbcTemplate.query(sql, (cc, rowNum) ->
			        new BoletinesDTO (
	        			cc.getString("DESCRIPCION"),
	                    cc.getInt("OPERACIONES"),
	                    cc.getDouble("MONTO"),
	                    cc.getDouble("TP"),
	                    cc.getDouble("SubProducto")	
			        )
			);	
		} catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al consulta Tasa Sucursal", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	@Transactional
	public List<BoletinesDTO> obtenerMontoProductoxDivision(Integer enfoque, String fecha1, String fecha2, Integer estatus) throws Exception 
	{
		try {
			String sql = "";
			if(enfoque == 0) {
				sql =  "SELECT NVL(DIVISION,'NA') AS DIVISION, COUNT(ID_TASA) AS OPERACIONES,NVL(SUM(Producto),0) AS SubProducto, NVL(ROUND(SUM(MONTO),2),0) AS MONTO, "
						+ "NVL(ROUND((SUM(PRODUCTO))/(SUM(MONTO)),2),0) AS TP "
						+ " FROM UEC_TB_TASAS WHERE TRUNC(FECHA_OPE) >= TO_DATE('" + fecha1 + "','DD/MM/YY') AND TRUNC(FECHA_OPE) <= TO_DATE('" + fecha2 + "','DD/MM/YY') ";
				switch(estatus) {
					case 1: sql += " AND ESTATUS  = 1 "; break;
					case 2: sql += " AND ESTATUS <> 1 "; break;
				}
				sql += " AND NVL(DIVISION,' ') <> ' ' GROUP BY DIVISION ";
			}else {
				sql = "SELECT NVL(DIVISION,'NA') AS DIVISION, COUNT(ID_TASAUTO) AS OPERACIONES,NVL(SUM(Producto),0) as SubProducto, NVL(ROUND(SUM( MONTO),2),0) AS MONTO,"
						+ " CASE WHEN SUM(MONTO) = 0 THEN 0.0 ELSE NVL(ROUND((SUM(PRODUCTO))/(SUM(MONTO)),2),0) END AS TP "
						+ " FROM UEC_TB_TASAS_BOLETIN  WHERE TRUNC(FECHA_OPE) BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "','DD/MM/YY') ";
				switch(estatus) {
					case 1: sql += " AND ESTATUS  = 1 "; break;
					case 2: sql += " AND ESTATUS <> 1 "; break;
				}
				sql += " GROUP BY DIVISION ";
			}
			log.info("Query MontoProductoxDivision = " + sql);
			return jdbcTemplate.query(sql, (cc, rowNum) ->
			        new BoletinesDTO (
	        			cc.getString("DIVISION"),
	                    cc.getInt("OPERACIONES"),
	                    cc.getDouble("MONTO"),
	                    cc.getDouble("TP"),
	                    cc.getDouble("SubProducto")	
			        )
			);	
		} catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al consulta Tasa Sucursal", HttpStatus.NOT_FOUND.toString());
        }
	}

	@Transactional
	public List<BoletinesDTO> obtenerMontoProductoxAplicadasRechazadas(Integer enfoque, String fecha1, String fecha2, Integer estatus) throws Exception 
	{
		try {
			String sql = "";
			if(enfoque == 0) {
				sql =  " SELECT 'Aplicada Rechazada' AS DESCRIPCION, COUNT(ID_TASA) AS OPERACIONES, NVL(ROUND(SUM(MONTO),2),0) AS MONTO, NVL(SUM(PRODUCTO),0) as SubProducto, "
						+ " CASE WHEN SUM(MONTO) = 0 THEN 0.0 ELSE NVL(ROUND((SUM(PRODUCTO))/(SUM(MONTO)),2),0) END AS TP"
						+ " FROM UEC_TB_TASAS WHERE TRUNC(FECHA_OPE) >= TO_DATE('" + fecha1 + "','DD/MM/YY') AND TRUNC(FECHA_OPE) <= TO_DATE('" + fecha2 + "','DD/MM/YY') ";
				sql += estatus == 1 ? "  AND ESTATUS  =  1 " : "  AND ESTATUS  <>  1 ";
				sql += " AND NVL(DIVISION,' ') <> ' '";
			}else {
				sql = "SELECT 'Aplicada Rechazada' AS DESCRIPCION, COUNT(ID_TASAUTO) AS OPERACIONES, NVL(ROUND(SUM(MONTO),2),0) AS MONTO, NVL(SUM(PRODUCTO),0) as SubProducto, "
						+ " CASE WHEN SUM(MONTO) = 0 THEN 0.0 ELSE NVL(ROUND((SUM(PRODUCTO))/(SUM(MONTO)),2),0) END AS TP"
						+ " FROM UEC_TB_TASAS_BOLETIN  WHERE TRUNC(FECHA_OPE) BETWEEN TO_DATE('" + fecha1 + "','DD/MM/YY') AND TO_DATE('" + fecha2 + "','DD/MM/YY') ";
				sql += estatus == 1 ? "  AND ESTATUS  =  1 " : "  AND ESTATUS  <>  1 ";
			}
			log.info("Query MontoProductoxAplicadasRechazadas = " + sql);
			return jdbcTemplate.query(sql, (cc, rowNum) ->
			        new BoletinesDTO (
	        			cc.getString("DESCRIPCION"),
	                    cc.getInt("OPERACIONES"),
	                    cc.getDouble("MONTO"),
	                    cc.getDouble("TP"),
	                    cc.getDouble("SubProducto")	
			        )
			);	
		} catch (Exception e) {
            e.printStackTrace();
            throw new GenericException("Error al consulta Tasa Sucursal", HttpStatus.NOT_FOUND.toString());
        }
	}
}
