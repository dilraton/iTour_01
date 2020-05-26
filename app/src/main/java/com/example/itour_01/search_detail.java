package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class search_detail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);

        TextView title = findViewById(R.id.title);
        Bundle bundle = getIntent().getExtras();
        String title1 = bundle.getString("content");
        title.setText(title1);

        TextView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(search_detail.this,MainActivity.class);
                startActivity(i);
            }
        });

        int[] imgIds = new int[]{R.drawable.f10, R.drawable.f12, R.drawable.f11};

        String[] name = new String[3];

        new Thread() {
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://rm-2zemllxq8jl06818eao.mysql.rds.aliyuncs.com:3306/itour";

                    Connection conn = DriverManager.getConnection(url, "system", "QWer1234");

                    if (conn != null) {
                        Log.d("调试", "成功");
                        Statement stmt = conn.createStatement();
                        String sql = "select acontent from activity where city = \""+title1+"\"";
                        ResultSet rs = stmt.executeQuery(sql);
                        int j=0;

                        while(rs.next()){
                            name[j] = rs.getString(1);
                            j++;

                        }
                        Log.d("name",name[2]);


                    } else {
                        Log.d("调试", "连接失败");
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("names",name[i]);
            showitem.put("touxiang", imgIds[i]);
            listitem.add(showitem);
        }

        SimpleAdapter myAdapter = new SimpleAdapter(search_detail.this, listitem,
                R.layout.top_listview, new String[]{"names","touxiang"},
                new int[]{R.id.name,R.id.pic});
        ListView listView = findViewById(R.id.biu);
        listView.setAdapter(myAdapter);
    }
}
