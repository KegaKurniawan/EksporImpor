package com.example.kegafirstapp.eksporimpor;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    Button btnImport, btnEkport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnImport = (Button) findViewById(R.id.bImport);
        btnEkport = (Button) findViewById(R.id.bEkspor);

        btnImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ImportLocation.class);
                startActivity(i);
            }
        });
    }


}
