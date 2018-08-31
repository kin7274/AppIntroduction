package com.example.administrator.appintroduction;

import android.content.Context;
import android.os.Bundle;
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
    TextView index, index_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        scrollview = (ScrollView) findViewById(R.id.scrollview);
        // 이거 왜 안먹히지??
        scrollview.scrollTo(0, 0);
        // 맨 끝까지 스크롤 시키기
        scrollview.fullScroll(ScrollView.FOCUS_DOWN);
        // 수평 스크롤바 사용 가능 설정
        scrollview.setHorizontalScrollBarEnabled(true);

        ExpandableListView elv = (ExpandableListView) findViewById(R.id.elv);

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

        Index p1 = new Index("목차1.1은 무엇");
        p1.contents.add("1.1의 내용은1111111111111");

        Index p2 = new Index("목차1.2은 무엇");
        p2.contents.add("1.2의 내용은1111111111111");

        Index p3 = new Index("목차1.3은 무엇");
        p3.contents.add("1.3의 내용은1111111111111");

        Index p4 = new Index("목차1.4은 무엇");
        p4.contents.add("1.4의 내용은1111111111111");

        ArrayList<Index> allposition = new ArrayList<>();
        allposition.add(p1);
        allposition.add(p2);
        allposition.add(p3);
        allposition.add(p4);
        return allposition;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
