package com.citi.euces.sitiouec.services;

import org.springframework.stereotype.Service;

import com.citi.euces.sitiouec.dto.EmailAprobacionTasaEspecialDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;
import com.citi.euces.sitiouec.services.api.EmailTemplateAprobacionService;

@Service
public class EmailTemplateAprobacionServiceImpl implements EmailTemplateAprobacionService {

	@Override
	public String emailTemplateTasaEspecial(EmailAprobacionTasaEspecialDTO request) throws GenericException {
	
		String body = null;
		try {
				
		body = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
				+ "<html xmlns =\"http://www.w3.org/1999/xhtml\">"
				+ "<head><meta http - equiv =\"Content-Type\" content=\"text/html; charset="+"UTF-8"+"/>"
				+ "<title> Form Confirmation </title> </head>"
				+ "</head>"
				+ "<body>"
				+ "<b style = 'font-family: Verdana, Arial, Helvetica, sans-serif; '> Aviso. </b><br /><br />"
				+ "<table width = '50%' style='border:solid 2px #1A5B97; background:#1A5B97; font-family: Verdana, Arial, Helvetica, sans-serif'> "	
		        + "<tr> <td style='font-size:20;font-weight:bold;color:#FFFFFF' align = 'center'>Estimado(a):"+request.getNombreCte() + " <br /></td></tr>"
		        + "<tr> <td style='text-align:right;color:#FFFFFF'; font-size = 8pt'>Fecha:<b>"+ request.getFechaOperacion()+"</b> <br/><br/></td> </tr> "
		        + "<tr> <td style='text-align:left;font-size: 10px;font-weight:bold;color:#FFFFFF';> Se ha generado una solicitud de tasa: ESPECIAL,"+  request.getTipo().concat(request.getIdAutoTasa()) + " con la siguiente información: <br/><br/></td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>1.-Núm.y Suc.Operadora: </td></tr>"
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getSucursalDiv() + "</b></td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>2.-Nombre de Cliente:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getNombreCte()+"</b> </td> </tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>3.-Número de Cliente:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getNumCte() +"</b> </td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>4.-Número de Contrato:</td></tr>"
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b>"+request.getContrato() +"</b> </td> </tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>5.-Monto:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b>"+request.getMonto()+ "</b> </td> </tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>6.-Plazo:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getPlazo() +"</b> </td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>7.-Tasa Bruta Solic:</td> </tr>         "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getTasaSolicitud() +"</b> %</td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Justificación de solicitud:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getJustificacionSolicitud() +"</b></td></tr>"		        
		        + "<tr> <td> <br/> </td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size=8pt'>Nombre del solicitante:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b> "+request.getNombreSolicitante() +"</b> </td> </tr>"
		        + "<tr> <td><br /></td></tr> "
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'> Para Confirmar o Rechazar La solicitud, haga Clic en los siguientes botónes:<br/><br/></td> </tr>"
		        + "<tr> <td style='background-color:#E3F6CE;text-align:left;font-size:10px;font-weight:bold;color:#5E610B'></td> </tr>"
		        + "<tr> <td align='center' style='text-align:center;font-size:8pt'>"
		        + "    <a href='http://10.224.80.191:91/TasasAuto/VoBoTasaAuto.aspx?SOEID="+request.getLinkAutoriza()+"&TASA="+request.getIdAutoTasa()+"&ESTATUS= ACEPTADA' style='background-color:#7CC3C6; font-size:18px; font-weight:300; font-family:Verdana, Helvetica,sans-serif; color:#ffffff; text-decoration:none'> -Autorizar -</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
		        + "    <a href='http://10.224.80.191:91/TasasAuto/VoBoTasaAuto.aspx?SOEID="+request.getLinkRechaza()+"&TASA="+request.getIdAutoTasa()+"&ESTATUS= RECHAZADA' style='background-color:#EC8153; font-size:18px; font-weight:300; font-family:Verdana, Helvetica, sans-serif; color:#ffffff; text-decoration:none'> -Rechazar -</a>"
		        + "</td> </tr>"
		        + "<tr> <td style='background-color:#F2F2F2;text-align:center;font-size:6px;font-weight:bold;color:#5377A9'> Gracias por su atención. (Unidad Especializada de Comercialización.) </td></tr> "
		        + " </table> "
		        + "</body>"
		        + "</html>";

		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		return body;
		
		
		
	}

	@Override
	public String emailTemplateAprobacionInversion(EmailAprobacionTasaEspecialDTO request) throws GenericException {
	
		String body = null;
		String folioPortabilidad="";
		
		
		
		try {
			
			if(request.getTipo().equals("PORTAESPNOM") && !request.getFolioBantanet().isEmpty()) {
				folioPortabilidad = "         <tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Folio Bancanet de Portabilidad:</td></tr> " +
                        "         <tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size=8pt'><b>" + request.getFolioPortabilidad() + "</b></td></tr>";
			}
				
		body = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
				+ "<html xmlns =\"http://www.w3.org/1999/xhtml\">"
				+ "<head><meta http - equiv =\"Content-Type\" content=\"text/html; charset="+"UTF-8"+"/>"
				+ "<title> Form Confirmation </title> </head>"
				+ "</head>"
				+ "<body>"
				+ "<b style = 'font-family: Verdana, Arial, Helvetica, sans-serif; '> Aviso. </b><br /><br />"
				+ "<table width = '50%' style='border:solid 2px #1A5B97; background:#1A5B97; font-family: Verdana, Arial, Helvetica, sans-serif'> "	
		        + "<tr> <td style='font-size:20;font-weight:bold;color:#FFFFFF' align = 'center'>Estimado(a):"+request.getNombreCte() + " <br /></td></tr>"
		        + "<tr> <td style='text-align:right;color:#FFFFFF'; font-size = 8pt'>Fecha:<b>"+ request.getFechaOperacion()+"</b> <br/><br/></td> </tr> "
		        + "<tr> <td style='text-align:left;font-size: 10px;font-weight:bold;color:#FFFFFF';> Se ha generado una solicitud de tasa: ESPECIAL,"+  request.getTipo().concat(request.getIdAutoTasa()) + " con la siguiente información: <br/><br/></td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>1.-Núm.y Suc.Operadora: </td></tr>"
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getSucursalDiv() + "</b></td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size = 8pt'>2.-Nombre de Cliente:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getNombreCte()+"</b> </td> </tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>3.-Número de Cliente:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getNumCte() +"</b> </td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>4.-Número de Contrato:</td></tr>"
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b>"+request.getContrato() +"</b> </td> </tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>5.-Monto:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b>"+request.getMonto()+ "</b> </td> </tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>6.-Plazo:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getPlazo() +"</b> </td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'>7.-Tasa Bruta Solic:</td> </tr>         "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getTasaSolicitud() +"</b> %</td></tr>"
		        + "<tr> <td style='text-align:left;color:#FFFFFF';font-size=8pt'>Justificación de solicitud:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt'><b> "+request.getJustificacionSolicitud() +"</b></td></tr>"	        
		        + ""+folioPortabilidad +""
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size=8pt'>Nombre del solicitante:</td></tr> "
		        + "<tr> <td style='background-color:#FFFFFF;text-align:center;color:#1F497D;font-size:8pt' ><b> "+request.getNombreSolicitante() +"</b> </td> </tr>"
		        + "<tr> <td><br /></td></tr> "
		        + "<tr> <td style='text-align:left;color:#FFFFFF'; font-size = 8pt'> Para Confirmar o Rechazar La solicitud, haga Clic en los siguientes botónes:<br/><br/></td> </tr>"
		        + "<tr> <td style='background-color:#E3F6CE;text-align:left;font-size:10px;font-weight:bold;color:#5E610B'></td> </tr>"
		        + "<tr> <td align='center' style='text-align:center;font-size:8pt'>"
		        + "    <a href='http://10.224.80.191:91/TasasAuto/VoBoTasaAuto.aspx?SOEID="+request.getLinkAutoriza()+"&TASA="+request.getIdAutoTasa()+"&ESTATUS= ACEPTADA' style='background-color:#7CC3C6; font-size:18px; font-weight:300; font-family:Verdana, Helvetica,sans-serif; color:#ffffff; text-decoration:none'> -Autorizar -</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
		        + "    <a href='http://10.224.80.191:91/TasasAuto/VoBoTasaAuto.aspx?SOEID="+request.getLinkRechaza()+"&TASA="+request.getIdAutoTasa()+"&ESTATUS= RECHAZADA' style='background-color:#EC8153; font-size:18px; font-weight:300; font-family:Verdana, Helvetica, sans-serif; color:#ffffff; text-decoration:none'> -Rechazar -</a>"
		        + "</td> </tr>"
		        + "<tr> <td style='background-color:#F2F2F2;text-align:center;font-size:6px;font-weight:bold;color:#5377A9'> Gracias por su atención. (Unidad Especializada de Comercialización.) </td></tr> "
		        + " </table> "
		        + "</body>"
		        + "</html>";

		}catch (Exception ex) {
			System.out.println("ex ->" + ex.getMessage());
			System.out.println("ex ->" + ex.getCause());
		}
		
		return body;
	}

	
	
	
}
