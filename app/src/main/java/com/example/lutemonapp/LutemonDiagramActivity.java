// Lutemon App, LutemonDiagramActivity
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// Diagram activity for the visualized statistics, shows a pie diagram from victories
// Android Studio
// Last Updated 26.4.2023

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
    private ArrayList<Lutemon> listOfLutemons = new ArrayList<>();
    private List<DataEntry> data;
    private Pie pie;
    private AnyChartView anyChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_diagram);
        listOfLutemons.addAll(HomeArea.getInstance().getLutemons());
        listOfLutemons.addAll(BattleArea.getInstance().getLutemons());
        listOfLutemons.addAll(TrainingArea.getInstance().getLutemons());
        anyChartView = findViewById(R.id.chart_lutemon_stat);
        data = new ArrayList<>();
        pie = AnyChart.pie();
        for (Lutemon lutemon : listOfLutemons){
            data.add(new ValueDataEntry(lutemon.getName(), lutemon.getWins()));
        }
        pie.data(data);
        anyChartView.setChart(pie);
    }
}