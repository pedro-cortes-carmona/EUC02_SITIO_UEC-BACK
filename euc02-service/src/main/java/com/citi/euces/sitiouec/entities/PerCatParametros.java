package com.citi.euces.sitiouec.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_PARAMETROS") // TSC_EUCS_OWN
public class PerCatParametros {

	@Id
	@Column(name = "PARAMETRO_ID", nullable = true)
	private Long idParametro;

	@Column(name = "PARAMETRO_NOM", nullable = true)
	private String parametroNom;

	@Column(name = "PARAMETRO_TIPO", nullable = true)
	private String parametroTipo;

	@Column(name = "PARAMETRO_FORMATO", nullable = true)
	private String parametroFormato;

	@Column(name = "PARAMETRO_VALOR", nullable = true)
	private String parametroValor;

	@Column(name = "PARAMETRO_ESTATUS", nullable = true)
	private int parametroEstatus;

	@Column(name = "PARAMETRO_ESTATUS_FEC", nullable = true)
	private Date paraEstatusFec;

	@Column(name = "PARAMETRO_MASIVO_TITULO", nullable = true)
	private String parametroMasivoTitulo;

	@Column(name = "PARAMETRO_MASIVO_DESCRIPCION", nullable = true)
	private String parametroMasivoDescripcion;
	

	public PerCatParametros() {
		// TODO Auto-generated constructor stub
	}

	public PerCatParametros(Long idParametro, String parametroNom, String parametroTipo, String parametroFormato,
			String parametroValor, int parametroEstatus, Date paraEstatusFec, String parametroMasivoTitulo,
			String parametroMasivoDescripcion) {
		super();
		this.idParametro = idParametro;
		this.parametroNom = parametroNom;
		this.parametroTipo = parametroTipo;
		this.parametroFormato = parametroFormato;
		this.parametroValor = parametroValor;
		this.parametroEstatus = parametroEstatus;
		this.paraEstatusFec = paraEstatusFec;
		this.parametroMasivoTitulo = parametroMasivoTitulo;
		this.parametroMasivoDescripcion = parametroMasivoDescripcion;
	}

	public Long getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}

	public String getParametroNom() {
		return parametroNom;
	}

	public void setParametroNom(String parametroNom) {
		this.parametroNom = parametroNom;
	}

	public String getParametroTipo() {
		return parametroTipo;
	}

	public void setParametroTipo(String parametroTipo) {
		this.parametroTipo = parametroTipo;
	}

	public String getParametroFormato() {
		return parametroFormato;
	}

	public void setParametroFormato(String parametroFormato) {
		this.parametroFormato = parametroFormato;
	}

	public String getParametroValor() {
		return parametroValor;
	}

	public void setParametroValor(String parametroValor) {
		this.parametroValor = parametroValor;
	}

	public int getParametroEstatus() {
		return parametroEstatus;
	}

	public void setParametroEstatus(int parametroEstatus) {
		this.parametroEstatus = parametroEstatus;
	}

	public Date getParaEstatusFec() {
		return paraEstatusFec;
	}

	public void setParaEstatusFec(Date paraEstatusFec) {
		this.paraEstatusFec = paraEstatusFec;
	}

	public String getParametroMasivoTitulo() {
		return parametroMasivoTitulo;
	}

	public void setParametroMasivoTitulo(String parametroMasivoTitulo) {
		this.parametroMasivoTitulo = parametroMasivoTitulo;
	}

	public String getParametroMasivoDescripcion() {
		return parametroMasivoDescripcion;
	}

	public void setParametroMasivoDescripcion(String parametroMasivoDescripcion) {
		this.parametroMasivoDescripcion = parametroMasivoDescripcion;
	}

}
