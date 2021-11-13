package com.citi.euces.sitiouec.dto;

public class PetCatEjecutivoSucursalCampanaDTO {

	
	private String soied;
	private Long nomina;	
	private String nombre;
	private Long sirhSucursal;	
	private String puestoTipo;	
	private String priority;
	
	public PetCatEjecutivoSucursalCampanaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PetCatEjecutivoSucursalCampanaDTO(String soied, Long nomina, String nombre, Long sirhSucursal,
			String puestoTipo, String priority) {
		super();
		this.soied = soied;
		this.nomina = nomina;
		this.nombre = nombre;
		this.sirhSucursal = sirhSucursal;
		this.puestoTipo = puestoTipo;
		this.priority = priority;
	}

	public String getSoied() {
		return soied;
	}
	public void setSoied(String soied) {
		this.soied = soied;
	}
	public Long getNomina() {
		return nomina;
	}
	public void setNomina(Long nomina) {
		this.nomina = nomina;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getSirhSucursal() {
		return sirhSucursal;
	}
	public void setSirhSucursal(Long sirhSucursal) {
		this.sirhSucursal = sirhSucursal;
	}
	public String getPuestoTipo() {
		return puestoTipo;
	}
	public void setPuestoTipo(String puestoTipo) {
		this.puestoTipo = puestoTipo;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "PetCatEjecutivoSucursalCampanaDTO [soied=" + soied + ", nomina=" + nomina + ", nombre=" + nombre
				+ ", sirhSucursal=" + sirhSucursal + ", puestoTipo=" + puestoTipo + ", priority=" + priority + "]";
	}
	
	
	
	
	
}
