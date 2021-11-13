package com.citi.euces.sitiouec.dto;

public class ObtenerVistaCampanaporDivisionResponseDTO {
		
		private Long RK;
		private String DIVISION;
		private String Region;
		private String Distrito;
		private String Mercado;
		private Long Suc;
		private String Nomina;
		
		
		private double VENTAS;
		private double MONTO;
		private double MONTOVENTAS;
		private double cantsuc;
		private double cantejec;
		private double CantSucSinVentas;
		private double CantSucConVentas;
		private double Per_Capita;
		
		private double CantVentasCam1;
		private double VentasCam1;
	    private double CantVentasCam2;
	    private double VentasCam2;
	    private double CantVentasCam3;
	    private double VentasCam3;
	    private double CantVentasCam4;
	    private double VentasCam4;

	    private double CantVentasCam5;
	    private double VentasCam5;

	    private double CantVentasCam6;
	    private double VentasCam6;

	    private double CantVentasCam7;
	    private double VentasCam7;

	    private double CantVentasCam8;
	    private double VentasCam8;

	    private double CantVentasCam9;
	    private double VentasCam9;

	    private double CantVentasCam10;
	    private double VentasCam10;
		
		
		
		/**
		 * 
		 */
		 ObtenerVistaCampanaporDivisionResponseDTO() {
			super();
		}
			
		/**
		 * @param dIVISION
		 * @param vENTAS
		 * @param mONTO
		 * @param mONTOVENTAS
		 * @param cantsuc
		 * @param cantejec
		 * @param cantSucSinVentas
		 * @param cantSucConVentas
		 * @param per_Capita
		 * @param rK
		 */
		public ObtenerVistaCampanaporDivisionResponseDTO(String dIVISION, double vENTAS, double mONTO, double mONTOVENTAS, double cantsuc,
				double cantejec, double cantSucSinVentas, double cantSucConVentas, double per_Capita, Long rK) {
			super();
			DIVISION = dIVISION;
			VENTAS = vENTAS;
			MONTO = mONTO;
			MONTOVENTAS = mONTOVENTAS;
			this.cantsuc = cantsuc;
			this.cantejec = cantejec;
			CantSucSinVentas = cantSucSinVentas;
			CantSucConVentas = cantSucConVentas;
			Per_Capita = per_Capita;
			RK = rK;
		}






		public String getDIVISION() {
			return DIVISION;
		}
		public void setDIVISION(String dIVISION) {
			DIVISION = dIVISION;
		}
		public double getVENTAS() {
			return VENTAS;
		}
		public void setVENTAS(double vENTAS) {
			VENTAS = vENTAS;
		}
		public double getMONTO() {
			return MONTO;
		}
		public void setMONTO(double mONTO) {
			MONTO = mONTO;
		}
		public double getMONTOVENTAS() {
			return MONTOVENTAS;
		}
		public void setMONTOVENTAS(double mONTOVENTAS) {
			MONTOVENTAS = mONTOVENTAS;
		}
		public double getCantsuc() {
			return cantsuc;
		}
		public void setCantsuc(double cantsuc) {
			this.cantsuc = cantsuc;
		}
		public double getCantejec() {
			return cantejec;
		}
		public void setCantejec(double cantejec) {
			this.cantejec = cantejec;
		}
		public double getCantSucSinVentas() {
			return CantSucSinVentas;
		}
		public void setCantSucSinVentas(double cantSucSinVentas) {
			CantSucSinVentas = cantSucSinVentas;
		}
		public double getCantSucConVentas() {
			return CantSucConVentas;
		}
		public void setCantSucConVentas(double cantSucConVentas) {
			CantSucConVentas = cantSucConVentas;
		}
		public double getPer_Capita() {
			return Per_Capita;
		}
		public void setPer_Capita(double per_Capita) {
			Per_Capita = per_Capita;
		}
		public Long getRK() {
			return RK;
		}
		public void setRK(Long rK) {
			RK = rK;
		}

		public String getRegion() {
			return Region;
		}

		public void setRegion(String region) {
			Region = region;
		}

		public String getDistrito() {
			return Distrito;
		}

