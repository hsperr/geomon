package com.mon.geo.geomon;

import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;
/**
 * Created by hsperr on 11/29/14.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{

    private Solo solo;
    public MainActivityTest() {
        super(MainActivity.class);
    }
    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }
    public void testMapButton() throws Exception{
        solo.clickOnButton("Map");
        solo.waitForActivity("MapsActivity");
        solo.assertCurrentActivity("Map button does not work.", MapsActivity.class);
    }
    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}
