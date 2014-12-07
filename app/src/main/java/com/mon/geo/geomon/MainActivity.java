package com.mon.geo.geomon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.mon.geo.geomon.Net.NetBlaster;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
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
        NetBlaster.getInstance(this).addToRequestQueue(new StringRequest(
            Request.Method.GET, "http://google.com",

            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VolleyResponse", response.substring(0, 500));
                }
            },

            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VolleyResponse", error.getMessage());
                    }
                }
        ));
    }

    @OnClick(R.id.toMonsterSack)
    public void onMonsterSackClick() {
        Intent toSack = new Intent(MainActivity.this, MonsterSackActivity.class);
        startActivity(toSack);
    }

}
