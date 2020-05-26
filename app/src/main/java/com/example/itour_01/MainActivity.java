package com.example.itour_01;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    ViewPager viewPager;
    BottomNavigationView navigation;
    List<Fragment> listFragment;
    private String phone,content = "0";
    String name;
    Main_fragment2 main_fragment2 = new Main_fragment2();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = getIntent().getStringExtra("phone");
        Log.d("phone",phone);


        new Thread() {
            public void run() {
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://rm-2zemllxq8jl06818eao.mysql.rds.aliyuncs.com:3306/itour";

                    Connection conn = DriverManager.getConnection(url, "system", "QWer1234");

                    if (conn != null) {
                        Log.d("调试", "成功");
                        Statement stmt = conn.createStatement();
                        String sql = "select * from user where phone = \""+phone+"\"";
                        ResultSet rs = stmt.executeQuery(sql);
                        if(rs.next()){
                            name = rs.getString(5);
                            Log.d("name",name);

                        }
                        else{
                            Log.d("查找","失败");
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


        initView();

    }
    public String getName(){
        return name;
    }
    public String getContent(){
        return content;
    }
    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        navigation = (BottomNavigationView) findViewById(R.id.nav_view);

        //向ViewPager添加各页面
        listFragment = new ArrayList<>();
        listFragment.add(new Main_fragment1());
        listFragment.add(new Main_fragment2());
        listFragment.add(new Main_fragment3());

        MyFragAdapter myAdapter = new MyFragAdapter(getSupportFragmentManager(), this, listFragment);
        viewPager.setAdapter(myAdapter);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //这里设置为：当点击到某子项，ViewPager就滑动到对应位置
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.create:
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("content",content);
                        main_fragment2.setArguments(bundle1);
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.me:
                        viewPager.setCurrentItem(2);

                        return true;

                    default:
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //注意这个方法滑动时会调用多次，下面是参数解释：
                //position当前所处页面索引,滑动调用的最后一次绝对是滑动停止所在页面
                //positionOffset:表示从位置的页面偏移的[0,1]的值。
                //positionOffsetPixels:以像素为单位的值，表示与位置的偏移
            }

            @Override
            public void onPageSelected(int position) {
                //该方法只在滑动停止时调用，position滑动停止所在页面位置
//                当滑动到某一位置，导航栏对应位置被按下
                navigation.getMenu().getItem(position).setChecked(true);
                //这里使用navigation.setSelectedItemId(position);无效，
                //setSelectedItemId(position)的官网原句：Set the selected
                // menu item ID. This behaves the same as tapping on an item
                //未找到原因
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//这个方法在滑动是调用三次，分别对应下面三种状态
// 这个方法对于发现用户何时开始拖动，
// 何时寻呼机自动调整到当前页面，或何时完全停止/空闲非常有用。
//                state表示新的滑动状态，有三个值：
//                SCROLL_STATE_IDLE：开始滑动（空闲状态->滑动），实际值为0
//                SCROLL_STATE_DRAGGING：正在被拖动，实际值为1
//                SCROLL_STATE_SETTLING：拖动结束,实际值为2
            }
        });


    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        Log.d("进入","result");
        if(data == null){
            Log.d("返回","null");
            return;
        }
        else{
            Log.d("获取到","data");
            switch (resultCode){
                case 1111:
                    Bundle bundle = data.getExtras();
                    content = bundle.getString("content");


                    break;
                default:
                    break;
            }
        }

    }


}
