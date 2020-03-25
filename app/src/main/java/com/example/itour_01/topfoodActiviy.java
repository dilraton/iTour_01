package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        String[] names = new String[]{"锦里", "宽窄巷子~", "欢乐谷~"};
        int[] imgIds = new int[]{R.drawable.f6, R.drawable.f5, R.drawable.f6};


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


    }
}
