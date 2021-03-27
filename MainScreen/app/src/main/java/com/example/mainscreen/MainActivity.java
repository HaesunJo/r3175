package com.example.mainscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mainscreen.fragments.FirstFragment;
import com.example.mainscreen.fragments.FourthFragment;
import com.example.mainscreen.fragments.SecondFragment;
import com.example.mainscreen.fragments.ThirdFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //DatabaseHelper databaseHelper;

    BottomNavigationView bottomNavigationView;

    //for the bottom navigation
    FirstFragment fragment1;
    SecondFragment fragment2;
    ThirdFragment fragment3;
    FourthFragment fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //databaseHelper = new DatabaseHelper(this);



        bottomNavigationView = findViewById(R.id.bottom_navigation);

        fragment1 = new FirstFragment();
        fragment2 = new SecondFragment();
        fragment3 = new ThirdFragment();
        fragment4 = new FourthFragment();

        //getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.page_1:{
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment1).commitAllowingStateLoss();
                    }
                    case R.id.page_2:{
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment2).commitAllowingStateLoss();
                    }
                    case R.id.page_3:{
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment3).commitAllowingStateLoss();
                    }
                    case R.id.page_4:{
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment4).commitAllowingStateLoss();
                    }

                    default:
                        return false;
                }
            }
        });
    }

    public void btnFood(View view){

    }

    public void btnDoc(View view){

    }
}