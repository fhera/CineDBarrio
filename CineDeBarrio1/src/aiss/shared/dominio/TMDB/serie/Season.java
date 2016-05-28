
package aiss.shared.dominio.TMDB.serie;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Season implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7625975041945691796L;
	private String airDate;
    private Integer episodeCount;
    private Integer id;
    private String posterPath;
    private Integer seasonNumber;

    /**
     * 
     * @return
     *     The airDate
     */
    public String getAirDate() {
        return airDate;
    }

    /**
     * 
     * @param airDate
     *     The air_date
     */
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    /**
     * 
     * @return
     *     The episodeCount
     */
    public Integer getEpisodeCount() {
        return episodeCount;
    }

    /**
     * 
     * @param episodeCount
     *     The episode_count
     */
    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The posterPath
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     * 
     * @param posterPath
     *     The poster_path
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     * 
     * @return
     *     The seasonNumber
     */
    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    /**
     * 
     * @param seasonNumber
     *     The season_number
     */
    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

}
