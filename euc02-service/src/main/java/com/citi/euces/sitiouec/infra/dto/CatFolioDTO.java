package com.citi.euces.sitiouec.infra.dto;

public class CatFolioDTO {

	private String folioValor;
	private String folioEspecialOfertaId;
	private Long folioIdCliente;
	private Integer folioEstatus;
	/**
	 * 
	 */
	public CatFolioDTO() {
		super();
	}
	
	/**
	 * @param folioId
	 * @param folioValor
	 * @param folioEspecialOfertaId
	 * @param folioIdCliente
	 * @param folioEstatus
	 */
	public CatFolioDTO(String folioValor, String folioEspecialOfertaId, Long folioIdCliente,
			Integer folioEstatus) {
		super();
		this.folioValor = folioValor;
		this.folioEspecialOfertaId = folioEspecialOfertaId;
		this.folioIdCliente = folioIdCliente;
		this.folioEstatus = folioEstatus;
	}
	
	/**
	 * @return the folioValor
	 */
	public String getFolioValor() {
		return folioValor;
	}

	/**
	 * @param folioValor the folioValor to set
	 */
	public void setFolioValor(String folioValor) {
		this.folioValor = folioValor;
	}

	/**
	 * @return the folioEspecialOfertaId
	 */
	public String getFolioEspecialOfertaId() {
		return folioEspecialOfertaId;
	}

	/**
	 * @param folioEspecialOfertaId the folioEspecialOfertaId to set
	 */
	public void setFolioEspecialOfertaId(String folioEspecialOfertaId) {
		this.folioEspecialOfertaId = folioEspecialOfertaId;
	}

	/**
	 * @return the folioIdCliente
	 */
	public Long getFolioIdCliente() {
		return folioIdCliente;
	}
	/**
	 * @param folioIdCliente the folioIdCliente to set
	 */
	public void setFolioIdCliente(Long folioIdCliente) {
		this.folioIdCliente = folioIdCliente;
	}
	/**
	 * @return the folioEstatus
	 */
	public Integer getFolioEstatus() {
		return folioEstatus;
	}
	/**
	 * @param folioEstatus the folioEstatus to set
	 */
	public void setFolioEstatus(Integer folioEstatus) {
		this.folioEstatus = folioEstatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CatFolioDTO [folioValor=");
		builder.append(folioValor);
		builder.append(", folioEspecialOfertaId=");
		builder.append(folioEspecialOfertaId);
		builder.append(", folioIdCliente=");
		builder.append(folioIdCliente);
		builder.append(", folioEstatus=");
		builder.append(folioEstatus);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
