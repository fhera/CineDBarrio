package aiss.shared.dominio.trakttv;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Traduccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6194225508848927031L;
	private String title;
	private String overview;
	private String language;

	/**
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The overview
	 */
	public String getOverview() {
		return overview;
	}

	/**
	 * 
	 * @param overview
	 *            The overview
	 */
	public void setOverview(String overview) {
		this.overview = overview;
	}

	/**
	 * 
	 * @return The language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * 
	 * @param language
	 *            The language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

}
