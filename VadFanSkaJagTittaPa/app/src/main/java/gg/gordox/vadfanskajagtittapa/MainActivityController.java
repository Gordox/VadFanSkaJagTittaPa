package gg.gordox.vadfanskajagtittapa;

import android.util.Log;
import android.view.View;

/**
 * Created by Spellabbet on 2016-10-27.
 */

class MainActivityController {

    private MainActivity activity;

    private String gender = "", mood = "", genre = "";

    MainActivityController(MainActivity activity) {
        this.activity = activity;
        OmdbController.getInstance().connectController(this);
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
    }

    void MoodClick(View view){
        if(view.getId() == R.id.bn_Mood_Happy){
            mood = "Happy";
        }else if(view.getId() == R.id.bn_Mood_Sad){
            mood = "Sad";
        }else if(view.getId() == R.id.bn_Mood_Angry){
            mood = "Angry";
        }else if(view.getId() == R.id.bn_Mood_Content){
            mood = "Content";
        }else if(view.getId() == R.id.bn_Mood_Sleepy){
            mood = "Sleepy";
        }else{
            mood = "";
        }
    }

    void SearchClick(View view){
        genre = activity.getPreferedGenre().getSelectedItem().toString();
        Log.e("SIMON SAYS", genre);
        OmdbController.getInstance().search(genre);
    }

    void onMoviesReceived() {
        MovieListFragment movieListFragment = new MovieListFragment();
        movieListFragment.show(activity.getFragmentManager(), "MovieListFragment");
    }
}
