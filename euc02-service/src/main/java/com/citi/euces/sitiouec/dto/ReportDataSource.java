package com.citi.euces.sitiouec.dto;

import java.util.List;

public class ReportDataSource {
	
	private List<SucursalGerenciaResponseDTO> ListaVistaDivisiones;
	private List<SucursalGerenciaResponseDTO> ListaVistaRegiones;
	private List<SucursalGerenciaResponseDTO> ListaVistaMercado;
    private List<SucursalGerenciaResponseDTO> ListaVistaSucursales;
    private List<SucursalGerenciaResponseSumaDTO> listaresultados;
	public ReportDataSource(List<SucursalGerenciaResponseDTO> listaVistaDivisiones,
			List<SucursalGerenciaResponseDTO> listaVistaRegiones, List<SucursalGerenciaResponseDTO> listaVistaMercado,
			List<SucursalGerenciaResponseDTO> listaVistaSucursales, List<SucursalGerenciaResponseSumaDTO> listaresultados) {
		super();
		ListaVistaDivisiones = listaVistaDivisiones;
		ListaVistaRegiones = listaVistaRegiones;
		ListaVistaMercado = listaVistaMercado;
		ListaVistaSucursales = listaVistaSucursales;
		this.listaresultados = listaresultados;
	}
	public List<SucursalGerenciaResponseDTO> getListaVistaDivisiones() {
		return ListaVistaDivisiones;
	}
	public void setListaVistaDivisiones(List<SucursalGerenciaResponseDTO> listaVistaDivisiones) {
		ListaVistaDivisiones = listaVistaDivisiones;
	}
	public List<SucursalGerenciaResponseDTO> getListaVistaRegiones() {
		return ListaVistaRegiones;
	}
	public void setListaVistaRegiones(List<SucursalGerenciaResponseDTO> listaVistaRegiones) {
		ListaVistaRegiones = listaVistaRegiones;
	}
	public List<SucursalGerenciaResponseDTO> getListaVistaMercado() {
		return ListaVistaMercado;
	}
	public void setListaVistaMercado(List<SucursalGerenciaResponseDTO> listaVistaMercado) {
		ListaVistaMercado = listaVistaMercado;
	}
	public List<SucursalGerenciaResponseDTO> getListaVistaSucursales() {
		return ListaVistaSucursales;
	}
	public void setListaVistaSucursales(List<SucursalGerenciaResponseDTO> listaVistaSucursales) {
		ListaVistaSucursales = listaVistaSucursales;
	}
	public List<SucursalGerenciaResponseSumaDTO> getListaresultados() {
		return listaresultados;
	}
	public void setListaresultados(List<SucursalGerenciaResponseSumaDTO> listaresultados) {
		this.listaresultados = listaresultados;
	}
    
    
	
   
	
    

}
