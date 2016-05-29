package aiss.shared.dominio.trakttv.serie;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowTrakt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3006478301685076255L;
	private String title;
	private String overview;
	private Integer year;
	private String status;

	private Imagenes images;
//	private Ides ids;

	public ShowTrakt() {

	}

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
	 * @return The year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * 
	 * @param year
	 *            The year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * 
	 * @return The status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The images
	 */
	public Imagenes getImages() {
		return images;
	}

	/**
	 *
	 * @param images
	 *            The images
	 */
	public void setImages(Imagenes images) {
		this.images = images;
	}

	// /**
	// *
	// * @return The ids
	// */
	// public Ides getIds() {
	// return ids;
	// }
	//
	// /**
	// *
	// * @param ids
	// * The ids
	// */
	// public void setIds(Ides ids) {
	// this.ids = ids;
	// }

}
