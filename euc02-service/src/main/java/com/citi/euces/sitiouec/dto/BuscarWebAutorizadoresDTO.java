package com.citi.euces.sitiouec.dto;

public class BuscarWebAutorizadoresDTO {
	
	private String soeid;
	
	private String division;

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
		return "BuscarWebAutorizadoresDTO[soeid="+soeid+", division="+division+"]";
	}
		

}
