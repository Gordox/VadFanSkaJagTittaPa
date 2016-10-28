package gg.gordox.vadfanskajagtittapa;

/**
 * Created by Spellabbet on 2016-10-27.
 */

class Movie {
    final String title;
    final String genre;
    final String releaseDate;
    final String plot;
    final String imageUrl;

    Movie(String title, String releaseDate, String genre, String plot, String imageUrl) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.plot = plot;
        this.imageUrl = imageUrl;
    }
}