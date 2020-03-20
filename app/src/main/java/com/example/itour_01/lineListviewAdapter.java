package com.example.itour_01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.LinkedList;

public class lineListviewAdapter extends BaseAdapter {

    private LinkedList<lineListview> mData;
    private Context mContext;

    public lineListviewAdapter(LinkedList<lineListview> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.line_listview,viewGroup,false);

        EditText lineName = view.findViewById(R.id.lineName);

        lineName.setText(mData.get(i).getlineName());


        return view;
    }



}
