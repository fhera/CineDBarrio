package aiss.shared.dominio.tviso;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusquedaTviso implements Serializable {

	private static final long serialVersionUID = -889915506586195316L;
	private Media result;
	private Media1 result1;
	private Media2 result2;
	private Media3 result3;
	private Media4 result4;
	private Integer error;

	/**
	 * No args constructor for use in serialization
	 */
	public BusquedaTviso() {
	}

	public Media get0() {
		return result;
	}

	public void set0(Media result) {
		this.result = result;
	}
	
	public Media1 get1() {
		return result1;
	}

	public void set1(Media1 result1) {
		this.result1 = result1;
	}
	
	public Media2 get2() {
		return result2;
	}

	public void set2(Media2 result2) {
		this.result2 = result2;
	}

	public Media3 get3() {
		return result3;
	}

	public void set3(Media3 result3) {
		this.result3 = result3;
	}
	
	public Media4 get4() {
		return result4;
	}

	public void set4(Media4 result4) {
		this.result4 = result4;
	}

	/**
	 * @return The error
	 */
	public Integer getError() {
		return error;
	}

	/**
	 * @param error
	 *            The error
	 */
	public void setError(Integer error) {
		this.error = error;
	}
}
