package com.citi.euces.sitiouec.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.dto.BuscarWebDTO;
import com.citi.euces.sitiouec.dto.CatSucursalesDTO;
import com.citi.euces.sitiouec.dto.ConsultarAutorizadorDTO;


@Repository
public class WebAutorizadoresRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	//BUSCAR AUTORIZADORES WEB
	@Transactional
	public List<BuscarWebDTO> getBuscarWebAutorizadores(String Inic, String division){
		String sql = null;
		
		if(Inic == null || Inic == "" ) {
			sql = "Select Soeid, Division, SOEID_Divisional,distristo, Nombre,Inic,Fecha_Inicio,Fecha_Termino,Alta, CORREO, IS_CETE100, IS_CAMPESP, id_nivel_auto "
					+ "from UEC_CATALOGO_AUTORIZADORES2021  where division like '%"+division+"%' ORDER BY Division ";	
		}		
		else if(division == null || division == "" ){
			sql = "Select Soeid, Division, SOEID_Divisional,distristo, Nombre,Inic,Fecha_Inicio,Fecha_Termino,Alta, CORREO, IS_CETE100, IS_CAMPESP, id_nivel_auto "
					+ "from UEC_CATALOGO_AUTORIZADORES2021  where Inic like '%"+Inic+"%' ORDER BY Division";
		}
		else {
			sql = "Select Soeid, Division, SOEID_Divisional,distristo, Nombre,Inic,Fecha_Inicio,Fecha_Termino,Alta, CORREO, IS_CETE100, IS_CAMPESP, id_nivel_auto "
					+ "from UEC_CATALOGO_AUTORIZADORES2021  where Inic like '%"+Inic+"%' and division like '%"+division+"%' ORDER BY Division";
		}
			
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new BuscarWebDTO(
						cc.getString("Soeid"), 
						cc.getString("Division"),
						cc.getString("SOEID_Divisional"),
						cc.getString("distristo"),
						cc.getString("Nombre"),
						cc.getString("Inic"),
						cc.getDate("Fecha_Inicio"),
						cc.getDate("Fecha_Termino"),
						cc.getLong("Alta"),
						cc.getString("CORREO"),
						cc.getLong("IS_CETE100"),
						cc.getLong("IS_CAMPESP"),
						cc.getLong("id_nivel_auto")						
						));
	}
	
	//LISTA DE CATALOGOS DE SUCURSALES
	public List<CatSucursalesDTO> getCatalogoSucursales(){
		String sql = "SELECT DISTINCT SUCURSAL FROM UEC_CAT_SUC2021";
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new CatSucursalesDTO(
						cc.getString("SUCURSAL")));
	}
	
	//SERVICIO DE BUSCAR SUCURSAL
	@Transactional
	public void desativarUsuario(String soeid) {
		String query = "UPDATE UEC_CATALOGO_AUTORIZADORES2021 SET ALTA = 0 WHERE SOEID = '"+soeid+"'";
		jdbcTemplate.execute(query);
	}
	
	//INSERTAR CATALOGOS AUTORIZADORES
	@Transactional
	public void insertarAutorizadores(String soeid, String soeidDivisional, String soeidDistrital, String division, String distrito
			,String nombre, String inic, String fechaInicio, String fechaTermino, Long alta, String correo, Long isCete100, Long isCampesp,
			Long idNivelAuto) {
		
		String query = "INSERT INTO UEC_CATALOGO_AUTORIZADORES2021 (SOEID, SOEID_DIVISIONAL, SOEID_DISTRITAL, DIVISION, DISTRISTO,"
				+ " NOMBRE, INIC, FECHA_INICIO, FECHA_TERMINO, ALTA, CORREO, IS_CETE100, IS_CAMPESP, ID_NIVEL_AUTO) "
				+ "VALUES ('"+soeid+"','"+soeidDivisional+"','"+soeidDistrital+"', '"+division+"','"+distrito+"','"+nombre+"','"+inic+"',"
				+ "TO_DATE('"+fechaInicio+"', 'DD/MM/YYYY'),TO_DATE('"+fechaTermino+"', 'DD/MM/YYYY'),"+alta+",'"+correo+"',"+isCete100+","+isCampesp+","+idNivelAuto+")";
		jdbcTemplate.execute(query);
	}
	
	//CONSULTAR EL CAMPO QUE SE DESEA MODIFICAR
	@Transactional
	public List<ConsultarAutorizadorDTO> consultarAutorizadores(String soeid) {
		String sql = "SELECT SOEID, SOEID_DIVISIONAL, SOEID_DISTRITAL, DIVISION, DISTRISTO, "
				+ "NOMBRE, INIC, FECHA_INICIO, FECHA_TERMINO, ALTA, CORREO, IS_CETE100, IS_CAMPESP, ID_NIVEL_AUTO "
				+ "FROM UEC_CATALOGO_AUTORIZADORES2021 WHERE SOEID = '"+soeid+"'";
		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new ConsultarAutorizadorDTO(
						cc.getString("SOEID"),
						cc.getString("SOEID_DIVISIONAL"),
						cc.getString("SOEID_DISTRITAL"),
						cc.getString("DIVISION"),						
						cc.getString("DISTRISTO"),
						cc.getString("NOMBRE"),
						cc.getString("INIC"),
						cc.getDate("FECHA_INICIO"),
						cc.getDate("FECHA_TERMINO"),
						cc.getString("CORREO"),
						cc.getLong("IS_CETE100"),
						cc.getLong("IS_CAMPESP"),
						cc.getLong("ID_NIVEL_AUTO")
						));
	}
	
	//MODIFICAR USUARIO
	@Transactional
	public void modificarAutorizadores(String soeid, String soeidDivisional, String soeidDistrital, String division, String distrito
			,String nombre, String inic, String fechaInicio, String fechaTermino, Long alta, String correo, Long isCete100, Long isCampesp,
			Long idNivelAuto) {
	
		String query = "UPDATE UEC_CATALOGO_AUTORIZADORES2021 SET SOEID_DIVISIONAL = '"+soeidDivisional+"', SOEID_DISTRITAL = '"+soeidDistrital+"', DIVISION = '"+division+"',"
				+ "DISTRISTO = '"+distrito+"', NOMBRE = '"+nombre+"', INIC = '"+inic+"', FECHA_INICIO = TO_DATE('"+fechaInicio+"', 'DD/MM/YYYY'), FECHA_TERMINO = TO_DATE('"+fechaTermino+"', 'DD/MM/YYYY'), "
				+ "ALTA = "+alta+", CORREO = '"+correo+"', IS_CETE100 = "+isCete100+", IS_CAMPESP = "+isCampesp+", ID_NIVEL_AUTO = "+idNivelAuto+" WHERE SOEID = '"+soeid+"' ";
		jdbcTemplate.execute(query);
		
	}
	

}
