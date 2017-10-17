package com.example.hy17;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView name;
    int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




//     프래그먼트 작성
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentActivity1 fragment=new FragmentActivity1();

        fragmentTransaction.add(R.id.container, fragment); //메인과 프레그먼트를연결
        fragmentTransaction.commit(); // 프래그먼트 실행

    }

    public void onChangeFragment(View v) {
        Fragment fragment;

        switch (flag) {
            default:
            case 0: {
                fragment = new FragmentActivity1(); //붉은 화면
                flag = 1;
                break;

            }
            case 1: {
                fragment = new FragmentActivity2(); // 파란색 화면
                flag = 0;
                break;
            }
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();


    }

    public void movie(View v){
        // 인텐트 작성
        Intent movie = new Intent(MainActivity.this, Movidate.class);
        startActivity(movie);
    }


    public void community(View v){
        // 인텐트 작성
        Intent community = new Intent(MainActivity.this, Community.class);
        startActivity(community);
    }

    public void setting(View v){
        // 인텐트 작성
        Intent community = new Intent(MainActivity.this, Setting.class);
        startActivity(community);
    }

}
