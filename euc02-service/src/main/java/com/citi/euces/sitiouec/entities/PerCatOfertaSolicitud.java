package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CAT_OFERTA") // TSC_EUCS_OWN
public class PerCatOfertaSolicitud {
	
	@Id
	@Column(name = "OFERTA_ID", nullable = true)
	private String ofertaID;

	@Column(name = "OFERTA_TIPO_DIRIGIDA", nullable = true)
	private Long ofertaTipoDirigida;
	
	@Column(name = "OFERTA_DIGITAL", nullable = true)
	private String ofertaDigital;
	
	@Column(name = "OFERTA_NTD", nullable = true)
	private String ofertaNTD;
	
	@Column(name = "OFERTA_NTP", nullable = true)
	private String ofertaNTP;
	
	@Column(name = "OFERTA_ECM", nullable = true)
	private String ofertaECM;
	
	@Column(name = "OFERTA_NTM", nullable = true)
	private String ofertaNTM;
	
	@Column(name = "OFERTA_BAU", nullable = true)
	private String ofertaBAU;
	
	@Column(name = "OFERTA_CLIENTE_TIPO_PERSONA", nullable = true)
	private String ofertaClienteTipoPersona;
	
	@Column(name = "OFERTA_SEGMENTO", nullable = true)
	private Long ofertaSegmento;
	
	@Column(name = "OFERTA_NOMBRE_LARGO", nullable = true)
	private String ofertaNombreLargo;
	
	@Column(name = "OFERTA_CAMPANIA_ID", nullable = true)
	private String ofertaCampanaID;
	
	@Column(name = "OFERTA_MONTO_DESDE", nullable = true)
	private Long ofertaMontoDesde;
		
	@Column(name = "OFERTA_MONTO_HASTA", nullable = true)
	private Long ofertaMontoHasta;
		
	@Column(name = "OFERTA_DINERO_NUEVO_MIN", nullable = true)
	private Long ofertaDineroNuevoMin;
		
	@Column(name = "OFERTA_DINERO_NUEVO_MAX", nullable = true)
	private Long ofertaDineroNuevoMax;
	
	@Column(name = "OFERTA_PLAZO_MINIMO", nullable = true)
	private String ofertaPlazoMinimo;
	
	@Column(name = "OFERTA_PLAZO_MAXIMO", nullable = true)
	private String ofertaPlazoMaximo;
	
	@Column(name = "OFERTA_TASA_ID", nullable = true)
	private String ofertaTasaID;
	
	@Column(name = "OFERTA_PARTICIPACION_UNICA", nullable = true)
	private Long ofertaParticipacionUnica;
	
	@Column(name = "OFERTA_DIAS_CLIENTE", nullable = true)
	private Long ofertaDiasCliente;
	
	@Column(name = "OFERTA_SIGUIENTE_PASO", nullable = true)
	private Long ofertaSiguientePaso;
	
	@Column(name = "OFERTA_INFORMATIVA_FONDOS", nullable = true)
	private String ofertaInformativaFondos;
		
	@Column(name = "OFERTA_SECCION", nullable = true)
	private Long ofertaSeccion;
	
	@Column(name = "OFERTA_PRIMERA_BUSQUEDA", nullable = true)
	private String ofertaPrimeraBusqueda;
		
	@Column(name = "OFERTA_SEGUNDA_BUSQUEDA", nullable = true)
	private String ofertaSegundaBusqueda;
		
	@Column(name = "OFERTA_GUIA_INFORMATIVA_ID", nullable = true)
	private String ofertaGuiaInformativaID;
	
	@Column(name = "OFERTA_PDF_ESPECIAL_ID", nullable = true)
	private String ofertaPDFEspecialID;
	
	
	public PerCatOfertaSolicitud() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	

}
