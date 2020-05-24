package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterActivity extends AppCompatActivity {
    String temp=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        RadioGroup sex = findViewById(R.id.sex);
        Button register = findViewById(R.id.register);


        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.male:
                        temp = "男";
                        break;
                    case R.id.fmale:
                        temp = "女";
                        break;

                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread() {
                    public void run() {
                        try {
                            String name1 = name.getText().toString().trim();
                            String phone1 = phone.getText().toString().trim();
                            String email1 = email.getText().toString().trim();
                            String password1 = password.getText().toString().trim();
                            Class.forName("com.mysql.jdbc.Driver");
                            String url = "jdbc:mysql://rm-2zemllxq8jl06818eao.mysql.rds.aliyuncs.com:3306/itour";

                            Connection conn = DriverManager.getConnection(url, "system", "QWer1234");

                            if (conn != null) {
                                Log.d("调试", "成功");
                                String sql = "insert into user values (\""+phone1+"\",\""+password1+"\",\""+temp+"\",\""+email1+"\",\""+name1+"\")";
                                PreparedStatement stmt = conn.prepareStatement(sql);
                                stmt.executeUpdate();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_LONG).show();
                                    }
                                });
                                Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(i);

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
