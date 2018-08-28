package com.example.administrator.appintroduction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DevelopActivity extends AppCompatActivity {

    //
    private MyRecyclerAdapter mAdapter;
    RecyclerView recyclerView;
    List<CardItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_develop);

        //
        RecyclerView recyclerView = ( RecyclerView ) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);

        // 레이아웃 매니저로 LinearLayoutManager를 설정
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // 표시할 임시 데이터
        List<CardItem> dataList = new ArrayList<>();
        // 예시
        // dataList.add(new CardItem("이름", "학력", "이메일", "전화번호"));
        // dataList.add(new CardItem("OOO", "강원대학교 전자공학전공 0학년", "oooooo@oooo.ooo", "000-0000-0000"));
        // 양식 준수
        dataList.add(new CardItem("양지훈", "강원대학교 전자공학전공 4학년", "kms6742@naver.com", "010-5104-7274"));
        dataList.add(new CardItem("뿡뿡이", "강원대학교 전자공학전공 3학년", "abdcdefg123456@daum.net", "010-0000-0000"));

        // 어댑터 설정
        mAdapter = new MyRecyclerAdapter(dataList);
        recyclerView.setAdapter(mAdapter);

        // 구분선
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
