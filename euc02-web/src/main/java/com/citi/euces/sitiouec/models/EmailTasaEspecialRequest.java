package com.citi.euces.sitiouec.models;

import java.io.Serializable;

public class EmailTasaEspecialRequest implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private String listAurotizadores;
	private String folio;
	private String linkAutoriza;
	private String linkRechaza;
	private String urlRedirect;
	private String idAutorizadores;

	public String getListAurotizadores() {
		return listAurotizadores;
	}

	public void setListAurotizadores(String listAurotizadores) {
		this.listAurotizadores = listAurotizadores;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getLinkAutoriza() {
		return linkAutoriza;
	}

	public void setLinkAutoriza(String linkAutoriza) {
		this.linkAutoriza = linkAutoriza;
	}

	public String getLinkRechaza() {
		return linkRechaza;
	}

	public void setLinkRechaza(String linkRechaza) {
		this.linkRechaza = linkRechaza;
	}

	public String getUrlRedirect() { return urlRedirect; }

	public void setUrlRedirect(String urlRedirect) { this.urlRedirect = urlRedirect; }

	public String getIdAutorizadores() { return idAutorizadores; }

	public void setIdAutorizadores(String idAutorizadores) { this.idAutorizadores = idAutorizadores; }

	@Override
	public String toString() {
		return "EmailTasaEspecialRequest{" +
				"listAurotizadores='" + listAurotizadores + '\'' +
				", folio='" + folio + '\'' +
				", linkAutoriza='" + linkAutoriza + '\'' +
				", linkRechaza='" + linkRechaza + '\'' +
				", urlRedirect='" + urlRedirect + '\'' +
				", idAutorizadores='" + idAutorizadores + '\'' +
				'}';
	}

}
