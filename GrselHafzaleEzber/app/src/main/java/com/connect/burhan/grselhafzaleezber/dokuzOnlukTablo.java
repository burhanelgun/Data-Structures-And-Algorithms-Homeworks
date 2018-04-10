package com.connect.burhan.grselhafzaleezber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by burhan on 25.02.2018.
 */

public class dokuzOnlukTablo extends Activity {
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dokuzonluktablo);
    }
    public void kelimeGösterimi(View v) {
        switch (v.getId()) {
            case R.id.b21:
                myIntent = new Intent(dokuzOnlukTablo.this, o41.class);
                dokuzOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b22:
                myIntent = new Intent(dokuzOnlukTablo.this, o42.class);
                dokuzOnlukTablo .this.startActivity(myIntent);
                break;
            case R.id.b23:
                myIntent = new Intent(dokuzOnlukTablo.this, o43.class);
                dokuzOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b24:
                myIntent = new Intent(dokuzOnlukTablo.this, o44.class);
                dokuzOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b25:
                myIntent = new Intent(dokuzOnlukTablo.this, o45.class);
                dokuzOnlukTablo.this.startActivity(myIntent);
                break;
        }
    }

}
