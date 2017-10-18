package com.example.hy17;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;

public class Setting extends AppCompatActivity {
    EditText nameChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        Spinner Main_spinner = (Spinner) findViewById(R.id.spinner);

        //스피너 어댑터 설정
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.item, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Main_spinner.setAdapter(adapter);

        //스피너 이벤트 발생
        Main_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //각 항목 클릭시 포지션값을 토스트에 띄운다.
                Toast showToast = Toast.makeText(getApplicationContext(), Integer.toString(position), Toast.LENGTH_SHORT);
                showToast.show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setTitle("자기소개 및 정보");

        TabHost tabHost = (TabHost) findViewById(R.id.tabhost1);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("1").setContent(R.id.user).setIndicator("USER");

        TabHost.TabSpec tab2 = tabHost.newTabSpec("2").setContent(R.id.info).setIndicator("INFO");

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);




    }

}
