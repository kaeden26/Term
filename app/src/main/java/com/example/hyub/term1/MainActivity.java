package com.example.hyub.term1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double latitude;
    double longitude;
    private Button btnShowLocation;
    private TextView txtLat;
    private TextView txtLon;
    private GpsInfo gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Statistics = (Button) findViewById(R.id.Statistics);
        Button Todo = (Button) findViewById(R.id.Todo);
        Button Map = (Button) findViewById(R.id.Map);
        btnShowLocation = (Button) findViewById(R.id.MyLocation);
        txtLat = (TextView) findViewById(R.id.latitude);
        txtLon = (TextView) findViewById(R.id.longitude);

        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                gps = new GpsInfo(MainActivity.this);
                // GPS 사용유무 가져오기
                if (gps.isGetLocation()) {

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    txtLat.setText(String.valueOf(latitude));
                    txtLon.setText(String.valueOf(longitude));

                    Toast.makeText(
                            getApplicationContext(),
                            "당신의 위치 - \n위도: " + latitude + "\n경도: " + longitude,
                            Toast.LENGTH_LONG).show();
                } else {
                    // GPS 를 사용할수 없으므로
                    gps.showSettingsAlert();
                }
            }
        });

      // final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

/*
        btnShowLocation .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Map.class);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                startActivity(intent);
            }
        });*/
        Todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Todo.class);
                startActivity(intent);
            }
        });
        Map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Map.class);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                startActivity(intent);
            }
        });


    }

/*
   */
/* private void updateLocation(Location location) {
        TextView tvDescription = (TextView) findViewById(R.id.desc);
        TextView tvLongitude = (TextView) findViewById(R.id.longitude);
        TextView tvLatitude = (TextView) findViewById(R.id.latitude);

        if (location != null) {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();

            tvDescription.setText(R.string.desc);
            tvLongitude.setText(
                    getString(R.string.longitude) + " " + longitude);
            tvLatitude.setText(
                    getString(R.string.latitude) + " " + latitude);
        } else {
            tvDescription.setText(R.string.unknown);
            tvLongitude.setText(" ");
            tvLatitude.setText(" ");

        }*//*

    }
*/

}






