package com.sodabazapplication.Screens;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.sodabazapplication.Login_ModelClass;
import com.sodabazapplication.R;
import com.sodabazapplication.RetrofitClient;
import com.sodabazapplication.Services.Endpoints;
import com.sodabazapplication.Signup_Payload;
import com.sodabazapplication.UserDashboard.Dashboard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {
 TextInputEditText name, email, password, confirmpassword;
 MaterialButton register;
 Endpoints endpoints;
 ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpassword);
        register = findViewById(R.id.register);
        progressbar = findViewById(R.id.progressbar);
        endpoints = RetrofitClient.getEndpoints();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String ConfirmPassword = confirmpassword.getText().toString();
                if (Name.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view,"Please enter your name",Snackbar.LENGTH_LONG);
                    snackbar.show();
                    return;
                }
                else if (!isValidEmail(Email)){
                    Snackbar snackbar = Snackbar.make(view,"Please correct your email",Snackbar.LENGTH_LONG);
                    snackbar.show();
                    return;
                }
                else if (Password.length()<6){
                    Snackbar snackbar = Snackbar.make(view,"Please enter 6 digit password",Snackbar.LENGTH_LONG);
                    snackbar.show();
                    return;
                }
               else if (!Password.equals(ConfirmPassword)){
                    Snackbar snackbar = Snackbar.make(view,"Password is not match",Snackbar.LENGTH_LONG);
                    snackbar.show();
                    return;
                }
               else if (ConfirmPassword.equals(Password)){
                   register.setVisibility(View.GONE);
                   progressbar.setVisibility(View.VISIBLE);
                    Signup_Payload signup_payload = new Signup_Payload(Name,Email,Password);
                    Call<Login_ModelClass> call = endpoints.getSignupData(signup_payload);
                    call.enqueue(new Callback<Login_ModelClass>() {
                        @Override
                        public void onResponse(Call<Login_ModelClass> call, Response<Login_ModelClass> response) {
                            try {
                                if (response.isSuccessful() && response!=null){
                                    SharedPreferences sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("username",Name);
                                    editor.apply();
                                    progressbar.setVisibility(View.GONE);
                                    register.setVisibility(View.GONE);
                                    Log.d(TAG, "i am in onresponse ");
                                    Login_ModelClass login_modelClass = response.body();
                                    Log.d(TAG, " this is onResponse: " + login_modelClass.getMethod());
                                    Log.d(TAG, " this is onResponse: " + login_modelClass.getStatus());
                                    Snackbar snackbar = Snackbar.make(view,"Your Account has been registered",Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                    name.setText("");
                                    email.setText("");
                                    password.setText("");
                                    confirmpassword.setText("");
                                    startActivity(new Intent(Registration.this,LoginScreen.class));
                                }
                                else {
                                    Snackbar snackbar = Snackbar.make(view,"Your Account has not registered",Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                    progressbar.setVisibility(View.GONE);
                                    register.setVisibility(View.VISIBLE);
                                }
                            }
                            catch (Exception e){

                            }
                        }

                        @Override
                        public void onFailure(Call<Login_ModelClass> call, Throwable t) {

                        }
                    });
                }

            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Create a Pattern object with the regex pattern
        Pattern pattern = Pattern.compile(emailPattern);

        // Create a Matcher object and match it against the email string
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the pattern, false otherwise
        return matcher.matches();
    }
}