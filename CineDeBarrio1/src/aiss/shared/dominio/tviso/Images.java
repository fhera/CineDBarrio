package aiss.shared.dominio.tviso;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
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
	 * @param poster
	 * @param country
	 * @param backdrop
	 */
	public Images(String backdrop, String poster, String country) {
		this.backdrop = backdrop;
		this.poster = poster;
		this.country = country;
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
