
package aiss.shared.dominio.places;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class OpeningHours {

    private Boolean openNow;
    private List<Object> weekdayText = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The openNow
     */
    public Boolean getOpenNow() {
        return openNow;
    }

    /**
     * 
     * @param openNow
     *     The open_now
     */
    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    /**
     * 
     * @return
     *     The weekdayText
     */
    public List<Object> getWeekdayText() {
        return weekdayText;
    }

    /**
     * 
     * @param weekdayText
     *     The weekday_text
     */
    public void setWeekdayText(List<Object> weekdayText) {
        this.weekdayText = weekdayText;
    }

}
