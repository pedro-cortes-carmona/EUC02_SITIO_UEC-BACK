package com.citi.euces.sitiouec.services.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.citi.euces.sitiouec.dto.PetCatEjecutivoSucursalCampanaDTO;
public class PetCatEjecuSucuCampanaMapper implements RowMapper<PetCatEjecutivoSucursalCampanaDTO> {

	@Override
	public PetCatEjecutivoSucursalCampanaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PetCatEjecutivoSucursalCampanaDTO ejecutivos = new PetCatEjecutivoSucursalCampanaDTO();
		ejecutivos.setSoied(rs.getString("SOIED"));
		ejecutivos.setNomina(rs.getLong("NOMINA"));
		ejecutivos.setNombre(rs.getString("NOMBRE"));
		ejecutivos.setSirhSucursal(rs.getLong("SIRH_SUCURSAL"));
		ejecutivos.setPuestoTipo(rs.getString("PUESTO_TIPO"));
		ejecutivos.setPriority(rs.getString("PRIORITY_"));
		
		return ejecutivos;
	}

}
