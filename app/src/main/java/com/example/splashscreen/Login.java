package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import es.dmoral.toasty.Toasty;

public class Login extends AppCompatActivity {

    Button loginButton, forgotPass;
    TextInputEditText userName, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // for hiding status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // for hiding status bar
        setContentView(R.layout.activity_login);
        Toasty.info(Login.this, "Please log in to continue", Toasty.LENGTH_SHORT, true).show();

        loginButton = (Button)findViewById(R.id.login);
        forgotPass = (Button)findViewById(R.id.forgot_pass);
        userName = (TextInputEditText)findViewById(R.id.username);
        password = (TextInputEditText)findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                    Toasty.info(Login.this, "Please enter your username and password", Toasty.LENGTH_SHORT, true).show();
                else {
                    openDashboard();
                    Toasty.success(Login.this, "Login Successful!", Toasty.LENGTH_SHORT, true).show();
                }
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.warning(Login.this, "Resetting your password", Toasty.LENGTH_SHORT, true).show();
            }
        });



    }

    public void openDashboard() {
        Intent intent = new Intent(this, UserDashboard.class);
        startActivity(intent);
    }



}