package com.citi.euces.sitiouec.infra.utils;

public class ConstantUtils {

	final public static String SOEID="Soeid";
	final public static String FECHA_OPE="Fecha Operacion";
	final public static String FECHA_ELIM="Fecha Eliminacion";
	
	
	//DETALLE OPERACION
	//REPORTE DETALLE OPERACION
	final public static String IDD = "ID";
	final public static String FOLIO = "FOLIO";
	final public static String FECHA_APERTURA = "FECHA A PERTURA";
	final public static String FECHA_ATENCION = "FECHA ATENCIÓN";
	final public static String SOEID_ASIG = "SOEID ASIG";
	final public static String SOEID_OPE = "SOEID OPE";
	final public static String OBSERVA_WEB = "OBSERVA WEB";
	final public static String DIVISION = "DIVISION";
	final public static String DISTRITO = "DISTRITO";
	final public static String SUCURSAL = "SUCURSAL";
	final public static String ESTATUSD = "ESTATUS";
	final public static String APLICADO = "APLICADO";
	final public static String PRODUCTO = "PRODUCTO";
	final public static String CAMPANA = "CAMPAÑA";
	final public static String T_PER = "TIPO DE PERSONA";
	final public static String CONTRATOD = "CONTRATO";
	final public static String CLIENTED = "CLIENTE";
	final public static String NOM_CTE = "NOMBRE CLIENTE";
	final public static String NUM_INVER = "NUM INVER";
	final public static String SDO_INVER = "SDO INVER";
	final public static String SALDO_INT = "SALDO INT";
	final public static String MONTO_AUTO = "MONTO AUTO";
	final public static String PLAZO_AUTO = "PLAZO AUTO";
	final public static String TASA_AUTO = "TASA_AUTO";
	final public static String VIGENCIA = "VIGENCIA INVERSION";
	final public static String PLAZO_SELEC = "PLAZO SELECCIONADO";
	final public static String GAT_NOMINAL = "GAT NOMINAL";
	final public static String GAT_REAL = "GAT REAL";
	final public static String RENDIMIENTO = "RENDIMIENTO";
	final public static String PARTICIPACION = "ID PARTICIPACIÓN ÚNICA";
	final public static String SIRH = "SIRH SUCURSAL";
	final public static String CERT = "CERT";
	final public static String FOLIO_BAN = "FOLIO_BANCANET";
	final public static String SOEID_EJE_SUC = "SOEID EJECUTIVO SUCURSAL";
	final public static String NOMINA = "NOMINA";
	final public static String NOMBRE_EJEC = "NOMBRE EJECUTIVO";
	final public static String SOEID_AUTORI = "SOEID AUTORI";
	
	
	//REPORTE RESUMEN UEC
	final public static String ESTATUS_UEC = "Estatus UEC";
	final public static String APLICADO_UEC = "Aplicado";
	final public static String APLICANDO_MONTO = "Aplicado Monto";
	final public static String NO_APLICADO = "No Aplicado";
	final public static String NO_APLI_MONTO = "No Apli Monto";
	final public static String NO_LOCALIZADO = "No Localizado";
	final public static String NO_LOC_MONTO = "No Loc Monto";
	final public static String OPERACIONES = "Operaciones";
	final public static String SUBTOTAL = "SubTotal";
	
	//REPORTE RESUMEN GER INV
	final public static String CAMPANA_UEC = "Campaña";
	final public static String APLICADO_GER = "Aplicado";
	final public static String OPERACIONES_GER = "Operaciones";
	final public static String MONTO_GER = "Monto";
	
	//REPORTE RESUMEN AUT X DIV
	final public static String DIVISION_AUT = "División";
	final public static String CAMPANA_AUT = "Campaña";
	final public static String OPERACIONES_AUT = "Operaciones";
	final public static String MONTO_AUT = "Monto";
	final public static String TASA_P = "Tasa P";
	final public static String CETE = "CETE";
	
	//REPORTE BOLETINES ENCABEZADO REGISTROS
	final public static String TIPO_PER = "	Tipo de Persona"; 
	final public static String OPE = "Operaciones";
	final public static String MONTO = "Monto";
	final public static String TASA_PROM = "Tasa P.";
	final public static String OPE_ANUAL = "Operaciones";
	final public static String MONTO_ANUAL = "Monto";
	final public static String TASA_PROM_ANUAL = "Tasa P.";
	
	//REPORTE ACUMULADO DIVISIONES
	final public static String RK = "RK";
	final public static String DIVACUM = "División";
	final public static String EJEC = "#Ejecutivos";
	final public static String VENTAS = "#Ventas";
	final public static String IMPORTE = "$ Importe";
	final public static String PER_CAPITA = "Per Cápita";
	final public static String PROMEDIO = "Promedio";
	final public static String SUC = "Suc Sn/Vtas";
	final public static String VENTASRETEN = "#Ventas";
	final public static String IMPRETEN = "$ Importe";
	
