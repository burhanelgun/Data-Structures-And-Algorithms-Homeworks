package com.connect.burhan.grselhafzaleezber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by burhan on 25.02.2018.
 */

public class besOnlukTablo extends Activity {
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.besonluktablo);
    }
    public void kelimeGösterimi(View v) {
        switch (v.getId()) {
            case R.id.b21:
                myIntent = new Intent(besOnlukTablo.this, o21.class);
                besOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b22:
                myIntent = new Intent(besOnlukTablo.this, o22.class);
                besOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b23:
                myIntent = new Intent(besOnlukTablo.this, o23.class);
                besOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b24:
                myIntent = new Intent(besOnlukTablo.this, o24.class);
                besOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b25:
                myIntent = new Intent(besOnlukTablo.this, o25.class);
                besOnlukTablo.this.startActivity(myIntent);
                break;
        }
    }

}
