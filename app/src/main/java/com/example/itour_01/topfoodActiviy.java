package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class topfoodActiviy extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topfood);

        TextView back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(topfoodActiviy.this,MainActivity.class);
                startActivity(i);
            }
        });

        String[] names = new String[]{"锦里", "宽窄巷子", "春熙路"};
        int[] imgIds = new int[]{R.drawable.f7, R.drawable.f8, R.drawable.f9};


        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("names",names[i]);
            showitem.put("touxiang", imgIds[i]);
            listitem.add(showitem);
        }


        //创建一个simpleAdapter
        SimpleAdapter myAdapter = new SimpleAdapter(topfoodActiviy.this, listitem,
                R.layout.top_listview, new String[]{"names","touxiang"},
                new int[]{R.id.name,R.id.pic});
        ListView listView = findViewById(R.id.food);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("sname",names[position]);
                bundle.putInt("photo",imgIds[position]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(topfoodActiviy.this,visit_detail.class);
                startActivity(intent);
            }
        });


    }
}
