package com.example.gstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_gst_amount,txt_total_amount;
    EditText txt_amount,txt_gst_percent;
    Button btn_cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_gst_amount = findViewById(R.id.txt_gst_amount);
        txt_total_amount = findViewById(R.id.txt_total_amount);
        txt_amount = findViewById(R.id.txt_amount);
        txt_gst_percent = findViewById(R.id.txt_gst_percent);
        btn_cal = findViewById(R.id.btn_cal);

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float total = Float.parseFloat(txt_amount.getText().toString());
                float gst_percent = Float.parseFloat(txt_gst_percent.getText().toString());

                float gst_amount = Math.round((gst_percent/100)*total);
                txt_gst_amount.setText("GST amount is:" + gst_amount);

                float total_amount = total + gst_amount;
                txt_total_amount.setText("The net total amount:" + total_amount);
            }
        });
    }
}