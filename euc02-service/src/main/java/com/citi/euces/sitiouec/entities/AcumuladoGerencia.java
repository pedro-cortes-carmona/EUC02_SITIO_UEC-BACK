package com.citi.euces.sitiouec.entities;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_ACUMULADO_CAMP")
public class AcumuladoGerencia {

	@Id
    @Column(name ="ID_ACUMULADO")
	private Long ID_ACUMULADO;
	@Column(name ="FECHA_APERTURA")
	private Date FECHA_APERTURA;
	@Column(name ="ESTATUS")
	private Long ESTATUS;
	@Column(name ="CONTRATO")
	private Long CONTRATO;
	@Column(name ="NUM_INVER")
	private Long NUM_INVER;
	@Column(name ="NUM_CTE")
	private BigInteger NUM_CTE;
	@Column(name ="NOM_CTE")
	private String NOM_CTE;
	@Column(name ="PLAZO")
	private String PLAZO;
	@Column(name ="MONTO")
	private Long MONTO;
	@Column(name ="TASA_AUTO")
	private Long TASA_AUTO;
	@Column(name ="HORA_AUTO")
	private String HORA_AUTO;
	@Column(name ="NUM_AUTO_UEC")
	private Long NUM_AUTO_UEC;
	@Column(name ="SUC_SOLIC")
	private Long SUC_SOLIC;
	@Column(name ="DIVISION")
	private String DIVISION;
	@Column(name ="REGION")
	private String REGION;
	@Column(name ="GER_MERCADO")
	private String GER_MERCADO;
	@Column(name ="NOMINA")
	private BigInteger NOMINA;
	@Column(name ="NOM_EJEC")
	private String NOM_EJEC;
	@Column(name ="NOM_CAMP")
	private String NOM_CAMP;
	/**
	 * 
	 */
	public AcumuladoGerencia() {
		super();
	}
	
	
	
	
}
