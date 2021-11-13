package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.dto.PerCatFolioSolicitudesUECDTO;

@Repository
public class PerCatFolioSolicitudesUECRepository {
	
	private static final Logger LOGGER = LogManager.getLogger(TasasRepository.class);
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@Transactional
	public List<PerCatFolioSolicitudesUECDTO> getPDFFolioCliente(String numCliente) {

		String sql = "select PDF_FOLIO_VALOR,PDF_FOLIO_ESPECIAL_OFERTA_ID,PDF_FOLIO_ID_CLIENTE,PDF_FOLIO_ESTATUS"
				+ " from per_cat_folio WHERE PDF_FOLIO_ID_CLIENTE= '"+ numCliente  + "'";
		
		LOGGER.info("Query - Method -  getPDFFolioCliente" + " " + sql.toString());		
		
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new PerCatFolioSolicitudesUECDTO(cc.getString("PDF_FOLIO_VALOR"), cc.getString("PDF_FOLIO_ESPECIAL_OFERTA_ID"),
						cc.getLong("PDF_FOLIO_ID_CLIENTE"), cc.getLong("PDF_FOLIO_ESTATUS")));
	}
	
	@Transactional
	public int actualizarEstatusClientes (List<String> lsFoliosActualizar) {

		int res=0;
		
		for (String folio : lsFoliosActualizar) {
			
			String sql = "update per_cat_folio Set PDF_FOLIO_ESTATUS=0  Where PDF_FOLIO_ID_CLIENTE = '" + folio + "'";
			
			try {
				res = jdbcTemplate.update(sql);
				LOGGER.info("Query - Method - Se actualizo el folio" + " " + folio);
				LOGGER.info("Query - Method -  actualizarEstatusClientes" + " " + res);
				res = 1;
			} catch (Exception e) {
				LOGGER.error("Error:: actualizarEstatusClientes - " + " " + e.getMessage());
				LOGGER.error("Error:: actualizarEstatusClientes - " + " " + e.getCause());
				LOGGER.error("Error:: actualizarEstatusClientes - " + " " + e.getStackTrace());
			}	
			
		}		
		return res;
	}	
	

	@Transactional
	public int actualizarPDFFolioClienteIdCliente (List<String> lsFoliosActualizar) {

		int res=0;
		
		for (String folio : lsFoliosActualizar) {
			
			String sql = "update per_cat_folio Set PDF_FOLIO_ID_CLIENTE=0  Where PDF_FOLIO_ID_CLIENTE = '" + folio + "'";
			
			try {
				res = jdbcTemplate.update(sql);
				LOGGER.info("Query - Method - Se actualizo el folio PDF_FOLIO_ID_CLIENTE" + " " + folio);
				LOGGER.info("Query - Method -  actualizarEstatusClientes" + " " + res);
				res = 1;
			} catch (Exception e) {
				LOGGER.error("Error:: actualizarEstatusClientes - " + " " + e.getMessage());
				LOGGER.error("Error:: actualizarEstatusClientes - " + " " + e.getCause());
				LOGGER.error("Error:: actualizarEstatusClientes - " + " " + e.getStackTrace());
			}	
			
		}		
		return res;
		
	}	
	

}
