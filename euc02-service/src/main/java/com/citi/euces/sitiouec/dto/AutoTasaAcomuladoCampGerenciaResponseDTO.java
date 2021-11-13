package com.citi.euces.sitiouec.dto;



public class AutoTasaAcomuladoCampGerenciaResponseDTO {
	
     	private String SIRH;
	   	private String DIVICION;
	   	private String DISTRITO;
	   	private String NOMBRE_CAMPANA;
		private String TIPO_DISPOSITIVO;
		private String TIPO;
		private Long MONTO;
		private Long NUM_EJECUTIVO;
		private Long NUM_VENTAS;
		
		
		
		/**
		 * 
		 */
		public AutoTasaAcomuladoCampGerenciaResponseDTO() {
			super();
		}
		/**
		 * @param sIRH
		 * @param dIVICION
		 * @param dISTRITO
		 * @param nOMBRE_CAMPANA
		 * @param tIPO_DISPOSITIVO
		 * @param tIPO
		 * @param mONTO
		 * @param nUM_EJECUTIVO
		 * @param nUM_VENTAS
		 */
		public AutoTasaAcomuladoCampGerenciaResponseDTO(String sIRH, String dIVICION, String dISTRITO,
				String nOMBRE_CAMPANA, String tIPO_DISPOSITIVO, String tIPO, Long mONTO, Long nUM_EJECUTIVO,
				Long nUM_VENTAS) {
			super();
			SIRH = sIRH;
			DIVICION = dIVICION;
			DISTRITO = dISTRITO;
			NOMBRE_CAMPANA = nOMBRE_CAMPANA;
			TIPO_DISPOSITIVO = tIPO_DISPOSITIVO;
			TIPO = tIPO;
			MONTO = mONTO;
			NUM_EJECUTIVO = nUM_EJECUTIVO;
			NUM_VENTAS = nUM_VENTAS;
		}
		public String getSIRH() {
			return SIRH;
		}
		public void setSIRH(String sIRH) {
			SIRH = sIRH;
		}
		public String getDIVICION() {
			return DIVICION;
		}
		public void setDIVICION(String dIVICION) {
			DIVICION = dIVICION;
		}
		public String getDISTRITO() {
			return DISTRITO;
		}
		public void setDISTRITO(String dISTRITO) {
			DISTRITO = dISTRITO;
		}
		public String getNOMBRE_CAMPANA() {
			return NOMBRE_CAMPANA;
		}
		public void setNOMBRE_CAMPANA(String nOMBRE_CAMPANA) {
			NOMBRE_CAMPANA = nOMBRE_CAMPANA;
		}
		public String getTIPO_DISPOSITIVO() {
			return TIPO_DISPOSITIVO;
		}
		public void setTIPO_DISPOSITIVO(String tIPO_DISPOSITIVO) {
			TIPO_DISPOSITIVO = tIPO_DISPOSITIVO;
		}
		public String getTIPO() {
			return TIPO;
		}
		public void setTIPO(String tIPO) {
			TIPO = tIPO;
		}
		public Long getMONTO() {
			return MONTO;
		}
		public void setMONTO(Long mONTO) {
			MONTO = mONTO;
		}
		public Long getNUM_EJECUTIVO() {
			return NUM_EJECUTIVO;
		}
		public void setNUM_EJECUTIVO(Long nUM_EJECUTIVO) {
			NUM_EJECUTIVO = nUM_EJECUTIVO;
		}
		public Long getNUM_VENTAS() {
			return NUM_VENTAS;
		}
		public void setNUM_VENTAS(Long nUM_VENTAS) {
			NUM_VENTAS = nUM_VENTAS;
		}
     	
		

}
