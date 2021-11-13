package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class ArchivoDiaCargaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String file;
	
	public ArchivoDiaCargaDTO() {}
	
	public ArchivoDiaCargaDTO(String file) {
		super();
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	
	
}
