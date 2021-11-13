package com.citi.euces.sitiouec.dto;

public class ResultEditarDTO {

	private long idAutoTasa;
	
	private String estatus;
	
	private String contrato;
	
	private String numeroCliente;
	
	private String fechaSolicitud;
	
	private String soeid;
	
	
	
	
	public String getEstatus() {
		return estatus;
	}




	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}




	public String getContrato() {
		return contrato;
	}




	public void setContrato(String contrato) {
		this.contrato = contrato;
	}




	public String getNumeroCliente() {
		return numeroCliente;
	}




	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}




	public String getFechaSolicitud() {
		return fechaSolicitud;
	}




	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}




	public String getSoeid() {
		return soeid;
	}




	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}

	


	public long getIdAutoTasa() {
		return idAutoTasa;
	}




	public void setIdAutoTasa(long idAutoTasa) {
		this.idAutoTasa = idAutoTasa;
	}




	@Override
	public String toString() {
		return "InBuscarClickDTO [estatus="+estatus+",estatus="+estatus+", contrato=" + contrato + ",numeroCliente=" + numeroCliente +", fechaSolicitud=" + fechaSolicitud + ", soeid "+soeid+"= ]";
	}
	
	
}
