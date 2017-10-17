package com.example.hy17;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import static android.R.attr.start;

public class Movidate extends AppCompatActivity {
    Button start;
    Button complete;
    Chronometer chrometer;
    RadioButton calander;
    RadioButton picker;
    CalendarView viewcal;
    TimePicker viewpick;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movidate);

        start = (Button)findViewById(R.id.start);
        complete = (Button)findViewById(R.id.complete);
        chrometer = (Chronometer)findViewById(R.id.chronometer1);
        calander = (RadioButton)findViewById(R.id.calender);
        picker = (RadioButton)findViewById(R.id.picker);
        viewcal = (CalendarView)findViewById(R.id.calendarView1);
        viewpick = (TimePicker)findViewById(R.id.timePicker1);
        txt = (TextView)findViewById(R.id.result);
        calander.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){viewcal.setVisibility(android.view.View.VISIBLE);
                    viewpick.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });
        picker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    viewcal.setVisibility(android.view.View.INVISIBLE);
                    viewpick.setVisibility(android.view.View.VISIBLE);
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrometer.setBase(SystemClock.elapsedRealtime());
                chrometer.start();
                chrometer.setTextColor(Color.RED);
            }
        });
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrometer.stop();
                chrometer.setTextColor(Color.RED);
                java.util.Date curDate = new
                        java.util.Date(viewcal.getDate());
                txt.setText(Integer.toString(1900 + curDate.getYear())
                        + "년" +
                        Integer.toString(1 +
                                curDate.getMonth()) + "월" +
                        Integer.toString(curDate.getDate()) + "일" +
                        Integer.toString(viewpick.getCurrentHour()) + "시" +
                        Integer.toString(viewpick.getCurrentMinute()) + "분" + " 예약함");
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
