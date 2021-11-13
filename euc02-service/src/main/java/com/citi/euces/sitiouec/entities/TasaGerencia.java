package com.citi.euces.sitiouec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UEC_TB_TASAS")
public class TasaGerencia {
	
	@Id
    @Column(name ="ID_TASA")
	private Long ID_TASA;

}
