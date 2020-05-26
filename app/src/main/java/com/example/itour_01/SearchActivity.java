package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView search_back = findViewById(R.id.search_back);

        search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        ImageView search = findViewById(R.id.search);
        EditText content = findViewById(R.id.content);
        TextView history = findViewById(R.id.history);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content1 = content.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("content",content1);
                Intent i = new Intent();
                i.putExtras(bundle);
                i.setClass(SearchActivity.this,search_detail.class);
                startActivity(i);
            }
        });

    }
}
