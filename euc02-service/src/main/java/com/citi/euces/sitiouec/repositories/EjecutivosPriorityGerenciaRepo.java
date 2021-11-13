package com.citi.euces.sitiouec.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.citi.euces.sitiouec.entities.EjecutivosPriorityGerencia;

public interface EjecutivosPriorityGerenciaRepo extends JpaRepository<EjecutivosPriorityGerencia, Long>{
	
	@Query(value = " select * "
			+ " from UEC_CAT_EJECUTIVOS_PRIORITY2021 a ", nativeQuery = true)
	List<EjecutivosPriorityGerencia> ObtenerEjecutivosPriority();

}
