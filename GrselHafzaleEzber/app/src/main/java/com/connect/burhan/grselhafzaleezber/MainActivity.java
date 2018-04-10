package com.connect.burhan.grselhafzaleezber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ezbereBaslaButton(View view) {
        Intent myIntent = new Intent(MainActivity.this, ellilikTablo.class);
        MainActivity.this.startActivity(myIntent);
    }
}
