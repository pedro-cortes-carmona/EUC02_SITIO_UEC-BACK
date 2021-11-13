package com.citi.euces.sitiouec.models;

import java.io.Serializable;
import java.util.List;

import com.citi.euces.sitiouec.infra.dto.AutoAutorizadorBEDTO;

public class EmailTemplateSolTarifasRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String listAurotizadores;
	private String folio;
	private String linkAutoriza;
	private String linkRechaza;
	private String urlRedirect;
    private List<AutoAutorizadorBEDTO> listadoAutorizadores;
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

	public List<AutoAutorizadorBEDTO> getListadoAutorizadores() {
		return listadoAutorizadores;
	}

	public void setListadoAutorizadores(List<AutoAutorizadorBEDTO> listadoAutorizadores) {
		this.listadoAutorizadores = listadoAutorizadores;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailTemplateSolTarifasRequest [listAurotizadores=");
		builder.append(listAurotizadores);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", linkAutoriza=");
		builder.append(linkAutoriza);
		builder.append(", linkRechaza=");
		builder.append(linkRechaza);
		builder.append(", urlRedirect=");
		builder.append(urlRedirect);
		builder.append(", listadoAutorizadores=");
		builder.append(listadoAutorizadores);
		builder.append(", idAutorizadores=");
		builder.append(idAutorizadores);
		builder.append("]");
		return builder.toString();
	}
	
	
}
