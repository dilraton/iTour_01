package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_fragment1 extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);


        LinearLayout search = view.findViewById(R.id.search);
        TextView food = view.findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),topfoodActiviy.class);
                startActivity(i);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SearchActivity.class);
                startActivity(i);
            }
        });

        String[] names = new String[]{"Tom", "Jack", "Json"};
        String[] says = new String[]{"111111，2222222", "33333333~", "444444444~"};
        int[] imgIds = new int[]{R.drawable.f4, R.drawable.f5, R.drawable.f6};


        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < says.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("touxiang", imgIds[i]);
            showitem.put("name",names[i]);
            showitem.put("says", says[i]);
            listitem.add(showitem);
        }


        //创建一个simpleAdapter
        SimpleAdapter myAdapter = new SimpleAdapter(getActivity(), listitem,
                R.layout.home_listview, new String[]{"touxiang","name", "says"},
                new int[]{R.id.imgtou,R.id.name, R.id.says});
        ListView listView = view.findViewById(R.id.content);
        listView.setAdapter(myAdapter);


        return view;
    }

}
