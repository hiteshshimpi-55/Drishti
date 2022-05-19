package com.example.drishti_videoplayer_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private DisplayFragment displayFragment;
    private FormFragment formFragment;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //initialize bottomNavigationBar
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        //initialize fragments
        homeFragment = new HomeFragment();
        displayFragment = new DisplayFragment();
        formFragment = new FormFragment();
        replaceFragment(homeFragment);
        //Navigate through fragments
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home_id:
                       replaceFragment(homeFragment);
                       return true;
                    case R.id.form_id:
                        replaceFragment(formFragment);
                        return true;
                    case R.id.display_id:
                        replaceFragment(displayFragment);
                        return true;
                    default:
                        return false;

                }
            }
        });
    }

    private void replaceFragment(Fragment newFragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,newFragment);
        fragmentTransaction.commit();
    }
}