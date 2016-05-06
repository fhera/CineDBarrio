package aiss.shared.dominio.tviso;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MinPrice implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1173018685729078944L;
	private String eur;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MinPrice() {
    }
    /**
     * 
     * @return
     *     The eur
     */
    public String getEur() {
        return eur;
    }

    /**
     * 
     * @param eur
     *     The eur
     */
    public void setEur(String eur) {
        this.eur = eur;
    }

}
