package com.citi.euces.sitiouec.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UEC_CAT_GRAL_CTES")
public class CatGralClientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "NUM_CTE")
	private Integer numCte;

	@Column(name = "CLIENTENTP")
	private Integer clienteNtp;
	
	@Column(name = "CONTRATO")
	private Integer contrato;
	
	@Column(name = "SEGMENTO")
	private String segmento;

	@Column(name = "FISICA_MORAL")
	private String fisicaMoral;
	
	@Column(name = "IS_PORTABILIDAD")
	private Integer isPortabilidad;
	
	@Column(name = "EJECUTIVOS")
	private Integer ejecutivos;

	@Column(name = "FECHA_PORTABILIDAD")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPortabilidad;
	
	@Column(name = "MONTO1")
	private Integer monto1;
	
	@Column(name = "PORCENTAJE1")
	private Integer porcentaje1;
	
	@Column(name = "MONTO2")
	private Integer monto2;
	
	@Column(name = "PORCENTAJE2")
	private Integer porcentaje2;
	
	@Column(name = "MONTO3")
	private Integer monto3;
	
	@Column(name = "PORCENTAJE3")
	private Integer porcentaje3;
	
	@Column(name = "MONTO4")
	private Integer monto4;
	
	@Column(name = "PORCENTAJE4")
	private Integer porcentaje4;
	
	@Column(name = "MONTO5")
	private Integer monto5;
	
	@Column(name = "PORCENTAJE5")
	private Integer porcentaje5;

	@Column(name = "CLIENTE_SIN_OFERTA")
	private Integer clienteSinOferta;
	
	@Column(name = "CLIENTE_NUMERO")
	private Integer clienteNumero;
	
	@Column(name = "CLIENTE_TIPO_PERSONA")
	private String clienteTipoPersona;
	
	@Column(name = "CLIENTE_SEGMENTO")
	private Integer clienteSegmento;
	
	@Column(name = "CLIENTE_MONTO_REFERENCIA")
	private Integer clienteMontoReferencia;
	
	@Column(name = "CLIENTE_NEW_TO_PRODUCT")
	private Integer clienteNewToProduct;
	
	@Column(name = "CLIENTE_NEW_TO_DIGITAL")
	private Integer clienteNewToDigital;
	
	@Column(name = "CLIENTE_FECHA_REFERENCIA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date clienteFechaReferencia;
	
	@Column(name = "CUENTA_CONTRATO")
	private Integer cuentaContrato;
	
	@Column(name = "CLIENTE_OFERTA_01")
	private Integer clienteOferta01;
	
	@Column(name = "CLIENTE_OFERTA_02")
	private Integer clienteOferta02;
	
	@Column(name = "CLIENTE_OFERTA_03")
	private Integer clienteOferta03;
	
	@Column(name = "CLIENTE_OFERTA_04")
	private Integer clienteOferta04;
	
	@Column(name = "CLIENTE_OFERTA_05")
	private Integer clienteOferta05;
	
	@Column(name = "CLIENTE_OFERTA_06")
	private Integer clienteOferta06;
	
	@Column(name = "CLIENTE_OFERTA_07")
	private Integer clienteOferta07;
	
	@Column(name = "CLIENTE_OFERTA_08")
	private Integer clienteOferta08;
	
	@Column(name = "CLIENTE_OFERTA_09")
	private Integer clienteOferta09;
	
	@Column(name = "CLIENTE_OFERTA_10")
	private Integer clienteOferta10;
	
	@Column(name = "CLIENTE_OFERTA_11")
	private Integer clienteOferta11;
	
	@Column(name = "CLIENTE_OFERTA_12")
	private Integer clienteOferta12;
	
	@Column(name = "CLIENTE_OFERTA_13")
	private Integer clienteOferta13;
	
	@Column(name = "CLIENTE_OFERTA_14")
	private Integer clienteOferta14;
	
	@Column(name = "CLIENTE_OFERTA_15")
	private Integer clienteOferta15;
	
	@Column(name = "CLIENTE_OFERTA_16")
	private Integer clienteOferta16;
	
	@Column(name = "CLIENTE_OFERTA_17")
	private Integer clienteOferta17;
	
	@Column(name = "CLIENTE_OFERTA_18")
	private Integer clienteOferta18;
	
	@Column(name = "CLIENTE_OFERTA_19")
	private Integer clienteOferta19;
	
	@Column(name = "CLIENTE_OFERTA_20")
	private Integer clienteOferta20;
	
	@Column(name = "PLAZO1")
	private Integer plazo1;
	
	@Column(name = "PLAZO2")
	private Integer plazo2;
	
	@Column(name = "PLAZO3")
	private Integer plazo3;
	
	@Column(name = "PLAZO4")
	private Integer plazo4;
	
	@Column(name = "PLAZO5")
	private Integer plazo5;

	@Column(name = "IS_HIPO")
	private Integer isHipo;

	public Integer getNumCte() {
		return numCte;
	}

	public void setNumCte(Integer numCte) {
		this.numCte = numCte;
	}

	public Integer getClienteNtp() {
		return clienteNtp;
	}

	public void setClienteNtp(Integer clienteNtp) {
		this.clienteNtp = clienteNtp;
	}

	public Integer getContrato() {
		return contrato;
	}

	public void setContrato(Integer contrato) {
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

	public Integer getIsPortabilidad() {
		return isPortabilidad;
	}

	public void setIsPortabilidad(Integer isPortabilidad) {
		this.isPortabilidad = isPortabilidad;
	}

	public Integer getEjecutivos() {
		return ejecutivos;
	}

	public void setEjecutivos(Integer ejecutivos) {
		this.ejecutivos = ejecutivos;
	}

	public Date getFechaPortabilidad() {
		return fechaPortabilidad;
	}

	public void setFechaPortabilidad(Date fechaPortabilidad) {
		this.fechaPortabilidad = fechaPortabilidad;
	}

	public Integer getMonto1() {
		return monto1;
	}

	public void setMonto1(Integer monto1) {
		this.monto1 = monto1;
	}

	public Integer getPorcentaje1() {
		return porcentaje1;
	}

	public void setPorcentaje1(Integer porcentaje1) {
		this.porcentaje1 = porcentaje1;
	}

	public Integer getMonto2() {
		return monto2;
	}

	public void setMonto2(Integer monto2) {
		this.monto2 = monto2;
	}

	public Integer getPorcentaje2() {
		return porcentaje2;
	}

	public void setPorcentaje2(Integer porcentaje2) {
		this.porcentaje2 = porcentaje2;
	}

	public Integer getMonto3() {
		return monto3;
	}

	public void setMonto3(Integer monto3) {
		this.monto3 = monto3;
	}

	public Integer getPorcentaje3() {
		return porcentaje3;
	}

	public void setPorcentaje3(Integer porcentaje3) {
		this.porcentaje3 = porcentaje3;
	}

	public Integer getMonto4() {
		return monto4;
	}

	public void setMonto4(Integer monto4) {
		this.monto4 = monto4;
	}

	public Integer getPorcentaje4() {
		return porcentaje4;
	}

	public void setPorcentaje4(Integer porcentaje4) {
		this.porcentaje4 = porcentaje4;
	}

	public Integer getMonto5() {
		return monto5;
	}

	public void setMonto5(Integer monto5) {
		this.monto5 = monto5;
	}

	public Integer getPorcentaje5() {
		return porcentaje5;
	}

	public void setPorcentaje5(Integer porcentaje5) {
		this.porcentaje5 = porcentaje5;
	}

	public Integer getClienteSinOferta() {
		return clienteSinOferta;
	}

	public void setClienteSinOferta(Integer clienteSinOferta) {
		this.clienteSinOferta = clienteSinOferta;
	}

	public Integer getClienteNumero() {
		return clienteNumero;
	}

	public void setClienteNumero(Integer clienteNumero) {
		this.clienteNumero = clienteNumero;
	}

	public String getClienteTipoPersona() {
		return clienteTipoPersona;
	}

	public void setClienteTipoPersona(String clienteTipoPersona) {
		this.clienteTipoPersona = clienteTipoPersona;
	}

	public Integer getClienteSegmento() {
		return clienteSegmento;
	}

	public void setClienteSegmento(Integer clienteSegmento) {
		this.clienteSegmento = clienteSegmento;
	}

	public Integer getClienteMontoReferencia() {
		return clienteMontoReferencia;
	}

	public void setClienteMontoReferencia(Integer clienteMontoReferencia) {
		this.clienteMontoReferencia = clienteMontoReferencia;
	}

	public Integer getClienteNewToProduct() {
		return clienteNewToProduct;
	}

	public void setClienteNewToProduct(Integer clienteNewToProduct) {
		this.clienteNewToProduct = clienteNewToProduct;
	}

	public Integer getClienteNewToDigital() {
		return clienteNewToDigital;
	}

	public void setClienteNewToDigital(Integer clienteNewToDigital) {
		this.clienteNewToDigital = clienteNewToDigital;
	}

	public Date getClienteFechaReferencia() {
		return clienteFechaReferencia;
	}

	public void setClienteFechaReferencia(Date clienteFechaReferencia) {
		this.clienteFechaReferencia = clienteFechaReferencia;
	}

	public Integer getCuentaContrato() {
		return cuentaContrato;
	}

	public void setCuentaContrato(Integer cuentaContrato) {
		this.cuentaContrato = cuentaContrato;
	}

	public Integer getClienteOferta01() {
		return clienteOferta01;
	}

	public void setClienteOferta01(Integer clienteOferta01) {
		this.clienteOferta01 = clienteOferta01;
	}

	public Integer getClienteOferta02() {
		return clienteOferta02;
	}

	public void setClienteOferta02(Integer clienteOferta02) {
		this.clienteOferta02 = clienteOferta02;
	}

	public Integer getClienteOferta03() {
		return clienteOferta03;
	}

	public void setClienteOferta03(Integer clienteOferta03) {
		this.clienteOferta03 = clienteOferta03;
	}

	public Integer getClienteOferta04() {
		return clienteOferta04;
	}

	public void setClienteOferta04(Integer clienteOferta04) {
		this.clienteOferta04 = clienteOferta04;
	}

	public Integer getClienteOferta05() {
		return clienteOferta05;
	}

	public void setClienteOferta05(Integer clienteOferta05) {
		this.clienteOferta05 = clienteOferta05;
	}

	public Integer getClienteOferta06() {
		return clienteOferta06;
	}

	public void setClienteOferta06(Integer clienteOferta06) {
		this.clienteOferta06 = clienteOferta06;
	}

	public Integer getClienteOferta07() {
		return clienteOferta07;
	}

	public void setClienteOferta07(Integer clienteOferta07) {
		this.clienteOferta07 = clienteOferta07;
	}

	public Integer getClienteOferta08() {
		return clienteOferta08;
	}

	public void setClienteOferta08(Integer clienteOferta08) {
		this.clienteOferta08 = clienteOferta08;
	}

	public Integer getClienteOferta09() {
		return clienteOferta09;
	}

	public void setClienteOferta09(Integer clienteOferta09) {
		this.clienteOferta09 = clienteOferta09;
	}

	public Integer getClienteOferta10() {
		return clienteOferta10;
	}

	public void setClienteOferta10(Integer clienteOferta10) {
		this.clienteOferta10 = clienteOferta10;
	}

	public Integer getClienteOferta11() {
		return clienteOferta11;
	}

	public void setClienteOferta11(Integer clienteOferta11) {
		this.clienteOferta11 = clienteOferta11;
	}

	public Integer getClienteOferta12() {
		return clienteOferta12;
	}

	public void setClienteOferta12(Integer clienteOferta12) {
		this.clienteOferta12 = clienteOferta12;
	}

	public Integer getClienteOferta13() {
		return clienteOferta13;
	}

	public void setClienteOferta13(Integer clienteOferta13) {
		this.clienteOferta13 = clienteOferta13;
	}

	public Integer getClienteOferta14() {
		return clienteOferta14;
	}

	public void setClienteOferta14(Integer clienteOferta14) {
		this.clienteOferta14 = clienteOferta14;
	}

	public Integer getClienteOferta15() {
		return clienteOferta15;
	}

	public void setClienteOferta15(Integer clienteOferta15) {
		this.clienteOferta15 = clienteOferta15;
	}

	public Integer getClienteOferta16() {
		return clienteOferta16;
	}

	public void setClienteOferta16(Integer clienteOferta16) {
		this.clienteOferta16 = clienteOferta16;
	}

	public Integer getClienteOferta17() {
		return clienteOferta17;
	}

	public void setClienteOferta17(Integer clienteOferta17) {
		this.clienteOferta17 = clienteOferta17;
	}

	public Integer getClienteOferta18() {
		return clienteOferta18;
	}

	public void setClienteOferta18(Integer clienteOferta18) {
		this.clienteOferta18 = clienteOferta18;
	}

	public Integer getClienteOferta19() {
		return clienteOferta19;
	}

	public void setClienteOferta19(Integer clienteOferta19) {
		this.clienteOferta19 = clienteOferta19;
	}

	public Integer getClienteOferta20() {
		return clienteOferta20;
	}

	public void setClienteOferta20(Integer clienteOferta20) {
		this.clienteOferta20 = clienteOferta20;
	}

	public Integer getPlazo1() {
		return plazo1;
	}

	public void setPlazo1(Integer plazo1) {
		this.plazo1 = plazo1;
	}

	public Integer getPlazo2() {
		return plazo2;
	}

	public void setPlazo2(Integer plazo2) {
		this.plazo2 = plazo2;
	}

	public Integer getPlazo3() {
		return plazo3;
	}

	public void setPlazo3(Integer plazo3) {
		this.plazo3 = plazo3;
	}

	public Integer getPlazo4() {
		return plazo4;
	}

	public void setPlazo4(Integer plazo4) {
		this.plazo4 = plazo4;
	}

	public Integer getPlazo5() {
		return plazo5;
	}

	public void setPlazo5(Integer plazo5) {
		this.plazo5 = plazo5;
	}

	public Integer getIsHipo() {
		return isHipo;
	}

	public void setIsHipo(Integer isHipo) {
		this.isHipo = isHipo;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
