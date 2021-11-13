package com.citi.euces.sitiouec.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author cesar.alducin
 * 
 *         Clase que contiene dos listas para los dias accuracy y los dias
 *         TimeLines
 *
 */
public class ReporteDetailDTO {

	private List<ReporteAccuracyDTO> lsDiasAccuracy;

	private List<ReporteAccuracyDTO> lsDiasTimes;

	public List<ReporteAccuracyDTO> getLsDiasAccuracy() {
		if (lsDiasAccuracy == null) {
			lsDiasAccuracy = new ArrayList<>();
		}
		return lsDiasAccuracy;
	}

	public void setLsDiasAccuracy(List<ReporteAccuracyDTO> lsDiasAccuracy) {
		this.lsDiasAccuracy = lsDiasAccuracy;
	}

	public List<ReporteAccuracyDTO> getLsDiasTimes() {
		if (lsDiasTimes == null) {
			lsDiasTimes = new ArrayList<>();
		}
		return lsDiasTimes;
	}

	public void setLsDiasTimes(List<ReporteAccuracyDTO> lsDiasTimes) {
		this.lsDiasTimes = lsDiasTimes;
	}

}
