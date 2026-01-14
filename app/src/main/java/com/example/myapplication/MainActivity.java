package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
TextView textViewMocHasla;
TextView textViewHaslo;
CheckBox checkBoxMala;
CheckBox checkBoxDuza;
CheckBox checkBoxCyfry;
CheckBox checkBoxSpecjalne;
Button buttonGeneruj;
EditText editTextWpisana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWpisana=findViewById(R.id.editTextTextNumber);
        checkBoxMala=findViewById(R.id.checkBox);
        checkBoxDuza=findViewById(R.id.checkBox2);
        checkBoxCyfry=findViewById(R.id.checkBox3);
        checkBoxSpecjalne=findViewById(R.id.checkBox4);
        buttonGeneruj=findViewById(R.id.button);
        textViewMocHasla=findViewById(R.id.textView);
        textViewHaslo=findViewById(R.id.textView2);

        buttonGeneruj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, GenerujHaslo(10,true,true,true,true), Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
    private String GenerujHaslo (int liczbaLiter,boolean male,boolean duze,boolean specjalne,boolean liczbyy){
        String haslo="";
        String maleLiatery="qwerty7uiopasdfghjklzxcvbnm";
        String duzeLitery="QWERTYUIOPASDFGHJKLZXCVBNM";
        String znakiSpecjalne="!~@#$%^&*()";
        String liczby="1234567890";
        String wszystkieZnaki="";
        Random random=new Random();

            if (male) {
                int indeks = random.nextInt(maleLiatery.length());
                haslo += maleLiatery.charAt(indeks);
                wszystkieZnaki += maleLiatery;
            }
            if (duze) {
                int indeks = random.nextInt(duzeLitery.length());
                haslo += duzeLitery.charAt(indeks);
                wszystkieZnaki += duzeLitery;
            }
            if (liczbyy) {
                int indeks = random.nextInt(liczby.length());
                haslo += liczby.charAt(indeks);
                wszystkieZnaki += liczby;
            }
            if (specjalne) {
                int indeks = random.nextInt(znakiSpecjalne.length());
                haslo += znakiSpecjalne.charAt(indeks);
                wszystkieZnaki += znakiSpecjalne;
            }
           while(haslo.length()<liczbaLiter){
               int indeks=random.nextInt(wszystkieZnaki.length());
               haslo+=wszystkieZnaki.charAt(indeks);
           }
        return haslo;
        }
        public String Fyrlanie(String slowo){
        String wyfyrlane="";
        Random random=new Random();
        while(slowo.length()>2){
            int i=random.nextInt(slowo.length()-2)+1;
            wyfyrlane+=slowo.charAt(i);
            slowo=slowo.substring(0,i)+slowo.substring(i,1);
        }
        int pierwszyIndeks=random.nextInt(wyfyrlane.length());
        wyfyrlane=wyfyrlane.substring(0,pierwszyIndeks)+slowo.charAt(0)+wyfyrlane.substring(pierwszyIndeks);

        return wyfyrlane;
        }

    }
