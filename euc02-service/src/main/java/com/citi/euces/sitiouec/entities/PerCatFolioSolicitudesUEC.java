package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_FOLIO") // TSC_EUCS_OWN
public class PerCatFolioSolicitudesUEC {

	@Id
	@Column(name = "PDF_FOLIO_VALOR", nullable = true)
	private String pdfFolioValor;

	@Column(name = "PDF_FOLIO_ESPECIAL_OFERTA_ID", nullable = true)
	private String pdfFolioEspecialOferta;

	@Column(name = "PDF_FOLIO_ID_CLIENTE", nullable = true)
	private Long pdfFolioIdCliente;

	@Column(name = "PDF_FOLIO_ESTATUS", nullable = true)
	private Long pdfFolioEstatus;

	public PerCatFolioSolicitudesUEC() {
		// TODO Auto-generated constructor stub
	}

	public String getPdfFolioValor() {
		return pdfFolioValor;
	}

	public void setPdfFolioValor(String pdfFolioValor) {
		this.pdfFolioValor = pdfFolioValor;
	}

	public String getPdfFolioEspecialOferta() {
		return pdfFolioEspecialOferta;
	}

	public void setPdfFolioEspecialOferta(String pdfFolioEspecialOferta) {
		this.pdfFolioEspecialOferta = pdfFolioEspecialOferta;
	}

	public Long getPdfFolioIdCliente() {
		return pdfFolioIdCliente;
	}

	public void setPdfFolioIdCliente(Long pdfFolioIdCliente) {
		this.pdfFolioIdCliente = pdfFolioIdCliente;
	}

	public Long getPdfFolioEstatus() {
		return pdfFolioEstatus;
	}

	public void setPdfFolioEstatus(Long pdfFolioEstatus) {
		this.pdfFolioEstatus = pdfFolioEstatus;
	}

	@Override
	public String toString() {
		return "PerCatFolioSolicitudesUEC [pdfFolioValor=" + pdfFolioValor + ", pdfFolioEspecialOferta="
				+ pdfFolioEspecialOferta + ", pdfFolioIdCliente=" + pdfFolioIdCliente + ", pdfFolioEstatus="
				+ pdfFolioEstatus + "]";
	}

}
