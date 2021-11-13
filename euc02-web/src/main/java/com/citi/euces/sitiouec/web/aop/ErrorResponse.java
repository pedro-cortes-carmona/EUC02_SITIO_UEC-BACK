/**
 * 
 */
package com.citi.euces.sitiouec.web.aop;

import java.util.List;


/**
 * @author lbermejo
 *
 */
//@XmlRootElement(name = "error")
public class ErrorResponse {

	public ErrorResponse(String message, List<String> details) {
		this.message = message;
		this.details = details;
	}
	
	public ErrorResponse(String code, String message, List<String> details) {
		this.code = code;
		this.message = message;
		this.details = details;
	}
	
	private String code;
	private String message;
	private List<String> details;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
