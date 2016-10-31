package gg.gordox.vadfanskajagtittapa;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends AppCompatActivity{

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).showImageOnFail(R.drawable.noimage).showImageForEmptyUri(R.drawable.noimage).build();

        ImageLoaderConfiguration c = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();

        ImageLoader.getInstance().init(c);

        WeatherRetreiver.getInstance(this);

        fm = getFragmentManager();


        fm.beginTransaction().replace(R.id.activity_main,
                new MainFragment()).commit();
    }
}
