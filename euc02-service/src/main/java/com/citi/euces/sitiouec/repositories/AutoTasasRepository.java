package com.citi.euces.sitiouec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citi.euces.sitiouec.entities.AutoTasas;

@Repository
public interface AutoTasasRepository extends JpaRepository<AutoTasas, Long> {

	
}