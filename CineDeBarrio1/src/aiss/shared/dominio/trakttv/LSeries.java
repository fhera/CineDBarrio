package aiss.shared.dominio.trakttv;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LSeries implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3682347777962165770L;
	private Integer watchers;
	private Show show;

	/**
	 * 
	 * @return The watchers
	 */
	public Integer getWatchers() {
		return watchers;
	}

	/**
	 * 
	 * @param watchers
	 *            The watchers
	 */
	public void setWatchers(Integer watchers) {
		this.watchers = watchers;
	}

	/**
	 * 
	 * @return The show
	 */
	public Show getShow() {
		return show;
	}

	/**
	 * 
	 * @param show
	 *            The show
	 */
	public void setShow(Show show) {
		this.show = show;
	}

}
