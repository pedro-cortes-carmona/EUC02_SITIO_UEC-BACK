package com.citi.euces.sitiouec.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_ACUMULADO_CAMP")
public class EjecutivosNoLocalizablesGerencia {
	
	@Id
    @Column(name ="NOMINA")
	private BigInteger NOMINA;
    @Column(name ="NOMBRE")
	private String NOMBRE;
    @Column(name ="SUC")
	private String SUC;
    @Column(name ="MONTOVENTAS")
	private BigInteger MONTOVENTAS;
    @Column(name ="NUMVENTAS")
	private BigInteger NUMVENTAS;
	/**
	 * 
	 */
	public EjecutivosNoLocalizablesGerencia() {
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
	public String getSUC() {
		return SUC;
	}
	public void setSUC(String sUC) {
		SUC = sUC;
	}
	public BigInteger getMONTOVENTAS() {
		return MONTOVENTAS;
	}
	public void setMONTOVENTAS(BigInteger mONTOVENTAS) {
		MONTOVENTAS = mONTOVENTAS;
	}
	public BigInteger getNUMVENTAS() {
		return NUMVENTAS;
	}
	public void setNUMVENTAS(BigInteger nUMVENTAS) {
		NUMVENTAS = nUMVENTAS;
	}
    
    

}
