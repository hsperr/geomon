package com.mon.geo.geomon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.mon.geo.geomon.Map.GeoInfo;
import com.mon.geo.geomon.Net.NetBlaster;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends Activity {

    private GeoInfo geoInfo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        geoInfo = new GeoInfo(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.buttonMap)
    public void onOpenMapClick() {
                Intent myIntent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(myIntent);
    }

    @OnClick(R.id.sendRequest)
    public void onSendRequestClick() {
        String url =  "http://10.0.2.2:8080/get_spawn?pos=";
        String location = geoInfo.getLocationAsString();
        if(location==""){
            Log.w("VolleyQuery","No Location found, returning");
            return;
        }
        url+=location;
        Log.v("VolleyQuery","Query: "+url);

        NetBlaster.getInstance(this).addToRequestQueue(new StringRequest(
                Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("VolleyResponse", response);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //TODO: crashes on some errors because getMessage seems to be empty
                        if (error.getMessage() == null) {
                            Log.e("VolleyResponse", "Connection failed, empty error.");
                        } else {
                            Log.e("VolleyResponse", error.getMessage());
                        }
                    }

                }
        ));
    }

}
