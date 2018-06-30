package com.example.lc.broadcast.another_view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Crime {
    public  Crime(){
        mDate = new Date();
        mUUID = UUID.randomUUID() ;
    }
    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        return  dateFormat.format(mDate);
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Boolean getSolved() {
        return mSolved;
    }

    public void setSolved(Boolean solved) {
        mSolved = solved;
    }

    private UUID mUUID;
    private String  mTitle;
    private Date mDate;
    private Boolean mSolved;
}
