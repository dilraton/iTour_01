package com.example.itour_01;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class userallAvtivity extends AppCompatActivity {

    private FragmentTransaction transaction;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userall);


        TextView biu = findViewById(R.id.biu);
        TextView content = findViewById(R.id.content);

        addFragment1();

        biu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment1();
            }
        });

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                BlankFragment2 blankFragment2 = new BlankFragment2();
                transaction.replace(R.id.fm,blankFragment2);
                transaction.commitAllowingStateLoss();
            }
        });



    }

    private void addFragment1() {
        transaction = getSupportFragmentManager().beginTransaction();
        BlankFragment1 blankFragment1 = new BlankFragment1();
        transaction.replace(R.id.fm,blankFragment1);
        transaction.commitAllowingStateLoss();
    }
}