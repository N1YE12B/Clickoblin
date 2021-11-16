package com.example.clicker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MagazActivity extends AppCompatActivity {

    private final static String FILE_NAME_SKIN = "skin.txt";
    private final static String FILE_NAME_COUNT = "count.txt";

    ImageView head_hair1, head_hair2 ,head_hair3 ,head_hair4 ,head_hair5 ,head_hair_bold;

    String countQty = "";
    String string_skinID;

    TextView txtValue;


    int countClick;

    int skinID = 0;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magaz_layout);

        txtValue = findViewById(R.id.txtValue);

        head_hair1 = findViewById(R.id.head_hair1);
        head_hair2 = findViewById(R.id.head_hair2);
        head_hair3 = findViewById(R.id.head_hair3);
        head_hair4 = findViewById(R.id.head_hair4);
        head_hair5 = findViewById(R.id.head_hair5);
        head_hair_bold = findViewById(R.id.head_bold);


        //Проверка на активность скина
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME_SKIN);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            string_skinID = new String (bytes);
            skinID = Integer.parseInt(string_skinID);

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

        switch (skinID)
        {
            case 0:
                head_hair_bold.setAlpha((float) 0.4);
            break;
            case 1:
                head_hair1.setAlpha((float) 0.4);
                break;
            case 2:
                head_hair2.setAlpha((float) 0.4);
                break;
            case 3:
                head_hair3.setAlpha((float) 0.4);
                break;
            case 4:
                head_hair4.setAlpha((float) 0.4);
                break;
            case 5:
                head_hair5.setAlpha((float) 0.4);
                break;
        }



    //Считывание кликов



        try {
            fin = openFileInput(FILE_NAME_COUNT);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            countQty = new String (bytes);
            txtValue.setText("Clicks: "+countQty);

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


    }

    public void btnMagBack(View view) {
        Intent i = new Intent(MagazActivity.this, MainActivity.class);
        startActivity(i);
    }


    public void btnHair1(View view) {

        //Проверка на активность скина
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME_SKIN);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            string_skinID = new String (bytes);
            skinID = Integer.parseInt(string_skinID);

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

        if(skinID == 1 )
        {
            Toast.makeText(this, "Вы уже имеете этот скин", Toast.LENGTH_SHORT).show();
        }
