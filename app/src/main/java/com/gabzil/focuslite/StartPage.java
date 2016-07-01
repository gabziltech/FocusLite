package com.gabzil.focuslite;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StartPage extends Activity {
    LinearLayout signup,signin;
    TextView companyname;
    Typeface face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        companyname = (TextView) findViewById(R.id.companyname);
        face = Typeface.createFromAsset(getAssets(), "brush-script-mt.ttf");
        companyname.setTypeface(face);

        signup = (LinearLayout) findViewById(R.id.signup);
        signin = (LinearLayout) findViewById(R.id.signin);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartPage.this,NewAccount.class);
                startActivity(i);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartPage.this,SignIn.class);
                startActivity(i);
            }
        });
    }
}
