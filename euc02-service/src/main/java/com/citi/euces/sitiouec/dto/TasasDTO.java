package com.citi.euces.sitiouec.dto;

import java.io.Serializable;
import java.util.Date;


//Anny y Cesar
public class TasasDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idTasa;

	private Date fechaOpe;	
	
	private String fechaOperacion;

	private Long suc_solic;

	private Double monto;

	private Long plazo;

	private Long estatus;

	private Long num_cte;

	private String nomCliente;

	private Long contrato;

	private String operadoPor;

	private String campanaWeb;

	private String nomEjecutivo;

	private String observaWeb;

	private String soeidRep;

	private String sinRegistros;

	private Long numAutoriUec;

	private String nomEjec;

	private int tasaAutori;
	
	private Double numAutoriUEC;
	
	private String sucursal;

	public TasasDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public TasasDTO(Long idTasa, Date fechaOpe, Long suc_solic, Double monto, Long plazo, Long estatus, Long num_cte,
			String nomCliente, Long contrato, String operadoPor, String campanaWeb, String observaWeb, String soeidRep,
			Long numAutoriUec, String nomEjec, int tasaAutori) {
		super();
		this.idTasa=idTasa;
		this.fechaOpe = fechaOpe;
		this.suc_solic = suc_solic;
		this.monto = monto;
		this.plazo = plazo;
		this.estatus = estatus;
		this.num_cte = num_cte;
		this.nomCliente = nomCliente;
		this.contrato = contrato;
		this.operadoPor = operadoPor;
		this.campanaWeb = campanaWeb;
		this.observaWeb = observaWeb;
		this.soeidRep = soeidRep;
		this.numAutoriUec = numAutoriUec;
		this.nomEjec = nomEjec;
		this.tasaAutori = tasaAutori;
	}


	public TasasDTO(Double numAutoriUEC,Long idTasa, Date fechaOpe, Long suc_solic, Double monto, Long plazo, Long estatus, Long num_cte,
			String nomCliente, Long contrato, String operadoPor, String campanaWeb, String nomEjecutivo,
			String observaWeb, String soeidRep) {
		super();
		this.numAutoriUEC=numAutoriUEC;
		this.idTasa = idTasa;
		this.fechaOpe = fechaOpe;
		this.suc_solic = suc_solic;
		this.monto = monto;
		this.plazo = plazo;
		this.estatus = estatus;
		this.num_cte = num_cte;
		this.nomCliente = nomCliente;
		this.contrato = contrato;
		this.operadoPor = operadoPor;
		this.campanaWeb = campanaWeb;
		this.nomEjecutivo = nomEjecutivo;
		this.observaWeb = observaWeb;
		this.soeidRep = soeidRep;		
	}

	public Double getNumAutoriUEC() {
		return numAutoriUEC;
	}
	
	public void setNumAutoriUEC(Double numAutoriUEC) {
		this.numAutoriUEC = numAutoriUEC;
	}
	
	public String getFechaOperacion() {
		return fechaOperacion;
	}
	
	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	
	public String getNomEjec() {
		return nomEjec;
	}

	public void setNomEjec(String nomEjec) {
		this.nomEjec = nomEjec;
	}

	public int getTasaAutori() {
		return tasaAutori;
	}

	public void setTasaAutori(int tasaAutori) {
		this.tasaAutori = tasaAutori;
	}

	public Long getNumAutoriUec() {
		return numAutoriUec;
	}

	public void setNumAutoriUec(Long numAutoriUec) {
		this.numAutoriUec = numAutoriUec;
	}

	public void setSinRegistros(String sinRegistros) {
		this.sinRegistros = sinRegistros;
	}

	public String getSinRegistros() {
		return sinRegistros;
	}

	

	public Date getFechaOpe() {
		return fechaOpe;
	}

	public void setFechaOpe(Date fechaOpe) {
		this.fechaOpe = fechaOpe;
	}

	public Long getSuc_solic() {
		return suc_solic;
	}

	public void setSuc_solic(Long suc_solic) {
		this.suc_solic = suc_solic;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Long getPlazo() {
		return plazo;
	}

	public void setPlazo(Long plazo) {
		this.plazo = plazo;
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

	public String getSoeidRep() {
		return soeidRep;
	}

	public void setSoeidRep(String soeidRep) {
		this.soeidRep = soeidRep;
	}

	public Long getIdTasa() {
		return idTasa;
	}
	
	public void setIdTasa(Long idTasa) {
		this.idTasa = idTasa;
	}

	
	public String getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	@Override
	public String toString() {
		return "TasasDTO [idTasa=" + idTasa + ", fechaOpe=" + fechaOpe + ", fechaOperacion=" + fechaOperacion
				+ ", suc_solic=" + suc_solic + ", monto=" + monto + ", plazo=" + plazo + ", estatus=" + estatus
				+ ", num_cte=" + num_cte + ", nomCliente=" + nomCliente + ", contrato=" + contrato + ", operadoPor="
				+ operadoPor + ", campanaWeb=" + campanaWeb + ", nomEjecutivo=" + nomEjecutivo + ", observaWeb="
				+ observaWeb + ", soeidRep=" + soeidRep + ", sinRegistros=" + sinRegistros + ", numAutoriUec="
				+ numAutoriUec + ", nomEjec=" + nomEjec + ", tasaAutori=" + tasaAutori + ", numAutoriUEC="
				+ numAutoriUEC + ", sucursal=" + sucursal + "]";
	}
	
	

	
	

}
