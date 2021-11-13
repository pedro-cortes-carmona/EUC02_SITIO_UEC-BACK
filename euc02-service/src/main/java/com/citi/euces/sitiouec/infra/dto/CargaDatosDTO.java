package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class CargaDatosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private String mensajeInfo;
    private String mensajeConfirm;
    private String fecha;
    private Integer numRegTasas;
    private Integer numRegAcum;
    
    public CargaDatosDTO() {
    }
    
    public CargaDatosDTO(String mensajeInfo, String mensajeConfirm, String fecha, Integer numRegTasas,
			Integer numRegAcum) {
		super();
		this.mensajeInfo = mensajeInfo;
		this.mensajeConfirm = mensajeConfirm;
		this.fecha = fecha;
		this.numRegTasas = numRegTasas;
		this.numRegAcum = numRegAcum;
	}

	public String getFecha() {
		return fecha;
	}
    
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getNumRegTasas() {
		return numRegTasas;
	}

	public void setNumRegTasas(Integer numRegTasas) {
		this.numRegTasas = numRegTasas;
	}

	public Integer getNumRegAcum() {
		return numRegAcum;
	}

	public void setNumRegAcum(Integer numRegAcum) {
		this.numRegAcum = numRegAcum;
	}

	public String getMensajeInfo() {
        return mensajeInfo;
    }

    public void setMensajeInfo(String mensajeInfo) {
        this.mensajeInfo = mensajeInfo;
    }

    public String getMensajeConfirm() {
        return mensajeConfirm;
    }

    public void setMensajeConfirm(String mensajeConfirm) {
        this.mensajeConfirm = mensajeConfirm;
    }
}
