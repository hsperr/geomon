package com.mon.geo.geomon;

import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;

import junit.framework.Assert;

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

    public void testNetBlaster() throws Exception {
        // TODO find a way to mock network requests
        solo.clearLog();
        solo.clickOnButton("Send Request");
        Assert.assertTrue("Expected response: asdasd", solo.waitForLogMessage("asdasd", 5000));
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}
