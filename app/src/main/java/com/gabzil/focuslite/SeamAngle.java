package com.gabzil.focuslite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SeamAngle extends Fragment {
    public SeamAngle() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_seam_angle, container, false);

//        ImageView img_animation = (ImageView) v.findViewById(R.id.img_animation);
//
//        img_animation.clearAnimation();
//        RotateAnimation anim = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
//        anim.setFillAfter(true);
//        anim.setRepeatCount(0);
//        anim.setDuration(10000);
//        img_animation.startAnimation(anim);
        return v;
    }

}