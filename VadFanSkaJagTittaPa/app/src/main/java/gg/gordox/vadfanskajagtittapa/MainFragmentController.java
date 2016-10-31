package gg.gordox.vadfanskajagtittapa;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Spellabbet on 2016-10-27.
 */

class MainFragmentController {

    private MainFragment ui;
    private GenreAlgorithm algo;

    private String gender = "";
    private String mood = "";
    private String weather = "";
    private String preferred = "";

    MainFragmentController(MainFragment ui) {
        this.ui = ui;
        OmdbController.getInstance().connectController(this);
        algo = new GenreAlgorithm(ui);
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
            mood = ui.getString(R.string.mood_happy);
        } else if (view.getId() == R.id.bn_Mood_Sad){
            mood = ui.getString(R.string.mood_sad);
        } else if (view.getId() == R.id.bn_Mood_Angry){
            mood = ui.getString(R.string.mood_angry);
        } else if (view.getId() == R.id.bn_Mood_Content){
            mood = ui.getString(R.string.mood_content);
        } else if (view.getId() == R.id.bn_Mood_Sleepy){
            mood = ui.getString(R.string.mood_sleepy);
        } else {
            mood = "";
        }
    }

    void SearchClick(View view){
        if(gender.equals("")) {
            Toast.makeText(ui.getActivity(), "No gender selected! You don't want us to assume your gender, do you?", Toast.LENGTH_LONG).show();
            return;
        }
        if(mood.equals("")) {
            Toast.makeText(ui.getActivity(), "No mood selected!", Toast.LENGTH_SHORT).show();
            return;
        }
        weather = WeatherRetreiver.getInstance(ui.getActivity()).getCondition();
        String genre = algo.calcGenre(weather, mood, preferred);
        OmdbController.getInstance().search(genre);
    }

    void onMoviesReceived() {
        FragmentManager fm = ui.getActivity().getFragmentManager();

        FragmentTransaction ft =  fm.beginTransaction().replace(R.id.activity_main,
                new MovieListFragment(),"movieListFragment");
        ft.addToBackStack("movieListFragment");
        ft.commit();
    }
}
