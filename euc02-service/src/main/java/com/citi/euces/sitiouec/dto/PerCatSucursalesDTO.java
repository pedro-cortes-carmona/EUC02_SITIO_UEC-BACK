package com.citi.euces.sitiouec.dto;

public class PerCatSucursalesDTO {

	private Long idSucursalSirh;
	private String nombreSucursal;
	private String divisionId;
	private String divisionNombre;

	public PerCatSucursalesDTO() {
		// TODO Auto-generated constructor stub
	}

	public PerCatSucursalesDTO(Long idSucursalSirh, String nombreSucursal, String divisionId, String divisionNombre) {
		super();
		this.idSucursalSirh = idSucursalSirh;
		this.nombreSucursal = nombreSucursal;
		this.divisionId = divisionId;
		this.divisionNombre = divisionNombre;
	}
	

	public PerCatSucursalesDTO(String nombreSucursal) {
		super();
		this.nombreSucursal = nombreSucursal;
	}

	public Long getIdSucursalSirh() {
		return idSucursalSirh;
	}

	public void setIdSucursalSirh(Long idSucursalSirh) {
		this.idSucursalSirh = idSucursalSirh;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionNombre() {
		return divisionNombre;
	}

	public void setDivisionNombre(String divisionNombre) {
		this.divisionNombre = divisionNombre;
	}

	@Override
	public String toString() {
		return "PerCatSucursalesDTO [idSucursalSirh=" + idSucursalSirh + ", nombreSucursal=" + nombreSucursal
				+ ", divisionId=" + divisionId + ", divisionNombre=" + divisionNombre + "]";
	}

}
