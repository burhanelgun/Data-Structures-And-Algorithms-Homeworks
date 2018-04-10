package com.connect.burhan.grselhafzaleezber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by burhan on 25.02.2018.
 */

public class onaltiOnlukTablo extends Activity {
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.onaltionluktablo);
    }
    public void kelimeGösterimi(View v) {
        switch (v.getId()) {
            case R.id.b21:
                myIntent = new Intent(onaltiOnlukTablo.this, o76.class);
                onaltiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b22:
                myIntent = new Intent(onaltiOnlukTablo.this, o77.class);
                onaltiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b23:
                myIntent = new Intent(onaltiOnlukTablo.this, o78.class);
                onaltiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b24:
                myIntent = new Intent(onaltiOnlukTablo.this, o79.class);
                onaltiOnlukTablo.this.startActivity(myIntent);
                break;
            case R.id.b25:
                myIntent = new Intent(onaltiOnlukTablo.this, o80.class);
                onaltiOnlukTablo.this.startActivity(myIntent);
                break;
        }
    }

}
