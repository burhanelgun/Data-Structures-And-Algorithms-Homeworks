package com.connect.burhan.coonectfour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class main extends AppCompatActivity {

    private static Button startButton;
    public static EditText editSize;
    public static int size;
    public static EditText amountOfTime;
    public static int amountOfTimee;
    public  RadioButton rb1;
    public  RadioButton rb2;
    public static int gameMode=2;
    public static int radius;
    public TextView errorCheck;


    /**
     * Anasayfadaki input ve radio buttonların kontrollerine göre oyun oynanan sayfaya yönlendiren sayfadır
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.connect.burhan.coonectfour.R.layout.activity_main);  // inputlar alınır

        errorCheck = (TextView) findViewById(com.connect.burhan.coonectfour.R.id.textView4);


        startButton = (Button)findViewById(com.connect.burhan.coonectfour.R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStartClicked();

            }
        });

        editSize=(EditText)findViewById(com.connect.burhan.coonectfour.R.id.editText);

        amountOfTime=(EditText) findViewById(com.connect.burhan.coonectfour.R.id.editText2);

        rb1=(RadioButton)findViewById(com.connect.burhan.coonectfour.R.id.OnePlayer);
        rb2=(RadioButton)findViewById(com.connect.burhan.coonectfour.R.id.TwoPlayer);


    }

    /**
     * Start butonuna basılınca olacak olanları içeren method
     */
    private void onStartClicked(){

        if(editSize.getText().toString().matches("")){
           size=1;
        }
        else{
            size=Integer.parseInt(main.editSize.getText().toString());
        }


        if(amountOfTime.getText().toString().matches("")){
            amountOfTimee=10000;
        }
        else{
            amountOfTimee= Integer.parseInt(main.amountOfTime.getText().toString());
        }


        if(10>size){
            radius=50;
        }
        if(size>=10 && size<=12){
            radius=35;
        }
        if(size>=13 && size<=15){
            radius=25;
        }
        if(size>=16 && size<=20){
            radius=18;

        }
        if(size>=21 && size<=25){
            radius=13;
        }
        if(size>=26 && size<=30){
            radius=10;
        }
        if(size>=31 && size<=35){
            radius=7;
        }
        if(size>=36 && size<=40){
            radius=6;

        }

        if(rb1.isChecked()){ //radio button lardan hangisinin check edildiğine bakılır
            gameMode=2;
        }
        else if(rb2.isChecked()){
            gameMode=1;
        }
        Intent intent = new Intent("android.intent.action.Customer" );

        if(size>=5 && size<=40) {
            errorCheck.setText("");
            startActivity(intent);
        }
        else{
            errorCheck.setText("Size Must Be Between 5 and 40");
        }

    }



}
