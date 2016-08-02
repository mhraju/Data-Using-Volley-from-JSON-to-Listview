package com.mhraju.webservice.web_service_list_view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    private static final String url = "http://nerdcastlebd.com/_old-site/web_service/banglapoems/index.php/poets/all/format/json";
    ArrayList<PoetList> poetDetailsArrayList;
    private ProgressDialog pDialog;
    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        poetDetailsArrayList = new ArrayList<>();
        adapter = new CustomListAdapter(this,R.layout.list_row, poetDetailsArrayList);

        listView.setAdapter(adapter);



        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                JSONArray jsonArray = null;
                try {
                    jsonArray = response.getJSONArray("poets");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        PoetList poetDetails = new PoetList();
                        poetDetails.setPoetId(jsonObject.getInt("id"));
                        poetDetails.setPoetName(jsonObject.getString("name"));
                        poetDetails.setPoetBiography(jsonObject.getString("biography"));
                        poetDetailsArrayList.add(poetDetails);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error + "", Toast.LENGTH_SHORT).show();


            }
        });


        AppController.getInstance().addToRequestQueue(request);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,PoetDestailsActivity.class);
                intent.putExtras(poetDetailsArrayList.get(position).getPoetInfoBundle());
                startActivity(intent);
            }
        });

    }
}