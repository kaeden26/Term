package com.example.hyub.term1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hyub on 2016-12-16.
 */

public class NoteItemAdapter extends ArrayAdapter<NoteItem> {
    int idTextView;

    public NoteItemAdapter(Context context, int textViewResourceId, List<NoteItem> objects){
        super(context, textViewResourceId, objects);

        idTextView = textViewResourceId;
    }
    @Override
    public View getView(int pos, View v, ViewGroup parent){
        RelativeLayout NoteView;
        NoteItem item = getItem(pos);
        String content = item.getContent();
        Date date = item.getDate();
        SimpleDateFormat fmtDate = new SimpleDateFormat("yy/MM/dd");
        String dateString = fmtDate.format(date);

        if( v== null){
            LayoutInflater li = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            NoteView =  new RelativeLayout(getContext());

            li.inflate(idTextView, NoteView, true);
        }
        else{
            NoteView = (RelativeLayout)v;
        }

        TextView tvContent = (TextView)NoteView.findViewById(R.id.NoteRowContent);
        TextView tvDate = (TextView)NoteView.findViewById(R.id.NoteRowDate);

        tvContent.setText(content);
        tvDate.setText(dateString);

        return NoteView;
    }
}
