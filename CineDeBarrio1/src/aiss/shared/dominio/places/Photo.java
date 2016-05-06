package aiss.shared.dominio.places;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3056342143443456327L;
	private Integer height;
	private List<String> htmlAttributions = new ArrayList<String>();
	private String photoReference;
	private Integer width;

	/**
	 * 
	 * @return The height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * 
	 * @param height
	 *            The height
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * 
	 * @return The htmlAttributions
	 */
	public List<String> getHtmlAttributions() {
		return htmlAttributions;
	}

	/**
	 * 
	 * @param htmlAttributions
	 *            The html_attributions
	 */
	public void setHtmlAttributions(List<String> htmlAttributions) {
		this.htmlAttributions = htmlAttributions;
	}

	/**
	 * 
	 * @return The photoReference
	 */
	public String getPhotoReference() {
		return photoReference;
	}

	/**
	 * 
	 * @param photoReference
	 *            The photo_reference
	 */
	public void setPhotoReference(String photoReference) {
		this.photoReference = photoReference;
	}

	/**
	 * 
	 * @return The width
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * 
	 * @param width
	 *            The width
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

}
