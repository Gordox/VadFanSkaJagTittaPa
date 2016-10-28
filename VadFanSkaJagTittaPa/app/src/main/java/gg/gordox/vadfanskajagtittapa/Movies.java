package gg.gordox.vadfanskajagtittapa;

import android.app.Activity;

import java.util.HashMap;

/**
 * Created by Simon on 2016-10-27.
 */

class Movies {
    private static HashMap<String, String[]> data;

    static String[] getTitles(String genre) {
        return data.get(genre);
    }

    static void init(Activity activity) {
        data = new HashMap<>();
        init_action(activity);
        init_action(activity);
        init_adventure(activity);
        init_comedy(activity);
        init_drama(activity);
        init_horror(activity);
        init_romance(activity);
        init_science_fiction(activity);
    }

    private static void init_action(Activity activity) {
        data.put(activity.getString(R.string.genre_action), new String[]{
                "Batman",
                "Gladiator",
                "Lethal Weapon",
                "Mad Max"
        });
    }

    private static void init_adventure(Activity activity) {
        data.put(activity.getString(R.string.genre_adventure), new String[]{
                "Indiana Jones",
                "Harry Potter",
                "Lord of the Rings",
                "James Bond"
        });
    }

    private static void init_comedy(Activity activity) {
        data.put(activity.getString(R.string.genre_comedy), new String[]{
                "Borat",
                "Zoolander",
                "The Hangover",
                "Silver Linings Playbook"
        });
    }

    private static void init_drama(Activity activity) {
        data.put(activity.getString(R.string.genre_drama), new String[]{
                "Titanic",
                "American Beauty",
                "Forrest Gump",
                "Cast Away"
        });
    }

    private static void init_horror(Activity activity) {
        data.put(activity.getString(R.string.genre_horror), new String[]{
                "Paranormal Activity",
                "The Shining",
                "Elm Street",
                "Scream"
        });
    }

    private static void init_romance(Activity activity) {
        data.put(activity.getString(R.string.genre_romance), new String[]{
                "Love Actually",
                "Eternal Sunshine",
                "Brokeback Mountain",
                "The Notebook",
                "Bridget Jones’ Diary"
        });
    }

    private static void init_science_fiction(Activity activity) {
        data.put(activity.getString(R.string.genre_science_fiction), new String[]{
                "Ex Machina",
                "Matrix",
                "E.T",
                "Avatar",
                "Star Wars",
                "Dr Who"
        });
    }
}