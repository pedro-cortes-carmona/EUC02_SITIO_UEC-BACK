package com.citi.euces.sitiouec.dto;

public class ActualizarSolicitudKPIDTO {

	private Long idTasaAuto;

	private String soeidAsig;

	private String soeidProc;

	private String soeidOpe;
	

	public ActualizarSolicitudKPIDTO() {
		
	}

	public ActualizarSolicitudKPIDTO(Long idTasaAuto, String soeidAsig, String soeidProc, String soeidOpe) {
		super();
		this.idTasaAuto = idTasaAuto;
		this.soeidAsig = soeidAsig;
		this.soeidProc = soeidProc;
		this.soeidOpe = soeidOpe;
	}

	public Long getIdTasaAuto() {
		return idTasaAuto;
	}

	public void setIdTasaAuto(Long idTasaAuto) {
		this.idTasaAuto = idTasaAuto;
	}

	public String getSoeidAsig() {
		return soeidAsig;
	}

	public void setSoeidAsig(String soeidAsig) {
		this.soeidAsig = soeidAsig;
	}

	public String getSoeidProc() {
		return soeidProc;
	}

	public void setSoeidProc(String soeidProc) {
		this.soeidProc = soeidProc;
	}

	public String getSoeidOpe() {
		return soeidOpe;
	}

	public void setSoeidOpe(String soeidOpe) {
		this.soeidOpe = soeidOpe;
	}

	@Override
	public String toString() {
		return "ActualizarSolicitudKPIDTO [idTasaAuto=" + idTasaAuto + ", soeidAsig=" + soeidAsig + ", soeidProc="
				+ soeidProc + ", soeidOpe=" + soeidOpe + "]";
	}

}
