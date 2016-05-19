package aiss.shared.dominio.tviso;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Prices  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9188588971572039032L;
	private Double SD;
	
	public Prices() {
		
	}
	
	public Double getSD() {
		return SD;
	}
	
	public void setSD(Double sd) {
		this.SD = sd;
	}
}
