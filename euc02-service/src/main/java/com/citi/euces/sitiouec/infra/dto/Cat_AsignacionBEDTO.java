package com.citi.euces.sitiouec.infra.dto;

import java.io.Serializable;

public class Cat_AsignacionBEDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String soeid;
    private int online;
    
    
	/**
	 * @param sOEID
	 * @param online
	 */
	public Cat_AsignacionBEDTO(String soeid, int online) {
		this.soeid = soeid;
		this.online = online;
	}


	/**
	 * 
	 */
	public Cat_AsignacionBEDTO() {
	}


	/**
	 * @return the soeid
	 */
	public String getSoeid() {
		return soeid;
	}


	/**
	 * @param soeid the soeid to set
	 */
	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}


	/**
	 * @return the online
	 */
	public int getOnline() {
		return online;
	}


	/**
	 * @param online the online to set
	 */
	public void setOnline(int online) {
		this.online = online;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cat_AsignacionBEDTO [soeid=");
		builder.append(soeid);
		builder.append(", online=");
		builder.append(online);
		builder.append("]");
		return builder.toString();
	}
    
	
    
}
