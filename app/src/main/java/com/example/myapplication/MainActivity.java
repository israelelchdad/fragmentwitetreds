package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMovieFragmentClickListener, Toolbar.OnMenuItemClickListener {
    //private FrameLayout tabletfremcontainer = null;
    private ViewPager pager = null;
    private Toolbar mytoolbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mytoolbr = findViewById(R.id.mo_tol);
        setSupportActionBar(mytoolbr);
        mytoolbr.setOnMenuItemClickListener(this);


//        tabletfremcontainer = findViewById(R.id.act_m_fremtwo_tablet);
        pager = findViewById(R.id.act_m_viewpager_tablet);
        if (pager != null) {
            Adapterpajer adapterpajer = new Adapterpajer(getSupportFragmentManager(), arrfragment());
            pager.setAdapter(adapterpajer);
        }


        if (savedInstanceState == null) {
            MoviesFragment moviesFragment = new MoviesFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.act_m_frem, moviesFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tolbar, menu);
        return true;
    }

    private List<Fragment> arrfragment() {
        List<Fragment> mylistarryfrag = new ArrayList<Fragment>();
        for (int i = 0; i < MainActivity.araydata().size(); i++) {
            mylistarryfrag.add(fragmentto.newinstans(MainActivity.araydata().get(i)));

        }
        return mylistarryfrag;
    }

    public static ArrayList<Data> araydata() {
        ArrayList<Data> arrdata = new ArrayList<>();
        arrdata.add(new Data("cars", "1", R.drawable.cars, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        arrdata.add(new Data("code_8", "2", R.drawable.code_8, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        arrdata.add(new Data("frozen_2", "3", R.drawable.frozen_2, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        arrdata.add(new Data("interstellar", "4", R.drawable.interstellar, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        arrdata.add(new Data("jurassic_world", "5", R.drawable.jurassic_world, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        arrdata.add(new Data("rabbi_jacob", "6", R.drawable.rabbi_jacob, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        arrdata.add(new Data("rick_and_morty", "7", R.drawable.rick_and_morty, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        arrdata.add(new Data("spider_man", "8", R.drawable.spider_man, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        arrdata.add(new Data("the_simpsons", "9", R.drawable.the_simpsons, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        arrdata.add(new Data("toy_story_4", "10", R.drawable.toy_story_4, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        arrdata.add(new Data("young_sheldon", "10", R.drawable.young_sheldon, "https://www.youtube.com/watch?v=SImhJKgZZDY&pbjreload=10"));
        return arrdata;


    }

    @Override
    public void onMovieClicked(Data dat) {
        fragmentto fto = fragmentto.newinstans(dat);

        //        if (  tabletfremcontainer == null){
        if (pager == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.act_m_frem, fto).commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null);
//                    .replace(R.id.act_m_viewpager_tablet,fto).commit();
            pager.setCurrentItem(MoviesFragment.indexitem);
        }

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if (item.getItemId() == R.id.async) {
            Log.e(":clic", "clic");
            Intent goToNextActivity = new Intent(getApplicationContext(), ActivAsinc.class);
            startActivity(goToNextActivity);
        } else if (item.getItemId() == R.id.thred) {
            Log.e(":clic", "clic");
            Intent goToNextActivity = new Intent(getApplicationContext(), TherdAvctivity.class);
            startActivity(goToNextActivity);
        }

        return false;
    }
}
