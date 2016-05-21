
package aiss.shared.dominio.trakttv;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Images implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2908196350409443386L;
	private Poster poster;
    private Fanart fanart;


    /**
     * 
     * @return
     *     The poster
     */
    public Poster getPoster() {
        return poster;
    }

    /**
     * 
     * @param poster
     *     The poster
     */
    public void setPoster(Poster poster) {
        this.poster = poster;
    }

    /**
     * 
     * @return
     *     The fanart
     */
    public Fanart getFanart() {
        return fanart;
    }

    /**
     * 
     * @param fanart
     *     The fanart
     */
    public void setFanart(Fanart fanart) {
        this.fanart = fanart;
    }

	@Override
	public String toString() {
		return "Images [poster=" + poster + ", fanart=" + fanart + "]";
	}

}
