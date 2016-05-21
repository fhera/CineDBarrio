
package aiss.shared.dominio.trakttv;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListSeries implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8260285091596452361L;
	private String type;
    private Double score;
    private Show show;
    
    public ListSeries() {
	}


    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The score
     */
    public Double getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * 
     * @return
     *     The show
     */
    public Show getShow() {
        return show;
    }

    /**
     * 
     * @param show
     *     The show
     */
    public void setShow(Show show) {
        this.show = show;
    }

	@Override
	public String toString() {
		return "ListSeries [type=" + type + ", score=" + score + ", show="
				+ show + "]";
	}

}
