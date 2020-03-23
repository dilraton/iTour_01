
package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class LoginActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText phone = findViewById(R.id.phone);
        EditText password = findViewById(R.id.password);

        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.register);

        String phone1 = phone.getText().toString();
        String password1 = password.getText().toString();
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
                            Class.forName("com.mysql.jdbc.Driver");
                            String url = "jdbc:mysql://rm-bp15eh5r5hsl844604o.mysql.rds.aliyuncs.com:3306/itour";

                            Connection conn = DriverManager.getConnection(url, "itour_01", "QWer1234");

                            if (conn != null) {
                                Log.d("调试", "成功");
                                Statement stmt = conn.createStatement();
                                String sql = "select * from user where phone = '\"+phone1+\"' and password = '\"+password1+\"'";
                                ResultSet rs = stmt.executeQuery(sql);
                                if(rs.next()){
                                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
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