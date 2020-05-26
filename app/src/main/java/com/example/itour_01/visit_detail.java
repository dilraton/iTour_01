package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class visit_detail extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_detail);

        Bundle bundle = getIntent().getExtras();
        String sname = bundle.getString("sname");
        int photo = bundle.getInt("photo");
        Log.d("sname",sname);

        TextView back = findViewById(R.id.more_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(visit_detail.this,topfoodActiviy.class);
                startActivity(i);
            }
        });

        ImageView photo1 = findViewById(R.id.photo);
        photo1.setImageResource(photo);

        TextView sno = findViewById(R.id.sno);
        TextView sname1 = findViewById(R.id.sname);
        TextView saddress = findViewById(R.id.saddress);
        TextView scontent = findViewById(R.id.scontent);

        sname1.setText(sname);

        new Thread() {
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://rm-2zemllxq8jl06818eao.mysql.rds.aliyuncs.com:3306/itour";

                    Connection conn = DriverManager.getConnection(url, "system", "QWer1234");

                    if (conn != null) {
                        Log.d("调试", "成功");
                        Statement stmt = conn.createStatement();
                        String sql = "select sno,saddress,sdetail from scenery where sname = \""+sname+"\"";
                        ResultSet rs = stmt.executeQuery(sql);
                        if(rs.next()){
                            String sno1 = rs.getString(1);
                            String saddress1 = rs.getString(2);
                            String scontent1 = rs.getString(3);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d("数据","okkkk");
                                    sno.setText(sno1);
                                    saddress.setText(saddress1);
                                    scontent.setText(scontent1);
                                }
                            });


                        }
                        else{
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"数据不存在",Toast.LENGTH_LONG).show();
                                }
                            });
                        }


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
    }
}
