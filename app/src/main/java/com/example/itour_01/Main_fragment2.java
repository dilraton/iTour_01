package com.example.itour_01;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.LinkedList;
import java.util.List;

public class Main_fragment2 extends Fragment {

    private List<lineListview> mData = null;
    private Context mContext;
    private lineListviewAdapter mAdapter = null;
    private ListView listline;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_line, container, false);

        mContext = getActivity();

        listline = view.findViewById(R.id.line);

        mData = new LinkedList<lineListview>();
        mData.add(new lineListview("小吃街"));
        mData.add(new lineListview("华山"));
        mData.add(new lineListview("兵马俑"));
        mAdapter = new lineListviewAdapter((LinkedList<lineListview>) mData, mContext);
        listline.setAdapter(mAdapter);





        return view;
    }
}
