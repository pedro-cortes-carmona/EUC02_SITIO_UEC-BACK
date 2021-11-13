package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "UEC_TB_AUTOTASAS")
public class AutoTasaSucursalesGerencia {
	
//	@Id
//    @Column(name ="DIVISION")
	private String DIVISION;
	//@Column(name ="SUC_SOLIC")
    private Long SUC_SOLIC;
    //@Column(name ="VENTAS")
	private double VENTAS;
    //@Column(name ="MONTO")
	private double MONTO;
    //@Column(name ="MONTOVENTAS")
	private double MONTOVENTAS;
	//@Column(name ="DISTRITO" )
	private String DISTRITO;
    //@Column(name ="CAPITA")
	private double CAPITA;
	//@Column(name ="EJECUTIVOS" )
	private double EJECUTIVOS;
	/**
	 * 
	 */
	public AutoTasaSucursalesGerencia() {
		super();
	}
	/**
	 * @param dIVISION
	 * @param sUC_SOLIC
	 * @param vENTAS
	 * @param mONTO
	 * @param mONTOVENTAS
	 * @param dISTRITO
	 * @param cAPITA
	 * @param eJECUTIVOS
	 */
	public AutoTasaSucursalesGerencia(String dIVISION, Long sUC_SOLIC, double vENTAS, double mONTO, double mONTOVENTAS,
			String dISTRITO, double cAPITA, double eJECUTIVOS) {
		super();
		DIVISION = dIVISION;
		SUC_SOLIC = sUC_SOLIC;
		VENTAS = vENTAS;
		MONTO = mONTO;
		MONTOVENTAS = mONTOVENTAS;
		DISTRITO = dISTRITO;
		CAPITA = cAPITA;
		EJECUTIVOS = eJECUTIVOS;
	}
	public String getDIVISION() {
		return DIVISION;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}
	public Long getSUC_SOLIC() {
		return SUC_SOLIC;
	}
	public void setSUC_SOLIC(Long sUC_SOLIC) {
		SUC_SOLIC = sUC_SOLIC;
	}
	public double getVENTAS() {
		return VENTAS;
	}
	public void setVENTAS(double vENTAS) {
		VENTAS = vENTAS;
	}
	public double getMONTO() {
		return MONTO;
	}
	public void setMONTO(double mONTO) {
		MONTO = mONTO;
	}
	public double getMONTOVENTAS() {
		return MONTOVENTAS;
	}
	public void setMONTOVENTAS(double mONTOVENTAS) {
		MONTOVENTAS = mONTOVENTAS;
	}
	public String getDISTRITO() {
		return DISTRITO;
	}
	public void setDISTRITO(String dISTRITO) {
		DISTRITO = dISTRITO;
	}
	public double getCAPITA() {
		return CAPITA;
	}
	public void setCAPITA(double cAPITA) {
		CAPITA = cAPITA;
	}
	public double getEJECUTIVOS() {
		return EJECUTIVOS;
	}
	public void setEJECUTIVOS(double eJECUTIVOS) {
		EJECUTIVOS = eJECUTIVOS;
	}
	@Override
	public String toString() {
		return "AutoTasaSucursalesGerencia [DIVISION=" + DIVISION + ", SUC_SOLIC=" + SUC_SOLIC + ", VENTAS=" + VENTAS
				+ ", MONTO=" + MONTO + ", MONTOVENTAS=" + MONTOVENTAS + ", DISTRITO=" + DISTRITO + ", CAPITA=" + CAPITA
				+ ", EJECUTIVOS=" + EJECUTIVOS + "]";
	}
	
	

}
