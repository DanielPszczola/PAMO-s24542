package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import java.util.ArrayList;
import java.util.List;

public class BmiChartActivity extends AppCompatActivity {

    private LineChart bmiChart;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_chart);

        bmiChart = findViewById(R.id.bmiChart);
        backButton = findViewById(R.id.backButton);

        List<Entry> bmiEntries = new ArrayList<>();
        bmiEntries.add(new Entry(1, 22.5f));
        bmiEntries.add(new Entry(2, 23.0f));
        bmiEntries.add(new Entry(3, 22.7f));
        bmiEntries.add(new Entry(4, 23.4f));
        bmiEntries.add(new Entry(5, 24.0f));
        bmiEntries.add(new Entry(6, 23.6f));

        LineDataSet dataSet = new LineDataSet(bmiEntries, "BMI w czasie");
        dataSet.setLineWidth(2f);
        dataSet.setCircleRadius(4f);
        dataSet.setValueTextSize(12f);

        LineData lineData = new LineData(dataSet);
        bmiChart.setData(lineData);

        XAxis xAxis = bmiChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(bmiEntries.size());

        YAxis leftAxis = bmiChart.getAxisLeft();
        YAxis rightAxis = bmiChart.getAxisRight();
        rightAxis.setEnabled(false);

        bmiChart.getDescription().setEnabled(false);
        bmiChart.invalidate();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}