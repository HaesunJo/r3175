package com.example.grouppj_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText userid, password, postalcode, username;
    Button signIn, register;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userid =  findViewById(R.id.txtId);
        password =  findViewById(R.id.txtPw);
        username =  findViewById(R.id.nameText);
        postalcode = findViewById(R.id.postalText);

        signIn = (Button) findViewById(R.id.btnSignIn);
        register = (Button) findViewById(R.id.btnReg);

        DB = new DBHelper(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = userid.getText().toString();
                String pass = password.getText().toString();
                String pcode = postalcode.getText().toString();
                String name = username.getText().toString();

                if(user.equals("")||pass.equals("")||pcode.equals("")||name.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {

                        Boolean checkuser = DB.checkusername(user);

                        System.out.println("line62" + checkuser);

                        if (checkuser == false){
                            Boolean insert = DB.insertData(user, pass, pcode, name);
                            if(insert == true){
                                Toast.makeText(MainActivity.this, "Registered!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);

                                System.out.println("ok");
                            } else {
                                Toast.makeText(MainActivity.this, "Register failed!", Toast.LENGTH_SHORT).show();
                                System.out.println("eh");

                            }
                        } else {
                            Toast.makeText(MainActivity.this, "User already exist!", Toast.LENGTH_SHORT).show();
                            System.out.println("no");

                        }
                }
            }
        });

    }
}