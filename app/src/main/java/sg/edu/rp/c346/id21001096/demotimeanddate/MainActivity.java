package sg.edu.rp.c346.id21001096.demotimeanddate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    Button btnReset;
    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        btnDisplayDate = findViewById(R.id.btnDisplayDate);
        btnDisplayTime = findViewById(R.id.btnDisplayTime);
        tvDisplay = findViewById(R.id.tvDisplay);
        btnReset = findViewById(R.id.btnReset);
        tp.setIs24HourView(true);


        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "Time is ";
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();

                if (min < 10) {
                    text = text + hour + ":0" + min;
                } else {
                    text = text + hour + ":" + min;
                }

                tvDisplay.setText(text);


            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "Date is ";
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();
                text = text + day + "/" + month + "/" + year;
                tvDisplay.setText(text);


            }

        });

        btnReset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v==btnReset) {
                    tp.setCurrentMinute(00);
                    tp.setCurrentHour(12);
                    dp.updateDate(2020,00,01);
                }
            }
        });


    }}
