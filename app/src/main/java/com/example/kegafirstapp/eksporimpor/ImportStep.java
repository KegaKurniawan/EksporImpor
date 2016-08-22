package com.example.kegafirstapp.eksporimpor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Kega on 8/16/2016.
 */
public class ImportStep extends ActionBarActivity {

    String passedVar, location;
    Button btnPpjk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.import_step);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Langkah Import Barang");
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        passedVar = getIntent().getStringExtra(ImportLocation.ID_EXTRA);
        location = passedVar;

        btnPpjk = (Button) findViewById(R.id.bPpjk);

        btnPpjk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),PpjkList.class);
                startActivity(i);
                overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_in_top);
            }
        });



    }

}
