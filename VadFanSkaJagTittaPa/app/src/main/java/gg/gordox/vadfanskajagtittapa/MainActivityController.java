package gg.gordox.vadfanskajagtittapa;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Spellabbet on 2016-10-27.
 */

class MainActivityController {

    private MainActivity activity;
    private GenreAlgorithm algo;

    private String gender = "";
    private String mood = "";
    private String weather = "";
    private String preferred = "";

    MainActivityController(MainActivity activity) {
        this.activity = activity;
        OmdbController.getInstance().connectController(this);
        algo = new GenreAlgorithm(activity);
    }

    void GenderClick(View view){
        if(view.getId() == R.id.bn_Gender_Male){
            gender = "Male";
        }else if(view.getId() == R.id.bn_Gender_Female){
            gender = "Female";
        }else if(view.getId() == R.id.bn_Gender_TosaPog){
            gender = "TosaPog";
        }
        else{
            gender = "";
        }
        Log.e("Gender set to", gender);
    }

    void MoodClick(View view){
        if(view.getId() == R.id.bn_Mood_Happy){
            mood = activity.getString(R.string.mood_happy);
        } else if (view.getId() == R.id.bn_Mood_Sad){
            mood = activity.getString(R.string.mood_sad);
        } else if (view.getId() == R.id.bn_Mood_Angry){
            mood = activity.getString(R.string.mood_angry);
        } else if (view.getId() == R.id.bn_Mood_Content){
            mood = activity.getString(R.string.mood_content);
        } else if (view.getId() == R.id.bn_Mood_Sleepy){
            mood = activity.getString(R.string.mood_sleepy);
        } else {
            mood = "";
        }
        Log.e("Mood set to", mood);
    }

    void SearchClick(View view){
        if(mood.equals("")) {
            Toast.makeText(activity, "No mood selected!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(gender.equals("")) {
            Toast.makeText(activity, "No gender selected! You don't want us to assume your gender, do you?", Toast.LENGTH_LONG).show();
            return;
        }
        String genre = algo.calcGenre(weather, mood, preferred);
        OmdbController.getInstance().search(genre);
    }

    void onMoviesReceived() {
        MovieListFragment movieListFragment = new MovieListFragment();
        movieListFragment.show(activity.getFragmentManager(), "MovieListFragment");
    }
}
