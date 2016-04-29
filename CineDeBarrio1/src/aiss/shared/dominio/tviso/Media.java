package aiss.shared.dominio.tviso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Media implements Serializable {

	private static final long serialVersionUID = -8388941791805584549L;
	private Integer idm;
	private Integer mediaType;
	private String mediaStyle;
	private String imdb;
	private Double rating;
	private String name;
	private String originalName;
	private Images images;
	private String maingenre;
	private Integer year;
	private String plot;	
	private String idMedia;
	private List<Object> vodBestOffer = new ArrayList<Object>();

	/**
	 * No args constructor for use in serialization
	 */
	public Media() {
	}

	/**
	 * @return The idm
	 */
	public Integer getIdm() {
		return idm;
	}

	/**
	 * @param idm
	 *            The idm
	 */
	public void setIdm(Integer idm) {
		this.idm = idm;
	}

	/**
	 * 
	 * @return The mediaType
	 */
	public Integer getMediaType() {
		return mediaType;
	}

	/**
	 * @param mediaType
	 *            The mediaType
	 */
	public void setMediaType(Integer mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * @return The mediaStyle
	 */
	public String getMediaStyle() {
		return mediaStyle;
	}

	/**
	 * @param mediaStyle
	 *            The mediaStyle
	 */
	public void setMediaStyle(String mediaStyle) {
		this.mediaStyle = mediaStyle;
	}

	/**
	 * @return The imdb
	 */
	public String getImdb() {
		return imdb;
	}

	/**
	 * @param imdb
	 *            The imdb
	 */
	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	/**
	 * @return The rating
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            The rating
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}

	/**
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The originalName
	 */
	public String getOriginalName() {
		return originalName;
	}

	/**
	 * @param originalName
	 *            The original_name
	 */
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	/**
	 * @return The images
	 */
	public Images getImages() {
		return images;
	}

	/**
	 * @param images
	 *            The images
	 */
	public void setImages(Images images) {
		this.images = images;
	}

	/**
	 * @return The maingenre
	 */
	public String getMaingenre() {
		return maingenre;
	}

	/**
	 * @param maingenre
	 *            The maingenre
	 */
	public void setMaingenre(String maingenre) {
		this.maingenre = maingenre;
	}

	/**
	 * @return The year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year
	 *            The year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * @return The plot
	 */
	public String getPlot() {
		return plot;
	}

	/**
	 * @param plot
	 *            The plot
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/**
	 * @return The idMedia
	 */
	public String getIdMedia() {
		return idMedia;
	}

	/**
	 * @param idMedia
	 *            The id_media
	 */
	public void setIdMedia(String idMedia) {
		this.idMedia = idMedia;
	}

	/**
	 * @return The vodBestOffer
	 */
	public List<Object> getVodBestOffer() {
		return vodBestOffer;
	}

	/**
	 * @param vodBestOffer
	 *            The vod_best_offer
	 */
	public void setVodBestOffer(List<Object> vodBestOffer) {
		this.vodBestOffer = vodBestOffer;
	}
}
