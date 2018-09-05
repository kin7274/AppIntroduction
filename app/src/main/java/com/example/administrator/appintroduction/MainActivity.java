package com.example.administrator.appintroduction;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 메뉴 4개(텍스트뷰로 구현)
    TextView menu1, menu2, menu3, menu4;

    @SuppressLint("ResourceType")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 툴바
        Toolbar mytoolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("");

        menu1 = (TextView) findViewById(R.id.menu1);
        menu2 = (TextView) findViewById(R.id.menu2);
        menu3 = (TextView) findViewById(R.id.menu3);
        menu4 = (TextView) findViewById(R.id.menu4);
        menu1.setOnClickListener((View.OnClickListener) this);
        menu2.setOnClickListener((View.OnClickListener) this);
        menu3.setOnClickListener((View.OnClickListener) this);
        menu4.setOnClickListener((View.OnClickListener) this);
    }

    // 메뉴 4개(텍스트뷰) 클릭 이벤트

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu1:
                // 1번 메뉴 : 당뇨그루에 대해
                // 액티비티 넘겨
//                Toast.makeText(this, "1번 메뉴 클릭", Toast.LENGTH_LONG).show();
                Intent IntroIntent = new Intent(MainActivity.this, IntroActivity.class);
                startActivity(IntroIntent);
                break;
            case R.id.menu2:
                // 2번 메뉴 : 앱버전 정보
                // 커스텀 다이얼로그
//                Toast.makeText(this, "2번 메뉴 클릭", Toast.LENGTH_LONG).show();
                CustomDialog dialog = new CustomDialog(MainActivity.this);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setDialogListener(new MyDialogListener() {
                    @Override
                    public void onPositiveClicked() {
                    }
                });
                dialog.create();
                dialog.show();
                break;
            case R.id.menu3:
                // 3번 메뉴 : 개발자 정보
                // 리사이클러뷰
                // 뷰홀더 형식을 생각하자!
//                Toast.makeText(this, "3번 메뉴 클릭", Toast.LENGTH_LONG).show();
                Intent developer_Intent = new Intent(MainActivity.this, DevelopActivity.class);
                startActivity(developer_Intent);
                break;
            case R.id.menu4:
                // 4번 메뉴 : Change log
                // 변경 내용
                // 액티비티 넘겨
//                Toast.makeText(this, "4번 메뉴 클릭", Toast.LENGTH_LONG).show();
                Intent changeLogIntent = new Intent(MainActivity.this, ChangeLogActivity.class);
                startActivity(changeLogIntent);
                break;
        }
    }
}
