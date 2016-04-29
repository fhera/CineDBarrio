package aiss.shared.dominio.tviso;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Media implements Serializable {

	private static final long serialVersionUID = -889915506586195316L;
	private Result result;
	private Integer error;

	/**
	 * No args constructor for use in serialization 
	 */
	public Media() {
	}

	/**
	 * 
	 * @param error
	 * @param result
	 */
	public Media(Result result, Integer error) {
		this.result = result;
		this.error = error;
	}

	/**
	 * 
	 * @return The result
	 */
	public Result get0() {
		return result;
	}

	/**
	 * 
	 * @param result
	 */
	public void set0(Result result) {
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
