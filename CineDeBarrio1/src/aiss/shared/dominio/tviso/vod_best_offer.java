package aiss.shared.dominio.tviso;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class vod_best_offer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5751836347198534416L;
	private Integer bitMap;
	private Source source;
	private String type;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public vod_best_offer() {
	}
	/**
	 * 
	 * @return The bitMap
	 */
	public Integer getBitMap() {
		return bitMap;
	}

	/**
	 * 
	 * @param bitMap
	 *            The bitMap
	 */
	public void setBitMap(Integer bitMap) {
		this.bitMap = bitMap;
	}

	/**
	 * 
	 * @return The source
	 */
	public Source getSource() {
		return source;
	}

	/**
	 * 
	 * @param source
	 *            The source
	 */
	public void setSource(Source source) {
		this.source = source;
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;

	}

	@Override
	public String toString() {
		return "VodBestOffer [bitMap=" + bitMap + ", type=" + type + "]";
	}
}
