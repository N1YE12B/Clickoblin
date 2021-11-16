package com.example.clicker;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class LoadWindowActivity extends AppCompatActivity {

    ImageView goblinguit1, goblinguit2 , logoImVie, gobhead;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(null);
        setContentView(R.layout.loadwindow_layout);



        gobhead = findViewById(R.id.gobheadload);
        Animation gobhed = AnimationUtils.loadAnimation(this, R.anim.gob_load_anim);
        gobhead.startAnimation(gobhed);

        goblinguit1 = findViewById(R.id.goblinGuitar1);
        goblinguit2 = findViewById(R.id.goblinguitar2);


            Thread thr1 = new Thread()
            {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        goblinguit1.setRotationY(-180);
                        goblinguit2.setRotationY(180);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }; thr1.start();

        Thread thr2 = new Thread()
        {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    goblinguit1.setRotationY(0);
                    goblinguit2.setRotationY(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }; thr2.start();

        Thread thr3 = new Thread()
        {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    goblinguit1.setRotationY(-180);
                    goblinguit2.setRotationY(180);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }; thr3.start();

        Thread thr4 = new Thread()
        {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(4);
                    goblinguit1.setRotationY(0);
                    goblinguit2.setRotationY(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }; thr4.start();

        Thread thr5 = new Thread()
        {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    goblinguit1.setRotationY(-180);
                    goblinguit2.setRotationY(180);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }; thr5.start();








        Thread thrNext = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    Intent i = new Intent(LoadWindowActivity.this, MainActivity.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }; thrNext.start();

    }
}
