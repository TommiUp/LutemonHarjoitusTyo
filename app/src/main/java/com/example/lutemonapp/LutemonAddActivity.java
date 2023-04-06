package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LutemonAddActivity extends AppCompatActivity {

    private RadioGroup rgLutemons;
    private RadioButton rbWhite, rbGreen, rbPink, rbOrange, rbBlack;
    private String type, name;
    private EditText txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_add);
        rgLutemons = findViewById(R.id.rgLutemons);
        rbWhite = findViewById(R.id.rbWhite);
        rbGreen = findViewById(R.id.rbGreen);
        rbPink = findViewById(R.id.rbPink);
        rbOrange = findViewById(R.id.rbOrange);
        rbBlack = findViewById(R.id.rbBlack);
        txtName = findViewById(R.id.txtLutemonName);
    }

    public void createLutemon() {
        switch (rgLutemons.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                type = rbWhite.getText().toString();
                break;
            case R.id.rbGreen:
                type = rbGreen.getText().toString();
                break;
            case R.id.rbPink:
                type = rbPink.getText().toString();
                break;
            case R.id.rbOrange:
                type = rbOrange.getText().toString();
                break;
            case R.id.rbBlack:
                type = rbBlack.getText().toString();
                break;
        }
        name = txtName.getText().toString();
        Lutemon newLutemon = new Lutemon(type, name);
        LutemonStorage.getInstance().addLutemon(newLutemon);
        LutemonStorage.getInstance().saveLutemons(this);
        finish();
    }
}