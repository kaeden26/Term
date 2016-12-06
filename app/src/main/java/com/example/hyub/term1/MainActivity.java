package com.example.hyub.term1;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button MyLocation = (Button) findViewById(R.id.MyLocation);
        Button Statistics = (Button) findViewById(R.id.Statistics);
        Button Todo = (Button) findViewById(R.id.Todo);

        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        final Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        MyLocation.setOnClickListener(new View.OnClickListener(){
            double longitude;
            double latitude;
            @Override
            public void onClick(View v){
                try {
                    updateLocation(location);
                }
                catch (SecurityException se) {
                }
                Intent intent = new Intent(getApplicationContext(),Map.class);
                intent.putExtra("latitude",latitude);
                intent.putExtra("longitude",longitude);
                startActivity(intent);
            }
        });

    }
        private void updateLocation(Location location){
        TextView tvDescription = (TextView)findViewById(R.id.desc);
        TextView tvLongitude = (TextView)findViewById(R.id.longitude);
        TextView tvLatitude = (TextView)findViewById(R.id.latitude);

        if (location != null) {
            double dbLongitude = location.getLongitude();
            double dbLatitude = location.getLatitude();

            tvDescription.setText(R.string.desc);
            tvLongitude.setText(
                    getString(R.string.longitude) + " " + dbLongitude);
            tvLatitude.setText(
                    getString(R.string.latitude) + " " + dbLatitude);
        }
        else{
            tvLongitude.setText(" ");
            tvLatitude.setText(" ");

        }
    }







    }
}
