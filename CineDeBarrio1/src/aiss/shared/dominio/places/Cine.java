package aiss.shared.dominio.places;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
public class Cine implements Serializable {

	private static final long serialVersionUID = 6434635488240857964L;
	private Geometry geometry;
	private String icon;
	private String id;
	private String name;
	private OpeningHours openingHours;
	private List<Photo> photos = new ArrayList<Photo>();
	private String placeId;
	private Double rating;
	private String reference;
	private String scope;
	private List<String> types = new ArrayList<String>();
	private String vicinity;

	/**
	 * 
	 * @return The geometry
	 */
	public Geometry getGeometry() {
		return geometry;
	}

	/**
	 * 
	 * @param geometry
	 *            The geometry
	 */
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	/**
	 * 
	 * @return The icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 
	 * @param icon
	 *            The icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
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
	 * @return The openingHours
	 */
	public OpeningHours getOpeningHours() {
		return openingHours;
	}

	/**
	 * 
	 * @param openingHours
	 *            The opening_hours
	 */
	public void setOpeningHours(OpeningHours openingHours) {
		this.openingHours = openingHours;
	}

	/**
	 * 
	 * @return The photos
	 */
	public List<Photo> getPhotos() {
		return photos;
	}

	/**
	 * 
	 * @param photos
	 *            The photos
	 */
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	/**
	 * 
	 * @return The placeId
	 */
	public String getPlaceId() {
		return placeId;
	}

	/**
	 * 
	 * @param placeId
	 *            The place_id
	 */
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	/**
	 * 
	 * @return The rating
	 */
	public Double getRating() {
		return rating;
	}

	/**
	 * 
	 * @param rating
	 *            The rating
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}

    /**
     * 
     * @return
     *     The reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * 
     * @param reference
     *     The reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * 
     * @return
     *     The scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * 
     * @param scope
     *     The scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * 
     * @return
     *     The types
     */
    public List<String> getTypes() {
        return types;
    }

    /**
     * 
     * @param types
     *     The types
     */
    public void setTypes(List<String> types) {
        this.types = types;
    }

    /**
     * 
     * @return
     *     The vicinity
     */
    public String getVicinity() {
        return vicinity;
    }

    /**
     * 
     * @param vicinity
     *     The vicinity
     */
    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

}
