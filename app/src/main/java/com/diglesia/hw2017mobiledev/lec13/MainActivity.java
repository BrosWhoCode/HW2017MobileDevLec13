package com.diglesia.hw2017mobiledev.lec13;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View rootView = findViewById(R.id.root_layout);
        final View squareView = findViewById(R.id.square_view);

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*ObjectAnimator squareViewYAnimator = ObjectAnimator.ofFloat(squareView, "y", squareView.getY(), squareView.getY()+500);
                squareViewYAnimator.setDuration(3000);
                squareViewYAnimator.start();*/

                int endX = rootView.getWidth()-squareView.getWidth();
                ObjectAnimator squareViewXAnimator = ObjectAnimator.ofFloat(squareView, "x", squareView.getX(), endX);
                squareViewXAnimator.setDuration(3000);
                squareViewXAnimator.setInterpolator(new OvershootInterpolator());
                squareViewXAnimator.start();

                ObjectAnimator squareViewColorAnimator = ObjectAnimator.ofArgb(squareView, "backgroundColor", 0xFF0000FF, 0xFFFF0000);
                squareViewColorAnimator.setDuration(3000);
                squareViewColorAnimator.start();

                ObjectAnimator buttonAlphaAnimator = ObjectAnimator.ofFloat(button, "alpha", 1, 0);
                buttonAlphaAnimator.setDuration(3000);
                buttonAlphaAnimator.start();

                ObjectAnimator buttonYAnimator = ObjectAnimator.ofFloat(button, "y", button.getY(), rootView.getHeight());
                buttonYAnimator.setDuration(3000);
                buttonYAnimator.start();

                ObjectAnimator buttonRotationAnimator = ObjectAnimator.ofFloat(button, "rotation", 0, 90);
                buttonRotationAnimator.setDuration(3000);
                buttonRotationAnimator.start();


            }
        });
    }
}
