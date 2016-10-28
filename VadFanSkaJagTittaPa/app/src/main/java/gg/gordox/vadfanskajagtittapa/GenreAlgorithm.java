package gg.gordox.vadfanskajagtittapa;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Simon on 2016-10-28.
 */

class GenreAlgorithm {

    private ArrayList<String> genres;

    private String happy;
    private String sad;
    private String angry;
    private String content;
    private String sleepy;

    private String action;
    private String adventure;
    private String comedy;
    private String drama;
    private String horror;
    private String romance;
    private String science_fiction;

    private Random random;

    GenreAlgorithm(Activity activity) {
        random = new Random();

        happy = activity.getString(R.string.mood_happy);
        sad = activity.getString(R.string.mood_sad);
        angry = activity.getString(R.string.mood_angry);
        content = activity.getString(R.string.mood_content);
        sleepy = activity.getString(R.string.mood_sleepy);

        action = activity.getString(R.string.genre_action);
        adventure = activity.getString(R.string.genre_adventure);
        comedy = activity.getString(R.string.genre_comedy);
        drama = activity.getString(R.string.genre_drama);
        horror = activity.getString(R.string.genre_horror);
        romance = activity.getString(R.string.genre_romance);
        science_fiction = activity.getString(R.string.genre_science_fiction);
    }

    String calcGenre(String weather, String mood, String preferredGenre) {
        genres = new ArrayList<>();

        analWeather(weather);
        analMood(mood);
        analPreferred(preferredGenre);

        int rand = random.nextInt(genres.size());

        Log.e("Random", rand + "");

        return genres.get(rand);
    }

    private void analWeather(String weather) {

    }

    private void analMood(String mood) {

        if (mood.equals(happy)) {
            genres.add(comedy);
            genres.add(adventure);
            genres.add(science_fiction);

        } else if (mood.equals(sad)) {
            genres.add(romance);
            genres.add(drama);

        } else if (mood.equals(angry)) {
            genres.add(action);
            genres.add(horror);
        } else if (mood.equals(content)) {
            genres.add(science_fiction);
            genres.add(adventure);
            genres.add(comedy);
        } else if (mood.equals(sleepy)) {
            genres.add(drama);
            genres.add(romance);
        }
    }

    private void analPreferred(String preferredGenre) {
        if(!preferredGenre.isEmpty()) {
            genres.add(preferredGenre);
            genres.add(preferredGenre);
        }
    }
    /**
     * Cold, rainy, very cloudy weather -> romance, drama, adventure, horror, science fiction
     * https://www.thestar.com/life/2011/10/21/winter_romance_cold_weather_attracts_us_to_romcoms_study.html
     *
     * Warm, sunny, clear weather, little cloudy -> comedy, action, adventure, science fiction
     *
     * Happy - comedy, adventure, science fiction, action
     *
     * Sad - romance, drama
     *
     * Angry - Action, horror
     *
     * Bored / Content - science fiction, adventure, comedy
     *
     * Sleepy - drama, romance
     *
     */
}
