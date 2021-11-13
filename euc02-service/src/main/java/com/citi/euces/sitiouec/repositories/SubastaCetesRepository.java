package com.citi.euces.sitiouec.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.dto.AutoRangoDTO;
import com.citi.euces.sitiouec.dto.CetePaginaDTO;
import com.citi.euces.sitiouec.dto.HistoricoCeteDTO;
import com.citi.euces.sitiouec.dto.HistoricoCetesDTO;
import com.citi.euces.sitiouec.entities.SubastaCetes;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

@Repository
public class SubastaCetesRepository {
	
	
	private static final Logger LOGGER = LogManager.getLogger(SubastaCetesRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SubastaCeteRepository subastaCeteRepository;
	
	
			
	@Transactional
	public List<HistoricoCetesDTO> listadoSubastaCetes(){
		
		String sql = "SELECT FECHA, CETE1PLAZO, CETE1TASA*100 as CETE1TASA,"
				+ "CETE2PLAZO, CETE2TASA*100 as CETE2TASA, CETE3PLAZO, "
				+ "CETE3TASA*100 as CETE3TASA, CETE4PLAZO, CETE4TASA*100 as CETE4TASA FROM UEC_TB_HISTORICO_CETES";
		
		LOGGER.info("class:: SubastaCetesRepository :: Method :: listadoSubastaCetes (SQL) " + " "+ sql.toString() );
		
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new HistoricoCetesDTO(
						cc.getDate("FECHA"), 
						cc.getDouble("CETE1PLAZO"),
						cc.getDouble("CETE1TASA"),
						cc.getDouble("CETE2PLAZO"),
						cc.getDouble("CETE2TASA"),
						cc.getDouble("CETE3PLAZO"),
						cc.getDouble("CETE3TASA"),
						cc.getDouble("CETE4PLAZO"),
						cc.getDouble("CETE4TASA")					
						));
		
	}
	
