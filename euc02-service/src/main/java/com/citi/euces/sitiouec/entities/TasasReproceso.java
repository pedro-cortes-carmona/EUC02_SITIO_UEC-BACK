package com.citi.euces.sitiouec.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_TASAS_REPROCESO") // TSC_EUCS_OWN  uec_tb_tasas_timeliness
public class TasasReproceso {
	
	
	
	@Id
	@Column(name = "ID_TASA", nullable = true)
	private Long idTasa;
	
	@Column(name = "NUM_AUTORI_UEC", nullable = true)
	private Long numAutoriUec;
	
	@Column(name = "FECHA_OPE", nullable = true)
	private Date fechaOpe;
	
	@Column(name = "SUC_SOLIC", nullable = true)
	private Long sucSolic;
	
	@Column(name = "MONTO")
	private Long monto;

	@Column(name = "PLAZO", nullable = true)
	private Long plazo;
	
	@Column(name = "TASA_AUTORI")
	private Long tasaAutori;
	
	@Column(name = "ESTATUS", nullable = true)
	private String estatus;
	
	@Column(name = "NUM_CTE", nullable = true)
	private Long num_cte;

	@Column(name = "NOM_CTE", nullable = true)
	private String nomCliente;
	
	@Column(name = "CONTRATO", nullable = true)
	private Long contrato;
	
	@Column(name = "OPERADO_POR", nullable = true)
	private String operadoPor;

	@Column(name = "CAMPANA_WEB", nullable = true)
	private String campanaWeb;
	
	@Column(name = "NOMEJEC", nullable = true)
	private String nomEjecutivo;
	
	@Column(name = "OBSERVA_WEB", nullable = true)
	private String observaWeb;

	@Column(name = "SOEID_RESP", nullable = true)
	private String soeidResp;
	
	

	public Long getIdTasa() {
		return idTasa;
	}
	
	public void setIdTasa(Long idTasa) {
		this.idTasa = idTasa;
	}

	public Long getNumAutoriUec() {
		return numAutoriUec;
	}

	public void setNumAutoriUec(Long numAutoriUec) {
		this.numAutoriUec = numAutoriUec;
	}

	public Date getFechaOpe() {
		return fechaOpe;
	}

	public void setFechaOpe(Date fechaOpe) {
		this.fechaOpe = fechaOpe;
	}

	public Long getSucSolic() {
		return sucSolic;
	}

	public void setSucSolic(Long sucSolic) {
		this.sucSolic = sucSolic;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public Long getPlazo() {
		return plazo;
	}

	public void setPlazo(Long plazo) {
		this.plazo = plazo;
	}

	public Long getTasaAutori() {
		return tasaAutori;
	}

	public void setTasaAutori(Long tasaAutori) {
		this.tasaAutori = tasaAutori;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Long getNum_cte() {
		return num_cte;
	}

	public void setNum_cte(Long num_cte) {
		this.num_cte = num_cte;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public Long getContrato() {
		return contrato;
	}

	public void setContrato(Long contrato) {
		this.contrato = contrato;
	}

	public String getOperadoPor() {
		return operadoPor;
	}

	public void setOperadoPor(String operadoPor) {
		this.operadoPor = operadoPor;
	}

	public String getCampanaWeb() {
		return campanaWeb;
	}

	public void setCampanaWeb(String campanaWeb) {
		this.campanaWeb = campanaWeb;
	}

	public String getNomEjecutivo() {
		return nomEjecutivo;
	}

	public void setNomEjecutivo(String nomEjecutivo) {
		this.nomEjecutivo = nomEjecutivo;
	}

	public String getObservaWeb() {
		return observaWeb;
	}

	public void setObservaWeb(String observaWeb) {
		this.observaWeb = observaWeb;
	}

	public String getSoeidResp() {
		return soeidResp;
	}

	public void setSoeidResp(String soeidResp) {
		this.soeidResp = soeidResp;
	}

	
	
	
	

}
