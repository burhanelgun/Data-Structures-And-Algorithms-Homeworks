package com.connect.burhan.grselhafzaleezber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by burhan on 24.02.2018.
 */

public class ellilikTablo extends Activity {
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.elliliktablo);
    }

    public void ellilikButon(View v) {
        switch (v.getId()) {
            case R.id.b1:
                myIntent = new Intent(ellilikTablo.this, birOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b2:
                myIntent = new Intent(ellilikTablo.this, ikiOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b3:
                myIntent = new Intent(ellilikTablo.this, ucOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b4:
                 myIntent = new Intent(ellilikTablo.this, dortOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b5:
                 myIntent = new Intent(ellilikTablo.this, besOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b6:
                 myIntent = new Intent(ellilikTablo.this, altiOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b7:
                 myIntent = new Intent(ellilikTablo.this, yediOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b8:
                 myIntent = new Intent(ellilikTablo.this, sekizOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b9:
                 myIntent = new Intent(ellilikTablo.this, dokuzOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b10:
                 myIntent = new Intent(ellilikTablo.this, onOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b11:
                 myIntent = new Intent(ellilikTablo.this, onbirOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b12:
                 myIntent = new Intent(ellilikTablo.this, onikiOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b13:
                 myIntent = new Intent(ellilikTablo.this, onucOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b14:
                 myIntent = new Intent(ellilikTablo.this, ondortOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b15:
                 myIntent = new Intent(ellilikTablo.this, onbesOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b16:
                 myIntent = new Intent(ellilikTablo.this, onaltiOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b17:
                 myIntent = new Intent(ellilikTablo.this, onyediOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b18:
                 myIntent = new Intent(ellilikTablo.this, onsekizOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b19:
                 myIntent = new Intent(ellilikTablo.this, ondokuzOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
            case R.id.b20:
                 myIntent = new Intent(ellilikTablo.this, yirmiOnlukTablo.class);
                ellilikTablo.this.startActivity(myIntent);
                break;
        }
    }
}