package gg.gordox.vadfanskajagtittapa;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends AppCompatActivity{

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageLoaderConfiguration c = new ImageLoaderConfiguration.Builder(this).build();

        ImageLoader.getInstance().init(c);

        fm = getFragmentManager();


        fm.beginTransaction().replace(R.id.activity_main,
                new MainFragment()).commit();
    }
}
