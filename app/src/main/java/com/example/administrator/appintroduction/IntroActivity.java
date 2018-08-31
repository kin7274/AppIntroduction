package com.example.administrator.appintroduction;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class IntroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // TODO 확장형 리스트뷰 : 변수 이름 변경, 사이즈 조절, 내용 추가
    // TODO 스크롤뷰 : 처음 열면 맨 위로 올라오도록!

    ScrollView scrollview;
    TextView index_no1, index_no2_1, index_no2_2, index_no2_3, index_no2_4, index_no3, index_no4, index_no5;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        scrollview = ( ScrollView ) findViewById(R.id.scrollview);
        // 이거 왜 안먹히지??
        scrollview.scrollTo(0, 0);
        // 맨 끝까지 스크롤 시키기
        scrollview.fullScroll(ScrollView.FOCUS_DOWN);
        // 수평 스크롤바 사용 가능 설정
        // 안넣어도
        scrollview.setHorizontalScrollBarEnabled(true);
//        scrollview.setNestedScrollingEnabled(false);

        index_no1 = ( TextView ) findViewById(R.id.index_no1);
        index_no2_1 = ( TextView ) findViewById(R.id.index_no2_1);
        index_no2_2 = ( TextView ) findViewById(R.id.index_no2_2);
        index_no2_3 = ( TextView ) findViewById(R.id.index_no2_3);
        index_no2_4 = ( TextView ) findViewById(R.id.index_no2_4);
        index_no3 = ( TextView ) findViewById(R.id.index_no3);
        index_no4 = ( TextView ) findViewById(R.id.index_no4);
        index_no5 = ( TextView ) findViewById(R.id.index_no5);
/*
        index_no1.setOnClickListener(( View.OnClickListener ) this);
        index_no2_1.setOnClickListener(( View.OnClickListener ) this);
        index_no2_2.setOnClickListener(( View.OnClickListener ) this);
        index_no2_3.setOnClickListener(( View.OnClickListener ) this);
        index_no2_4.setOnClickListener(( View.OnClickListener ) this);
        index_no3.setOnClickListener(( View.OnClickListener ) this);
        index_no4.setOnClickListener(( View.OnClickListener ) this);
        index_no5.setOnClickListener(( View.OnClickListener ) this);

        View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.index_no1:

                        break;
                    case R.id.index_no2_1:
                        break;
                    case R.id.index_no2_2:
                        break;
                    case R.id.index_no2_3:
                        break;
                    case R.id.index_no2_4:
                        break;
                    case R.id.index_no3:
                        break;
                    case R.id.index_no4:
                        break;
                    case R.id.index_no5:
                        break;
                }
            }
        };
        */
        ExpandableListView elv = ( ExpandableListView ) findViewById(R.id.elv);

        final ArrayList<Index> index = getData();

        //create and bind to adatper
        MyAdapter adapter = new MyAdapter(this, index);
        elv.setAdapter(adapter);

        //set onclick listener
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), index.get(groupPosition).contents.get(childPosition), Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    //add and get data for list
    private ArrayList<Index> getData() {

        Index p1 = new Index("1. 당뇨그루에 관해");
        p1.contents.add(getResources().getString(R.string.Intro_content));

        Index p2 = new Index("2-1. 식이요법관리");
        p2.contents.add("띠용");

        Index p3 = new Index("2-2. 운동관리");
        p3.contents.add("띠용");

        Index p4 = new Index("2-3. 투약");
        p4.contents.add("띠용");

        Index p5 = new Index("2-4. 신체활동");
        p5.contents.add("띠용");

        Index p6 = new Index("3. 기대효과");
        p6.contents.add("띠용");

        Index p7 = new Index("4. 개발방향");
        p7.contents.add("띠용");

        Index p8 = new Index("5. 도움주신분");
        p8.contents.add("띠용");

        ArrayList<Index> allposition = new ArrayList<>();
        allposition.add(p1);
        allposition.add(p2);
        allposition.add(p3);
        allposition.add(p4);
        allposition.add(p5);
        allposition.add(p6);
        allposition.add(p7);
        allposition.add(p8);
        return allposition;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
