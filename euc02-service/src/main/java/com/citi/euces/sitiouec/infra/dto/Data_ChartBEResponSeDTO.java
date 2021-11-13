package com.citi.euces.sitiouec.infra.dto;

public class Data_ChartBEResponSeDTO {
	
	private String Label;
	private double Value;
	public Data_ChartBEResponSeDTO(String label, double value) {
		super();
		Label = label;
		Value = value;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public double getValue() {
		return Value;
	}
	public void setValue(double value) {
		Value = value;
	}

	
	

}
