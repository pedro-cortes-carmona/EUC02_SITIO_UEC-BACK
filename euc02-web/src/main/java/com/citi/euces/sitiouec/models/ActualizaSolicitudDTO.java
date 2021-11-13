package com.citi.euces.sitiouec.models;

/**
 * DTO para actualizar la fecha Proceso y el SOEID Proceso
 * de quien toma una solicitud en el revolver
 * @author cesar.alducin
 *
 */
public class ActualizaSolicitudDTO {
	
	private String soeidOpe;
	
	private String idTasaAuto;
	
	public ActualizaSolicitudDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getSoeidOpe() {
		return soeidOpe;
	}

	public void setSoeidOpe(String soeidOpe) {
		this.soeidOpe = soeidOpe;
	}

	public String getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(String idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	public ActualizaSolicitudDTO(String soeidOpe, String idTasaAuto) {
		super();
		this.soeidOpe = soeidOpe;
		this.idTasaAuto = idTasaAuto;
	}
	
	

}
