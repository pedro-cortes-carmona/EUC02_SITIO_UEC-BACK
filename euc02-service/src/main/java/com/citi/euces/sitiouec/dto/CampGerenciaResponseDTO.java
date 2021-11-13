package com.citi.euces.sitiouec.dto;


public class CampGerenciaResponseDTO {
	
	private String Id_Camp;
	private String Campana;
	private String Activo;
	/**
	 * 
	 */
	public CampGerenciaResponseDTO() {
		super();
	}
	/**
	 * @param id_Camp
	 * @param campana
	 * @param activo
	 */
	public CampGerenciaResponseDTO(String id_Camp, String campana, String activo) {
		super();
		Id_Camp = id_Camp;
		Campana = campana;
		Activo = activo;
	}
	public String getId_Camp() {
		return Id_Camp;
	}
	public void setId_Camp(String id_Camp) {
		Id_Camp = id_Camp;
	}
	public String getCampana() {
		return Campana;
	}
	public void setCampana(String campana) {
		Campana = campana;
	}
	public String getActivo() {
		return Activo;
	}
	public void setActivo(String activo) {
		Activo = activo;
	}
	
	
	
	

}