	@Transactional
	public HistoricoCetesDTO obtenerHistorialCetes(){
		
		String sql = "SELECT Fecha,Cete1Plazo,Cete1Tasa,Cete2Plazo,Cete2Tasa,Cete3Plazo,Cete3Tasa,Cete4Plazo, Cete4Tasa "+ " "
				+ "FROM UEC_TB_HISTORICO_CETES order by fecha asc";
		
		LOGGER.info("class:: SubastaCetesRepository :: Method :: obtenerHistorialCetes (SQL) " + " "+ sql.toString() );
		
		List<HistoricoCetesDTO> lsHistorico = new ArrayList<>();
		HistoricoCetesDTO historico1  = new HistoricoCetesDTO();
		HistoricoCetesDTO historico  = new HistoricoCetesDTO();
		try {
			lsHistorico = jdbcTemplate.query(sql,
					(cc, rowNum) -> new HistoricoCetesDTO(
							cc.getDate("FECHA"), 
							cc.getDouble("CETE1PLAZO"),
							cc.getDouble("CETE1TASA"),
							cc.getDouble("CETE2PLAZO"),
							cc.getDouble("CETE2TASA"),
							cc.getDouble("CETE3PLAZO"),
							cc.getDouble("CETE3TASA"),
							cc.getDouble("CETE4PLAZO"),
							cc.getDouble("CETE4TASA")					
							));
				
		} catch (Exception e) {
			LOGGER.info("class:: SubastaCetesRepository :: Method :: obtenerHistorialCetes (SQL) " + " "+ e.getMessage());
			LOGGER.info("class:: SubastaCetesRepository :: Method :: obtenerHistorialCetes (SQL) " + " "+ e.getStackTrace());
		}
		
		
		if(!lsHistorico.isEmpty()) {
			LOGGER.info("historico1"+ " " + lsHistorico.size());			
			historico1 = lsHistorico.isEmpty()?null : lsHistorico.get(lsHistorico.size()-1);				
		}else {
			LOGGER.info("La lista lsHistorico es null");
			
			historico = new HistoricoCetesDTO();
			historico.setCete1plazo(0.00);
			historico.setCete1tasa(0.00);
			historico.setCete2plazo(0.00);
			historico.setCete2tasa(0.00);
			historico.setCete3plazo(0.00);
			historico.setCete3tasa(0.00);
			historico.setCete4plazo(0.00);
			historico.setCete4tasa(0.00);
			historico.setFecha(new Date());

			lsHistorico.add(historico);
			
			HistoricoCetesDTO historico2 = new HistoricoCetesDTO();
			historico2.setCete1plazo(0.00);
			historico2.setCete1tasa(0.00);
			historico2.setCete2plazo(0.00);
			historico2.setCete2tasa(0.00);
			historico2.setCete3plazo(0.00);
			historico2.setCete3tasa(0.00);
			historico2.setCete4plazo(0.00);
			historico2.setCete4tasa(0.00);
			historico2.setFecha(new Date());
			
			lsHistorico.add(historico2);
			
			HistoricoCetesDTO historico3 = new HistoricoCetesDTO();
			historico3.setCete1plazo(0.00);
			historico3.setCete1tasa(0.00);
			historico3.setCete2plazo(0.00);
			historico3.setCete2tasa(0.00);
			historico3.setCete3plazo(0.00);
			historico3.setCete3tasa(0.00);
			historico3.setCete4plazo(0.00);
			historico3.setCete4tasa(0.00);
			historico3.setFecha(new Date());
			
			lsHistorico.add(historico3);
			
			historico1 = lsHistorico.isEmpty()?null : lsHistorico.get(lsHistorico.size()-1);
		}
				
		return historico1;
	}
	
	
	@Transactional
	public List<HistoricoCetesDTO> obtenerListaHistorialCetes(){
		
		String sql = "SELECT Fecha,Cete1Plazo,Cete1Tasa,Cete2Plazo,Cete2Tasa,Cete3Plazo,Cete3Tasa,Cete4Plazo, Cete4Tasa "+ " "
				+ "FROM UEC_TB_HISTORICO_CETES order by fecha asc";
		
		LOGGER.info("class:: SubastaCetesRepository :: Method :: obtenerHistorialCetes (SQL) " + " "+ sql.toString());

		List<HistoricoCetesDTO> lsHistorico = new ArrayList<>();
		HistoricoCetesDTO historico = new HistoricoCetesDTO();
		
		try {		  
			lsHistorico = jdbcTemplate.query(sql,
					(cc, rowNum) -> new HistoricoCetesDTO(
							cc.getDate("FECHA"), 
							cc.getDouble("CETE1PLAZO"),
							cc.getDouble("CETE1TASA"),
							cc.getDouble("CETE2PLAZO"),
							cc.getDouble("CETE2TASA"),
							cc.getDouble("CETE3PLAZO"),
							cc.getDouble("CETE3TASA"),
							cc.getDouble("CETE4PLAZO"),
							cc.getDouble("CETE4TASA")					
							));
			
		} catch (Exception e) {
			LOGGER.info("class:: SubastaCetesRepository :: Method :: obtenerHistorialCetes (SQL) :: Error" + " " + e.getMessage());
			LOGGER.info("class:: SubastaCetesRepository :: Method :: obtenerHistorialCetes (SQL) :: Error" + " " + e.getStackTrace());
		}
		
		if(lsHistorico.size()==0 || lsHistorico.isEmpty()) {
			
			historico = new HistoricoCetesDTO();
			historico.setCete1plazo(0.00);
			historico.setCete1tasa(0.00);
			historico.setCete2plazo(0.00);
			historico.setCete2tasa(0.00);
			historico.setCete3plazo(0.00);
			historico.setCete3tasa(0.00);
			historico.setCete4plazo(0.00);
			historico.setCete4tasa(0.00);
			historico.setFecha(new Date());

			lsHistorico.add(historico);
			
			HistoricoCetesDTO historico2 = new HistoricoCetesDTO();
			historico2.setCete1plazo(0.00);
			historico2.setCete1tasa(0.00);
			historico2.setCete2plazo(0.00);
			historico2.setCete2tasa(0.00);
			historico2.setCete3plazo(0.00);
			historico2.setCete3tasa(0.00);
			historico2.setCete4plazo(0.00);
			historico2.setCete4tasa(0.00);
			historico2.setFecha(new Date());
			
			lsHistorico.add(historico2);
			
			HistoricoCetesDTO historico3 = new HistoricoCetesDTO();
			historico3.setCete1plazo(0.00);
			historico3.setCete1tasa(0.00);
			historico3.setCete2plazo(0.00);
			historico3.setCete2tasa(0.00);
			historico3.setCete3plazo(0.00);
			historico3.setCete3tasa(0.00);
			historico3.setCete4plazo(0.00);
			historico3.setCete4tasa(0.00);
			historico3.setFecha(new Date());
			
			lsHistorico.add(historico3);
			
		}
		
		LOGGER.info("class:: SubastaCetesRepository :: size()  " + "  lsHistorico.size() "+ " "  + lsHistorico.size());
		
		
		return lsHistorico;
	}
	
	
	
