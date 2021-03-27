package com.example.grouppj_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FifthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void clickBtn5(View view){
        //Intent intent = new Intent(this, LoginActivity.class);
        startActivity(new Intent(FifthActivity.this, MainActivity.class));
    }
}
