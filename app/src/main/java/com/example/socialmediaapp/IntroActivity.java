package com.example.socialmediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroActivity extends AppCompatActivity {

    ImageView logo, splashImg;
    TextView appName;
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.CollarTitle);
        splashImg = findViewById(R.id.image);
        lottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-getDisplay().getHeight() * 1.1f).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(getDisplay().getHeight()).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(getDisplay().getHeight()).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(getDisplay().getHeight()).setDuration(1000).setStartDelay(4000);

    }
}