package com.citi.euces.sitiouec.infra.dto;

import java.util.Date;

public class AutoAutorizadorBEDTO {
	
	 public String SOEID;     
     public String SOEID_Divisional;     
     public String SOEID_Regional;     
     public String Division;     
     public String Region;
     public String distrito;
     public String Nombre;
     public String Inic;     
     public String Tipo;
     public int Alta;
     public String Correo;
     public int Is_Cete100;
     public int Is_CampEsp;

     public Date Fecha_Inicio;
     public Date Fecha_Termino;
    
     public String Inic2;
     public String Inic3;
     public String Tipo2;
     public String Tipo3;

     public int id_nivel_auto;

	public AutoAutorizadorBEDTO() {
	}

	
	/**
	 * @param sOEID
	 * @param division
	 * @param nombre
	 * @param inic
	 * @param alta
	 * @param correo
	 * @param fecha_Inicio
	 * @param fecha_Termino
	 * @param id_nivel_auto
	 */
	public AutoAutorizadorBEDTO(String sOEID, String division, String nombre, String inic,
			Date fecha_Inicio, Date fecha_Termino, int alta, int id_nivel_auto, String correo) {
		SOEID = sOEID;
		Division = division;
		Nombre = nombre;
		Inic = inic;
		Alta = alta;
		Correo = correo;
		Fecha_Inicio = fecha_Inicio;
		Fecha_Termino = fecha_Termino;
		this.id_nivel_auto = id_nivel_auto;
	}


	/**
	 * @param sOEID
	 * @param nombre
	 */
	public AutoAutorizadorBEDTO(String sOEID, String nombre) {
		SOEID = sOEID;
		Nombre = nombre;
	}

	/**
	 * @param sOEID
	 * @param nombre
	 * @param correo
	 */
	public AutoAutorizadorBEDTO( String nombre, String sOEID, String correo) {
		Nombre = nombre;
		SOEID = sOEID;
		Correo = correo;
	}

	/**
	 * @return the sOEID
	 */
	public String getSOEID() {
		return SOEID;
	}

	/**
	 * @param sOEID the sOEID to set
	 */
	public void setSOEID(String sOEID) {
		SOEID = sOEID;
	}

	/**
	 * @return the sOEID_Divisional
	 */
	public String getSOEID_Divisional() {
		return SOEID_Divisional;
	}

	/**
	 * @param sOEID_Divisional the sOEID_Divisional to set
	 */
	public void setSOEID_Divisional(String sOEID_Divisional) {
		SOEID_Divisional = sOEID_Divisional;
	}

	/**
	 * @return the sOEID_Regional
	 */
	public String getSOEID_Regional() {
		return SOEID_Regional;
	}

	/**
	 * @param sOEID_Regional the sOEID_Regional to set
	 */
	public void setSOEID_Regional(String sOEID_Regional) {
		SOEID_Regional = sOEID_Regional;
	}

	/**
	 * @return the division
	 */
	public String getDivision() {
		return Division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		Division = division;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return Region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		Region = region;
	}

	/**
	 * @return the distrito
	 */
	public String getDistrito() {
		return distrito;
	}

	/**
	 * @param distrito the distrito to set
	 */
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * @return the inic
	 */
	public String getInic() {
		return Inic;
	}

