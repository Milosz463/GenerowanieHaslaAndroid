package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
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
                        boolean male=checkBoxMala.isChecked();
                        boolean duze=checkBoxDuza.isChecked();
                        boolean specjalne=checkBoxSpecjalne.isChecked();
                        boolean liczby=checkBoxCyfry.isChecked();
                        int dlugoscHasla=Integer.parseInt(editTextWpisana.getText().toString());
                        String haslo=GenerujHaslo(dlugoscHasla,male,duze,specjalne,liczby);
                        haslo=Fyrlanie(haslo);
                        textViewHaslo.setText(haslo);
                        int liczbaSpelnionychWarunkow=0;
                        if(male){
                            liczbaSpelnionychWarunkow++;
                        }
                        if(duze){
                            liczbaSpelnionychWarunkow++;
                        }
                        if(liczby){
                            liczbaSpelnionychWarunkow++;
                        }
                        if (specjalne){
                            liczbaSpelnionychWarunkow++;
                        }
                        if(liczbaSpelnionychWarunkow==4 && haslo.length() >=12){
                            textViewMocHasla.setText("Silne haslo");
                            textViewHaslo.setTextColor(Color.GREEN);
                        }else if(liczbaSpelnionychWarunkow>=3&&haslo.length()>8){
                            textViewMocHasla.setText("srednie haslo");
                            textViewHaslo.setTextColor(Color.YELLOW);
                        }else{
                            textViewMocHasla.setText("Slabe haslo");
                            textViewHaslo.setTextColor(Color.RED);
                        }

                    }
                }
        );

    }

    /**
     * Nazwa metody generujHaslo
     * Opis-metoda sluzaca do generowania hasla o okreslonej dlugosci o danymi wartosciami
     *parametry
     *  liczbaLiter-liczba calkowita przechowująca dlugość hasła
     *  male-zmienna logiczna określaąca czy w haśle występują małe litery
     *  duze-zmienna logiczna określaąca czy w haśle występują duże litery
     *  specjalne-zmienna logiczna określaąca czy w haśle występują znaki specjalne
     *  liczbyy-zmienna logiczna określaąca czy w haśle występują liczby
     * zwracana wartosc-haslo tekst w ktorym znajduja sie wylosowane litery
     */
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
        /**
         * Nazwa metody fyrlanie
         * Opis-losuje wygenerowane litery
         * parametry
         * slowo-zmienna tekstowa w ktore beda mieszane znaki
         * zwaca wyfyrlane-kejst w ktorym sa wymieszane znaki
         */
        return haslo;
        }
        public String Fyrlanie(String slowo){
        String wyfyrlane="";
        Random random=new Random();
        while(slowo.length()>2){
            int i=random.nextInt(slowo.length()-2)+1;
            wyfyrlane+=slowo.charAt(i);
            slowo=slowo.substring(0,i)+slowo.substring(i+1);
        }
        int pierwszyIndeks=random.nextInt(wyfyrlane.length());
        wyfyrlane=wyfyrlane.substring(0,pierwszyIndeks)+slowo.charAt(0)+wyfyrlane.substring(pierwszyIndeks);

            pierwszyIndeks = random.nextInt(wyfyrlane.length());
            wyfyrlane = wyfyrlane.substring(0,pierwszyIndeks) + slowo.charAt(1)+ wyfyrlane.substring(pierwszyIndeks);
        return wyfyrlane;
        }

    }
