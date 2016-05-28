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
	private String backdropPath;
	private List<CreatedBy> createdBy = new ArrayList<CreatedBy>();
	private List<Integer> episodeRunTime = new ArrayList<Integer>();
	private String firstAirDate;
	private List<Genre> genres = new ArrayList<Genre>();
	private String homepage;
	private Integer id;
	private Boolean inProduction;
	private List<String> languages = new ArrayList<String>();
	private String lastAirDate;
	private String name;
	private List<Network> networks = new ArrayList<Network>();
	private Integer numberOfEpisodes;
	private Integer numberOfSeasons;
	private List<String> originCountry = new ArrayList<String>();
	private String originalLanguage;
	private String originalName;
	private String overview;
	private Double popularity;
	private String poster_path;
	private List<ProductionCompany> productionCompanies = new ArrayList<ProductionCompany>();
	private List<Season> seasons = new ArrayList<Season>();
	private String status;
	private String type;
	private Double voteAverage;
	private Integer voteCount;

	/**
	 * 
	 * @return The backdropPath
	 */
	public String getBackdropPath() {
		return backdropPath;
	}

	/**
	 * 
	 * @param backdropPath
	 *            The backdrop_path
	 */
	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	/**
	 * 
	 * @return The createdBy
	 */
	public List<CreatedBy> getCreatedBy() {
		return createdBy;
	}

	/**
	 * 
	 * @param createdBy
	 *            The created_by
	 */
	public void setCreatedBy(List<CreatedBy> createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * 
	 * @return The episodeRunTime
	 */
	public List<Integer> getEpisodeRunTime() {
		return episodeRunTime;
	}

	/**
	 * 
	 * @param episodeRunTime
	 *            The episode_run_time
	 */
	public void setEpisodeRunTime(List<Integer> episodeRunTime) {
		this.episodeRunTime = episodeRunTime;
	}

	/**
	 * 
	 * @return The firstAirDate
	 */
	public String getFirstAirDate() {
		return firstAirDate;
	}

	/**
	 * 
	 * @param firstAirDate
	 *            The first_air_date
	 */
	public void setFirstAirDate(String firstAirDate) {
		this.firstAirDate = firstAirDate;
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
		return inProduction;
	}

	/**
	 * 
	 * @param inProduction
	 *            The in_production
	 */
	public void setInProduction(Boolean inProduction) {
		this.inProduction = inProduction;
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
	public String getLastAirDate() {
		return lastAirDate;
	}

	/**
	 * 
	 * @param lastAirDate
	 *            The last_air_date
	 */
	public void setLastAirDate(String lastAirDate) {
		this.lastAirDate = lastAirDate;
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
	public Integer getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	/**
	 * 
	 * @param numberOfEpisodes
	 *            The number_of_episodes
	 */
	public void setNumberOfEpisodes(Integer numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}

	/**
	 * 
	 * @return The numberOfSeasons
	 */
	public Integer getNumberOfSeasons() {
		return numberOfSeasons;
	}

	/**
	 * 
	 * @param numberOfSeasons
	 *            The number_of_seasons
	 */
	public void setNumberOfSeasons(Integer numberOfSeasons) {
		this.numberOfSeasons = numberOfSeasons;
	}

	/**
	 * 
	 * @return The originCountry
	 */
	public List<String> getOriginCountry() {
		return originCountry;
	}

	/**
	 * 
	 * @param originCountry
	 *            The origin_country
	 */
	public void setOriginCountry(List<String> originCountry) {
		this.originCountry = originCountry;
	}

	/**
	 * 
	 * @return The originalLanguage
	 */
	public String getOriginalLanguage() {
		return originalLanguage;
	}

	/**
	 * 
	 * @param originalLanguage
	 *            The original_language
	 */
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	/**
	 * 
	 * @return The originalName
	 */
	public String getOriginalName() {
		return originalName;
	}

	/**
	 * 
	 * @param originalName
	 *            The original_name
	 */
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
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
	public List<ProductionCompany> getProductionCompanies() {
		return productionCompanies;
	}

	/**
	 * 
	 * @param productionCompanies
	 *            The production_companies
	 */
	public void setProductionCompanies(
			List<ProductionCompany> productionCompanies) {
		this.productionCompanies = productionCompanies;
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
	public Double getVoteAverage() {
		return voteAverage;
	}

	/**
	 * 
	 * @param voteAverage
	 *            The vote_average
	 */
	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}

	/**
	 * 
	 * @return The voteCount
	 */
	public Integer getVoteCount() {
		return voteCount;
	}

	/**
	 * 
	 * @param voteCount
	 *            The vote_count
	 */
	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

}
