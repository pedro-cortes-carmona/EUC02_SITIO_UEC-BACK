package com.citi.euces.sitiouec.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import com.citi.euces.sitiouec.repositories.AutoTasasRepository;
import com.citi.euces.sitiouec.infra.dto.Cat_SucBEDTO;
import com.citi.euces.sitiouec.repositories.solicitudCampanaJDBCRepository;
import com.citi.euces.sitiouec.entities.AutoTasas;
import com.citi.euces.sitiouec.infra.dto.AutoAutorizadorBEDTO;
import com.citi.euces.sitiouec.infra.dto.EmailTemplateDTO;
import com.citi.euces.sitiouec.services.api.SolicitudCampanaService;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.infra.utils.ConstantUtils;

@Service
public class SolicitudCampanaServiceImp implements SolicitudCampanaService {
	
	@Autowired
	private solicitudCampanaJDBCRepository solicitudCampanaJDBCRepository;
	
	@Autowired
	private AutoTasasRepository autoTasasRepository;

	@PersistenceContext
	private EntityManager entityManager;

	static final Logger log = LoggerFactory.getLogger(SolicitudCampanaServiceImp.class);

	
	@Override
	public EmailTemplateDTO emailTemplate(String folio, String linkAutoriza, String linkRechaza,
		    String urlRedirect, List<AutoAutorizadorBEDTO> listadoAutorizadores) throws GenericException {
		log.info("emailTemplate init :: >");
		EmailTemplateDTO response = new EmailTemplateDTO();
		AutoTasas solicitud = autoTasasRepository.findById(Long.valueOf(folio)).get();
		if (solicitud == null) {
            throw new GenericException(
                    "No se encontro informacion en SolicitudesTarifasEspeciales con folio  :: " + folio,
                    HttpStatus.NOT_FOUND.toString());
        }

        String[] linkAutorizas = linkAutoriza.split(",");
        String[] linkRechazas = linkRechaza.split(",");
		int i = 0;
		String title = "";
		String body = "";
		String cadenaIds = "";
		String suc;
		System.out.println("288 solicitud->" + solicitud);
		try {
			suc = ObtenerSucursalesPorSuc(solicitud.getSucSolic());
		} catch (Exception e) {
			throw new GenericException("Error al obtener ObtenerSucursalesPorSuc:: ",
					HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		System.out.println("288 vsuc->" + suc);
		String strAceptada = "StrAceptada";
		String strRechadaza = "StrRechadaza";
		
		// ESPECIAL','AutCETE98','EXCEPGER','PORTAESPNOM

		int x = 0;
		System.out.println("288 listadoAutorizadores->" + listadoAutorizadores);
		for (AutoAutorizadorBEDTO item : listadoAutorizadores) {
			title += ConstantUtils.GetTitleSolicitud + "|";
			cadenaIds += item.SOEID + "|";

			if (item.SOEID.equals("VN86003")) {
				try {
					Date date1=new Date(solicitud.getFechaSoli().getTime());
					Long long1=Long.parseLong(solicitud.getContrato());  
					body += BodySolicitudAutorizadorUEC(date1, solicitud.getIsPortabilidad(),
							solicitud.getTipoAutori(), solicitud.getJustificacion(), solicitud.getNomEjecutivo(),
							solicitud.getNomCliente(), solicitud.getNumCliente(), long1,
							solicitud.getMonto() + "", solicitud.getPlazo(), solicitud.getTasaAutori() + "",
							solicitud.getIdTasaAuto() + "", strAceptada, strRechadaza, suc, item.Nombre, item.SOEID)
							+ "|";
				} catch (Exception e) {
					throw new GenericException("Error al obtener BodySolicitudAutorizadorUEC:: ",
							HttpStatus.INTERNAL_SERVER_ERROR.toString());
				}
			} else {
				if (!body.contains(item.Nombre)) {
					try {
						Date date1=new Date(solicitud.getFechaSoli().getTime());
						Long long1=Long.parseLong(solicitud.getContrato());  
						body += BodySolicitud(date1, solicitud.getIsPortabilidad(),
								solicitud.getTipoAutori(), solicitud.getJustificacion(), solicitud.getNomEjecutivo(),
								solicitud.getNomCliente(), solicitud.getNumCliente(), long1,
								solicitud.getMonto() + "", solicitud.getPlazo(), solicitud.getTasaAutori() + "",
								solicitud.getIdTasaAuto() + "", strAceptada, strRechadaza, suc, item.Nombre,
								item.SOEID, urlRedirect, linkAutorizas[x], linkRechazas[x]) + "|";
					} catch (Exception e) {
						throw new GenericException("Error al obtener BodySolicitud:: ",
								HttpStatus.INTERNAL_SERVER_ERROR.toString());
					}
				}
			}
			x++;
		}
		System.out.println("288 body->" + body);

		if (i > 0) {
			title = title.substring(0, title.length() - 1);
			body = body.substring(0, body.length() - 1);
			cadenaIds = cadenaIds.substring(0, cadenaIds.length() - 1);
		}

		System.out.println("288 title y cadenaIds->" + title + "     " + cadenaIds);
		response.setSoeidEnc(cadenaIds);
		response.setTitleEnc(title);
		response.setInformeEnc(body);
		response.setAcountEnc(ConstantUtils.BUZON);
		System.out.println("288 response->" + response);
		return response;
	}


	@Override
	public EmailTemplateDTO emailTemplate21(String folio, String linkAutoriza, String linkRechaza, String urlRedirect,
			List<AutoAutorizadorBEDTO> listadoAutorizadores) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String BodySolicitudAutorizadorUEC(Date fecha_solic, String Folio_BancaNet, String TIPO_AUTORI,
			String JUSTIFICACION, String NOMEJEC, String NOM_CTE, Long NUM_CTE, Long CONTRATO, String MONTO, Long PLAZO,
			String TASA_AUTORI, String idtasaEncrypt, String strAceptada, String strRechadaza, String suc,
			String nombre_autorizador, String soeidEncrypt) throws GenericException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaComoCadena = sdf.format(fecha_solic);
		String body = null;
		try {
			String folioPortabilidad = "";
			if (TIPO_AUTORI.equals("PORTAESPNOM") && !Folio_BancaNet.isEmpty()) {
				folioPortabilidad = "         <tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Folio Bancanet de Portabilidad:</td></tr> "
						+ "         <tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size=8pt'><b>"
						+ Folio_BancaNet + "</b></td></tr>";
			}

			body = "<html xmlns =\"http://www.w3.org/1999/xhtml\">"
					+ "<head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /> "
					+ "<title> Form Confirmation </title> </head>" + "<body>"
					+ "<b style = 'font-family: Verdana, Arial, Helvetica, sans-serif; '> Aviso. </b><br /><br />"
					+ "<table width = '50%' style='border:solid 2px #1A5B97; background:#1A5B97; font-family: Verdana, Arial, Helvetica, sans-serif'> "
					+ "<tr> <td style='font-size:20;font-weight:bold;color:#FFFFFF' align = 'center'>Estimado(a):"
					+ nombre_autorizador + " <br /></td></tr>"
					+ "<tr> <td style='text-align:right;color:#FFFFFF'; font-size = 8pt'>Fecha:<b>" + fechaComoCadena
					+ "</b> <br/><br/></td> </tr> "
					+ "<tr> <td style='text-align:left;font-size: 10px;font-weight:bold;color:#FFFFFF';> Se ha generado una solicitud de tasa: "
					+ TIPO_AUTORI + " con la siguiente información:<br/><br/></td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>1.-Núm.y Suc.Operadora: </td></tr>"
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ suc + "</b></td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>2.-Nombre de Cliente:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ NOM_CTE + "</b> </td> </tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>3.-Número de Cliente:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ NUM_CTE + "</b> </td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>4.-Número de Contrato:</td></tr>"
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b>"
					+ CONTRATO + "</b> </td> </tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>5.-Monto:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b>"	+ formatNumber(Double.parseDouble(MONTO))
					+ "</b> </td> </tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>6.-Plazo:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ PLAZO + "</b> </td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>7.-Tasa Bruta Solic:</td> </tr>         "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ formatNumber(Double.parseDouble(TASA_AUTORI)) + "</b> %</td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Justificación de solicitud:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ JUSTIFICACION + "</b></td></tr>" + "" + folioPortabilidad + "" + "<tr> <td> <br/> </td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size=8pt'>Nombre del solicitante:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b> "
					+ NOMEJEC + "</b> </td> </tr>" + "<tr> <td><br /></td></tr> "
					+ "<tr> <td style='background-color:#F2F2F2;text-align:center;font-size:6px;font-weight:bold;color:#5377A9'> Gracias por su atención. (Unidad Especializada de Comercialización.) </td></tr> "
					+ " </table> " + "</body>" + "</html>";

		} catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}

		return body;
	}
	
