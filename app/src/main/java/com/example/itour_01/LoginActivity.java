
package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import com.example.itour_01.Main_fragment3;

public class LoginActivity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText phone = findViewById(R.id.phone);
        EditText password = findViewById(R.id.password);

        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread() {
                    public void run() {
                        try {
                            String phone1 = phone.getText().toString().trim();
                            String password1 = password.getText().toString().trim();
                            Class.forName("com.mysql.jdbc.Driver");
                            String url = "jdbc:mysql://rm-2zemllxq8jl06818eao.mysql.rds.aliyuncs.com:3306/itour";

                            Connection conn = DriverManager.getConnection(url, "system", "QWer1234");

                            if (conn != null) {
                                Log.d("调试", "成功");
                                Statement stmt = conn.createStatement();
                                String sql = "select * from user where phone = \""+phone1+"\" and password = \""+password1+"\"";
                                ResultSet rs = stmt.executeQuery(sql);
                                if(rs.next()){
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
                                        }
                                    });
                                    Intent data = new Intent(LoginActivity.this,MainActivity.class);
                                    data.putExtra("phone",phone1);
                                    startActivity(data);

                                }
                                else{
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_LONG).show();
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
        });


    }


}