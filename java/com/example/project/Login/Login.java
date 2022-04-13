package com.example.project.Login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.Home.DBHandler;
import com.example.project.Home.Home;
import com.example.project.Home.Registration;
import com.example.project.R;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions;
import com.google.android.gms.fido.fido2.api.common.RequestOptions;
import com.google.android.gms.fido.fido2.api.common.TokenBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class Login extends AppCompatActivity {

    EditText edt_name , edt_pwd ;
    Button btn_reg,btn_login ;
    private DBHandler dbHandler;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private static final String EMAIL = "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_reg = findViewById(R.id.btn_reg);
        edt_name = findViewById(R.id.U_name);
        edt_pwd = findViewById(R.id.Pwd);
        btn_login = findViewById(R.id.btn_login);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });
        dbHandler = new DBHandler(Login.this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edt_name.getText().toString();
                String password = edt_pwd.getText().toString();

                Boolean result = dbHandler.checkUser(username, password);
                if (result == true) {
                    Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Failed Login ,Please Try ", Toast.LENGTH_SHORT).show();
                    edt_name.setText("");
                    edt_pwd.setText("");
                }
            }
        });
    }
}