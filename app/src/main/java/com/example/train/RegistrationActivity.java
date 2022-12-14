package com.example.train;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;


public class RegistrationActivity extends AppCompatActivity {

    Button btnReg;
    Button btnToLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Objects.requireNonNull(getSupportActionBar()).hide();

        btnReg = findViewById(R.id.btnReg);
        btnToLog = findViewById(R.id.btnRegToLog);

        btnToLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);

                //AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                //builder.setMessage("ERRORRRRRRRRRRRRRRRRRRRRRRRR")
                //        .setTitle("Error");
                //AlertDialog dialog = builder.create();
                //dialog.show();
            }
        });
    }
}