package aiss.shared.dominio.tviso;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusquedaTviso implements Serializable {

	private static final long serialVersionUID = -889915506586195316L;
	private Media result;
	private Integer error;

	/**
	 * No args constructor for use in serialization
	 */
	public BusquedaTviso() {
	}

	/**
	 * 
	 * @return The result
	 */
	public Media get0() {
		return result;
	}

	/**
	 * 
	 * @param result
	 */
	public void set0(Media result) {
		this.result = result;
	}

	/**
	 * 
	 * @return The error
	 */
	public Integer getError() {
		return error;
	}

	/**
	 * 
	 * @param error
	 *            The error
	 */
	public void setError(Integer error) {
		this.error = error;
	}

}
