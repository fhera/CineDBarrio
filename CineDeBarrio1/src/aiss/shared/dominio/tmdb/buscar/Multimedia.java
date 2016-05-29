package aiss.shared.dominio.tmdb.buscar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Multimedia implements Serializable {

	private static final long serialVersionUID = -8590903442118182450L;
	private Boolean adult;
	private String backdrop_path;
	private List<Integer> genre_ids = new ArrayList<Integer>();
	private Integer id;
	private String original_language;
	private String original_title;
	private String overview;
	private String release_date;
	private String poster_path;
	private Double popularity;
	private String title;
	private Boolean video;
	private Double vote_average;
	private Integer vote_count;
	private String first_air_date;
	private String original_name;
	private List<String> origin_country = new ArrayList<String>();
	private String name;

	public Multimedia() {

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
	 * @return The genreIds
	 */
	public List<Integer> getGenre_ids() {
		return genre_ids;
	}

	/**
	 * 
	 * @param genreIds
	 *            The genre_ids
	 */
	public void setGenre_ids(List<Integer> genreIds) {
		this.genre_ids = genreIds;
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
	 * @return The originalTitle
	 */
	public String getOriginal_title() {
		return original_title;
	}

	/**
	 * 
	 * @param originalTitle
	 *            The original_title
	 */
	public void setOriginal_title(String originalTitle) {
		this.original_title = originalTitle;
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
	public String getRelease_date() {
		return release_date;
	}

	/**
	 * 
	 * @param releaseDate
	 *            The release_date
	 */
	public void setRelease_date(String releaseDate) {
		this.release_date = releaseDate;
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
		return "Result [adult=" + adult + ", backdropPath=" + backdrop_path
				+ ", genreIds=" + genre_ids + ", id=" + id
				+ ", originalLanguage=" + original_language
				+ ", originalTitle=" + original_title + ", overview="
				+ overview + ", releaseDate=" + release_date + ", posterPath="
				+ poster_path + ", popularity=" + popularity + ", title="
				+ title + ", video=" + video + ", voteAverage=" + vote_average
				+ ", voteCount=" + vote_count + ", firstAirDate="
				+ first_air_date + ", originalName=" + original_name
				+ ", originCountry=" + origin_country + ", name=" + name + "]";
	}

}
