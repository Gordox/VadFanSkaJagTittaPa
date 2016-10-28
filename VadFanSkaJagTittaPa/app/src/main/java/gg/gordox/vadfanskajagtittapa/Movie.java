package gg.gordox.vadfanskajagtittapa;

/**
 * Created by Spellabbet on 2016-10-27.
 */

public class Movie {
    public final String title;
    public final String genre;
    public final String releaseDate;
    public final String plot;
    public final String imageUrl;

    public Movie(String title, String releaseDate, String genre, String plot, String imageUrl) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.plot = plot;
        this.imageUrl = imageUrl;
    }
}