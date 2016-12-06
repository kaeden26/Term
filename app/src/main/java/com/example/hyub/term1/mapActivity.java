package com.example.hyub.term1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.*;

/**
 * Created by hyub on 2016-12-06.
 */

public class mapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gmap;
    double longitude;
    double latitude;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapView = (MapView)findViewById(R.id.map_view);
    }
}
