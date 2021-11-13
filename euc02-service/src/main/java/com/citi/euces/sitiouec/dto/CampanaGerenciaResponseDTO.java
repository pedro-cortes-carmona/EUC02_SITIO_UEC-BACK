package com.citi.euces.sitiouec.dto;

import java.math.BigInteger;
import java.util.List;

public class CampanaGerenciaResponseDTO {
	
	
	private BigInteger NOMINA;
	private String NOMBRE;
	private Long SUC;
	private String DIVISION;
	private String DIRECCION;
	private String SOIED;
	private String PRIO_VENTAS;
	private String SUB_TOTAL;
	private String SUB_IMPORTE;
	private BigInteger CEDE_VENTAS;
	private BigInteger CEDE_IMPORTE;
	private BigInteger CAMP_VENTAS;
	private BigInteger CAMP_IMPORTE;
	private String PUESTO;
	private BigInteger PORTAESP_VENTAS;
	private BigInteger PORTAESP_IMPORTE;
	private List<CampanaDiasGerenciaResponseDTO> listaFecha;
	/**
	 * 
	 */
	public CampanaGerenciaResponseDTO() {
		super();
	}
	/**
	 * @param nOMINA
	 * @param nOMBRE
	 * @param sUC
	 * @param dIVISION
	 * @param dIRECCION
	 * @param sOIED
	 * @param pRIO_VENTAS
	 * @param sUB_TOTAL
	 * @param sUB_IMPORTE
	 * @param cEDE_VENTAS
	 * @param cEDE_IMPORTE
	 * @param cAMP_VENTAS
	 * @param cAMP_IMPORTE
	 * @param pUESTO
	 * @param pORTAESP_VENTAS
	 * @param pORTAESP_IMPORTE
	 * @param listaFecha
	 */
	public CampanaGerenciaResponseDTO(BigInteger nOMINA, String nOMBRE, Long sUC, String dIVISION, String dIRECCION,
			String sOIED, String pRIO_VENTAS, String sUB_TOTAL, String sUB_IMPORTE, BigInteger cEDE_VENTAS,
			BigInteger cEDE_IMPORTE, BigInteger cAMP_VENTAS, BigInteger cAMP_IMPORTE, String pUESTO,
			BigInteger pORTAESP_VENTAS, BigInteger pORTAESP_IMPORTE, List<CampanaDiasGerenciaResponseDTO> listaFecha) {
		super();
		NOMINA = nOMINA;
		NOMBRE = nOMBRE;
		SUC = sUC;
		DIVISION = dIVISION;
		DIRECCION = dIRECCION;
		SOIED = sOIED;
		PRIO_VENTAS = pRIO_VENTAS;
		SUB_TOTAL = sUB_TOTAL;
		SUB_IMPORTE = sUB_IMPORTE;
		CEDE_VENTAS = cEDE_VENTAS;
		CEDE_IMPORTE = cEDE_IMPORTE;
		CAMP_VENTAS = cAMP_VENTAS;
		CAMP_IMPORTE = cAMP_IMPORTE;
		PUESTO = pUESTO;
		PORTAESP_VENTAS = pORTAESP_VENTAS;
		PORTAESP_IMPORTE = pORTAESP_IMPORTE;
		this.listaFecha = listaFecha;
	}
	public BigInteger getNOMINA() {
		return NOMINA;
	}
	public void setNOMINA(BigInteger nOMINA) {
		NOMINA = nOMINA;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public Long getSUC() {
		return SUC;
	}
	public void setSUC(Long sUC) {
		SUC = sUC;
	}
	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public String getDIRECCION() {
		return DIRECCION;
	}
	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}
	public String getSOIED() {
		return SOIED;
	}
	public void setSOIED(String sOIED) {
		SOIED = sOIED;
	}
	public String getPRIO_VENTAS() {
		return PRIO_VENTAS;
	}
	public void setPRIO_VENTAS(String pRIO_VENTAS) {
		PRIO_VENTAS = pRIO_VENTAS;
	}
	public String getSUB_TOTAL() {
		return SUB_TOTAL;
	}
	public void setSUB_TOTAL(String sUB_TOTAL) {
		SUB_TOTAL = sUB_TOTAL;
	}
	public String getSUB_IMPORTE() {
		return SUB_IMPORTE;
	}
	public void setSUB_IMPORTE(String sUB_IMPORTE) {
		SUB_IMPORTE = sUB_IMPORTE;
	}
	public BigInteger getCEDE_VENTAS() {
		return CEDE_VENTAS;
	}
	public void setCEDE_VENTAS(BigInteger cEDE_VENTAS) {
		CEDE_VENTAS = cEDE_VENTAS;
	}
	public BigInteger getCEDE_IMPORTE() {
		return CEDE_IMPORTE;
	}
	public void setCEDE_IMPORTE(BigInteger cEDE_IMPORTE) {
		CEDE_IMPORTE = cEDE_IMPORTE;
	}
	public BigInteger getCAMP_VENTAS() {
		return CAMP_VENTAS;
	}
	public void setCAMP_VENTAS(BigInteger cAMP_VENTAS) {
		CAMP_VENTAS = cAMP_VENTAS;
	}
	public BigInteger getCAMP_IMPORTE() {
		return CAMP_IMPORTE;
	}
	public void setCAMP_IMPORTE(BigInteger cAMP_IMPORTE) {
		CAMP_IMPORTE = cAMP_IMPORTE;
	}
	public String getPUESTO() {
		return PUESTO;
	}
	public void setPUESTO(String pUESTO) {
		PUESTO = pUESTO;
	}
	public BigInteger getPORTAESP_VENTAS() {
		return PORTAESP_VENTAS;
	}
	public void setPORTAESP_VENTAS(BigInteger pORTAESP_VENTAS) {
		PORTAESP_VENTAS = pORTAESP_VENTAS;
	}
	public BigInteger getPORTAESP_IMPORTE() {
		return PORTAESP_IMPORTE;
	}
	public void setPORTAESP_IMPORTE(BigInteger pORTAESP_IMPORTE) {
		PORTAESP_IMPORTE = pORTAESP_IMPORTE;
	}
	public List<CampanaDiasGerenciaResponseDTO> getListaFecha() {
		return listaFecha;
	}
	public void setListaFecha(List<CampanaDiasGerenciaResponseDTO> listaFecha) {
		this.listaFecha = listaFecha;
	}
	
}
