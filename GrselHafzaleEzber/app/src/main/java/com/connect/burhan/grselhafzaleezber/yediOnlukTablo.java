package com.connect.burhan.grselhafzaleezber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by burhan on 25.02.2018.
 */

public class yediOnlukTablo extends Activity {
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.yedionluktablo);
    }
    public void kelimeGösterimi(View v) {
        switch (v.getId()) {
            case R.id.b21:
                myIntent = new Intent(yediOnlukTablo.this, o31.class);
                yediOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b22:
                myIntent = new Intent(yediOnlukTablo.this, o32.class);
                yediOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b23:
                myIntent = new Intent(yediOnlukTablo.this, o33.class);
                yediOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b24:
                myIntent = new Intent(yediOnlukTablo.this, o34.class);
                yediOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b25:
                myIntent = new Intent(yediOnlukTablo.this, o35.class);
                yediOnlukTablo.this.startActivity(myIntent);
                break;
        }
    }

}
