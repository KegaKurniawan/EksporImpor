package com.example.kegafirstapp.eksporimpor;

/**
 * Created by Kega on 7/21/2016.
 */


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImportLocation extends Activity {

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.import_location);
        btnSubmit = (Button) findViewById(R.id.bSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}