package com.example.lutemonapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class LutemonStatisticsActivity extends AppCompatActivity {

    private LutemonStorage storage;

    private RecyclerView recyclerView;

    private LutemonStatisticsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_statistics);
        storage = LutemonStorage.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonStatisticsAdapter(getApplicationContext(), storage.getLutemons("all"));
        recyclerView.setAdapter(adapter);
        AnyChartView anyChartView = findViewById(R.id.chart_lutemon_stat);

        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();
        for (Lutemon lutemon : storage.getLutemons("all")) {
            data.add(new ValueDataEntry(lutemon.getName(), lutemon.getWins()));
        }
        pie.data(data);

        anyChartView.setChart(pie);
    }
}