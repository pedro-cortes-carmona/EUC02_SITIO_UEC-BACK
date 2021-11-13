package com.citi.euces.sitiouec.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_TASAS") // TSC_EUCS_OWN
public class Tasas {

	
	@Id
	@Column(name = "ID_TASA", nullable = true)
	private Long IdTasa;

	@Column(name = "FECHA_OPE", nullable = true)
	private Date fechaOpe;

	@Column(name = "ESTATUS", nullable = true)
	private Long estatus;

	@Column(name = "NUM_CTE", nullable = true)
	private Long num_cte;

	@Column(name = "CONTRATO", nullable = true)
	private Long contrato;

	@Column(name = "SUC_SOLIC", nullable = true)
	private Long suc_solic;

	@Column(name = "DIVISION", nullable = true)
	private String division;

	@Column(name = "NUM_AUTORI_UEC", nullable = true)
	private Long numAutoriUec;

	@Column(name = "TIPO_PERSONA", nullable = true)
	private Long tipoPersona;

	@Column(name = "T_PER")
	private Long tPer;

	@Column(name = "MONTO")
	private Long monto;

	@Column(name = "TASA_AUTORI")
	private Long tasaAutori;

	@Column(name = "HORA_AUTORI", nullable = true)
	private Date horaAutori;

	@Column(name = "PRODUCTO")
	private Long producto;

	@Column(name = "OPERADOR_UEC", nullable = true)
	private Long operadorUec;

	@Column(name = "NUM_INVERSION", nullable = true)
	private Long numInversion;

	@Column(name = "PLAZO", nullable = true)
	private Long plazo;

	@Column(name = "NOM_CTE", nullable = true)
	private String nomCliente;

	@Column(name = "INSTR", nullable = true)
	private Long instr;

	@Column(name = "CVE_MONTO", nullable = true)
	private Long cveMonto;

	@Column(name = "CVE_PLAZO", nullable = true)
	private Long cvePlazo;

	@Column(name = "SOEID_REP", nullable = true)
	private String soeidRep;

	@Column(name = "AUTORIZADOR", nullable = true)
	private String autorizador;

	@Column(name = "CETE", nullable = true)
	private Long cete;

	@Column(name = "PORCEN_CETE", nullable = true)
	private Long porcenCete;

	@Column(name = "ASIGNADO_A", nullable = true)
	private String asginadoA;

	@Column(name = "OPERADO_POR", nullable = true)
	private String operadoPor;

	@Column(name = "FECHA_CAPTURA", nullable = true)
	private Date fechaCaptura;

	@Column(name = "FECHA_ESTATUS", nullable = true)
	private Date fechaEstatus;

	@Column(name = "IS_TASA_BASE", nullable = true)
	private Long isTasaBase;

	@Column(name = "OBSERVA_WEB", nullable = true)
	private String observaWeb;

	@Column(name = "CAMPANA_WEB", nullable = true)
	private String campanaWeb;

	@Column(name = "IS_WEB", nullable = true)
	private Long isWeb;

	@Column(name = "IS_BEI", nullable = true)
	private Long isBei;

	@Column(name = "NOMINA", nullable = true)
	private String nomina;

	@Column(name = "NOMEJEC", nullable = true)
	private String nomEjecutivo;

	
	
	public Long getIdTasa() {
		return IdTasa;
	}

	public void setIdTasa(Long idTasa) {
		IdTasa = idTasa;
	}

	public Date getFechaOpe() {
		return fechaOpe;
	}

