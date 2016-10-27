package gg.gordox.vadfanskajagtittapa;

import android.util.Log;

import java.io.IOException;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by Simon on 2016-10-27.
 */
    class OmdbController {
    private static OmdbController ourInstance = new OmdbController();
    static OmdbController getInstance() {
        return ourInstance;
    }

    private OmdbController() {
    }

    void search(String genre) {
        new OmdbTask(Movies.getTitles(genre)).start();
    }

    private class OmdbTask extends Thread {
        Stack<String> titles;
        OmdbTask(String[] titles) {
            this.titles = new Stack<>();
            Collections.addAll(this.titles, titles);
        }

        public void run() {
            try {
                while(!titles.isEmpty()) {
                    String title = titles.pop();
                    OMDB omdb = new OMDB();
                    omdb.setPlot(OMDB.FULL_PLOT);
                    OmdbResponse response = omdb.search(title);

                    Log.e("TITLE", response.getTitle());
                    Log.e("YEAR", response.getYear());
                    Log.e("POSTER", response.getActors());
                    Log.e("POSTER", response.getPoster());
                    Log.e("PLOT", response.getPlot());
                }
            } catch (IOException ignored) {

            }
        }
    }
}