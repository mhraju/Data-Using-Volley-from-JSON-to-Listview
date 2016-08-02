package com.mhraju.webservice.web_service_list_view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
/**
 * Created by MaksudulHasan on 02-Aug-16.
 */
public class CustomListAdapter extends ArrayAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<PoetList> movieItems;
    private Context context;
    private List<PoetList> videoBeansList;

    public CustomListAdapter(Context context, int resource, List<PoetList> objects) {
        super(context, resource, objects);
        this.context = context;
        this.videoBeansList = objects;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        view = inflater.inflate(R.layout.list_row, null);
        PoetList videoBean = videoBeansList.get(position);

        TextView titleTextVIew = (TextView) view.findViewById(R.id.name);
        titleTextVIew.setText(videoBean.getPoetName());

        return view;
    }




}
