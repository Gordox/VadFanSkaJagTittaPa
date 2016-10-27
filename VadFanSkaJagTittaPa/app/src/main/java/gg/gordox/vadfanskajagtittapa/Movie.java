package gg.gordox.vadfanskajagtittapa;

/**
 * Created by Spellabbet on 2016-10-27.
 */

public class Movie {
    public final String title;
    public final String year;
    public final String plot;
    public final String imageUrl;

    public Movie(String title, String year, String plot, String imageUrl) {
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.imageUrl = imageUrl;
    }
}