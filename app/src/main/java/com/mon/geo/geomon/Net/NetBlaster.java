package com.mon.geo.geomon.Net;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Volley request queue-er
 */
public class NetBlaster {

    private static NetBlaster instance;
    private static Context appContext;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;

    /*
     * Get instance of network queue
     */
    public static synchronized NetBlaster getInstance(Context context) {
        if (instance == null) {
            instance = new NetBlaster(context);
        }
        return instance;
    }

    private NetBlaster(Context context) {

    }

    public RequestQueue getRequestQueue(Context context) {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
    }
}
