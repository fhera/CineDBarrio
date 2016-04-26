package aiss.shared.dominio.tmdb.buscar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {

	private static final long serialVersionUID = -8590903442118182450L;
	private Boolean adult;
	private String backdropPath;
	private List<Integer> genreIds = new ArrayList<Integer>();
	private Integer id;
	private String originalLanguage;
	private String originalTitle;
	private String overview;
	private String releaseDate;
	private String posterPath;
	private Double popularity;
	private String title;
	private Boolean video;
	private Double voteAverage;
	private Integer voteCount;
	private String mediaType;
	private String firstAirDate;
	private String originalName;
	private List<String> originCountry = new ArrayList<String>();
	private String name;

	public Result(){
		
	}
	/**
	 * 
	 * @return The adult
	 */
	public Boolean getAdult() {
		return adult;
	}

	/**
	 * 
	 * @param adult
	 *            The adult
	 */
	public void setAdult(Boolean adult) {
		this.adult = adult;
	}

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
	 * @return The genreIds
	 */
	public List<Integer> getGenreIds() {
		return genreIds;
	}

	/**
	 * 
	 * @param genreIds
	 *            The genre_ids
	 */
	public void setGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
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
	 * @return The originalTitle
	 */
	public String getOriginalTitle() {
		return originalTitle;
	}

	/**
	 * 
	 * @param originalTitle
	 *            The original_title
	 */
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
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
	 * @return The releaseDate
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

	/**
	 * 
	 * @param releaseDate
	 *            The release_date
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * 
	 * @return The posterPath
	 */
	public String getPosterPath() {
		return posterPath;
	}

	/**
	 * 
	 * @param posterPath
	 *            The poster_path
	 */
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
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
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The video
	 */
	public Boolean getVideo() {
		return video;
	}

	/**
	 * 
	 * @param video
	 *            The video
	 */
	public void setVideo(Boolean video) {
		this.video = video;
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

	/**
	 * 
	 * @return The mediaType
	 */
	public String getMediaType() {
		return mediaType;
	}

	/**
	 * 
	 * @param mediaType
	 *            The media_type
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
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
	@Override
	public String toString() {
		return "Result [adult=" + adult + ", backdropPath=" + backdropPath
				+ ", genreIds=" + genreIds + ", id=" + id
				+ ", originalLanguage=" + originalLanguage + ", originalTitle="
				+ originalTitle + ", overview=" + overview + ", releaseDate="
				+ releaseDate + ", posterPath=" + posterPath + ", popularity="
				+ popularity + ", title=" + title + ", video=" + video
				+ ", voteAverage=" + voteAverage + ", voteCount=" + voteCount
				+ ", mediaType=" + mediaType + ", firstAirDate=" + firstAirDate
				+ ", originalName=" + originalName + ", originCountry="
				+ originCountry + ", name=" + name + "]";
	}

}