else {


            countClick = Integer.parseInt(countQty);

            if (countClick >= 25) {
                countClick -= 25;
                skinID = 1;
                string_skinID = Integer.toString(skinID);
                countQty = Integer.toString(countClick);
                head_hair1.setAlpha((float) 0.4);
                head_hair2.setAlpha((float) 1);
                head_hair3.setAlpha((float) 1);
                head_hair4.setAlpha((float) 1);
                head_hair5.setAlpha((float) 1);
                head_hair_bold.setAlpha((float) 1);
//Запись в файл кликов
                FileOutputStream fos = null;
                try {

                    fos = openFileOutput(FILE_NAME_COUNT, MODE_PRIVATE);
                    fos.write(countQty.getBytes());
                    txtValue.setText("Clicks: " + countQty);

                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                //Запись в файл скин


                try {

                    fos = openFileOutput(FILE_NAME_SKIN, MODE_PRIVATE);
                    fos.write(string_skinID.getBytes());


                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                Toast.makeText(this, "Покупка завершена!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Не хватает кликов!", Toast.LENGTH_SHORT).show();
            }
        }





    }


    public void btnHair2(View view) {
        //Проверка на активность скина
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME_SKIN);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            string_skinID = new String (bytes);
            skinID = Integer.parseInt(string_skinID);

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

        if(skinID == 2 )
        {
            Toast.makeText(this, "Вы уже имеете этот скин", Toast.LENGTH_SHORT).show();
        }
        else {


            countClick = Integer.parseInt(countQty);

            if (countClick >= 25) {
                countClick -= 25;
                skinID = 2;
                string_skinID = Integer.toString(skinID);
                countQty = Integer.toString(countClick);
                head_hair1.setAlpha((float) 1);
                head_hair2.setAlpha((float) 0.4);
                head_hair3.setAlpha((float) 1);
                head_hair4.setAlpha((float) 1);
                head_hair5.setAlpha((float) 1);
                head_hair_bold.setAlpha((float) 1);
//Запись в файл кликов
                FileOutputStream fos = null;
                try {

                    fos = openFileOutput(FILE_NAME_COUNT, MODE_PRIVATE);
                    fos.write(countQty.getBytes());
                    txtValue.setText("Clicks: " + countQty);

                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                //Запись в файл скин


                try {

                    fos = openFileOutput(FILE_NAME_SKIN, MODE_PRIVATE);
                    fos.write(string_skinID.getBytes());


                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                Toast.makeText(this, "Покупка завершена!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Не хватает кликов!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnHair3(View view) {
        //Проверка на активность скина
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME_SKIN);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            string_skinID = new String (bytes);
            skinID = Integer.parseInt(string_skinID);

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

        if(skinID == 3 )
        {
            Toast.makeText(this, "Вы уже имеете этот скин", Toast.LENGTH_SHORT).show();
        }
        else {


            countClick = Integer.parseInt(countQty);

            if (countClick >= 25) {
                countClick -= 25;
                skinID = 3;
                string_skinID = Integer.toString(skinID);
                countQty = Integer.toString(countClick);
                head_hair1.setAlpha((float) 1);
                head_hair2.setAlpha((float) 1);
                head_hair3.setAlpha((float) 0.4);
                head_hair4.setAlpha((float) 1);
                head_hair5.setAlpha((float) 1);
                head_hair_bold.setAlpha((float) 1);
//Запись в файл кликов
                FileOutputStream fos = null;
                try {

                    fos = openFileOutput(FILE_NAME_COUNT, MODE_PRIVATE);
                    fos.write(countQty.getBytes());
                    txtValue.setText("Clicks: " + countQty);

                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                //Запись в файл скин


                try {

                    fos = openFileOutput(FILE_NAME_SKIN, MODE_PRIVATE);
                    fos.write(string_skinID.getBytes());


                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                Toast.makeText(this, "Покупка завершена!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Не хватает кликов!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnHair4(View view) {
        //Проверка на активность скина
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME_SKIN);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            string_skinID = new String (bytes);
            skinID = Integer.parseInt(string_skinID);

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

        if(skinID == 4 )
        {
            Toast.makeText(this, "Вы уже имеете этот скин", Toast.LENGTH_SHORT).show();
        }
        else {


            countClick = Integer.parseInt(countQty);

            if (countClick >= 25) {
                countClick -= 25;
                skinID = 4;
                string_skinID = Integer.toString(skinID);
                countQty = Integer.toString(countClick);
                head_hair1.setAlpha((float) 1);
                head_hair2.setAlpha((float) 1);
                head_hair3.setAlpha((float) 1);
                head_hair4.setAlpha((float) 0.4);
                head_hair5.setAlpha((float) 1);
                head_hair_bold.setAlpha((float) 1);
//Запись в файл кликов
                FileOutputStream fos = null;
                try {

                    fos = openFileOutput(FILE_NAME_COUNT, MODE_PRIVATE);
                    fos.write(countQty.getBytes());
                    txtValue.setText("Clicks: " + countQty);

                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                //Запись в файл скин


                try {

                    fos = openFileOutput(FILE_NAME_SKIN, MODE_PRIVATE);
                    fos.write(string_skinID.getBytes());


                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                Toast.makeText(this, "Покупка завершена!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Не хватает кликов!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnHair5(View view) {
        //Проверка на активность скина
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME_SKIN);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            string_skinID = new String (bytes);
            skinID = Integer.parseInt(string_skinID);

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

        if(skinID == 5 )
        {
            Toast.makeText(this, "Вы уже имеете этот скин", Toast.LENGTH_SHORT).show();
        }
        else {


            countClick = Integer.parseInt(countQty);

            if (countClick >= 25) {
                countClick -= 25;
                skinID = 5;
                string_skinID = Integer.toString(skinID);
                countQty = Integer.toString(countClick);
                head_hair1.setAlpha((float) 1);
                head_hair2.setAlpha((float) 1);
                head_hair3.setAlpha((float) 1);
                head_hair4.setAlpha((float) 1);
                head_hair5.setAlpha((float) 0.4);
                head_hair_bold.setAlpha((float) 1);
//Запись в файл кликов
                FileOutputStream fos = null;
                try {

                    fos = openFileOutput(FILE_NAME_COUNT, MODE_PRIVATE);
                    fos.write(countQty.getBytes());
                    txtValue.setText("Clicks: " + countQty);

                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                //Запись в файл скин


                try {

                    fos = openFileOutput(FILE_NAME_SKIN, MODE_PRIVATE);
                    fos.write(string_skinID.getBytes());


                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                Toast.makeText(this, "Покупка завершена!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Не хватает кликов!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnHair_Bold(View view) {
        //Проверка на активность скина
        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME_SKIN);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            string_skinID = new String (bytes);
            skinID = Integer.parseInt(string_skinID);

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

        if(skinID == 0 )
        {
            Toast.makeText(this, "Вы уже имеете этот скин", Toast.LENGTH_SHORT).show();
        }
        else {


            countClick = Integer.parseInt(countQty);

            if (countClick >= 25) {
                countClick -= 25;
                skinID = 0;
                string_skinID = Integer.toString(skinID);
                countQty = Integer.toString(countClick);
                head_hair1.setAlpha((float) 1);
                head_hair2.setAlpha((float) 1);
                head_hair3.setAlpha((float) 1);
                head_hair4.setAlpha((float) 1);
                head_hair5.setAlpha((float) 1);
                head_hair_bold.setAlpha((float) 0.4);
//Запись в файл кликов
                FileOutputStream fos = null;
                try {

                    fos = openFileOutput(FILE_NAME_COUNT, MODE_PRIVATE);
                    fos.write(countQty.getBytes());
                    txtValue.setText("Clicks: " + countQty);

                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                //Запись в файл скин


                try {

                    fos = openFileOutput(FILE_NAME_SKIN, MODE_PRIVATE);
                    fos.write(string_skinID.getBytes());


                } catch (IOException ex) {
                } finally {
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException ex) {
                    }
                }

                Toast.makeText(this, "Покупка завершена!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Не хватает кликов!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
