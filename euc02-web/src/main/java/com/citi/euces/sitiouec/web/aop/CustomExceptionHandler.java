/**
 * 
 */
package com.citi.euces.sitiouec.web.aop;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.citi.euces.sitiouec.exceptions.RecordNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

/**
 * @author lbermejo
 *
 */
@ControllerAdvice
@ResponseBody
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomExceptionHandler.class);
	
	@ExceptionHandler({Exception.class})
    public final ResponseEntity<ErrorResponse> handleAllExceptions(
    							Exception ex, WebRequest request) {
        
		List<String> details = new ArrayList<>();
        			 details.add(ex.getLocalizedMessage());
        
        ErrorResponse error = new ErrorResponse("1001","APP_SERVER_ERROR", details);
        LOGGER.error(error);
        
        return new ResponseEntity<>(error, HttpStatus.OK);  ////HttpStatus.INTERNAL_SERVER_ERROR
    }
 
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(
								RecordNotFoundException ex,WebRequest request) {
		
		List<String> details = new ArrayList<>();
					 details.add(ex.getLocalizedMessage());
		
		ErrorResponse error = new ErrorResponse("1002","APP_RECORD_NOT_FOUND", details);
		LOGGER.info(error);
		
		return new ResponseEntity<>(error, HttpStatus.OK); //HttpStatus.NOT_FOUND
	}
	
	// @Validate For Validating Path Variables and Request Parameters
    @ExceptionHandler({ConstraintViolationException.class, InvalidFormatException.class})
    public final ResponseEntity<ErrorResponse> handleConstraintViolation(
                                ConstraintViolationException ex, WebRequest request){

    	LOGGER.info(ex.getConstraintViolations());
    	
    	List<String> details = new ArrayList<>();
		 			 details.add(ex.getLocalizedMessage());
		 
        ErrorResponse error = new ErrorResponse("1003","BAD_REQUEST", details);
        LOGGER.info(error);
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); //HttpStatus.BAD_REQUEST
    }
    
    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);
        
        LOGGER.info(errors);
        return new ResponseEntity<>(body, headers, status);

    }

	
}
