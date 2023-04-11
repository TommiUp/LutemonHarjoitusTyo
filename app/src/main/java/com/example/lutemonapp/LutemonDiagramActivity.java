package com.example.lutemonapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;



public class LutemonDiagramActivity extends AppCompatActivity {

    private LutemonStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_diagram);
        storage = LutemonStorage.getInstance();
        AnyChartView anyChartView = findViewById(R.id.chart_lutemon_stat);
        AnyChartView anyChartView2 = findViewById(R.id.chart_lutemon_stat2);

        Pie pie = AnyChart.pie();
        Pie pie2 = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();
        List<DataEntry> data2 = new ArrayList<>();

        for (Lutemon lutemon : storage.getLutemons("all")){
            data.add(new ValueDataEntry(lutemon.getName(), lutemon.getWins()));
            data2.add(new ValueDataEntry(lutemon.getName(), lutemon.getLost()));
        }

        pie.data(data);
        pie2.data(data2);

        anyChartView.setChart(pie);
        anyChartView2.setChart(pie2);
    }
}