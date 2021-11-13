package com.citi.euces.sitiouec.services;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.euces.sitiouec.dto.PerCatSucursalesDTO;
import com.citi.euces.sitiouec.repositories.PerCatSucursalesRepository;
import com.citi.euces.sitiouec.services.api.PerCatSucursalesService;

@Service
public class PerCatSucursalesServiceImpl implements PerCatSucursalesService {
	
	private static final Logger LOGGER = LogManager.getLogger(PerCatSucursalesServiceImpl.class);

	@Autowired
	private PerCatSucursalesRepository perCatSucursalesRepository;	

	@Override
	public List<PerCatSucursalesDTO> getDivisiones(String descripcion) {
		// TODO Auto-generated method stub
		
		 List<PerCatSucursalesDTO>  lsDivisiones = perCatSucursalesRepository.getDivisiones(descripcion);
		 
//		 List<PerCatSucursalesDTO> distinctElements = lsDivisiones.stream()
//                 .filter( distinctByKey(p -> p.getDivisionNombre()) )
//                 .collect( Collectors.toList() );
		 
		 if(lsDivisiones!=null && lsDivisiones.size()<=0) {
			 LOGGER.info("NO SE ENCONTRO INFORMACION DE DIVISIONES" + " " + "Method:: getDivisiones");
		 }
		 
		return lsDivisiones;
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
