package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_EJECUTIVO_SUCURSAL") // TSC_EUCS_OWN
public class PetCatEjecutivoSucursalCampana {

	@Id
	@Column(name = "SOIED", nullable = true)
	private String soied;

	@Column(name = "NOMINA", nullable = true)
	private Long nomina;

	@Column(name = "NOMBRE", nullable = true)
	private String nombre;

	@Column(name = "SIRH_SUCURSAL", nullable = true)
	private Long sirhSucursal;

	@Column(name = "PUESTO_TIPO", nullable = true)
	private String puestoTipo;

	@Column(name = "PRIORITY_", nullable = true)
	private String priority;

	public PetCatEjecutivoSucursalCampana() {
		// TODO Auto-generated constructor stub
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
		return "PetCatEjecutivoSucursalCampana [soied=" + soied + ", nomina=" + nomina + ", nombre=" + nombre
				+ ", sirhSucursal=" + sirhSucursal + ", puestoTipo=" + puestoTipo + ", priority=" + priority + "]";
	}

}
