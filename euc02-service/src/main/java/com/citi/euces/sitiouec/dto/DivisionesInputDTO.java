package com.citi.euces.sitiouec.dto;

public class DivisionesInputDTO {

	private String soeid;
	private String division;

	public DivisionesInputDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getSoeid() {
		return soeid;
	}

	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Override
	public String toString() {
		return "DivisionesInputDTO [soeid=" + soeid + ", division=" + division + "]";
	}

}