	public void setFechaOpe(Date fechaOpe) {
		this.fechaOpe = fechaOpe;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	public Long getNum_cte() {
		return num_cte;
	}

	public void setNum_cte(Long num_cte) {
		this.num_cte = num_cte;
	}

	public Long getContrato() {
		return contrato;
	}

	public void setContrato(Long contrato) {
		this.contrato = contrato;
	}

	public Long getSuc_solic() {
		return suc_solic;
	}

	public void setSuc_solic(Long suc_solic) {
		this.suc_solic = suc_solic;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Long getNumAutoriUec() {
		return numAutoriUec;
	}

	public void setNumAutoriUec(Long numAutoriUec) {
		this.numAutoriUec = numAutoriUec;
	}

	public Long getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(Long tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Long gettPer() {
		return tPer;
	}

	public void settPer(Long tPer) {
		this.tPer = tPer;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public Long getTasaAutori() {
		return tasaAutori;
	}

	public void setTasaAutori(Long tasaAutori) {
		this.tasaAutori = tasaAutori;
	}

	public Date getHoraAutori() {
		return horaAutori;
	}

	public void setHoraAutori(Date horaAutori) {
		this.horaAutori = horaAutori;
	}

	public Long getProducto() {
		return producto;
	}

	public void setProducto(Long producto) {
		this.producto = producto;
	}

	public Long getOperadorUec() {
		return operadorUec;
	}

	public void setOperadorUec(Long operadorUec) {
		this.operadorUec = operadorUec;
	}

	public Long getNumInversion() {
		return numInversion;
	}

	public void setNumInversion(Long numInversion) {
		this.numInversion = numInversion;
	}

	public Long getPlazo() {
		return plazo;
	}

	public void setPlazo(Long plazo) {
		this.plazo = plazo;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public Long getInstr() {
		return instr;
	}

	public void setInstr(Long instr) {
		this.instr = instr;
	}

	public Long getCveMonto() {
		return cveMonto;
	}

	public void setCveMonto(Long cveMonto) {
		this.cveMonto = cveMonto;
	}

	public Long getCvePlazo() {
		return cvePlazo;
	}

	public void setCvePlazo(Long cvePlazo) {
		this.cvePlazo = cvePlazo;
	}

	public String getSoeidRep() {
		return soeidRep;
	}

	public void setSoeidRep(String soeidRep) {
		this.soeidRep = soeidRep;
	}

	public String getAutorizador() {
		return autorizador;
	}

	public void setAutorizador(String autorizador) {
		this.autorizador = autorizador;
	}

	public Long getCete() {
		return cete;
	}

	public void setCete(Long cete) {
		this.cete = cete;
	}

	public Long getPorcenCete() {
		return porcenCete;
	}

	public void setPorcenCete(Long porcenCete) {
		this.porcenCete = porcenCete;
	}

	public String getAsginadoA() {
		return asginadoA;
	}

	public void setAsginadoA(String asginadoA) {
		this.asginadoA = asginadoA;
	}

	public String getOperadoPor() {
		return operadoPor;
	}

	public void setOperadoPor(String operadoPor) {
		this.operadoPor = operadoPor;
	}

	public Date getFechaCaptura() {
		return fechaCaptura;
	}

	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	public Date getFechaEstatus() {
		return fechaEstatus;
	}

	public void setFechaEstatus(Date fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}

	public Long getIsTasaBase() {
		return isTasaBase;
	}

	public void setIsTasaBase(Long isTasaBase) {
		this.isTasaBase = isTasaBase;
	}

	public String getObservaWeb() {
		return observaWeb;
	}

	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}

	public String getCampanaWeb() {
		return campanaWeb;
	}

	public void setCampanaWeb(String campanaWeb) {
		this.campanaWeb = campanaWeb;
	}

	public Long getIsWeb() {
		return isWeb;
	}

	public void setIsWeb(Long isWeb) {
		this.isWeb = isWeb;
	}

	public Long getIsBei() {
		return isBei;
	}

	public void setIsBei(Long isBei) {
		this.isBei = isBei;
	}

	public String getNomina() {
		return nomina;
	}

	public void setNomina(String nomina) {
		this.nomina = nomina;
	}

	public String getNomEjecutivo() {
		return nomEjecutivo;
	}

	public void setNomEjecutivo(String nomEjecutivo) {
		this.nomEjecutivo = nomEjecutivo;
	}

	@Override
	public String toString() {
		return "Tasas [IdTasa=" + IdTasa + ", fechaOpe=" + fechaOpe + ", estatus=" + estatus + ", num_cte=" + num_cte
				+ ", contrato=" + contrato + ", suc_solic=" + suc_solic + ", division=" + division + ", numAutoriUec="
				+ numAutoriUec + ", tipoPersona=" + tipoPersona + ", tPer=" + tPer + ", monto=" + monto
				+ ", tasaAutori=" + tasaAutori + ", horaAutori=" + horaAutori + ", producto=" + producto
				+ ", operadorUec=" + operadorUec + ", numInversion=" + numInversion + ", plazo=" + plazo
				+ ", nomCliente=" + nomCliente + ", instr=" + instr + ", cveMonto=" + cveMonto + ", cvePlazo="
				+ cvePlazo + ", soeidRep=" + soeidRep + ", autorizador=" + autorizador + ", cete=" + cete
				+ ", porcenCete=" + porcenCete + ", asginadoA=" + asginadoA + ", operadoPor=" + operadoPor
				+ ", fechaCaptura=" + fechaCaptura + ", fechaEstatus=" + fechaEstatus + ", isTasaBase=" + isTasaBase
				+ ", observaWeb=" + observaWeb + ", campanaWeb=" + campanaWeb + ", isWeb=" + isWeb + ", isBei=" + isBei
				+ ", nomina=" + nomina + ", nomEjecutivo=" + nomEjecutivo + "]";
	}

}
