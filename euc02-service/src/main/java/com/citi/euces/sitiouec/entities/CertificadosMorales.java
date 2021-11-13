package com.citi.euces.sitiouec.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_CERTIFICADOS_Morales")
public class CertificadosMorales implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOLIO")
	private String folio;

	@Column(name = "NUM_CTE")
	private String numCte;

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getNumCte() {
		return numCte;
	}

	public void setNumCte(String numCte) {
		this.numCte = numCte;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
