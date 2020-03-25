package com.example.itour_01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BlankFragment1 extends Fragment {


    public BlankFragment1() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);

        String[] times = new String[]{"1天前", "3天前~", "2天前~"};
        String[] says = new String[]{"111111，2222222", "33333333~", "444444444~"};
        int[] imgIds = new int[]{R.drawable.f4, R.drawable.f5, R.drawable.f6};


        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < says.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("touxiang", imgIds[i]);
            showitem.put("says", says[i]);
            showitem.put("times",times[i]);
            listitem.add(showitem);
        }


        //创建一个simpleAdapter
        SimpleAdapter myAdapter = new SimpleAdapter(getActivity(), listitem,
                R.layout.content_listview, new String[]{"touxiang","says", "times"},
                new int[]{R.id.imgtou,R.id.says,R.id.time });
        ListView listView = view.findViewById(R.id.fmlist1);
        listView.setAdapter(myAdapter);

        return view;
    }



}
