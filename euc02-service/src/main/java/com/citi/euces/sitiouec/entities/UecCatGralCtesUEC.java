package com.citi.euces.sitiouec.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UEC_CAT_GRAL_CTES")
public class UecCatGralCtesUEC implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "NUM_CTE")
	private Long numCte;
	@Column(name = "CLIENTENTP")
	private Long cliententp;
	@Basic(optional = false)
	@Column(name = "CONTRATO")
	private long contrato;
	@Column(name = "SEGMENTO")
	private String segmento;
	@Column(name = "FISICA_MORAL")
	private String fisicaMoral;
	@Column(name = "IS_PORTABILIDAD")
	private Long isPortabilidad;
	@Column(name = "FECHA_PORTABILIDAD")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPortabilidad;
	@Column(name = "MONTO1")
	private BigInteger monto1;
	@Column(name = "PORCENTAJE1")
	private BigInteger porcentaje1;
	@Column(name = "MONTO2")
	private BigInteger monto2;
	@Column(name = "PORCENTAJE2")
	private BigInteger porcentaje2;
	@Column(name = "MONTO3")
	private BigInteger monto3;
	@Column(name = "PORCENTAJE3")
	private BigInteger porcentaje3;
	@Column(name = "MONTO4")
	private BigInteger monto4;
	@Column(name = "PORCENTAJE4")
	private BigInteger porcentaje4;
	@Column(name = "MONTO5")
	private BigInteger monto5;
	@Column(name = "PORCENTAJE5")
	private BigInteger porcentaje5;
	@Column(name = "CLIENTE_SIN_OFERTA")
	private Short clienteSinOferta;
	@Column(name = "CLIENTE_NUMERO")
	private Long clienteNumero;
	@Column(name = "CLIENTE_TIPO_PERSONA")
	private String clienteTipoPersona;
	@Column(name = "CLIENTE_SEGMENTO")
	private Short clienteSegmento;
	@Column(name = "CLIENTE_MONTO_REFERENCIA")
	private BigInteger clienteMontoReferencia;
	@Column(name = "CLIENTE_NEW_TO_PRODUCT")
	private Short clienteNewToProduct;
	@Column(name = "CLIENTE_NEW_TO_DIGITAL")
	private Short clienteNewToDigital;
	@Column(name = "CLIENTE_FECHA_REFERENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date clienteFechaReferencia;
	@Column(name = "CUENTA_CONTRATO")
	private Long cuentaContrato;
	@Column(name = "CLIENTE_OFERTA_01")
	private Short clienteOferta01;
	@Column(name = "CLIENTE_OFERTA_02")
	private Short clienteOferta02;
	@Column(name = "CLIENTE_OFERTA_03")
	private Short clienteOferta03;
	@Column(name = "CLIENTE_OFERTA_04")
	private Short clienteOferta04;
	@Column(name = "CLIENTE_OFERTA_05")
	private Short clienteOferta05;
	@Column(name = "CLIENTE_OFERTA_06")
	private Short clienteOferta06;
	@Column(name = "CLIENTE_OFERTA_07")
	private Short clienteOferta07;
	@Column(name = "CLIENTE_OFERTA_08")
	private Short clienteOferta08;
	@Column(name = "CLIENTE_OFERTA_09")
	private Short clienteOferta09;
	@Column(name = "CLIENTE_OFERTA_10")
	private Short clienteOferta10;
	@Column(name = "CLIENTE_OFERTA_11")
	private Short clienteOferta11;
	@Column(name = "CLIENTE_OFERTA_12")
	private Short clienteOferta12;
	@Column(name = "CLIENTE_OFERTA_13")
	private Short clienteOferta13;
	@Column(name = "CLIENTE_OFERTA_14")
	private Short clienteOferta14;
	@Column(name = "CLIENTE_OFERTA_15")
	private Short clienteOferta15;
	@Column(name = "CLIENTE_OFERTA_16")
	private Short clienteOferta16;
	@Column(name = "CLIENTE_OFERTA_17")
	private Short clienteOferta17;
	@Column(name = "CLIENTE_OFERTA_18")
	private Short clienteOferta18;
	@Column(name = "CLIENTE_OFERTA_19")
	private Short clienteOferta19;
	@Column(name = "CLIENTE_OFERTA_20")
	private Short clienteOferta20;
	@Column(name = "PLAZO1")
	private Long plazo1;
	@Column(name = "PLAZO2")
	private Long plazo2;
	@Column(name = "PLAZO3")
	private Long plazo3;
	@Column(name = "PLAZO4")
	private Long plazo4;
	@Column(name = "PLAZO5")
	private Long plazo5;
	@Column(name = "IS_HIPO")
	private Long isHipo;

	public Long getNumCte() {
		return numCte;
	}

	public void setNumCte(Long numCte) {
		this.numCte = numCte;
	}

	public Long getCliententp() {
		return cliententp;
	}

	public void setCliententp(Long cliententp) {
		this.cliententp = cliententp;
	}

	public long getContrato() {
		return contrato;
	}

	public void setContrato(long contrato) {
		this.contrato = contrato;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getFisicaMoral() {
		return fisicaMoral;
	}

	public void setFisicaMoral(String fisicaMoral) {
		this.fisicaMoral = fisicaMoral;
	}

	public Long getIsPortabilidad() {
		return isPortabilidad;
	}

	public void setIsPortabilidad(Long isPortabilidad) {
		this.isPortabilidad = isPortabilidad;
	}

	public Date getFechaPortabilidad() {
		return fechaPortabilidad;
	}

	public void setFechaPortabilidad(Date fechaPortabilidad) {
		this.fechaPortabilidad = fechaPortabilidad;
	}

	public BigInteger getMonto1() {
		return monto1;
	}

	public void setMonto1(BigInteger monto1) {
		this.monto1 = monto1;
	}

	public BigInteger getPorcentaje1() {
		return porcentaje1;
	}

	public void setPorcentaje1(BigInteger porcentaje1) {
		this.porcentaje1 = porcentaje1;
	}

	public BigInteger getMonto2() {
		return monto2;
	}

	public void setMonto2(BigInteger monto2) {
		this.monto2 = monto2;
	}

	public BigInteger getPorcentaje2() {
		return porcentaje2;
	}

	public void setPorcentaje2(BigInteger porcentaje2) {
		this.porcentaje2 = porcentaje2;
	}

	public BigInteger getMonto3() {
		return monto3;
	}

	public void setMonto3(BigInteger monto3) {
		this.monto3 = monto3;
	}

	public BigInteger getPorcentaje3() {
		return porcentaje3;
	}

	public void setPorcentaje3(BigInteger porcentaje3) {
		this.porcentaje3 = porcentaje3;
	}

	public BigInteger getMonto4() {
		return monto4;
	}

	public void setMonto4(BigInteger monto4) {
		this.monto4 = monto4;
	}

	public BigInteger getPorcentaje4() {
		return porcentaje4;
	}

	public void setPorcentaje4(BigInteger porcentaje4) {
		this.porcentaje4 = porcentaje4;
	}

	public BigInteger getMonto5() {
		return monto5;
	}

	public void setMonto5(BigInteger monto5) {
		this.monto5 = monto5;
	}

	public BigInteger getPorcentaje5() {
		return porcentaje5;
	}

	public void setPorcentaje5(BigInteger porcentaje5) {
		this.porcentaje5 = porcentaje5;
	}

	public Short getClienteSinOferta() {
		return clienteSinOferta;
	}

	public void setClienteSinOferta(Short clienteSinOferta) {
		this.clienteSinOferta = clienteSinOferta;
	}

	public Long getClienteNumero() {
		return clienteNumero;
	}

	public void setClienteNumero(Long clienteNumero) {
		this.clienteNumero = clienteNumero;
	}

	public String getClienteTipoPersona() {
		return clienteTipoPersona;
	}

	public void setClienteTipoPersona(String clienteTipoPersona) {
		this.clienteTipoPersona = clienteTipoPersona;
	}

	public Short getClienteSegmento() {
		return clienteSegmento;
	}

	public void setClienteSegmento(Short clienteSegmento) {
		this.clienteSegmento = clienteSegmento;
	}

	public BigInteger getClienteMontoReferencia() {
		return clienteMontoReferencia;
	}

	public void setClienteMontoReferencia(BigInteger clienteMontoReferencia) {
		this.clienteMontoReferencia = clienteMontoReferencia;
	}

	public Short getClienteNewToProduct() {
		return clienteNewToProduct;
	}

	public void setClienteNewToProduct(Short clienteNewToProduct) {
		this.clienteNewToProduct = clienteNewToProduct;
	}

	public Short getClienteNewToDigital() {
		return clienteNewToDigital;
	}

	public void setClienteNewToDigital(Short clienteNewToDigital) {
		this.clienteNewToDigital = clienteNewToDigital;
	}

	public Date getClienteFechaReferencia() {
		return clienteFechaReferencia;
	}

	public void setClienteFechaReferencia(Date clienteFechaReferencia) {
		this.clienteFechaReferencia = clienteFechaReferencia;
	}

	public Long getCuentaContrato() {
		return cuentaContrato;
	}

	public void setCuentaContrato(Long cuentaContrato) {
		this.cuentaContrato = cuentaContrato;
	}

	public Short getClienteOferta01() {
		return clienteOferta01;
	}

	public void setClienteOferta01(Short clienteOferta01) {
		this.clienteOferta01 = clienteOferta01;
	}

	public Short getClienteOferta02() {
		return clienteOferta02;
	}

	public void setClienteOferta02(Short clienteOferta02) {
		this.clienteOferta02 = clienteOferta02;
	}

	public Short getClienteOferta03() {
		return clienteOferta03;
	}

	public void setClienteOferta03(Short clienteOferta03) {
		this.clienteOferta03 = clienteOferta03;
	}

	public Short getClienteOferta04() {
		return clienteOferta04;
	}

	public void setClienteOferta04(Short clienteOferta04) {
		this.clienteOferta04 = clienteOferta04;
	}

	public Short getClienteOferta05() {
		return clienteOferta05;
	}

	public void setClienteOferta05(Short clienteOferta05) {
		this.clienteOferta05 = clienteOferta05;
	}

	public Short getClienteOferta06() {
		return clienteOferta06;
	}

	public void setClienteOferta06(Short clienteOferta06) {
		this.clienteOferta06 = clienteOferta06;
	}

	public Short getClienteOferta07() {
		return clienteOferta07;
	}

	public void setClienteOferta07(Short clienteOferta07) {
		this.clienteOferta07 = clienteOferta07;
	}

	public Short getClienteOferta08() {
		return clienteOferta08;
	}

	public void setClienteOferta08(Short clienteOferta08) {
		this.clienteOferta08 = clienteOferta08;
	}

	public Short getClienteOferta09() {
		return clienteOferta09;
	}

	public void setClienteOferta09(Short clienteOferta09) {
		this.clienteOferta09 = clienteOferta09;
	}

	public Short getClienteOferta10() {
		return clienteOferta10;
	}

	public void setClienteOferta10(Short clienteOferta10) {
		this.clienteOferta10 = clienteOferta10;
	}

	public Short getClienteOferta11() {
		return clienteOferta11;
	}

	public void setClienteOferta11(Short clienteOferta11) {
		this.clienteOferta11 = clienteOferta11;
	}

	public Short getClienteOferta12() {
		return clienteOferta12;
	}

	public void setClienteOferta12(Short clienteOferta12) {
		this.clienteOferta12 = clienteOferta12;
	}

	public Short getClienteOferta13() {
		return clienteOferta13;
	}

	public void setClienteOferta13(Short clienteOferta13) {
		this.clienteOferta13 = clienteOferta13;
	}

	public Short getClienteOferta14() {
		return clienteOferta14;
	}

	public void setClienteOferta14(Short clienteOferta14) {
		this.clienteOferta14 = clienteOferta14;
	}

	public Short getClienteOferta15() {
		return clienteOferta15;
	}

	public void setClienteOferta15(Short clienteOferta15) {
		this.clienteOferta15 = clienteOferta15;
	}

	public Short getClienteOferta16() {
		return clienteOferta16;
	}

	public void setClienteOferta16(Short clienteOferta16) {
		this.clienteOferta16 = clienteOferta16;
	}

	public Short getClienteOferta17() {
		return clienteOferta17;
	}

	public void setClienteOferta17(Short clienteOferta17) {
		this.clienteOferta17 = clienteOferta17;
	}

	public Short getClienteOferta18() {
		return clienteOferta18;
	}

	public void setClienteOferta18(Short clienteOferta18) {
		this.clienteOferta18 = clienteOferta18;
	}

	public Short getClienteOferta19() {
		return clienteOferta19;
	}

	public void setClienteOferta19(Short clienteOferta19) {
		this.clienteOferta19 = clienteOferta19;
	}

	public Short getClienteOferta20() {
		return clienteOferta20;
	}

	public void setClienteOferta20(Short clienteOferta20) {
		this.clienteOferta20 = clienteOferta20;
	}

	public Long getPlazo1() {
		return plazo1;
	}

	public void setPlazo1(Long plazo1) {
		this.plazo1 = plazo1;
	}

	public Long getPlazo2() {
		return plazo2;
	}

	public void setPlazo2(Long plazo2) {
		this.plazo2 = plazo2;
	}

	public Long getPlazo3() {
		return plazo3;
	}

	public void setPlazo3(Long plazo3) {
		this.plazo3 = plazo3;
	}

	public Long getPlazo4() {
		return plazo4;
	}

	public void setPlazo4(Long plazo4) {
		this.plazo4 = plazo4;
	}

	public Long getPlazo5() {
		return plazo5;
	}

	public void setPlazo5(Long plazo5) {
		this.plazo5 = plazo5;
	}

	public Long getIsHipo() {
		return isHipo;
	}

	public void setIsHipo(Long isHipo) {
		this.isHipo = isHipo;
	}

	@Override
	public String toString() {
		return "UecCatGralCtesUEC [numCte=" + numCte + ", cliententp=" + cliententp + ", contrato=" + contrato
				+ ", segmento=" + segmento + ", fisicaMoral=" + fisicaMoral + ", isPortabilidad=" + isPortabilidad
				+ ", fechaPortabilidad=" + fechaPortabilidad + ", monto1=" + monto1 + ", porcentaje1=" + porcentaje1
				+ ", monto2=" + monto2 + ", porcentaje2=" + porcentaje2 + ", monto3=" + monto3 + ", porcentaje3="
				+ porcentaje3 + ", monto4=" + monto4 + ", porcentaje4=" + porcentaje4 + ", monto5=" + monto5
				+ ", porcentaje5=" + porcentaje5 + ", clienteSinOferta=" + clienteSinOferta + ", clienteNumero="
				+ clienteNumero + ", clienteTipoPersona=" + clienteTipoPersona + ", clienteSegmento=" + clienteSegmento
				+ ", clienteMontoReferencia=" + clienteMontoReferencia + ", clienteNewToProduct=" + clienteNewToProduct
				+ ", clienteNewToDigital=" + clienteNewToDigital + ", clienteFechaReferencia=" + clienteFechaReferencia
				+ ", cuentaContrato=" + cuentaContrato + ", clienteOferta01=" + clienteOferta01 + ", clienteOferta02="
				+ clienteOferta02 + ", clienteOferta03=" + clienteOferta03 + ", clienteOferta04=" + clienteOferta04
				+ ", clienteOferta05=" + clienteOferta05 + ", clienteOferta06=" + clienteOferta06 + ", clienteOferta07="
				+ clienteOferta07 + ", clienteOferta08=" + clienteOferta08 + ", clienteOferta09=" + clienteOferta09
				+ ", clienteOferta10=" + clienteOferta10 + ", clienteOferta11=" + clienteOferta11 + ", clienteOferta12="
				+ clienteOferta12 + ", clienteOferta13=" + clienteOferta13 + ", clienteOferta14=" + clienteOferta14
				+ ", clienteOferta15=" + clienteOferta15 + ", clienteOferta16=" + clienteOferta16 + ", clienteOferta17="
				+ clienteOferta17 + ", clienteOferta18=" + clienteOferta18 + ", clienteOferta19=" + clienteOferta19
				+ ", clienteOferta20=" + clienteOferta20 + ", plazo1=" + plazo1 + ", plazo2=" + plazo2 + ", plazo3="
				+ plazo3 + ", plazo4=" + plazo4 + ", plazo5=" + plazo5 + ", isHipo=" + isHipo + "]";
	}
	
	
	

}
