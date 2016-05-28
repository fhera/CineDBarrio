package aiss.shared.dominio.TMDB.serie;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedBy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2813276014690443350L;
	private Integer id;
	private String name;
	private String profilePath;

	/**
	 * 
	 * @return The id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The profilePath
	 */
	public String getProfilePath() {
		return profilePath;
	}

	/**
	 * 
	 * @param profilePath
	 *            The profile_path
	 */
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

}
