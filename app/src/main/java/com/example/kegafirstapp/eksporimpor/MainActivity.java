package com.example.kegafirstapp.eksporimpor;

//import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button btnImport, btnEkport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Main Menu");
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        btnImport = (Button) findViewById(R.id.bImport);
        btnEkport = (Button) findViewById(R.id.bEkspor);

        btnImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ImportLocation.class);
                startActivity(i);
                overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_in_top);
            }
        });
    }


}
