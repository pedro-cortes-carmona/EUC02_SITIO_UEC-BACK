package com.citi.euces.sitiouec.entities;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_ACUMULADO_CAMP")
public class AcomuladoGerencia {
	
	@Id
	@Column(name = "NOMINA")
	private BigInteger NOMINA;
	@Column(name = "NOMBRE")
	private String NOMBRE;
	@Column(name = "SUC")
	private Long SUC;
	@Column(name = "DIVISION")
	private String DIVISION;
	@Column(name = "DISTRITO")
	private String DISTRITO;
	@Column(name = "SOIED")
	private String SOIED;
	@Column(name = "PRIO_VENTAS")
	private String PRIO_VENTAS;
	@Column(name = "SUB_TOTAL")
	private String SUB_TOTAL;
	@Column(name = "SUB_IMPORTE")
	private String SUB_IMPORTE;
	@Column(name = "CEDE_VENTAS")
	private BigInteger CEDE_VENTAS;
	@Column(name = "CEDE_IMPORTE")
	private BigInteger CEDE_IMPORTE;
	@Column(name = "CAMP_VENTAS")
	private BigInteger CAMP_VENTAS;
	@Column(name = "CAMP_IMPORTE")
	private BigInteger CAMP_IMPORTE;
	@Column(name = "PUESTO")
	private String PUESTO;
	@Column(name = "PORTAESP_VENTAS")
	private BigInteger PORTAESP_VENTAS;
	@Column(name = "PORTAESP_IMPORTE")
	private BigInteger PORTAESP_IMPORTE;
	@Column(name = "FECHA")
    private Date FECHA;
	@Column(name = "NUM_FECHA")
    private String NUM_FECHA;
	/**
	 * 
	 */
	public AcomuladoGerencia() {
		super();
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
	public String getDISTRITO() {
		return DISTRITO;
	}
	public void setDISTRITO(String dISTRITO) {
		DISTRITO = dISTRITO;
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
	public Date getFECHA() {
		return FECHA;
	}
	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}
	public String getNUM_FECHA() {
		return NUM_FECHA;
	}
	public void setNUM_FECHA(String nUM_FECHA) {
		NUM_FECHA = nUM_FECHA;
	}
	
	
	
	
}
