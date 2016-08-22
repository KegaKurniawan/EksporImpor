package com.example.kegafirstapp.eksporimpor;

/**
 * Created by Kega on 7/21/2016.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class ImportLocation extends Activity {

    Button btnSubmit;
    Spinner spinLocation;
    public final static String ID_EXTRA = "com.example.kegafirstapp.testxml.ImportLocation._ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.import_location);

        btnSubmit = (Button) findViewById(R.id.bSubmit);
        spinLocation = (Spinner) findViewById(R.id.spinnerLocation);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = spinLocation.getSelectedItem().toString();
                Intent in = new Intent(getApplicationContext(), ImportStep.class);
                in.putExtra(ID_EXTRA, String.valueOf(text));
                startActivityForResult(in, 100);
            }
        });
    }
}