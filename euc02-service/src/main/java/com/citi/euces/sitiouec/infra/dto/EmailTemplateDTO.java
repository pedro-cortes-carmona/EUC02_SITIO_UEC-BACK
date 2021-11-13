package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class EmailTemplateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String soeidEnc;
	private String informeEnc;
	private String titleEnc;
	private String acountEnc;

	public String getSoeidEnc() {
		return soeidEnc;
	}

	public void setSoeidEnc(String soeidEnc) {
		this.soeidEnc = soeidEnc;
	}

	public String getInformeEnc() {
		return informeEnc;
	}

	public void setInformeEnc(String informeEnc) {
		this.informeEnc = informeEnc;
	}

	public String getTitleEnc() {
		return titleEnc;
	}

	public void setTitleEnc(String titleEnc) {
		this.titleEnc = titleEnc;
	}

	public String getAcountEnc() {
		return acountEnc;
	}

	public void setAcountEnc(String acountEnc) {
		this.acountEnc = acountEnc;
	}

}
