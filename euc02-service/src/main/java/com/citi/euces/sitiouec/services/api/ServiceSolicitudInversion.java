package com.citi.euces.sitiouec.services.api;
import java.io.IOException;
import java.util.List;

import com.citi.euces.sitiouec.infra.dto.ActSolicitudDtoRequest;
import com.citi.euces.sitiouec.infra.dto.ActSolicitudDtoResponse;
import com.citi.euces.sitiouec.infra.dto.DiasFestivosBEDTO;
import com.citi.euces.sitiouec.infra.dto.DiasFestivosResponseDTO;
import com.citi.euces.sitiouec.infra.exceptions.GenericException;

public interface ServiceSolicitudInversion {
	List<DiasFestivosResponseDTO> ObtenerDiasFeriados(DiasFestivosBEDTO request) throws GenericException, IOException;
	
	public ActSolicitudDtoResponse actSolicitud(ActSolicitudDtoRequest actSolicitudDtoRequest);
}