		public void setDistrito(String distrito) {
			Distrito = distrito;
		}

		public String getMercado() {
			return Mercado;
		}

		public void setMercado(String mercado) {
			Mercado = mercado;
		}

		public Long getSuc() {
			return Suc;
		}

		public void setSuc(Long suc) {
			Suc = suc;
		}

		public String getNomina() {
			return Nomina;
		}

		public void setNomina(String nomina) {
			Nomina = nomina;
		}

		public double getCantVentasCam1() {
			return CantVentasCam1;
		}

		public void setCantVentasCam1(double cantVentasCam1) {
			CantVentasCam1 = cantVentasCam1;
		}

		public double getVentasCam1() {
			return VentasCam1;
		}

		public void setVentasCam1(double ventasCam1) {
			VentasCam1 = ventasCam1;
		}

		public double getCantVentasCam2() {
			return CantVentasCam2;
		}

		public void setCantVentasCam2(double cantVentasCam2) {
			CantVentasCam2 = cantVentasCam2;
		}

		public double getVentasCam2() {
			return VentasCam2;
		}

		public void setVentasCam2(double ventasCam2) {
			VentasCam2 = ventasCam2;
		}

		public double getCantVentasCam3() {
			return CantVentasCam3;
		}

		public void setCantVentasCam3(double cantVentasCam3) {
			CantVentasCam3 = cantVentasCam3;
		}

		public double getVentasCam3() {
			return VentasCam3;
		}

		public void setVentasCam3(double ventasCam3) {
			VentasCam3 = ventasCam3;
		}

		public double getCantVentasCam4() {
			return CantVentasCam4;
		}

		public void setCantVentasCam4(double cantVentasCam4) {
			CantVentasCam4 = cantVentasCam4;
		}

		public double getVentasCam4() {
			return VentasCam4;
		}

		public void setVentasCam4(double ventasCam4) {
			VentasCam4 = ventasCam4;
		}

		public double getCantVentasCam5() {
			return CantVentasCam5;
		}

		public void setCantVentasCam5(double cantVentasCam5) {
			CantVentasCam5 = cantVentasCam5;
		}

		public double getVentasCam5() {
			return VentasCam5;
		}

		public void setVentasCam5(double ventasCam5) {
			VentasCam5 = ventasCam5;
		}

		public double getCantVentasCam6() {
			return CantVentasCam6;
		}

		public void setCantVentasCam6(double cantVentasCam6) {
			CantVentasCam6 = cantVentasCam6;
		}

		public double getVentasCam6() {
			return VentasCam6;
		}

		public void setVentasCam6(double ventasCam6) {
			VentasCam6 = ventasCam6;
		}

		public double getCantVentasCam7() {
			return CantVentasCam7;
		}

		public void setCantVentasCam7(double cantVentasCam7) {
			CantVentasCam7 = cantVentasCam7;
		}

		public double getVentasCam7() {
			return VentasCam7;
		}

		public void setVentasCam7(double ventasCam7) {
			VentasCam7 = ventasCam7;
		}

		public double getCantVentasCam8() {
			return CantVentasCam8;
		}

		public void setCantVentasCam8(double cantVentasCam8) {
			CantVentasCam8 = cantVentasCam8;
		}

		public double getVentasCam8() {
			return VentasCam8;
		}

		public void setVentasCam8(double ventasCam8) {
			VentasCam8 = ventasCam8;
		}

		public double getCantVentasCam9() {
			return CantVentasCam9;
		}

		public void setCantVentasCam9(double cantVentasCam9) {
			CantVentasCam9 = cantVentasCam9;
		}

		public double getVentasCam9() {
			return VentasCam9;
		}

		public void setVentasCam9(double ventasCam9) {
			VentasCam9 = ventasCam9;
		}

		public double getCantVentasCam10() {
			return CantVentasCam10;
		}

		public void setCantVentasCam10(double cantVentasCam10) {
			CantVentasCam10 = cantVentasCam10;
		}

		public double getVentasCam10() {
			return VentasCam10;
		}

		public void setVentasCam10(double ventasCam10) {
			VentasCam10 = ventasCam10;
		}


	


}
