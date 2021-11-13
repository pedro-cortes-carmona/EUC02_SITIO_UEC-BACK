package com.citi.euces.sitiouec.dto;

public class ListaUsuariosSoeidDTO {

	private String soeidOpe;
	
	private String nombre;

	
	public ListaUsuariosSoeidDTO() {
		// TODO Auto-generated constructor stub
	}

	public ListaUsuariosSoeidDTO(String soeidOpe) {
		super();
		this.soeidOpe = soeidOpe;
	}

	public String getSoeidOpe() {
		return soeidOpe;
	}

	public void setSoeidOpe(String soeidOpe) {
		this.soeidOpe = soeidOpe;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
