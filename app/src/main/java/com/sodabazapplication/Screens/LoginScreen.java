package com.sodabazapplication.Screens;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.sodabazapplication.Login_ModelClass;
import com.sodabazapplication.Login_Payload;
import com.sodabazapplication.Modelclasses.FetchUsername_Model_Class;
import com.sodabazapplication.Modelclasses.ForgetPassword_ModelClass;
import com.sodabazapplication.R;
import com.sodabazapplication.RetrofitClient;
import com.sodabazapplication.Services.Endpoints;
import com.sodabazapplication.UserDashboard.Dashboard;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends AppCompatActivity {
TextView login;
TextView message;
Button dismiss;
TextInputEditText email, password;
TextView forgotpassword;
TextInputEditText forgetemail;
Button submit;
Endpoints endpoints;
ProgressBar progressBar;
ProgressBar dialog_progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_login_screen);
            getSupportActionBar().hide();
                login = findViewById(R.id.login);
                email = findViewById(R.id.email);
                password = findViewById(R.id.password);
                Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.custom_dialog_box);
                dismiss = dialog.findViewById(R.id.dismiss);
            dialog_progressbar = dialog.findViewById(R.id.dialog_progressbar);
                forgetemail = dialog.findViewById(R.id.forgetemail);
                message = dialog.findViewById(R.id.message);
                submit = dialog.findViewById(R.id.submit);
                progressBar = findViewById(R.id.progressbar);
                endpoints = RetrofitClient.getEndpoints();
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String Forgetemail = forgetemail.getText().toString();
                            if (!Forgetemail.isEmpty()){
                                dialog_progressbar.setVisibility(View.VISIBLE);
                                ForgetPassword_ModelClass forget_payload = new ForgetPassword_ModelClass(Forgetemail);
                                Call<Login_ModelClass> call = endpoints.forgetPassword(forget_payload);
                                call.enqueue(new Callback<Login_ModelClass>() {
                                    @Override
                                    public void onResponse(Call<Login_ModelClass> call, Response<Login_ModelClass> response) {
                                        if (response.isSuccessful() && response.body()!=null){
                                            dialog_progressbar.setVisibility(View.GONE);
                                            Login_ModelClass login_modelClass = response.body();
                                            Snackbar snackbar = Snackbar.make(view,"Done"+login_modelClass.getMethod(),Snackbar.LENGTH_LONG);
                                            snackbar.show();
                                            Log.d(TAG, "onResponse: "+login_modelClass.getStatus());
                                            Log.d(TAG, "onResponse: "+login_modelClass.getMethod());
                                            dialog.dismiss();
                                        }
                                        else {
                                            dialog_progressbar.setVisibility(View.GONE);
                                            Snackbar snackbar = Snackbar.make(view,"Invalid Email",Snackbar.LENGTH_LONG);
                                            snackbar.show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Login_ModelClass> call, Throwable t) {
                                        dialog_progressbar.setVisibility(View.GONE);
                                        Snackbar snackbar = Snackbar.make(view,"In Onfailure",Snackbar.LENGTH_LONG);
                                        snackbar.show();
                                    }
                                });
                            }
                            else {
                                Snackbar snackbar = Snackbar.make(view,"Please enter email",Snackbar.LENGTH_LONG);
                                snackbar.show();
                            }
                        }
                        catch (Exception e){
                            dialog_progressbar.setVisibility(View.GONE);
                            Snackbar snackbar = Snackbar.make(view,"In Exception"+e.getMessage(),Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }

                    }
                });
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                forgotpassword = findViewById(R.id.forgotpassword);
                forgotpassword.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.show();
                        dialog.setCancelable(false);
                    }
                });
        }
        catch (Exception e){
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "An Error Occurred! CAUSED BY: "+ e.getMessage(), Snackbar.LENGTH_LONG);
            snackbar.show();
        }

    }

    public void submitdata(View view) {
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        if(Email.isEmpty()){
            Snackbar snackbar = Snackbar.make(view,"Please enter your email",Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else if (!isValidEmail(Email)){
            Snackbar snackbar = Snackbar.make(view,"Please correct your email",Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else if (Password.length()<6){
            Snackbar snackbar = Snackbar.make(view,"Please enter 6 digit password",Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else{
            try {
                 final MaterialButton submitButton = findViewById(R.id.submit_button);
                 submitButton.setVisibility(View.GONE);
                 progressBar.setVisibility(View.VISIBLE);
                Login_Payload login_payload = new Login_Payload(Email,Password);
                Call<Login_ModelClass> call = endpoints.getLoginData(login_payload);
                call.enqueue(new Callback<Login_ModelClass>() {
                    @Override
                    public void onResponse(Call<Login_ModelClass> call, Response<Login_ModelClass> response) {
                        if (response.isSuccessful() && response!=null){
                            SharedPreferences sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("isUserLoggedIn", "true");
                            editor.putString("email", Email);
                            editor.apply();
                            editor.putString("password",Password);
                            editor.apply();
                            progressBar.setVisibility(View.GONE);
                            submitButton.setVisibility(View.VISIBLE);
                            Login_ModelClass login_modelClass = response.body();
                            Log.d(TAG, " this is onResponse: " + login_modelClass.getMethod());
                            Log.d(TAG, " this is onResponse: " + login_modelClass.getStatus());
                            FetchUsername_Model_Class fetchUsername_model_class = new FetchUsername_Model_Class(Email);
                            Call<Login_ModelClass> call1 = endpoints.fetchUsername(fetchUsername_model_class);
                            call1.enqueue(new Callback<Login_ModelClass>() {
                                @Override
                                public void onResponse(Call<Login_ModelClass> call, Response<Login_ModelClass> response) {
                                          if (response.isSuccessful() && response.body() !=null){
                                              Login_ModelClass login_modelClass1 = response.body();
                                              Log.d(TAG, "The username is "+login_modelClass1.getMethod());
                                              editor.putString("username",login_modelClass1.getMethod());
                                              editor.apply();
                                          }
                                }

                                @Override
                                public void onFailure(Call<Login_ModelClass> call, Throwable t) {

                                }
                            });
                            email.setText("");
                            password.setText("");
                            startActivity(new Intent(getApplicationContext(),Dashboard.class));
                            finish();
                        }
                        else {
                            Snackbar snackbar = Snackbar.make(view,"Invalid Credentials",Snackbar.LENGTH_LONG);
                            snackbar.show();
                            progressBar.setVisibility(View.GONE);
                            submitButton.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(Call<Login_ModelClass> call, Throwable t) {
                        Snackbar snackbar = Snackbar.make(view,"i am in onfailure",Snackbar.LENGTH_LONG);
                        snackbar.show();
                        progressBar.setVisibility(View.GONE);
                        submitButton.setVisibility(View.VISIBLE);
                    }
                });
            }
            catch (Exception e){
                Snackbar snackbar = Snackbar.make(view,"i am in exception"+e.getMessage(),Snackbar.LENGTH_LONG);
                snackbar.show();
                progressBar.setVisibility(View.GONE);
            }

        }
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

    public void register(View view) {
        startActivity(new Intent(getApplicationContext(),Registration.class));
    }
}