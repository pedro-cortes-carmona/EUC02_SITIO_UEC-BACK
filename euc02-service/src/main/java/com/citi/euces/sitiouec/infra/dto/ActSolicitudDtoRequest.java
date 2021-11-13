package com.citi.euces.sitiouec.infra.dto;


public class ActSolicitudDtoRequest {
	
	
	private Long tasaId; 
	private String soeId;
	private String nuevoEstado;
	private String causaRechazo;
	/**
	 * 
	 */
	public ActSolicitudDtoRequest() {
		super();
	}
	/**
	 * @return the tasaId
	 */
	public Long getTasaId() {
		return tasaId;
	}
	/**
	 * @param tasaId the tasaId to set
	 */
	public void setTasaId(Long tasaId) {
		this.tasaId = tasaId;
	}
	/**
	 * @return the soeId
	 */
	public String getSoeId() {
		return soeId;
	}
	/**
	 * @param soeId the soeId to set
	 */
	public void setSoeId(String soeId) {
		this.soeId = soeId;
	}
	/**
	 * @return the nuevoEstado
	 */
	public String getNuevoEstado() {
		return nuevoEstado;
	}
	/**
	 * @param nuevoEstado the nuevoEstado to set
	 */
	public void setNuevoEstado(String nuevoEstado) {
		this.nuevoEstado = nuevoEstado;
	}
	/**
	 * @return the causaRechazo
	 */
	public String getCausaRechazo() {
		return causaRechazo;
	}
	/**
	 * @param causaRechazo the causaRechazo to set
	 */
	public void setCausaRechazo(String causaRechazo) {
		this.causaRechazo = causaRechazo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActSolicitudDtoRequest [tasaId=").append(tasaId).append(", soeId=").append(soeId)
				.append(", nuevoEstado=").append(nuevoEstado).append(", causaRechazo=").append(causaRechazo)
				.append("]");
		return builder.toString();
	}

	
}
