/**
 *
 */
package com.citi.euces.sitiouec.models;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author lbermejo
 *
 */
public class CustomerDetailTDCRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@NotEmpty(message = "Please provide a tdcCustomer")
	@NotNull(message = "Please provide a tdcCustomer")
	@Pattern(regexp="^[0-9]{16}$",message = "Only 16 digits")
	private String tdcCustomer;

	

	/**
	 * @return the tdcCustomer
	 */
	public String getTdcCustomer() {
		return tdcCustomer;
	}

	/**
	 * @param tdcCustomer the tdcCustomer to set
	 */
	public void setTdcCustomer(String tdcCustomer) {
		this.tdcCustomer = tdcCustomer;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this, ToStringStyle.JSON_STYLE  );
	}
	
}