	@Transactional
	public void insertHistoricoCetes(String fecha, Double cete1plazo, Double cete1tasa, Double cete2plazo, Double cete2tasa, Double cete3plazo, 
			   Double cete3tasa, Double cete4plazo, Double cete4tasa, Boolean subasta4plazos) {
		
		HistoricoCeteDTO historico        = new HistoricoCeteDTO();
		List<CetePaginaDTO> listaSubRango = new ArrayList<CetePaginaDTO>();
		
		CetePaginaDTO cete1 = new CetePaginaDTO();
		CetePaginaDTO cete2 = new CetePaginaDTO();
		CetePaginaDTO cete3 = new CetePaginaDTO();
		CetePaginaDTO cete4 = new CetePaginaDTO();
		
		cete1.setPlazo(cete1plazo);
		cete2.setPlazo(cete2plazo);
		cete3.setPlazo(cete3plazo);
		
		cete1.setTasa(cete1tasa/100);
		cete2.setTasa(cete2tasa/100);
		cete3.setTasa(cete3tasa/100);
		
		historico.setCete1plazo(cete1.getPlazo());
		historico.setCete1tasa(Math.floor(cete1.getTasa()*100)/100);		
		historico.setCete2plazo(cete2.getPlazo());
		historico.setCete2tasa(Math.floor(cete2.getTasa()*100)/100);		
		historico.setCete3plazo(cete3.getPlazo());
		historico.setCete3tasa(Math.floor(cete3.getTasa()*100)/100);
		
		if(subasta4plazos==true) {
			cete4.setPlazo(cete4plazo);
			cete4.setTasa(cete4tasa/100);
			historico.setCete4plazo(cete4.getPlazo());
			historico.setCete4tasa(Math.floor(cete4.getTasa()*100)/100);
		}else {
			
			cete4 = ObtenerUltimo4toCete();
			
		}
		
		
		listaSubRango.add(cete1);
		LOGGER.info("OBJETO - cete1" + " " +  cete1.toString());
		listaSubRango.add(cete2);
		LOGGER.info("OBJETO - cete2" + " " +  cete2.toString());
		listaSubRango.add(cete3);
		LOGGER.info("OBJETO - cete3" + " " +  cete3.toString());
		listaSubRango.add(cete4);
		LOGGER.info("OBJETO - cete4" + " " +  cete4.toString());
		
		updateCete(listaSubRango);
		listaSubRango.clear();
		
		//Actualizacion de cetes Rango 1
		listaSubRango = obtenerCetesPlazoFinalInicial(1,cete1.getPlazo()-1);
		List<CetePaginaDTO> listaSubRango1 = new ArrayList<CetePaginaDTO>();
		
		for (CetePaginaDTO item : listaSubRango) {
			
			item.setTasa((((Math.pow((1 + (item.getTasa() * cete1.getPlazo() / 360)), (item.getPlazo() / cete1.getPlazo())) - 1.0)) * 360) / item.getPlazo());
			item.setTasa(Math.floor(item.getTasa()*100)/100);
			listaSubRango1.add(item);
		}
		
		
		if(listaSubRango1.size()>0) {
			LOGGER.info("Encontro informacion en  - listaSubRango1 " + " " +  listaSubRango1.get(0).getPlazo());
			updateCete(listaSubRango1);
			listaSubRango.clear();
		}
		
		
		
		/**
		 * Actualizacion de cetes Rango 2
		 */
		listaSubRango = obtenerCetesPlazoFinalInicial(cete1.getPlazo()+1,cete2.getPlazo()-1);
		List<CetePaginaDTO> listaSubRango2 = new ArrayList<CetePaginaDTO>();
		
		for (CetePaginaDTO item : listaSubRango) {
			
			double tasaTemp2 = cete2.getTasa() * 100; 
			double tasaTemp1 = cete1.getTasa() * 100;
   
			double value =  ((((Math.pow((((1 + ((tasaTemp2 * cete2.getPlazo()) / 36000))) / (1 + ((tasaTemp1 * cete1.getPlazo()) / 36000))),
                    (item.getPlazo() - cete1.getPlazo()) / (cete2.getPlazo() - cete1.getPlazo()))
					        ) * (1 + (tasaTemp1 * cete1.getPlazo()) / 36000)
					     ) - 1
					 ) * 36000
					) / item.getPlazo();
			
			item.setTasa(value);
			item.setTasa(Math.floor((item.getTasa()/100)*100)/100);
			listaSubRango2.add(item);
		}
		
		if(listaSubRango2.size()>0) {
			LOGGER.info("Encontro informacion en  - listaSubRango2 " + " " +  listaSubRango2.get(0).getPlazo());
			updateCete(listaSubRango2);
			listaSubRango.clear();
			
		}
		
		/**
		 * Actualizacion de cetes Rango 3
		 */
		listaSubRango = obtenerCetesPlazoFinalInicial(cete2.getPlazo()+1,cete3.getPlazo()-1);
		List<CetePaginaDTO> listaSubRango3 = new ArrayList<CetePaginaDTO>();

		for (CetePaginaDTO item : listaSubRango) {
			
			double tasaTemp3 = cete3.getTasa() * 100; 
			double tasaTemp2 = cete2.getTasa() * 100;

            double value = ((((Math.pow((((1 + ((tasaTemp3 * cete3.getPlazo()) / 36000))) / (1 + ((tasaTemp2 * cete2.getPlazo()) / 36000))),
                                             (item.getPlazo() - cete2.getPlazo()) / (cete3.getPlazo() - cete2.getPlazo()))
                                 ) * (1 + (tasaTemp2 * cete2.getPlazo()) / 36000)
                              ) - 1
                          ) * 36000
                       ) / item.getPlazo();
            
            item.setTasa(Math.floor(value*100)/100);
            listaSubRango3.add(item);
            
		}
		
		if(listaSubRango3.size()>0) {
			LOGGER.info("Encontro informacion en  - listaSubRango3 " + " " +  listaSubRango3.get(0).getPlazo());
			updateCete(listaSubRango3);
			listaSubRango.clear();
		}
		
		
		/**
		 * Actualizacion de cetes Rango 4
		 */
		listaSubRango = obtenerCetesPlazoFinalInicial(cete3.getPlazo()+1,cete4.getPlazo()-1);
		List<CetePaginaDTO> listaSubRango4 = new ArrayList<CetePaginaDTO>();

		for (CetePaginaDTO item : listaSubRango4) {
			
			double tasaTemp4 = cete4.getTasa() * 100; 
			double tasaTemp3 = cete3.getTasa() * 100;

            double value = ((((Math.pow((((1 + ((tasaTemp4 * cete4.getPlazo()) / 36000))) / (1 + ((tasaTemp3 * cete3.getPlazo()) / 36000))),
                                             (item.getPlazo() - cete3.getPlazo()) / (cete4.getPlazo() - cete3.getPlazo()))
                                 ) * (1 + (tasaTemp3 * cete3.getPlazo()) / 36000)
                              ) - 1
                          ) * 36000
                       ) / item.getPlazo();

            item.setTasa(Math.floor(value*100)/100);
            listaSubRango4.add(item);            
		}
		
		if(listaSubRango4.size()>0) {
			LOGGER.info("Encontro informacion en  - listaSubRango4 " + " " +  listaSubRango4.get(0).getPlazo());
			updateCete(listaSubRango4);
			listaSubRango.clear();			
		}
		
		
		
		/**
		 * Actualizacion de cetes Rango 5
		 */
		listaSubRango = obtenerCetesPlazoFinalInicial(cete4.getPlazo()+1,378);
		List<CetePaginaDTO> listaSubRango5 = new ArrayList<CetePaginaDTO>();

		for (CetePaginaDTO item : listaSubRango) {
			
			double value = (((Math.pow((1 + (cete4.getTasa() * cete4.getPlazo() / 360)), (item.getPlazo() / cete4.getPlazo())) - 1.0)) * 360) / item.getPlazo();			
			item.setTasa(Math.floor(value*100)/100);
			listaSubRango5.add(item);
		}	
		
		if(listaSubRango5.size()>0) {
			LOGGER.info("Encontro informacion en  - listaSubRango5 " + " " +  listaSubRango5.get(0).getPlazo());
			updateCete(listaSubRango5);
			listaSubRango.clear();			
		}
		
		Instant  instant = Instant.now();
		Timestamp timeStamp = Timestamp.from(instant);		
		historico.setFecha(timeStamp);
		
		/**
		 * Save to Historico de CETES
		 */
		
		SubastaCetes subastaCetes = new SubastaCetes();
		subastaCetes.setFecha(historico.getFecha());
		
		subastaCetes.setCete1plazo(Math.round(historico.getCete1plazo()));
		subastaCetes.setCete1tasa(historico.getCete1tasa());
		
		subastaCetes.setCete2plazo(Math.round(historico.getCete2plazo()));
		subastaCetes.setCete2tasa(historico.getCete2tasa());
		
		subastaCetes.setCete3plazo(Math.round(historico.getCete3plazo()));
		subastaCetes.setCete3tasa(historico.getCete3tasa());
		subastaCetes.setCete4plazo(Math.round(historico.getCete4plazo()));
		subastaCetes.setCete4tasa(historico.getCete4tasa());
		
		/**
		 * Si no tiene el cete4Plazo entonces no se debe de incluir actualizar 
		 */
		if(historico.getCete4plazo()!=null) {
			subastaCetes.setCete4plazo(Math.round(historico.getCete4plazo()));
			subastaCetes.setCete4tasa(historico.getCete4tasa());				
		}
		
		try {
			subastaCeteRepository.save(subastaCetes);
			LOGGER.info("Save Historico de Cetes " + " " +  subastaCetes.toString());
		} catch (Exception e) {
			LOGGER.error("Error:: updateCete - " + " " + e.getMessage());
			LOGGER.error("Error:: updateCete - " + " " + e.getCause());
			LOGGER.error("Error:: updateCete - " + " " + e.getStackTrace());
		}
		
	}
	
