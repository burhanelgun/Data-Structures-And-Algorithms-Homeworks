package com.connect.burhan.grselhafzaleezber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by burhan on 25.02.2018.
 */

public class birOnlukTablo extends Activity {
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.bironluktablo);
    }

    public void kelimeGösterimi(View v){
        switch (v.getId()) {
            case R.id.b21:
                myIntent = new Intent(birOnlukTablo.this, birinciOnluk.class);
                birOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b22:
                myIntent = new Intent(birOnlukTablo.this, ikinciOnluk.class);
                birOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b23:
                myIntent = new Intent(birOnlukTablo.this, ucuncuOnluk.class);
                birOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b24:
                myIntent = new Intent(birOnlukTablo.this, dorduncuOnluk.class);
                birOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b25:
                myIntent = new Intent(birOnlukTablo.this, besinciOnluk.class);
                birOnlukTablo.this.startActivity(myIntent);
                break;
        }

    }
}

