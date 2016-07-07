package com.gabzil.focuslite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SeamAngle extends Fragment {
    Button start;
    ImageView image;
    String str;
    float angle;
    long speed;
    private Spinner swingAngle, swingSpeed;
    TextView t1;

    public SeamAngle() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_seam_angle, container, false);

        start=(Button)v.findViewById(R.id.startanimation);
        image=(ImageView)v.findViewById(R.id.animationView);
        swingAngle = (Spinner) v.findViewById(R.id.spinnerangle);
        swingSpeed = (Spinner) v.findViewById(R.id.spinnerspeed);
        t1=(TextView) v.findViewById(R.id.in);

        swingAngle.setSelection(9);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    angle = Float.parseFloat(String.valueOf(swingAngle.getSelectedItem()));
                    if(angle>0){
                        t1.setText("In-Swing");
                        t1.setVisibility(View.VISIBLE);
                    }
                    else{
                        t1.setText("Out-Swing");
                        t1.setVisibility(View.VISIBLE);
                    }
                    str = String.valueOf(swingSpeed.getSelectedItem());
                    if(str.equals("Slow")){
                        speed=5000;
                    }else if(str.equals("Medium")){
                        speed=2000;
                    }else if(str.equals("Fast")){
                        speed=500;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Step1 : create the  RotateAnimation object
                RotateAnimation anim = new RotateAnimation(0f, angle, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

                // Step 2:  Set the Animation properties
                anim.setFillAfter(true);
                anim.setInterpolator(new LinearInterpolator());

                //anim.setRepeatCount(Animation.RELATIVE_TO_SELF);
                anim.setRepeatCount(Animation.ABSOLUTE);
                anim.setDuration(speed);

                // Step 3: Start animating the image
                image.startAnimation(anim);

            }
        });

        return v;
    }

}