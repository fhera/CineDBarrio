package aiss.shared.dominio.tviso;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Images implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8344538697403553707L;
	private String backdrop;
	private String poster;
	private String country;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Images() {
	}

	/**
	 * 
	 * @return The backdrop
	 */
	public String getBackdrop() {
		return backdrop;
	}

	/**
	 * 
	 * @param backdrop
	 *            The backdrop
	 */
	public void setBackdrop(String backdrop) {
		this.backdrop = backdrop;
	}

	/**
	 * 
	 * @return The poster
	 */
	public String getPoster() {
		return poster;
	}

	/**
	 * 
	 * @param poster
	 *            The poster
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}

	/**
	 * 
	 * @return The country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 *            The country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
