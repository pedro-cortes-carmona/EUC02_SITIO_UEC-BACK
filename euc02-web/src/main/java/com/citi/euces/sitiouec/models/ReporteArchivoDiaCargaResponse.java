package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import com.citi.euces.sitiouec.infra.dto.ArchivoDiaCargaDTO;

public class ReporteArchivoDiaCargaResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArchivoDiaCargaDTO file;
	private String code;
	
	public ReporteArchivoDiaCargaResponse() {}
	
	public ReporteArchivoDiaCargaResponse(ArchivoDiaCargaDTO file, String code) {
		super();
		this.file = file;
		this.code = code;
	}
	public ArchivoDiaCargaDTO getFile() {
		return file;
	}
	public void setFile(ArchivoDiaCargaDTO file) {
		this.file = file;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
