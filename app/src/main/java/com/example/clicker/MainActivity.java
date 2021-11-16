package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer, mediaPlayer_short;
    AudioManager audioManager;

    private final static String FILE_NAME_SKIN = "skin.txt";
    private final static String FILE_NAME_COUNT = "count.txt";

    String countQty = "";
    int countClick;

    String skin = "";
    int skinID;

    ImageView goblinStand, goblinClick,  magazClose, ground,lil_island1,lil_island2,cloud1,cloud2,cloud3;
    Button btnClick, btnMag, btnMagBack;


    TextView txtCount;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Анимация островов и облаков
        lil_island1 = findViewById(R.id.lil_island1);
        Animation flying = AnimationUtils.loadAnimation(this, R.anim.lil_island_anim);
        Animation flying_downtoup = AnimationUtils.loadAnimation(this, R.anim.lil_island_anim2_downtoup);
        lil_island1.startAnimation(flying);
        lil_island2 = findViewById(R.id.lil_island2);
        lil_island2.startAnimation(flying_downtoup);

        cloud1 = findViewById(R.id.cloud1);
        Animation flying_cloud = AnimationUtils.loadAnimation(this,R.anim.cloud_anim1);
        cloud1.startAnimation(flying_cloud);

        cloud2 = findViewById(R.id.cloud2);
        Animation flying_cloud3 = AnimationUtils.loadAnimation(this,R.anim.cloud_anim3);
        cloud2.startAnimation(flying_cloud3);

        cloud3 = findViewById(R.id.cloud3);
        Animation flying_cloud2 = AnimationUtils.loadAnimation(this,R.anim.cloud_anim2);
        cloud3.startAnimation(flying_cloud2);

     //Чтение из файла кликов

        FileInputStream fin = null;

        try {
            fin = openFileInput(FILE_NAME_COUNT);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
             countQty = new String (bytes);

        }
        catch(IOException ex) {
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){
            }
        }


        //Чтение из файла скина

        try {
            fin = openFileInput(FILE_NAME_SKIN);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            skin = new String (bytes);
            skinID = Integer.parseInt(skin);

        }
        catch(IOException ex) {
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){
            }
        }

    //Замена текстуры гоблина

        switch (skinID)
        {
            case 0:
                goblinStand = findViewById(R.id.goblin_stand);
                goblinStand.setVisibility(View.VISIBLE);
                goblinClick = findViewById(R.id.goblin_click);
                break;
            case 1:
                goblinStand = findViewById(R.id.goblin_hair1);
                goblinStand.setVisibility(View.VISIBLE);
                goblinClick = findViewById(R.id.goblin_click_hair1);
                break;
            case 2:
                goblinStand = findViewById(R.id.goblin_hair2);
                goblinStand.setVisibility(View.VISIBLE);
                goblinClick = findViewById(R.id.goblin_click_hair2);
                break;
            case 3:
                goblinStand = findViewById(R.id.goblin_hair3);
                goblinStand.setVisibility(View.VISIBLE);
                goblinClick = findViewById(R.id.goblin_click_hair3);
                break;
            case 4:
                goblinStand = findViewById(R.id.goblin_hair4);
                goblinStand.setVisibility(View.VISIBLE);
                goblinClick = findViewById(R.id.goblin_click_hair4);
                break;
            case 5:
                goblinStand = findViewById(R.id.goblin_hair5);
                goblinStand.setVisibility(View.VISIBLE);
                goblinClick = findViewById(R.id.goblin_click_hair5);
                break;

        }












        magazClose = findViewById(R.id.magaz_close);

        ground = findViewById(R.id.ground);

        txtCount = findViewById(R.id.txtCount);
        txtCount.setText(countQty);

        btnClick = findViewById(R.id.btnClick);
        btnClick.setAlpha(0);

        btnMag = findViewById(R.id.btnMag);
        btnMag.setAlpha(0);






        btnClick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    goblinStand.setVisibility(View.INVISIBLE);
                    goblinClick.setVisibility(View.VISIBLE);
                }
                if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    goblinStand.setVisibility(View.VISIBLE);
                    goblinClick.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });

    }



    public void btnClick(View view) {

        //audio
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.click_sound);
        mediaPlayer_short = MediaPlayer.create(MainActivity.this, R.raw.click_sound_short);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        mediaPlayer_short.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer_short) {
                stopPlay();
            }

            private void stopPlay() {
                try {
                    mediaPlayer_short.prepare();
                    mediaPlayer_short.seekTo(0);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopPlay();
            }

            private void stopPlay() {
                try {
                    mediaPlayer.prepare();
                    mediaPlayer.seekTo(0);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mediaPlayer_short.start();

        btnClick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    goblinStand.setVisibility(View.INVISIBLE);
                    goblinClick.setVisibility(View.VISIBLE);


                    mediaPlayer.start();






                }
                if(event.getAction() == MotionEvent.ACTION_UP)
                {

                    goblinStand.setVisibility(View.VISIBLE);
                    goblinClick.setVisibility(View.INVISIBLE);
                    mediaPlayer.stop();
                    mediaPlayer_short.stop();
                    stopPlay();
                }
                return false;
            }
        });



        //Достаем кол-во кликов
        FileInputStream fin = null;

        try {
            fin = openFileInput(FILE_NAME_COUNT);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            countQty = new String (bytes);

        }
        catch(IOException ex) {
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){
            }
        }


        countClick = Integer.parseInt(countQty);

        countClick++;

        txtCount.setText(""+countClick);




//Запись в файл
        FileOutputStream fos = null;
        try {

String countQty = (String) txtCount.getText();

            fos = openFileOutput(FILE_NAME_COUNT, MODE_PRIVATE);
            fos.write(countQty.getBytes());

        }
        catch(IOException ex) {
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){
            }
        }


    }


    private void stopPlay() {
        try {
            mediaPlayer.prepare();
            mediaPlayer.seekTo(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void btnMag(View view) {

        Intent i = new Intent(MainActivity.this, MagazActivity.class);
        startActivity(i);
    //    i.overridePendingTransitions(0, 0);




    }

    public void btnMagBack(View view) {
        setContentView(R.layout.activity_main);
        btnClick.setEnabled(true);
        btnMag = findViewById(R.id.btnMag);
        btnMag.setAlpha(0);
        btnClick = findViewById(R.id.btnClick);
        btnClick.setAlpha(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer.isPlaying()){stopPlay();}
        if(mediaPlayer_short.isPlaying()){stopPlay();}
    }
}