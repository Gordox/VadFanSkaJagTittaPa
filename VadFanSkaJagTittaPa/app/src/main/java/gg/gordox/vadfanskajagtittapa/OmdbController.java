package gg.gordox.vadfanskajagtittapa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Simon on 2016-10-27.
 */
public class OmdbController {
    private static OmdbController ourInstance = new OmdbController();
    public static OmdbController getInstance() {
        return ourInstance;
    }
    private OMDB omdb = new OMDB();

    private OmdbController() {

    }

    public void search(String genre) {
    }

    private class OmdbTask implements Runnable {
        public OmdbTask() {
        }

        public void run() {
            try {
                OmdbResponse response = omdb.search("");
            } catch (IOException ignored) {

            }
        }
    }
}
