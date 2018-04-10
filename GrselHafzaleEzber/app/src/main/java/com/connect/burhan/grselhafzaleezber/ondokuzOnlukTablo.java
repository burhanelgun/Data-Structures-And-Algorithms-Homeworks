package com.connect.burhan.grselhafzaleezber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by burhan on 25.02.2018.
 */

public class ondokuzOnlukTablo extends Activity {
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ondokuzonluktablo);
    }
    public void kelimeGösterimi(View v) {
        switch (v.getId()) {
            case R.id.b21:
                myIntent = new Intent(ondokuzOnlukTablo.this, o91.class);
                ondokuzOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b22:
                myIntent = new Intent(ondokuzOnlukTablo.this, o92.class);
                ondokuzOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b23:
                myIntent = new Intent(ondokuzOnlukTablo.this, o93.class);
                ondokuzOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b24:
                myIntent = new Intent(ondokuzOnlukTablo.this, o94.class);
                ondokuzOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b25:
                myIntent = new Intent(ondokuzOnlukTablo.this, o95.class);
                ondokuzOnlukTablo.this.startActivity(myIntent);
                break;
        }
    }

}
