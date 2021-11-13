package com.citi.euces.sitiouec.entities;





//@Entity
//@Table(name = "UEC_TB_AUTOTASAS")
public class AutoTasaGerencia   {


//	@Id
  //  @Column(name ="DIVISION")
	private String DIVISION;
//    @Column(name ="VENTAS")
	private double VENTAS;
    //@Column(name ="MONTO")
	private double MONTO;
    //@Column(name ="MONTOVENTAS")
	private double MONTOVENTAS;
	//@Column(name ="DISTRITO" )
	private String DISTRITO;
	/**
	 * 
	 */
	public AutoTasaGerencia() {
		super();
	}
	
	public String getDIVISION() {
		return DIVISION;
	}
	/**
	 * @param dIVISION
	 * @param vENTAS
	 * @param mONTO
	 * @param mONTOVENTAS
	 * @param dISTRITO
	 */
	public AutoTasaGerencia(String DIVISION, double VENTAS, double MONTO, double MONTOVENTAS, String DISTRITO) {
		super();
		this.DIVISION = DIVISION;
		this.VENTAS = VENTAS;
		this.MONTO = MONTO;
		this.MONTOVENTAS = MONTOVENTAS;
		this.DISTRITO = DISTRITO;
	}
	public void setDIVISION(String dIVISION) {
		DIVISION = dIVISION;
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

	@Override
	public String toString() {
		return "AutoTasaGerencia [DIVISION=" + DIVISION + ", VENTAS=" + VENTAS + ", MONTO=" + MONTO + ", MONTOVENTAS="
				+ MONTOVENTAS + ", DISTRITO=" + DISTRITO + "]";
	}
	
	
	
	
	
}
