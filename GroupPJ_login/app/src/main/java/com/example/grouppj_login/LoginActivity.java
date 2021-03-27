package com.example.grouppj_login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout userid, password;
    Button btnSign, btnRegster;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userid = (TextInputLayout) findViewById(R.id.txtId1);
        password = (TextInputLayout) findViewById(R.id.txtPw1);


        btnSign = (Button) findViewById(R.id.btnSignIn1);
        btnRegster = (Button) findViewById(R.id.btnReg);

        DB = new DBHelper(this);

        btnRegster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userid.toString();
                String pass = password.toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Enter your account!", Toast.LENGTH_SHORT).show();

                }else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass == true){
                        Toast.makeText(LoginActivity.this, "Welcome to Dr.Fit!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "No such an user", Toast.LENGTH_SHORT).show();

                    }
                }
               // startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

    }

}
