package aiss.shared.dominio.trakttv.serie;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shows implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6062955078576252146L;
	private String type;
	private Integer score;
	private ShowTrakt show;

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 *
	 * @return The score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 *
	 * @param score
	 *            The score
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * 
	 * @return The show
	 */
	public ShowTrakt getShow() {
		return show;
	}

	/**
	 * 
	 * @param show
	 *            The show
	 */
	public void setShow(ShowTrakt show) {
		this.show = show;
	}

}
