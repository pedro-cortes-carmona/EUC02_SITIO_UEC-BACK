package com.citi.euces.sitiouec.entities;

import java.math.BigInteger;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UEC_CAT_EJECUTIVOS_PRIORITY2021")
public class EjecutivosPriorityVentaGerencia {
	
	@Id
    @Column(name ="DIVISION")
	private String DIVISION;
    @Column(name ="DISTRITO")
	private String DISTRITO;
    @Column(name ="SUC")
    private String SUC;
    @Column(name ="NOMINA")
	private BigInteger NOMINA;
    @Column(name ="NOMBRE")
    private String NOMBRE;
    @Column(name ="FECHA")
    private Date FECHA;
    @Column(name ="SUBTOTAL")
	private BigInteger SUBTOTAL;
    @Column(name ="SUB_IMPORTE")
    private Long SUB_IMPORTE;
    @Column(name ="CAMPANA")
    private String CAMPANA;  //SIRH
	/**
	 * @param dIVISION
	 * @param dISTRITO
	 * @param sUC
	 * @param nOMINA
	 * @param nOMBRE
	 * @param fECHA
	 * @param sUBTOTAL
	 * @param sUB_IMPORTE
	 * @param cAMPANA
	 */
	public EjecutivosPriorityVentaGerencia(String dIVISION, String dISTRITO, String sUC, BigInteger nOMINA,
			String nOMBRE, Date fECHA, BigInteger sUBTOTAL, Long sUB_IMPORTE, String cAMPANA) {
		super();
		DIVISION = dIVISION;
		DISTRITO = dISTRITO;
		SUC = sUC;
		NOMINA = nOMINA;
		NOMBRE = nOMBRE;
		FECHA = fECHA;
		SUBTOTAL = sUBTOTAL;
		SUB_IMPORTE = sUB_IMPORTE;
		CAMPANA = cAMPANA;
	}
	/**
	 * 
	 */
	public EjecutivosPriorityVentaGerencia() {
		super();
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
	public String getSUC() {
		return SUC;
	}
	public void setSUC(String sUC) {
		SUC = sUC;
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
	public Date getFECHA() {
		return FECHA;
	}
	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}
	public BigInteger getSUBTOTAL() {
		return SUBTOTAL;
	}
	public void setSUBTOTAL(BigInteger sUBTOTAL) {
		SUBTOTAL = sUBTOTAL;
	}
	public Long getSUB_IMPORTE() {
		return SUB_IMPORTE;
	}
	public void setSUB_IMPORTE(Long sUB_IMPORTE) {
		SUB_IMPORTE = sUB_IMPORTE;
	}
	public String getCAMPANA() {
		return CAMPANA;
	}
	public void setCAMPANA(String cAMPANA) {
		CAMPANA = cAMPANA;
	}
    
    
    
}
