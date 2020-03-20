package com.example.itour_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class attention extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);

        LinearLayout more = findViewById(R.id.moreattention);
        ImageView attention_back = findViewById(R.id.attention_back);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(attention.this,attention_moreActivity.class);
                startActivity(i);
            }
        });

        attention_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(attention.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
