package com.citi.euces.sitiouec.repositories;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.dto.AutoAutorizadorDTO;
import com.citi.euces.sitiouec.dto.AutoTasasDTO;
import com.citi.euces.sitiouec.dto.AutoTasasEmailDTO;
import com.citi.euces.sitiouec.dto.AutorizadorElegidoDTO;
import com.citi.euces.sitiouec.dto.CargaCeteDTO;
import com.citi.euces.sitiouec.dto.CargaGridDTO;
import com.citi.euces.sitiouec.dto.EditarTasaAutoDTO;
import com.citi.euces.sitiouec.dto.EmailTasaEspecialDTO;
import com.citi.euces.sitiouec.dto.MensajeDTO;
import com.citi.euces.sitiouec.dto.PerCatSucursalesDTO;
import com.citi.euces.sitiouec.dto.ResendMailDTO;
import com.citi.euces.sitiouec.entities.AutoTasas;
import com.citi.euces.sitiouec.entities.UecCatGralCtesUEC;

@Repository
public class TasaAutoRepository {

	private static final Logger LOGGER = LogManager.getLogger(TasaAutoRepository.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private AutoTasasRepository autoTasasRepository;

	@Autowired
	private TasasRepository tasasService;

	@Autowired
	private UecCatGralCtesUECRepository catGral;

	// SERVICIO CARGA GRID
	@Transactional
	public List<CargaGridDTO> getCargaGrid() {

		String sql = "SELECT p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
				+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
				+ "p.MONTO, p.TASA_AUTORI, p.AUTORIZADORES, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
				+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
				+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'MM/DD/YY'),'MM/DD/YY') = to_date(to_char(SYSDATE, 'MM/DD/YY'),'MM/DD/YY') "
				+ "AND p.estatus = 'ACEPTADA' ORDER BY p.FECHA_SOLIC ASC";

