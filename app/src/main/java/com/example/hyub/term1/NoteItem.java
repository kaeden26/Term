package com.example.hyub.term1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hyub on 2016-12-16.
 */

public class NoteItem {
    private String content;
    private Date date;

    public NoteItem(String content, Date date){
        this.content = content;
        this.date = date;
    }

    public NoteItem(String content){
        this(content, new Date(java.lang.System.currentTimeMillis()));
    }

    public String getContent(){
        return content;
    }

    public Date getDate(){
        return date;
    }
    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
        String dateString = dateFormat.format(date);

        return "["+dateString+"]"+content;
    }
}
