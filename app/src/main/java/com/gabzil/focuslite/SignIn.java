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

public class SignIn extends Activity {
    Button signin;
    TextView signup;
    EditText userName,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        userName=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        final MyOpenHelper login=new MyOpenHelper(this);

        signin = (Button) findViewById(R.id.login_btn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Password = login.getLogin(userName.getText().toString(), password.getText().toString());
                InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(password.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                if (userName.getText().toString().length() == 0 && password.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Insert The Username & Password", Toast.LENGTH_SHORT).show();
                } else if (userName.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Insert The Username", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Insert The Password", Toast.LENGTH_SHORT).show();
                } else if ((password.getText().toString()).equals(Password)) {
                    Toast.makeText(getApplicationContext(), "You Are Successfully Login...", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignIn.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Please Insert Correct Username & Password", Toast.LENGTH_SHORT).show();
                    userName.setText("");
                    password.setText("");
                }
            }
        });

        signup = (TextView) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignIn.this, NewAccount.class);
                startActivity(i);
            }
        });
    }
}