	/**
	 * @param inic the inic to set
	 */
	public void setInic(String inic) {
		Inic = inic;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return Tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	/**
	 * @return the alta
	 */
	public int getAlta() {
		return Alta;
	}

	/**
	 * @param alta the alta to set
	 */
	public void setAlta(int alta) {
		Alta = alta;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return Correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		Correo = correo;
	}

	/**
	 * @return the is_Cete100
	 */
	public int getIs_Cete100() {
		return Is_Cete100;
	}

	/**
	 * @param is_Cete100 the is_Cete100 to set
	 */
	public void setIs_Cete100(int is_Cete100) {
		Is_Cete100 = is_Cete100;
	}

	/**
	 * @return the is_CampEsp
	 */
	public int getIs_CampEsp() {
		return Is_CampEsp;
	}

	/**
	 * @param is_CampEsp the is_CampEsp to set
	 */
	public void setIs_CampEsp(int is_CampEsp) {
		Is_CampEsp = is_CampEsp;
	}

	/**
	 * @return the fecha_Inicio
	 */
	public Date getFecha_Inicio() {
		return Fecha_Inicio;
	}

	/**
	 * @param fecha_Inicio the fecha_Inicio to set
	 */
	public void setFecha_Inicio(Date fecha_Inicio) {
		Fecha_Inicio = fecha_Inicio;
	}

	/**
	 * @return the fecha_Termino
	 */
	public Date getFecha_Termino() {
		return Fecha_Termino;
	}

	/**
	 * @param fecha_Termino the fecha_Termino to set
	 */
	public void setFecha_Termino(Date fecha_Termino) {
		Fecha_Termino = fecha_Termino;
	}

	/**
	 * @return the inic2
	 */
	public String getInic2() {
		return Inic2;
	}

	/**
	 * @param inic2 the inic2 to set
	 */
	public void setInic2(String inic2) {
		Inic2 = inic2;
	}

	/**
	 * @return the inic3
	 */
	public String getInic3() {
		return Inic3;
	}

	/**
	 * @param inic3 the inic3 to set
	 */
	public void setInic3(String inic3) {
		Inic3 = inic3;
	}

	/**
	 * @return the tipo2
	 */
	public String getTipo2() {
		return Tipo2;
	}

	/**
	 * @param tipo2 the tipo2 to set
	 */
	public void setTipo2(String tipo2) {
		Tipo2 = tipo2;
	}

	/**
	 * @return the tipo3
	 */
	public String getTipo3() {
		return Tipo3;
	}

	/**
	 * @param tipo3 the tipo3 to set
	 */
	public void setTipo3(String tipo3) {
		Tipo3 = tipo3;
	}

	/**
	 * @return the id_nivel_auto
	 */
	public int getId_nivel_auto() {
		return id_nivel_auto;
	}

	/**
	 * @param id_nivel_auto the id_nivel_auto to set
	 */
	public void setId_nivel_auto(int id_nivel_auto) {
		this.id_nivel_auto = id_nivel_auto;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AutoAutorizadorBEDTO [SOEID=");
		builder.append(SOEID);
		builder.append(", SOEID_Divisional=");
		builder.append(SOEID_Divisional);
		builder.append(", SOEID_Regional=");
		builder.append(SOEID_Regional);
		builder.append(", Division=");
		builder.append(Division);
		builder.append(", Region=");
		builder.append(Region);
		builder.append(", distrito=");
		builder.append(distrito);
		builder.append(", Nombre=");
		builder.append(Nombre);
		builder.append(", Inic=");
		builder.append(Inic);
		builder.append(", Tipo=");
		builder.append(Tipo);
		builder.append(", Alta=");
		builder.append(Alta);
		builder.append(", Correo=");
		builder.append(Correo);
		builder.append(", Is_Cete100=");
		builder.append(Is_Cete100);
		builder.append(", Is_CampEsp=");
		builder.append(Is_CampEsp);
		builder.append(", Fecha_Inicio=");
		builder.append(Fecha_Inicio);
		builder.append(", Fecha_Termino=");
		builder.append(Fecha_Termino);
		builder.append(", Inic2=");
		builder.append(Inic2);
		builder.append(", Inic3=");
		builder.append(Inic3);
		builder.append(", Tipo2=");
		builder.append(Tipo2);
		builder.append(", Tipo3=");
		builder.append(Tipo3);
		builder.append(", id_nivel_auto=");
		builder.append(id_nivel_auto);
		builder.append("]");
		return builder.toString();
	}

	
}
