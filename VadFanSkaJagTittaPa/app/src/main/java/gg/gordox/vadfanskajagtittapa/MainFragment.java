package gg.gordox.vadfanskajagtittapa;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener{
    private ImageButton bnGenderMale, bnGenderFemale, bnGenderTosaPog;
    private ImageButton bnMoodHappy, bnMoodSad, bnMoodAngry, bnMoodContent, bnMoodSleepy;
    private Button bnSearch;
    private Spinner spPreferredGenre;
    private MainFragmentController controller;
    private View myView;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_main, container, false);

        Init();
        setListener();

        getActivity().setTitle("What are we going to watch?");

        return myView;
    }

    public void OnGenderClick(View v){
        controller.GenderClick(v);
    }

    public void OnMoodClick(View v){
        controller.MoodClick(v);
    }

    public void OnSearchClick(View v){
        controller.SearchClick(v);
    }

    private void Init(){
        bnGenderMale = (ImageButton) myView.findViewById(R.id.bn_Gender_Male);
        bnGenderFemale = (ImageButton) myView.findViewById(R.id.bn_Gender_Female);
        bnGenderTosaPog = (ImageButton) myView.findViewById(R.id.bn_Gender_TosaPog);

        bnMoodHappy = (ImageButton) myView.findViewById(R.id.bn_Mood_Happy);
        bnMoodSad = (ImageButton) myView.findViewById(R.id.bn_Mood_Sad);
        bnMoodAngry = (ImageButton) myView.findViewById(R.id.bn_Mood_Angry);
        bnMoodContent = (ImageButton) myView.findViewById(R.id.bn_Mood_Content);
        bnMoodSleepy = (ImageButton) myView.findViewById(R.id.bn_Mood_Sleepy);

        bnSearch = (Button) myView.findViewById(R.id.bn_Search);

        spPreferredGenre = (Spinner) myView.findViewById(R.id.sp_Genera_Preference_Selector);
        loadSpinnerData();

        Movies.init(this.getActivity());
        controller = new MainFragmentController(this);
    }

    void setListener(){
        bnGenderMale.setOnClickListener(this);
        bnGenderFemale.setOnClickListener(this);
        bnGenderTosaPog.setOnClickListener(this);

        bnMoodHappy.setOnClickListener(this);
        bnMoodSad.setOnClickListener(this);
        bnMoodAngry.setOnClickListener(this);
        bnMoodContent.setOnClickListener(this);
        bnMoodSleepy.setOnClickListener(this);

        bnSearch.setOnClickListener(this);
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
        ArrayAdapter<String> genreAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, GenreList);

        // attaching genera adapter to spinner
        spPreferredGenre.setAdapter(genreAdapter);
    }

    public Spinner getPreferedGenre(){
        return spPreferredGenre;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bn_Gender_Male ||
                v.getId() == R.id.bn_Gender_Female ||
                v.getId() == R.id.bn_Gender_TosaPog){
            OnGenderClick(v);
        }else if(v.getId() == R.id.bn_Mood_Happy   ||
                 v.getId() == R.id.bn_Mood_Sad     ||
                 v.getId() == R.id.bn_Mood_Angry   ||
                 v.getId() == R.id.bn_Mood_Content ||
                 v.getId() == R.id.bn_Mood_Sleepy){
            OnMoodClick(v);
        }else if(v.getId() == R.id.bn_Search){
            OnSearchClick(v);
        }
    }
}
