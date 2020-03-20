package com.example.itour_01;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class lineActivity extends AppCompatActivity {
    private List<lineListview> mData = null;
    private Context mContext;
    private lineListviewAdapter mAdapter = null;
    private ListView listline;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        mContext = lineActivity.this;

        listline = (ListView) findViewById(R.id.line);

        mData = new LinkedList<lineListview>();
        mData.add(new lineListview("小吃街"));
        mData.add(new lineListview("华山"));
        mData.add(new lineListview("兵马俑"));
        mAdapter = new lineListviewAdapter((LinkedList<lineListview>) mData, mContext);
        listline.setAdapter(mAdapter);
    }

}
