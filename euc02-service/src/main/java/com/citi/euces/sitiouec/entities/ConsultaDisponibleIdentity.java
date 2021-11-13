package com.citi.euces.sitiouec.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The primary key class for the CONSULTA_DISPONIBLE database table.
 * @author lbermejo
 * 
 */
@Embeddable
public class ConsultaDisponibleIdentity implements Serializable {
	
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	
	
	@NotNull
    @Size(max = 16)
	@Column(name="TARJETA_CREDITO")
	private String tarjetaCredito;

	@NotNull
	@Column(name="NOMBRE")
	private String nombre;
	
	@NotNull
	@Column(name="PROMOCION")
	private String promocion;

	
	public ConsultaDisponibleIdentity() {}
	public ConsultaDisponibleIdentity(
			final String ntdc, final String name, final String promo) {
		this.tarjetaCredito = ntdc;
		this.nombre = name;
		this.promocion = promo;
	}
	
	/**
	 * 
	 */
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other );
	}

	/**
	 * 
	 */
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	/**
	 * @return the tarjetaCredito
	 */
	public String getTarjetaCredito() {
		return tarjetaCredito;
	}

	/**
	 * @param tarjetaCredito the tarjetaCredito to set
	 */
	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the promocion
	 */
	public String getPromocion() {
		return promocion;
	}

	/**
	 * @param promocion the promocion to set
	 */
	public void setPromocion(String promocion) {
		this.promocion = promocion;
	}

}