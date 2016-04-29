package aiss.shared.dominio.tviso;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AuthToken implements Serializable {

	private static final long serialVersionUID = -2761149182814515400L;
	private String authToken;
	private Integer authExpiresDate;
	private Integer error;

	/**
	 * @return The authToken
	 */
	public String getAuthToken() {
		return authToken;
	}

	/**
	 * 
	 * @param authToken
	 *            The auth_token
	 */
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	/**
	 * 
	 * @return The authExpiresDate
	 */
	public Integer getAuthExpiresDate() {
		return authExpiresDate;
	}

	/**
	 * 
	 * @param authExpiresDate
	 *            The auth_expires_date
	 */
	public void setAuthExpiresDate(Integer authExpiresDate) {
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

}
