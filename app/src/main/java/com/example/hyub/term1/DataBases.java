package com.example.hyub.term1;

import android.provider.BaseColumns;

import static com.example.hyub.term1.R.id.latitude;
import static com.example.hyub.term1.R.id.longitude;

/**
 * Created by hyub on 2016-12-16.
 */

public class DataBases {
    public static final class CreateDB implements BaseColumns {
        public static final double LATITUDE = Double.parseDouble("latitude");
        public static final String LONGITUDE = "longitude";
        public static final String TODO = "Todo";
        public static final String _TABLENAME ="Term";
        public static final String _CREATE = "create table"+_TABLENAME+"("
        +_ID+"integer primary key autoincrement,"
        +LATITUDE+" not null,"
        +LONGITUDE+" not null,"
        +TODO+"text not null);";
        public static final String _INSERT = "INSERT INTO"+_TABLENAME+"VALUES(null,'"+latitude+"','"+longitude+");";
            }
}
