package com.example.itour_01;

import java.io.Serializable;

public class line implements Serializable {
    private String content;

    public line(String content){
        this.content = content;

    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
