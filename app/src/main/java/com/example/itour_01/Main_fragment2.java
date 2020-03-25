package com.example.itour_01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.LinkedList;
import java.util.List;

public class Main_fragment2 extends Fragment {
    private String content;
    private TextView linecontent;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_line, container, false);

        linecontent = view.findViewById(R.id.linecontent);
        TextView go = view.findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(getActivity(),makeLineActivity.class);
                startActivity(data);

            }
        });
        MainActivity mainActivity = (MainActivity) getActivity();
        if(mainActivity.getContent() != null){
            content = mainActivity.getContent();
            linecontent.setText(content);
            go.setText("再次添加路线");
        }



        return view;
    }


}
