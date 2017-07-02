package com.example.pc.socialnet;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler_sqlite helper = new Handler_sqlite(this);
        TextView text=(TextView)findViewById(R.id.text);
        helper.abrir();
        text.setText(helper.leer());
    }

    public void llamar(View view) {
        Intent i = new Intent(this, Primero.class);
        startActivity(i);

    }
}