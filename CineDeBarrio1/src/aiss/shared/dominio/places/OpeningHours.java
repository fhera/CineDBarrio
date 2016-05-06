package aiss.shared.dominio.places;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
public class OpeningHours implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1500656086117734738L;
	private Boolean openNow;
	private List<Object> weekdayText = new ArrayList<Object>();

	/**
	 * 
	 * @return The openNow
	 */
	public Boolean getOpenNow() {
		return openNow;
	}

	/**
	 * 
	 * @param openNow
	 *            The open_now
	 */
	public void setOpenNow(Boolean openNow) {
		this.openNow = openNow;
	}

	/**
	 * 
	 * @return The weekdayText
	 */
	public List<Object> getWeekdayText() {
		return weekdayText;
	}

	/**
	 * 
	 * @param weekdayText
	 *            The weekday_text
	 */
	public void setWeekdayText(List<Object> weekdayText) {
		this.weekdayText = weekdayText;
	}

}
