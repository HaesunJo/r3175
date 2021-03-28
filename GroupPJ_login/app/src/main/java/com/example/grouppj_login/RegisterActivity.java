package com.example.grouppj_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHelper = new DatabaseHelper(this);

        EditText emailReg = findViewById(R.id.emailText);
        EditText pwReg = findViewById(R.id.pswordText);
        EditText nameReg = findViewById(R.id.nameText);
        EditText postReg = findViewById(R.id.postalText);

        Button btnRegister = findViewById(R.id.Registerbutton);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = databaseHelper.addRecord(nameReg.getText().toString(),
                                                                pwReg.getText().toString(),
                                                                emailReg.getText().toString(),
                                                                postReg.getText().toString());
                if (isInserted){
                    Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration has not been approved", Toast.LENGTH_LONG).show();
                }
            }


        });


    }

}