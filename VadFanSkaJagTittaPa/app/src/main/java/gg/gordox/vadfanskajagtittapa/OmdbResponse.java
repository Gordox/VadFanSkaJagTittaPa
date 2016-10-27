/*
 * The MIT License (MIT)
 * Copyright (c) 2016 Rodrigo Santoro
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package gg.gordox.vadfanskajagtittapa;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OmdbResponse {
	
	@JsonProperty("Title") private String title;
	@JsonProperty("Year") private String year;
	@JsonProperty("Rated") private String rated;
	@JsonProperty("Released") private String releaseDate;
	@JsonProperty("Runtime") private String runtime;
	@JsonProperty("Genre") private String genre;
	@JsonProperty("Director") private String director;
	@JsonProperty("Writer") private String writer;
	@JsonProperty("Actors") private String actors;
	@JsonProperty("Plot") private String plot;
	@JsonProperty("Language") private String language;
	@JsonProperty("Country") private String country;
	@JsonProperty("Awards") private String awards;
	@JsonProperty("Poster") private String poster;
	@JsonProperty("Metascore") private String metascore;
	@JsonProperty("imdbRating") private String imdbRating;
	@JsonProperty("imdbVotes") private String imdbVotes;
	@JsonProperty("imdbID") private String imdbId;
	@JsonProperty("Type") private String type;
	@JsonProperty("totalSeasons") private String totalSeasons;
	
	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @return year
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * @return age rating
	 */
	public String getRated() {
		return rated;
	}

	/**
	 * @return release date
	 */
	public String getReleaseDate() {
		return releaseDate;
	}
	
	/**
	 * @return runtime in minutes
	 */
	public String getRuntime() {
		return runtime;
	}
	
	/**
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}
	
	/**
	 * @return director
	 */
	public String getDirector() {
		return director;
	}
	
	/**
	 * @return writer
	 */
	public String getWriter() {
		return writer;
	}
	
	/**
	 * @return actors
	 */
	public String getActors() {
		return actors;
	}
	
	/**
	 * @return plot
	 */
	public String getPlot() {
		return plot;
	}

	/**
	 * @return language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return awards
	 */
	public String getAwards() {
		return awards;
	}

	/**
	 * @return link to the poster
	 */
	public String getPoster() {
		return poster;
	}

	/**
	 * @return metascore
	 */
	public String getMetascore() {
		return metascore;
	}

	/**
	 * @return imdb rating out of 10
	 */
	public String getImdbRating() {
		return imdbRating;
	}
	
	/**
	 * @return imdb votes
	 */
	public String getImdbVotes() {
		return imdbVotes;
	}
	
	/**
	 * @return imdb id
	 */
	public String getImdbId() {
		return imdbId;
	}
	
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @return total number of seasons
	 */
	public String getTotalSeasons() {
		return totalSeasons;
	}
}