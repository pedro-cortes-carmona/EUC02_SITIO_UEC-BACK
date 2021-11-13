package com.citi.euces.sitiouec.dto;

public class MontoPlazoTasaCampanaDTO {

	private Long IdTasa;
	private Long numAutoriUec;
	private String fechaOpe;
	private Long suc_solic;
	private Double monto;
	private Long plazo;
	private int tasaAutori;
	private Long estatus;
	private Long num_cte;
	private String nomCliente;
	private Long contrato;
	private String operadoPor;
	private String campanaWeb;
	private String nomEjecutivo;
	private String observaWeb;
	private String soeidRep;
	
	public MontoPlazoTasaCampanaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MontoPlazoTasaCampanaDTO(Long idTasa, Long numAutoriUec, String fechaOpe, Long suc_solic, Double monto,
			Long plazo, int tasaAutori, Long estatus, Long num_cte, String nomCliente, Long contrato, String operadoPor,
			String campanaWeb, String nomEjecutivo, String observaWeb, String soeidRep) {
		super();
		IdTasa = idTasa;
		this.numAutoriUec = numAutoriUec;
		this.fechaOpe = fechaOpe;
		this.suc_solic = suc_solic;
		this.monto = monto;
		this.plazo = plazo;
		this.tasaAutori = tasaAutori;
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
	public Long getIdTasa() {
		return IdTasa;
	}
	public void setIdTasa(Long idTasa) {
		IdTasa = idTasa;
	}
	public Long getNumAutoriUec() {
		return numAutoriUec;
	}
	public void setNumAutoriUec(Long numAutoriUec) {
		this.numAutoriUec = numAutoriUec;
	}
	public String getFechaOpe() {
		return fechaOpe;
	}
	public void setFechaOpe(String fechaOpe) {
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
	public int getTasaAutori() {
		return tasaAutori;
	}
	public void setTasaAutori(int tasaAutori) {
		this.tasaAutori = tasaAutori;
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
	
	
	
	
	
	
	
}
