package com.example.proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RowItem {
    private String name;

    public RowItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
