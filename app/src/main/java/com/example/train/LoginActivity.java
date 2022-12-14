package com.example.train;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.train.http.UserAPI;
import com.example.train.http.UserLogin;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    Context context;
    Button btnLogin;
    Button btnToReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Objects.requireNonNull(getSupportActionBar()).hide();

        btnLogin = findViewById(R.id.log_btn);
        btnToReg = findViewById(R.id.btnLoginToReg);

        btnToReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                //AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                //builder.setMessage("ERRORRRRRRRRRRRRRRRRRRRRRRRR")
                //        .setTitle("Error");
                //AlertDialog dialog = builder.create();
                //dialog.show();
            }
        });
    }
    
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            
            UserAPI retrofitAPI = retrofit.create(UserAPI.class);

            UserLogin userLogin = new UserLogin();
            userLogin.email = "text@mail.com";
            userLogin.password = "password";
            
            Call<String> call = retrofitAPI.loginUser(userLogin);

            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        response.body();

                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.i("my data", "Failed to get data");
                }
            });
        }
    });
}