/**
 * 
 */
package com.citi.euces.sitiouec.web.filter;

//import dev.c20.workflow.WorkflowApplication;
//import dev.c20.workflow.tools.PathUtils;
//import dev.c20.workflow.tools.StringUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 
 *
 */
@Order(2)
@Component
@WebFilter(filterName = "InjectionFilter", urlPatterns = "/*")
public class InjectionFilter  extends OncePerRequestFilter {
	
	@Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("IN  InjectionFilter ");
        CachedBodyHttpServletRequest cachedBodyHttpServletRequest = new CachedBodyHttpServletRequest(httpServletRequest);

        /*
        String restService = PathUtils.splitPath(httpServletRequest.getRequestURI())[1];
        
        if( WorkflowApplication.CHECK_AUTHORIZATION ) {
            if( !isOpenServices(restService) ) {
                // validate token
                logger.info("==>/" + restService + "/<== Is not open service, we need Validate token");
                String tokenData = revalidateToken(httpServletRequest,httpServletResponse);
                httpServletResponse.setHeader(WorkflowApplication.HEADER_AUTHORIZATION, WorkflowApplication.HEADER_AUTHORIZATION_TOKEN + tokenData);
            }
        }
        */
        
        String body = IOUtils.toString(cachedBodyHttpServletRequest.getReader());
        
        //ogger.info("Apply filter to " + restService);
        //if( !restService.equals("flow")) {
	        if( !isValidCrossSite(body) ) {
	        	throw new RuntimeException("Cross Site error");
	        }
	        if( !isValidSqlInjection(body )) {
	        	throw new RuntimeException("SQLInjection error");
	        }
        //}
		
        filterChain.doFilter(cachedBodyHttpServletRequest, httpServletResponse);

    }

	/*
    public String revalidateToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    	
    	String token = httpServletRequest.getHeader(WorkflowApplication.HEADER_AUTHORIZATION);

        if( token == null || token.equals(""))
            throw new RuntimeException("No se recibio el Token");
        
        logger.info("Token:" + token);
        token = token.substring(WorkflowApplication.HEADER_AUTHORIZATION_TOKEN.length());
        logger.info(token);
         
        
    	Map<String,Object> tokenData = StringUtils.readToken(token);
        tokenData.put("dummy", StringUtils.randomString(20));
        long validTo = (Long)tokenData.get("validTo");

        if( System.currentTimeMillis() > validTo )
            throw new RuntimeException("Token caduco");

        return StringUtils.getToken(tokenData);
    }

    public boolean isOpenServices( String restService) {

        for(int i = 0; i < WorkflowApplication.SERVICES_WITHOUT_AUTH.length; i ++ ) {
            if( WorkflowApplication.SERVICES_WITHOUT_AUTH[i].equals(restService) )
                return true;
        }

        return false;

    } */
    
    private static final String CARACTERES_NO_VALIDOS = "[\\<|\\>|\\'|\\;|\\(|\\)]"; 
	private static final String CARACTERES_SCRIPT = "<script"; 
	private static final String CARACTERES_JAVASCRIPT = "<javascript"; 
	private static final String CARACTERES_IFRAME = "<iframe"; 
	public static boolean isValidCrossSite(String datoAValidar) { 
		Pattern pattern = Pattern.compile(CARACTERES_NO_VALIDOS); 
		Matcher matcher = pattern.matcher(datoAValidar); 
		return !matcher.find(); 
	} 
	
	public static boolean hasScript(String datoAValidar) { 
	 
		return datoAValidar.toLowerCase().contains(CARACTERES_SCRIPT) || datoAValidar.toLowerCase().contains(CARACTERES_JAVASCRIPT)|| datoAValidar.toLowerCase().contains(CARACTERES_IFRAME); 
	} 
	
	private static final String SQL_CARACTERES_NO_VALIDOS = "\\s*DROP\\s+|\\s*SELECT\\s+|\\s*COUNT\\s+|\\s*AND\\s+|\\s*FROM\\s+|\\s*EXEC\\s+|\\s*DESC\\s+|\\s*CURSOR\\s+|\\s*CREATE\\s+|\\s*CAST\\s+"; 
	 
	public static boolean isValidSqlInjection(String datoAValidar) { 
		Pattern pattern = Pattern.compile(SQL_CARACTERES_NO_VALIDOS); 
		Matcher matcher = pattern.matcher(datoAValidar.toUpperCase()); 
		
		return !matcher.find(); 
	} 

}
