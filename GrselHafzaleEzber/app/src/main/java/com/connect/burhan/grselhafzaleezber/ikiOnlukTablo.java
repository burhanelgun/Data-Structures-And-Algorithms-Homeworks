package com.connect.burhan.grselhafzaleezber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by burhan on 25.02.2018.
 */

public class ikiOnlukTablo extends Activity {
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ikionluktablo);
    }
    public void kelimeGösterimi(View v){
        switch (v.getId()) {
            case R.id.b21:
                myIntent = new Intent(ikiOnlukTablo.this, altinciOnluk.class);
                ikiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b22:
                myIntent = new Intent(ikiOnlukTablo.this, yedinciOnluk.class);
                ikiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b23:
                myIntent = new Intent(ikiOnlukTablo.this, sekizinciOnluk.class);
                ikiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b24:
                myIntent = new Intent(ikiOnlukTablo.this, dokuzuncuOnluk.class);
                ikiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b25:
                myIntent = new Intent(ikiOnlukTablo.this, onuncuOnluk.class);
                ikiOnlukTablo.this.startActivity(myIntent);
                break;
        }

    }

}
