/**
 *
 */
package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author lbermejo
 *
 */
public class CustomerDetailResponse implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String tarjetaDeCredito;
	private String promocion;
	private String nombre;
	private String producto;  
	private Double lineaInvitada;
	private String mensualidades;
	private String tasaIntAn;
	private String catSinIva;
	private String vigencia; 
	private String promoId; 

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this, ToStringStyle.JSON_STYLE  );
	}

	/**
	 * @return the tarjetaDeCredito
	 */
	public String getTarjetaDeCredito() {
		return tarjetaDeCredito;
	}

	/**
	 * @param tarjetaDeCredito the tarjetaDeCredito to set
	 */
	public void setTarjetaDeCredito(String tarjetaDeCredito) {
		this.tarjetaDeCredito = tarjetaDeCredito;
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
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @return the vigencia
	 */
	public String getVigencia() {
		return vigencia;
	}
	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	/**
	 * @return the promoId
	 */
	public String getPromoId() {
		return promoId;
	}
	/**
	 * @param promoId the promoId to set
	 */
	public void setPromoId(String promoId) {
		this.promoId = promoId;
	}
	/**
	 * @return the lineaInvitada
	 */
	public Double getLineaInvitada() {
		return lineaInvitada;
	}
	/**
	 * @param lineaInvitada the lineaInvitada to set
	 */
	public void setLineaInvitada(Double lineaInvitada) {
		this.lineaInvitada = lineaInvitada;
	}
	/**
	 * @return the mensualidades
	 */
	public String getMensualidades() {
		return mensualidades;
	}
	/**
	 * @param mensualidades the mensualidades to set
	 */
	public void setMensualidades(String mensualidades) {
		this.mensualidades = mensualidades;
	}
	/**
	 * @param tasaIntAn the tasaIntAn to set
	 */
	public void setTasaIntAn(String tasaIntAn) {
		this.tasaIntAn = tasaIntAn;
	}
	/**
	 * @return the tasaIntAn
	 */
	public String getTasaIntAn() {
		return tasaIntAn;
	}
	/**
	 * @return the catSinIva
	 */
	public String getCatSinIva() {
		return catSinIva;
	}
	/**
	 * @param catSinIva the catSinIva to set
	 */
	public void setCatSinIva(String catSinIva) {
		this.catSinIva = catSinIva;
	}
	
	
	
}
