package com.mon.geo.geomon;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MonsterSackActivity extends Activity
        implements MonsterSackFragment.OnFragmentInteractionListener,
                   MonsterDetailsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_sack);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_monster_sack, menu);
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

    /**
     * Allow interaction with monster list fragment
     * @param id
     */
    public void onListFragmentInteraction(String id) {
        // We shouldn't be here if we're in landscape
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Change the monster in the details panel
        } else {
            Intent toDetail = new Intent(MonsterSackActivity.this, MonsterDetailActivity.class);
            startActivity(toDetail);
        }
    }

    public void onDetailFragmentInteraction() {
        // do nuthing for now
    }
}
