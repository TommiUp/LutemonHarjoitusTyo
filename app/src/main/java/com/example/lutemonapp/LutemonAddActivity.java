package com.example.lutemonapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
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

    // Method for creating a lutemon
    public void createLutemon(View view) {
        switch (rgLutemons.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                type = "White";
                break;
            case R.id.rbGreen:
                type = "Green";
                break;
            case R.id.rbPink:
                type = "Pink";
                break;
            case R.id.rbOrange:
                type = "Orange";
                break;
            case R.id.rbBlack:
                type = "Black";
                break;
        }
        name = txtName.getText().toString();
        Lutemon newLutemon = new Lutemon(name, type);
        HomeArea homeArea = HomeArea.getInstance();
        homeArea.addLutemon(newLutemon);
        homeArea.saveLutemons(this);
        finish();
    }
}