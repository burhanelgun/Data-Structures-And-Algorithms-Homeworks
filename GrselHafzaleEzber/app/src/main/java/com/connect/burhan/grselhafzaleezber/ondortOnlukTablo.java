package com.connect.burhan.grselhafzaleezber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by burhan on 25.02.2018.
 */

public class ondortOnlukTablo extends Activity {
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ondortonluktablo);
    }
    public void kelimeGösterimi(View v) {
        switch (v.getId()) {
            case R.id.b21:
                myIntent = new Intent(ondortOnlukTablo.this, o66.class);
                ondortOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b22:
                myIntent = new Intent(ondortOnlukTablo.this, o67.class);
                ondortOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b23:
                myIntent = new Intent(ondortOnlukTablo.this, o68.class);
                ondortOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b24:
                myIntent = new Intent(ondortOnlukTablo.this, o69.class);
                ondortOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b25:
                myIntent = new Intent(ondortOnlukTablo.this, o70.class);
                ondortOnlukTablo.this.startActivity(myIntent);
                break;
        }
    }

}
