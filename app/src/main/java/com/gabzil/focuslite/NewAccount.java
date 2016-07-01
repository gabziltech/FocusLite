package com.gabzil.focuslite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewAccount extends Activity {
    Button signup;
    TextView login;
    EditText username,password,re_password;
    private DataHelp dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_account);

        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        re_password=(EditText) findViewById(R.id.re_password);
        dh = new DataHelp(this);

        signup = (Button) findViewById(R.id.signup_btn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(password.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                if(username.getText().toString().length()==0 && password.getText().toString().length()==0 && re_password.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Please insert all the fields", Toast.LENGTH_SHORT).show();
                }
                else if(username.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Please insert the username", Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString().length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Please insert the password", Toast.LENGTH_SHORT).show();
                }
                else if(!(password.getText().toString()).equals((re_password.getText().toString())))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dh.LoginSbmt(username.getText().toString(), password.getText().toString());
                    username.setText("");
                    password.setText("");
                    re_password.setText("");

                    Toast.makeText(getApplicationContext(), "Registration Sucessful...", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(NewAccount.this,SignIn.class);
                    startActivity(i);
                }
            }
        });

        login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NewAccount.this,SignIn.class);
                startActivity(i);
            }
        });
    }
}