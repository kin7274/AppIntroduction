package com.example.administrator.appintroduction;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity{

    ScrollView scrollview;
    TextView index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        scrollview = (ScrollView) findViewById(R.id.scrollview);
        scrollview.scrollTo(0, 0);
        // 맨 끝까지 스크롤 시키기
        scrollview.fullScroll(ScrollView.FOCUS_DOWN);
        // 수평 스크롤바 사용 가능 설정
        scrollview.setHorizontalScrollBarEnabled(true);
//        display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

//        scrollview.scrollTo(display.getWidth(), 0);

        index = (TextView) findViewById(R.id.index);
        index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 목차 클릭시 해당 내용으로 스크롤 이동
                scrollview.scrollTo(0, 800);
            }
        });
    }
}
