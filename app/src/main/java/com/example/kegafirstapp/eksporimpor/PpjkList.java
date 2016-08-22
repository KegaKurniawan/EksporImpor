package com.example.kegafirstapp.eksporimpor;

/**
 * Created by Kega on 8/16/2016.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class PpjkList extends ListActivity {

    private ProgressDialog pDialog;

    JSONparser jParser = new JSONparser();

    ArrayList<HashMap<String, String>> ppjksList;

    private static String url_all_products = "http://easygaming.esy.es/ekspor_impor/daftar_ppjk.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PPJK = "ppjk";
    private static final String TAG_NAMA = "Nama";

    JSONArray ppjks = null;
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppjk_list);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        ppjksList = new ArrayList<HashMap<String, String>>();

        ListView lv = getListView();
        new LoadAllPpjk().execute();

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    class LoadAllPpjk extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(PpjkList.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        protected String doInBackground(String... args) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            JSONObject json = jParser.getJSONFromUrl(url_all_products);

            Log.d("All Products: ", json.toString());

            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    ppjks = json.getJSONArray(TAG_PPJK);

                    // looping through All Products
                    for (int i = 0; i < ppjks.length(); i++) {
                        JSONObject c = ppjks.getJSONObject(i);

                        // Storing each json item in variable
                        String name = c.getString(TAG_NAMA);

                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        map.put(TAG_NAMA, name);

                        // adding HashList to ArrayList
                        ppjksList.add(map);
                    }
                } else {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "data ppjk tidak ada", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    ListAdapter adapter = new SimpleAdapter(
                            PpjkList.this, ppjksList,
                            R.layout.list_item, new String[]{
                            TAG_NAMA},new int[]{R.id.list_text} );
                    // updating listview
                    setListAdapter(adapter);
                }
            });

        }
    }
}
