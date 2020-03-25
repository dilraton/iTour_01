package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main_fragment3 extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user, container, false);
        LinearLayout fans = view.findViewById(R.id.fans);
        LinearLayout attention = view.findViewById(R.id.attention);
        LinearLayout line = view.findViewById(R.id.line);
        TextView name = view.findViewById(R.id.name);

        MainActivity mainActivity = (MainActivity) getActivity();
        String name1 = mainActivity.getName();
        name.setText(name1);




        fans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),FansActivity.class);
                startActivity(i);
            }
        });

        attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),attention.class);
                startActivity(i);
            }
        });

        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Traveline.class);
                startActivity(i);
            }
        });
         String[] says = new String[]{"111111，2222222", "33333333~", "444444444~"};
         int[] imgIds = new int[]{R.drawable.f4, R.drawable.f5, R.drawable.f6};

        String[] times = new String[]{"1天前", "3天前~", "2天前~"};


        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < says.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("touxiang", imgIds[i]);
            showitem.put("says", says[i]);
            showitem.put("time", times[i]);
            listitem.add(showitem);
        }


        //创建一个simpleAdapter
        SimpleAdapter myAdapter = new SimpleAdapter(getActivity(), listitem,
                R.layout.content_listview, new String[]{"touxiang",  "says","time"},
                new int[]{R.id.imgtou,  R.id.says, R.id.time});
        ListView listView = view.findViewById(R.id.content);
        listView.setAdapter(myAdapter);



        return view;
    }


}
