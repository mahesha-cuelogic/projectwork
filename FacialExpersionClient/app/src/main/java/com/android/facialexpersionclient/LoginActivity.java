package com.android.facialexpersionclient;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private String TAG="In Smart Pill Box Login Activity";
    EditText usernameText;
    EditText passwordText;
    TextView wolf;
    TextView signin;

    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Typeface custom_font = Typeface.createFromAsset(getAssets(),"font/Lato-Light.ttf");

        usernameText=(EditText) findViewById(R.id.username);
        passwordText=(EditText) findViewById(R.id.pass);
        wolf = (TextView) findViewById(R.id.wolf);
        signin = (TextView) findViewById(R.id.signin);

        usernameText.setTypeface(custom_font);
        passwordText.setTypeface(custom_font);
        wolf.setTypeface(custom_font);
        signin.setTypeface(custom_font);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username=usernameText.getText().toString();
                password=passwordText.getText().toString();

                if(TextUtils.isEmpty(username))
                {
                    usernameText.setError("Enter Username");
                }
                else if(TextUtils.isEmpty(password))
                {
                    passwordText.setError("Enter Password");
                }
                else if(username.equals("user") && password.equals("user123"))
                {
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Invalid username and password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
