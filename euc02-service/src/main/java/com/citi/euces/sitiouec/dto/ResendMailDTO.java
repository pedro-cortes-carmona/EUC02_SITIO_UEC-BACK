package com.citi.euces.sitiouec.dto;

public class ResendMailDTO {

	private String comando;

	private String estatus;

	private String fechaSolicitud;

	private String contrato;

	private String numeroCliente;

	private String nombreCliente;

	private String nomina;

	private String nomEjec;

	private String sucursal;

	private String plaza;

	private String monto;

	private String tasaAutori;

	private String autorizadores;
	
	private String tipoOferta;

	public ResendMailDTO() {

	}

	public ResendMailDTO(String comando, String estatus, String fechaSolicitud, String contrato, String numeroCliente,
			String nombreCliente, String nomina, String nomEjec, String sucursal, String plaza, String monto,
			String tasaAutori, String autorizadores, String tipoOferta) {
		super();
		this.comando = comando;
		this.estatus = estatus;
		this.fechaSolicitud = fechaSolicitud;
		this.contrato = contrato;
		this.numeroCliente = numeroCliente;
		this.nombreCliente = nombreCliente;
		this.nomina = nomina;
		this.nomEjec = nomEjec;
		this.sucursal = sucursal;
		this.plaza = plaza;
		this.monto = monto;
		this.tasaAutori = tasaAutori;
		this.autorizadores = autorizadores;
		this.tipoOferta=tipoOferta;
	}

	public String getTipoOferta() {
		return tipoOferta;
	}
	
	public void setTipoOferta(String tipoOferta) {
		this.tipoOferta = tipoOferta;
	}
	
	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
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

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNomina() {
		return nomina;
	}

	public void setNomina(String nomina) {
		this.nomina = nomina;
	}

	public String getNomEjec() {
		return nomEjec;
	}

	public void setNomEjec(String nomEjec) {
		this.nomEjec = nomEjec;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getPlaza() {
		return plaza;
	}

	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getTasaAutori() {
		return tasaAutori;
	}

	public void setTasaAutori(String tasaAutori) {
		this.tasaAutori = tasaAutori;
	}

	public String getAutorizadores() {
		return autorizadores;
	}

	public void setAutorizadores(String autorizadores) {
		this.autorizadores = autorizadores;
	}

	@Override
	public String toString() {
		return "ResendMailDTO [comando=" + comando + ", estatus=" + estatus + ", fechaSolicitud=" + fechaSolicitud
				+ ", contrato=" + contrato + ", numeroCliente=" + numeroCliente + ", nombreCliente=" + nombreCliente
				+ ", nomina=" + nomina + ", nomEjec=" + nomEjec + ", sucursal=" + sucursal + ", plaza=" + plaza
				+ ", monto=" + monto + ", tasaAutori=" + tasaAutori + ", autorizadores=" + autorizadores
				+ ", tipoOferta=" + tipoOferta + "]";
	}

}