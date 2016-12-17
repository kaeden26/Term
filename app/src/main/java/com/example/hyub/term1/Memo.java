/*package com.example.hyub.term1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

*//**
 * Created by hyub on 2016-12-16.
 *//*

public class Memo extends AppCompatActivity {

    Point p = new Point();
    String content = new String();
    String point1;
    int point;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

       final EditText memo = (EditText)findViewById(R.id.Memo);
        *//*Spinner spinner =  (Spinner)findViewById(R.id.spinner);*//*

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int point, long id){
                p.setPoint(point);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                content = memo.getText().toString();
                point = p.getPoint();

                switch (point){
                    case 1: point1 = "1";
                        break;
                    case 2 : point1 = "2";
                        break;
                    case 3 : point1 = "3";
                        break;
                    case 4 : point1 = "4";
                        break;
                    case 5 : point1 = "5";
                        break;
                }
            }
        });

        }
    class Point {
        private int point;

        public void setPoint(int point){
            this.point = point;
        }

        public int getPoint(){
            return point;
        }
    }
}*/