	//REPORTE ACUMULADO REGIONALES
	final public static String RK_REG = "RK";
	final public static String DIVACUM_REG = "División";
	final public static String DIRECCION = "Dirección";
	final public static String EJEC_REG = "#Ejecutivos";
	final public static String VENTS = "#Ventas";
	final public static String IMPORTE_REG = "$Importe";
	final public static String PER_CAP_REG = "Per Cápita";
	final public static String PROM_REG = "Promedio";
	final public static String SUC_SN = "Suc Sn/Vtas";
	
	//REPORTE ACUM SUCURSALES
	final public static String RK_SUC = "RK";
	final public static String DIVACUM_SUC = "División";
	final public static String DIRECCION_SUC = "Dirección";
	final public static String NOMBRE_SUC = "Nombre Suc";
	final public static String SUCUR = "SUC";
	final public static String EJEC_SUC = "#Ejecutivos";
	final public static String VENTS_SUC = "#Ventas";
	final public static String IMPORTE_SUC = "$Importe";
	final public static String PER_CAP_SUC = "Per Cápita";
	final public static String PROM_SUC = "Promedio";
	final public static String SUC_SN_SUC = "Suc Sn/Vtas";
	
	final public static String[] TITLE_SUC = {RK_SUC, DIVACUM_SUC, DIRECCION_SUC, NOMBRE_SUC, SUCUR, EJEC_SUC, VENTS_SUC, IMPORTE_SUC, PER_CAP_SUC, PROM_SUC, SUC_SN_SUC, VENTS_SUC, IMPORTE_SUC};
	
	final public static String[] TITLE_DIV = {RK, DIVACUM, EJEC, VENTAS, IMPORTE, PER_CAPITA, PROMEDIO, SUC, VENTASRETEN, IMPRETEN};
	
	final public static String[] TITLE_REG = {RK_REG, DIVACUM_REG, DIRECCION, EJEC_REG, VENTS, IMPORTE_REG, PER_CAP_REG, PROM_REG, SUC_SN, VENTS, IMPORTE_REG};
	
	
	
	final public static String[] TITLE_BOLETIN = {TIPO_PER, OPE, MONTO, TASA_PROM, OPE_ANUAL, MONTO_ANUAL, TASA_PROM_ANUAL};
	
	final public static String[] TITLE_UEC = {ESTATUS_UEC, APLICADO_UEC, APLICANDO_MONTO, NO_APLICADO, 
											NO_APLI_MONTO, NO_LOCALIZADO, NO_LOC_MONTO, OPERACIONES, SUBTOTAL};
	
	final public static String[] TITLE_GER_INV = {CAMPANA_UEC, APLICADO_GER, OPERACIONES_GER, MONTO_GER};
	
	final public static String[] TITLE_AUT_DIV = {DIVISION_AUT, CAMPANA_AUT, OPERACIONES_AUT, MONTO_AUT, TASA_P, CETE};
	
	final public static String[] TITLE_DETALLE_OPE = {IDD, FOLIO, FECHA_APERTURA, FECHA_ATENCION, SOEID_ASIG, SOEID_OPE, OBSERVA_WEB, DIVISION, DISTRITO, SUCURSAL
				,ESTATUSD, APLICADO, PRODUCTO, CAMPANA, T_PER, CONTRATOD, CLIENTED, NOM_CTE, NUM_INVER, MONTO_AUTO, PLAZO_AUTO, TASA_AUTO, VIGENCIA, 
				PLAZO_SELEC, GAT_NOMINAL, GAT_REAL, RENDIMIENTO, PARTICIPACION, SIRH, CERT, FOLIO_BAN, SOEID_EJE_SUC, NOMINA, NOMBRE_EJEC, SOEID_AUTORI}; 
	
	final public static String[] TITLE_DETALLE_M = {IDD, FOLIO, FECHA_APERTURA, FECHA_ATENCION, SOEID_ASIG, SOEID_OPE, OBSERVA_WEB, DIVISION, DISTRITO, SUCURSAL,
				ESTATUSD, APLICADO, PRODUCTO, CAMPANA, T_PER, CONTRATOD, CLIENTED, NOM_CTE, NUM_INVER, MONTO_AUTO, PLAZO_AUTO, TASA_AUTO, VIGENCIA,
				PLAZO_SELEC, GAT_NOMINAL, GAT_REAL, RENDIMIENTO, PARTICIPACION, SIRH, SOEID_EJE_SUC, NOMINA, NOMBRE_EJEC, SOEID_AUTORI};
	
	final public static String ENCABEZADO_ARCH_CARGA_DIA = SOEID + "\t" + FECHA_OPE + "\t" + FECHA_ELIM + "\n";
	
	final public static String GetTitleSolicitud = "Solicitud de Aprobación de Tasa Especial";
	final public static String BUZON = "uec";
}