	public String BodySolicitud(Date fecha_solic, String Folio_BancaNet, String TIPO_AUTORI, String JUSTIFICACION,
			String NOMEJEC, String NOM_CTE, Long NUM_CTE, Long CONTRATO, String MONTO, long PLAZO, String TASA_AUTORI,
			String idtasaEncrypt, String strAceptada, String strRechadaza, String suc, String nombre_autorizador,
			String soeidEncrypt, String urlRedirect, String linksAutoriza, String linksRechazas) throws GenericException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaComoCadena = sdf.format(fecha_solic);
		String body = null;
		try {
			String folioPortabilidad = "";
			if (TIPO_AUTORI.equals("PORTAESPNOM") && !Folio_BancaNet.isEmpty()) {
				folioPortabilidad = "         <tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Folio Bancanet de Portabilidad:</td></tr> "
						+ "         <tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size=8pt'><b>"
						+ Folio_BancaNet + "</b></td></tr>";
			}

			body = "<html xmlns =\"http://www.w3.org/1999/xhtml\">"
					+ "<head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /> "
					+ "<title> Form Confirmation </title> </head>" + "<body>"
					+ "<b style = 'font-family: Verdana, Arial, Helvetica, sans-serif; '> Aviso. </b><br /><br />"
					+ "<table width = '50%' style='border:solid 2px #1A5B97; background:#1A5B97; font-family: Verdana, Arial, Helvetica, sans-serif'> "
					+ "<tr> <td style='font-size:20;font-weight:bold;color:#FFFFFF' align = 'center'>Estimado(a):"
					+ nombre_autorizador + " <br /></td></tr>"
					+ "<tr> <td style='text-align:right;color:#FFFFFF'; font-size = 8pt'>Fecha:<b>" + fechaComoCadena
					+ "</b> <br/><br/></td> </tr> "
					+ "<tr> <td style='text-align:left;font-size: 10px;font-weight:bold;color:#FFFFFF';> Se ha generado una solicitud de tasa: "
					+ TIPO_AUTORI + "," + idtasaEncrypt + " con la siguiente información:<br/><br/></td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>1.-Núm.y Suc.Operadora: </td></tr>"
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ suc + "</b></td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>2.-Nombre de Cliente:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ NOM_CTE + "</b> </td> </tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>3.-Número de Cliente:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ NUM_CTE + "</b> </td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>4.-Número de Contrato:</td></tr>"
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b>"
					+ CONTRATO + "</b> </td> </tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>5.-Monto:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b>"	+ formatNumber(Double.parseDouble(MONTO))
					+ "</b> </td> </tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>6.-Plazo:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ PLAZO + "</b> </td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>7.-Tasa Bruta Solic:</td> </tr>         "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ formatNumber(Double.parseDouble(TASA_AUTORI)) + "</b> %</td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Justificación de solicitud:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "
					+ JUSTIFICACION + "</b></td></tr>" + "" + folioPortabilidad + "" + "<tr> <td> <br/> </td></tr>"
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size=8pt'>Nombre del solicitante:</td></tr> "
					+ "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b> "
					+ NOMEJEC + "</b> </td> </tr>" + "<tr> <td><br /></td></tr> "
					+ "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'> Para Confirmar o Rechazar La solicitud, haga Clic en los siguientes botónes:<br/><br/></td> </tr>"
					+ "<tr> <td style='background-color:#E3F6CE;text-align:left;font-size:10px;font-weight:bold;color:#5E610B'></td> </tr>"
					+ "<tr> <td align='center' style='text-align:center;font-size:8pt'>" + 
					"  <a href = '" + urlRedirect + "?data=" + linksAutoriza
	                        + "' style = 'background-color:#7CC3C6; font-size:18px; font-weight:300; font-family:Verdana, Helvetica, sans-serif;  color:#ffffff;  text-decoration:none' > -Autorizar -</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; "
	                        + "    <a href = '" + urlRedirect + "?data=" + linksRechazas
	                        + "' style = 'background-color:#EC8153; font-size:18px; font-weight:300; font-family:Verdana, Helvetica, sans-serif;  color:#ffffff;  text-decoration:none' > -Rechazar -</a> "
					+ "<tr> <td style='background-color:#F2F2F2;text-align:center;font-size:6px;font-weight:bold;color:#5377A9'> Gracias por su atención. (Unidad Especializada de Comercialización.) </td></tr> "
					+ " </table> " + "</body>" + "</html>";

		} catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}

		return body;
	}
	
	public String ObtenerSucursalesPorSuc(Long request) throws GenericException, IOException {
		String respuesta = new String();
		List<Cat_SucBEDTO> cte = new ArrayList<Cat_SucBEDTO>();

		try {
			cte = solicitudCampanaJDBCRepository.GetItem(Long.parseLong(request+""));
			respuesta = cte.get(0).getNUMSUC() + " - " + cte.get(0).getSUCURSAL() + " - " + cte.get(0).getDIVISION();
		} catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		return respuesta;
	}
	
	private BigDecimal formatNumber(double monto) {		
		BigDecimal formatNumber = new BigDecimal(monto);
		formatNumber = formatNumber.setScale(2, RoundingMode.HALF_UP);
    return formatNumber;
	}

}
