package gg.gordox.vadfanskajagtittapa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ImageButton bnGenderMale, bnGenderFemale, bnGenderTosaPog;
    private ImageButton bnMoodHappy, bnMoodSad, bnMoodAngry, bnMoodContent, bnMoodSleepy;
    private Button bnSearch;
    private Spinner spPreferredGenre;
    private MainActivityController controller;
    private WeatherRetreiver weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Init();
    }

    public void OnGenderClick(View v){
        controller.GenderClick(v);
        Log.e("Gender: ", v.getId()+"");
    }

    public void OnMoodClick(View v){
        controller.MoodClick(v);
        Log.e("Mood: ", v.getId()+"");
    }

    public void OnSearchClick(View v){
        controller.SearchClick(v);
        Log.e("Search: ", v.getId()+"");
    }

    private void Init(){
        bnGenderMale = (ImageButton) findViewById(R.id.bn_Gender_Male);
        bnGenderFemale = (ImageButton) findViewById(R.id.bn_Gender_Female);
        bnGenderTosaPog = (ImageButton) findViewById(R.id.bn_Gender_TosaPog);

        bnMoodHappy = (ImageButton) findViewById(R.id.bn_Mood_Happy);
        bnMoodSad = (ImageButton) findViewById(R.id.bn_Mood_Sad);
        bnMoodAngry = (ImageButton) findViewById(R.id.bn_Mood_Angry);
        bnMoodContent = (ImageButton) findViewById(R.id.bn_Mood_Content);
        bnMoodSleepy = (ImageButton) findViewById(R.id.bn_Mood_Sleepy);

        bnSearch = (Button) findViewById(R.id.bn_Search);

        spPreferredGenre = (Spinner) findViewById(R.id.sp_Genera_Preference_Selector);
        loadSpinnerData();

        Movies.init(this);
        controller = new MainActivityController(this);

        weather = new WeatherRetreiver(this);
        weather.run();
    }

    private void loadSpinnerData(){
        // Spinner Drop down elements
        List<String> GenreList = new ArrayList<String>();

        //Populate the Genre list
        GenreList.add(getString(R.string.genre_none));
        GenreList.add(getString(R.string.genre_action));
        GenreList.add(getString(R.string.genre_adventure));
        GenreList.add(getString(R.string.genre_comedy));
        GenreList.add(getString(R.string.genre_drama));
        GenreList.add(getString(R.string.genre_horror));
        GenreList.add(getString(R.string.genre_romance));
        GenreList.add(getString(R.string.genre_science_fiction));

        // Creating adapter for spinner
        ArrayAdapter<String> genreAdapter = new ArrayAdapter<String>(this ,
                android.R.layout.simple_spinner_item, GenreList);

        // attaching genera adapter to spinner
        spPreferredGenre.setAdapter(genreAdapter);
    }

    public Spinner getPreferedGenre(){
        return spPreferredGenre;
    }
}