	@Transactional
    public int[][] batchInsert(List<AutoRangoDTO> books, int batchSize) throws GenericException {
		try {
			int[][] sql = jdbcTemplate.batchUpdate(
	                "INSERT INTO UEC_TB_AUTORANGOS (ID_RANGO, RANGOMIN, RANGOMAX, MILL_DOSMILLQUIN, DOSMILLQUIN_CINCOMILL, CINCOMILL_SIETEMILLQUIN, "
	                + "SIETEMILLQUIN_DIEZMILL, DIEZMILL_VEINTEMILL, VEINTEMILL_DOSCIENTOSMILL, FECHA, FECHAFIN) "
	                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)",
	                books,
	                batchSize,
	                new ParameterizedPreparedStatementSetter<AutoRangoDTO>() {
	                    public void setValues(PreparedStatement ps, AutoRangoDTO content) throws SQLException {
	                    	try {
	                    		ps.setString(1, content.getIdRango());
	                    		ps.setString(2, content.getRangoMin());
	                    		ps.setString(3, content.getRangoMax());
	                    		ps.setString(4, content.getMilDosMilQuin());
	                    		ps.setString(5, content.getMilDosMilQuin());
	                    		ps.setString(6, content.getDosMilCincoMil());
	                    		ps.setString(7, content.getCincoMilSieteMil());
	                    		ps.setString(8, content.getSieteMilDiezMil());
	                    		ps.setString(9, content.getDiezMilVeinteMil());
	                    		ps.setString(10, content.getVeinteMilDoscientoMil());
	                    		ps.setString(10, content.getFecha());
	                    		ps.setString(10, content.getFechaFin());
	                    	} catch (SQLException e) {
	                			e.printStackTrace();
	                        }
	                    }
	                });
	        return sql;	
		} catch (Exception e) {
			e.printStackTrace();
            throw new GenericException( "Error al guardar en :: ARCHIVO TEMPORAL ", HttpStatus.NOT_FOUND.toString());
        }
	}
	
	public void borrarTablaCetes() {
		String query = "DELETE FROM UEC_TB_AUTOCETES";
		jdbcTemplate.execute(query);
	}
	
	public void borrarTablaRangos() {
		String query = "DELETE FROM UEC_TB_AUTORANGOS";
		jdbcTemplate.execute(query);
	}
	
	
	@Transactional
	public List<CetePaginaDTO> obtenerCetes(){
		
		String sql ="SELECT Id_Plazo,Cete FROM uec_tb_Cetes";
		
		LOGGER.info("class:: SubastaCetesRepository :: Method :: obtenerCetes (SQL) " + " "+ sql.toString());
		
		List<CetePaginaDTO> lsCete = new ArrayList<>();
		CetePaginaDTO  cete = new CetePaginaDTO();
		
		try {
			lsCete =  jdbcTemplate.query(sql,
					(cc, rowNum) -> new CetePaginaDTO(
							cc.getDouble("Id_Plazo"), 
							cc.getDouble("Cete")));				
		} catch (Exception e) {
			cete = new CetePaginaDTO();
			cete.setPlazo(0.00);
			cete.setTasa(0.00);
			cete.setVariacion("");
			lsCete.add(cete);
			LOGGER.error("lass:: SubastaCetesRepository :: Method :: obtenerCetes (SQL) " + e.getMessage());
			LOGGER.error("lass:: SubastaCetesRepository :: Method :: obtenerCetes (SQL) " + e.getStackTrace());
		}	
		
		if(lsCete.isEmpty()) {
			
			cete = new CetePaginaDTO();
			cete.setPlazo(0.00);
			cete.setTasa(0.00);
			cete.setVariacion("");
			lsCete.add(cete);
			
			LOGGER.info("No se encontro información de Cetes pero se llena el objeto  " + " "+ lsCete.size());
		}
		
		
		return lsCete;
	 }
	
	@Transactional
	public List<CetePaginaDTO> obtenerCetesPlazoFinalInicial(double plazoInicial, double plazoFinal){
		
		String sql ="SELECT Id_Plazo,Cete FROM uec_tb_Cetes "
				+ "    Where Id_Plazo between '"+plazoInicial+"' AND  '"+plazoFinal+"'";
		
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new CetePaginaDTO(
						cc.getDouble("Id_Plazo"), 
						cc.getDouble("Cete")));
			
	}
	
	
	
	@Transactional
	public CetePaginaDTO ObtenerUltimo4toCete(){
		
		String sql ="SELECT Cete4Plazo, Cete4Tasa FROM UEC_TB_HISTORICO_CETES WHERE Cete4Plazo <> 0"
				+ " order by fecha desc fetch first 1 rows only";
		
		LOGGER.info("class:: SubastaCetesRepository :: Method :: ObtenerUltimo4toCete (SQL) " + " "+ sql.toString() );
		
		CetePaginaDTO ceteBE =  jdbcTemplate.queryForObject(sql,
				(cc, rowNum) -> new CetePaginaDTO(
						cc.getDouble("Cete4Plazo"), 
						cc.getDouble("Cete4Tasa")));
		
		return ceteBE;
	 }
	
	
	@Transactional
	public void updateCete (List<CetePaginaDTO> items) {
		int res=0;
		
		for (CetePaginaDTO cetePaginaDTO : items) {
			
			String sql = " UPDATE uec_tb_Cetes SET Cete =" + cetePaginaDTO.getTasa()+ " WHERE Id_Plazo=" + cetePaginaDTO.getPlazo() +"";
			
			try {
				res = jdbcTemplate.update(sql);
				LOGGER.info("OBJETO QUE SE ACTUALIZO " + " " +  sql.toString());
				LOGGER.info("OBJETO QUE SE ACTUALIZO " + " " +  cetePaginaDTO.toString());
				res=1;
			} catch (Exception e) {
				LOGGER.error("Error:: updateCete - " + " " + e.getMessage());
				LOGGER.error("Error:: updateCete - " + " " + e.getCause());
				LOGGER.error("Error:: updateCete - " + " " + e.getStackTrace());
			}
			
			LOGGER.info("Resultado por Iteraccion " + " " +  res);
		}
		
	}
	
	
}