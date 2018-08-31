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

    ScrollView scrollview;
    TextView index, index_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

//        index_11 = (TextView) findViewById(R.id.index_11);
//        index_11.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 목차 클릭시 해당 내용으로 스크롤 이동
////                scrollview.scrollTo(0, 800);
//                Toast.makeText(getApplicationContext(), "뷰 이동시키자!", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
        scrollview = (ScrollView) findViewById(R.id.scrollview);
        // 이거 왜 안먹히지??
        scrollview.scrollTo(0, 0);
        // 맨 끝까지 스크롤 시키기
        scrollview.fullScroll(ScrollView.FOCUS_DOWN);
        // 수평 스크롤바 사용 가능 설정
        scrollview.setHorizontalScrollBarEnabled(true);

//        // display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        ExpandableListView elv = (ExpandableListView) findViewById(R.id.elv);

        final ArrayList<Position> position = getData();

        //create and bind to adatper
        MyAdapter adapter = new MyAdapter(this, position);
        elv.setAdapter(adapter);

        //set onclick listener
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), position.get(groupPosition).players.get(childPosition), Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }
    //add and get data for list
    private ArrayList<Position> getData() {

        Position p1 = new Position("목차1.1은 무엇");
        p1.players.add("1.1의 내용은1111111111111");

        Position p2 = new Position("목차1.2은 무엇");
        p2.players.add("1.2의 내용은1111111111111");

        Position p3 = new Position("목차1.3은 무엇");
        p3.players.add("1.3의 내용은1111111111111");

        Position p4 = new Position("목차1.4은 무엇");
        p4.players.add("1.4의 내용은1111111111111");

        ArrayList<Position> allposition = new ArrayList<>();
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
