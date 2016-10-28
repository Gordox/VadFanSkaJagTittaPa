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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class OMDB {
	
	public static final String SHORT_PLOT = "short";
	public static final String FULL_PLOT = "full";
	
	private final String TITLE_TAG = "<TITLE>";
	private final String YEAR_TAG = "<YEAR>";
	private final String PLOT_TAG = "<PLOT>";
	
	private String plot = "short";
	
	private String url = "http://www.omdbapi.com/?t=<TITLE>&y=<YEAR>&plot=<PLOT>&r=json";
	
	private ObjectMapper mapper;
	
	OMDB() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	/**
	 * @param plot Plot can be either short or full. Usage: OMDB.SHORT_PLOT for short plot and OMDB.FULL_PLOT for the full plot.
	 */
	void setPlot(String plot) {
		this.plot = plot;
	}
	
	/**
	 * @param title
	 * @return OmdbResponse object containing all the attributes
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	OmdbResponse search(String title) throws IOException {
		setURL(title, "", plot);
		return mapper.readValue(new URL(url), OmdbResponse.class);
	}
	
	private void setURL(String title, String year, String plot) {
		title = title.replaceAll(" ", "+").trim();
		url = url.replace(TITLE_TAG, title).replace(YEAR_TAG, year).replace(PLOT_TAG, plot);
	}
}