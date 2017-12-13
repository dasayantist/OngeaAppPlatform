package com.knatcom.ongeaappplatform;

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
    public void talk(View view){
        Intent main = new Intent(MainActivity.this, Service1.class);
        startActivity(main);
    }
    public void report(View view){

    }
    public void emergency(View view){

    }
    public void guide(View view){

    }
}
