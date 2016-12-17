package com.example.hyub.term1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by hyub on 2016-12-11.
 */
public class Map extends FragmentActivity implements OnMapReadyCallback{
    private GoogleMap mMap;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Intent intent = getIntent();
        latitude = intent.getExtras().getDouble("latitude");
        longitude = intent.getExtras().getDouble("longitude");

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        CameraUpdate zoom = CameraUpdateFactory.zoomTo(13);
        googleMap.animateCamera(zoom);

        MarkerOptions marker = new MarkerOptions();
        marker.position(new LatLng(latitude, longitude))
                .title("현재 위치")
                .snippet("메모 입력");
        googleMap.addMarker(marker).showInfoWindow();

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    public boolean onMarkerClick(Marker marker) {

                Intent intent = new Intent(Map.this, Todo.class);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                startActivity(intent);
                return false;
            }
        });
    }
}
