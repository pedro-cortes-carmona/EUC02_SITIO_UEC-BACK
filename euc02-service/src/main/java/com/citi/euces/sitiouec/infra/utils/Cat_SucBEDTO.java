package com.citi.euces.sitiouec.infra.utils;

import java.io.Serializable;

public class Cat_SucBEDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long NUMSUC;
    public String SUCURSAL;

    public String coddiv;
    public String DIVISION;

    public String coddist;
    public String distrito;

    public String EJECUTIVOS;
    public String EJEC_PRIORITY;

    public String IS_CLOSED;

    public int is_encontrado;

	/**
	 * 
	 */
	public Cat_SucBEDTO() {
	}

	/**
	 * @param nUMSUC
	 * @param sUCURSAL
	 * @param coddiv
	 * @param dIVISION
	 * @param coddist
	 * @param distrito
	 * @param eJECUTIVOS
	 * @param eJEC_PRIORITY
	 * @param iS_CLOSED
	 */
	public Cat_SucBEDTO(Long nUMSUC, String sUCURSAL, String coddiv, String dIVISION, String coddist, String distrito,
			String eJECUTIVOS, String eJEC_PRIORITY, String iS_CLOSED) {
		super();
		NUMSUC = nUMSUC;
		SUCURSAL = sUCURSAL;
		this.coddiv = coddiv;
		DIVISION = dIVISION;
		this.coddist = coddist;
		this.distrito = distrito;
		EJECUTIVOS = eJECUTIVOS;
		EJEC_PRIORITY = eJEC_PRIORITY;
		IS_CLOSED = iS_CLOSED;
	}

	/**
	 * @return the nUMSUC
	 */
	public Long getNUMSUC() {
		return NUMSUC;
	}

	/**
	 * @param nUMSUC the nUMSUC to set
	 */
	public void setNUMSUC(Long nUMSUC) {
		NUMSUC = nUMSUC;
	}

	/**
	 * @return the sUCURSAL
	 */
	public String getSUCURSAL() {
		return SUCURSAL;
	}

	/**
	 * @param sUCURSAL the sUCURSAL to set
	 */
	public void setSUCURSAL(String sUCURSAL) {
		SUCURSAL = sUCURSAL;
	}

	/**
	 * @return the coddiv
	 */
	public String getCoddiv() {
		return coddiv;
	}

	/**
	 * @param coddiv the coddiv to set
	 */
	public void setCoddiv(String coddiv) {
		this.coddiv = coddiv;
	}

	/**
	 * @return the dIVISION
	 */
	public String getDIVISION() {
		return DIVISION;
	}

	/**
	 * @param dIVISION the dIVISION to set
	 */
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
	}

	/**
	 * @return the coddist
	 */
	public String getCoddist() {
		return coddist;
	}

	/**
	 * @param coddist the coddist to set
	 */
	public void setCoddist(String coddist) {
		this.coddist = coddist;
	}

	/**
	 * @return the distrito
	 */
	public String getDistrito() {
		return distrito;
	}

	/**
	 * @param distrito the distrito to set
	 */
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	/**
	 * @return the eJECUTIVOS
	 */
	public String getEJECUTIVOS() {
		return EJECUTIVOS;
	}

	/**
	 * @param eJECUTIVOS the eJECUTIVOS to set
	 */
	public void setEJECUTIVOS(String eJECUTIVOS) {
		EJECUTIVOS = eJECUTIVOS;
	}

	/**
	 * @return the eJEC_PRIORITY
	 */
	public String getEJEC_PRIORITY() {
		return EJEC_PRIORITY;
	}

	/**
	 * @param eJEC_PRIORITY the eJEC_PRIORITY to set
	 */
	public void setEJEC_PRIORITY(String eJEC_PRIORITY) {
		EJEC_PRIORITY = eJEC_PRIORITY;
	}

	/**
	 * @return the iS_CLOSED
	 */
	public String getIS_CLOSED() {
		return IS_CLOSED;
	}

	/**
	 * @param iS_CLOSED the iS_CLOSED to set
	 */
	public void setIS_CLOSED(String iS_CLOSED) {
		IS_CLOSED = iS_CLOSED;
	}

	/**
	 * @return the is_encontrado
	 */
	public int getIs_encontrado() {
		return is_encontrado;
	}

	/**
	 * @param is_encontrado the is_encontrado to set
	 */
	public void setIs_encontrado(int is_encontrado) {
		this.is_encontrado = is_encontrado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cat_SucBEDTO [NUMSUC=");
		builder.append(NUMSUC);
		builder.append(", SUCURSAL=");
		builder.append(SUCURSAL);
		builder.append(", coddiv=");
		builder.append(coddiv);
		builder.append(", DIVISION=");
		builder.append(DIVISION);
		builder.append(", coddist=");
		builder.append(coddist);
		builder.append(", distrito=");
		builder.append(distrito);
		builder.append(", EJECUTIVOS=");
		builder.append(EJECUTIVOS);
		builder.append(", EJEC_PRIORITY=");
		builder.append(EJEC_PRIORITY);
		builder.append(", IS_CLOSED=");
		builder.append(IS_CLOSED);
		builder.append(", is_encontrado=");
		builder.append(is_encontrado);
		builder.append("]");
		return builder.toString();
	}
    
    
}
