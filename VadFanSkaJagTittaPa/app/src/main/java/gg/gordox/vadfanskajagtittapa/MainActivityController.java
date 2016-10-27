package gg.gordox.vadfanskajagtittapa;

import android.view.View;

/**
 * Created by Spellabbet on 2016-10-27.
 */

public class MainActivityController {

    private MainActivity activity;

    String Gender = "", Mood = "", Genre = "";

    public MainActivityController(MainActivity activity){
        this.activity = activity;
    }

    public void GenderClick(View view){
        if(view.getId() == R.id.bn_Gender_Male){
            Gender = "Male";
        }else if(view.getId() == R.id.bn_Gender_Female){
            Gender = "Female";
        }else if(view.getId() == R.id.bn_Gender_TosaPog){
            Gender = "TosaPog";
        }
        else{
            Gender = "";
        }
    }

    public void MoodClick(View view){
        if(view.getId() == R.id.bn_Mood_Happy){
            Mood = "Happy";
        }else if(view.getId() == R.id.bn_Mood_Sad){
            Mood = "Sad";
        }else if(view.getId() == R.id.bn_Mood_Angry){
            Mood = "Angry";
        }else if(view.getId() == R.id.bn_Mood_Content){
            Mood = "Content";
        }else if(view.getId() == R.id.bn_Mood_Sleepy){
            Mood = "Sleepy";
        }else{
            Mood = "";
        }
    }

    public void SearchClick(View view){
        Genre = activity.getPreferedGenre().getSelectedItem().toString();

        //More shit here


    }

}
