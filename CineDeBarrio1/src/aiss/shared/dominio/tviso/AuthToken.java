package aiss.shared.dominio.tviso;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthToken implements Serializable {

	private static final long serialVersionUID = -2761149182814515400L;
	private String auth_token;
	private Integer authExpiresDate;
	private Integer error;
	
	public AuthToken(){
		
	}

	/**
	 * @return The authToken
	 */
	public String getAuth_token() {
		return auth_token;
	}

	/**
	 * 
	 * @param authToken
	 *            The auth_token	
	 */
	public void setAuth_token(String authToken) {
		this.auth_token = authToken;
	}

	/**
	 * 
	 * @return The authExpiresDate
	 */
	public Integer getAuth_expires_date() {
		return authExpiresDate;
	}

	/**
	 * 
	 * @param authExpiresDate
	 *            The auth_expires_date
	 */
	public void setAuth_expires_date(Integer authExpiresDate) {
		this.authExpiresDate = authExpiresDate;
	}

	/**
	 * 
	 * @return The error
	 */
	public Integer getError() {
		return error;
	}

	/**
	 * 
	 * @param error
	 *            The error
	 */
	public void setError(Integer error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return "AuthToken [authToken=" + auth_token + ", authExpiresDate="
				+ authExpiresDate + ", error=" + error + "]";
	}

}
