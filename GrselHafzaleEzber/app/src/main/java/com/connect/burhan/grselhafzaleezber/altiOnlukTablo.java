package com.connect.burhan.grselhafzaleezber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by burhan on 25.02.2018.
 */

public class altiOnlukTablo extends Activity {
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.altionluktablo);
    }
    public void kelimeGösterimi(View v) {
        switch (v.getId()) {
            case R.id.b21:
                myIntent = new Intent(altiOnlukTablo.this, o26.class);
                altiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b22:
                myIntent = new Intent(altiOnlukTablo.this, o27.class);
                altiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b23:
                myIntent = new Intent(altiOnlukTablo.this, o28.class);
                altiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b24:
                myIntent = new Intent(altiOnlukTablo.this, o29.class);
                altiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b25:
                myIntent = new Intent(altiOnlukTablo.this, o30.class);
                altiOnlukTablo.this.startActivity(myIntent);
                break;
        }
    }

}
