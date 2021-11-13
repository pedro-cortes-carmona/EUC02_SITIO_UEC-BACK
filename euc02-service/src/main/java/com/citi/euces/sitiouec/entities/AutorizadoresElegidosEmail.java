package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author cesar.alducin Entidad que se utiliza para mappear la tabla
 *         UEC_Catalogo_Autorizadores2021
 */
@Entity
@Table(name = "UEC_TB_AUTORIZADORES_ELEGIDOS")
public class AutorizadoresElegidosEmail {

	@Id
	@Column(name = "ID_TASAUTO", nullable = true)
	private Long idTasaAuto;

	@Column(name = "AUTORIZADORES", nullable = true)
	private String autorizadores;

	public AutorizadoresElegidosEmail() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	public String getAutorizadores() {
		return autorizadores;
	}

	public void setAutorizadores(String autorizadores) {
		this.autorizadores = autorizadores;
	}

	@Override
	public String toString() {
		return "AutorizadoresElegidosEmail [idTasaAuto=" + idTasaAuto + ", autorizadores=" + autorizadores + "]";
	}

}
