package aiss.shared.dominio.TMDB.serie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Serie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7457433909733048501L;
	private String backdrop_path;
	private List<CreatedBy> created_by = new ArrayList<CreatedBy>();
	private List<Integer> episode_run_time = new ArrayList<Integer>();
	private String first_air_date;
	private List<Genre> genres = new ArrayList<Genre>();
	private String homepage;
	private Integer id;
	private Boolean in_production;
	private List<String> languages = new ArrayList<String>();
	private String last_air_date;
	private String name;
	private List<Network> networks = new ArrayList<Network>();
	private Integer number_of_episodes;
	private Integer number_of_seasons;
	private List<String> origin_country = new ArrayList<String>();
	private String original_language;
	private String original_name;
	private String overview;
	private Double popularity;
	private String poster_path;
	private List<ProductionCompany> production_companies = new ArrayList<ProductionCompany>();
	private List<Season> seasons = new ArrayList<Season>();
	private String status;
	private String type;
	private Double vote_average;
	private Integer vote_count;

	/**
	 * 
	 * @return The backdropPath
	 */
	public String getBackdrop_path() {
		return backdrop_path;
	}

	/**
	 * 
	 * @param backdropPath
	 *            The backdrop_path
	 */
	public void setBackdrop_path(String backdropPath) {
		this.backdrop_path = backdropPath;
	}

	/**
	 * 
	 * @return The createdBy
	 */
	public List<CreatedBy> getCreated_by() {
		return created_by;
	}

	/**
	 * 
	 * @param createdBy
	 *            The created_by
	 */
	public void setCreated_by(List<CreatedBy> createdBy) {
		this.created_by = createdBy;
	}

	/**
	 * 
	 * @return The episodeRunTime
	 */
	public List<Integer> getEpisode_run_time() {
		return episode_run_time;
	}

	/**
	 * 
	 * @param episodeRunTime
	 *            The episode_run_time
	 */
	public void setEpisode_run_time(List<Integer> episodeRunTime) {
		this.episode_run_time = episodeRunTime;
	}

	/**
	 * 
	 * @return The firstAirDate
	 */
	public String getFirst_air_date() {
		return first_air_date;
	}

	/**
	 * 
	 * @param firstAirDate
	 *            The first_air_date
	 */
	public void setFirst_air_date(String firstAirDate) {
		this.first_air_date = firstAirDate;
	}

	/**
	 * 
	 * @return The genres
	 */
	public List<Genre> getGenres() {
		return genres;
	}

	/**
	 * 
	 * @param genres
	 *            The genres
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	/**
	 * 
	 * @return The homepage
	 */
	public String getHomepage() {
		return homepage;
	}

	/**
	 * 
	 * @param homepage
	 *            The homepage
	 */
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

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
	 * @return The inProduction
	 */
	public Boolean getInProduction() {
		return in_production;
	}

	/**
	 * 
	 * @param inProduction
	 *            The in_production
	 */
	public void setIn_production(Boolean inProduction) {
		this.in_production = inProduction;
	}

	/**
	 * 
	 * @return The languages
	 */
	public List<String> getLanguages() {
		return languages;
	}

	/**
	 * 
	 * @param languages
	 *            The languages
	 */
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	/**
	 * 
	 * @return The lastAirDate
	 */
	public String getLast_air_date() {
		return last_air_date;
	}

	/**
	 * 
	 * @param lastAirDate
	 *            The last_air_date
	 */
	public void setLast_air_date(String lastAirDate) {
		this.last_air_date = lastAirDate;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The networks
	 */
	public List<Network> getNetworks() {
		return networks;
	}

	/**
	 * 
	 * @param networks
	 *            The networks
	 */
	public void setNetworks(List<Network> networks) {
		this.networks = networks;
	}

	/**
	 * 
	 * @return The numberOfEpisodes
	 */
	public Integer getNumber_of_episodes() {
		return number_of_episodes;
	}

	/**
	 * 
	 * @param numberOfEpisodes
	 *            The number_of_episodes
	 */
	public void setNumber_of_episodes(Integer numberOfEpisodes) {
		this.number_of_episodes = numberOfEpisodes;
	}

	/**
	 * 
	 * @return The numberOfSeasons
	 */
	public Integer getNumber_of_seasons() {
		return number_of_seasons;
	}

	/**
	 * 
	 * @param numberOfSeasons
	 *            The number_of_seasons
	 */
	public void setNumber_of_seasons(Integer numberOfSeasons) {
		this.number_of_seasons = numberOfSeasons;
	}

	/**
	 * 
	 * @return The originCountry
	 */
	public List<String> getOrigin_country() {
		return origin_country;
	}

	/**
	 * 
	 * @param originCountry
	 *            The origin_country
	 */
	public void setOrigin_country(List<String> originCountry) {
		this.origin_country = originCountry;
	}

	/**
	 * 
	 * @return The originalLanguage
	 */
	public String getOriginal_language() {
		return original_language;
	}

	/**
	 * 
	 * @param originalLanguage
	 *            The original_language
	 */
	public void setOriginal_language(String originalLanguage) {
		this.original_language = originalLanguage;
	}

	/**
	 * 
	 * @return The originalName
	 */
	public String getOriginal_name() {
		return original_name;
	}

	/**
	 * 
	 * @param originalName
	 *            The original_name
	 */
	public void setOriginal_name(String originalName) {
		this.original_name = originalName;
	}

	/**
	 * 
	 * @return The overview
	 */
	public String getOverview() {
		return overview;
	}

	/**
	 * 
	 * @param overview
	 *            The overview
	 */
	public void setOverview(String overview) {
		this.overview = overview;
	}

	/**
	 * 
	 * @return The popularity
	 */
	public Double getPopularity() {
		return popularity;
	}

	/**
	 * 
	 * @param popularity
	 *            The popularity
	 */
	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}

	/**
	 * 
	 * @return The posterPath
	 */
	public String getPoster_path() {
		return poster_path;
	}

	/**
	 * 
	 * @param posterPath
	 *            The poster_path
	 */
	public void setPoster_path(String posterPath) {
		this.poster_path = posterPath;
	}

	/**
	 * 
	 * @return The productionCompanies
	 */
	public List<ProductionCompany> getProduction_companies() {
		return production_companies;
	}

	/**
	 * 
	 * @param productionCompanies
	 *            The production_companies
	 */
	public void setProduction_companies(
			List<ProductionCompany> productionCompanies) {
		this.production_companies = productionCompanies;
	}

	/**
	 * 
	 * @return The seasons
	 */
	public List<Season> getSeasons() {
		return seasons;
	}

	/**
	 * 
	 * @param seasons
	 *            The seasons
	 */
	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	/**
	 * 
	 * @return The status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The voteAverage
	 */
	public Double getVote_average() {
		return vote_average;
	}

	/**
	 * 
	 * @param voteAverage
	 *            The vote_average
	 */
	public void setVote_average(Double voteAverage) {
		this.vote_average = voteAverage;
	}

	/**
	 * 
	 * @return The voteCount
	 */
	public Integer getVote_count() {
		return vote_count;
	}

	/**
	 * 
	 * @param voteCount
	 *            The vote_count
	 */
	public void setVote_count(Integer voteCount) {
		this.vote_count = voteCount;
	}

}
