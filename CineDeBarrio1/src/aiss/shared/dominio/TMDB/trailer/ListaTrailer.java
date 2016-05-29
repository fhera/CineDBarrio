package aiss.shared.dominio.TMDB.trailer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaTrailer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4251915262795804730L;
	private Integer id;
	private List<Trailer> results = new ArrayList<Trailer>();

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
	 * @return The results
	 */
	public List<Trailer> getResults() {
		return results;
	}

	/**
	 * 
	 * @param results
	 *            The results
	 */
	public void setResults(List<Trailer> results) {
		this.results = results;
	}

}
