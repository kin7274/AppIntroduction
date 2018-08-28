package com.example.administrator.appintroduction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView menu1, menu2, menu3, menu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 툴바
        Toolbar mytoolbar = ( Toolbar ) findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("");

        menu1 = (TextView) findViewById(R.id.menu1);
        menu2 = (TextView) findViewById(R.id.menu2);
        menu3 = (TextView) findViewById(R.id.menu3);
        menu4 = (TextView) findViewById(R.id.menu4);
        menu1.setOnClickListener(this);
        menu2.setOnClickListener(this);
        menu3.setOnClickListener(this);
        menu4.setOnClickListener(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.menu1:
                // 1번 메뉴 : 당뇨그루에 대해
                Toast.makeText(this, "1번 메뉴 클릭", Toast.LENGTH_LONG).show();

                break;
            case R.id.menu2:
                // 2번 메뉴 : 앱버전 정보
                Toast.makeText(this, "2번 메뉴 클릭", Toast.LENGTH_LONG).show();

                break;
            case R.id.menu3:
                // 3번 메뉴 : 개발자 정보
                Toast.makeText(this, "3번 메뉴 클릭", Toast.LENGTH_LONG).show();

                break;
            case R.id.menu4:
                // 4번 메뉴 : Change log
                Toast.makeText(this, "4번 메뉴 클릭", Toast.LENGTH_LONG).show();

                break;
        }
    }
}
