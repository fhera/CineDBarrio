package aiss.shared.dominio.tmdb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import aiss.shared.dominio.tmdb.Result;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pelicula implements Serializable {

	private static final long serialVersionUID = 6682667437260316383L;
	private Integer page;
	private List<Result> results = new ArrayList<Result>();
	private Integer totalResults;
	private Integer totalPages;

	public Pelicula() {
	}

	/**
	 * 
	 * @return The page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * 
	 * @param page
	 *            The page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * 
	 * @return The results
	 */
	public List<Result> getResults() {
		return results;
	}

	/**
	 * 
	 * @param results
	 *            The results
	 */
	public void setResults(List<Result> results) {
		this.results = results;
	}

	/**
	 * 
	 * @return The totalResults
	 */
	public Integer getTotalResults() {
		return totalResults;
	}

	/**
	 * 
	 * @param totalResults
	 *            The total_results
	 */
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	/**
	 * 
	 * @return The totalPages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * 
	 * @param totalPages
	 *            The total_pages
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

}
