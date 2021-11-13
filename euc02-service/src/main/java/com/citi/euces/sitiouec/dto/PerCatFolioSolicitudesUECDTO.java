package com.citi.euces.sitiouec.dto;

public class PerCatFolioSolicitudesUECDTO {

	private String pdfFolioValor;

	private String pdfFolioEspecialOferta;

	private Long pdfFolioIdCliente;

	private Long pdfFolioEstatus;

	public PerCatFolioSolicitudesUECDTO() {
		
	}

	public PerCatFolioSolicitudesUECDTO(String pdfFolioValor, String pdfFolioEspecialOferta, Long pdfFolioIdCliente,
			Long pdfFolioEstatus) {
		super();
		this.pdfFolioValor = pdfFolioValor;
		this.pdfFolioEspecialOferta = pdfFolioEspecialOferta;
		this.pdfFolioIdCliente = pdfFolioIdCliente;
		this.pdfFolioEstatus = pdfFolioEstatus;
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
		return "PerCatFolioSolicitudesUECDTO [pdfFolioValor=" + pdfFolioValor + ", pdfFolioEspecialOferta="
				+ pdfFolioEspecialOferta + ", pdfFolioIdCliente=" + pdfFolioIdCliente + ", pdfFolioEstatus="
				+ pdfFolioEstatus + "]";
	}

}
