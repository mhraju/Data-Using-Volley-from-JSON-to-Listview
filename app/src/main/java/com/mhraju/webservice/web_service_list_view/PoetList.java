package com.mhraju.webservice.web_service_list_view;

import android.os.Bundle;

/**
 * Created by MaksudulHasan on 02-Aug-16.
 */
public class PoetList {
    private String poetName,poetBiography;
    private int poetId;


    public PoetList() {
    }

    public PoetList(int poetId, String poetName, String poetBiography) {
        this.poetId = poetId;
        this.poetName = poetName;
        this.poetBiography = poetBiography;
    }


    public int getPoetId() {
        return poetId;
    }

    public void setPoetId(int poetId) {
        this.poetId = poetId;
    }


    public String getPoetName() {
        return poetName;
    }

    public void setPoetName(String poetName) {
        this.poetName = poetName;
    }


    public String getPoetBiography() {
        return poetBiography;
    }

    public void setPoetBiography(String poetBiography) {
        this.poetBiography = poetBiography;
    }

    public Bundle getPoetInfoBundle(){
        Bundle bundle = new Bundle();
        bundle.putInt("id",this.poetId);
        bundle.putString("name",this.poetName);
        bundle.putString("bio",this.poetBiography);
        return bundle;
    }


}