		LOGGER.info("class:: TasaAutoRepository - Method ::getCargaGrid - SQL" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new CargaGridDTO(cc.getLong("ID_TASAUTO"), cc.getString("SOEID_ASIG"),
						cc.getString("ESTATUS"), cc.getString("FECHA_SOLIC"), cc.getString("OFERTA_ID"),
						cc.getString("ID_CAMPANA"), cc.getString("CONTRATO"), cc.getLong("NUM_CTE"),
						cc.getString("NOM_CTE"), cc.getString("SUC"), cc.getLong("PLAZO"), cc.getLong("MONTO"),
						cc.getLong("TASA_AUTORI"), cc.getString("FECHA_AUTORI"), cc.getString("INIC_AUTORI"),
						cc.getString("FECHA_ESTATUS"), cc.getLong("NUM_AUTORI_UEC"), cc.getString("OBSERVA_WEB"),
						cc.getString("AUTORIZADORES")

				));

	}

	/**
	 * Método para buscar toda la información que se muestra en el Layout de Página
	 * Web Operaciones UEC
	 * 
	 * @return
	 */

	@Transactional
	public List<AutoTasasDTO> getCargaGridLoad(String fecha, String estatus, String contrato, String cliente) {

		String F100CETE = "PORTAESPNOM";
		String F100CETESDO = "RETEN20212105";
		String F100CETENOM = "RETENSDO520212";
		
		@SuppressWarnings("unused")
		String PRIO110CETE2019 = "RETENOP20212100";
		
		@SuppressWarnings("unused")
		String HIPOTECA2020 = "HIPOTECA2021";
		
		String F100CETE110 = "PTU2021110";
		String CREDNOM = "CREDNOM2021";
		
		@SuppressWarnings("unused")
		String ONBOARDING = "ONBOARDING2021";

		List<AutoTasasDTO> listaSolicitudes = new ArrayList<AutoTasasDTO>();

		List<AutoTasasDTO> listaSolicitudesFinal = new ArrayList<AutoTasasDTO>();
		AutoTasasDTO autoTasasDTOFinal = new AutoTasasDTO();

		List<AutoAutorizadorDTO> lsAutoAutorizador = obtenerAutorizadoresDivisionales("", "");

		LOGGER.info("Ingresa al Metodo - lsAutoAutorizador" + " " + lsAutoAutorizador.size());

		List<AutoTasasDTO> listaCETE98HOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana("AutCETE98", "");

		LOGGER.info("Ingresa al Metodo - listaCETE98HOY" + " " + listaCETE98HOY.size());

		@SuppressWarnings("unused")
		List<AutoTasasDTO> listaEspecialHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana("ESPECIAL", "");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> listaEspecialGERHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana("EXCEPGER",
				"");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> listaEspecialPORTAHOY = tasasService
				.obtenerRegistrosDeClienteRepetidosPorCampana("PORTAESPNOM", "");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETE = tasasService.obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(F100CETE,
				null);
		
		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETEHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana(F100CETE, "");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETESDO = tasasService
				.obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(F100CETESDO, null);
		
		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETESDOHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana(F100CETESDO,
				"");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LF100CETE110 = tasasService
				.obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(F100CETE110, null);
		
		@SuppressWarnings("unused")
		List<AutoTasasDTO> LF100CETE110HOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana(F100CETE110, "");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCREDNOM = tasasService.obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(CREDNOM, null);

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCREDNOMHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana(CREDNOM, "");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETENOM = tasasService
				.obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(F100CETENOM, null);
		
		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETENOMHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana(F100CETENOM,
				"");

		listaSolicitudes = tasasService.obtenerRegistrosAutoTasas(fecha, estatus, contrato, cliente);

		LOGGER.info("Ingresa al Metodo - listaSolicitudes" + " " + listaSolicitudes.size());

		/**
		 * For Pendiente de validacion con Front
		 */

		for (AutoTasasDTO autoTasasDTO : listaSolicitudes) {

			if (autoTasasDTO.getDistrito() == null || autoTasasDTO.getDistrito().equals("")) {

				PerCatSucursalesDTO obtenerSuc = tasasService
						.obtenerSucursal(String.valueOf(autoTasasDTO.getSucSolic()));
				LOGGER.info("obtenerSuc.getNombreSucursal() - SQL" + " " + obtenerSuc.getNombreSucursal());
				LOGGER.info("obtenerSuc.getNombreSucursal() - SQL" + " " + obtenerSuc.toString());
				autoTasasDTO.setDistrito(obtenerSuc.getNombreSucursal());
			}
			LOGGER.info("ELEMENTOS QUE SE ENCONTRARON - SQL" + " " + autoTasasDTO.toString());

			Optional<UecCatGralCtesUEC> numCliente = catGral.findById(autoTasasDTO.getNumCliente());

			if (numCliente.isPresent()) {
				autoTasasDTO
						.setEstatusCliente(numCliente.get().getContrato() != 0 ? "CLIENTE EXISTENTE" : "CLIENTE NUEVO");
				LOGGER.info("CLIENTE ENCONTRADO EN LA TABLA DE UecCatGralCtesUEC - Contrato" + " "
						+ numCliente.get().getContrato());
			}

			autoTasasDTO.setFechaAuto(
					autoTasasDTO.getFechaAutori() != null ? autoTasasDTO.getFechaAutori().toString() : "");
			
			autoTasasDTO.setFechaLiberacion(
					autoTasasDTO.getFechaLiberacion() != null ? autoTasasDTO.getFechaLiberacion().toString() : "");
			
			autoTasasDTO
					.setFechaSoliS(autoTasasDTO.getFechaSoli() != null ? autoTasasDTO.getFechaSoli().toString() : "");
			
			autoTasasDTO.setFechaEstatusS(autoTasasDTO.getFechaEstatus() != null ? autoTasasDTO.getFechaEstatus().toString() : "");
			
			autoTasasDTO.setOfertaCampanaID(autoTasasDTO.getIdCampana() != null ? autoTasasDTO.getTipoAutori()
					: autoTasasDTO.getOfertaCampanaID());

			autoTasasDTOFinal = new AutoTasasDTO();
			autoTasasDTOFinal = autoTasasDTO;
			LOGGER.info("Elementos que van a la lista final - autoTasasDTOFinal" + " " + autoTasasDTOFinal.toString());
			listaSolicitudesFinal.add(autoTasasDTOFinal);
		}

		LOGGER.info("Ingresa al Metodo - listaSolicitudesFinal" + " " + listaSolicitudesFinal.size());

		return listaSolicitudesFinal;

	}

	@Transactional
	public List<AutoTasasDTO> getCargaGridLoadVersion2(String fecha, String estatus, String contrato, String cliente) {

		String F100CETE = "PORTAESPNOM";
		String F100CETESDO = "RETEN20212105";
		String F100CETENOM = "RETENSDO520212";
		
		@SuppressWarnings("unused")
		String PRIO110CETE2019 = "RETENOP20212100";// No existe
		
		@SuppressWarnings("unused")
		String HIPOTECA2020 = "HIPOTECA2021";
		
		String F100CETE110 = "PTU2021110";
		String CREDNOM = "CREDNOM2021";
		
		@SuppressWarnings("unused")
		String ONBOARDING = "ONBOARDING2021";

		List<AutoTasasDTO> listaSolicitudes = new ArrayList<AutoTasasDTO>();

		List<AutoTasasDTO> listaSolicitudesFinal = new ArrayList<AutoTasasDTO>();
		AutoTasasDTO autoTasasDTOFinal = new AutoTasasDTO();

		List<AutoAutorizadorDTO> lsAutoAutorizador = obtenerAutorizadoresDivisionales("", "");

		LOGGER.info("Ingresa al Metodo - lsAutoAutorizador" + " " + lsAutoAutorizador.size());

		List<AutoTasasDTO> listaCETE98HOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana("AutCETE98", "");

		LOGGER.info("Ingresa al Metodo - listaCETE98HOY" + " " + listaCETE98HOY.size());

		@SuppressWarnings("unused")
		List<AutoTasasDTO> listaEspecialHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana("ESPECIAL", "");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> listaEspecialGERHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana("EXCEPGER",
				"");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> listaEspecialPORTAHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana("PORTAESPNOM", "");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETE = tasasService.obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(F100CETE,null);
		
		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETEHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana(F100CETE, "");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETESDO = tasasService.obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(F100CETESDO, null);
		
		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETESDOHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana(F100CETESDO,"");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LF100CETE110 = tasasService
				.obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(F100CETE110, null);
		
		@SuppressWarnings("unused")
		List<AutoTasasDTO> LF100CETE110HOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana(F100CETE110, "");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCREDNOM = tasasService.obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(CREDNOM, null);

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCREDNOMHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana(CREDNOM, "");

		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETENOM = tasasService
				.obtenerRegistrosDeClienteRepetidosPorCampanaFechaNull(F100CETENOM, null);
		
		@SuppressWarnings("unused")
		List<AutoTasasDTO> LCtsF100CETENOMHOY = tasasService.obtenerRegistrosDeClienteRepetidosPorCampana(F100CETENOM,"");

		listaSolicitudes = tasasService.obtenerRegistrosAutoTasasV1(fecha, estatus, contrato, cliente);

		LOGGER.info("Ingresa al Metodo - listaSolicitudes" + " " + listaSolicitudes.size());

		for (AutoTasasDTO autoTasasDTO : listaSolicitudes) {

			if (autoTasasDTO.getDistrito() == null || autoTasasDTO.getDistrito().equals("")) {

				PerCatSucursalesDTO obtenerSuc = tasasService
						.obtenerSucursal(String.valueOf(autoTasasDTO.getSucSolic()));
				LOGGER.info("obtenerSuc.getNombreSucursal() - SQL" + " " + obtenerSuc.getNombreSucursal());
				LOGGER.info("obtenerSuc.getNombreSucursal() - SQL" + " " + obtenerSuc.toString());
				autoTasasDTO.setDistrito(obtenerSuc.getNombreSucursal());
			}
			
			LOGGER.info("ELEMENTOS QUE SE ENCONTRARON - SQL" + " " + autoTasasDTO.toString());

			Optional<UecCatGralCtesUEC> numCliente = catGral.findById(autoTasasDTO.getNumCliente());

			if (numCliente.isPresent()) {
				autoTasasDTO
						.setEstatusCliente(numCliente.get().getContrato() != 0 ? "CLIENTE EXISTENTE" : "CLIENTE NUEVO");
				LOGGER.info("CLIENTE ENCONTRADO EN LA TABLA DE UecCatGralCtesUEC - Contrato" + " "
						+ numCliente.get().getContrato());
			}
			
			autoTasasDTO.setFechaEstatusS(autoTasasDTO.getFechaEstatus() != null ? autoTasasDTO.getFechaEstatus().toString() : "");
			
			autoTasasDTO.setFechaAuto(
					autoTasasDTO.getFechaAutori() != null ? autoTasasDTO.getFechaAutori().toString() : "");
			
			autoTasasDTO.setFechaLiberacion(
					autoTasasDTO.getFechaLiberacion() != null ? autoTasasDTO.getFechaLiberacion().toString() : "");
			
			autoTasasDTO
					.setFechaSoliS(autoTasasDTO.getFechaSoli() != null ? autoTasasDTO.getFechaSoli().toString() : "");
			
			autoTasasDTO.setOfertaCampanaID(autoTasasDTO.getIdCampana() != null ? autoTasasDTO.getTipoAutori()
					: autoTasasDTO.getOfertaCampanaID());

			autoTasasDTOFinal = new AutoTasasDTO();
			autoTasasDTOFinal = autoTasasDTO;
			LOGGER.info("Elementos que van a la lista final - autoTasasDTOFinal" + " " + autoTasasDTOFinal.toString());
			listaSolicitudesFinal.add(autoTasasDTOFinal);
		}

		LOGGER.info("Ingresa al Metodo - listaSolicitudesFinal" + " " + listaSolicitudesFinal.size());

		return listaSolicitudesFinal;

	}

	// SERVICIO IN BUSCAR CLICK
	@Transactional
	public List<CargaGridDTO> getInBuscarClick(String estatus, String contrato, String numeroCliente,
			String fechaSolicitud) {

		String sql = "";

		sql = createParameterToSql(estatus, contrato, numeroCliente, fechaSolicitud, sql);

		LOGGER.info("class:: TasaAutoRepository - Method ::getInBuscarClick - SQL" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new CargaGridDTO(cc.getLong("ID_TASAUTO"), cc.getString("SOEID_ASIG"),
						cc.getString("ESTATUS"), cc.getString("FECHA_SOLIC"), cc.getString("OFERTA_ID"),
						cc.getString("ID_CAMPANA"), cc.getString("CONTRATO"), cc.getLong("NUM_CTE"),
						cc.getString("NOM_CTE"), cc.getString("SUC"), cc.getLong("PLAZO"), cc.getLong("MONTO"),
						cc.getLong("TASA_AUTORI"), cc.getString("FECHA_AUTORI"), cc.getString("INIC_AUTORI"),
						cc.getString("FECHA_ESTATUS"), cc.getLong("NUM_AUTORI_UEC"), cc.getString("OBSERVA_WEB"),
						cc.getString("AUTORIZADORES")));

	}

	private String createParameterToSql(String estatus, String contrato, String numeroCliente, String fechaSolicitud,
			String sql) {

		if (fechaSolicitud != null && !fechaSolicitud.equals("") && estatus.equals("") && contrato.equals("")
				&& numeroCliente.equals("")) {

			sql = "SELECT p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, p.AUTORIZADORES, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + "ORDER BY p.FECHA_SOLIC ASC";

		}

		if (contrato != null && !contrato.equals("") && estatus.equals("") && numeroCliente.equals("")
				&& fechaSolicitud.equals("")) {

			sql = "SELECT p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, p.AUTORIZADORES, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p " + "WHERE  p.CONTRATO = '" + contrato
					+ "' " + "ORDER BY p.FECHA_SOLIC ASC";
		}

		if (numeroCliente != null && !numeroCliente.equals("") && estatus.equals("") && contrato.equals("")
				&& fechaSolicitud.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p " + "WHERE p.NUM_CTE = '" + numeroCliente
					+ "'" + "ORDER BY p.FECHA_SOLIC ASC";

		}

		if (estatus != null && !estatus.equals("") && contrato.equals("") && numeroCliente.equals("")
				&& fechaSolicitud.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p " + "WHERE  p.ESTATUS = '" + estatus
					+ "'" + "ORDER BY p.FECHA_SOLIC ASC";
		}

		if (fechaSolicitud != null && !fechaSolicitud.equals("") && !estatus.equals("") && contrato.equals("")
				&& numeroCliente.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + " AND p.ESTATUS = '" + estatus + "' ORDER BY p.FECHA_SOLIC ASC";
		}

		if (fechaSolicitud != null && !fechaSolicitud.equals("") && !estatus.equals("") && !contrato.equals("")
				&& numeroCliente.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + " AND p.CONTRATO = '" + contrato + "' AND p.ESTATUS = '" + estatus
					+ "' ORDER BY p.FECHA_SOLIC ASC";
		}

		if (fechaSolicitud != null && !fechaSolicitud.equals("") && estatus.equals("") && !contrato.equals("")
				&& numeroCliente.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + "AND p.CONTRATO = '" + contrato + "' ORDER BY p.FECHA_SOLIC ASC";
		}

		if (fechaSolicitud != null && !fechaSolicitud.equals("") && !estatus.equals("") && contrato.equals("")
				&& numeroCliente.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + "AND p.ESTATUS = '" + estatus + "' ORDER BY p.FECHA_SOLIC ASC";

		}

		if (fechaSolicitud != null && !fechaSolicitud.equals("") && !estatus.equals("") && !contrato.equals("")
				&& !numeroCliente.equals("")) {

			sql = "SELECT  p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + " AND p.NUM_CTE = '" + numeroCliente + "' AND p.CONTRATO = '" + contrato
					+ "' AND p.ESTATUS = '" + estatus + "' ORDER BY p.FECHA_SOLIC ASC";

		}

		if (estatus != null && !estatus.equals("") && !contrato.equals("") && !numeroCliente.equals("")
				&& fechaSolicitud.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p " + "WHERE  p.ESTATUS = '" + estatus
					+ "' AND p.CONTRATO = '" + contrato + "' AND p.NUM_CTE = '" + numeroCliente + "' "
					+ "ORDER BY p.FECHA_SOLIC ASC";

		}

		if (estatus != null && !estatus.equals("") && !contrato.equals("") && numeroCliente.equals("")
				&& fechaSolicitud.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p " + "WHERE  p.ESTATUS = '" + estatus
					+ "' AND p.CONTRATO = '" + contrato + "'" + "ORDER BY p.FECHA_SOLIC ASC";

		}

		if (contrato != null && !contrato.equals("") && estatus.equals("") && !numeroCliente.equals("")
				&& fechaSolicitud.equals("")) {

			sql = "SELECT  p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p " + "WHERE p.CONTRATO = '" + contrato
					+ "' AND p.NUM_CTE = '" + numeroCliente + "' " + "ORDER BY p.FECHA_SOLIC ASC";
		}

		if (contrato != null && !contrato.equals("") && !estatus.equals("") && !numeroCliente.equals("")
				&& fechaSolicitud.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p " + "WHERE  p.ESTATUS = '" + estatus
					+ "' AND p.CONTRATO = '" + contrato + "' AND p.NUM_CTE = '" + numeroCliente + "' "
					+ "ORDER BY p.FECHA_SOLIC ASC";

		}

		if (numeroCliente != null && !numeroCliente.equals("") && !estatus.equals("") && contrato.equals("")
				&& fechaSolicitud.equals("")) {

			sql = "SELECT p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p " + "WHERE  p.ESTATUS = '" + estatus
					+ "' AND p.NUM_CTE = '" + numeroCliente + "' " + "ORDER BY p.FECHA_SOLIC ASC";

		}

		if (fechaSolicitud != null && !fechaSolicitud.equals("") && estatus.equals("") && contrato.equals("")
				&& !numeroCliente.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + " AND p.NUM_CTE = '" + numeroCliente + "'" + " ORDER BY p.FECHA_SOLIC ASC";

		}

		if (contrato != null && !contrato.equals("") && estatus.equals("") && !fechaSolicitud.equals("")
				&& !numeroCliente.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + " AND p.NUM_CTE = '" + numeroCliente + "'  AND p.CONTRATO = '" + contrato
					+ "'" + " ORDER BY p.FECHA_SOLIC ASC";

		}

		if (contrato.equals("") && !estatus.equals("") && !fechaSolicitud.equals("") && !numeroCliente.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + " AND p.NUM_CTE = '" + numeroCliente + "'  AND p.ESTATUS = '" + estatus + "'"
					+ " ORDER BY p.FECHA_SOLIC ASC";
		}

		if (estatus.equals("") && estatus != null) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p " + "WHERE  p.ESTATUS = '" + estatus
					+ "'" + " ORDER BY p.FECHA_SOLIC ASC";
		}

		if (estatus.equals("TODAS")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p " + " ORDER BY p.FECHA_SOLIC ASC";
		}

		if (estatus.equals("TODAS") && fechaSolicitud != null && !fechaSolicitud.equals("") && contrato.equals("")
				&& numeroCliente.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + "ORDER BY p.FECHA_SOLIC ASC";

		}

		if (fechaSolicitud != null && !fechaSolicitud.equals("") && contrato.equals("") && numeroCliente.equals("")
				&& estatus.equals("")) {

			sql = "SELECT p.AUTORIZADORES, p.ID_TASAUTO, p.SOEID_ASIG, p.ESTATUS, p.FECHA_SOLIC, p.OFERTA_ID, p.ID_CAMPANA, "
					+ "p.CONTRATO, p.NUM_CTE, p.NOM_CTE, (p.SUC || ' - ' || p.DIVISION) AS SUC, p.PLAZO, "
					+ "p.MONTO, p.TASA_AUTORI, p.FECHA_AUTORI, p.INIC_AUTORI, p.FECHA_ESTATUS, "
					+ "p.NUM_AUTORI_UEC, p.OBSERVA_WEB FROM UEC_TB_AUTOTASAS p "
					+ "WHERE to_date(to_char(p.FECHA_SOLIC, 'YYYY-MM-DD'),'YYYY-MM-DD') = TO_DATE('" + fechaSolicitud
					+ "','YYYY-MM-DD') " + "ORDER BY p.FECHA_SOLIC ASC";

		}

		LOGGER.info("class:: TasaAutoRepository - Method ::createParameterToSql - SQL" + " " + sql.toString());

		return sql;
	}


	@Transactional
	public List<CargaCeteDTO> getCargaCeteDTO() {

		String sql = "SELECT id_Rango, RangoMin || ' - ' || RangoMax as periodo, MILL_DOSMILLQUIN, FECHA, FECHAFIN FROM UEC_TB_AUTORANGOS";

		LOGGER.info("class:: TasaAutoRepository - Method ::getCargaCeteDTO - SQL" + " " + sql.toString());

		return jdbcTemplate.query(sql, (cc, rowNum) -> new CargaCeteDTO(cc.getLong("id_Rango"), cc.getString("periodo"),
				cc.getString("MILL_DOSMILLQUIN"), cc.getString("FECHA"), cc.getString("FECHAFIN")));
	}


	@Transactional
	public List<EditarTasaAutoDTO> getInBuscarEditar(Long idAutoTasa) {
		String sql = "SELECT p.SOEID_ASIG, p.SUC || ' - ' || p.SUC_SOLIC AS SUC, p.NOMINA, p.NOMEJEC, p.NUM_CTE, p.ESTATUS_CLIENTE, p.NOM_CTE, CONTRATO, "
				+ "p.OFERTA_ID, p.ID_CAMPANA, p.MONTO, p.PLAZO, p.PORCEN_CETE, p.TASA_AUTORI, p.CETE, p.AUTORIZADORES, p.OBSERVA_WEB "
				+ "FROM UEC_TB_AUTOTASAS p WHERE p.ID_TASAUTO = '" + idAutoTasa + "'";

		LOGGER.info("class:: TasaAutoRepository - Method ::getInBuscarEditar - SQL" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new EditarTasaAutoDTO(cc.getString("SOEID_ASIG"), cc.getString("SUC"),
						cc.getString("NOMINA"), cc.getString("NOMEJEC"), cc.getString("NUM_CTE"),
						cc.getString("ESTATUS_CLIENTE"), cc.getString("NOM_CTE"), cc.getString("CONTRATO"),
						cc.getString("OFERTA_ID"), cc.getString("ID_CAMPANA"), cc.getString("MONTO"),
						cc.getString("PLAZO"), cc.getString("PORCEN_CETE"), cc.getString("TASA_AUTORI"),
						cc.getString("CETE"), cc.getString("AUTORIZADORES"), cc.getString("OBSERVA_WEB")));

	}

	// MODIFICAR IN RECHAZAR CLICK
	@Transactional
	public void updateInkRechazar(String soeidOpe, String justificacion, String observaWeb, String idTasaAuto,
			String fechaSolicitud) {

		String query = "UPDATE UEC_TB_AUTOTASAS SET SOEID_OPE ='" + soeidOpe
				+ "', ESTATUS ='RECHAZADA', JUSTIFICACION = '" + justificacion + "'," + "	OBSERVA_WEB = '"
				+ observaWeb + "', FECHA_SOLIC = TO_DATE('" + fechaSolicitud
				+ "', 'YYYY-MM-DD') WHERE ESTATUS != 'RECHAZA' AND ID_TASAUTO = '" + idTasaAuto + "' ";

		LOGGER.info("class:: TasaAutoRepository - Method ::updateInkRechazar - SQL" + " " + query.toString());

		jdbcTemplate.execute(query);

	}

	// MODIFICAR IN RECHAZAR CANCELAR CLICK
	@Transactional
	public void updateInkRechazarCancelar(String soeidOpe, String fechaEstatus, String justificacion,
			String observacionWeb, String numAutoriEUC, String estatus, String idTasaAuto) {
		String query = "UPDATE UEC_TB_AUTOTASAS SET SOEID_OPE ='" + soeidOpe + "', FECHA_ESTATUS = TO_DATE('"
				+ fechaEstatus + "', 'YYYY-MM-DD'), ESTATUS = '" + estatus + "'"
				+ "WHERE ESTATUS = 'SOLIC_CANCEL' AND ID_TASAUTO = '" + idTasaAuto
				+ "' AND OBSERVA_WEB IS NOT NULL AND AUTORIZADORES IS NOT NULL";

		LOGGER.info("class:: TasaAutoRepository - Method ::updateInkRechazarCancelar - SQL" + " " + query.toString());

		jdbcTemplate.execute(query);
	}

	// MODIFICAR IN CANCELAR CLICK
	@Transactional
	public void updateInkCancelar(String soeidOpe, String estatus, String justificacion, String observacionWeb,
			String numAutoriEUC, String idTasaAuto) {

		/*
		 * String query =
		 * "UPDATE UEC_TB_AUTOTASAS SET SOEID_OPE ='"+soeidOpe+"', NUM_AUTORI_UEC ='"
		 * +numAutoriEUC+"', OBSERVA_WEB ='"+observacionWeb+"', JUSTIFICACION ='"
		 * +justificacion+"', FECHA_ESTATUS = TO_DATE(SYSDATE, 'YYYY-MM-DD'), ESTATUS = '"
		 * +estatus+"' " + "WHERE ID_TASAUTO = '"+idTasaAuto+"'";
		 * 
		 * LOGGER.info("QUERY updateInkCancelar -  "+ "   " + query.toString() );
		 * 
		 * jdbcTemplate.execute(query);
		 */

		Optional<AutoTasas> solicitud = Optional.ofNullable(new AutoTasas());

		solicitud = autoTasasRepository.findById(Long.valueOf(idTasaAuto));
		AutoTasas actSolicitud = new AutoTasas();

		if (solicitud.isPresent()) {

			LOGGER.info("Id AutoTasas Encontrado" + " " + solicitud.get().getIdTasaAuto());

			if (!soeidOpe.equals("")) {
				LOGGER.info("Valor a modificar " + " " + solicitud.get().getSoeidAsig());
				solicitud.get().setSoeidOpe(soeidOpe);
			}
			if (!estatus.equals("")) {
				LOGGER.info("Valor a modificar" + " " + solicitud.get().getEstatus());
				solicitud.get().setEstatus(estatus);
			}
			if (!justificacion.equals("")) {
				LOGGER.info("Valor a modificar" + " " + solicitud.get().getJustificacion());
				solicitud.get().setJustificacion(justificacion);
			}
			if (!observacionWeb.equals("")) {
				LOGGER.info("Valor a modificar" + " " + solicitud.get().getObservaWeb());
				solicitud.get().setObservaWeb(observacionWeb);
			}
			if (!numAutoriEUC.equals("")) {
				LOGGER.info("Valor a modificar" + " " + solicitud.get().getNumAutoriEuc());
				solicitud.get().setNumAutoriEuc(Long.valueOf(numAutoriEUC));
			}

			/**
			 * La fecha estatus, se coloca la fecha en que se libera
			 */
			Timestamp fechaEstatus = new Timestamp(System.currentTimeMillis());
			solicitud.get().setFechaEstatus(fechaEstatus);

			/**
			 * También se tiene que actualizar la fecha de liberación 
			 */
			if(estatus.equals("LIBERADA")) {
				
			}
			
			
			actSolicitud = solicitud.get();

			try {
				tasasService.complementarSolicitudKPI(actSolicitud);
				LOGGER.info("Solicitud Actualizada con Exito " + " " + "updateInkCancelar");
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	
	@Transactional
	public void insertChkRecibir(String soeid, String online, String nombre, String action) {
		String query = "INSERT INTO UEC_TB_ASIGNACIONES (SOEID, ONLINE_, NOMBRE) VALUES ('" + soeid + "','" + online
				+ "','" + nombre + "')";

		LOGGER.info("class:: TasaAutoRepository - Method ::insertChkRecibir - SQL" + " " + query.toString());

		jdbcTemplate.execute(query);

		String query1 = "INSERT INTO UEC_TB_LOG_CONNECT (SOEID, ACCION, FECHA) VALUES ('" + soeid + "','" + action
				+ "',TO_DATE(SYSDATE, 'DD/MM/YY'))";

		LOGGER.info("class:: TasaAutoRepository - Method ::insertChkRecibir - SQL" + " " + query.toString());

		jdbcTemplate.execute(query1);

	}

	@Transactional
	public List<ResendMailDTO> getCargaResendMail() {

		String sql = "SELECT '' AS COMANDO, p.ESTATUS, p.FECHA_SOLIC, p.CONTRATO, p.NUM_CTE, "
				+ "p.NOM_CTE, p.NOMINA, p.NOMEJEC, p.SUC, p.PLAZO, p.MONTO,  "
				+ "P.TASA_AUTORI, p.AUTORIZADORES,p.TIPO_AUTORI FROM UEC_TB_AUTOTASAS p WHERE p.ESTATUS = 'SOLICITADA' AND "
				+ "TO_DATE(to_char(p.FECHA_SOLIC, 'MM/DD/YY'),'MM/DD/YY') = TO_DATE(to_char(SYSDATE, 'MM/DD/YY'),'MM/DD/YY')";

		LOGGER.info("class:: TasaAutoRepository - Method ::getCargaResendMail - SQL" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new ResendMailDTO(cc.getString("COMANDO"), cc.getString("ESTATUS"),
						cc.getString("FECHA_SOLIC"), cc.getString("CONTRATO"), cc.getString("NUM_CTE"),
						cc.getString("NOM_CTE"), cc.getString("NOMINA"), cc.getString("NOMEJEC"), cc.getString("SUC"),
						cc.getString("PLAZO"), cc.getString("MONTO"), cc.getString("TASA_AUTORI"),
						cc.getString("AUTORIZADORES"), cc.getString("TIPO_AUTORI")));

	}

	@Transactional
	public List<AutoTasasEmailDTO> obtenerRegistrosSinAutorizacion() {

		String sql = "select tas.ID_TASAUTO,tas.SUC_SOLIC, tas.estatus, tas.fecha_solic,tas.tipo_autori, tas.contrato, tas.num_cte,"
				+ "tas.nomina, tas.nomejec, tas.nom_cte, tas.plazo, tas.monto, tas.tasa_autori,"
				+ "concat(concat(concat(sucu.SIRH_SUCURSAL_ID,' - '),concat(sucu.NOMBRE_SUCURSAL,' - ')),sucu.DISTRITO_NOMBRE) as suc, "
				+ "is_portabilidad as foliobancanet from uec_tb_autotasas tas "
				+ "inner join uec_tb_autorizadores_elegidos eleg on tas.ID_TASAUTO= eleg.ID_TASAAUTO "
				+ "left join per_cat_sucursales sucu on tas.suc_solic=sucu.SIRH_SUCURSAL_ID WHERE "
				+ "TRUNC(tas.fecha_solic) = TO_DATE(to_char(SYSDATE, 'MM/DD/YY'),'MM/DD/YY') AND ESTATUS like 'SOLICITADA'";

		LOGGER.info(
				"class:: TasaAutoRepository - Method ::ObtenerRegistrosSinAutorizacion - SQL" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new AutoTasasEmailDTO(cc.getLong("ID_TASAUTO"), cc.getLong("SUC_SOLIC"),
						cc.getTimestamp("fecha_solic"), cc.getString("suc"), cc.getString("estatus"),
						cc.getString("tipo_autori"), cc.getString("contrato"), cc.getLong("num_cte"),
						cc.getString("nomina"), cc.getString("nomejec"), cc.getString("nom_cte"), cc.getLong("monto"),
						cc.getLong("plazo"), cc.getDouble("tasa_autori"), cc.getString("foliobancanet")));

	}

	@Transactional
	public AutorizadorElegidoDTO obtenerAutorizador(Long idAutoTasa) {

		List<String> listaCadena = new ArrayList<>();
		List<AutoAutorizadorDTO> lsAutorizadores = new ArrayList<>();
		List<AutoAutorizadorDTO> lsAutoAutorizador = new ArrayList<>();

		String sql = "SELECT id_tasaauto, autorizadores " + "FROM uec_tb_autorizadores_elegidos Where id_tasaAuto = '"
				+ idAutoTasa + "'";

		LOGGER.info("class:: TasaAutoRepository - Method ::obtenerAutorizador - SQL" + " " + sql.toString());

		AutorizadorElegidoDTO autorizadorElegidoDTO = jdbcTemplate.queryForObject(sql,
				(cc, rowNum) -> new AutorizadorElegidoDTO(cc.getLong("id_tasaauto"), cc.getString("autorizadores")));

		String[] str = autorizadorElegidoDTO.getAutorizadores().split("\\|");
		listaCadena = Arrays.asList(str);

		for (String soeid : listaCadena) {

			LOGGER.info("class:: TasaAutoRepository - Method ::obtenerAutorizador - SQL" + " " + sql.toString());

			lsAutoAutorizador = obtenerAutorizadoresDivisionales(soeid, "");
			lsAutorizadores.addAll(lsAutoAutorizador);
		}

		autorizadorElegidoDTO.setLsAutorizadores(lsAutorizadores);

		for (AutoAutorizadorDTO autori : autorizadorElegidoDTO.getLsAutorizadores()) {

			LOGGER.info("class:: TasaAutoRepository - Method ::obtenerAutorizador - Autorizadores" + " "
					+ autori.getNombre());
			LOGGER.info("class:: TasaAutoRepository - Method ::obtenerAutorizador - Autorizadores" + " "
					+ autori.getDvision());
		}

		return autorizadorElegidoDTO;

	}

	@Transactional
	public List<AutoAutorizadorDTO> obtenerAutorizadoresDivisionales(String soeid, String division) {

		String sql = "select SOEID,SOEID_DIVISIONAL,SOEID_DISTRITAL,DIVISION,"
				+ " DISTRISTO,NOMBRE,INIC,FECHA_INICIO,FECHA_TERMINO,ALTA,CORREO,IS_CETE100,IS_CAMPESP,ID_NIVEL_AUTO "
				+ "from UEC_CATALOGO_AUTORIZADORES2021   where soeid like '" + soeid + "'";

		LOGGER.info(
				"class:: TasaAutoRepository - Method ::ObtenerAutorizadoresDivisionales - SQL" + " " + sql.toString());

		if (division != null) {
			sql.concat(" and division like '" + division + "'");
		}

		LOGGER.info(
				"class:: TasaAutoRepository - Method ::ObtenerAutorizadoresDivisionales - SQL" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new AutoAutorizadorDTO(cc.getString("SOEID"), cc.getString("SOEID_DIVISIONAL"),
						cc.getString("SOEID_DISTRITAL"), cc.getString("DIVISION"), cc.getString("DISTRISTO"),
						cc.getString("NOMBRE"), cc.getString("INIC"), cc.getDate("FECHA_INICIO"),
						cc.getDate("FECHA_TERMINO"), cc.getLong("ALTA"), cc.getString("CORREO"),
						cc.getLong("IS_CETE100"), cc.getLong("IS_CAMPESP"), cc.getLong("ID_NIVEL_AUTO")));
	}

	@Transactional
	public List<EmailTasaEspecialDTO> getEmailTasaEspecial() {

		String sql = "SELECT a.ID_TASAUTO, a.SIRH  || ' ' || a.SUCURSAL as SUCURSAL, NOM_CTE, NUM_CTE, CONTRATO, MONTO, PLAZO, TASA_AUTORI, JUSTIFICACION, NOMEJEC "
				+ "FROM UEC_TB_AUTOTASAS p, UEC_CAT_SUC2021 a WHERE p.SUC_SOLIC = a.SIRH";

		LOGGER.info("class:: TasaAutoRepository - Method ::getEmailTasaEspecial - SQL" + " " + sql.toString());

		return jdbcTemplate.query(sql,
				(cc, rowNum) -> new EmailTasaEspecialDTO(cc.getString("ID_TASAUTO"), cc.getString("SUCURSAL"),
						cc.getString("NOM_CTE"), cc.getString("NUM_CTE"), cc.getString("CONTRATO"),
						cc.getString("MONTO"), cc.getString("PLAZO"), cc.getString("TASA_AUTORI"),
						cc.getString("JUSTIFICACION"), cc.getString("NOMEJEC")));

	}

	/**
	 * Actualiza el SOEID Operador y la fecha process buscando por IDAutoTasa
	 * 
	 * @param soeidOpe
	 * @param estatus
	 * @param justificacion
	 * @param observacionWeb
	 * @param numAutoriEUC
	 * @param idTasaAuto
	 */
	@Transactional
	public MensajeDTO actualizaSolicitud(String soeidOpe, String idTasaAuto) {

		MensajeDTO mensaje = new MensajeDTO();

		Optional<AutoTasas> solicitud = Optional.ofNullable(new AutoTasas());

		solicitud = autoTasasRepository.findById(Long.valueOf(idTasaAuto));
		AutoTasas actSolicitud = new AutoTasas();

		if (solicitud.isPresent()) {

			LOGGER.info("Id AutoTasas Encontrado" + " " + solicitud.get().getIdTasaAuto());

			if (solicitud.get().getSoeidOpe() == null && solicitud.get().getFechaProcess() == null) {

				if (!soeidOpe.equals("")) {
					LOGGER.info("Valor a modificar " + " " + solicitud.get().getSoeidOpe());
					solicitud.get().setSoeidOpe(soeidOpe);

					/**
					 * La fecha estatus, se coloca la fecha en que se tomo la solicitud
					 */
					Timestamp fechaProceso = new Timestamp(System.currentTimeMillis());
					solicitud.get().setFechaProcess(fechaProceso);

					actSolicitud = solicitud.get();

					try {
						tasasService.complementarSolicitudKPI(actSolicitud);
						mensaje.setMensajeInfo("Información Actualización registro");
						mensaje.setMensajeConfirm("Se actualiza la información Satisfactoriamente.");
						LOGGER.info("Solicitud Actualizada con Exito " + " " + "actualizaSolicitud");
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}
				}
			} else {

				Timestamp oldTime = (Timestamp) solicitud.get().getFechaProcess();

				Timestamp currentTime = new Timestamp(System.currentTimeMillis());

				long dif = compareTwoTimeStamps(currentTime, oldTime);

				if (dif < 3) {
					LOGGER.info("NO SE PUEDE TOMAR LA SOLICITUD PORQUE ESTA ASIGNADA AL OPERADOR" + " "
							+ solicitud.get().getSoeidOpe() + "Y EL TIEMPO TRANSCURRIDO ES " + " " + dif);

					mensaje.setMensajeInfo("NO SE PUEDE TOMAR LA SOLICITUD PORQUE ESTA ASIGNADA AL OPERADOR" + " "
							+ solicitud.get().getSoeidOpe() + " " + "Y EL TIEMPO TRANSCURRIDO ES DE  " + " " + dif + "  "  + "MINUTO(S)"+ ","+
							"PASADOS 3 MINUTOS SE PUEDE TOMAR LA SOLICITUD");
					mensaje.setMensajeConfirm("Informacion no actualizada");
				} else {

					solicitud.get().setSoeidOpe(soeidOpe);
					Timestamp fechaProceso = new Timestamp(System.currentTimeMillis());
					solicitud.get().setFechaProcess(fechaProceso);

					actSolicitud = solicitud.get();

					try {
						tasasService.complementarSolicitudKPI(actSolicitud);
						mensaje.setMensajeInfo("Información Actualización registro");
						mensaje.setMensajeConfirm("Se actualiza la información Satisfactoriamente.");
						LOGGER.info("Solicitud Actualizada con Exito " + " " + "actualizaSolicitud");
					} catch (Exception e) {
						LOGGER.error(e.getMessage());
					}
				}
			}

		}

		return mensaje;
	}

	public static long compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime) {
		long milliseconds1 = oldTime.getTime();
		long milliseconds2 = currentTime.getTime();

		long diff = milliseconds2 - milliseconds1;
		long diffSeconds = diff / 1000;
		long diffMinutes = diff / (60 * 1000);
		long diffHours = diff / (60 * 60 * 1000);
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffMinutes;
	}

}
