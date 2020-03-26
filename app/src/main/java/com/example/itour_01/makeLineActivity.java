package com.example.itour_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class makeLineActivity extends AppCompatActivity {
    private String content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);

        ImageView back = findViewById(R.id.back);
        ImageView sure = findViewById(R.id.sure);
        EditText lineContent = findViewById(R.id.linecontent);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(makeLineActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        if(lineContent != null){
            content = lineContent.getText().toString();
            Log.d("content",content);
            sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent data = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("name",content);
                    data.putExtras(bundle);
                    setResult(2,data);
                    finish();

                }
            });
        }
    }
}
