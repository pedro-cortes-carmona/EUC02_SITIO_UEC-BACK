package com.citi.euces.sitiouec.dto;

public class ReporteDivisionesBEResponseDTO {
	
	 private String RK;
     private String division;
     private String num_ejecutivos;
     private String num_ventas;
     private String importe;
     private String per_capita;
     private String promedio;
     private String suc_sin_ventas;

     private String camp1_num_ventas;
     private String camp1_importe;

     private String camp2_num_ventas;
     private String camp2_importe;

     private String camp3_num_ventas;
     private String camp3_importe;

     private String camp4_num_ventas;
     private String camp4_importe;

     private String camp5_num_ventas;
     private String camp5_importe;
	public ReporteDivisionesBEResponseDTO(String rK, String division, String num_ejecutivos, String num_ventas,
			String importe, String per_capita, String promedio, String suc_sin_ventas, String camp1_num_ventas,
			String camp1_importe, String camp2_num_ventas, String camp2_importe, String camp3_num_ventas,
			String camp3_importe, String camp4_num_ventas, String camp4_importe, String camp5_num_ventas,
			String camp5_importe) {
		super();
		RK = rK;
		this.division = division;
		this.num_ejecutivos = num_ejecutivos;
		this.num_ventas = num_ventas;
		this.importe = importe;
		this.per_capita = per_capita;
		this.promedio = promedio;
		this.suc_sin_ventas = suc_sin_ventas;
		this.camp1_num_ventas = camp1_num_ventas;
		this.camp1_importe = camp1_importe;
		this.camp2_num_ventas = camp2_num_ventas;
		this.camp2_importe = camp2_importe;
		this.camp3_num_ventas = camp3_num_ventas;
		this.camp3_importe = camp3_importe;
		this.camp4_num_ventas = camp4_num_ventas;
		this.camp4_importe = camp4_importe;
		this.camp5_num_ventas = camp5_num_ventas;
		this.camp5_importe = camp5_importe;
	}
	public String getRK() {
		return RK;
	}
	public void setRK(String rK) {
		RK = rK;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getNum_ejecutivos() {
		return num_ejecutivos;
	}
	public void setNum_ejecutivos(String num_ejecutivos) {
		this.num_ejecutivos = num_ejecutivos;
	}
	public String getNum_ventas() {
		return num_ventas;
	}
	public void setNum_ventas(String num_ventas) {
		this.num_ventas = num_ventas;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getPer_capita() {
		return per_capita;
	}
	public void setPer_capita(String per_capita) {
		this.per_capita = per_capita;
	}
	public String getPromedio() {
		return promedio;
	}
	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}
	public String getSuc_sin_ventas() {
		return suc_sin_ventas;
	}
	public void setSuc_sin_ventas(String suc_sin_ventas) {
		this.suc_sin_ventas = suc_sin_ventas;
	}
	public String getCamp1_num_ventas() {
		return camp1_num_ventas;
	}
	public void setCamp1_num_ventas(String camp1_num_ventas) {
		this.camp1_num_ventas = camp1_num_ventas;
	}
	public String getCamp1_importe() {
		return camp1_importe;
	}
	public void setCamp1_importe(String camp1_importe) {
		this.camp1_importe = camp1_importe;
	}
	public String getCamp2_num_ventas() {
		return camp2_num_ventas;
	}
	public void setCamp2_num_ventas(String camp2_num_ventas) {
		this.camp2_num_ventas = camp2_num_ventas;
	}
	public String getCamp2_importe() {
		return camp2_importe;
	}
	public void setCamp2_importe(String camp2_importe) {
		this.camp2_importe = camp2_importe;
	}
	public String getCamp3_num_ventas() {
		return camp3_num_ventas;
	}
	public void setCamp3_num_ventas(String camp3_num_ventas) {
		this.camp3_num_ventas = camp3_num_ventas;
	}
	public String getCamp3_importe() {
		return camp3_importe;
	}
	public void setCamp3_importe(String camp3_importe) {
		this.camp3_importe = camp3_importe;
	}
	public String getCamp4_num_ventas() {
		return camp4_num_ventas;
	}
	public void setCamp4_num_ventas(String camp4_num_ventas) {
		this.camp4_num_ventas = camp4_num_ventas;
	}
	public String getCamp4_importe() {
		return camp4_importe;
	}
	public void setCamp4_importe(String camp4_importe) {
		this.camp4_importe = camp4_importe;
	}
	public String getCamp5_num_ventas() {
		return camp5_num_ventas;
	}
	public void setCamp5_num_ventas(String camp5_num_ventas) {
		this.camp5_num_ventas = camp5_num_ventas;
	}
	public String getCamp5_importe() {
		return camp5_importe;
	}
	public void setCamp5_importe(String camp5_importe) {
		this.camp5_importe = camp5_importe;
	}
     
     

}
