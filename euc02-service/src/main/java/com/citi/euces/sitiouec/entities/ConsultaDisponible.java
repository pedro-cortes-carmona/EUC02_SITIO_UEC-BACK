package com.citi.euces.sitiouec.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the CONSULTA_DISPONIBLE database table.
 * @author lbermejo
 * 
 */
@Entity
@Table(name="PDI_CONSULTA_DISPONIBLE") //TSC_EUCS_OWN
public class ConsultaDisponible implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private ConsultaDisponibleIdentity id;

	@Column(name="CAT_SIN_IVA")
	private String catSinIva;

	@Column(name="DB_PROMO")
	private String dbPromo;

	@Column(name="LINEA_INVITADA")
	private Double lineaInvitada;
	
	@Column(name="MENSUALIDADES")
	private String mensualidades;
	
	@Column(name="PRODUCTO")
	private String producto;

	@Column(name="TASA_ANUAL")
	private String tasaAnual;

	@Column(name="VIGENCIA")
	private String vigencia;
	
	/**
	 * @return the id
	 */
	public ConsultaDisponibleIdentity getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ConsultaDisponibleIdentity id) {
		this.id = id;
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

	/**
	 * @return the dbPromo
	 */
	public String getDbPromo() {
		return dbPromo;
	}

	/**
	 * @param dbPromo the dbPromo to set
	 */
	public void setDbPromo(String dbPromo) {
		this.dbPromo = dbPromo;
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
	 * @return the tasaAnual
	 */
	public String getTasaAnual() {
		return tasaAnual;
	}

	/**
	 * @param tasaAnual the tasaAnual to set
	 */
	public void setTasaAnual(String tasaAnual) {
		this.tasaAnual = tasaAnual;
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

}